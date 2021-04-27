/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc545groupproject.Views;

import csc545groupproject.Controllers.FridgeManager;
import csc545groupproject.Models.Food;
import csc545groupproject.Models.Recipe;
import csc545groupproject.Controllers.RecipeManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class ModifyRecipeJFrame extends javax.swing.JFrame {
    public JDialog dialog;
    public AccessRecipesJFrame presenter;
    
    public DefaultListModel updateIngredientsList = new DefaultListModel();
    public DefaultListModel updateInstructionsList = new DefaultListModel();
    
    public ArrayList<Food> foods;
    
    private Recipe recipe;
    private HashMap ingredients = new HashMap();
    private ArrayList<String> instructions = new ArrayList<>();

    public ModifyRecipeJFrame(JDialog dialog, AccessRecipesJFrame presenter, Recipe recipe) {
        //DefaultListModel ingredientsList = new DefaultListModel();
        initComponents();
                
        //populateTable();
        populateComboBox();
        
        this.dialog = dialog;
        this.presenter = presenter;
        
        this.recipe = recipe;
        this.nameTextField.setText(recipe.getName());
        this.categoryTextField.setText(recipe.getCategory());
        
        this.ingredients = recipe.ingredients;
        instructions = Stream.of(recipe.getInstructions().split("\\. ")).collect(Collectors.toCollection(ArrayList::new));
        
        populateIngredientsList();
        populateInstructionsList();
    }

    public void populateComboBox() {
        foods = FridgeManager.getFoodsFromDb();
        int numRows = foods.size();
        
        foodNamesComboBox.removeAllItems();
        for (int i = 0; i < numRows; i++) {
            String foodName = foods.get(i).getName();
            foodNamesComboBox.addItem(foodName);
        }
        
        quantityComboBox.removeAllItems();
        for (int i = 1; i <= 10; i++) {
            quantityComboBox.addItem(i + "");
        }
    }

    private void close() {
        try {
            presenter.populateTable(true);
        } catch (Exception e) {
            System.out.println("running in standalone");
        }
        
        try {
            dialog.dispose();
        } catch (Exception f) {
            this.dispose();
        }
    }
    
    private void populateIngredientsList() {
        DefaultListModel dlm = new DefaultListModel();
        
        String[] foodNames = (String[]) ingredients.keySet().toArray(new String[0]);
        Integer[] quantities = (Integer[]) ingredients.values().toArray(new Integer[0]);
        
        for (int i = 0; i < ingredients.size(); i++) {       
            String selectedIngredients = String.format("%sx %s", quantities[i], foodNames[i]);
            dlm.add(i, selectedIngredients);
        }
        
        ingredientsList.setModel(dlm);
    }
    
    private void populateInstructionsList() {
        DefaultListModel dlm = new DefaultListModel();
        
        for (int i = 0; i < instructions.size(); i++) {       
            String step = instructions.get(i);
            dlm.add(i, step);
        }
        
        instructionsList.setModel(dlm);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        instructionsLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        categoryLabel = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        categoryTextField = new javax.swing.JTextField();
        selectIngredientLabel = new javax.swing.JLabel();
        listOfAddedIngredientsLabel = new javax.swing.JLabel();
        addFoodToRecipeButton = new javax.swing.JButton();
        quantityComboBox = new javax.swing.JComboBox<>();
        foodNamesComboBox = new javax.swing.JComboBox<>();
        removeFoodFromRecipeButton = new javax.swing.JButton();
        editRecipeButton = new javax.swing.JButton();
        quantityLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ingredientsList = new javax.swing.JList<>();
        addInstructionButton = new javax.swing.JButton();
        removeInstructionButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        instructionsList = new javax.swing.JList<>();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Edit Recipe");

        instructionsLabel.setText("Instructions");

        nameLabel.setText("Name");

        categoryLabel.setText("Category");

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        selectIngredientLabel.setText("Select Ingredient");

        listOfAddedIngredientsLabel.setText("List of Added Ingredients");

        addFoodToRecipeButton.setText("Add Ingredient");
        addFoodToRecipeButton.setPreferredSize(new java.awt.Dimension(127, 23));
        addFoodToRecipeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFoodToRecipeButtonActionPerformed(evt);
            }
        });

        quantityComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        foodNamesComboBox.setToolTipText("");

        removeFoodFromRecipeButton.setText("Remove Ingredient");
        removeFoodFromRecipeButton.setPreferredSize(new java.awt.Dimension(127, 23));
        removeFoodFromRecipeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeFoodFromRecipeButtonActionPerformed(evt);
            }
        });

        editRecipeButton.setText("Done");
        editRecipeButton.setPreferredSize(new java.awt.Dimension(65, 23));
        editRecipeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editRecipeButtonActionPerformed(evt);
            }
        });

        quantityLabel.setText("Quantity");

        jScrollPane3.setViewportView(ingredientsList);
        ingredientsList.getAccessibleContext().setAccessibleName("ingredientsList");

        addInstructionButton.setText("Add Instruction");
        addInstructionButton.setPreferredSize(new java.awt.Dimension(127, 23));
        addInstructionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addInstructionButtonActionPerformed(evt);
            }
        });

        removeInstructionButton.setText("Remove Instruction");
        removeInstructionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeInstructionButtonActionPerformed(evt);
            }
        });

        jScrollPane5.setViewportView(instructionsList);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(151, 151, 151))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addFoodToRecipeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(listOfAddedIngredientsLabel)
                            .addComponent(instructionsLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(categoryLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectIngredientLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(238, 238, 238)
                                .addComponent(quantityLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(quantityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(foodNamesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(addInstructionButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addComponent(editRecipeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cancelButton)))
                                        .addGap(18, 18, 18)
                                        .addComponent(removeInstructionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(removeFoodFromRecipeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane5)
                                            .addComponent(jScrollPane3))
                                        .addGap(1, 1, 1))
                                    .addComponent(categoryTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nameTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(41, 41, 41))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(categoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryLabel))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(foodNamesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectIngredientLabel))
                .addGap(7, 7, 7)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addFoodToRecipeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeFoodFromRecipeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(listOfAddedIngredientsLabel))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(instructionsLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addInstructionButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(removeInstructionButton))
                        .addGap(50, 50, 50)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelButton)
                            .addComponent(editRecipeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        nameTextField.getAccessibleContext().setAccessibleName("nameTextField");
        cancelButton.getAccessibleContext().setAccessibleName("cancelButton");
        categoryTextField.getAccessibleContext().setAccessibleName("categoryTextField");
        addFoodToRecipeButton.getAccessibleContext().setAccessibleName("addFoodToRecipeButton");
        quantityComboBox.getAccessibleContext().setAccessibleName("quantityComboBox");
        foodNamesComboBox.getAccessibleContext().setAccessibleName("foodNamesComboBox");
        removeFoodFromRecipeButton.getAccessibleContext().setAccessibleName("removeFoodFromRecipeButton");
        editRecipeButton.getAccessibleContext().setAccessibleName("addRecipeButton");
        addInstructionButton.getAccessibleContext().setAccessibleName("addInstructionButton");
        removeInstructionButton.getAccessibleContext().setAccessibleName("removeInstructionButton");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        close();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void editRecipeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editRecipeButtonActionPerformed
        // TODO add your handling code here:
        
        String recipeName = nameTextField.getText();
        String category = categoryTextField.getText();
        String instructionsString = String.join(". ", instructions);
        
        if (recipeName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Recipe name cannot be left blank!");
            return;
        }
        
        if (category.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Category cannot be left blank!");
            return;
        }
        
        if (ingredients.size() == 0) {
            JOptionPane.showMessageDialog(null, "Ingredients cannot be left blank!");
            return;
        }
        
        if (instructionsString.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Instructions cannot be left blank!");
            return;
        }
        
        recipe.setName(recipeName);
        recipe.setCategory(category);
        recipe.setInstructions(instructionsString);
        recipe.setIngredients(ingredients);

        boolean success = RecipeManager.updateRecipeInDb(recipe);
        if (success) {
            close();
        } else {
            JOptionPane.showMessageDialog(null, "Unable to modify selected recipe!");
        }
    }//GEN-LAST:event_editRecipeButtonActionPerformed

    private void addFoodToRecipeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFoodToRecipeButtonActionPerformed
        // TODO add your handling code here:
        String selectedFoodName = (String) foodNamesComboBox.getSelectedItem().toString();
        Integer selectedQuantity = Integer.parseInt(quantityComboBox.getSelectedItem().toString());

        if (selectedFoodName == null) return;
        if (selectedQuantity == null) return;
        
        ingredients.put(selectedFoodName, selectedQuantity);
        populateIngredientsList();
    }//GEN-LAST:event_addFoodToRecipeButtonActionPerformed

    private void addInstructionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addInstructionButtonActionPerformed
        // TODO add your handling code here:
        String step = JOptionPane.showInputDialog("Enter Instruction Step: ");
        if (step == null) return;
        
        instructions.add(step);
        populateInstructionsList();
    }//GEN-LAST:event_addInstructionButtonActionPerformed

    private void removeFoodFromRecipeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeFoodFromRecipeButtonActionPerformed
        // TODO add your handling code here:
        String selectedFoodName = (String) foodNamesComboBox.getSelectedItem().toString();
        Integer selectedQuantity = Integer.parseInt(quantityComboBox.getSelectedItem().toString());
        
        int selectedIndex = ingredientsList.getSelectedIndex();
        
        if (selectedIndex == -1) return;

        ingredients.remove(selectedFoodName);
        populateIngredientsList();
    }//GEN-LAST:event_removeFoodFromRecipeButtonActionPerformed

    private void removeInstructionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeInstructionButtonActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        int selectedIndex = instructionsList.getSelectedIndex();
        if (selectedIndex == -1) return;
        
        instructions.remove(selectedIndex);
        populateInstructionsList();
    }//GEN-LAST:event_removeInstructionButtonActionPerformed

    /**
     * @param args the command line arguments
//     */
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
//            java.util.logging.Logger.getLogger(ModifyRecipeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ModifyRecipeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ModifyRecipeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ModifyRecipeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ModifyRecipeJFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFoodToRecipeButton;
    private javax.swing.JButton addInstructionButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JTextField categoryTextField;
    private javax.swing.JButton editRecipeButton;
    private javax.swing.JComboBox<String> foodNamesComboBox;
    private javax.swing.JList<String> ingredientsList;
    private javax.swing.JLabel instructionsLabel;
    private javax.swing.JList<String> instructionsList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel listOfAddedIngredientsLabel;
    public javax.swing.JPanel mainPanel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JComboBox<String> quantityComboBox;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JButton removeFoodFromRecipeButton;
    private javax.swing.JButton removeInstructionButton;
    private javax.swing.JLabel selectIngredientLabel;
    // End of variables declaration//GEN-END:variables

    
}
