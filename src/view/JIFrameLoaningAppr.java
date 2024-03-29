/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controllers.AssetController;
import controllers.LoaningController;
import controllers.LoaningStatusController;
import controllers.RepairController;
import controllers.RepairStatusController;
import controllers.RoleController;
import controllers.StatusController;
import icontrollers.IAssetController;
import icontrollers.ILoaningController;
import icontrollers.ILoaningStatusController;
import icontrollers.IRepairController;
import icontrollers.IRepairStatusController;
import icontrollers.IRoleController;
import icontrollers.IStatusController;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Asset;
import models.Loaning;
import models.LoaningStatus;
import models.Repair;
import models.RepairStatus;
import models.Role;
import models.Status;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author WINDOWS 10
 */
public class JIFrameLoaningAppr extends javax.swing.JInternalFrame {

    DefaultTableModel model = new DefaultTableModel();
    SessionFactory factory = HibernateUtil.getSessionFactory();
    ILoaningStatusController lsco = new LoaningStatusController(factory);
    IRepairController reco = new RepairController(factory);

    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

    public JIFrameLoaningAppr() {
        initComponents();
        tblLStatus.setModel(model);
        model.addColumn("No");
        model.addColumn("Repair Date");
        model.addColumn("Loaning Status ID");
        model.addColumn("Loaning");
        model.addColumn("Status");
        getStatus();
        getLoaning();

        showTable("");
    }

    public void resetText() {
        jId.setText("");
        jStatus.setSelectedIndex(0);
        jLoaning.setSelectedIndex(0);
        jDate.setDate(null);
        btnSave.setEnabled(true);

//        btnUpdate.setEnabled(true);
    }

    private void getStatus() {
        for (Status status : new StatusController(factory).getAll()) {
            jStatus.addItem(status.getId() + "-" + status.getName());
        }
    }

    private void getLoaning() {
        for (Loaning loaning : new LoaningController(factory).getAll()) {
            jLoaning.addItem(loaning.getId() + "-" + loaning.getAsset().getName());
        }
    }

    public void showTable(String key) {
        DefaultTableModel model = (DefaultTableModel) tblLStatus.getModel();
        model.setRowCount(0);
        Object[] row = new Object[12];
        List<LoaningStatus> lstatus = new ArrayList<>();
        if (key == "") {
            lstatus = lsco.getAll();
        }
        lstatus = lsco.search(key);
//        emp = eco.search(key);

        for (int i = 0; i < lstatus.size(); i++) {
            row[0] = i + 1;
            row[1] = lstatus.get(i).getId();
            row[2] = formatter.format(lstatus.get(i).getDateLoaning());
            row[3] = lstatus.get(i).getStatus().getName();
            row[4] = lstatus.get(i).getLoaning().getAsset().getName();
//            if (lstatus.get(i).getLoaning()== null) {
//                row[4] = "";
//            } else {
//                row[4] = lstatus.get(i).getLoaning().getAsset().getName();
//            }
            model.addRow(row);
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLStatus = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jSearch = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jId = new javax.swing.JTextField();
        jStatus = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jDate = new com.toedter.calendar.JDateChooser();
        jLoaning = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        BTN_SETUJU = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jLabel1.setText("LOANING STATUS");

        tblLStatus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblLStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLStatusMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLStatus);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Search");

        jSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSearchActionPerformed(evt);
            }
        });
        jSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jSearchKeyTyped(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel2.setText("APPROVAL ID");

        jLabel4.setText("STATUS");

        jLabel5.setText("LOANING");

        jId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jIdActionPerformed(evt);
            }
        });

        jStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CHOOSE", " " }));

        jLabel3.setText("LOANING DATE");

        jDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDatePropertyChange(evt);
            }
        });

        jLoaning.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CHOOSE", " " }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jId))
                    .addComponent(jLoaning, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 156, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLoaning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnReset.setText("RESET");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        BTN_SETUJU.setText("SETUJUI");
        BTN_SETUJU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_SETUJUActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(BTN_SETUJU)
                .addGap(26, 26, 26)
                .addComponent(btnReset)
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnReset)
                    .addComponent(BTN_SETUJU))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(326, 326, 326))
            .addGroup(layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 162, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel13)
                        .addGap(32, 32, 32)
                        .addComponent(jSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jSearchActionPerformed

    private void jSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jSearchKeyTyped
        //        updateTableEmployee(jSearch.getText());
        showTable(jSearch.getText());
    }//GEN-LAST:event_jSearchKeyTyped

    private void jIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jIdActionPerformed

    private void jDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDatePropertyChange
        jDate.setDateFormatString("MM/dd/yyyy");

    }//GEN-LAST:event_jDatePropertyChange

    private void tblLStatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLStatusMouseClicked
        DefaultTableModel model = (DefaultTableModel) tblLStatus.getModel();
        int SelectRowIndex = tblLStatus.getSelectedRow();
//        jRepair.setText(model.getValueAt(SelectRowIndex, 1).toString());
//        jCost.setText(model.getValueAt(SelectRowIndex, 2).toString());
//        jNote.setText(model.getValueAt(SelectRowIndex, 3).toString());
//        jAsset.setSelectedItem(model.getValueAt(SelectRowIndex, 4).toString());
//        jEmployee.setSelectedItem(model.getValueAt(SelectRowIndex, 5).toString());
    }//GEN-LAST:event_tblLStatusMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (jId.getText().equals("") || jStatus.getSelectedItem() == ("CHOOSE")
                || jLoaning.getSelectedItem() == ("CHOOSE") || jDate.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Isi semua kolom");
        } else {
            int confirm = JOptionPane.showConfirmDialog(this, "Kamu yakin mau menambah data?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirm == JOptionPane.YES_OPTION) {
                String statusid = jStatus.getSelectedItem().toString();
                String loaningid = jLoaning.getSelectedItem().toString();
                statusid = statusid.substring(0, statusid.indexOf("-"));
                loaningid = loaningid.substring(0, loaningid.indexOf("-"));
                date = jDate.getDate();
                String loaningDate = formatter.format(date);
                JOptionPane.showMessageDialog(null, lsco.save(jId.getText(),loaningDate,loaningid, statusid));
                //               if (confirm == JOptionPane.YES_OPTION) {
                //            JOptionPane.showMessageDialog(null, edao.saveOrDelete(emp, false));
                ////            insert();
                //        }
                resetText();
            }
        }
        showTable("");
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        resetText();
    }//GEN-LAST:event_btnResetActionPerformed

    private void BTN_SETUJUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_SETUJUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_SETUJUActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_SETUJU;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private com.toedter.calendar.JDateChooser jDate;
    private javax.swing.JTextField jId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JComboBox<String> jLoaning;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jSearch;
    private javax.swing.JComboBox<String> jStatus;
    private javax.swing.JTable tblLStatus;
    // End of variables declaration//GEN-END:variables
}
