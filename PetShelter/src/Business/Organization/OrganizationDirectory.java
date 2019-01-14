/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;


import Business.Organization.Organization.MerchantType;
import Business.Organization.Organization.NGOType;
import Business.Organization.Organization.VetHospitalType;
import java.util.ArrayList;

/**
 *
 * @author Suraj PC
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganizationHospital(VetHospitalType type, String name){
        Organization organization = null;
        if (type.getValue().equals(VetHospitalType.VetClinic.getValue())){
            organization = new ClinicOrganization();
            organization.setName(name);
            organizationList.add(organization);
        }else{
            if (type.getValue().equals(VetHospitalType.Pharmacy.getValue())){
             organization = new PharmacyOrganization();
             organization.setName(name);
             organizationList.add(organization);
            }
        }
        return organization;
    }
    public Organization createOrganizationSupplier(MerchantType type, String name){
        Organization organization = null;
        if (type.getValue().equals(MerchantType.Food.getValue())){
            organization = new FoodOrganization();
            organization.setName(name);
            organizationList.add(organization);
        }else{
           if (type.getValue().equals(MerchantType.Medicines.getValue())){
            organization = new MedicineOrganization();
            organization.setName(name);
            organizationList.add(organization);
            }
        }
        return organization;
    }
    public Organization createOrganizationNgo(NGOType type,String name){
        Organization organization = null;
        if (type.getValue().equals(NGOType.NgoOffice.getValue())){
            organization = new NgoOfficeOrganization();
            organization.setName(name);
            organizationList.add(organization);
        }else{
            if (type.getValue().equals(NGOType.PetShelter.getValue())){
            organization = new PetShelterOrganization();
            organization.setName(name);
            organizationList.add(organization);
            }
        }
        return organization;
    }
}