/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.POJO;

import java.util.HashSet;
import java.util.Random;

/**
 *
 * @author rishijatania
 */
public class IDGenerator {
     private static IDGenerator instance;
     private final Random rand;
     private final int orgIdrange;
     private final int requestIdrange;
     HashSet orgSet;
     HashSet reqSet; 

    public IDGenerator() {
        rand = new Random();
        this.orgIdrange = 1000;
        this.requestIdrange = 1000;
    }

    public HashSet getOrgSet() {
        if(orgSet==null){
            return orgSet=new HashSet<>();
        }
        return orgSet;
    }

    public void setOrgSet(HashSet orgSet) {
        this.orgSet = orgSet;
    }
    
    public HashSet getReqSet() {
        if(reqSet==null){
            return reqSet=new HashSet<>();
        }
        return reqSet;
    }
    
     public void setReqSet(HashSet reqSet) {
        this.reqSet = reqSet;
    }
    
    public int getOrgId(){ 
        int orgid;
        do{
            orgid=rand.nextInt(orgIdrange);
        }while(this.getOrgSet().contains(orgid));
        this.getOrgSet().add(orgid);        
        return orgid;
    }
    
    public int getReqId(){ 
        int reqid;
        do{
            reqid=rand.nextInt(requestIdrange);
        }while(this.getReqSet().contains(reqid));
        this.getReqSet().add(reqid);        
        return reqid;
    }
    
}
