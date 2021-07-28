/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author felipe
 */
public class RenderFicha extends JLabel implements TableCellRenderer {
    boolean isBordered = true;

    public RenderFicha(boolean isBordered) {
        this.isBordered = isBordered;
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object color, boolean isSelected, boolean hasFocus, int row, int column) {
        if( "Asignado".equals(table.getValueAt(row, 7)) ) {
            return new JButton("Consultar");
        }
        if( "Confirmado".equals(table.getValueAt(row, 7)) ) {
            return new JButton("Registrar");
        }
        if( "Finalizado".equals(table.getValueAt(row, 7)) ) {
            return new JButton(table.getValueAt(row, 8).toString());
            //return new JLabel(table.getValueAt(row, 8).toString());
        }
        return this;
//        return new JLabel(table.getValueAt(row, 8).toString());
    }
}
