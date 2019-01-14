/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.OrganizationDirectory;
import Business.Role.Role;
import java.util.ArrayList;
    
public class VetHospital extends Enterprise {
    
    private OrganizationDirectory organizationDirectory;
    
    public VetHospital(String name){
        super(name,EnterpriseType.VetHospital);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
