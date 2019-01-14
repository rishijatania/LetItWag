/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.NgoAccountantRole;
import Business.Role.NgoStaffRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Suraj PC
 */
public class NgoOfficeOrganization extends Organization{
    private String nameOfOrganization;

    public String getNameOfOrganization() {
        return nameOfOrganization;
    }

    public void setNameOfOrganization(String nameOfOrganization) {
        this.nameOfOrganization = nameOfOrganization;
    }
    
    public NgoOfficeOrganization() {
        super(Organization.NGOType.NgoOffice.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new NgoStaffRole());
        roles.add(new NgoAccountantRole());
        return roles;
    }
     
   
    
    
}
