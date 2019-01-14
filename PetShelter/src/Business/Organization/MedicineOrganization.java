/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.MedAdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Suraj PC
 */
public class MedicineOrganization extends Organization{
    private String nameOfOrganization;

    public String getNameOfOrganization() {
        return nameOfOrganization;
    }

    public void setNameOfOrganization(String nameOfOrganization) {
        this.nameOfOrganization = nameOfOrganization;
    }
    public MedicineOrganization() {
        super(Organization.MerchantType.Medicines.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new MedAdminRole());
        return roles;
    }
}
