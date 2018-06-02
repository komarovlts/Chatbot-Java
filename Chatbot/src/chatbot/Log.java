/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot;

import java.util.*;

/**
 *
 * @author Omar Antonio Carrasco Escudero - Kömarøv
 */
public class Log {    
    public boolean esLog(List Log){
        if(Log.isEmpty()){
            return true;
        }
        else{
            try{
            Iterator<String> iterator = Log.iterator();
            int i = 0;
            while (iterator.hasNext()) {
                i++;
                if(i > Log.size()){
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
   
    public List setLog(List Log, String Msg){
       Log.add(Msg);
       return Log;
   }
}
