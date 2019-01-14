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
public class MedWorkRequest extends WorkRequest{
    private ArrayList<String> medList = new ArrayList<>();
    private String medReqId;

    public ArrayList<String> getMedList() {
        return medList;
    }

    public void setMedList(ArrayList<String> medList) {
        this.medList = medList;
    }

    public String getMedReqId() {
        return medReqId;
    }

    public void setMedReqId(String medReqId) {
        this.medReqId = medReqId;
    }
    
    @Override
    public String toString(){
        return this.getMedReqId();
    }
}
