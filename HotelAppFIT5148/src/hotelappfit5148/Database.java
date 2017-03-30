/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelappfit5148;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author situsnow
 */
public class Database {

    private static final String DB_DRIVER
            = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_CONNECTION_FIT5148A
            = "jdbc:oracle:thin:@hippo.its.monash.edu.au:1521:FIT5148A";
    private static final String DB_CONNECTION_FIT5148B
            = "jdbc:oracle:thin:@hippo.its.monash.edu.au:1521:FIT5148B";
    private static final String DB_USER = "S27530264";
    private static final String DB_PASSWORD = "student";
    
    //Global variable
    public static final String DB_FIT5148A = "FIT5148A";
    public static final String DB_FIT5148B = "FIT5148B";

    private static Database dbIsntance;
    private static Connection con_5148A;
    private static Connection con_5148B;
    private static PreparedStatement pstmt;
    private static ResultSet rs;
    private static CallableStatement cstmt;
    
    private static String CALLSP_INSERTORUPDATECUSTOMER = "{call insertOrUpdateCustomer(?,?,?,?,?,?,?,?,?,?,?,?,?)}";

    private Database() {
        // private constructor //
    }

    public static Database getInstance() {
        if (dbIsntance == null) {
            dbIsntance = new Database();
        }
        return dbIsntance;
    }

    public Connection getDBConnection(String databaseName) {
//        Connection dbConnection = null;
        

        try {
            if ("FIT5148A".equalsIgnoreCase(databaseName)) {
                if (con_5148A == null || con_5148A.isClosed()) {
                    con_5148A = DriverManager.getConnection(DB_CONNECTION_FIT5148A, DB_USER, DB_PASSWORD);
                }
                return con_5148A;
            } else {
                if (con_5148B == null || con_5148B.isClosed()) {
                    con_5148B = DriverManager.getConnection(DB_CONNECTION_FIT5148B, DB_USER, DB_PASSWORD);
                }
                
                return con_5148B;
            }
            
            

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void closeDBConnection() {
        //boolean result = false;

        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();                
            }
            
            if (cstmt != null){
                cstmt.close();
            }
            
            if (con_5148A != null) {
                con_5148A.close();                
            }
            if (con_5148B != null) {
                con_5148B.close();                
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }        
    }

    public ResultSet selectRecords(String dbName, String sqlStatement) throws SQLException {
        Connection dbConnection = null;
        try {
            dbConnection = getDBConnection(dbName);            
//            
            pstmt = dbConnection.prepareStatement(sqlStatement);

            rs = pstmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
       
        return null;
    }
    
    public boolean updateTable(String dbName, String sqlStatement){
        Connection dbConnection = null;
        
        try{
            dbConnection = getDBConnection(dbName);            
//            
            pstmt = dbConnection.prepareStatement(sqlStatement);

            pstmt.executeUpdate(sqlStatement);
            
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return false;
    }

    public boolean callSPInsertOrUpdateCustomer(CustomerBean customer, String dbName, String action){
        Connection dbConnection = null;
        
        try{
            dbConnection = getDBConnection(dbName);
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
            
            cstmt.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } 
        
    }
}
