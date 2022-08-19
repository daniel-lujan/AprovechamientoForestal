package co.gov.minambiente.vista.formulario;

import co.gov.minambiente.controlador.ControladorSolicitud;
import co.gov.minambiente.vista.formulario.Seccion5_2;
import java.awt.Point;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

/**
 *
 * @author Natalia García
 */
public class Seccion5_1 extends javax.swing.JFrame {

    private ControladorSolicitud controlador;

    public Seccion5_1() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public Seccion5_1(ControladorSolicitud controlador) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.controlador = controlador;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnSiguiente1 = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cmbMetodoA = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEspecies = new javax.swing.JTable();
        jLabel34 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtUso = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setText("    flora silvestre y los productos forestales no maderables");

        btnSiguiente1.setText("Siguiente");
        btnSiguiente1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSiguiente1MouseClicked(evt);
            }
        });
        btnSiguiente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguiente1ActionPerformed(evt);
            }
        });

        btnAnterior.setText("Anterior");
        btnAnterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAnteriorMouseClicked(evt);
            }
        });
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel13.setText("       sostenible de flora silvestre y los productos forestales no maderables y método");

        jLabel15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel15.setText("Indique el uso que se pretende dar a los productos a obtener:");

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel2.setText("5. Información sobre el aprovechamiento forestal o manejo sostenible de la");

        jLabel20.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel20.setText("5.1. Información de las especies objeto de la solicitud de aprovechamiento forestal o manejo");

        cmbMetodoA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Mecánico", "Manual", "Mecánico-Manual" }));

        jLabel21.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel21.setText("Método de aprovechamiento o manejo sostenible:");

        tblEspecies.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Short((short) 1), null, null, null, null, null, null, null, null},
                { new Short((short) 2), null, null, null, null, null, null, null, null},
                { new Short((short) 3), null, null, null, null, null, null, null, null},
                { new Short((short) 4), null, null, null, null, null, null, null, null},
                { new Short((short) 5), null, null, null, null, null, null, null, null},
                { new Short((short) 6), null, null, null, null, null, null, null, null},
                { new Short((short) 7), null, null, null, null, null, null, null, null},
                { new Short((short) 8), null, null, null, null, null, null, null, null},
                { new Short((short) 9), null, null, null, null, null, null, null, null},
                { new Short((short) 10), null, null, null, null, null, null, null, null}
            },
            new String [] {
                "#", "Cantidad", "Unidad de medida", "Nombre Común", "Nombre Científico", "Parte Aprovechada", "Hábito", "Veda", "Categoría de Amenaza"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Short.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEspecies.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblEspeciesMousePressed(evt);
            }
        });
        tblEspecies.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tblEspeciesKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tblEspecies);

        jLabel34.setFont(new java.awt.Font("Arial Narrow", 2, 13)); // NOI18N
        jLabel34.setText("Nota: Para los aprovechamientos forestales únicos la información sobre el volumen corresponde a la establecida por el inventario estadístico.");

        jLabel33.setFont(new java.awt.Font("Arial Narrow", 2, 13)); // NOI18N
        jLabel33.setText("*Unidad de medida: Metros cúbicos, toneladas, kilogramos, gramos, miligramos, entre otros.");
        jLabel33.setToolTipText("");

        jLabel17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel17.setText("Especies objeto de la solicitud:");

        txtUso.setColumns(20);
        txtUso.setLineWrap(true);
        txtUso.setRows(5);
        txtUso.setWrapStyleWord(true);
        txtUso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsoKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txtUso);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 878, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel13)
                            .addComponent(jLabel20)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbMetodoA, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel17)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnAnterior)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSiguiente1))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)))
                .addGap(4, 4, 4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel13))
                    .addComponent(jLabel20))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(cmbMetodoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnterior)
                    .addComponent(btnSiguiente1))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 862, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiguiente1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSiguiente1MouseClicked
        String[][] datosTabla = new String[tblEspecies.getRowCount() - 1][tblEspecies.getColumnCount() - 1];

        for (int row = 1; row < tblEspecies.getRowCount(); row++) {
            for (int column = 1; column < tblEspecies.getColumnCount(); column++) {
                if (tblEspecies.getValueAt(row, column) == null) {
                    datosTabla[row - 1][column - 1] = "";
                } else {
                    datosTabla[row - 1][column - 1] = (String) tblEspecies.getValueAt(row, column);
                }
            }
        }

        String metodo = (String) cmbMetodoA.getSelectedItem();
        String uso = txtUso.getText().trim();

        if (!metodo.equals("Seleccione") && !uso.equals("")) {
            controlador.guardarInformacionSeccion5_1(metodo, datosTabla, uso);
            this.setVisible(false);
            controlador.mostrarSeccion5_2();
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese todos los datos solicitados.");
        }
    }//GEN-LAST:event_btnSiguiente1MouseClicked

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        this.setVisible(false);
        controlador.mostrarSeccion4_2();
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnAnteriorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnteriorMouseClicked

    }//GEN-LAST:event_btnAnteriorMouseClicked

    private void txtUsoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsoKeyTyped
        if (txtUso.getText().length() >= 150) {
            evt.consume();
        }
    }//GEN-LAST:event_txtUsoKeyTyped

    private void btnSiguiente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguiente1ActionPerformed

    }//GEN-LAST:event_btnSiguiente1ActionPerformed

    private void tblEspeciesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblEspeciesKeyTyped

    }//GEN-LAST:event_tblEspeciesKeyTyped

    private void tblEspeciesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEspeciesMousePressed
        /**if (evt.getClickCount() > 1) {
            Point point = evt.getPoint();
            int row = tblEspecies.rowAtPoint(point);
            int column = tblEspecies.columnAtPoint(point);
            TableModel model = tblEspecies.getModel();
            JOptionPane.showMessageDialog(this, model.getValueAt(row, column));
        }**/
    }//GEN-LAST:event_tblEspeciesMousePressed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Seccion5_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAnterior;
    public javax.swing.JButton btnSiguiente1;
    public javax.swing.JComboBox<String> cmbMetodoA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTable tblEspecies;
    public javax.swing.JTextArea txtUso;
    // End of variables declaration//GEN-END:variables
}
