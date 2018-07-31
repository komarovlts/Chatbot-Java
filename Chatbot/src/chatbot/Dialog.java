/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author omarc
 */
public class Dialog {
    //Campos de clase.
    
    /**
     * Constructor del Dialog.
     */
    public Dialog(){
    }
    
    public void iniciarConversación(){
    
    }
    
    /** 
    * Método que desarrolla la conversación a través de comandos específicos e
    * indentificadores, este método sólo se detiene con el comando !stop, hasta
    * que este comando no sea utilizado se seguirá dando al usuario la opción
    * de ingresar datos por consola.
     * @param personalidadInicial
     * @return log, lista de strings que representa el historial de la conversación.
    * @throws IOException, excepción de Input/Output derivada de ciertos submétodos.
    */
    public Log conversacionNormal(int personalidadInicial, Log log) throws IOException {
        
        Usuario usuario = new Usuario();
        Chatbot chatbot = new Chatbot();
        
        chatbot.beginDialog(personalidadInicial,log);
        
	Scanner lecturaConsolaConversacion = new Scanner(System.in);
        String mensajeUsuario = lecturaConsolaConversacion.nextLine();
        String mensaje;
        String ultimoMensaje;
        String advertencia = "Chatbot: Aún no se ha finalizado la conversación o este ya fue evaluado.";       
        
        while(!"!stop".equals(mensajeUsuario)){
            //Start beginDialog.
            if("!beginDialog 0".equals(mensajeUsuario) || "!beginDialog cero".equals(mensajeUsuario) ||
	    "!beginDialog Cero".equals(mensajeUsuario) || "!beginDialog CERO".equals(mensajeUsuario)){
                if(log.getLog().isEmpty()){
                    chatbot.beginDialog(0,log);
                    chatbot.setChatbot(0);
                }
                else if(log.getUltimo(log.getLog()).equals("|Chatbot evaluado|")){
                    chatbot.beginDialog(0,log);
                    chatbot.setChatbot(0);
                }
                else{
                ultimoMensaje = log.getUltimo(log.getLog());
                mensaje = chatbot.addMetaDatos("Chatbot: Lo lamento, debes terminar y evaluar la conversación anterior antes de comenzar una nueva.");
                System.out.println("Chatbot: Lo lamento, debes terminar y evaluar la conversación anterior antes de comenzar una nueva.");
                log.addLog(log.getLog(), mensaje);
                log.addLog(log.getLog(), ultimoMensaje);
                }
            }
            else if("!beginDialog 1".equals(mensajeUsuario) || "!beginDialog uno".equals(mensajeUsuario) ||
               "!beginDialog Uno".equals(mensajeUsuario) || "!beginDialog UNO".equals(mensajeUsuario)){
                if(log.getLog().isEmpty()){
                    chatbot.beginDialog(1,log);
                    chatbot.setChatbot(1);
                }
                else if(log.getUltimo(log.getLog()).equals("|Chatbot evaluado|")){
                    chatbot.beginDialog(1,log);
                    chatbot.setChatbot(1);
                }
                else{
                    ultimoMensaje = log.getUltimo(log.getLog());
                    mensaje = chatbot.addMetaDatos("Chatbot: Lo lamento, debes terminar y evaluar la conversación anterior antes de comenzar una nueva.");
                    System.out.println("Chatbot: Lo lamento, debes terminar y evaluar la conversación anterior antes de comenzar una nueva.");
                    log.addLog(log.getLog(), mensaje);
                    log.addLog(log.getLog(), ultimoMensaje);
                }
            }
            else if("!beginDialog".equals(mensajeUsuario)){
                if(log.getLog().isEmpty()){
                    chatbot.beginDialog(1,log);
                    chatbot.setChatbot(1);
                }
                else if(log.getUltimo(log.getLog()).equals("|Chatbot evaluado|")){
                    chatbot.beginDialog(1,log);
                    chatbot.setChatbot(1);
                }
                else{
                    ultimoMensaje = log.getUltimo(log.getLog());
                    mensaje = chatbot.addMetaDatos("Chatbot: Lo lamento, debes terminar y evaluar la conversación anterior antes de comenzar una nueva.");
                    System.out.println("Chatbot: Lo lamento, debes terminar y evaluar la conversación anterior antes de comenzar una nueva.");
                    log.addLog(log.getLog(), mensaje);
                    log.addLog(log.getLog(), ultimoMensaje);
                }
            }
            //End beginDialog.
            //Start Conversation.
            else if(log.getUltimo(log.getLog()).equals("|Nombre|")){
                usuario.setNombreUsuario(mensajeUsuario);
                if(chatbot.getChatbot() == 1){
                    mensaje = chatbot.addMetaDatos("Chatbot: ¿Cómo estás "+ mensajeUsuario +"?");
                    System.out.println("Chatbot: ¿Cómo estás "+ mensajeUsuario +"?");
                    log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), mensaje);
                }
                if(chatbot.getChatbot() == 0){
                    mensaje = chatbot.addMetaDatos("Chatbot: ¿Cómo estás "+ mensajeUsuario +"?");
                    System.out.println("Chatbot: ¿Cómo estai "+ mensajeUsuario +"?");
                    log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), mensaje);
                }
                log.addLog(log.getLog(), "|Respuesta1|");     
            }
            else if(log.getUltimo(log.getLog()).equals("|Respuesta1|") && !"!beginDialog 0".equals(mensajeUsuario) && !"!beginDialog cero".equals(mensajeUsuario) &&
	    !"!beginDialog Cero".equals(mensajeUsuario) && !"!beginDialog CERO".equals(mensajeUsuario) && !"!beginDialog 1".equals(mensajeUsuario) && !"!beginDialog uno".equals(mensajeUsuario) &&
            !"!beginDialog Uno".equals(mensajeUsuario) && !"!beginDialog UNO".equals(mensajeUsuario) && !"!beginDialog".equals(mensajeUsuario) &&  !"!rate 1".equals(mensajeUsuario) &&
            !"!rate 2".equals(mensajeUsuario) && !"!rate 3".equals(mensajeUsuario) && !"!rate 4".equals(mensajeUsuario) && !"!rate 5".equals(mensajeUsuario) && !"!endDialog".equals(mensajeUsuario) &&
            !"!saveLog".equals(mensajeUsuario) && !"!loadLog".equals(mensajeUsuario)){
                mensaje = chatbot.addMetaDatos("Chatbot: Oh, bueno. Estos son las marcas/modelos de autos de las homocinéticas que disponemos: 1.-Toyota Rav4, 2.-Renault Duster, 3.-Hyundai Tucson, 4.-Nissan Qashqai, 5.-Nissan Kicks, elija la opción que desea.");
                System.out.println("Chatbot: Oh, bueno. Estos son las marcas/modelos de autos de las homocinéticas que disponemos: 1.-Toyota Rav4, 2.-Renault Duster, 3.-Hyundai Tucson, 4.-Nissan Qashqai, 5.-Nissan Kicks, elija la opción que desea.");
                log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                log.addLog(log.getLog(), mensaje);   
                log.addLog(log.getLog(), "|Respuesta2|");     
            }
            else if(log.getUltimo(log.getLog()).equals("|Respuesta2|") && !"!beginDialog 0".equals(mensajeUsuario) && !"!beginDialog cero".equals(mensajeUsuario) &&
	    !"!beginDialog Cero".equals(mensajeUsuario) && !"!beginDialog CERO".equals(mensajeUsuario) && !"!beginDialog 1".equals(mensajeUsuario) && !"!beginDialog uno".equals(mensajeUsuario) &&
            !"!beginDialog Uno".equals(mensajeUsuario) && !"!beginDialog UNO".equals(mensajeUsuario) && !"!beginDialog".equals(mensajeUsuario) &&  !"!rate 1".equals(mensajeUsuario) &&
            !"!rate 2".equals(mensajeUsuario) && !"!rate 3".equals(mensajeUsuario) && !"!rate 4".equals(mensajeUsuario) && !"!rate 5".equals(mensajeUsuario) && !"!endDialog".equals(mensajeUsuario) &&
            !"!saveLog".equals(mensajeUsuario) && !"!loadLog".equals(mensajeUsuario)){
                mensaje = chatbot.addMetaDatos("Chatbot: Perfecto, ¿Cuántas querrá?");
                System.out.println("Chatbot: Perfecto, ¿Cuántas querrá?");
                log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                log.addLog(log.getLog(), mensaje);   
                log.addLog(log.getLog(), "|Respuesta3|");     
            }
            else if(log.getUltimo(log.getLog()).equals("|Respuesta3|") && !"!beginDialog 0".equals(mensajeUsuario) && !"!beginDialog cero".equals(mensajeUsuario) &&
	    !"!beginDialog Cero".equals(mensajeUsuario) && !"!beginDialog CERO".equals(mensajeUsuario) && !"!beginDialog 1".equals(mensajeUsuario) && !"!beginDialog uno".equals(mensajeUsuario) &&
            !"!beginDialog Uno".equals(mensajeUsuario) && !"!beginDialog UNO".equals(mensajeUsuario) && !"!beginDialog".equals(mensajeUsuario) &&  !"!rate 1".equals(mensajeUsuario) &&
            !"!rate 2".equals(mensajeUsuario) && !"!rate 3".equals(mensajeUsuario) && !"!rate 4".equals(mensajeUsuario) && !"!rate 5".equals(mensajeUsuario) && !"!endDialog".equals(mensajeUsuario) &&
            !"!saveLog".equals(mensajeUsuario) && !"!loadLog".equals(mensajeUsuario)){
                mensaje = chatbot.addMetaDatos("Chatbot: Excelente, ¿Desea comprar algo más?");
                System.out.println("Chatbot: Excelente, ¿Desea comprar algo más?");
                log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                log.addLog(log.getLog(), mensaje);   
                log.addLog(log.getLog(), "|Respuesta4|");     
            }
            else if(log.getUltimo(log.getLog()).equals("|Respuesta4|") && !"!beginDialog 0".equals(mensajeUsuario) && !"!beginDialog cero".equals(mensajeUsuario) &&
	    !"!beginDialog Cero".equals(mensajeUsuario) && !"!beginDialog CERO".equals(mensajeUsuario) && !"!beginDialog 1".equals(mensajeUsuario) && !"!beginDialog uno".equals(mensajeUsuario) &&
            !"!beginDialog Uno".equals(mensajeUsuario) && !"!beginDialog UNO".equals(mensajeUsuario) && !"!beginDialog".equals(mensajeUsuario) &&  !"!rate 1".equals(mensajeUsuario) &&
            !"!rate 2".equals(mensajeUsuario) && !"!rate 3".equals(mensajeUsuario) && !"!rate 4".equals(mensajeUsuario) && !"!rate 5".equals(mensajeUsuario) && !"!endDialog".equals(mensajeUsuario) &&
            !"!saveLog".equals(mensajeUsuario) && !"!loadLog".equals(mensajeUsuario)){
                if(mensajeUsuario.equals("Sí") || mensajeUsuario.equals("Si") || mensajeUsuario.equals("sí") || mensajeUsuario.equals("si")
                || mensajeUsuario.equals("Sí, me gustaría comprar algo más") || mensajeUsuario.equals("Si, me gustaria comprar algo mas")
                || mensajeUsuario.equals("sí, me gustaría comprar algo más") || mensajeUsuario.equals("si, me gustaria comprar algo mas"))
                {
                    mensaje = chatbot.addMetaDatos("Chatbot: ¡Okey! Estos son las marcas/modelos de autos de las homocinéticas que disponemos: 1.-Toyota Rav4, 2.-Renault Duster, 3.-Hyundai Tucson, 4.-Nissan Qashqai, 5.-Nissan Kicks, elija la opción que desea.");
                    System.out.println("Chatbot: ¡Okey! Estos son las marcas/modelos de autos de las homocinéticas que disponemos: 1.-Toyota Rav4, 2.-Renault Duster, 3.-Hyundai Tucson, 4.-Nissan Qashqai, 5.-Nissan Kicks, elija la opción que desea.");
                    log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), mensaje);
                    log.addLog(log.getLog(), "|Respuesta2|"); 
                }
                else if(mensajeUsuario.equals("No") || mensajeUsuario.equals("no")
                || mensajeUsuario.equals("No, no me gustaría comprar algo más") || mensajeUsuario.equals("no, no me gustaria comprar algo mas"))
                {
                    mensaje = chatbot.addMetaDatos("Chatbot: ¡Está bien! Todos sus items han sido agregados a su carro.");
                    System.out.println("Chatbot: ¡Está bien! Todos sus items han sido agregados a su carro.");
                    log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), mensaje);  
                }
                else{
                    mensaje = chatbot.addMetaDatos("Chatbot: Lo lamento, no logro entenderte, ¿Podrías repetirlo?");
                    System.out.println("Chatbot: Lo lamento, no logro entenderte, ¿Podrías repetirlo?");
                    log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), mensaje);
                    log.addLog(log.getLog(), "|Error|");
                    log.addLog(log.getLog(), "|Respuesta4|");              
                }
            }
            //End Conversation.
            //Start rate.
            else if("!rate 1".equals(mensajeUsuario)){
                if(log.getUltimo(log.getLog()).equals("|Fin de la Conversación|")){
                   chatbot.rate(1,log);
                   chatbot.addDatosFinales(log, usuario);
                   return log;
                } 
                else{
                    System.out.println(advertencia);
                    log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), chatbot.addMetaDatos(advertencia));
                }
            }
            else if("!rate 2".equals(mensajeUsuario)){
                if(log.getUltimo(log.getLog()).equals("|Fin de la Conversación|")){
                   chatbot.rate(2,log);
                   chatbot.addDatosFinales(log, usuario);
                   return log;
                } 
                else{
                    System.out.println(advertencia);
                    log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), chatbot.addMetaDatos(advertencia));
                }
            }
            else if("!rate 3".equals(mensajeUsuario)){
                if(log.getUltimo(log.getLog()).equals("|Fin de la Conversación|")){
                   chatbot.rate(3,log);
                   chatbot.addDatosFinales(log, usuario);
                   return log;
                } 
                else{
                    System.out.println(advertencia);
                    log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), chatbot.addMetaDatos(advertencia));
                }
            }
            else if("!rate 4".equals(mensajeUsuario)){
                if(log.getUltimo(log.getLog()).equals("|Fin de la Conversación|")){
                   chatbot.rate(4,log);
                   chatbot.addDatosFinales(log, usuario);
                   return log;
                } 
                else{
                    System.out.println(advertencia);
                    log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), chatbot.addMetaDatos(advertencia));
                }
            }
            else if("!rate 5".equals(mensajeUsuario)){
                if(log.getUltimo(log.getLog()).equals("|Fin de la Conversación|")){
                   chatbot.rate(5,log);
                   chatbot.addDatosFinales(log, usuario);
                   return log;
                } 
                else{
                    System.out.println(advertencia);
                    log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), chatbot.addMetaDatos(advertencia));
                }
            }
            //End rate.
            //Start endDialog.
            else if("!endDialog".equals(mensajeUsuario)){
                chatbot.endDialog(chatbot.getChatbot(),log);
            }
            //End endDialog.
            else if("!saveLog".equals(mensajeUsuario)){
                log.saveLog(log.getLog());
            }
            else if("!loadLog".equals(mensajeUsuario)){
                System.out.println("Ingrese el nombre del archivo: ");
                mensajeUsuario = lecturaConsolaConversacion.nextLine();
                log.loadLog(mensajeUsuario);
            }
        mensajeUsuario = lecturaConsolaConversacion.nextLine();
        }
        log.addLog(log.getLog(), "|Fin|"); 
        return log;
    }
    
    /** 
    * Método que desarrolla la conversación a través de comandos específicos e
    * indentificadores, este método sólo se detiene con el comando !stop, hasta
    * que este comando no sea utilizado se seguirá dando al usuario la opción
    * de ingresar datos por consola.
     * @param log, lista de strings que representa el historial de la conversación cargada.
     * @return log, lista de strings que representa el historial de la conversación.
    * @throws IOException, excepción de Input/Output derivada de ciertos submétodos.
    */
    public Log conversacionCargada(Log log) throws IOException {
        Usuario usuario = new Usuario();
        Chatbot chatbot = new Chatbot();
                
	Scanner lecturaConsolaConversacion = new Scanner(System.in);
        String mensajeUsuario = lecturaConsolaConversacion.nextLine();
        String mensaje;
        String ultimoMensaje;
        String advertencia = "Chatbot: Aún no se ha finalizado la conversación o este ya fue evaluado.";       
        
        while(!"!stop".equals(mensajeUsuario)){
            //Start beginDialog.
            if("!beginDialog 0".equals(mensajeUsuario) || "!beginDialog cero".equals(mensajeUsuario) ||
	    "!beginDialog Cero".equals(mensajeUsuario) || "!beginDialog CERO".equals(mensajeUsuario)){
                if(log.getLog().isEmpty()){
                    chatbot.beginDialog(0,log);
                    chatbot.setChatbot(0);
                }
                else if(log.getUltimo(log.getLog()).equals("|Chatbot evaluado|")){
                    chatbot.beginDialog(0,log);
                    chatbot.setChatbot(0);
                }
                else{
                ultimoMensaje = log.getUltimo(log.getLog());
                mensaje = chatbot.addMetaDatos("Chatbot: Lo lamento, debes terminar y evaluar la conversación anterior antes de comenzar una nueva.");
                System.out.println("Chatbot: Lo lamento, debes terminar y evaluar la conversación anterior antes de comenzar una nueva.");
                log.addLog(log.getLog(), mensaje);
                log.addLog(log.getLog(), ultimoMensaje);
                }
            }
            else if("!beginDialog 1".equals(mensajeUsuario) || "!beginDialog uno".equals(mensajeUsuario) ||
               "!beginDialog Uno".equals(mensajeUsuario) || "!beginDialog UNO".equals(mensajeUsuario)){
                if(log.getLog().isEmpty()){
                    chatbot.beginDialog(1,log);
                    chatbot.setChatbot(1);
                }
                else if(log.getUltimo(log.getLog()).equals("|Chatbot evaluado|")){
                    chatbot.beginDialog(1,log);
                    chatbot.setChatbot(1);
                }
                else{
                    ultimoMensaje = log.getUltimo(log.getLog());
                    mensaje = chatbot.addMetaDatos("Chatbot: Lo lamento, debes terminar y evaluar la conversación anterior antes de comenzar una nueva.");
                    System.out.println("Chatbot: Lo lamento, debes terminar y evaluar la conversación anterior antes de comenzar una nueva.");
                    log.addLog(log.getLog(), mensaje);
                    log.addLog(log.getLog(), ultimoMensaje);
                }
            }
            else if("!beginDialog".equals(mensajeUsuario)){
                if(log.getLog().isEmpty()){
                    chatbot.beginDialog(1,log);
                    chatbot.setChatbot(1);
                }
                else if(log.getUltimo(log.getLog()).equals("|Chatbot evaluado|")){
                    chatbot.beginDialog(1,log);
                    chatbot.setChatbot(1);
                }
                else{
                    ultimoMensaje = log.getUltimo(log.getLog());
                    mensaje = chatbot.addMetaDatos("Chatbot: Lo lamento, debes terminar y evaluar la conversación anterior antes de comenzar una nueva.");
                    System.out.println("Chatbot: Lo lamento, debes terminar y evaluar la conversación anterior antes de comenzar una nueva.");
                    log.addLog(log.getLog(), mensaje);
                    log.addLog(log.getLog(), ultimoMensaje);
                }
            }
            //End beginDialog.
            //Start Conversation.
            else if(log.getUltimo(log.getLog()).equals("|Nombre|")){
                usuario.setNombreUsuario(mensajeUsuario);
                if(chatbot.getChatbot() == 1){
                    mensaje = chatbot.addMetaDatos("Chatbot: ¿Cómo estás "+ mensajeUsuario +"?");
                    System.out.println("Chatbot: ¿Cómo estás "+ mensajeUsuario +"?");
                    log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), mensaje);
                }
                if(chatbot.getChatbot() == 0){
                    mensaje = chatbot.addMetaDatos("Chatbot: ¿Cómo estás "+ mensajeUsuario +"?");
                    System.out.println("Chatbot: ¿Cómo estai "+ mensajeUsuario +"?");
                    log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), mensaje);
                }
                log.addLog(log.getLog(), "|Respuesta1|");     
            }
            else if(log.getUltimo(log.getLog()).equals("|Respuesta1|") && !"!beginDialog 0".equals(mensajeUsuario) && !"!beginDialog cero".equals(mensajeUsuario) &&
	    !"!beginDialog Cero".equals(mensajeUsuario) && !"!beginDialog CERO".equals(mensajeUsuario) && !"!beginDialog 1".equals(mensajeUsuario) && !"!beginDialog uno".equals(mensajeUsuario) &&
            !"!beginDialog Uno".equals(mensajeUsuario) && !"!beginDialog UNO".equals(mensajeUsuario) && !"!beginDialog".equals(mensajeUsuario) &&  !"!rate 1".equals(mensajeUsuario) &&
            !"!rate 2".equals(mensajeUsuario) && !"!rate 3".equals(mensajeUsuario) && !"!rate 4".equals(mensajeUsuario) && !"!rate 5".equals(mensajeUsuario) && !"!endDialog".equals(mensajeUsuario) &&
            !"!saveLog".equals(mensajeUsuario) && !"!loadLog".equals(mensajeUsuario)){
                mensaje = chatbot.addMetaDatos("Chatbot: Oh, bueno. Estos son las marcas/modelos de autos de las homocinéticas que disponemos: 1.-Toyota Rav4, 2.-Renault Duster, 3.-Hyundai Tucson, 4.-Nissan Qashqai, 5.-Nissan Kicks, elija la opción que desea.");
                System.out.println("Chatbot: Oh, bueno. Estos son las marcas/modelos de autos de las homocinéticas que disponemos: 1.-Toyota Rav4, 2.-Renault Duster, 3.-Hyundai Tucson, 4.-Nissan Qashqai, 5.-Nissan Kicks, elija la opción que desea.");
                log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                log.addLog(log.getLog(), mensaje);   
                log.addLog(log.getLog(), "|Respuesta2|");     
            }
            else if(log.getUltimo(log.getLog()).equals("|Respuesta2|") && !"!beginDialog 0".equals(mensajeUsuario) && !"!beginDialog cero".equals(mensajeUsuario) &&
	    !"!beginDialog Cero".equals(mensajeUsuario) && !"!beginDialog CERO".equals(mensajeUsuario) && !"!beginDialog 1".equals(mensajeUsuario) && !"!beginDialog uno".equals(mensajeUsuario) &&
            !"!beginDialog Uno".equals(mensajeUsuario) && !"!beginDialog UNO".equals(mensajeUsuario) && !"!beginDialog".equals(mensajeUsuario) &&  !"!rate 1".equals(mensajeUsuario) &&
            !"!rate 2".equals(mensajeUsuario) && !"!rate 3".equals(mensajeUsuario) && !"!rate 4".equals(mensajeUsuario) && !"!rate 5".equals(mensajeUsuario) && !"!endDialog".equals(mensajeUsuario) &&
            !"!saveLog".equals(mensajeUsuario) && !"!loadLog".equals(mensajeUsuario)){
                mensaje = chatbot.addMetaDatos("Chatbot: Perfecto, ¿Cuántas querrá?");
                System.out.println("Chatbot: Perfecto, ¿Cuántas querrá?");
                log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                log.addLog(log.getLog(), mensaje);   
                log.addLog(log.getLog(), "|Respuesta3|");     
            }
            else if(log.getUltimo(log.getLog()).equals("|Respuesta3|") && !"!beginDialog 0".equals(mensajeUsuario) && !"!beginDialog cero".equals(mensajeUsuario) &&
	    !"!beginDialog Cero".equals(mensajeUsuario) && !"!beginDialog CERO".equals(mensajeUsuario) && !"!beginDialog 1".equals(mensajeUsuario) && !"!beginDialog uno".equals(mensajeUsuario) &&
            !"!beginDialog Uno".equals(mensajeUsuario) && !"!beginDialog UNO".equals(mensajeUsuario) && !"!beginDialog".equals(mensajeUsuario) &&  !"!rate 1".equals(mensajeUsuario) &&
            !"!rate 2".equals(mensajeUsuario) && !"!rate 3".equals(mensajeUsuario) && !"!rate 4".equals(mensajeUsuario) && !"!rate 5".equals(mensajeUsuario) && !"!endDialog".equals(mensajeUsuario) &&
            !"!saveLog".equals(mensajeUsuario) && !"!loadLog".equals(mensajeUsuario)){
                mensaje = chatbot.addMetaDatos("Chatbot: Excelente, ¿Desea comprar algo más?");
                System.out.println("Chatbot: Excelente, ¿Desea comprar algo más?");
                log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                log.addLog(log.getLog(), mensaje);   
                log.addLog(log.getLog(), "|Respuesta4|");     
            }
            else if(log.getUltimo(log.getLog()).equals("|Respuesta4|") && !"!beginDialog 0".equals(mensajeUsuario) && !"!beginDialog cero".equals(mensajeUsuario) &&
	    !"!beginDialog Cero".equals(mensajeUsuario) && !"!beginDialog CERO".equals(mensajeUsuario) && !"!beginDialog 1".equals(mensajeUsuario) && !"!beginDialog uno".equals(mensajeUsuario) &&
            !"!beginDialog Uno".equals(mensajeUsuario) && !"!beginDialog UNO".equals(mensajeUsuario) && !"!beginDialog".equals(mensajeUsuario) &&  !"!rate 1".equals(mensajeUsuario) &&
            !"!rate 2".equals(mensajeUsuario) && !"!rate 3".equals(mensajeUsuario) && !"!rate 4".equals(mensajeUsuario) && !"!rate 5".equals(mensajeUsuario) && !"!endDialog".equals(mensajeUsuario) &&
            !"!saveLog".equals(mensajeUsuario) && !"!loadLog".equals(mensajeUsuario)){
                if(mensajeUsuario.equals("Sí") || mensajeUsuario.equals("Si") || mensajeUsuario.equals("sí") || mensajeUsuario.equals("si")
                || mensajeUsuario.equals("Sí, me gustaría comprar algo más") || mensajeUsuario.equals("Si, me gustaria comprar algo mas")
                || mensajeUsuario.equals("sí, me gustaría comprar algo más") || mensajeUsuario.equals("si, me gustaria comprar algo mas"))
                {
                    mensaje = chatbot.addMetaDatos("Chatbot: ¡Okey! Estos son las marcas/modelos de autos de las homocinéticas que disponemos: 1.-Toyota Rav4, 2.-Renault Duster, 3.-Hyundai Tucson, 4.-Nissan Qashqai, 5.-Nissan Kicks, elija la opción que desea.");
                    System.out.println("Chatbot: ¡Okey! Estos son las marcas/modelos de autos de las homocinéticas que disponemos: 1.-Toyota Rav4, 2.-Renault Duster, 3.-Hyundai Tucson, 4.-Nissan Qashqai, 5.-Nissan Kicks, elija la opción que desea.");
                    log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), mensaje);
                    log.addLog(log.getLog(), "|Respuesta2|"); 
                }
                else if(mensajeUsuario.equals("No") || mensajeUsuario.equals("no")
                || mensajeUsuario.equals("No, no me gustaría comprar algo más") || mensajeUsuario.equals("no, no me gustaria comprar algo mas"))
                {
                    mensaje = chatbot.addMetaDatos("Chatbot: ¡Está bien! Todos sus items han sido agregados a su carro.");
                    System.out.println("Chatbot: ¡Está bien! Todos sus items han sido agregados a su carro.");
                    log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), mensaje);  
                }
                else{
                    mensaje = chatbot.addMetaDatos("Chatbot: Lo lamento, no logro entenderte, ¿Podrías repetirlo?");
                    System.out.println("Chatbot: Lo lamento, no logro entenderte, ¿Podrías repetirlo?");
                    log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), mensaje);
                    log.addLog(log.getLog(), "|Error|");
                    log.addLog(log.getLog(), "|Respuesta4|");              
                }
            }
            //End Conversation.
            //Start rate.
            else if("!rate 1".equals(mensajeUsuario)){
                if(log.getUltimo(log.getLog()).equals("|Fin de la Conversación|")){
                   chatbot.rate(1,log);
                   chatbot.addDatosFinales(log, usuario);
                   return log;
                } 
                else{
                    System.out.println(advertencia);
                    log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), chatbot.addMetaDatos(advertencia));
                }
            }
            else if("!rate 2".equals(mensajeUsuario)){
                if(log.getUltimo(log.getLog()).equals("|Fin de la Conversación|")){
                   chatbot.rate(2,log);
                   chatbot.addDatosFinales(log, usuario);
                   return log;
                } 
                else{
                    System.out.println(advertencia);
                    log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), chatbot.addMetaDatos(advertencia));
                }
            }
            else if("!rate 3".equals(mensajeUsuario)){
                if(log.getUltimo(log.getLog()).equals("|Fin de la Conversación|")){
                   chatbot.rate(3,log);
                   chatbot.addDatosFinales(log, usuario);
                   return log;
                } 
                else{
                    System.out.println(advertencia);
                    log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), chatbot.addMetaDatos(advertencia));
                }
            }
            else if("!rate 4".equals(mensajeUsuario)){
                if(log.getUltimo(log.getLog()).equals("|Fin de la Conversación|")){
                   chatbot.rate(4,log);
                   chatbot.addDatosFinales(log, usuario);
                   return log;
                } 
                else{
                    System.out.println(advertencia);
                    log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), chatbot.addMetaDatos(advertencia));
                }
            }
            else if("!rate 5".equals(mensajeUsuario)){
                if(log.getUltimo(log.getLog()).equals("|Fin de la Conversación|")){
                   chatbot.rate(5,log);
                   chatbot.addDatosFinales(log, usuario);
                   return log;
                } 
                else{
                    System.out.println(advertencia);
                    log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), chatbot.addMetaDatos(advertencia));
                }
            }
            //End rate.
            //Start endDialog.
            else if("!endDialog".equals(mensajeUsuario)){
                chatbot.endDialog(chatbot.getChatbot(),log);
            }
            //End endDialog.
            else if("!saveLog".equals(mensajeUsuario)){
                log.saveLog(log.getLog());
            }
            else if("!loadLog".equals(mensajeUsuario)){
                System.out.println("Ingrese el nombre del archivo: ");
                mensajeUsuario = lecturaConsolaConversacion.nextLine();
                log.loadLog(mensajeUsuario);
            }
        mensajeUsuario = lecturaConsolaConversacion.nextLine();
        }
        log.addLog(log.getLog(), "|Fin|"); 
        return log;
    }
}
