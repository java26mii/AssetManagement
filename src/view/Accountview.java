/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controllers.AccountController;
import icontrollers.IAccount;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import tools.BCrypt;
import tools.HibernateUtil;

/**
 *
 * @author erik
 */
public class Accountview extends javax.swing.JInternalFrame {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private Session session = null;
    IAccount iac = new AccountController(sessionFactory);
    /**
     * Creates new form Account
     */
    public Accountview() {
        initComponents();
        showTableAccount();
    }
    
    public void resetTextAccount() {
        jid.setText("");
        jusername.setText("");
        jpassword.setText("");
        jsearch.setText("");
        jid.setEditable(true);
        btn_insert.setEnabled(true);
    }
    
    public void showTableAccount(){
        DefaultTableModel model = (DefaultTableModel)tableresult.getModel();        
        Object[] row = new Object[4];
        List<Account> accounts = new ArrayList<>();
        accounts = iac.getAll();
        for (int i = 0; i < accounts.size(); i++) {
            row[0] = i +1;
            row[1] = accounts.get(i).getId();
            row[2] = accounts.get(i).getUsername();
            row[3] = accounts.get(i).getPassword();
            
//                    + " - " + country.get(i).getRegion().getId()
//                    + country.get(i).getRegion().getName();
//                    .getRegionId()
//                    + " - " + countries.get(i).getRegionId().getRegionName();
            
            model.addRow(row);
        }
    }
    
    public void showTableAccount(String keyword) {
        DefaultTableModel model = (DefaultTableModel)tableresult.getModel();
        model.setRowCount(0);
        Object[] row = new Object[4];
        List<Account> account = new ArrayList<>();
        if (keyword == "") {
            account = iac.getAll();
        }
        account = iac.search(keyword);
        for (int i = 0; i < account.size(); i++) {
            row[0] = i + 1;
            row[1] = account.get(i).getId();
            row[2] = account.get(i).getUsername();
            row[3] = account.get(i).getPassword();
            model.addRow(row);
        }
    }
    
    public void updateTableAccount(){       
        DefaultTableModel model = (DefaultTableModel)tableresult.getModel();
        model.setRowCount(0);
        showTableAccount();
    }
    
    public void updateTableAccount(String keyword){       
        DefaultTableModel model = (DefaultTableModel)tableresult.getModel();
        model.setRowCount(0);
        if (keyword == "") {
            showTableAccount();
        }
        showTableAccount(keyword);
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jid = new javax.swing.JTextField();
        jusername = new javax.swing.JTextField();
        jpassword = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableresult = new javax.swing.JTable();
        btn_insert = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jsearch = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Account");

        jLabel2.setText("ID");

        jLabel3.setText("Username");

        jLabel4.setText("Password");

        tableresult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "ID", "Username", "Password"
            }
        ));
        tableresult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableresultMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableresult);

        btn_insert.setText("Insert");
        btn_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertActionPerformed(evt);
            }
        });

        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        jLabel5.setText("Search");

        jsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jsearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(202, 202, 202)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(101, 101, 101)
                                        .addComponent(jid, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel4)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(19, 19, 19)
                                                    .addComponent(btn_insert))))
                                        .addGap(32, 32, 32)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(btn_update)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btn_delete)
                                                .addGap(53, 53, 53)
                                                .addComponent(btn_clear)
                                                .addGap(25, 25, 25))
                                            .addComponent(jusername, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jsearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_insert)
                    .addComponent(btn_delete)
                    .addComponent(btn_update)
                    .addComponent(btn_clear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertActionPerformed
        // TODO add your handling code here:
        if (jid.getText().equals("") || jusername.getText().equals("") || jpassword.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "DATA TIDAK BOLEH KOSONG");
        } else {
            int confirm = JOptionPane.showConfirmDialog(this, "Ingin memasukkan data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, iac.save(jid.getText(), jusername.getText(), jpassword.getText()));
                updateTableAccount("");
                resetTextAccount();
            }
        }
    }//GEN-LAST:event_btn_insertActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        if (jid.getText().equals("") || jusername.getText().equals("") || jpassword.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "DATA TIDAK BOLEH KOSONG");
        } else {
            int confirm = JOptionPane.showConfirmDialog(this, "Ingin mengupdate data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, iac.save(jid.getText(), jusername.getText(), BCrypt.hashpw(jpassword.getText(), BCrypt.gensalt())));
                
                updateTableAccount();
                resetTextAccount();
            }
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "Ingin mengupdate data ?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, iac.delete(jid.getText()));
            updateTableAccount();
            resetTextAccount();
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // TODO add your handling code here:
        resetTextAccount();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void tableresultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableresultMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableresult.getModel();
        int SelectRowIndex = tableresult.getSelectedRow();

        jid.setEditable(false);
        btn_insert.setEnabled(false);
        jid.setText(model.getValueAt(SelectRowIndex, 1).toString());
        jusername.setText(model.getValueAt(SelectRowIndex, 2).toString());
        jpassword.setText(model.getValueAt(SelectRowIndex, 3).toString());
    }//GEN-LAST:event_tableresultMouseClicked

    private void jsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jsearchKeyReleased
        // TODO add your handling code here:
        showTableAccount(jsearch.getText());
        System.out.println(jsearch.getText());
    }//GEN-LAST:event_jsearchKeyReleased


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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jid;
    private javax.swing.JTextField jpassword;
    private javax.swing.JTextField jsearch;
    private javax.swing.JTextField jusername;
    private javax.swing.JTable tableresult;
    // End of variables declaration//GEN-END:variables
}
