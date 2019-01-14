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
public class SupplyWorkRequest extends WorkRequest {

    private ArrayList<String> itemList = new ArrayList<>();
    private String suppReqId;
    private int billamount;

    public ArrayList<String> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<String> itemList) {
        this.itemList = itemList;
    }

    public String getSuppReqId() {
        return suppReqId;
    }

    public void setSuppReqId(String suppReqId) {
        this.suppReqId = suppReqId;
    }

    public int getBillamount() {
        return billamount;
    }

    public void setBillamount(int billamount) {
        this.billamount = billamount;
    }

    @Override
    public String toString() {
        return this.getSuppReqId();
    }

}
