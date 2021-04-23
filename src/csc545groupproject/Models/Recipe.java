/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc545groupproject.Models;

/**
 *
 * @author Jadon
 */
public class Recipe {
    
    private int id;
    private String name;
    private String category;
    private String instructions;
    
    public Recipe(int id, String name, String category, String instructions) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.instructions = instructions;
    }
    
//    private Ingredient[] ingredients;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the instructions
     */
    public String getInstructions() {
        return instructions;
    }

    /**
     * @param instructions the instructions to set
     */
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the ingredients
     */
//    public Ingredient[] getIngredients() {
//        return ingredients;
//    }
//
//    /**
//     * @param ingredients the ingredients to set
//     */
//    public void setIngredients(Ingredient[] ingredients) {
//        this.ingredients = ingredients;
//    }
}
