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
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import modelo.Agenda;
import modelo.Compania;
import modelo.Especialidad;
import modelo.Mecanico;
import modelo.Modelo;
import modelo.Turno;
import vista.InterfazTurno;
import vista.vistaHome;
import vista.FrmNuevoTurno;

/**
 *
 * @author francisco
 */
public class EncRecepcionControlador extends Controlador {
    
    public EncRecepcionControlador(InterfazTurno vista, Modelo modelo) {
        VISTA = vista;
        MODELO = modelo;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {

            switch (InterfazTurno.Operacion.valueOf(e.getActionCommand())) {
                case CONSULTAR:
                    VISTA.limpiaVista();
                    VISTA.actualizaTabla(this);
                    break;

                case TURNO:
                    // CERRAMOS LA VISTA ANTERIOR Y ABRIMOS LA DE NUEVO TURNO
                    VISTA.cerrarVista();
                    VISTA = new FrmNuevoTurno();
                    VISTA.iniciaVista();
                    VISTA.setControlador(this);
                    
                    iniciarFrmNuevoTurno();
                    break;
                 
                case CARGAR:
                    DefaultTableModel modeloTabla = (DefaultTableModel) ((vistaHome) this.VISTA).getModeloTblTurnos();
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
                    break;
                    
                case MECANICO:
                    JComboBox modeloComboBoxMecanicos = (JComboBox) ((FrmNuevoTurno) this.VISTA).getComboBoxMecanicos();
                    List<MecanicoDTO> listadoMecanicoPorEspecialidad= ((Mecanico) this.MODELO.fabricarModelo("Mecanico")).listarMecanicosConCriterios(((FrmNuevoTurno) this.VISTA).getEspecialdiadSeleccionada());
                    String [] mecanicos = new String[listadoMecanicoPorEspecialidad.size()];
                    for(int i = 0; i < listadoMecanicoPorEspecialidad.size(); i++) {
                        mecanicos[i] = listadoMecanicoPorEspecialidad.get(i).getNombre();
                    }
                    modeloComboBoxMecanicos.setModel(new DefaultComboBoxModel(mecanicos));;
                    
                    break;
                
                case DIA:
                    JComboBox modeloComboBoxFecha = (JComboBox) ((FrmNuevoTurno) this.VISTA).getComboBoxFecha();
                    if(((FrmNuevoTurno) this.VISTA).getComboBoxMecanicos().getItemCount() == 0) {
                        modeloComboBoxFecha.setModel(new DefaultComboBoxModel());
                        break;
                    }
//                    List<AgendaDTO> listadoFecha = ((Agenda) this.MODELO.fabricarModelo("Agenda")).listarAgenda(
//                                                   ((FrmNuevoTurno) this.VISTA).getMecanicoSeleccionado(), 
//                                                   "No asignado");
                    List<AgendaDTO> listadoFecha = ((Agenda) this.MODELO.fabricarModelo("Agenda")).listarAgenda(
                                                   ((FrmNuevoTurno) this.VISTA).getComboBoxMecanicos().getSelectedItem().toString(),
                                                   "No asignado");
                    String [] fechas = new String[listadoFecha.size()];
                    for(int i = 0; i < listadoFecha.size(); i++) {
                        fechas[i] = listadoFecha.get(i).getDia();
                    }
                    modeloComboBoxFecha.setModel(new DefaultComboBoxModel(fechas));
                    break;
                    
                case HORA:
                    JComboBox modeloComboBoxHora = (JComboBox) ((FrmNuevoTurno) this.VISTA).getComboBoxHora();
                    if(((FrmNuevoTurno) this.VISTA).getComboBoxFecha().getItemCount() == 0) {
                        modeloComboBoxHora.setModel(new DefaultComboBoxModel());
                        break;
                    }
//                    if(((FrmNuevoTurno) this.VISTA).getComboBoxFecha().getSelectedItem() == null){
//                        modeloComboBoxHora.removeAllItems();
//                        break;
//                    }
//                    List<AgendaDTO> listadoHorario = ((Agenda) this.MODELO.fabricarModelo("Agenda")).listarAgendaPorFecha(
//                                                     ((FrmNuevoTurno) this.VISTA).getMecanicoSeleccionado(),
//                                                     "No asignado",
//                                                     ((FrmNuevoTurno) this.VISTA).getFechaSeleccionada());
                    List<AgendaDTO> listadoHorario = ((Agenda) this.MODELO.fabricarModelo("Agenda")).listarAgendaPorFecha(
                                                     ((FrmNuevoTurno) this.VISTA).getComboBoxMecanicos().getSelectedItem().toString(),
                                                     "No asignado",
                                                     ((FrmNuevoTurno) this.VISTA).getComboBoxFecha().getSelectedItem().toString());
                    String [] horarios = new String[listadoHorario.size()];
                    for(int i = 0; i < listadoHorario.size(); i++) {
                        horarios[i] = listadoHorario.get(i).getHorario();
                    }
                    modeloComboBoxHora.setModel(new DefaultComboBoxModel(horarios));
                    break;
                    
                default:
                    System.out.println("DEFAULT");
                    break;
            }
        } catch (RuntimeException ex) {
            System.out.println("CATCH: " + ex.getMessage());
        }
    }
    
