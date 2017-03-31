/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Guest;

import hotelappfit5148.Database;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author situsnow
 */
public class GuestPanel extends javax.swing.JPanel {

    Object columnHeaders[] = {"GUEST_ID","Title", "First Name", "Last Name",
        "Citizen Id", "DateOfBirth", "Country", "City", "Street", "Email"};
    Object data[][] = {{}};
    DefaultTableModel dtm = new DefaultTableModel(data, columnHeaders);
    
    public final static String SELECT_GUEST = "SELECT GUEST_ID, TITLE, FIRST_NAME, "
            + "LAST_NAME, CITIZEN_ID, DOB, COUNTRY, CITY, STREET, EMAIL FROM GUEST";
    public final static String SELECT_GUEST_WITH_FIRSTNAME = " WHERE FIRST_NAME LIKE '%";
    public final static String SELECT_GUEST_WITH_LASTNAME = "%' OR LAST_NAME LIKE '%";
    
    public final static String MULTIPLE_SELECTION = "Please select one guest only.";
    public final static String NO_SELECTION = "Please select at least one guest.";
    
    public final static String CONFIRM_DELETE_GUEST = "The guest information will be deleted. Please click Yes to proceed.";
    public final static String DELETE_GUEST = "DELETE GUEST WHERE GUEST_ID = ";
    public final static String UPDATE_GUEST_S = "Membership is deleted. Please refresh.";
    public final static String UPDATE_GUEST_F = "Fail to delete guest, there is booking for this guest in the system.";
    
    public final static String UPDATE_GUEST = "UpdateGuest";
    public final static String INSERT_GUEST = "InsertGuest";
    /**
     * Creates new form GuestPanel
     */
    public GuestPanel() {
        initComponents();
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
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(700, 500));

        jLabel1.setText("Guest Name");

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setSize(new java.awt.Dimension(700, 500));

        jTable1.setModel(dtm);
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Insert Guest");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Update Guest");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Delete Guest");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(64, 64, 64))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //Remove table content in case there's any
        for (int i = dtm.getRowCount() - 1; i >= 0; i--){
            dtm.removeRow(i);
        }
        
        StringBuffer sb = new StringBuffer(SELECT_GUEST);
        if (!"".equals(jTextField1.getText())){
            sb.append(SELECT_GUEST_WITH_FIRSTNAME).append(jTextField1.getText())
                    .append(SELECT_GUEST_WITH_LASTNAME).append(jTextField1.getText()).append("%'");
        }
        
        try {
            ResultSet rs = Database.getInstance().selectRecords(Database.DB_FIT5148B, sb.toString());
            ResultSetMetaData mdata = rs.getMetaData();
            int numberOfColumns = mdata.getColumnCount();
            while (rs.next()) {
                Object[] rowData = new Object[numberOfColumns];
                for (int i = 0; i < rowData.length; i++) {
                    rowData[i] = rs.getObject(i + 1);
                }
                dtm.addRow(rowData);
            }
            rs.close();
            //Close connection
            Database.getInstance().closeDBConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here: Insert
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuestInsertUpdateDialog(null, INSERT_GUEST).setVisible(true);
            }
        });
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here: Update
        int selectedRowCount = jTable1.getSelectedRowCount();
        if (selectedRowCount > 1){
            JOptionPane.showMessageDialog(null, MULTIPLE_SELECTION);
        }else if (selectedRowCount == 0){
            JOptionPane.showMessageDialog(null, NO_SELECTION);
        }else{
            GuestBean guestBean = constructGuestBean();
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new GuestInsertUpdateDialog(guestBean, UPDATE_GUEST).setVisible(true);
                }
            });
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private GuestBean constructGuestBean(){
        GuestBean guest = new GuestBean();
        
        int selectedGuest = jTable1.getSelectedRow();
        guest.setGuest_id(((BigDecimal)jTable1.getModel().getValueAt(selectedGuest, 0)).intValue());
        guest.setTitle((String)jTable1.getModel().getValueAt(selectedGuest, 1));
        guest.setFirstName((String)jTable1.getModel().getValueAt(selectedGuest, 2));
        guest.setLastName((String)jTable1.getModel().getValueAt(selectedGuest, 3));
        guest.setCitizenID(((BigDecimal)jTable1.getModel().getValueAt(selectedGuest, 4)).intValue());
        //Cast SQL Date format
        if (jTable1.getModel().getValueAt(selectedGuest, 5) != null){
            SimpleDateFormat dateFormat = new SimpleDateFormat(Database.DB_DATE_FORMAT);
            guest.setDOB(dateFormat.format(jTable1.getModel().getValueAt(selectedGuest, 5)));
        }
        
        guest.setCountry((String)jTable1.getModel().getValueAt(selectedGuest, 6));
        guest.setCity((String)jTable1.getModel().getValueAt(selectedGuest, 7));
        guest.setStreet((String)jTable1.getModel().getValueAt(selectedGuest, 8));
        guest.setEmail((String)jTable1.getModel().getValueAt(selectedGuest, 9));
        return guest;
        
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here: Delete
        int selectedRowCount = jTable1.getSelectedRowCount();
        if (selectedRowCount > 1){
            JOptionPane.showMessageDialog(null, MULTIPLE_SELECTION);
        }else if (selectedRowCount == 0){
            JOptionPane.showMessageDialog(null, NO_SELECTION);
        }else{
            int confirmDelete = JOptionPane.showConfirmDialog(null, CONFIRM_DELETE_GUEST, null, JOptionPane.YES_NO_OPTION);
            if (JOptionPane.YES_OPTION == confirmDelete){
                int selectedCustomer = jTable1.getSelectedRow();
                int guestID = ((BigDecimal)jTable1.getModel().getValueAt(selectedCustomer, 0)).intValue();
                StringBuffer sb = new StringBuffer(DELETE_GUEST);
                sb.append(guestID);
                
                //boolean updateResult;
                try {
                    Database.getInstance().updateTable(Database.DB_FIT5148B, sb.toString());
                    Database.getInstance().closeDBConnection();
                    JOptionPane.showMessageDialog(null, UPDATE_GUEST_S);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, UPDATE_GUEST_F);
                }
                
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
