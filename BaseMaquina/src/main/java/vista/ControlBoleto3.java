
package vista;

import controlador.ControlCategoria;
import controlador.ControlTren;
import javax.swing.JOptionPane;
import modelo.Categoria;
import modelo.Tren;


public class ControlBoleto3 extends javax.swing.JFrame {
    
    ControlTren ct;
    Categoria categoria1;
    ControlCategoria cc;

    public ControlBoleto3() {
        initComponents();
        ct = new ControlTren();
        categoria1 = new Categoria();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idFrame10 = new javax.swing.JTextField();
        cantFrame = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        trenFrame = new javax.swing.JTextField();
        secFrame = new javax.swing.JTextField();
        SigFrame = new javax.swing.JButton();
        verTrenesFrame = new javax.swing.JButton();
        CateFrame = new javax.swing.JComboBox<>();
        vagonesFrame = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        vagFrame = new javax.swing.JTextField();

        idFrame10.setBackground(new java.awt.Color(255, 153, 204));
        idFrame10.setForeground(new java.awt.Color(102, 0, 102));
        idFrame10.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 0, 153), new java.awt.Color(204, 0, 153)));
        idFrame10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFrame10ActionPerformed(evt);
            }
        });

        cantFrame.setBackground(new java.awt.Color(255, 153, 204));
        cantFrame.setForeground(new java.awt.Color(102, 0, 102));
        cantFrame.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2" }));
        cantFrame.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 0, 153), new java.awt.Color(204, 0, 153)));
        cantFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantFrameActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 183, 216));

        jPanel2.setBackground(new java.awt.Color(255, 234, 244));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 0, 153), new java.awt.Color(204, 0, 153)));

        jLabel2.setBackground(new java.awt.Color(204, 0, 153));
        jLabel2.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 153));
        jLabel2.setText("Comprar boleto");

        jLabel7.setBackground(new java.awt.Color(204, 0, 153));
        jLabel7.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 153));
        jLabel7.setText("Llene los siguientes datos sobre el tren");

        jLabel8.setBackground(new java.awt.Color(204, 0, 153));
        jLabel8.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 153));
        jLabel8.setText("Tren:");

        jLabel9.setBackground(new java.awt.Color(204, 0, 153));
        jLabel9.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 153));
        jLabel9.setText("Categoria:");

        jLabel10.setBackground(new java.awt.Color(204, 0, 153));
        jLabel10.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 153));
        jLabel10.setText("Sección:");

        trenFrame.setBackground(new java.awt.Color(255, 153, 204));
        trenFrame.setForeground(new java.awt.Color(102, 0, 102));
        trenFrame.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 0, 153), new java.awt.Color(204, 0, 153)));
        trenFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trenFrameActionPerformed(evt);
            }
        });

        secFrame.setBackground(new java.awt.Color(255, 153, 204));
        secFrame.setForeground(new java.awt.Color(102, 0, 102));
        secFrame.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 0, 153), new java.awt.Color(204, 0, 153)));
        secFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secFrameActionPerformed(evt);
            }
        });

        SigFrame.setBackground(new java.awt.Color(255, 133, 214));
        SigFrame.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SigFrame.setForeground(new java.awt.Color(153, 0, 102));
        SigFrame.setText("Siguiente");
        SigFrame.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 0, 153), new java.awt.Color(204, 0, 153)));
        SigFrame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SigFrameMouseClicked(evt);
            }
        });
        SigFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SigFrameActionPerformed(evt);
            }
        });

        verTrenesFrame.setBackground(new java.awt.Color(255, 133, 214));
        verTrenesFrame.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        verTrenesFrame.setForeground(new java.awt.Color(153, 0, 102));
        verTrenesFrame.setText("Trenes");
        verTrenesFrame.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 0, 153), new java.awt.Color(204, 0, 153)));
        verTrenesFrame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verTrenesFrameMouseClicked(evt);
            }
        });
        verTrenesFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verTrenesFrameActionPerformed(evt);
            }
        });

        CateFrame.setBackground(new java.awt.Color(255, 153, 204));
        CateFrame.setForeground(new java.awt.Color(102, 0, 102));
        CateFrame.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estandar", "Ejecutivo", "Premium" }));
        CateFrame.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 0, 153), new java.awt.Color(204, 0, 153)));
        CateFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CateFrameActionPerformed(evt);
            }
        });

        vagonesFrame.setBackground(new java.awt.Color(255, 133, 214));
        vagonesFrame.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        vagonesFrame.setForeground(new java.awt.Color(153, 0, 102));
        vagonesFrame.setText("Secciones");
        vagonesFrame.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 0, 153), new java.awt.Color(204, 0, 153)));
        vagonesFrame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vagonesFrameMouseClicked(evt);
            }
        });
        vagonesFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vagonesFrameActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(204, 0, 153));
        jLabel11.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 153));
        jLabel11.setText("Vagón:");

        vagFrame.setBackground(new java.awt.Color(255, 153, 204));
        vagFrame.setForeground(new java.awt.Color(102, 0, 102));
        vagFrame.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 0, 153), new java.awt.Color(204, 0, 153)));
        vagFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vagFrameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(CateFrame, 0, 100, Short.MAX_VALUE)
                                    .addComponent(trenFrame))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(verTrenesFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(vagFrame, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(secFrame, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(vagonesFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel7)))
                .addGap(37, 37, 37))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(SigFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(trenFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verTrenesFrame, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CateFrame))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vagFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(secFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vagonesFrame, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addComponent(SigFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(235, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void trenFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trenFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_trenFrameActionPerformed

    private void secFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_secFrameActionPerformed

    private void idFrame10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFrame10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFrame10ActionPerformed

    private void SigFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SigFrameActionPerformed
    }//GEN-LAST:event_SigFrameActionPerformed

    private void SigFrameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SigFrameMouseClicked
        String idTren = trenFrame.getText();
        Tren tren = ct.seleccionarTren(idTren);
        String categoria = (String) CateFrame.getSelectedItem();
        String seccion = secFrame.getText();
        String vagon = vagFrame.getText();
        cc = new ControlCategoria(tren);
        cc.seleccionarPuesto(Integer.parseInt(vagon), categoria, Integer.parseInt(seccion));
        cc.guardarClienteEnJSON(tren, Integer.parseInt(vagon), categoria, Integer.parseInt(seccion),cc.valor());
        ControlBoleto4 cbb = new ControlBoleto4();
        cbb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_SigFrameMouseClicked

    private void verTrenesFrameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verTrenesFrameMouseClicked
       VerTrenes vr = new VerTrenes();
       vr.setVisible(true);
    }//GEN-LAST:event_verTrenesFrameMouseClicked

    private void verTrenesFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verTrenesFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_verTrenesFrameActionPerformed

    private void cantFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantFrameActionPerformed

    private void CateFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CateFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CateFrameActionPerformed

    private void vagonesFrameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vagonesFrameMouseClicked
        JOptionPane.showMessageDialog(this, categoria1.mostrarVagonesDisponibles());
    }//GEN-LAST:event_vagonesFrameMouseClicked

    private void vagonesFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vagonesFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vagonesFrameActionPerformed

    private void vagFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vagFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vagFrameActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ControlBoleto3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControlBoleto3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControlBoleto3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControlBoleto3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControlBoleto3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CateFrame;
    private javax.swing.JButton SigFrame;
    private javax.swing.JComboBox<String> cantFrame;
    private javax.swing.JTextField idFrame10;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField secFrame;
    private javax.swing.JTextField trenFrame;
    private javax.swing.JTextField vagFrame;
    private javax.swing.JButton vagonesFrame;
    private javax.swing.JButton verTrenesFrame;
    // End of variables declaration//GEN-END:variables
}
