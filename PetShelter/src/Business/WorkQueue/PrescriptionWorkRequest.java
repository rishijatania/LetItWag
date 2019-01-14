/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class PrescriptionWorkRequest extends WorkRequest{
    
    private ArrayList<String> medicinesList = new ArrayList<>();
    private String presReqId;

    public String getPresReqId() {
        return presReqId;
    }

    public void setPresReqId(String presReqId) {
        this.presReqId = presReqId;
    }
    
    public ArrayList<String> getMedicinesList() {
        return medicinesList;
    }

    public void setMedicinesList(ArrayList<String> medicinesList) {
        this.medicinesList = medicinesList;
    }
    
    @Override
    public String toString(){
        return this.getPresReqId();
    }
        
}
