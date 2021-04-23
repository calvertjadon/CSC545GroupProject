/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc545groupproject.Controllers;

import csc545groupproject.Models.Recipe;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

/**
 *
 * @author Jadon
 */
public class RecipeManager {
    public static ArrayList<Recipe> getRecipes() {
        ArrayList<Recipe> recipes = new ArrayList<Recipe>();
        
        Connection conn = new ConnectDb().setupConnection();
        OraclePreparedStatement pst = null;
        OracleResultSet rs = null;
        
        try {
            String sqlStatement = "SELECT * FROM Recipe WHERE rownum<=100";
            
            pst = (OraclePreparedStatement) conn.prepareStatement(sqlStatement);
            rs = (OracleResultSet) pst.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String category = rs.getString("category");
                String instructions = rs.getString("instructions");
                
                Recipe recipe = new Recipe(id, name, category, instructions);
                recipes.add(recipe);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            ConnectDb.close(conn);
            ConnectDb.close(rs);
            ConnectDb.close(pst);
        }
        
        return recipes;
    }
}
