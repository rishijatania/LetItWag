/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.POJO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author rishijatania
 */
public class PetsDirectory  {
    private ArrayList<Pet> pets;
    
    public ArrayList<Pet> getListOfPets(){
        if(pets==null){
            return pets=new ArrayList<Pet>();
        }
        return pets;
    }
    
    public List<Pet> getAbusedPets(){
        return pets.stream().filter(pet->pet.getHasBeenReportedForAbuse() && null==pet.getRegPCNO())
                     .collect(Collectors.toList());
    }
    
    public List<Pet> getStrayPets(){
        return pets.stream().filter(pet->pet.getIsStray() && null==pet.getRegPCNO())
                     .collect(Collectors.toList());
    }
    
    public List<Pet> getPetsAvailableForAdoption(){
        return pets.stream().filter(pet->pet.getIsAvailableForAdoption())
                     .collect(Collectors.toList());
    }
    
}
