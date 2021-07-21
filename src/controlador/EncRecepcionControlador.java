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
import dto.TurnoDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
                    
                case GUARDAR:
                    insertarTitular(((FrmNuevoTurno) this.VISTA));
                    insertarVehiculo(((FrmNuevoTurno) this.VISTA));
                    insertarTurno(((FrmNuevoTurno) this.VISTA));
                    insertarAgenda(((FrmNuevoTurno) this.VISTA));
                    
                    volverHome();
                    break;
                    
                case CANCELAR:
                    volverHome();
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
        List<TurnoDTO> listadoTurnos = ((Turno) this.MODELO).listarTurnosPorCriterio("Asignado");
        for (TurnoDTO tur : listadoTurnos) {
            modeloTabla.addRow(new Object[]{tur.getNro(),
                                            tur.getDia(), 
                                            tur.getHora(),
                                            tur.getMecanico(),
                                            tur.getVehiculo(),
                                            tur.getTitular(),
                                            tur.getCompaniaSeguro(),
                                            tur.getEstado(),
                                            tur.getFichaMecanica()});
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
        modeloComboBoxEspecialidades.addItem("-");
        for (EspecialidadDTO especialidad : listadoEspecialidades) {
            modeloComboBoxEspecialidades.addItem(especialidad.getNombre()); 
        }

        // CARGAMOS LAS COMPANIAS DE SEGURO
        JComboBox modeloComboBoxCompanias = (JComboBox) ((FrmNuevoTurno) this.VISTA).getComboBoxCompania();
        List<CompaniaDTO> listadoCompanias = ((Compania) this.MODELO.fabricarModelo("Compania")).listarCompanias();
        modeloComboBoxCompanias.addItem("-");
        for (CompaniaDTO compania : listadoCompanias) {
            modeloComboBoxCompanias.addItem(compania.getRazonSocial()); 
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
    
    private void insertarTitular(FrmNuevoTurno vista) {
        MODELO = ((Titular)this.MODELO.fabricarModelo("Titular"));
        
        String telefono = vista.getTextFieldCodigo().getText() +
                          vista.getTextFieldCaracteristica().getText() +
                          vista.getTextFieldNumero().getText();
        
        ((Titular)MODELO).insertarTitular(vista.getTextFieldNombre().getText(), 
                                          vista.getTextFieldApellido().getText(),
                                          vista.getComboBoxTipoDNI().getSelectedItem().toString(),
                                          vista.getTextFieldNroDNI().getText(), 
                                          telefono,
                                          vista.getComboBoxCompania().getSelectedItem().toString());
    }
    
    private void insertarVehiculo(FrmNuevoTurno vista) {
        MODELO = ((Vehiculo)this.MODELO.fabricarModelo("Vehiculo"));
        ((Vehiculo)MODELO).insertarVehiculo(Integer.parseInt(vista.getTextFieldNroPoliza().getText()),
                                            vista.getTextFieldModelo().getText(),
                                            vista.getTextFieldMarca().getText(),
                                            vista.getTextFieldNroDNI().getText());
    }
    
    private void insertarTurno(FrmNuevoTurno vista) {
        MODELO = ((Turno)this.MODELO.fabricarModelo("Turno"));
        ((Turno)MODELO).insertarTurno(vista.getComboBoxFecha().getSelectedItem().toString(),
                                      vista.getComboBoxHora().getSelectedItem().toString(),
                                      vista.getComboBoxMecanicos().getSelectedItem().toString(),
                                      vista.getTextFieldNroPoliza().getText(),
                                      vista.getTextFieldNroDNI().getText(),
                                      vista.getComboBoxCompania().getSelectedItem().toString());
    }
    
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
            mecanicos[i+1] = listadoMecanicoPorEspecialidad.get(i).getNombre();
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
                                       vista.getComboBoxMecanicos().getSelectedItem().toString(),
                                       "No asignado");
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
                                         vista.getComboBoxMecanicos().getSelectedItem().toString(),
                                         "No asignado",
                                         vista.getComboBoxFecha().getSelectedItem().toString());
        String [] horarios = new String[listadoHorario.size()+1];
        horarios[0] = "-";
        for(int i = 0; i < listadoHorario.size(); i++) {
            horarios[i+1] = listadoHorario.get(i).getHorario();
        }
        modeloComboBoxHora.setModel(new DefaultComboBoxModel(horarios));
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

}
