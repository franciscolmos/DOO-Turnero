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
import modelo.Agenda;
import modelo.Compania;
import modelo.Especialidad;
import modelo.Mecanico;
import modelo.Modelo;
import modelo.Titular;
import modelo.Turno;
import modelo.Vehiculo;
import vista.InterfazTurno;
import vista.vistaHome;
import vista.FrmNuevoTurno;
import vista.FrmNuevoTItular;

/**
 *
 * @author francisco
 */
public class EncRecepcionControlador extends Controlador implements ItemListener {
    
    public EncRecepcionControlador(InterfazTurno vista, Modelo modelo) {
        VISTA = vista;
        MODELO = modelo;
        VISTA.setControlador(this, this);
        VISTA.iniciaVista();
        
        cargarAgendasYTurnos();
        
    }
    
    private void cargarAgendasYTurnos(){
        // INSERTAMOS TODOS LOS TURNOS DISPONIBLES POR UNICA VEZ
        List<MecanicoDTO> listadoMecanicos = ((Mecanico) this.MODELO.fabricarModelo("Mecanico")).listarMecanicos();
        ((Turno) this.MODELO.fabricarModelo("Turno")).insertarTurno(listadoMecanicos);
        ((Agenda) this.MODELO.fabricarModelo("Agenda")).insertarAgendas(listadoMecanicos);
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
//                    insertarTurno(((FrmNuevoTurno) this.VISTA));
                    volverHome();
                    break;
                    
                case VOLVER_HOME:
                    volverHome();
                    break;
                    
                case TITULAR:
                    irFrmNuevoTitular();
                    break;
                
                case VOLVER_NUEVO_TURNO:
                    volverNuevoTurno();
                    break;
                    
                case NUEVO_TITULAR:
//                    insertarTitular(((FrmNuevoTItular) this.VISTA));
                    break;
                    
                default:
                    System.out.println("DEFAULT");
                    break;
            }
        } catch (RuntimeException ex) {
            System.out.println("CATCH: " + ex.getMessage());
        }
    }

    private void actualizarTabla(vistaHome vista) {
        VISTA.limpiaVista();
        
        DefaultTableModel modeloTabla = (DefaultTableModel) vista.getModeloTblTurnos();
        modeloTabla.setRowCount(0);
        modeloTabla.fireTableDataChanged();
        List<TurnoDTO> listadoTurnos = ((Turno) this.MODELO).listarTurnosPorCriterio("No Asignado");
        for (TurnoDTO tur : listadoTurnos) {
            modeloTabla.addRow(new Object[]{tur.getNroTurno(),
                                            tur.getDia(), 
                                            tur.getHora(),
                                            tur.getLegajoMecanico(),
                                            tur.getNroPoliza(),
                                            tur.getNroTitular(),
                                            tur.getCuitCompania(),
                                            tur.getEstado()});
        }
    }
    
    private void irFrmNuevoTurno() {
        VISTA.cerrarVista();
        VISTA = new FrmNuevoTurno();
        VISTA.iniciaVista();
        VISTA.setControlador(this, this);

        iniciarFrmNuevoTurno();
    }
    
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
      
    private void volverHome() {
        MODELO = ((Turno)this.MODELO.fabricarModelo("Turno"));
        VISTA.cerrarVista();
        VISTA = new vistaHome();
        VISTA.iniciaVista();
        VISTA.setControlador(this, this);
    }
    
    private void irFrmNuevoTitular(){
        VISTA.cerrarVista();
        VISTA = new FrmNuevoTItular();
        VISTA.iniciaVista();
        VISTA.setControlador(this, this);
    }
    
    private void volverNuevoTurno(){
        MODELO = ((Turno)this.MODELO.fabricarModelo("Turno"));
        VISTA.cerrarVista();
        VISTA = new FrmNuevoTurno();
        VISTA.iniciaVista();
        VISTA.setControlador(this, this);
        iniciarFrmNuevoTurno();
    }
    
