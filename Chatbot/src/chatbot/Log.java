/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot;

import java.util.*;
import java.io.*;
/**
 *
 * @author Omar Antonio Carrasco Escudero - Kömarøv
 */



public class Log{

    public List log;
    
    public Log(){
        this.log = new ArrayList();
    }
    
    
    public boolean esLog(List log){
        this.log = log;
        if(log.isEmpty()){
            return true;
        }
        else{
            try{
            Iterator<String> iterator = log.iterator();
            int i = 0;
            while (iterator.hasNext()) {
                i++;
                if(i > log.size()){
                    break;
                    }
                }
            return true;
            }
            catch(Exception e){
               return false;
            }
        }
    }
   
    public List setLog(List log, String Msg){
       this.log = log;
       log.add(Msg);
       return log;
    }
    
    public void saveLog(List Log){
        
    }
   
    public void loadLog(List Log){
   
    }
}
