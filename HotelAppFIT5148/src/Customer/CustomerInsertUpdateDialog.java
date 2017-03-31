/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

import Util.CustomerGuestUtil;
import hotelappfit5148.Database;
import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author situsnow
 */
public class CustomerInsertUpdateDialog extends javax.swing.JDialog {

    public final static String CHECK_CUST_EXISTANCE_B4INSERT = "SELECT COUNT(1) "
            + "FROM CUSTOMER WHERE CITIZEN_ID = ";
    private final static String CUSTOMER_INSERT_UPDATE_S = "Customer added/updated successfully. Please go back to Customer page and refresh.";
    private final static String CUSTOMER_INSERT_UPDATE_F = "Failed to add/update customer. Other guest is using this citizen id."
            + "Please double check the information";
    
    
    private static CallableStatement cstmt;
    private final static String CALLSP_INSERTORUPDATECUSTOMER = "{call insertOrUpdateCustomer(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
    
    /**
     * Creates new form CustomerInsertUpdateDialog
     */
    public CustomerInsertUpdateDialog(CustomerBean customer, String action) {
        initComponents();
        if (CustomerPanel.UPDATE_CUST.equals(action)){
            initCustomerInformation(customer);
            jButton1.setVisible(false);
        }else{
            jButton2.setVisible(false);
        }
        
    }
    
