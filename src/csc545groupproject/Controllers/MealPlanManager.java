/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc545groupproject.Controllers;

import csc545groupproject.Models.MealPlan;
import csc545groupproject.Models.Recipe;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

/**
 *
 * @author Jadon
 */
public class MealPlanManager {
    public static ArrayList<MealPlan> getMealsFromDb(LocalDate day) {
        ArrayList<MealPlan> mealPlan = new ArrayList<>();
        
        Connection conn = new ConnectDb().setupConnection();
        OraclePreparedStatement pst = null;
        OracleResultSet rs = null;
        
        try {
            String sqlStatement = "SELECT * FROM MealPlan WHERE day=?";
            
            pst = (OraclePreparedStatement) conn.prepareStatement(sqlStatement);
            pst.setObject(1, day);
            
            rs = (OracleResultSet) pst.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                
                MealPlan meal = new MealPlan(id, name, day);
                mealPlan.add(meal);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            ConnectDb.close(conn);
            ConnectDb.close(rs);
            ConnectDb.close(pst);
        }
        
        return mealPlan;
    }
    
    public static ArrayList<Recipe> getMealPlanRecipes(MealPlan mealPlan) {
        ArrayList<Recipe> recipes = new ArrayList<>();
        
        Connection conn = new ConnectDb().setupConnection();
        OraclePreparedStatement pst = null;
        OracleResultSet rs = null;
        
        try {
            String sqlStatement = "select r.* from recipe r join mealplanrecipe mpr on r.id=mpr.recipeid where mpr.mealplanid=?";
            
            pst = (OraclePreparedStatement) conn.prepareStatement(sqlStatement);
            pst.setInt(1, mealPlan.getId());
            
            rs = (OracleResultSet) pst.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String category = rs.getString("category");
                String instructions = rs.getString("instructions");
                
                HashMap ingredients = RecipeManager.getRecipeIngredientsFromDb(id);
                System.out.printf("%s %s %n", name, ingredients.toString());
                
                Recipe r = new Recipe(id, name, category, instructions, ingredients);
                recipes.add(r);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            ConnectDb.close(conn);
            ConnectDb.close(rs);
            ConnectDb.close(pst);
        }
        
        return recipes;
    }
    
    public static void removeRecipeFromMealPlan(Recipe recipe, MealPlan mealPlan) {        
        Connection conn = new ConnectDb().setupConnection();
        OraclePreparedStatement pst = null;
        OracleResultSet rs = null;
        
        try {
            String sqlStatement = "delete from mealplanrecipe where recipeid=? and mealplanid=?";
            
            pst = (OraclePreparedStatement) conn.prepareStatement(sqlStatement);
            pst.setInt(1, recipe.getId());
            pst.setInt(2, mealPlan.getId());
            
            pst.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            ConnectDb.close(conn);
            ConnectDb.close(rs);
            ConnectDb.close(pst);
        }
    }

    public static void deleteMealPlan(MealPlan mealPlan) {
        Connection conn = new ConnectDb().setupConnection();
        OraclePreparedStatement pst = null;
        OracleResultSet rs = null;
        
        try {
            String sqlStatement = "delete from mealplan where id=?";
            
            pst = (OraclePreparedStatement) conn.prepareStatement(sqlStatement);
            pst.setInt(1, mealPlan.getId());
            
            pst.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            ConnectDb.close(conn);
            ConnectDb.close(rs);
            ConnectDb.close(pst);
        }
    }
    
    public static MealPlan createMealPlan(String name, LocalDate day) {
        // select nvl(max(id), 0)+1 as nextid from mealplan
        Connection conn = new ConnectDb().setupConnection();
        OraclePreparedStatement pst = null;
        OracleResultSet rs = null;
        
        try {
            String sqlStatement = "select nvl(max(id), 0)+1 as id from mealplan";
            pst = (OraclePreparedStatement) conn.prepareStatement(sqlStatement);
            
            rs = (OracleResultSet) pst.executeQuery();
            
            int id;
            if (rs.next()) {
                id = rs.getInt("id");
            } else {
                return null;
            }
            
            
            sqlStatement = "insert into mealplan (id, name, day) values (?, ?, ?)";
            
            pst = (OraclePreparedStatement) conn.prepareStatement(sqlStatement);
            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setObject(3, day);
            
            pst.executeUpdate();
            
            return new MealPlan(id, name, day);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            ConnectDb.close(conn);
            ConnectDb.close(rs);
            ConnectDb.close(pst);
        }
        
        return null;
    }
    
    public static void addRecipeToMealPlan(Recipe recipe, MealPlan mealPlan) {
        // insert into mealplanrecipe values (2, 1);
        Connection conn = new ConnectDb().setupConnection();
        OraclePreparedStatement pst = null;
        OracleResultSet rs = null;
        
        try {
            String sqlStatement = "insert into mealplanrecipe values (?, ?)";
            
            pst = (OraclePreparedStatement) conn.prepareStatement(sqlStatement);
            pst.setInt(1, mealPlan.getId());
            pst.setInt(2, recipe.getId());
            
            pst.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            ConnectDb.close(conn);
            ConnectDb.close(rs);
            ConnectDb.close(pst);
        }
    }
}
