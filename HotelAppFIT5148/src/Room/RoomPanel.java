/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Room;

import Facility.FacilityBean;
import Util.SQLStatement;
import Util.WarningMessage;
import java.sql.Connection;
import java.sql.Statement;
import hotelappfit5148.*;
import javax.swing.table.DefaultTableModel;
import oracle.jdbc.OracleDriver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author thaonguyen
 */
public class RoomPanel extends javax.swing.JPanel {

    Object columnHeaders[] = {"ROOM_NUMBER", "HOTEL_ID", "ROOM_TYPE", "PRICE", "DESCRIPTION", "FACILITY"};
    Object data[][] = {{}};
    DefaultTableModel dtm = new DefaultTableModel(data, columnHeaders);
    Connection conn = null;
    Statement stmt = null;

    /**
     * Creates new form RoomPanel
     */
    public RoomPanel() {
        initComponents();
        showAllRoomToTable();
    }

    private void showAllRoomToTable() {
        conn = Database.getInstance().getDBConnection(Database.DB_FIT5148B);
        dtm.setRowCount(0);
        try {
            DriverManager.registerDriver(new OracleDriver());
            stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery(SQLStatement.SELECT_ALL_ROOM);

            ResultSetMetaData mdata = rset.getMetaData();
            int numberOfColumns = mdata.getColumnCount();
            Object[] rowData = new Object[numberOfColumns + 1];

            while (rset.next()) {
                for (int i = 0; i < rowData.length - 1; i++) {
                    rowData[i] = rset.getObject(i + 1);
                }

                dtm.addRow(rowData);
            }
//            add facility
            for (int i = 0; i < dtm.getRowCount(); i++) {
                //                get facility
                List<FacilityBean> facilityList = getListFacilityOfRoom(dtm.getValueAt(i, 0).toString(), Long.parseLong(dtm.getValueAt(i, 1).toString()));
                String description = "";
                for (FacilityBean temp : facilityList) {
                    description += temp.getDescription();
                    description += " \n";
                }
                dtm.setValueAt(description, i, 5);
            }

            Database.getInstance().closeDBConnection();
        } catch (SQLException f) {
            System.out.println(f.getMessage());
        }
    }

