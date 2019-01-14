/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.FoodAdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Suraj PC
 */
public class FoodOrganization extends Organization{
    private String nameOfOrganization;

    public String getNameOfOrganization() {
        return nameOfOrganization;
    }

    public void setNameOfOrganization(String nameOfOrganization) {
        this.nameOfOrganization = nameOfOrganization;
    }
    
    public FoodOrganization() {
        super(Organization.MerchantType.Food.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new FoodAdminRole());
        return roles;
    }
}
