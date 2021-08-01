/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dto.AgendaDTO;
import dto.CompaniaDTO;
import dto.EspecialidadDTO;
import dto.MecanicoDTO;
import dto.TitularDTO;
import dto.TurnoDTO;
import dto.VehiculoDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTable;
import modelo.Agenda;
import modelo.Compania;
import modelo.Especialidad;
import modelo.Mecanico;
import modelo.Modelo;
import modelo.Titular;
import modelo.Turno;
import modelo.Vehiculo;
import vista.FrmFichaMecanica;
import vista.InterfazTurno;
import vista.vistaHome;
import vista.FrmNuevoTurno;
import vista.FrmNuevoTItular;
import vista.FrmNuevoVehiculo;
import vista.vistaConfirmarTurno;

/**
 *
 * @author francisco
 */
public class EncRecepcionControlador extends Controlador implements ItemListener, DocumentListener{
    
    public EncRecepcionControlador(InterfazTurno vista, Modelo modelo) {
        VISTA = vista;
        MODELO = modelo;
        VISTA.setControlador(this, this, this);
        VISTA.iniciaVista();
        
        cargarAgendasYTurnos(((vistaHome) this.VISTA));
    }
    
    private void cargarAgendasYTurnos(vistaHome vista){
        // INSERTAMOS TODOS LOS TURNOS DISPONIBLES POR UNICA VEZ
        List<MecanicoDTO> listadoMecanicos = ((Mecanico) this.MODELO.fabricarModelo("Mecanico")).listarMecanicos();
        ((Turno) this.MODELO.fabricarModelo("Turno")).insertarTurno(listadoMecanicos);
        ((Agenda) this.MODELO.fabricarModelo("Agenda")).insertarAgendas(listadoMecanicos);
        this.actualizarTabla(vista);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {

            switch (InterfazTurno.Operacion.valueOf(e.getActionCommand())) {
                case CONSULTAR:
                    actualizarTabla(((vistaHome) this.VISTA));
                    break;

                case TURNO:
                    irFrmNuevoTurno();
                    break;
                    
                case NUEVO_TURNO:
                    insertarTurno(((FrmNuevoTurno) this.VISTA));
                    break;
                    
                case VOLVER_HOME:
                    volverHome();
                    break;
                    
                case VOLVER_NUEVO_TURNO:
                    volverNuevoTurno();
                    break;
                    
                case TITULAR:
                    irFrmNuevoTitular();
                    break;
                    
                case NUEVO_TITULAR:
                    insertarTitular(((FrmNuevoTItular) this.VISTA));
                    break;
  
                case FILTRAR_TABLA:
                    filtrarTabla(((vistaHome) this.VISTA));
                    break;
                    
                case VEHICULO:
                    irFrmNuevoVehiculo();
                    break;
                    
                case NUEVO_VEHICULO:
                    insertarVehiculo((FrmNuevoVehiculo) this.VISTA);
                    break;
                    
                case CONSULTAR_TURNO:
                    System.out.println("CONSULTAR TURNO");
                    irVistaConfirmarTurno();
                    break;
                    
                case CONFIRMAR_TURNO:
                    System.out.println("CONFIRMAR TURNO");
                    break;
                    
                case CANCELAR_TURNO:
                    System.out.println("CANCELAR TURNO");
                    break;
                    
                case CONSULTAR_FICHA:
                    System.out.println("CONSULTAR FICHA");
                    irVistaConsultarFicha();
                    break;
                    
                case REGISTRAR_FICHA:
                    System.out.println("REGISTRAR FICHA");
                    irFrmRegistrarFicha();
                    break;
                    
                case NO_ASIGNADO:
                   showMessageDialog(null, "Aún no hay una ficha disponible!");
                    break;
                    
                case CANCELADO:
                   showMessageDialog(null, "No hay ficha para este turno cancelado!");
                   break;
                    
                case CONFIRMAR_FICHA:
                    confirmarFicha();
                    break;
                     
                case FINALIZADO:
                    irFrmRegistrarFichaConfirmada();
                    break;
                     
                default:
                    System.out.println("DEFAULT");
                    break;
            }
        } catch (RuntimeException ex) {
            System.out.println("CATCH: " + ex.getMessage());
        }
    }
    
