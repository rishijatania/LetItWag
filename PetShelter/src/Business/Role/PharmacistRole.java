/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.PharmacyOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.PharmacistRole.PharmaWorkAreaProcess;

/**
 *
 * @author Suraj PC
 */
public class PharmacistRole extends Role{
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) 
    {

        return new PharmaWorkAreaProcess(userProcessContainer, 
                                             account, 
                                            (PharmacyOrganization)organization, 
                                             enterprise,
                                             business);
    }
    }
