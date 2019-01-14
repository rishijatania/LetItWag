/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.OrganizationDirectory;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Suraj PC
 */
public class NgoEnterprise extends Enterprise{
    
    private OrganizationDirectory organizationDirectory;
    NgoEnterprise(String name) {
      super(name,Enterprise.EnterpriseType.Ngo);
    }
     
     @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
