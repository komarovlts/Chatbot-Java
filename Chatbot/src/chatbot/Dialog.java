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
    private boolean conversacionEnCurso;
    /**
     * Constructor del Dialog.
     */
    public Dialog(){
        this.conversacionEnCurso = true;
    }
    /**
     * Método para cambiar de estado la conversación.
     */
    public void setOffDialog(){
        conversacionEnCurso = false;
    }
    
    /** 
     * Método que desarrolla la conversación a través de comandos específicos e
     * indentificadores, este método sólo se detiene con el comando !stop, hasta
     * que este comando no sea utilizado se seguirá dando al usuario la opción
     * de ingresar datos por consola.
     * @param personalidadInicial
     * @param log, lista de strings que representa el historial hasta el momento de la conversación.
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
        String advertencia = "Chatbot: Aun no se ha finalizado la conversacion o este ya fue evaluado.";
        int notaChatbot; 
        int notaUsuario;
        
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
                System.out.println("Chatbot: Lo lamento, debes terminar y evaluar la conversacion anterior antes de comenzar una nueva.");
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
                    System.out.println("Chatbot: Lo lamento, debes terminar y evaluar la conversacion anterior antes de comenzar una nueva.");
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
                    System.out.println("Chatbot: Lo lamento, debes terminar y evaluar la conversacion anterior antes de comenzar una nueva.");
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
                    System.out.println("Chatbot: Como estas "+ mensajeUsuario +"?");
                    log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), mensaje);
                }
                if(chatbot.getChatbot() == 0){
                    mensaje = chatbot.addMetaDatos("Chatbot: ¿Cómo estai "+ mensajeUsuario +"?");
                    System.out.println("Chatbot: Como estai "+ mensajeUsuario +"?");
                    log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), mensaje);
                }
                log.addLog(log.getLog(), "|Respuesta1|");     
            }
            else if(log.getUltimo(log.getLog()).equals("|Respuesta1|") && !"!beginDialog 0".equals(mensajeUsuario) && !"!beginDialog cero".equals(mensajeUsuario) &&
	    !"!beginDialog Cero".equals(mensajeUsuario) && !"!beginDialog CERO".equals(mensajeUsuario) && !"!beginDialog 1".equals(mensajeUsuario) && !"!beginDialog uno".equals(mensajeUsuario) &&
            !"!beginDialog Uno".equals(mensajeUsuario) && !"!beginDialog UNO".equals(mensajeUsuario) && !"!beginDialog".equals(mensajeUsuario) && !mensajeUsuario.contains("!rate ") && 
            !"!endDialog".equals(mensajeUsuario) && !"!saveLog".equals(mensajeUsuario) && !mensajeUsuario.contains("!loadLog ")){
                mensaje = chatbot.addMetaDatos("Chatbot: Oh, bueno. Estos son las marcas/modelos de autos de las homocinéticas que disponemos: 1.-Toyota Rav4, 2.-Renault Duster, 3.-Hyundai Tucson, 4.-Nissan Qashqai, 5.-Nissan Kicks, elija la opción que desea.");
                System.out.println("Chatbot: Oh, bueno. Estos son las marcas/modelos de autos de las homocineticas que disponemos: 1.-Toyota Rav4, 2.-Renault Duster, 3.-Hyundai Tucson, 4.-Nissan Qashqai, 5.-Nissan Kicks, elija la opcion que desea.");
                log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                log.addLog(log.getLog(), mensaje);   
                log.addLog(log.getLog(), "|Respuesta2|");     
            }
            else if(log.getUltimo(log.getLog()).equals("|Respuesta2|") && !"!beginDialog 0".equals(mensajeUsuario) && !"!beginDialog cero".equals(mensajeUsuario) &&
	    !"!beginDialog Cero".equals(mensajeUsuario) && !"!beginDialog CERO".equals(mensajeUsuario) && !"!beginDialog 1".equals(mensajeUsuario) && !"!beginDialog uno".equals(mensajeUsuario) &&
            !"!beginDialog Uno".equals(mensajeUsuario) && !"!beginDialog UNO".equals(mensajeUsuario) && !"!beginDialog".equals(mensajeUsuario) && !mensajeUsuario.contains("!rate ") && 
            !"!endDialog".equals(mensajeUsuario) && !"!saveLog".equals(mensajeUsuario) && !mensajeUsuario.contains("!loadLog ")){
                mensaje = chatbot.addMetaDatos("Chatbot: Perfecto, ¿Cuántas querrá?");
                System.out.println("Chatbot: Perfecto, Cuantas querra?");
                log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                log.addLog(log.getLog(), mensaje);   
                log.addLog(log.getLog(), "|Respuesta3|");     
            }
            else if(log.getUltimo(log.getLog()).equals("|Respuesta3|") && !"!beginDialog 0".equals(mensajeUsuario) && !"!beginDialog cero".equals(mensajeUsuario) &&
	    !"!beginDialog Cero".equals(mensajeUsuario) && !"!beginDialog CERO".equals(mensajeUsuario) && !"!beginDialog 1".equals(mensajeUsuario) && !"!beginDialog uno".equals(mensajeUsuario) &&
            !"!beginDialog Uno".equals(mensajeUsuario) && !"!beginDialog UNO".equals(mensajeUsuario) && !"!beginDialog".equals(mensajeUsuario) && !mensajeUsuario.contains("!rate ") &&
            !"!endDialog".equals(mensajeUsuario) && !"!saveLog".equals(mensajeUsuario) && !mensajeUsuario.contains("!loadLog ")){
                mensaje = chatbot.addMetaDatos("Chatbot: Excelente, ¿Desea comprar algo más?");
                System.out.println("Chatbot: Excelente, Desea comprar algo mas?");
                log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                log.addLog(log.getLog(), mensaje);   
                log.addLog(log.getLog(), "|Respuesta4|");     
            }
            else if(log.getUltimo(log.getLog()).equals("|Respuesta4|") && !"!beginDialog 0".equals(mensajeUsuario) && !"!beginDialog cero".equals(mensajeUsuario) &&
	    !"!beginDialog Cero".equals(mensajeUsuario) && !"!beginDialog CERO".equals(mensajeUsuario) && !"!beginDialog 1".equals(mensajeUsuario) && !"!beginDialog uno".equals(mensajeUsuario) &&
            !"!beginDialog Uno".equals(mensajeUsuario) && !"!beginDialog UNO".equals(mensajeUsuario) && !"!beginDialog".equals(mensajeUsuario) &&  !mensajeUsuario.contains("!rate ") && 
            !"!endDialog".equals(mensajeUsuario) && !"!saveLog".equals(mensajeUsuario) && !mensajeUsuario.contains("!loadLog ")){
                if(mensajeUsuario.equals("Sí") || mensajeUsuario.equals("Si") || mensajeUsuario.equals("sí") || mensajeUsuario.equals("si")
                || mensajeUsuario.equals("Sí, me gustaría comprar algo más") || mensajeUsuario.equals("Si, me gustaria comprar algo mas")
                || mensajeUsuario.equals("sí, me gustaría comprar algo más") || mensajeUsuario.equals("si, me gustaria comprar algo mas"))
                {
                    mensaje = chatbot.addMetaDatos("Chatbot: ¡Okey! Estos son las marcas/modelos de autos de las homocinéticas que disponemos: 1.-Toyota Rav4, 2.-Renault Duster, 3.-Hyundai Tucson, 4.-Nissan Qashqai, 5.-Nissan Kicks, elija la opción que desea.");
                    System.out.println("Chatbot: Okey! Estos son las marcas/modelos de autos de las homocineticas que disponemos: 1.-Toyota Rav4, 2.-Renault Duster, 3.-Hyundai Tucson, 4.-Nissan Qashqai, 5.-Nissan Kicks, elija la opcion que desea.");
                    log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), mensaje);
                    log.addLog(log.getLog(), "|Respuesta2|"); 
                }
                else if(mensajeUsuario.equals("No") || mensajeUsuario.equals("no")
                || mensajeUsuario.equals("No, no me gustaría comprar algo más") || mensajeUsuario.equals("no, no me gustaria comprar algo mas"))
                {
                    mensaje = chatbot.addMetaDatos("Chatbot: ¡Está bien! Todos sus items han sido agregados a su carro.");
                    System.out.println("Chatbot: Esta bien! Todos sus items han sido agregados a su carro.");
                    log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), mensaje);  
                }
                else{
                    mensaje = chatbot.addMetaDatos("Chatbot: Lo lamento, no logro entenderte, ¿Podrías repetirlo?");
                    System.out.println("Chatbot: Lo lamento, no logro entenderte, Podrias repetirlo?");
                    log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), mensaje);
                    log.addLog(log.getLog(), "|Error|");
                    log.addLog(log.getLog(), "|Respuesta4|");              
                }
            }
            //End Conversation.
            //Start rate.
            else if(mensajeUsuario.contains("!rate ")){
                if(log.getUltimo(log.getLog()).equals("|Fin de la Conversación|")){
                    try{
                        String[] separacion = mensajeUsuario.split(" ");
                        notaChatbot = Integer.parseInt(separacion[1]); 
                        notaUsuario = Integer.parseInt(separacion[2]);
                        if(notaChatbot >= 1 && notaChatbot <= 5 && notaUsuario >= 1 && notaUsuario <= 5){
                            chatbot.rate(notaUsuario, notaChatbot,log);
                            chatbot.addDatosFinales(log, usuario);
                            return log;
                        }
                    }catch(ArrayIndexOutOfBoundsException error){
                        System.out.println(advertencia);
                        String aux = log.getUltimo(log.getLog());
                        log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                        log.addLog(log.getLog(), chatbot.addMetaDatos(advertencia + aux));
                    }                   
                }
                else{
                    System.out.println(advertencia);
                    String aux = log.getUltimo(log.getLog());
                    log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), chatbot.addMetaDatos(advertencia + aux));
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
            else if(mensajeUsuario.contains("!loadLog")){
                try{
                    String[] separacion = mensajeUsuario.split(" ");
                    String nombreArchivo = separacion[1]; 
                    log.loadLog(nombreArchivo);
                }catch(ArrayIndexOutOfBoundsException error){
                    System.out.println("Ups, creo que olvido poner el nombre del archivo.");
                }   
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
        String advertencia = "Chatbot: Aun no se ha finalizado la conversacion o este ya fue evaluado.";       
        int notaChatbot; 
        int notaUsuario;
        
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
                    System.out.println("Chatbot: Lo lamento, debes terminar y evaluar la conversacion anterior antes de comenzar una nueva.");
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
                    System.out.println("Chatbot: Lo lamento, debes terminar y evaluar la conversacion anterior antes de comenzar una nueva.");
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
                    System.out.println("Chatbot: Como estas "+ mensajeUsuario +"?");
                    log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), mensaje);
                }
                if(chatbot.getChatbot() == 0){
                    mensaje = chatbot.addMetaDatos("Chatbot: ¿Cómo estai "+ mensajeUsuario +"?");
                    System.out.println("Chatbot: Como estai "+ mensajeUsuario +"?");
                    log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), mensaje);
                }
                log.addLog(log.getLog(), "|Respuesta1|");     
            }
            else if(log.getUltimo(log.getLog()).equals("|Respuesta1|") && !"!beginDialog 0".equals(mensajeUsuario) && !"!beginDialog cero".equals(mensajeUsuario) &&
	    !"!beginDialog Cero".equals(mensajeUsuario) && !"!beginDialog CERO".equals(mensajeUsuario) && !"!beginDialog 1".equals(mensajeUsuario) && !"!beginDialog uno".equals(mensajeUsuario) &&
            !"!beginDialog Uno".equals(mensajeUsuario) && !"!beginDialog UNO".equals(mensajeUsuario) && !"!beginDialog".equals(mensajeUsuario) && !mensajeUsuario.contains("!rate") && 
            !"!endDialog".equals(mensajeUsuario) && !"!saveLog".equals(mensajeUsuario) && !mensajeUsuario.contains("!loadLog ")){
                mensaje = chatbot.addMetaDatos("Chatbot: Oh, bueno. Estas son las marcas/modelos de autos de las homocinéticas que disponemos: 1.-Toyota Rav4, 2.-Renault Duster, 3.-Hyundai Tucson, 4.-Nissan Qashqai, 5.-Nissan Kicks, elija la opción que desea.");
                System.out.println("Chatbot: Oh, bueno. Estas son las marcas/modelos de autos de las homocineticas que disponemos: 1.-Toyota Rav4, 2.-Renault Duster, 3.-Hyundai Tucson, 4.-Nissan Qashqai, 5.-Nissan Kicks, elija la opcion que desea.");
                log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                log.addLog(log.getLog(), mensaje);   
                log.addLog(log.getLog(), "|Respuesta2|");     
            }
            else if(log.getUltimo(log.getLog()).equals("|Respuesta2|") && !"!beginDialog 0".equals(mensajeUsuario) && !"!beginDialog cero".equals(mensajeUsuario) &&
	    !"!beginDialog Cero".equals(mensajeUsuario) && !"!beginDialog CERO".equals(mensajeUsuario) && !"!beginDialog 1".equals(mensajeUsuario) && !"!beginDialog uno".equals(mensajeUsuario) &&
            !"!beginDialog Uno".equals(mensajeUsuario) && !"!beginDialog UNO".equals(mensajeUsuario) && !"!beginDialog".equals(mensajeUsuario) && !mensajeUsuario.contains("!rate") && 
            !"!endDialog".equals(mensajeUsuario) && !"!saveLog".equals(mensajeUsuario) && !mensajeUsuario.contains("!loadLog ")){
                mensaje = chatbot.addMetaDatos("Chatbot: Perfecto, ¿Cuántas querrá?");
                System.out.println("Chatbot: Perfecto, Cuantas querra?");
                log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                log.addLog(log.getLog(), mensaje);   
                log.addLog(log.getLog(), "|Respuesta3|");     
            }
            else if(log.getUltimo(log.getLog()).equals("|Respuesta3|") && !"!beginDialog 0".equals(mensajeUsuario) && !"!beginDialog cero".equals(mensajeUsuario) &&
	    !"!beginDialog Cero".equals(mensajeUsuario) && !"!beginDialog CERO".equals(mensajeUsuario) && !"!beginDialog 1".equals(mensajeUsuario) && !"!beginDialog uno".equals(mensajeUsuario) &&
            !"!beginDialog Uno".equals(mensajeUsuario) && !"!beginDialog UNO".equals(mensajeUsuario) && !"!beginDialog".equals(mensajeUsuario) && !mensajeUsuario.contains("!rate") && 
            !"!endDialog".equals(mensajeUsuario) && !"!saveLog".equals(mensajeUsuario) && !mensajeUsuario.contains("!loadLog ")){
                mensaje = chatbot.addMetaDatos("Chatbot: Excelente, ¿Desea comprar algo más?");
                System.out.println("Chatbot: Excelente, Desea comprar algo mas?");
                log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                log.addLog(log.getLog(), mensaje);   
                log.addLog(log.getLog(), "|Respuesta4|");     
            }
            else if(log.getUltimo(log.getLog()).equals("|Respuesta4|") && !"!beginDialog 0".equals(mensajeUsuario) && !"!beginDialog cero".equals(mensajeUsuario) &&
	    !"!beginDialog Cero".equals(mensajeUsuario) && !"!beginDialog CERO".equals(mensajeUsuario) && !"!beginDialog 1".equals(mensajeUsuario) && !"!beginDialog uno".equals(mensajeUsuario) &&
            !"!beginDialog Uno".equals(mensajeUsuario) && !"!beginDialog UNO".equals(mensajeUsuario) && !"!beginDialog".equals(mensajeUsuario) && !mensajeUsuario.contains("!rate") && 
            !"!endDialog".equals(mensajeUsuario) && !"!saveLog".equals(mensajeUsuario) && !mensajeUsuario.contains("!loadLog ")){
                if(mensajeUsuario.equals("Sí") || mensajeUsuario.equals("Si") || mensajeUsuario.equals("sí") || mensajeUsuario.equals("si")
                || mensajeUsuario.equals("Sí, me gustaría comprar algo más") || mensajeUsuario.equals("Si, me gustaria comprar algo mas")
                || mensajeUsuario.equals("sí, me gustaría comprar algo más") || mensajeUsuario.equals("si, me gustaria comprar algo mas"))
                {
                    mensaje = chatbot.addMetaDatos("Chatbot: ¡Okey! Estas son las marcas/modelos de autos de las homocinéticas que disponemos: 1.-Toyota Rav4, 2.-Renault Duster, 3.-Hyundai Tucson, 4.-Nissan Qashqai, 5.-Nissan Kicks, elija la opción que desea.");
                    System.out.println("Chatbot: ¡Okey! Estas son las marcas/modelos de autos de las homocineticas que disponemos: 1.-Toyota Rav4, 2.-Renault Duster, 3.-Hyundai Tucson, 4.-Nissan Qashqai, 5.-Nissan Kicks, elija la opcion que desea.");
                    log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), mensaje);
                    log.addLog(log.getLog(), "|Respuesta2|"); 
                }
                else if(mensajeUsuario.equals("No") || mensajeUsuario.equals("no")
                || mensajeUsuario.equals("No, no me gustaría comprar algo más") || mensajeUsuario.equals("no, no me gustaria comprar algo mas"))
                {
                    mensaje = chatbot.addMetaDatos("Chatbot: ¡Está bien! Todos sus items han sido agregados a su carro.");
                    System.out.println("Chatbot: Esta bien! Todos sus items han sido agregados a su carro.");
                    log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), mensaje);  
                }
                else{
                    mensaje = chatbot.addMetaDatos("Chatbot: Lo lamento, no logro entenderte, ¿Podrías repetirlo?");
                    System.out.println("Chatbot: Lo lamento, no logro entenderte, Podrias repetirlo?");
                    log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), mensaje);
                    log.addLog(log.getLog(), "|Error|");
                    log.addLog(log.getLog(), "|Respuesta4|");              
                }
            }
            //End Conversation.
            //Start rate.
            else if(mensajeUsuario.contains("!rate ")){
                if(log.getUltimo(log.getLog()).equals("|Fin de la Conversación|")){
                    try{
                        String[] separacion = mensajeUsuario.split(" ");
                        notaChatbot = Integer.parseInt(separacion[1]); 
                        notaUsuario = Integer.parseInt(separacion[2]);
                        if(notaChatbot >= 1 && notaChatbot <= 5 && notaUsuario >= 1 && notaUsuario <= 5){
                            chatbot.rate(notaUsuario, notaChatbot,log);
                            chatbot.addDatosFinales(log, usuario);
                            return log;
                        }
                    }catch(ArrayIndexOutOfBoundsException error){
                        System.out.println(advertencia);
                        String aux = log.getUltimo(log.getLog());
                        log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                        log.addLog(log.getLog(), chatbot.addMetaDatos(advertencia + aux));
                    }                   
                }
                else{
                    System.out.println(advertencia);
                    String aux = log.getUltimo(log.getLog());
                    log.addLog(log.getLog(), chatbot.addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), chatbot.addMetaDatos(advertencia + aux));
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
            else if(mensajeUsuario.contains("!loadLog")){
                try{
                    String[] separacion = mensajeUsuario.split(" ");
                    String nombreArchivo = separacion[1]; 
                    log.loadLog(nombreArchivo);
                }catch(ArrayIndexOutOfBoundsException error){
                    System.out.println("Ups, creo que olvido poner el nombre del archivo.");
                }   
            }
        mensajeUsuario = lecturaConsolaConversacion.nextLine();
        }
        log.addLog(log.getLog(), "|Fin|"); 
        return log;
    }
}
