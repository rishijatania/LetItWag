/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Business.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Suraj PC
 */
public class Vald {
    
    private static Vald vald;
    
    public static Vald getInstance(){
        if(vald==null){
            vald=new Vald();
        }
        return vald;
    }
    
    public boolean validName(String name){
        Pattern p = Pattern.compile("[0-9@#$%^]+");
        Matcher m = p.matcher(name);
        if(m.find()){
            //match for bad data 
            return false;
        }else{
            //true data
            return true;
        }
    }
    public boolean validEmail(String email){
        Pattern p = Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$");
        Matcher m = p.matcher(email);
        if(m.find()){
            //valid email
            return true;
        }else{
            return false;
        }
    }
    public boolean validNum(String numbr){
        Pattern p = Pattern.compile("^[0-9]*$");
        Matcher m = p.matcher(numbr);
        if(m.find()){
            //match good to go data
            return true;
        }else{
            //no match fail data
            return false;
        }
    }

}
