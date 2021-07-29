package controlador;

import java.awt.*;
import java.awt.event.*;
import java.util.Objects;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *  The ButtonColumn class provides a renderer and an editor that looks like a
 *  JButton. The renderer and editor will then be used for a specified column
 *  in the table. The TableModel will contain the String to be displayed on
 *  the button.
 *
 *  The button can be invoked by a mouse click or by pressing the space bar
 *  when the cell has focus. Optionally a mnemonic can be set to invoke the
 *  button. When the button is invoked the provided Action is invoked. The
 *  source of the Action will be the table. The action command will contain
 *  the model row number of the button that was clicked.
 *
 */
public class ButtonColumn extends AbstractCellEditor
	implements TableCellRenderer, TableCellEditor, ActionListener, MouseListener
{
	private JTable table;
	private int mnemonic;
	private Border originalBorder;
	private Border focusBorder;
        
        private int currentRow;
        
        protected static final String CONFIRMAR = "CONFIRMAR_TURNO";
        protected static final String REGISTRAR = "REGISTRAR_FICHA";
        protected static final String CONSULTAR = "CONSULTAR_FICHA";
        protected static final String ERROR = "NO_ASIGNADO";
        protected static final String CANCELADO = "CANCELADO";
        protected static final String FINALIZADO = "FINALIZADO";

	private JButton renderButton;
	private JButton editButton;
	private Object editorValue;
	private boolean isButtonColumnEditor;

	/**
	 *  Create the ButtonColumn to be used as a renderer and editor. The
	 *  renderer and editor will automatically be installed on the TableColumn
	 *  of the specified column.
	 *
	 *  @param table the table containing the button renderer/editor
	 *  @param action the Action to be invoked when the button is invoked
	 *  @param column the column to which the button renderer/editor is added
	 */
	public ButtonColumn(JTable table, int column)
	{
		this.table = table;

		renderButton = new JButton();
		editButton = new JButton();
		editButton.setFocusPainted( false );
		originalBorder = editButton.getBorder();
		setFocusBorder( new LineBorder(Color.BLUE) );

		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(column).setCellRenderer( this );
		columnModel.getColumn(column).setCellEditor( this );
		table.addMouseListener( this );
	}
        
        public void setControlador( Controlador c ) {
            editButton.addActionListener(c);
        }

        public int getCurrentRow() {
            return currentRow;
        }

	/**
	 *  Get foreground color of the button when the cell has focus
	 *
	 *  @return the foreground color
	 */
	public Border getFocusBorder()
	{
		return focusBorder;
	}

	/**
	 *  The foreground color of the button when the cell has focus
	 *
	 *  @param focusBorder the foreground color
	 */
	public void setFocusBorder(Border focusBorder)
	{
		this.focusBorder = focusBorder;
		editButton.setBorder( focusBorder );
	}

	public int getMnemonic()
	{
		return mnemonic;
	}

	/**
	 *  The mnemonic to activate the button when the cell has focus
	 *
	 *  @param mnemonic the mnemonic
	 */
	public void setMnemonic(int mnemonic)
	{
		this.mnemonic = mnemonic;
		renderButton.setMnemonic(mnemonic);
		editButton.setMnemonic(mnemonic);
	}
        
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean bln, int row, int column) {
            
        if( Objects.equals("Asignado", table.getValueAt(row, 7).toString())) {
            editButton.setActionCommand(CONFIRMAR);
        }
        if( Objects.equals("Confirmado", table.getValueAt(row, 7).toString()) ) {
            editButton.setActionCommand(REGISTRAR);
        }
        if( Objects.equals("Finalizado", table.getValueAt(row, 7).toString()) ) {
            editButton.setActionCommand(FINALIZADO);
        }
        if( Objects.equals("No Asignado", table.getValueAt(row, 7).toString()) ) {
            editButton.setActionCommand(ERROR);
        }
         if( Objects.equals("Cancelado", table.getValueAt(row, 7).toString()) ) {
            editButton.setActionCommand(CANCELADO);
        }
         
        currentRow = row;
         
        return editButton;
    }

	@Override
	public Object getCellEditorValue()
	{
		return editorValue;
	}

//
//  Implement TableCellRenderer interface
//
	public Component getTableCellRendererComponent(
		JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
	{
            renderButton.setText( "Ver Ficha" );
            renderButton.setIcon( null );

	    return renderButton;
	}

//
//  Implement ActionListener interface
//
	/*
	 *	The button has been pressed. Stop editing and invoke the custom Action
	 */
	public void actionPerformed(ActionEvent e)
	{
//		int row = table.convertRowIndexToModel( table.getEditingRow() );
//		fireEditingStopped();
//                
//                
//		  Obtenemos el Estado del Turno elegido
//                
//                String estado = table.getValueAt(row, 7).toString();
//
//                if(Objects.equals("Confirmado", estado)){
//                    
//                    System.out.print("Estado: " + estado);
//                
//                }else{
//                    showMessageDialog(null, "Aún no hay una ficha disponible!");
//                }
//                
	}

//
//  Implement MouseListener interface
//
	/*
	 *  When the mouse is pressed the editor is invoked. If you then then drag
	 *  the mouse to another cell before releasing it, the editor is still
	 *  active. Make sure editing is stopped when the mouse is released.
	 */
    public void mousePressed(MouseEvent e)
    {
    	if (table.isEditing()
		&&  table.getCellEditor() == this)
			isButtonColumnEditor = true;
    }

    public void mouseReleased(MouseEvent e)
    {
    	if (isButtonColumnEditor
    	&&  table.isEditing())
    		table.getCellEditor().stopCellEditing();

		isButtonColumnEditor = false;
    }

    public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}