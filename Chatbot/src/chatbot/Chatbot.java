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
        
        System.out.println("Este chatbot te ayuda a realizar un pedido de homocinéticas");

    }
    
    public String TiempoActual(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
	return ("["+ dtf.format(now)+ "]");
    }
}
