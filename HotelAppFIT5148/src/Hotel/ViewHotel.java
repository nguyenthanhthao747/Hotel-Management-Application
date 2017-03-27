/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hotel;

import hotelappfit5148.DBConnection;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.OracleDriver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thaonguyen
 */
public class ViewHotel extends javax.swing.JFrame {
    
    Object columnHeaders[] = {"HOTEL_ID", "HOTEL_NAME", "HOTEL_TYPE", "CONSTUCTION_YEAR", "COUNTRY", "CITY", "ADDRESS", "CONTACT_NUMBER", "EMAIL"};
    Object data[][] = {{}};
    DefaultTableModel dtm = new DefaultTableModel(data, columnHeaders);
    Connection conn = null;
    Statement stmt = null;

    /**
     * Creates new form ViewHotel
     */
    public ViewHotel() {
        initComponents();
        conn = DBConnection.getDBConnection("FIT5148A");
        
        try {
            DriverManager.registerDriver(new OracleDriver());
            stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("select hotel_id, hotel_name, hotel_type, "
                    + "construction_year, country, city, address, "
                    + "contact_number, email from hotel");
            
            ResultSetMetaData mdata = rset.getMetaData();
            int numberOfColumns = mdata.getColumnCount();
            while (rset.next()) {
                Object[] rowData = new Object[numberOfColumns];
                for (int i = 0; i < rowData.length; i++) {
                    rowData[i] = rset.getObject(i + 1);
                }
                dtm.addRow(rowData);
            }
            
        } catch (SQLException f) {
            System.out.println(f.getMessage());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(dtm);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("View Hotel");

        jLabel2.setText("Hotel Type");

        List<String> typeListCombox = new ArrayList<String>();
        typeListCombox.add("None");
        typeListCombox.addAll(getHotelType());
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(typeListCombox.toArray()));

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("New Hotel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Update");

        jButton4.setText("Delete");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel1.getAccessibleContext().setAccessibleName("viewHotelLabel");
        jLabel1.getAccessibleContext().setAccessibleDescription("");
        jButton3.getAccessibleContext().setAccessibleName("Update");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dtm.setRowCount(0);
        
        try {
            // TODO add your handling code here:

            String selectedHotelType = String.valueOf(jComboBox2.getSelectedItem());
            StringBuffer sbSQL = new StringBuffer("select hotel_id, hotel_name, hotel_type, "
                    + "construction_year, country, city, address, "
                    + "contact_number, email from hotel");
            if (!"None".equals(selectedHotelType)) {
                sbSQL.append(" where hotel_type = '" + selectedHotelType + "'");
            }
            
            ResultSet rset = DBConnection.selectRecords("FIT5148A", sbSQL.toString());
            ResultSetMetaData mdata = rset.getMetaData();
            int numberOfColumns = mdata.getColumnCount();
            while (rset.next()) {
                Object[] rowData = new Object[numberOfColumns];
                for (int i = 0; i < rowData.length; i++) {
                    rowData[i] = rset.getObject(i + 1);
                }
                dtm.addRow(rowData);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new NewHotel().setVisible(true);
        
        conn = DBConnection.getDBConnection("FIT5148A");
        
        try {
            DriverManager.registerDriver(new OracleDriver());
            stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("select hotel_id, hotel_name, hotel_type, "
                    + "construction_year, country, city, address, "
                    + "contact_number, email from hotel");
            
            ResultSetMetaData mdata = rset.getMetaData();
            int numberOfColumns = mdata.getColumnCount();
            while (rset.next()) {
                Object[] rowData = new Object[numberOfColumns];
                for (int i = 0; i < rowData.length; i++) {
                    rowData[i] = rset.getObject(i + 1);
                }
                dtm.addRow(rowData);
            }
            
        } catch (SQLException f) {
            System.out.println(f.getMessage());
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed
    
    public List<String> getHotelType() {
        String getHotelType = "select distinct hotel_type from hotel order by hotel_type";
        
        try {
            ResultSet rset = DBConnection.selectRecords("FIT5148A", getHotelType);
            
            List<String> hotelTypeList = new ArrayList<String>();
            while (rset.next()) {
                hotelTypeList.add(rset.getString(1));
            }
//            List<String> result = hotelTypeList.toArray(new String[hotelTypeList.size()]);
            return hotelTypeList;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return null;
    }

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
            java.util.logging.Logger.getLogger(ViewHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewHotel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewHotel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
