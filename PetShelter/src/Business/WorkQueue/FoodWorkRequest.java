/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author Suraj PC
 */
public class FoodWorkRequest extends WorkRequest{
    private ArrayList<String> foodList = new ArrayList<>();
    private String foodReqId;

    public ArrayList<String> getFoodList() {
        return foodList;
    }

    public void setFoodList(ArrayList<String> foodList) {
        this.foodList = foodList;
    }

    public String getFoodReqId() {
        return foodReqId;
    }

    public void setFoodReqId(String foodReqId) {
        this.foodReqId = foodReqId;
    }
    
    @Override
    public String toString(){
        return this.getFoodReqId();
    }
}