    // METODO ENCARGADO DE ACTUALIZAR LA TABLA DE LA VISTA HOME, Y TRAER TODOS LOS TURNOS (ASIGNADOS, NO ASIGNADOS, CANCELADOS, ASISTIDOS)

    private void actualizarTabla(vistaHome vista) {
        VISTA.limpiaVista();
        
        DefaultTableModel modeloTabla = (DefaultTableModel) vista.getModeloTblTurnos();
        modeloTabla.setRowCount(0);
        modeloTabla.fireTableDataChanged();
        List<TurnoDTO> listadoTurnos = ((Turno) this.MODELO).listarTurno();
        for (TurnoDTO tur : listadoTurnos) {
            modeloTabla.addRow(new Object[]{tur.getNroTurno(),
                                            tur.getAnoMes(),
                                            tur.getDia(), 
                                            tur.getHora(),
                                            tur.getLegajoMecanico(),
                                            tur.getNroPoliza(),
                                            tur.getNroTitular(),
                                            tur.getCuitCompania(),
                                            tur.getEstado(),
                                            tur.getNroFicha()});
        }
    }
    
    // METODO ENCARGADO DE ACTUALIZAR LA TABLA DE LA VISTA HOME, Y TRAER LOS TURNOS SEGUN FILTRADO

    private void actualizarTablaFiltrado(vistaHome vista, String Estado) {
        VISTA.limpiaVista();
        
        DefaultTableModel modeloTabla = (DefaultTableModel) vista.getModeloTblTurnos();
        modeloTabla.setRowCount(0);
        modeloTabla.fireTableDataChanged();
        List<TurnoDTO> listadoTurnos = ((Turno) this.MODELO).listarTurnosPorCriterio(Estado);
        for (TurnoDTO tur : listadoTurnos) {
            modeloTabla.addRow(new Object[]{tur.getNroTurno(),
                                            tur.getAnoMes(),
                                            tur.getDia(), 
                                            tur.getHora(),
                                            tur.getLegajoMecanico(),
                                            tur.getNroPoliza(),
                                            tur.getNroTitular(),
                                            tur.getCuitCompania(),
                                            tur.getEstado(),
                                            tur.getNroFicha()});
        }
        
        vista.setColumnaBoton(new ButtonColumn(vista.getTablaTurnos(), 9), this);
    }
    
    // METODOS DE DESPLAZAMIENTO ENTRE VISTAS. VOLVER, IR A UNA VISTA. PUEDEN LLAMAR O NO A LOS METODOS DE INICIAR VISTAS CON CARGA DE DATOS A COMBOBOX
      
    private void volverHome() {
        MODELO = ((Turno)this.MODELO.fabricarModelo("Turno"));
        VISTA.cerrarVista();
        VISTA = new vistaHome();
        VISTA.iniciaVista();
        VISTA.setControlador(this, this, this);
        this.actualizarTabla(((vistaHome) this.VISTA));
    }
    
    private void volverNuevoTurno(){
        MODELO = ((Turno)this.MODELO.fabricarModelo("Turno"));
        VISTA.cerrarVista();
        VISTA = new FrmNuevoTurno();
        VISTA.iniciaVista();
        VISTA.setControlador(this, this, this);
        
        this.iniciarFrmNuevoTurno();
    }
    
    private void irFrmNuevoTurno() {
        VISTA.cerrarVista();
        VISTA = new FrmNuevoTurno();
        VISTA.iniciaVista();
        VISTA.setControlador(this, this, this);

        this.iniciarFrmNuevoTurno();
    }
    
    private void irFrmNuevoTitular(){
        VISTA.cerrarVista();
        VISTA = new FrmNuevoTItular();
        VISTA.iniciaVista();
        VISTA.setControlador(this, this, this);
        ((FrmNuevoTItular) VISTA).getBotonGuardar().setEnabled(false);
    }
    
    private void irFrmNuevoVehiculo(){
        VISTA.cerrarVista();
        VISTA = new FrmNuevoVehiculo();
        VISTA.iniciaVista();
        VISTA.setControlador(this, this, this);
        
        this.iniciarFrmNuevoVehiculo();
    }
    
