/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author felipe
 */
public class EditorFicha extends AbstractCellEditor implements TableCellEditor {
    Boolean currentValue;
    JButton button;
    protected static final String CONFIRMAR = "CONFIRMAR_TURNO";
    protected static final String REGISTRAR = "REGISTRAR_FICHA";
    protected static final String CONSULTAR = "CONSULTAR_FICHA";
    private JTable jTable;
    
    public EditorFicha(JTable jTable, Controlador controlador) {
        button = new JButton();
        button.addActionListener(controlador);
        button.setBorderPainted(false);
        this.jTable = jTable;
    }

    @Override
    public Object getCellEditorValue() {
        return currentValue;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean bln, int row, int column) {
        if( "Asignado".equals(table.getValueAt(row, 7)) ) {
            button.setActionCommand(CONFIRMAR);
            button.setText("Consultar");
            return button;
        }
        if( "Confirmado".equals(table.getValueAt(row, 7)) ) {
            button.setActionCommand(REGISTRAR);
            button.setText("Registrar");
            return button;
        }
        if( "Finalizado".equals(table.getValueAt(row, 7)) ) {
            button.setActionCommand(CONSULTAR);
            button.setText(table.getValueAt(row, 8).toString());
            return button;
        }
        return new JLabel();
    }
}

