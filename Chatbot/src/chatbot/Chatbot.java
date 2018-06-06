/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Omar Antonio Carrasco Escudero - Kömarøv
 */
public class Chatbot {
    
    public String tiempoActual;
    
    public void Chatbot(){
    
    
        List listaLog = new ArrayList();
        Usuario nuevoUsuario = new Usuario();
        Log log = new Log(); 
        Scanner lecturaConsola = new Scanner(System.in);
        
        
        System.out.println("Este chatbot te ayuda a realizar un pedido de homocinéticas");
        String mensajeUsuario =  lecturaConsola.next();
        while (mensajeUsuario != "!beginDialog" || mensajeUsuario != "!endDialog"){
            switch(mensajeUsuario){
                case "!beginDialog":
                    System.out.println("Hola!");
                    break;
                case "!endDialog":
                    System.out.println("Chao!");
                    break;
            }
            break;
        }
        
    }

    
    public void beginDiaglog(){
        
    }
    
    public void endDiaglog(){
        
    }
    
    public String TiempoActual(){
        DateTimeFormatter formatoTiempoActual = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
	return ("["+ formatoTiempoActual.format(now)+ "]");
    }
}
