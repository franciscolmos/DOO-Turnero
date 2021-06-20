/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author francisco
 */
public class EncRecepcionControlador extends Controlador {

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() instanceof JTable) {
            DefaultTableModel modeloTabla = (DefaultTableModel) ((FrmAbmAlumno) this.VISTA).getModeloTblAlumnos();
            ((FrmAbmAlumno) this.VISTA).getTxtLegajo().setValue(modeloTabla.getValueAt(((FrmAbmAlumno) this.VISTA).getTblAlumnos().getSelectedRow(), 0));
            ((FrmAbmAlumno) this.VISTA).getTxtNombre().setText((String) modeloTabla.getValueAt(((FrmAbmAlumno) this.VISTA).getTblAlumnos().getSelectedRow(), 1));
            ((FrmAbmAlumno) this.VISTA).getTxtApellido().setText((String) modeloTabla.getValueAt(((FrmAbmAlumno) this.VISTA).getTblAlumnos().getSelectedRow(), 2));
        } else if(e.getSource() instanceof JButton){
            Object legajo = ((FrmAbmAlumno) this.VISTA).getTxtLegajo().getValue();
            if (legajo != null) {
                ((FrmAbmAlumno) this.VISTA).getmItemGuardarAlumno().setEnabled(false);
                ((FrmAbmAlumno) this.VISTA).getmItemModificarAlumno().setEnabled(true);
            } else {
                ((FrmAbmAlumno) this.VISTA).getmItemGuardarAlumno().setEnabled(true);
                ((FrmAbmAlumno) this.VISTA).getmItemModificarAlumno().setEnabled(false);
            }
            ((FrmAbmAlumno) this.VISTA).getPopUpEdicion().show(e.getComponent(), e.getX(), e.getY());
        }
    }
    
}
