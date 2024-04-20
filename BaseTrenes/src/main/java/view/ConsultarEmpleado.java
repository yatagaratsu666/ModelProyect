package view;

import brenda.array.Array;
import brenda.listsingly.LinkedList;
import controlador.ControlEmpleado;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Employee;

/**
 *
 * @author BRENDA
 */
public class ConsultarEmpleado extends javax.swing.JFrame {

    ControlEmpleado cee = new ControlEmpleado();
    DefaultTableModel mt;
    LinkedList<Employee> le = new LinkedList<>();
    Array<String> array;
    Array<String> array1;

    public ConsultarEmpleado() throws RemoteException {
        initComponents();
        mt = new DefaultTableModel();

        String[] esc = {"id", "inicio", "destino", "telefono1","telefono2","user","contraseña"};
        mt.setColumnIdentifiers(esc);
        jTableE.setModel(mt);
        le = cee.consultarDisponibles();
        cargarRutasEnTabla(le);
    }

    private void cargarRutasEnTabla(LinkedList<Employee> employee) {
        for (int i = 0; i < employee.size(); i++) {
            Object[] fila = {
                employee.get(i).getId(),
                employee.get(i).getName(),
                employee.get(i).getLastName(),
                employee.get(i).getPhoneNumbers().get(0),
                employee.get(i).getPhoneNumbers().get(1),
                employee.get(i).getUser(),
                employee.get(i).getPassword()
            };
            mt.addRow(fila);
        }
    }
    