//    private void insertarTitular(FrmNuevoTItular vista) {
//        MODELO = ((Titular)this.MODELO.fabricarModelo("Titular"));
//        
//        ((Titular)MODELO).insertarTitular(vista.getTextNombre().getText(), 
//                                          vista.getTextApellido().getText(),
//                                          vista.getTextTipoDoc().getText(),
//                                          vista.getTextNumeroDoc().getText(), 
//                                          vista.getTextTelefono().getText(), 
//                                          vista.getComboBoxCompania().getSelectedItem().toString());
//        this.volverNuevoTurno();
//    }
    
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
    
//    private void insertarVehiculo(FrmNuevoTurno vista) {
//        System.out.println(this.obtenerDatosTitular(vista).getNroDNI());
//        MODELO = ((Vehiculo)this.MODELO.fabricarModelo("Vehiculo"));
//        ((Vehiculo)MODELO).insertarVehiculo(Integer.parseInt(vista.getTextFieldNroPoliza().getText()),
//                                            vista.getTextFieldModelo().getText(),
//                                            vista.getTextFieldMarca().getText(),
//                                            this.obtenerDatosTitular(vista).getNroDNI());
//    }
//    
//    private void insertarTurno(FrmNuevoTurno vista) {
//        MODELO = ((Turno)this.MODELO.fabricarModelo("Turno"));
//        ((Turno)MODELO).asignarTurno(this.obtenerDatosVehiculo(vista).getNroPoliza(),
//                                     this.obtenerDatosVehiculo(vista).getNroTitular(),
//                                     this.obtenerDatosVehiculo(vista).getCuitCompania(),
//                                     this.obtenerDatosMecanico(vista).get);
//    }
    
    private void insertarAgenda(FrmNuevoTurno vista) {
        MODELO = ((Agenda)this.MODELO.fabricarModelo("Agenda"));
        ((Agenda)MODELO).modificarAgenda(vista.getComboBoxFecha().getSelectedItem().toString(),
                                         vista.getComboBoxHora().getSelectedItem().toString(),
                                         vista.getComboBoxMecanicos().getSelectedItem().toString());
    }

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
    
    public void itemStateChanged(ItemEvent ie) {
        if(ie.getStateChange() == ItemEvent.SELECTED) {
            
            // Toma el cambio en ComboBox Especialidad
            if(ie.getSource().equals(((FrmNuevoTurno) VISTA).getComboBoxEspecialidad())) {
                System.out.println("ItemEvent Especialidad");
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
                System.out.println("ItemEvent Mecanicos");
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
                System.out.println("ItemEvent TItulares");
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
                System.out.println("ItemEvent Vehiculos");
                if(ie.getItem().toString() == "-") {
                    ((FrmNuevoTurno) VISTA).getBotonGuardar().setEnabled(false);
                }
            }
            
            
            // Toma el cambio en ComboBox Fecha
            if(ie.getSource().equals(((FrmNuevoTurno) VISTA).getComboBoxFecha())) {
                System.out.println("ItemEvent Fechas");
                if(ie.getItem().toString() == "-") {
                    ((FrmNuevoTurno) VISTA).getComboBoxHora().setEnabled(false);
                    ((FrmNuevoTurno) VISTA).getBotonGuardar().setEnabled(false);

                }
                else {
                    ((FrmNuevoTurno) VISTA).getComboBoxHora().setEnabled(true);
                    cargarHorarios(((FrmNuevoTurno) this.VISTA));                    
                }
            }
            
            // Toma el cambio en ComboBox Hora
            if(ie.getSource().equals(((FrmNuevoTurno) VISTA).getComboBoxHora())) {
                System.out.println("ItemEvent Horas");
                if(ie.getItem().toString() == "-") {
                    ((FrmNuevoTurno) VISTA).getBotonGuardar().setEnabled(false);
                }
                else {
                    ((FrmNuevoTurno) VISTA).getBotonGuardar().setEnabled(true);
                }
            }
        }
    }
