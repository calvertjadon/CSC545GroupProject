/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc545groupproject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

import javax.swing.JOptionPane;

/**
 *
 * @author Jadon
 */
public class CSC545GroupProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection conn = new ConnectDb().setupConnection();
        OraclePreparedStatement pst = null;
        OracleResultSet rs = null;
        
        try {
            String sqlStatement = "SELECT * FROM C##CALVERTJ2021.FOOD WHERE ROWNUM <= 100";
            
            pst = (OraclePreparedStatement) conn.prepareStatement(sqlStatement);
            
            rs = (OracleResultSet) pst.executeQuery();
            
            if (rs.next()) {
                String name = rs.getString("name");
                int calories = rs.getInt("calories");
                int sugar = rs.getInt("sugar");
                int protein = rs.getInt("protein");
                int sodium = rs.getInt("sodium");
                int fat = rs.getInt("fat");
                
                System.out.printf("%s %s %s %s %s %s %n", name, calories, sugar, protein, sodium, fat);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            ConnectDb.close(conn);
            ConnectDb.close(rs);
            ConnectDb.close(pst);
        }
    }
    
}