    // METODOS QUE INICIAN LAS VISTAS COMPLETANDO SUS COMBO BOX CON LA INFORMACION DE LA BASE
    
    private void iniciarFrmNuevoTurno() {
        
        // CARGAMOS LAS ESPECIALIDADES
        JComboBox modeloComboBoxEspecialidades = (JComboBox) ((FrmNuevoTurno) this.VISTA).getComboBoxEspecialidad();
        List<EspecialidadDTO> listadoEspecialidades = ((Especialidad) this.MODELO.fabricarModelo("Especialidad")).listarEspecialidades();
        // Agregamos una especialidad vacia para que quede seleccionada por defecto
        modeloComboBoxEspecialidades.addItem("-");
        for (EspecialidadDTO especialidad : listadoEspecialidades) {
            modeloComboBoxEspecialidades.addItem(especialidad.getNombre()); 
        }

        // CARGAMOS LOS TITULARES
        JComboBox modeloComboBoxTitulares = (JComboBox) ((FrmNuevoTurno) this.VISTA).getComboBoxTitular();
        List<TitularDTO> listadoTitulares = ((Titular) this.MODELO.fabricarModelo("Titular")).listarTitulares();
        // Agregamos un titular vacio para que quede seleccionado por defecto
        modeloComboBoxTitulares.addItem("-");
        for (TitularDTO titular : listadoTitulares) {
            modeloComboBoxTitulares.addItem(titular.getNombre() + " " + titular.getApellido() + " - DNI: " + titular.getNroDNI()); 
        }
        
        // EL BOTON GUARDAR SE INICIA DESHABILITADO HASTA QUE SE CARGUEN TODOS LOS DATOS
        ((FrmNuevoTurno) VISTA).getBotonGuardar().setEnabled(false);
    }
    
    private void iniciarFrmNuevoVehiculo() {
        
        // CARGAMOS LAS COMPANIAS
        JComboBox modeloComboBoxCompanias = (JComboBox) ((FrmNuevoVehiculo) this.VISTA).getComboBoxCompanias();
        List<CompaniaDTO> listadoCompanias = ((Compania) this.MODELO.fabricarModelo("Compania")).listarCompanias();
        // Agregamos una especialidad vacia para que quede seleccionada por defecto
        modeloComboBoxCompanias.addItem("-");
        for (CompaniaDTO compania : listadoCompanias) {
            modeloComboBoxCompanias.addItem("Cuit: " + compania.getCuit() + " - Razon Social: " + compania.getRazonSocial()); 
        }

        // CARGAMOS LOS TITULARES
        JComboBox modeloComboBoxTitulares = (JComboBox) ((FrmNuevoVehiculo) this.VISTA).getComboBoxTitulares();
        List<TitularDTO> listadoTitulares = ((Titular) this.MODELO.fabricarModelo("Titular")).listarTitulares();
        // Agregamos un titular vacio para que quede seleccionado por defecto
        modeloComboBoxTitulares.addItem("-");
        for (TitularDTO titular : listadoTitulares) {
            modeloComboBoxTitulares.addItem("Nro Titular: " + titular.getNroTitular() + " - DNI: " + titular.getNroDNI()); 
        } 
    }
    
    private void iniciarVistaConfirmarTurno( int nroTurno, String anoMes, String dia, String hora, String mecanico, String vehiculo, String titular ) {
        ((vistaConfirmarTurno) VISTA).getTextEditNroTurno().setText(Integer.toString(nroTurno));
        ((vistaConfirmarTurno) VISTA).getTextEditAnoMes().setText(anoMes);
        ((vistaConfirmarTurno) VISTA).getTextEditTitular().setText(titular);
        ((vistaConfirmarTurno) VISTA).getTextEditVehiculo().setText(vehiculo);
        ((vistaConfirmarTurno) VISTA).getTextEditMecanico().setText(mecanico);
        ((vistaConfirmarTurno) VISTA).getTextEditFechaHora().setText(dia + "-" + hora);
    }
    
