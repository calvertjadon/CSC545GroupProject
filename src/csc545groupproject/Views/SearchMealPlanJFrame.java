/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc545groupproject.Views;

import csc545groupproject.Controllers.MealPlanManager;
import csc545groupproject.Controllers.RecipeManager;
import csc545groupproject.Models.MealPlan;
import csc545groupproject.Models.Recipe;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

/**
 *
 * @author Jadon
 */
public class SearchMealPlanJFrame extends javax.swing.JFrame {

//    MealPlanManager mealPlanManager;
    DateManager dateManager;
    ArrayList<MealPlan> meals = new ArrayList<>();
    ArrayList<Recipe> mealRecipes = new ArrayList<>();
    
    /**
     * Creates new form MealPlanJFrame
     */
    public SearchMealPlanJFrame() {
        initComponents();
        
//        mealPlanManager = new MealPlanManager();
        dateManager = new DateManager();
        
        for(String month: dateManager.getMonths()) {
            int days = dateManager.getNumDays(month, 2021);
            System.out.printf("%s %s %n", month, days);
        }
        
        SimpleDateFormat model = new SimpleDateFormat("dd-MM-yyyy");
        dateSpinner.setModel(new SpinnerDateModel());
        dateSpinner.setEditor(new JSpinner.DateEditor(dateSpinner, model.toPattern()));
        
        getMealPlan();
    }
    
    public void populateMealList() {
        int numRows = meals.size();
        
        String[] mealNames = new String[numRows];
        for (int i = 0; i < numRows; i++) {
            mealNames[i] = meals.get(i).getName();
        }
        
        mealList.setListData(mealNames);
    }
    
    public void populateRecipeList() {
        int numRows = mealRecipes.size();
        
        String[] recipeNames = new String[numRows];
        for (int i = 0; i < numRows; i++) {
            recipeNames[i] = mealRecipes.get(i).getName();
        }
        
        recipesList.setListData(recipeNames);
    }
    