    private List<FacilityBean> getListFacilityOfRoom(String roomNumber, Long hotelId) {
        conn = Database.getInstance().getDBConnection(Database.DB_FIT5148B);

        List<FacilityBean> facilityList = new ArrayList<>();

        try {
            DriverManager.registerDriver(new OracleDriver());
            stmt = conn.createStatement();
            StringBuilder str = new StringBuilder(SQLStatement.SELECT_FACILITY);
            str.append(hotelId);
            str.append(SQLStatement.SELECT_FACILITY_WITH_ROOM);
            str.append(roomNumber).append("'");
            ResultSet rset = stmt.executeQuery(str.toString());

//            ResultSetMetaData mdata = rset.getMetaData();
            while (rset.next()) {
                FacilityBean facility = new FacilityBean();
                facility.setFacilityNumeber(rset.getObject(1).toString());
                facility.setRoomNumber(rset.getObject(2).toString());
                facility.setHotelId(Long.parseLong(rset.getObject(3).toString()));
                facility.setDescription(rset.getObject(4).toString());

                facilityList.add(facility);

            }
            Database.getInstance().closeDBConnection();
        } catch (SQLException f) {
            System.out.println(f.getMessage());
        }
        return facilityList;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchButton = new javax.swing.JButton();
        newRoomButton = new javax.swing.JButton();
        updateRoomButton = new javax.swing.JButton();
        deleteRoomButton = new javax.swing.JButton();
        HotelScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        facilityTextField1 = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(700, 500));

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        newRoomButton.setText("New Room");
        newRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newRoomButtonActionPerformed(evt);
            }
        });

        updateRoomButton.setText("Update");
        updateRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateRoomButtonActionPerformed(evt);
            }
        });

        deleteRoomButton.setText("Delete");
        deleteRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRoomButtonActionPerformed(evt);
            }
        });

        jTable1.setModel(dtm);
        HotelScrollPane1.setViewportView(jTable1);

        jLabel2.setText("Facility Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(facilityTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchButton))
                            .addComponent(HotelScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(newRoomButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateRoomButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteRoomButton)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(facilityTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HotelScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newRoomButton)
                    .addComponent(updateRoomButton)
                    .addComponent(deleteRoomButton))
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    //Thao TODO: Revise the SQL with SEMI Join instead of left join
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        dtm.setRowCount(0);

        try {
            // TODO add your handling code here:

            String facility = this.facilityTextField1.getText().trim();
            StringBuilder sbSQL = new StringBuilder(SQLStatement.SELECT_ROOM_INFO);

            if (!"".equals(facility)) {
                sbSQL.append(SQLStatement.SELECT_ROOM_INFO_WITH_FACILITY);
                sbSQL.append(facility.toLowerCase()).append("%' )");

            }
            sbSQL.append(SQLStatement.ORDER_ROOM_DESC);
            //System.out.print(sbSQL);
            ResultSet rset = Database.getInstance().selectRecords(Database.DB_FIT5148B, sbSQL.toString());
            ResultSetMetaData mdata = rset.getMetaData();
            int numberOfColumns = mdata.getColumnCount() + 1;
            while (rset.next()) {
                Object[] rowData = new Object[numberOfColumns];
                for (int i = 0; i < rowData.length - 1; i++) {
                    rowData[i] = rset.getObject(i + 1);
                }
                dtm.addRow(rowData);
            }

            //            add facility
            for (int i = 0; i < dtm.getRowCount(); i++) {
                //                get facility
                List<FacilityBean> facilityList = getListFacilityOfRoom(dtm.getValueAt(i, 0).toString(), Long.parseLong(dtm.getValueAt(i, 1).toString()));
                String description = "";
                for (FacilityBean temp : facilityList) {
                    description += temp.getDescription();
                    description += "\n";
                }
                dtm.setValueAt(description, i, 5);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void newRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newRoomButtonActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsertUpdateHRoomDialog(null, WarningMessage.INSERT_ACT).setVisible(true);
            }
        });


    }//GEN-LAST:event_newRoomButtonActionPerformed

    private void updateRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateRoomButtonActionPerformed
        // TODO add your handling code here:
        int selectedRowCount = jTable1.getSelectedRowCount();
        if (selectedRowCount != 1) {
            JOptionPane.showMessageDialog(null, WarningMessage.SELECT_ONE_RECORD);
        } else {
            RoomBean hotel = this.constructRoomBean();
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new InsertUpdateHRoomDialog(hotel, WarningMessage.UPDATE_ACT).setVisible(true);
                }
            });
        }
    }//GEN-LAST:event_updateRoomButtonActionPerformed

    private void deleteRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRoomButtonActionPerformed
        // TODO add your handling code here:

        int selectedRowCount = jTable1.getSelectedRowCount();
        if (selectedRowCount > 1) {
            JOptionPane.showMessageDialog(null, WarningMessage.MULTIPLE_SELECTION);
        } else if (selectedRowCount == 0) {
            JOptionPane.showMessageDialog(null, WarningMessage.NO_SELECTION);
        } else {
            int confirmDelete = JOptionPane.showConfirmDialog(null, WarningMessage.CONFIRM_DELETE, null, JOptionPane.YES_NO_OPTION);
            if (JOptionPane.YES_OPTION == confirmDelete) {
                int selectedRoom = jTable1.getSelectedRow();
                String roomNumber = jTable1.getModel().getValueAt(selectedRoom, 0).toString();
                Long hotelId = Long.parseLong(jTable1.getModel().getValueAt(selectedRoom, 1).toString());

                StringBuilder sb = new StringBuilder(SQLStatement.DELETE_ROOM);
                sb.append(roomNumber);
                sb.append(SQLStatement.DELETE_ROOM_WITH_HOTEL);
                sb.append(hotelId);

                boolean deleteResult;

                try {
                    deleteResult = Database.getInstance().updateTable(Database.DB_FIT5148B, sb.toString());
                    if (deleteResult == true) {
                        JOptionPane.showMessageDialog(null, WarningMessage.DELETE_S);
                        this.showAllRoomToTable();
                    } else {
                        JOptionPane.showMessageDialog(null, WarningMessage.DELETE_F);
                    }

                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    if (ex.getErrorCode() == 2292) {
                        JOptionPane.showMessageDialog(null, WarningMessage.FOREIGN_KEY_DELETE);
                        return;
                    }

                }

            }
        }
        Database.getInstance().closeDBConnection();
    }//GEN-LAST:event_deleteRoomButtonActionPerformed

    private RoomBean constructRoomBean() {
        RoomBean room = new RoomBean();
        int selectedRoom = jTable1.getSelectedRow();
        room.setRoomNumber((String) jTable1.getModel().getValueAt(selectedRoom, 0));
        room.setHotelId(Long.parseLong(jTable1.getModel().getValueAt(selectedRoom, 1).toString()));
        room.setRoomType((String) jTable1.getModel().getValueAt(selectedRoom, 2));
        room.setPrice(Float.parseFloat(jTable1.getModel().getValueAt(selectedRoom, 3).toString()));
        room.setDescription((String) jTable1.getModel().getValueAt(selectedRoom, 4));
        return room;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane HotelScrollPane1;
    private javax.swing.JButton deleteRoomButton;
    private javax.swing.JTextField facilityTextField1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton newRoomButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton updateRoomButton;
    // End of variables declaration//GEN-END:variables
}
