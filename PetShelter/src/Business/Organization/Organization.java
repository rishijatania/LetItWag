/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.EcoSystem;
import Business.Employee.EmployeeDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Organization {

    public String name;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int counter=0;
    
    public enum VetHospitalType{
        
        Admin("Admin Organization"), VetClinic("Vet Clinic Organization"), Pharmacy("Pharmacy Organization");
        private String value;
        private VetHospitalType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    public enum MerchantType{
        
        Admin("Admin Organization"), Food("Food Supplier Organization"), Medicines("Medicines Supplier Organization");
        private String value;
        private MerchantType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    public enum NGOType{
        
        Admin("Admin Organization"), PetShelter("PetShelter Organization"), NgoOffice("NGO Office Organization");

        private String value;
        private NGOType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    
    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        if(name!=null){
                organizationID = EcoSystem.getInstance().getIdGenInstance().getOrgId();
        }
        else{
            counter++;
        }
    }

    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }
    
    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