    // METODOS DE OBTENCION DE DATOS DE DISTINTOS DTOS
    
    private TitularDTO obtenerDatosTitular(FrmNuevoTurno vista){
        // divido el item selected en partes separadas por espacio y los almaceno en un array de String
        String[] partesDelTitular = vista.getComboBoxTitular().getSelectedItem().toString().split("[ X]");
        TitularDTO titular = ((Titular) this.MODELO.fabricarModelo("Titular"))
                            .buscarTitular(partesDelTitular[1], partesDelTitular[0]);
        return titular;
       
    }
    
    private MecanicoDTO obtenerDatosMecanico(FrmNuevoTurno vista){
        String[] partesDelMecanico = vista.getComboBoxMecanicos().getSelectedItem().toString().split("[ X]");
        MecanicoDTO mecanico = ((Mecanico) this.MODELO.fabricarModelo("Mecanico"))
                               .consultarMecanico(partesDelMecanico[3]);
        return mecanico;
    }
    
    private VehiculoDTO obtenerDatosVehiculo(FrmNuevoTurno vista){
        String[] partesDelVehiculo = vista.getComboBoxVehiculo().getSelectedItem().toString().split("[ X]");
        VehiculoDTO vehiculo = ((Vehiculo) this.MODELO.fabricarModelo("Vehiculo"))
                             .consultarVehiculo(parseInt(partesDelVehiculo[2]));
        return vehiculo;
    }
    
    private String obtenerNroTitular(FrmNuevoVehiculo vista){
        String[] partesDelTitular = vista.getComboBoxTitulares().getSelectedItem().toString().split("[ X]");
        String nroTitular = partesDelTitular[2];
        return nroTitular;
    }
    
    private String obtenerCuitCompania(FrmNuevoVehiculo vista){
        String[] partesDeLaCompania = vista.getComboBoxCompanias().getSelectedItem().toString().split("[ X]");
        String cuitCompania = partesDeLaCompania[1];
        return cuitCompania;
    }
    
    private TurnoDTO obtenerDatosTurno(FrmNuevoTurno vista, int legajoMecanico){
        TurnoDTO turno = ((Turno) this.MODELO.fabricarModelo("Turno"))
                          .consultarTurnoPorMecanicoDiaYHora(legajoMecanico,
                                                             vista.getComboBoxFecha().getSelectedItem().toString(),
                                                             vista.getComboBoxHora().getSelectedItem().toString());
        return turno;
    }
    
    private int obtenerProximoNroTitular(){
        List<TitularDTO> listadoTitulares = ((Titular) this.MODELO.fabricarModelo("Titular")).listarTitulares();
        int cantidadTitularesInsertados = listadoTitulares.size();
        return (cantidadTitularesInsertados + 1);
    }
    
    // METODOS DE INSERCION DE DATOS A BASE DE DATOS
    
    private void insertarVehiculo(FrmNuevoVehiculo vista) {
        MODELO = ((Vehiculo)this.MODELO.fabricarModelo("Vehiculo"));
        ((Vehiculo)MODELO).insertarVehiculo(Integer.parseInt(vista.getTextFieldNroPoliza().getText()),
                                            vista.getTextFieldModelo().getText(),
                                            vista.getTextFieldMarca().getText(),
                                            this.obtenerNroTitular(vista),
                                            this.obtenerCuitCompania(vista));
        this.volverNuevoTurno();
    }
    
    private void insertarTitular(FrmNuevoTItular vista) {
        MODELO = ((Titular)this.MODELO.fabricarModelo("Titular"));
        ((Titular)MODELO).insertarTitular(this.obtenerProximoNroTitular(),
                                          vista.getTextNombre().getText(), 
                                          vista.getTextApellido().getText(),
                                          vista.getCombBoxDoc().getSelectedItem().toString(),
                                          vista.getTextNumeroDoc().getText(), 
                                          vista.getTextTelefono().getText());
        this.volverNuevoTurno();
    }
    