    private void reload(){
        try {
            ConsultarEmpleado sce = new ConsultarEmpleado();
            sce.setVisible(true);
            this.dispose();
        } catch (RemoteException ex) {
            Logger.getLogger(ConsultarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        modificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableE = new javax.swing.JTable();
        borrar = new javax.swing.JButton();
        crear = new javax.swing.JButton();
        idFrame = new javax.swing.JTextField();
        nameFrame = new javax.swing.JTextField();
        lastFrame = new javax.swing.JTextField();
        dosFrame = new javax.swing.JTextField();
        unoFrame = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        salirFrame = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        userFrame = new javax.swing.JTextField();
        passFrame = new javax.swing.JTextField();

        jButton1.setText("jButton1");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 153));
        jLabel8.setText("*+:｡.｡");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 153));
        jLabel9.setText("*+:｡.｡");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 183, 216));

        jPanel4.setBackground(new java.awt.Color(255, 234, 244));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 0, 153), new java.awt.Color(204, 0, 153)));

        modificar.setBackground(new java.awt.Color(255, 133, 214));
        modificar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        modificar.setForeground(new java.awt.Color(153, 0, 102));
        modificar.setText("Modificar");
        modificar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 0, 153), new java.awt.Color(204, 0, 153)));
        modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modificarMouseClicked(evt);
            }
        });
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        jTableE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "nombre", "apellido", "id", "contraseña", "telefono1", "telefono2"
            }
        ));
        jScrollPane1.setViewportView(jTableE);

        borrar.setBackground(new java.awt.Color(255, 133, 214));
        borrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        borrar.setForeground(new java.awt.Color(153, 0, 102));
        borrar.setText("Borrar");
        borrar.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 0, 153), new java.awt.Color(204, 0, 153)));
        borrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                borrarMouseClicked(evt);
            }
        });
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });

        crear.setBackground(new java.awt.Color(255, 133, 214));
        crear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        crear.setForeground(new java.awt.Color(153, 0, 102));
        crear.setText("Crear");
        crear.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 0, 153), new java.awt.Color(204, 0, 153)));
        crear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crearMouseClicked(evt);
            }
        });
        crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearActionPerformed(evt);
            }
        });

        idFrame.setBackground(new java.awt.Color(255, 153, 204));
        idFrame.setForeground(new java.awt.Color(102, 0, 102));
        idFrame.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 0, 153), new java.awt.Color(204, 0, 153)));
        idFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFrameActionPerformed(evt);
            }
        });

        nameFrame.setBackground(new java.awt.Color(255, 153, 204));
        nameFrame.setForeground(new java.awt.Color(102, 0, 102));
        nameFrame.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 0, 153), new java.awt.Color(204, 0, 153)));
        nameFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFrameActionPerformed(evt);
            }
        });

        lastFrame.setBackground(new java.awt.Color(255, 153, 204));
        lastFrame.setForeground(new java.awt.Color(102, 0, 102));
        lastFrame.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 0, 153), new java.awt.Color(204, 0, 153)));
        lastFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastFrameActionPerformed(evt);
            }
        });

        dosFrame.setBackground(new java.awt.Color(255, 153, 204));
        dosFrame.setForeground(new java.awt.Color(102, 0, 102));
        dosFrame.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 0, 153), new java.awt.Color(204, 0, 153)));
        dosFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dosFrameActionPerformed(evt);
            }
        });

        unoFrame.setBackground(new java.awt.Color(255, 153, 204));
        unoFrame.setForeground(new java.awt.Color(102, 0, 102));
        unoFrame.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 0, 153), new java.awt.Color(204, 0, 153)));
        unoFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unoFrameActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 153));
        jLabel12.setText("ID:");

        jLabel14.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 153));
        jLabel14.setText("Nombre:");

        jLabel13.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 153));
        jLabel13.setText("Apellido:");

        jLabel17.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 153));
        jLabel17.setText("Numero2:");

        jLabel18.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 0, 153));
        jLabel18.setText("Numero1:");

        jLabel7.setFont(new java.awt.Font("Segoe Print", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 0, 153));
        jLabel7.setText("Consultar Empleado");

        salirFrame.setBackground(new java.awt.Color(255, 133, 214));
        salirFrame.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        salirFrame.setForeground(new java.awt.Color(153, 0, 102));
        salirFrame.setText("Salir");
        salirFrame.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 0, 153), new java.awt.Color(204, 0, 153)));
        salirFrame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salirFrameMouseClicked(evt);
            }
        });
        salirFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirFrameActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 153));
        jLabel19.setText("User:");

        jLabel20.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 0, 153));
        jLabel20.setText("Contraseña:");

        userFrame.setBackground(new java.awt.Color(255, 153, 204));
        userFrame.setForeground(new java.awt.Color(102, 0, 102));
        userFrame.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 0, 153), new java.awt.Color(204, 0, 153)));
        userFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userFrameActionPerformed(evt);
            }
        });

        passFrame.setBackground(new java.awt.Color(255, 153, 204));
        passFrame.setForeground(new java.awt.Color(102, 0, 102));
        passFrame.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 0, 153), new java.awt.Color(204, 0, 153)));
        passFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passFrameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(salirFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap(16, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(unoFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lastFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(idFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nameFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel17)
                            .addComponent(jLabel20)
                            .addComponent(borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dosFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(userFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(crear, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 21, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(idFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(nameFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(lastFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(unoFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(dosFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(userFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(passFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salirFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(crear, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(107, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modificarMouseClicked
        String id = idFrame.getText();
        String names = nameFrame.getText();
        String lastName = lastFrame.getText();
        String tel1 = unoFrame.getText();
        String tel2 = dosFrame.getText();
        String user = userFrame.getText();
        String pass = passFrame.getText();
        array1 = new Array(2);
        array1.add(tel1);
        array1.add(tel2);
        Employee employee = new Employee(names, lastName, array1, id, user, pass);
        cee.modificarRecorrido(id, employee);
        reload();
    }//GEN-LAST:event_modificarMouseClicked

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed

    }//GEN-LAST:event_modificarActionPerformed

    private void borrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrarMouseClicked
       String id = JOptionPane.showInputDialog("Ingrese el id:");
       cee.eliminar(id);
       reload();
    }//GEN-LAST:event_borrarMouseClicked

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_borrarActionPerformed

    private void crearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearMouseClicked
      String id = idFrame.getText();
      String names = nameFrame.getText();
      String lastName = lastFrame.getText();
      String tel1 = unoFrame.getText();
      String tel2 = dosFrame.getText();
      String user = userFrame.getText();
      String pass = passFrame.getText();
      array = new Array(2);
      array.add(tel1);
      array.add(tel2);
      Employee employee = new Employee(names, lastName, array, id, user, pass);
      cee.agregarEnLista(employee);
      reload();
    }//GEN-LAST:event_crearMouseClicked

    private void crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearActionPerformed

    }//GEN-LAST:event_crearActionPerformed

    private void idFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFrameActionPerformed

    private void nameFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFrameActionPerformed

    private void lastFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastFrameActionPerformed

    private void dosFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dosFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dosFrameActionPerformed

    private void unoFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unoFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unoFrameActionPerformed

    private void salirFrameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirFrameMouseClicked
        ControlFrame cf;
        try {
            cf = new ControlFrame();
            cf.setVisible(true);
            this.dispose();
        } catch (RemoteException ex) {
            Logger.getLogger(ConsultarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_salirFrameMouseClicked

    private void salirFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salirFrameActionPerformed

    private void userFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userFrameActionPerformed

    private void passFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passFrameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passFrameActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new ConsultarEmpleado().setVisible(true);
            } catch (RemoteException ex) {
                Logger.getLogger(ConsultarEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrar;
    private javax.swing.JButton crear;
    private javax.swing.JTextField dosFrame;
    private javax.swing.JTextField idFrame;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableE;
    private javax.swing.JTextField lastFrame;
    private javax.swing.JButton modificar;
    private javax.swing.JTextField nameFrame;
    private javax.swing.JTextField passFrame;
    private javax.swing.JButton salirFrame;
    private javax.swing.JTextField unoFrame;
    private javax.swing.JTextField userFrame;
    // End of variables declaration//GEN-END:variables
}
