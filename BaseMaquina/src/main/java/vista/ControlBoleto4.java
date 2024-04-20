
package vista;

import brenda.array.Array;
import controlador.ControlBoleto;
import controlador.ControlCategoria;
import controlador.ControlCliente;
import controlador.ControlEquipaje;
import java.rmi.RemoteException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import modelo.Boleto;
import modelo.Cliente;
import modelo.RutaEntity;
import modelo.Tren;
import modelo.TrenEntity;


public class ControlBoleto4 extends javax.swing.JFrame {
    
    ControlBoleto cb;
    ControlCliente cc;
    ControlEquipaje ce;
    ControlCategoria cca;
    DefaultTableModel mt = new DefaultTableModel();

    public ControlBoleto4() {
        try {
            initComponents();
            LocalTime horaActual = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String horaActualString = horaActual.format(formatter);
            cb = new ControlBoleto();
            cc = new ControlCliente();
            ce = new ControlEquipaje();
            cca = new ControlCategoria();
            Cliente cliente = cc.cargarClienteDesdeJSON();
            RutaEntity rutaEntity = ce.cargarClienteDesdeJSON();
            TrenEntity categoria = cca.cargarJSON();
            Boleto boleto = cb.armarBoleto(horaActualString, cliente, rutaEntity, categoria);
            String[] ids = {"fecha", "nombre", "apellido", "telefono1", "telefono2", "inicio", "fin", "trayecto", "id", "categoria", "equipaje", "precio", "tren"};
            mt.setColumnIdentifiers(ids);
            jTable1.setModel(mt);
            Object[] fila = {
                boleto.getFechaCompra(),
                boleto.getCliente().getName(),
                boleto.getCliente().getLastName(),
                boleto.getCliente().getPhoneNumbers().get(0),
                boleto.getCliente().getPhoneNumbers().get(1),
                boleto.getTrayectoria().getInicio(),
                boleto.getTrayectoria().getFin(),
                boleto.getTrayectoria().getTrayecto(),
                boleto.getCliente().getIdentification(),
                boleto.getCategoria(),
                boleto.getEquipaje().getCantidadEquipajes(),
                boleto.getPrecioTotal(),
                boleto.getTren().getIdentificador()
            };
            mt.addRow(fila);
        } catch (RemoteException ex) {
            Logger.getLogger(ControlBoleto4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idFrame10 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        SigFrame = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

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

        SigFrame.setBackground(new java.awt.Color(255, 133, 214));
        SigFrame.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SigFrame.setForeground(new java.awt.Color(153, 0, 102));
        SigFrame.setText("Aceptar");
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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "fechaCompra", "idTren", "nombre", "apellido", "telefono1", "telefono2", "inicio", "destino", "trayecto", "identificacion", "categoria", "equipaje", "precioTotal"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(455, 455, 455)
                        .addComponent(SigFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(579, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 305, Short.MAX_VALUE)
                .addComponent(SigFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(73, 73, 73)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(109, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void idFrame10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFrame10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFrame10ActionPerformed

    private void SigFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SigFrameActionPerformed
    }//GEN-LAST:event_SigFrameActionPerformed

    private void SigFrameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SigFrameMouseClicked

    }//GEN-LAST:event_SigFrameMouseClicked

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ControlBoleto4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControlBoleto4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControlBoleto4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControlBoleto4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControlBoleto4().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SigFrame;
    private javax.swing.JTextField idFrame10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
