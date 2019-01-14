/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.OrganizationDirectory;
import java.util.ArrayList;

/**
 *
 * @author Suraj PC
 */
public class EnterpriseDirectory {
    private ArrayList<Enterprise> enterpriseList;
    private OrganizationDirectory organizationDirectory;
   

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
    
    public EnterpriseDirectory(){
        enterpriseList=new ArrayList<Enterprise>();
    }
    
    //Create enterprise
    public Enterprise createAndAddEnterprise(String name,Enterprise.EnterpriseType type){
        Enterprise enterprise=null;
        if(type==Enterprise.EnterpriseType.VetHospital){
            enterprise=new VetHospital(name);
            enterpriseList.add(enterprise);
        }
        if(type==Enterprise.EnterpriseType.Merchant){
            enterprise =new MerchantEnterprise(name);
            enterpriseList.add(enterprise);
        }
        
        if(type==Enterprise.EnterpriseType.Ngo){
            enterprise =new NgoEnterprise(name);
            enterpriseList.add(enterprise);
        }
        
        return enterprise;
    }
    
    public Boolean checkIfEnterpriseIsUnique(String name){
        return this.enterpriseList.stream().noneMatch(ep->ep.getName().equalsIgnoreCase(name));
    }
}
