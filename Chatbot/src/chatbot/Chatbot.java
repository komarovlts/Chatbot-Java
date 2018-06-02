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
    
    public List Log;
    
    public void Chatbot(){
    TiempoActual tiempoActual = new TiempoActual();
    Usuario usuarioUno = new Usuario();
    Log posibleLog = new Log();
        
    tiempoActual.TiempoActual();
        
    System.out.println("Este chatbot te ayuda a realizar un pedido de homocinéticas");
    System.out.println(posibleLog);
        if(posibleLog.esLog(Log)){
            Log.add(0,tiempoActual);
            usuarioUno.setNombreUsuario("Omar");
            Log.setLog(Log , usuarioUno.getNombreUsuario());
            System.out.println(posibleLog);
        }
    }
    
    public String TiempoActual(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
	return ("["+ dtf.format(now)+ "]");
    }
}