    private void insertarTurno(FrmNuevoTurno vista) {
        VehiculoDTO vehiculo = this.obtenerDatosVehiculo(vista);
        MecanicoDTO mecanico = this.obtenerDatosMecanico(vista);
        TurnoDTO    turno    = this.obtenerDatosTurno(vista, mecanico.getLegajo());
        MODELO = ((Turno)this.MODELO.fabricarModelo("Turno"));
        ((Turno)MODELO).asignarTurno(vehiculo.getNroPoliza(),
                                     parseInt(vehiculo.getNroTitular()),
                                     vehiculo.getCuitCompania(),
                                     turno.getAnoMes(),
                                     mecanico.getLegajo(),
                                     turno.getDia(),
                                     turno.getHora());
        this.volverHome();
        this.actualizarTabla(((vistaHome) this.VISTA));
    }
    
    private void insertarAgenda(FrmNuevoTurno vista) {
        MODELO = ((Agenda)this.MODELO.fabricarModelo("Agenda"));
        ((Agenda)MODELO).modificarAgenda(vista.getComboBoxFecha().getSelectedItem().toString(),
                                         vista.getComboBoxHora().getSelectedItem().toString(),
                                         vista.getComboBoxMecanicos().getSelectedItem().toString());
    }
    
    // METODOS DE CARGA DE DATOS A LOS COMBO BOX DE LAS VISTAS

    private void cargarMecanicos(FrmNuevoTurno vista) {
        JComboBox modeloComboBoxMecanicos = (JComboBox) vista.getComboBoxMecanicos();
        List<MecanicoDTO> listadoMecanicoPorEspecialidad= ((Mecanico) this.MODELO.fabricarModelo("Mecanico")).
                                                          listarMecanicosConCriterios(vista.
                                                          getComboBoxEspecialidad().getSelectedItem().toString());
        String [] mecanicos = new String[listadoMecanicoPorEspecialidad.size()+1];
        mecanicos[0] = "-";
        for(int i = 0; i < listadoMecanicoPorEspecialidad.size(); i++) {
            mecanicos[i+1] = listadoMecanicoPorEspecialidad.get(i).getNombre() + " - Legajo: " + listadoMecanicoPorEspecialidad.get(i).getLegajo();
        }
        modeloComboBoxMecanicos.setModel(new DefaultComboBoxModel(mecanicos));
    }
    
    private void cargarDias(FrmNuevoTurno vista) {
        JComboBox modeloComboBoxFecha = (JComboBox) vista.getComboBoxFecha();
        if(vista.getComboBoxMecanicos().getItemCount() == 0) {
            modeloComboBoxFecha.setModel(new DefaultComboBoxModel());
            return;
        }
        List<AgendaDTO> listadoFecha = ((Agenda) this.MODELO.fabricarModelo("Agenda")).listarAgenda(
                                       Integer.toString(this.obtenerDatosMecanico(vista).getLegajo()),
                                       "No Asignado");
        String [] fechas = new String[listadoFecha.size()+1];
        fechas[0] = "-";
        for(int i = 0; i < listadoFecha.size(); i++) {
            fechas[i+1] = listadoFecha.get(i).getDia();
        }
        modeloComboBoxFecha.setModel(new DefaultComboBoxModel(fechas));
    }
    
    private void cargarHorarios(FrmNuevoTurno vista) {
        JComboBox modeloComboBoxHora = (JComboBox) vista.getComboBoxHora();
        if(vista.getComboBoxFecha().getItemCount() == 0) {
            modeloComboBoxHora.setModel(new DefaultComboBoxModel());
            return;
        }
        List<AgendaDTO> listadoHorario = ((Agenda) this.MODELO.fabricarModelo("Agenda")).listarAgendaPorFecha(
                                         Integer.toString(this.obtenerDatosMecanico(vista).getLegajo()),
                                         "No Asignado",
                                         vista.getComboBoxFecha().getSelectedItem().toString());
        String [] horarios = new String[listadoHorario.size()+1];
        horarios[0] = "-";
        for(int i = 0; i < listadoHorario.size(); i++) {
            horarios[i+1] = listadoHorario.get(i).getHora();
        }
        modeloComboBoxHora.setModel(new DefaultComboBoxModel(horarios));
    }
    
