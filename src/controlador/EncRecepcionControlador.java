/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dto.TurnoDTO;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Modelo;
import modelo.Turno;
import vista.InterfazTurno;

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
        Turno turnoModelo = (Turno) MODELO;
        try {

            switch (InterfazTurno.Operacion.valueOf(e.getActionCommand())) {
                case CONSULTAR:
                    System.out.println("CONSULTAR");
                    List<TurnoDTO> listadoTurnos = turnoModelo.listarTurno();
                    for (TurnoDTO turno : listadoTurnos) {
                    System.out.println("Encontrado: Nro: " + turno.getNro() + " - Dia: " 
                             + turno.getDia() + " - Hora: " + turno.getHora() +
                               " - Mecanico: " + turno.getMecanico() + " - Vehiculo: "
                             + turno.getVehiculo() + " - Titular: " + turno.getTitular()
                             + " - Compania: " + turno.getCompaniaSeguro() + 
                               " - Estado: " + turno.getEstado() + " - Ficha: "
                             + turno.getFichaMecanica());
                    }
                    break;
                case TURNO:
                    System.out.println("TURNO");
                    break;
                case CLIENTE:
                    System.out.println("CLIENTE");
                    break;
                case EMPLEADO:
                    System.out.println("EMPLEADO");
                    break;
            }
        } catch (RuntimeException ex) {
            System.out.println("CATCH");
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
