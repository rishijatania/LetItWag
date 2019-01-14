/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.FieldWorkerRole;
import Business.Role.Role;
import Business.Role.WardenRole;
import java.util.ArrayList;

/**
 *
 * @author Suraj PC
 */
public class PetShelterOrganization extends Organization{
    private String nameOfOrganization;

    public String getNameOfOrganization() {
        return nameOfOrganization;
    }

    public void setNameOfOrganization(String nameOfOrganization) {
        this.nameOfOrganization = nameOfOrganization;
    }
    
    public PetShelterOrganization() {
        super(Organization.NGOType.PetShelter.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new FieldWorkerRole());
        roles.add(new WardenRole());
        return roles;
    }
     
   
    
    
}