    private void cargarVehiculos(FrmNuevoTurno vista){
        JComboBox modeloComboBoxVehiculos = (JComboBox) vista.getComboBoxVehiculo();
        List<VehiculoDTO> listadoVehiculos = ((Vehiculo) this.MODELO.fabricarModelo("Vehiculo")).listarVehiculosPorTitular(Integer.toString(this.obtenerDatosTitular(vista).getNroTitular()));
        String [] vehiculos = new String[listadoVehiculos.size()+1];
        vehiculos[0] = "-";
        for(int i = 0; i < listadoVehiculos.size(); i++) {
            vehiculos[i+1] = "Nro. Poliza: " + listadoVehiculos.get(i).getNroPoliza() + " - Cuit Comp. Seguro: " + listadoVehiculos.get(i).getCuitCompania();
        }
        modeloComboBoxVehiculos.setModel(new DefaultComboBoxModel(vehiculos));
    }   
    
    // SE ENCARGA DE VER CUANDO UN COMOBO BAX CAMBIA DE SELECCION, Y ENTONCES CARGA EL COMBO BOX QUE LE SIGUE Y CORRESPONDE
    
    public void itemStateChanged(ItemEvent ie) {
        if(ie.getStateChange() == ItemEvent.SELECTED) {
            
            // Toma el cambio en ComboBox Especialidad
            if(ie.getSource().equals(((FrmNuevoTurno) VISTA).getComboBoxEspecialidad())) {
                if(ie.getItem().toString() == "-") {
                    ((FrmNuevoTurno) VISTA).getComboBoxMecanicos().setEnabled(false);
                    ((FrmNuevoTurno) VISTA).getComboBoxFecha().setEnabled(false);
                    ((FrmNuevoTurno) VISTA).getComboBoxHora().setEnabled(false);
                    ((FrmNuevoTurno) VISTA).getBotonGuardar().setEnabled(false);
                }
                else {
                    ((FrmNuevoTurno) VISTA).getComboBoxMecanicos().setEnabled(true);
                    cargarMecanicos(((FrmNuevoTurno) this.VISTA));
                }
            }
            
            // Toma el cambio en ComboBox Mecanicos
            if(ie.getSource().equals(((FrmNuevoTurno) VISTA).getComboBoxMecanicos())) {
                if(ie.getItem().toString() == "-") {
                    ((FrmNuevoTurno) VISTA).getComboBoxFecha().setEnabled(false);
                    ((FrmNuevoTurno) VISTA).getComboBoxHora().setEnabled(false);
                    ((FrmNuevoTurno) VISTA).getBotonGuardar().setEnabled(false);
                }
                else {
                    ((FrmNuevoTurno) VISTA).getComboBoxFecha().setEnabled(true);
                    cargarDias(((FrmNuevoTurno) this.VISTA));
                }
            }
            
            // Toma el cambio en ComboBox Titulares
            if(ie.getSource().equals(((FrmNuevoTurno) VISTA).getComboBoxTitular())) {
                    if(ie.getItem().toString() == "-") {
                        ((FrmNuevoTurno) VISTA).getComboBoxVehiculo().setEnabled(false);
                        ((FrmNuevoTurno) VISTA).getBotonGuardar().setEnabled(false);
                    }else{
                        ((FrmNuevoTurno) VISTA).getComboBoxVehiculo().setEnabled(true);
                        cargarVehiculos(((FrmNuevoTurno) this.VISTA));
                    }
                }
            }
        
            // Toma el cambio en ComboBox Vehiculos
            if(ie.getSource().equals(((FrmNuevoTurno) VISTA).getComboBoxVehiculo())) {
                if(ie.getItem().toString() == "-") {
                    ((FrmNuevoTurno) VISTA).getBotonGuardar().setEnabled(false);
                }else{
                    if(((FrmNuevoTurno) VISTA).getComboBoxEspecialidad().getSelectedItem().toString() != "-" &&
                      ((FrmNuevoTurno) VISTA).getComboBoxMecanicos().getSelectedItem().toString() != "-" &&
                      ((FrmNuevoTurno) VISTA).getComboBoxTitular().getSelectedItem().toString() != "-" &&
                      ((FrmNuevoTurno) VISTA).getComboBoxFecha().getSelectedItem().toString() != "-" &&
                      ((FrmNuevoTurno) VISTA).getComboBoxHora().getSelectedItem().toString() != "-"){
                        ((FrmNuevoTurno) VISTA).getBotonGuardar().setEnabled(true);
                    }
                }
            }
            
            
            // Toma el cambio en ComboBox Fecha
            if(ie.getSource().equals(((FrmNuevoTurno) VISTA).getComboBoxFecha())) {
                if(ie.getItem().toString() == "-") {
                    ((FrmNuevoTurno) VISTA).getComboBoxHora().setEnabled(false);
                    ((FrmNuevoTurno) VISTA).getBotonGuardar().setEnabled(false);

                }
                else {
                    ((FrmNuevoTurno) VISTA).getComboBoxHora().setEnabled(true);
                    cargarHorarios(((FrmNuevoTurno) this.VISTA));
                    if(((FrmNuevoTurno) VISTA).getComboBoxEspecialidad().getSelectedItem().toString() != "-" &&
                      ((FrmNuevoTurno) VISTA).getComboBoxMecanicos().getSelectedItem().toString() != "-" &&
                      ((FrmNuevoTurno) VISTA).getComboBoxTitular().getSelectedItem().toString() != "-" &&
                      ((FrmNuevoTurno) VISTA).getComboBoxVehiculo().getSelectedItem().toString() != "-" &&
                      ((FrmNuevoTurno) VISTA).getComboBoxHora().getSelectedItem().toString() != "-"){
                        ((FrmNuevoTurno) VISTA).getBotonGuardar().setEnabled(true);
                    }
                }
            }
            
            // Toma el cambio en ComboBox Hora
            if(ie.getSource().equals(((FrmNuevoTurno) VISTA).getComboBoxHora())) {
                if(ie.getItem().toString() == "-") {
                    ((FrmNuevoTurno) VISTA).getBotonGuardar().setEnabled(false);
                }
                else {
                    if(((FrmNuevoTurno) VISTA).getComboBoxEspecialidad().getSelectedItem().toString() != "-" &&
                      ((FrmNuevoTurno) VISTA).getComboBoxMecanicos().getSelectedItem().toString() != "-" &&
                      ((FrmNuevoTurno) VISTA).getComboBoxTitular().getSelectedItem().toString() != "-" &&
                      ((FrmNuevoTurno) VISTA).getComboBoxVehiculo().getSelectedItem().toString() != "-" &&
                      ((FrmNuevoTurno) VISTA).getComboBoxFecha().getSelectedItem().toString() != "-"){
                        ((FrmNuevoTurno) VISTA).getBotonGuardar().setEnabled(true);
                    }
                }
            }
        }
    
