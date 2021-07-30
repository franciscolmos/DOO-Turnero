/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;

/**
 *
 * @author benja
 */
public class FrmNuevoTurno extends javax.swing.JFrame implements InterfazTurno {
    
    public FrmNuevoTurno() {
        initComponents();
        this.setTitle("NUEVO TURNO");
        this.BotonCancelar.setName("BotonCancelar");
        this.ComboBoxEspecialidad.setName("ComboBoxEspecialidades");
        this.ComboBoxMecanicos.setName("ComboBoxMecanicos");
        this.ComboBoxTitular.setName("ComboBoxTitular");
        this.ComboBoxVehiculo.setName("ComboBoxVehiculo");
        this.ComboBoxFecha.setName("ComboBoxFecha");
        this.ComboBoxHora.setName("ComboBoxHora");
        this.BotonGuardar.setName("BotonGuardar");
    }

    public JButton getBotonGuardar() {
        return BotonGuardar;
    }

    public JComboBox<String> getComboBoxEspecialidad() {
        return ComboBoxEspecialidad;
    }
    
    public JComboBox<String> getComboBoxMecanicos() {
        return ComboBoxMecanicos;
    }

    public JComboBox<String> getComboBoxTitular() {
        return ComboBoxTitular;
    }
    
    public JComboBox<String> getComboBoxFecha() {
        return ComboBoxFecha;
    }

    public JComboBox<String> getComboBoxHora() {
        return ComboBoxHora;
    }

    public JButton getBotonAgregarVehiculo() {
        return BotonAgregarVehiculo;
    }

    public JComboBox<String> getComboBoxVehiculo() {
        return ComboBoxVehiculo;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        ComboBoxMecanicos = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BotonCancelar = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        ComboBoxEspecialidad = new javax.swing.JComboBox<>();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jLabel19 = new javax.swing.JLabel();
        ComboBoxHora = new javax.swing.JComboBox<>();
        ComboBoxFecha = new javax.swing.JComboBox<>();
        BotonGuardar = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        ComboBoxTitular = new javax.swing.JComboBox<>();
        BotonAgregarTitular = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        BotonAgregarVehiculo = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        ComboBoxVehiculo = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Formulario de Turno");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(2147483647, 2100000000));
        setResizable(false);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel3.setText("Mecanico");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel2.setText("Fecha del Turno:");

        BotonCancelar.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        BotonCancelar.setText("Cancelar");
        BotonCancelar.setActionCommand("VOLVER_HOME");

        jLabel18.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel18.setText("Especialidad");

        ComboBoxEspecialidad.setToolTipText("");

        jLabel19.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel19.setText("Hora del Turno:");

        ComboBoxFecha.setToolTipText("");
        ComboBoxFecha.setActionCommand("HORA");
        ComboBoxFecha.setName("BoxFecha"); // NOI18N

        BotonGuardar.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        BotonGuardar.setText("Guardar");
        BotonGuardar.setActionCommand("NUEVO_TURNO");
        BotonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGuardarActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel20.setText("Titular");

        ComboBoxTitular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxTitularActionPerformed(evt);
            }
        });

        BotonAgregarTitular.setText("Agregar Titular");
        BotonAgregarTitular.setActionCommand("TITULAR");
        BotonAgregarTitular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgregarTitularActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Nuevo Turno");

        BotonAgregarVehiculo.setText("Agregar Vehiculo");
        BotonAgregarVehiculo.setActionCommand("VEHICULO");
        BotonAgregarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgregarVehiculoActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel21.setText("Vehiculo");

        ComboBoxVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxVehiculoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 8, Short.MAX_VALUE)
                        .addComponent(jLabel13)))
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(BotonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(107, 107, 107)
                            .addComponent(BotonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ComboBoxHora, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ComboBoxFecha, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BotonAgregarTitular, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(ComboBoxMecanicos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ComboBoxTitular, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BotonAgregarVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(ComboBoxVehiculo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel19)))
                    .addComponent(ComboBoxEspecialidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(106, 106, 106))
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel7)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jLabel13)
                        .addGap(358, 358, 358)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboBoxEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboBoxMecanicos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonAgregarTitular))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboBoxTitular, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonAgregarVehiculo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboBoxVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboBoxFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboBoxHora, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BotonCancelar)
                            .addComponent(BotonGuardar))))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        ComboBoxFecha.getAccessibleContext().setAccessibleName("BoxFecha");

        getAccessibleContext().setAccessibleDescription("Formulario para registrar un turno nuevo");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboBoxTitularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxTitularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxTitularActionPerformed

    private void BotonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonGuardarActionPerformed

    private void BotonAgregarTitularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAgregarTitularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonAgregarTitularActionPerformed

    private void BotonAgregarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAgregarVehiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonAgregarVehiculoActionPerformed

    private void ComboBoxVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxVehiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxVehiculoActionPerformed

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
            java.util.logging.Logger.getLogger(FrmNuevoTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmNuevoTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmNuevoTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmNuevoTurno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmNuevoTurno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAgregarTitular;
    private javax.swing.JButton BotonAgregarVehiculo;
    private javax.swing.JButton BotonCancelar;
    private javax.swing.JButton BotonGuardar;
    private javax.swing.JComboBox<String> ComboBoxEspecialidad;
    private javax.swing.JComboBox<String> ComboBoxFecha;
    private javax.swing.JComboBox<String> ComboBoxHora;
    private javax.swing.JComboBox<String> ComboBoxMecanicos;
    private javax.swing.JComboBox<String> ComboBoxTitular;
    private javax.swing.JComboBox<String> ComboBoxVehiculo;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setControlador(Controlador c, ItemListener ci, DocumentListener dl) {
        this.BotonGuardar.addActionListener(c);
        this.BotonCancelar.addActionListener(c);
        this.BotonAgregarTitular.addActionListener(c);
        this.BotonAgregarVehiculo.addActionListener(c);
        this.ComboBoxEspecialidad.addItemListener(ci);
        this.ComboBoxMecanicos.addItemListener(ci);
        this.ComboBoxFecha.addItemListener(ci);
        this.ComboBoxHora.addItemListener(ci);
        this.ComboBoxTitular.addItemListener(ci);
        this.ComboBoxVehiculo.addItemListener(ci);        
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
        this.ComboBoxMecanicos.removeAllItems();
    }
}
