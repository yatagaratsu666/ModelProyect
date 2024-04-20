
package vista;


import brenda.listsingly.LinkedList;
import controlador.ControlCliente;
import controlador.ControlEquipaje;
import controlador.ControlRuta;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Equipaje;


public class ControlBoleto2 extends javax.swing.JFrame {
    
    ControlRuta cr;
    DefaultTableModel mt;
    LinkedList<String> trayectoria;
    String trayecto = "";
    float precio = 0;
    
    ControlEquipaje ce;
    public ControlBoleto2() {
        initComponents();
        try {
            cr = new ControlRuta();
            ce = new ControlEquipaje();
        } catch (RemoteException ex) {
            Logger.getLogger(ControlBoleto2.class.getName()).log(Level.SEVERE, null, ex);
        }
        mt = new DefaultTableModel();
    }
    
    public void reload(){
        ControlBoleto3 cb = new ControlBoleto3();
        cb.setVisible(true);
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idFrame10 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        finFrame = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        inicioFrame = new javax.swing.JTextField();
        trayeFrame = new javax.swing.JTextField();
        RutaFrame = new javax.swing.JButton();
        SigFrame1 = new javax.swing.JButton();
        SigFrame = new javax.swing.JButton();
        RecoFrame = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        peFrame = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        pe2Frame = new javax.swing.JTextField();
        cantFrame = new javax.swing.JComboBox<>();

        idFrame10.setBackground(new java.awt.Color(255, 153, 204));
        idFrame10.setForeground(new java.awt.Color(102, 0, 102));
        idFrame10.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 0, 153), new java.awt.Color(204, 0, 153)));
        idFrame10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFrame10ActionPerformed(evt);
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

        finFrame.setBackground(new java.awt.Color(255, 153, 204));
        finFrame.setForeground(new java.awt.Color(102, 0, 102));
        finFrame.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 0, 153), new java.awt.Color(204, 0, 153)));
        finFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finFrameActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(204, 0, 153));
        jLabel7.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 153));
        jLabel7.setText("Llene los datos de su trayectoria y equipaje");

        jLabel8.setBackground(new java.awt.Color(204, 0, 153));
        jLabel8.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 153));
        jLabel8.setText("Inicio:");

        jLabel9.setBackground(new java.awt.Color(204, 0, 153));
        jLabel9.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 153));
        jLabel9.setText("Fin:");

        jLabel10.setBackground(new java.awt.Color(204, 0, 153));
        jLabel10.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 153));
        jLabel10.setText("Trayectoria:");

        inicioFrame.setBackground(new java.awt.Color(255, 153, 204));
        inicioFrame.setForeground(new java.awt.Color(102, 0, 102));
        inicioFrame.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 0, 153), new java.awt.Color(204, 0, 153)));
        inicioFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioFrameActionPerformed(evt);
            }
        });

        trayeFrame.setBackground(new java.awt.Color(255, 153, 204));
        trayeFrame.setForeground(new java.awt.Color(102, 0, 102));
        trayeFrame.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 0, 153), new java.awt.Color(204, 0, 153)));
        trayeFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trayeFrameActionPerformed(evt);
            }
        });

        RutaFrame.setBackground(new java.awt.Color(255, 133, 214));
        RutaFrame.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        RutaFrame.setForeground(new java.awt.Color(153, 0, 102));
        RutaFrame.setText("Rutas");
        RutaFrame.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 0, 153), new java.awt.Color(204, 0, 153)));
        RutaFrame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RutaFrameMouseClicked(evt);
            }
        });
        RutaFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RutaFrameActionPerformed(evt);
            }
        });

        SigFrame1.setBackground(new java.awt.Color(255, 133, 214));
        SigFrame1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SigFrame1.setForeground(new java.awt.Color(153, 0, 102));
        SigFrame1.setText("Atras");
        SigFrame1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 0, 153), new java.awt.Color(204, 0, 153)));
        SigFrame1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SigFrame1MouseClicked(evt);
            }
        });
        SigFrame1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SigFrame1ActionPerformed(evt);
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

        RecoFrame.setBackground(new java.awt.Color(255, 133, 214));
        RecoFrame.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        RecoFrame.setForeground(new java.awt.Color(153, 0, 102));
        RecoFrame.setText("Recomendar Ruta");
        RecoFrame.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 0, 153), new java.awt.Color(204, 0, 153)));
        RecoFrame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RecoFrameMouseClicked(evt);
            }
        });
        RecoFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecoFrameActionPerformed(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(204, 0, 153));
        jLabel13.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 153));
        jLabel13.setText("Cantidad:");

        jLabel14.setBackground(new java.awt.Color(204, 0, 153));
        jLabel14.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 153));
        jLabel14.setText("Peso 1:");

        peFrame.setBackground(new java.awt.Color(255, 153, 204));
        peFrame.setForeground(new java.awt.Color(102, 0, 102));
        peFrame.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 0, 153), new java.awt.Color(204, 0, 153)));
        peFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peFrameActionPerformed(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(204, 0, 153));
        jLabel15.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 0, 153));
        jLabel15.setText("Peso 2:");

        pe2Frame.setBackground(new java.awt.Color(255, 153, 204));
        pe2Frame.setForeground(new java.awt.Color(102, 0, 102));
        pe2Frame.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 0, 153), new java.awt.Color(204, 0, 153)));
        pe2Frame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pe2FrameActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(SigFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(SigFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(finFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(inicioFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(trayeFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(RutaFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(41, 41, 41)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel15))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(peFrame)
                                            .addComponent(pe2Frame, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                            .addComponent(cantFrame, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(39, 39, 39))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(RecoFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inicioFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RutaFrame)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantFrame))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(finFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(peFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(trayeFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pe2Frame, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(RecoFrame)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SigFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SigFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
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

    private void finFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_finFrameActionPerformed

    private void inicioFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inicioFrameActionPerformed

    private void trayeFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trayeFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_trayeFrameActionPerformed

    private void idFrame10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFrame10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFrame10ActionPerformed

    private void RutaFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RutaFrameActionPerformed
    }//GEN-LAST:event_RutaFrameActionPerformed

    private void RutaFrameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RutaFrameMouseClicked
        VerRutas vr = new VerRutas();
        vr.setVisible(true);
    }//GEN-LAST:event_RutaFrameMouseClicked

    private void SigFrame1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SigFrame1MouseClicked
        ControlBoleto1 cb = new ControlBoleto1();
        cb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_SigFrame1MouseClicked

    private void SigFrame1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SigFrame1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SigFrame1ActionPerformed

    private void SigFrameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SigFrameMouseClicked
        String inicio = inicioFrame.getText();
        String fin = finFrame.getText();
        String traza = trayeFrame.getText();
        String cant = (String) cantFrame.getSelectedItem();
        String peso1 = peFrame.getText();
        String peso2 = pe2Frame.getText();

        trayectoria = cr.seleccionEstaciones(inicio, fin, traza);
        precio = cr.totalWeight();

        if (trayectoria.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La trayectoria " + traza + " no existe");
        } else {
            StringBuilder trayec = new StringBuilder();
            for (int i = 0; i < trayectoria.size(); i++) {
                trayec.append(trayectoria.get(i));
            }
            trayecto = trayec.toString();

            if (Integer.parseInt(cant) == 1) {
                if (!ce.agregarClienteSiVacioModificarSiNo(Integer.parseInt(cant), Integer.parseInt(peso1), inicio, fin, trayecto, precio)) {
                    JOptionPane.showMessageDialog(this, "No fue posible guardar");
                }else{
                    reload();
                }
            } else if (Integer.parseInt(cant) == 2) {
                int pesoTotal = Integer.parseInt(peso1) + Integer.parseInt(peso2);
                if (!ce.agregarClienteSiVacioModificarSiNo(Integer.parseInt(cant), pesoTotal, inicio, fin, trayecto, precio)) {
                    JOptionPane.showMessageDialog(this, "No fue posible guardar");
                }else{
                    reload();
                }
            } else {
                JOptionPane.showMessageDialog(this, "La cantidad de equipajes seleccionada no es válida");
            }
        }
    }//GEN-LAST:event_SigFrameMouseClicked

    private void SigFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SigFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SigFrameActionPerformed

    private void RecoFrameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RecoFrameMouseClicked
        String inicio = inicioFrame.getText();
        String fin = finFrame.getText();
        trayectoria = cr.rutaRecomendada(inicio, fin);
        if (trayectoria == null) {
            JOptionPane.showMessageDialog(null, "La ruta no es posible");
        } else {
            StringBuilder trayec = new StringBuilder();
            for (int i = 0; i < trayectoria.size(); i++) {
                trayec.append(trayectoria.get(i));
            }
            trayecto = trayec.toString();
            trayeFrame.setText(trayecto);
            cr.totalWeight();
        }
    }//GEN-LAST:event_RecoFrameMouseClicked

    private void RecoFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecoFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RecoFrameActionPerformed

    private void peFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_peFrameActionPerformed

    private void pe2FrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pe2FrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pe2FrameActionPerformed

    private void cantFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantFrameActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ControlBoleto2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControlBoleto2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControlBoleto2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControlBoleto2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControlBoleto2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RecoFrame;
    private javax.swing.JButton RutaFrame;
    private javax.swing.JButton SigFrame;
    private javax.swing.JButton SigFrame1;
    private javax.swing.JComboBox<String> cantFrame;
    private javax.swing.JTextField finFrame;
    private javax.swing.JTextField idFrame10;
    private javax.swing.JTextField inicioFrame;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField pe2Frame;
    private javax.swing.JTextField peFrame;
    private javax.swing.JTextField trayeFrame;
    // End of variables declaration//GEN-END:variables
}
