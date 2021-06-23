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
                    
                case MECANICO:
                    VISTA.limpiaVista();
                    JComboBox modeloComboBoxMecanicos = (JComboBox) ((FrmNuevoTurno) this.VISTA).getComboBoxMecanicos();
                    System.out.println(((FrmNuevoTurno) this.VISTA).getEspecialdiadSeleccionada());
                    List<MecanicoDTO> listadoMecanicoPorEspecialidad= ((Mecanico) this.MODELO.fabricarModelo("Mecanico")).listarMecanicosConCriterios(((FrmNuevoTurno) this.VISTA).getEspecialdiadSeleccionada());
                    for (MecanicoDTO mecanico : listadoMecanicoPorEspecialidad) {
                         modeloComboBoxMecanicos.addItem(mecanico.getNombre());
                    }
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
            }
        } catch (RuntimeException ex) {
            System.out.println("CATCH");
        }
    }
    
    private void iniciarFrmNuevoTurno() {
        
        // CARGAMOS LAS ESPECIALIDADES
        JComboBox modeloComboBoxEspecialidades = (JComboBox) ((FrmNuevoTurno) this.VISTA).getComboBoxEspecialidad();
        List<EspecialidadDTO> listadoEspecialidades = ((Especialidad) this.MODELO.fabricarModelo("Especialidad")).listarEspecialidades();
        for (EspecialidadDTO especialidad : listadoEspecialidades) {
            modeloComboBoxEspecialidades.addItem(especialidad.getNombre()); 
        }

        // CARGAMOS LOS MECANICOS
        JComboBox modeloComboBoxMec = (JComboBox) ((FrmNuevoTurno) this.VISTA).getComboBoxMecanicos();
        List<MecanicoDTO> listadoMecanico= ((Mecanico) this.MODELO.fabricarModelo("Mecanico")).listarMecanicosConCriterios(((FrmNuevoTurno) this.VISTA).getEspecialdiadSeleccionada());
        for (MecanicoDTO mecanico : listadoMecanico) {
             modeloComboBoxMec.addItem(mecanico.getNombre());
        }

        // CARGAMOS LAS COMPANIAS DE SEGURO
        JComboBox modeloComboBoxCompanias = (JComboBox) ((FrmNuevoTurno) this.VISTA).getComboBoxCompania();
        List<CompaniaDTO> listadoCompanias = ((Compania) this.MODELO.fabricarModelo("Compania")).listarCompanias();
        for (CompaniaDTO compania : listadoCompanias) {
            modeloComboBoxCompanias.addItem(compania.getRazonSocial()); 
        }
        
        // CARGAMOS LA AGENDA DEL MECANICO ELEGIDO
        JComboBox modeloComboBoxFecha = (JComboBox) ((FrmNuevoTurno) this.VISTA).getComboBoxFecha();
        List<AgendaDTO> listadoFecha = ((Agenda) this.MODELO.fabricarModelo("Agenda")).listarAgenda(
                                ((FrmNuevoTurno) this.VISTA).getMecanicoSeleccionado(), "No asignado");
        for (AgendaDTO fecha : listadoFecha) {
             modeloComboBoxFecha.addItem(fecha.getDia());
        }
        
        JComboBox modeloComboBoxHora = (JComboBox) ((FrmNuevoTurno) this.VISTA).getComboBoxHora();
        List<AgendaDTO> listadoHorario = ((Agenda) this.MODELO.fabricarModelo("Agenda")).listarAgendaPorFecha(
                ((FrmNuevoTurno) this.VISTA).getMecanicoSeleccionado(), 
                "No asignado", 
                ((FrmNuevoTurno) this.VISTA).getFechaSeleccionada());
        for (AgendaDTO horario : listadoHorario) {
             modeloComboBoxHora.addItem(horario.getHorario());
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

