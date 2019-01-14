/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.POJO;

import java.util.ArrayList;

/**
 *
 * @author rishijatania
 */
public class UserDirectory {
    private final ArrayList<Users> usersList= new ArrayList<Users>();
    
    public ArrayList<Users> getUsersList() {
        return usersList;
    }
    
    public Users authenticateUser(String username, String password){
        for (Users ua : usersList)
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)){
                return ua;
            }
        return null;
    }
    
    public Users createUserAccount(String username, String password, String name, String email, String city , String zip ){
        Users user = new Users();
        user.setUsername(username);
        user.setPassword(password);
        user.setCity(city);
        user.setName(name);
        user.setUserEmail(email);
        user.setZipCode(zip);
        usersList.add(user);
        return user;
    }
    
    public boolean checkIfUsernameIsUnique(String username){
//        for all usernames in useraccountlist get if username is equal to current
        
        return usersList.stream().noneMatch((ua) -> (ua.getUsername().equals(username)));
    }
    
}