        @Override
        public void insertUpdate(DocumentEvent de) {
            ((FrmNuevoTItular) VISTA).setVisible(true);
             if(((FrmNuevoTItular) VISTA).getTextNombre().getText().length() > 0 &&
               ((FrmNuevoTItular) VISTA).getTextApellido().getText().length() > 0 &&
               ((FrmNuevoTItular) VISTA).getTextNumeroDoc().getText().length() > 0 &&
               ((FrmNuevoTItular) VISTA).getTextTelefono().getText().length() > 0){
               ((FrmNuevoTItular) VISTA).getBotonGuardar().setEnabled(true);
            }
        }

        @Override
        public void removeUpdate(DocumentEvent de) {
            ((FrmNuevoTItular) VISTA).setVisible(true);
            if(((FrmNuevoTItular) VISTA).getTextNombre().getText().length() == 0 ||
               ((FrmNuevoTItular) VISTA).getTextApellido().getText().length() == 0 ||
               ((FrmNuevoTItular) VISTA).getTextNumeroDoc().getText().length() == 0 ||
               ((FrmNuevoTItular) VISTA).getTextTelefono().getText().length() == 0){
               ((FrmNuevoTItular) VISTA).getBotonGuardar().setEnabled(false);
            }
        }

        @Override
        public void changedUpdate(DocumentEvent de) {
            System.out.println("Override");
        }
        
    // Metodos para los botones
    