    private void getMealPlan() {
        Date selectedDate = (Date) dateSpinner.getValue();
        LocalDate selectedLocalDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        meals = MealPlanManager.getMealsFromDb(selectedLocalDate);
        mealRecipes.clear();
        
        int weekdayNum = selectedLocalDate.getDayOfWeek().getValue() - 1;
        int monthNum = selectedLocalDate.getMonth().getValue() - 1;
        int dayOfMonth = selectedLocalDate.getDayOfMonth();
        
//        System.out.printf("weekdayNum: %s, monthNum: %s dayOfMonth: %s %n", weekdayNum, monthNum, dayOfMonth);
        
        String weekday = dateManager.getWeekday(weekdayNum);
        String month = dateManager.getMonth(monthNum);
        
        weekdayLabel.setText(String.format("%s, %s %s", weekday, month, dayOfMonth));
        populateMealList();
        populateRecipeList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        removeRecipeButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        recipesList = new javax.swing.JList<>();
        addRecipeButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        showMealPlanButton = new javax.swing.JButton();
        dateSpinner = new javax.swing.JSpinner();
        jPanel3 = new javax.swing.JPanel();
        weekdayLabel = new javax.swing.JLabel();
        deleteMealButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        mealList = new javax.swing.JList<>();
        addMealButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Recipes");

        removeRecipeButton.setText("Remove from Meal");
        removeRecipeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeRecipeButtonActionPerformed(evt);
            }
        });

        recipesList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        recipesList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(recipesList);

        addRecipeButton.setText("Add to Meal");
        addRecipeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRecipeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(addRecipeButton))
                            .addComponent(removeRecipeButton))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(removeRecipeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addRecipeButton)))
                .addContainerGap())
        );

        showMealPlanButton.setText("Show Meal Plan");
        showMealPlanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showMealPlanButtonActionPerformed(evt);
            }
        });

        dateSpinner.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.DAY_OF_WEEK));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dateSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(showMealPlanButton)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showMealPlanButton))
                .addContainerGap())
        );

        weekdayLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        weekdayLabel.setText("dayOfWeek");

        deleteMealButton.setText("Delete Meal");
        deleteMealButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMealButtonActionPerformed(evt);
            }
        });

        mealList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        mealList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        mealList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mealListMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(mealList);

        addMealButton.setText("Add Meal");
        addMealButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMealButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addMealButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteMealButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(weekdayLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(weekdayLabel)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(addMealButton)
                        .addGap(7, 7, 7)
                        .addComponent(deleteMealButton))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(168, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(108, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showMealPlanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showMealPlanButtonActionPerformed
        // TODO add your handling code here:
        getMealPlan();
        
    }//GEN-LAST:event_showMealPlanButtonActionPerformed

    private void mealListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mealListMouseReleased
        // TODO add your handling code here:
        int mealIdx = mealList.getSelectedIndex();
        MealPlan mealPlan = meals.get(mealIdx);
        
        mealRecipes = MealPlanManager.getMealPlanRecipes(mealPlan);
        
        populateRecipeList();
    }//GEN-LAST:event_mealListMouseReleased

    private void removeRecipeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeRecipeButtonActionPerformed
        // TODO add your handling code here:
        int mealPlanIdx = mealList.getSelectedIndex();
        int recipeIdx = recipesList.getSelectedIndex();
        
        MealPlan mealPlan;
        Recipe recipe;
        
        try {
            mealPlan = meals.get(mealPlanIdx);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No meal selected");
            return;
        }
        try {
            recipe = mealRecipes.get(recipeIdx);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No recipe selected");
            return;
        }

        if (JOptionPane.showConfirmDialog(this, String.format("Are you sure you remove to %s from %s?", recipe.getName(), mealPlan.getName())) == JOptionPane.YES_OPTION) {
            mealRecipes.remove(recipeIdx);
            populateRecipeList();
            MealPlanManager.removeRecipeFromMealPlan(recipe, mealPlan);
        }
        
        
    }//GEN-LAST:event_removeRecipeButtonActionPerformed

    private void deleteMealButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMealButtonActionPerformed
        // TODO add your handling code here:
        int mealPlanIdx = mealList.getSelectedIndex();
        MealPlan mealPlan;
        
        try {
            mealPlan = meals.get(mealPlanIdx);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No meal selected");
            return;
        }
        
        if (JOptionPane.showConfirmDialog(this, String.format("Are you sure you delete %s?", mealPlan.getName())) == JOptionPane.YES_OPTION) {
            meals.remove(mealPlanIdx);
            mealRecipes.clear();
            MealPlanManager.deleteMealPlan(mealPlan);
            populateMealList();
            populateRecipeList();
        }
    }//GEN-LAST:event_deleteMealButtonActionPerformed

    private void addMealButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMealButtonActionPerformed
        // TODO add your handling code here:
        String mealName = JOptionPane.showInputDialog(
                this,
                "Enter a meal name",
                "Add Meal",
                JOptionPane.PLAIN_MESSAGE
        );
        
        if (mealName != null && !mealName.equals("")) {
            Date selectedDate = (Date) dateSpinner.getValue();
            LocalDate selectedLocalDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            MealPlan mealPlan = MealPlanManager.createMealPlan(mealName, selectedLocalDate);
            meals.add(mealPlan);

            mealRecipes.clear();

            populateMealList();
            populateRecipeList();
        } else {
            System.out.println("Invalid meal name");
        }
    }//GEN-LAST:event_addMealButtonActionPerformed

    private void addRecipeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRecipeButtonActionPerformed
        ArrayList<Recipe> allRecipes = RecipeManager.getRecipes();
        ArrayList<Recipe> currentRecipes = mealRecipes;
        
        List<Integer> currentRecipeIds = currentRecipes.stream().map(Recipe::getId).collect(Collectors.toList());
        ArrayList<Recipe> recipes = (ArrayList<Recipe>) allRecipes.stream().filter(r -> !currentRecipeIds.contains(r.getId())).collect(Collectors.toList());
        
        allRecipes.removeAll(currentRecipes);
        
        if (recipes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "There are no recipes available to add!");
            return;
        }
        
        int mealPlanIdx = mealList.getSelectedIndex();
        
        MealPlan mealPlan;
        try {
            mealPlan = meals.get(mealPlanIdx);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No meal plan selected");
            return;
        }
                
        JDialog frame = new JDialog(this, "Add Recipe to Meal Plan", true);
        frame.getContentPane().add(new AddRecipeToMealPlanJFrame(frame, this, recipes, mealPlan).mainPanel);
        frame.pack();
        frame.setVisible(true);
    }//GEN-LAST:event_addRecipeButtonActionPerformed

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
            java.util.logging.Logger.getLogger(SearchMealPlanJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchMealPlanJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchMealPlanJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchMealPlanJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new SearchMealPlanJFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMealButton;
    private javax.swing.JButton addRecipeButton;
    private javax.swing.JSpinner dateSpinner;
    private javax.swing.JButton deleteMealButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JPanel mainPanel;
    private javax.swing.JList<String> mealList;
    private javax.swing.JList<String> recipesList;
    private javax.swing.JButton removeRecipeButton;
    private javax.swing.JButton showMealPlanButton;
    private javax.swing.JLabel weekdayLabel;
    // End of variables declaration//GEN-END:variables
}

class DateManager {
    private final String[] months = {
        "January",
        "February",
        "March",
        "April",
        "May",
        "June",
        "July",
        "August",
        "September",
        "October",
        "November",
        "December"
    };
    private final int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private final String[] weekdays = {
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday",
        "Saturday",
        "Sunday"
    };
    
    int getNumDays(String month, int year) {
        for (int i = 0; i < months.length; i++) {
            if (months[i].equals(month)) {
                int numDays = days[i];
                if (month.equals("February") && year % 4 == 0) {
                    numDays += 1;
                }
                return numDays;
            }
        }
        return -1;
    }
    
    String getWeekday(int day) {
        return weekdays[day];
    }
    
    String[] getMonths() {
        return months;
    }
    
    String getMonth(int month) {
        return months[month];
    }
}