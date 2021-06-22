/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author benja
 */
public class vistaHome extends javax.swing.JFrame implements InterfazTurno {

    public DefaultTableModel getModeloTblTurnos() {
        return modeloTblTurnos;
    }

    private final DefaultTableModel modeloTblTurnos;
    
    /**
     * Creates new form vistaHome
     */
    public vistaHome() {
        initComponents();
        this.modeloTblTurnos = (DefaultTableModel) this.TablaTurnos.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TituloLabel = new javax.swing.JLabel();
        NuevoTurnoBtn = new javax.swing.JButton();
        ConsultarButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaTurnos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TituloLabel.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        TituloLabel.setText("SuperCharger S.R.L.");

        NuevoTurnoBtn.setText("Nuevo Turno");
        NuevoTurnoBtn.setActionCommand("TURNO");
        NuevoTurnoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoTurnoBtnActionPerformed(evt);
            }
        });

        ConsultarButton.setText("Consultar Turno");
        ConsultarButton.setActionCommand("CONSULTAR");

        TablaTurnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nro", "Dia", "Hora", "Mecanico", "Vehiculo", "Titular", "Compania", "Estado", "FichaMecanica"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TablaTurnos.setToolTipText("");
        jScrollPane1.setViewportView(TablaTurnos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(NuevoTurnoBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ConsultarButton)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(TituloLabel)
                .addGap(0, 228, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(TituloLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ConsultarButton)
                    .addComponent(NuevoTurnoBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NuevoTurnoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoTurnoBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NuevoTurnoBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vistaHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConsultarButton;
    private javax.swing.JButton NuevoTurnoBtn;
    private javax.swing.JTable TablaTurnos;
    private javax.swing.JLabel TituloLabel;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setControlador(Controlador c) {
        this.ConsultarButton.addActionListener(c);
        this.NuevoTurnoBtn.addActionListener(c);
        c.actionPerformed(new ActionEvent(this, 0, InterfazTurno.Operacion.CARGAR.toString()));
    }
    
    @Override
    public void iniciaVista() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void cerrarVista() {
        setVisible(false);
    }

    @Override
    public void limpiaVista() {
        this.TablaTurnos.clearSelection();
    }

    @Override
    public void actualizaTabla(Controlador c) {
        c.actionPerformed(new ActionEvent(this, 0, vistaHome.Operacion.CARGAR.toString()));
    }
}
