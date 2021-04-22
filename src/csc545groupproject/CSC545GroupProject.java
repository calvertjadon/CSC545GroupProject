/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc545groupproject;

import csc545groupproject.Controllers.DbManager;
import csc545groupproject.Models.Food;
import csc545groupproject.Models.Fridge;

import java.util.ArrayList;

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
        ArrayList<Food> foods = DbManager.getFoodsFromDb();
//        foods.forEach((food) -> {
//            System.out.println(food.getName());
//        });
        
        Fridge fridge = DbManager.getFridgeQuantitiesFromDb(foods);
        fridge.printContents();
        System.out.println("");
        
        Food banana = fridge.get("Banana");
        if (banana != null) {
            fridge.remove(banana);
        }
        
        Food apple = new Food("Apple", 1, 2, 3, 4, 5);
        if (fridge.add(apple, 0)) {
            DbManager.addFoodToDb(apple);
        } else {
            apple = fridge.get("Apple");
        }
        
        fridge.update(apple, 5);
        
        fridge.printContents();
    }
    
}
