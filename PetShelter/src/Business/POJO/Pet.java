/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.POJO;

import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author rishijatania
 */
public class Pet {
    private String petId;
    private String animalType;
    private String currentHealthStatus;
    private Integer regPCNO; 
    private String namePC;
    private String nameNGO;
    private Boolean isAvailableForAdoption;
    private Boolean isAdopted;
    private Users currentOwner;
    private Boolean hasBeenReportedForAbuse;
    private Boolean isStray;
    private ArrayList<Map<String,Object>> petMedHistory;
    private Users userReported;

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getCurrentHealthStatus() {
        return currentHealthStatus;
    }

    public void setCurrentHealthStatus(String currentHealthStatus) {
        this.currentHealthStatus = currentHealthStatus;
    }

    public Integer getRegPCNO() {
        return regPCNO;
    }

    public void setRegPCNO(Integer regPCNO) {
        this.regPCNO = regPCNO;
    }

    public String getNamePC() {
        return namePC;
    }

    public void setNamePC(String namePC) {
        this.namePC = namePC;
    }

    public String getNameNGO() {
        return nameNGO;
    }

    public void setNameNGO(String nameNGO) {
        this.nameNGO = nameNGO;
    }

    public Boolean getIsAvailableForAdoption() {
        return isAvailableForAdoption;
    }

    public void setIsAvailableForAdoption(Boolean isAvailableForAdoption) {
        this.isAvailableForAdoption = isAvailableForAdoption;
    }

    public Boolean getIsAdopted() {
        return isAdopted;
    }

    public void setIsAdopted(Boolean isAdopted) {
        this.isAdopted = isAdopted;
    }

    public Users getCurrentOwner() {
        return currentOwner;
    }

    public void setCurrentOwner(Users currentOwner) {
        this.currentOwner = currentOwner;
    }

    public Boolean getHasBeenReportedForAbuse() {
        return hasBeenReportedForAbuse;
    }

    public void setHasBeenReportedForAbuse(Boolean hasBeenReportedForAbuse) {
        this.hasBeenReportedForAbuse = hasBeenReportedForAbuse;
    }

    public Boolean getIsStray() {
        return isStray;
    }

    public void setIsStray(Boolean isStray) {
        this.isStray = isStray;
    }

    public ArrayList<Map<String, Object>> getPetMedHistory() {
        return petMedHistory;
    }

    public void setPetMedHistory(ArrayList<Map<String, Object>> petMedHistory) {
        this.petMedHistory = petMedHistory;
    }

    public Users getUserReported() {
        return userReported;
    }

    public void setUserReported(Users userReported) {
        this.userReported = userReported;
    }
    
    @Override
    public String toString(){
        return this.getPetId();
    }

}