    private void irVistaConfirmarTurno() {
        int row = ((vistaHome) VISTA).getColumnaBoton().getCurrentRow();
        
        JTable tabla = ((vistaHome) VISTA).getTablaTurnos();
        int nroTurno = (int) tabla.getValueAt(row, 0);
        String anoMes = tabla.getValueAt(row, 1).toString();
        String dia = tabla.getValueAt(row, 2).toString();
        String hora = tabla.getValueAt(row, 3).toString();
        String mecanico = tabla.getValueAt(row, 4).toString();
        String vehiculo = tabla.getValueAt(row, 5).toString();
        String titular = tabla.getValueAt(row, 6).toString();
        
        VISTA.cerrarVista();
        VISTA = new vistaConfirmarTurno();
        VISTA.iniciaVista();
        VISTA.setControlador(this, this, this); 
        
        iniciarVistaConfirmarTurno( nroTurno, anoMes, dia, hora, mecanico, vehiculo, titular );
    }

    private void filtrarTabla(vistaHome vistaHome) {
        String filtro = vistaHome.getComboFiltro().getSelectedItem().toString();
        
        if(filtro == "Todos"){
            actualizarTabla(vistaHome);
        }else{
            System.out.println("Filtrar por: " + filtro);
            actualizarTablaFiltrado(vistaHome, filtro);
        }
  
    }

    private void irVistaConsultarFicha() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void irFrmRegistrarFicha() {
        int row = ((vistaHome) VISTA).getColumnaBoton().getCurrentRow();
        
        JTable tabla = ((vistaHome) VISTA).getTablaTurnos();
        String mecanico = tabla.getValueAt(row, 4).toString();
        String nroFicha = tabla.getValueAt(row, 9).toString();
        
        VISTA.cerrarVista();
        VISTA = new FrmFichaMecanica();
        VISTA.iniciaVista();
        VISTA.setControlador(this, this, this); 
        
        iniciarVistaFrmRegistrarFicha(mecanico, nroFicha,"", false);
    }

    private void iniciarVistaFrmRegistrarFicha(String mecanico, String nroFicha,String obs, Boolean confirmada) {
        if(!confirmada){
        ((FrmFichaMecanica) VISTA).getFiledNroFicha().setText(nroFicha);
        ((FrmFichaMecanica) VISTA).getTextLegajo().setText(mecanico);
        }else{
        ((FrmFichaMecanica) VISTA).getFiledNroFicha().setText(nroFicha);
        ((FrmFichaMecanica) VISTA).getTextLegajo().setText(mecanico);
        ((FrmFichaMecanica) VISTA).getAreaObservaciones().setText(obs);
        ((FrmFichaMecanica) VISTA).getAreaObservaciones().setEnabled(false);
        ((FrmFichaMecanica) VISTA).getBotonGuardar().setEnabled(false);
        }
        
    }

    private void confirmarFicha() {
        String nroFicha = ((FrmFichaMecanica) VISTA).getFiledNroFicha().getText().toString();
        String legajo = ((FrmFichaMecanica) VISTA).getTextLegajo().getText().toString();
        String observaciones = ((FrmFichaMecanica) VISTA).getAreaObservaciones().getText().toString();
        //System.out.print("DATOS: " + nroFicha + " - " + legajo + "\n");
        
        ((Turno)MODELO).registrarFichaMecanica(observaciones, nroFicha);
        
        volverHome();
    }

    private void irFrmRegistrarFichaConfirmada() {
        int row = ((vistaHome) VISTA).getColumnaBoton().getCurrentRow();
        
        JTable tabla = ((vistaHome) VISTA).getTablaTurnos();
        String mecanico = tabla.getValueAt(row, 4).toString();
        String nroFicha = tabla.getValueAt(row, 9).toString();
        String obs = ((Turno)MODELO).getObservaciones(nroFicha);
        VISTA.cerrarVista();
        VISTA = new FrmFichaMecanica();
        VISTA.iniciaVista();
        VISTA.setControlador(this, this, this); 
        
        iniciarVistaFrmRegistrarFicha(mecanico, nroFicha, obs, true);
    
    }
   }