    private void iniciarFrmNuevoTurno() {
        
        // CARGAMOS LAS ESPECIALIDADES
        JComboBox modeloComboBoxEspecialidades = (JComboBox) ((FrmNuevoTurno) this.VISTA).getComboBoxEspecialidad();
        List<EspecialidadDTO> listadoEspecialidades = ((Especialidad) this.MODELO.fabricarModelo("Especialidad")).listarEspecialidades();
        for (EspecialidadDTO especialidad : listadoEspecialidades) {
            modeloComboBoxEspecialidades.addItem(especialidad.getNombre()); 
        }

        // CARGAMOS LAS COMPANIAS DE SEGURO
        JComboBox modeloComboBoxCompanias = (JComboBox) ((FrmNuevoTurno) this.VISTA).getComboBoxCompania();
        List<CompaniaDTO> listadoCompanias = ((Compania) this.MODELO.fabricarModelo("Compania")).listarCompanias();
        for (CompaniaDTO compania : listadoCompanias) {
            modeloComboBoxCompanias.addItem(compania.getRazonSocial()); 
        }
    }
    
    /*
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("NASHEEEEEEEEEEEEE");
        
        if (e.getSource() instanceof JTable) {
            DefaultTableModel modeloTabla = (DefaultTableModel) ((FrmTurno) this.VISTA).getModeloTblAlumnos();
            ((FrmTurno) this.VISTA).getTxtLegajo().setValue(modeloTabla.getValueAt(((FrmTurno) this.VISTA).getTblAlumnos().getSelectedRow(), 0));
            ((FrmTurno) this.VISTA).getTxtNombre().setText((String) modeloTabla.getValueAt(((FrmTurno) this.VISTA).getTblAlumnos().getSelectedRow(), 1));
            ((FrmTurno) this.VISTA).getTxtApellido().setText((String) modeloTabla.getValueAt(((FrmTurno) this.VISTA).getTblAlumnos().getSelectedRow(), 2));
        } else if(e.getSource() instanceof JButton){
            Object legajo = ((FrmTurno) this.VISTA).getTxtLegajo().getValue();
            if (legajo != null) {
                ((FrmTurno) this.VISTA).getmItemGuardarAlumno().setEnabled(false);
                ((FrmTurno) this.VISTA).getmItemModificarAlumno().setEnabled(true);
            } else {
                ((FrmTurno) this.VISTA).getmItemGuardarAlumno().setEnabled(true);
                ((FrmTurno) this.VISTA).getmItemModificarAlumno().setEnabled(false);
            }
            ((FrmTurno) this.VISTA).getPopUpEdicion().show(e.getComponent(), e.getX(), e.getY());
        }
        
    }
    */
    
    
}

