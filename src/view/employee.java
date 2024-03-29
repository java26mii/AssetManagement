/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controllers.EmployeeController;
import icontrollers.IEmployee;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author erik
 */
public class employee extends javax.swing.JInternalFrame {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private Session session = null;
    IEmployee iej = new EmployeeController(sessionFactory);
    /**
     * Creates new form employee
     */
    public employee() {
        initComponents();
        showTableEmployee();
    }
    
    public void resetTextEmployee() {
        jid.setText("");
        jfirst_name.setText("");
        jlast_name.setText("");
        jphone_number.setText("");
        jmanager.setText("");
        jemail.setText("");
        jsearch.setText("");
        jid.setEditable(true);
        btn_insert.setEnabled(true);
    }
    
     public void showTableEmployee(){
        DefaultTableModel model = (DefaultTableModel)jTableresult.getModel();        
        Object[] row = new Object[7];
        List<Employee> employees = new ArrayList<>();
        employees = iej.getAll();
        for (int i = 0; i < employees.size(); i++) {
            row[0] = i +1;
            row[1] = employees.get(i).getId();
            row[2] = employees.get(i).getFirstName();
            row[3] = employees.get(i).getLastName();
            row[4] = employees.get(i).getPhoneNumber();
            row[5] = employees.get(i).getManager().getFirstName()+" "+employees.get(i).getManager().getLastName();
            row[6] = employees.get(i).getEmail(); 
            
            
//                    + " - " + country.get(i).getRegion().getId()
//                    + country.get(i).getRegion().getName();
//                    .getRegionId()
//                    + " - " + countries.get(i).getRegionId().getRegionName();
            
            model.addRow(row);
        }
    }
    
    public void showTableEmployee(String keyword) {
        DefaultTableModel model = (DefaultTableModel)jTableresult.getModel();
        model.setRowCount(0);
        Object[] row = new Object[7];
        List<Employee> employees = new ArrayList<>();
        if (keyword == "") {
            employees = iej.getAll();
        }
        employees = iej.search(keyword);
        for (int i = 0; i < employees.size(); i++) {
            row[0] = i + 1;
            row[1] = employees.get(i).getId();
            row[2] = employees.get(i).getFirstName();
            row[3] = employees.get(i).getLastName();
            row[4] = employees.get(i).getPhoneNumber();
            row[5] = employees.get(i).getManager().getFirstName()+" "+employees.get(i).getManager().getLastName();
            row[6] = employees.get(i).getEmail();
            
            
            model.addRow(row);
        }
    }
    
    
    public void updateTableAccount(){       
        DefaultTableModel model = (DefaultTableModel)jTableresult.getModel();
        model.setRowCount(0);
        showTableEmployee();
    }
    
    public void updateTableAccount(String keyword){       
        DefaultTableModel model = (DefaultTableModel)jTableresult.getModel();
        model.setRowCount(0);
        if (keyword == "") {
            showTableEmployee();
        }
        showTableEmployee(keyword);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField4 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jid = new javax.swing.JTextField();
        jfirst_name = new javax.swing.JTextField();
        jlast_name = new javax.swing.JTextField();
        jphone_number = new javax.swing.JTextField();
        jmanager = new javax.swing.JTextField();
        jemail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableresult = new javax.swing.JTable();
        btn_insert = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        jsearch = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        jTextField4.setText("jTextField1");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Employee");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Id");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("First Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Last Name");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Email");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Phone Number");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Manager");

        jphone_number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jphone_numberActionPerformed(evt);
            }
        });

        jTableresult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Id", "First Name", "Last Name", "Phone Number", "Manager", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableresult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableresultMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableresult);

        btn_insert.setText("Insert");
        btn_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertActionPerformed(evt);
            }
        });

        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        jsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsearchActionPerformed(evt);
            }
        });
        jsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jsearchKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(344, 344, 344)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jid, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                                            .addComponent(jfirst_name)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jlast_name)))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jphone_number, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jemail)
                                            .addComponent(jmanager)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(btn_delete)
                                        .addGap(72, 72, 72)
                                        .addComponent(btn_clear))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(215, 215, 215)
                                .addComponent(btn_insert)
                                .addGap(44, 44, 44))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel8)
                                .addGap(32, 32, 32)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jsearch)
                                .addGap(45, 45, 45))
                            .addComponent(btn_update))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jphone_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jfirst_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jmanager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jlast_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_insert)
                    .addComponent(btn_update)
                    .addComponent(btn_delete)
                    .addComponent(btn_clear))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertActionPerformed
        // TODO add your handling code here:
        if (jid.getText().equals("") || jfirst_name.getText().equals("") || jlast_name.getText().equals("") 
                || jphone_number.getText().equals("")|| jmanager.getText().equals("") 
                || jemail.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "DATA TIDAK BOLEH KOSONG");
        } else {
            int confirm = JOptionPane.showConfirmDialog(this, "Ingin mengupdate data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, iej.save(jid.getText(), jfirst_name.getText(), jlast_name.getText(), jemail.getText(), jphone_number.getText(),jmanager.getText()));
                updateTableAccount("");
                resetTextEmployee();
            }
        }
    }//GEN-LAST:event_btn_insertActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        if (jid.getText().equals("") || jfirst_name.getText().equals("") || jlast_name.getText().equals("") 
                || jphone_number.getText().equals("")|| jmanager.getText().equals("") 
                || jemail.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "DATA TIDAK BOLEH KOSONG");
        } else {
            int confirm = JOptionPane.showConfirmDialog(this, "Ingin mengupdate data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, iej.save(jid.getText(), jfirst_name.getText(), jlast_name.getText(),  jemail.getText(), jphone_number.getText(),jmanager.getText()));
                updateTableAccount();
                resetTextEmployee();
            }
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "Ingin mengupdate data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, iej.delete(jid.getText()));
            updateTableAccount();
            resetTextEmployee();
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // TODO add your handling code here:
        resetTextEmployee();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void jsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jsearchActionPerformed

    private void jTableresultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableresultMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTableresult.getModel();
        int SelectRowIndex = jTableresult.getSelectedRow();

        jid.setEditable(false);
        btn_insert.setEnabled(false);
        jid.setText(model.getValueAt(SelectRowIndex, 1).toString());
        jfirst_name.setText(model.getValueAt(SelectRowIndex, 2).toString());
        jlast_name.setText(model.getValueAt(SelectRowIndex, 3).toString());
        jphone_number.setText(model.getValueAt(SelectRowIndex, 4).toString());
        jmanager.setText(model.getValueAt(SelectRowIndex, 5).toString());
        jemail.setText(model.getValueAt(SelectRowIndex, 6).toString());
    }//GEN-LAST:event_jTableresultMouseClicked

    private void jsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jsearchKeyReleased
        // TODO add your handling code here:
        showTableEmployee(jsearch.getText());
        System.out.println(jsearch.getText());
    }//GEN-LAST:event_jsearchKeyReleased

    private void jphone_numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jphone_numberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jphone_numberActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_insert;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableresult;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jemail;
    private javax.swing.JTextField jfirst_name;
    private javax.swing.JTextField jid;
    private javax.swing.JTextField jlast_name;
    private javax.swing.JTextField jmanager;
    private javax.swing.JTextField jphone_number;
    private javax.swing.JTextField jsearch;
    // End of variables declaration//GEN-END:variables
}
