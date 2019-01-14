/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.POJO.Pet;

/**
 *
 * @author rishijatania
 */
public class PetHealthCheckUpRequest extends WorkRequest {
    private Pet pet;
    private String comments;
    private String requestId;
    private String urgency;
    private PrescriptionWorkRequest prescription;

    public PrescriptionWorkRequest getPrescription() {
        return prescription;
    }

    public void setPrescription(PrescriptionWorkRequest prescription) {
        this.prescription = prescription;
    }
    
    public Pet getPet() {
        return pet;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
    
    @Override
    public String toString() {
        return this.requestId;
    }
    
    public enum urgency {
        Emergency("Emergency"), Urgent("Urgent"), NotUrgent("NotUrgent");
        private String urgency;

        private urgency(String urgency) {
            this.urgency = urgency;
        }

        public String getValue() {
            return urgency;
        }
        @Override
        public String toString(){
            return urgency;
        }
    }
}
