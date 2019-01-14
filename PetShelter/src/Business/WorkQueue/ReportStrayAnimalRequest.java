/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.POJO.Pet;
import Business.UserAccount.UserAccount;

/**
 *
 * @author rishijatania
 */
public class ReportStrayAnimalRequest extends WorkRequest {

    //private Integer reportId;
    private String reportId;
    private String street;
    private String city;
    private String state;
    private Integer zipCode;
    private String comments;
    private String animalType;
    private String issueType;
    private String urgencyType;
    private String username;
    private Pet pet;
    private UserAccount fieldWorkerAssigned;
    
    public UserAccount getFieldWorkerAssigned() {
        return fieldWorkerAssigned;
    }

    public void setFieldWorkerAssigned(UserAccount fieldWorkerAssigned) {
        this.fieldWorkerAssigned = fieldWorkerAssigned;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getUrgencyType() {
        return urgencyType;
    }

    public void setUrgencyType(String urgencyType) {
        this.urgencyType = urgencyType;
    }

    public String getReportId() {
       return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return this.reportId;
    }

    public enum issue {
        Injured("Injured"), SeemsLost("SeemsLost"), Abused("Abused"), NotInList("Not In List");
        private String issue;

        private issue(String issue) {
            this.issue = issue;
        }

        public String getValue() {
            return issue;
        }
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
    }

    public enum animalType {
        Cat("Cat"), Dog("Dog"), Rabbit("Rabbit"), Bird("Bird"), NotInList("Not In List");
        private String animalType;

        private animalType(String animalType) {
            this.animalType = animalType;
        }

        public String getValue() {
            return animalType;
        }
    }

}