    public void initCustomerInformation (CustomerBean customer){
        
        jTextField1.setText(String.valueOf(customer.getCustomer_id()));
        
        
        jComboBox1.setSelectedItem(customer.getTitle());
        jTextField2.setText(customer.getFirstName());
        jTextField3.setText(customer.getLastName());
        jTextField4.setText(String.valueOf(customer.getCitizenID()));
        
        try {
            if (customer.getDOB()!= null && !"".equals(customer.getDOB())){
                Date dob = new SimpleDateFormat(Database.DB_DATE_FORMAT).parse(customer.getDOB());
                jXDatePicker1.setDate(dob);
            }
        } catch (ParseException ex) {
            Logger.getLogger(CustomerInsertUpdateDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        jTextField5.setText(customer.getCountry());
        jTextField6.setText(customer.getCity());
        jTextField7.setText(customer.getStreet());
        jTextField8.setText(String.valueOf(customer.getPostalCode()));
        
        jTextField9.setText(String.valueOf(customer.getMembership()));
        jTextField10.setText(String.valueOf(customer.getMembershipCredit()));
        jTextField11.setText(String.valueOf(customer.getPhoneNumber()));
        jTextField12.setText(customer.getEmail());
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
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jLabel8 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jLabel2.setText("Customer ID");

        jTextField1.setEnabled(false);
        jTextField1.setSize(new java.awt.Dimension(20, 20));

        jLabel3.setText("Title");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mr", "Miss" }));

        jLabel4.setText("First Name");

        jTextField2.setToolTipText("");

        jLabel5.setText("Last Name");

        jLabel6.setText("Citizen ID");

        jLabel7.setText("DOB");

        jLabel8.setText("Country");

        jLabel9.setText("City");

        jLabel10.setText("Street");

        jLabel11.setText("Postal Code");

        jLabel12.setText("Membership");

        jTextField9.setEnabled(false);

        jLabel13.setText("Credit");

        jTextField10.setEnabled(false);

        jLabel14.setText("Phone");

        jLabel15.setText("Email");

        jButton1.setText("Create");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addComponent(jLabel6))
                            .addComponent(jLabel8))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel12)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField9, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                    .addComponent(jTextField8))
                                .addGap(30, 30, 30)
                                .addComponent(jLabel13)
                                .addGap(45, 45, 45)
                                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jXDatePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jTextField6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:        
        int cancelInput = JOptionPane.showConfirmDialog(null, CustomerGuestUtil.DISCARD_CHANGE, null, JOptionPane.YES_NO_OPTION);
        if (JOptionPane.NO_OPTION == cancelInput){
            dispose();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String citizenID = jTextField4.getText();
        if (null == citizenID || "".equals(citizenID)){
            JOptionPane.showMessageDialog(null, CustomerGuestUtil.EMPTY_CITIZEN_ID);
            return;
        }
        boolean citizenId_Numeric = citizenID.chars().allMatch(Character :: isDigit);
        if (citizenId_Numeric == true){
            if (!CustomerGuestUtil.checkCitizenID(citizenID, CHECK_CUST_EXISTANCE_B4INSERT)){
                boolean insertResult = performInsertOrUpdate(CustomerPanel.INSERT_CUST);
                if (insertResult == true){
                    JOptionPane.showMessageDialog(null, CUSTOMER_INSERT_UPDATE_S);
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null, CUSTOMER_INSERT_UPDATE_F);
                }
            }else{
                JOptionPane.showMessageDialog(null, CustomerGuestUtil.EXISTED_CITIZEN);
            }
        }else{
            JOptionPane.showMessageDialog(null, CustomerGuestUtil.INVALID_CITIZEN_ID);
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here: update here
        boolean updateResult = performInsertOrUpdate(CustomerPanel.UPDATE_CUST);
        if (updateResult == true){
            JOptionPane.showMessageDialog(null, CUSTOMER_INSERT_UPDATE_S);
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, CUSTOMER_INSERT_UPDATE_F);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private boolean performInsertOrUpdate(String action){
        CustomerBean customer = getUserInputOfCustomer();
        boolean result = callSPInsertOrUpdateCustomer(customer, 
                        Database.DB_FIT5148B, action);
        Database.getInstance().closeDBConnection();
        
        return result;
        
    }
    
    private CustomerBean getUserInputOfCustomer(){
        CustomerBean cust = new CustomerBean();
        
        if (null != jTextField1.getText() && !"".equals(jTextField1.getText())){
            cust.setCustomer_id(Integer.valueOf(jTextField1.getText()));
        }
        
        cust.setTitle((String)jComboBox1.getSelectedItem());
        cust.setFirstName(jTextField2.getText());
        cust.setLastName(jTextField3.getText());
        cust.setCitizenID(Integer.valueOf(jTextField4.getText()));
        
        if (jXDatePicker1.getDate() != null){
            Date dob = jXDatePicker1.getDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat(Database.DB_DATE_FORMAT);
            cust.setDOB(dateFormat.format(dob));
        }
        
        cust.setCountry(jTextField5.getText());
        cust.setCity(jTextField6.getText());
        cust.setStreet(jTextField7.getText());
        if("".equals(jTextField8.getText())){
            cust.setPostalCode(0);
        }else{
            cust.setPostalCode(Integer.valueOf(jTextField8.getText()));
        }
        if("".equals(jTextField11.getText())){
            cust.setPhoneNumber(0);
        }else{
            cust.setPhoneNumber(Integer.valueOf(jTextField11.getText()));
        }
        
        cust.setEmail(jTextField12.getText());
        
        return cust;
    }
    
    public boolean callSPInsertOrUpdateCustomer(CustomerBean customer, String dbName, String action){
        Connection dbConnection = null;
        
        try{
            dbConnection = Database.getInstance().getDBConnection(dbName);
            cstmt = dbConnection.prepareCall(CALLSP_INSERTORUPDATECUSTOMER);
            
            cstmt.setInt(1, customer.getCustomer_id());
            cstmt.setString(2, customer.getTitle());
            cstmt.setString(3, customer.getFirstName());
            cstmt.setString(4, customer.getLastName());
            cstmt.setInt(5, customer.getCitizenID());
            cstmt.setString(6, customer.getDOB());
            cstmt.setString(7, customer.getCountry());
            cstmt.setString(8, customer.getCity());
            cstmt.setString(9, customer.getStreet());
            cstmt.setInt(10, customer.getPostalCode());
            cstmt.setInt(11, customer.getPhoneNumber());
            cstmt.setString(12, customer.getEmail());
            
            cstmt.setString(13, action);
            cstmt.registerOutParameter(14, java.sql.Types.VARCHAR);
            
            cstmt.executeUpdate();
            
            String result = cstmt.getString(14);
            
            cstmt.close();
            Database.getInstance().closeDBConnection();
            if (CustomerGuestUtil.FAIL_PROCEDURE.equals(result)){
                return false;
            }
            return true;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } 
        
    }
    
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(CustomerInsertUpdateDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(CustomerInsertUpdateDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(CustomerInsertUpdateDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(CustomerInsertUpdateDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new CustomerInsertUpdateDialog().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    // End of variables declaration//GEN-END:variables
}
