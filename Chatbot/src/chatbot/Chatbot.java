package chatbot;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

/**
 * Esta clase define los parámetros necesarios para llevar a cabo una 
 * conversación entre usuario y chatbot.
 * @author Omar Antonio Carrasco Escudero - KomarovLTS
 */
public class Chatbot {
    //Campos de clase.
    private List evaluaciones;
    private int personalidad;
    
    Log log = new Log();
    Usuario nuevoUsuario = new Usuario();
    
    /**
     * Constructor de Chatbot.
     * personalidad es un parametro entero que ronda entre 0 y 1, donde
     * 0 implica que el chatbot tendrá una personalidad informal y
     * 1 implica que el chatbot tendrá una personalidad formal.
     * Por defecto el chatbot posee una personalidad formal. 
     */
    public Chatbot() {
	this.personalidad = 1;
        this.evaluaciones = new ArrayList();      
    }//Cierre de constructor.
    
    /**
     * Método para cambiar la personalidad actual del Chatbot.
     * @param personalidad, número entero que puede ser 0 y 1.
     */
    public void setChatbot(int personalidad){
        this.personalidad = personalidad;
    }
    
    /**
     * Método que desarrolla la conversación a través de comandos específicos e
     * indentificadores, este método sólo se detiene con el comando !stop, hasta
     * que este comando no sea utilizado se seguirá dando al usuario la opción
     * de ingresar datos por consola.
     * @throws IOException, excepción de Input/Output derivada de ciertos submétodos.
     */
    public void conversacion() throws IOException {
        
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
                    beginDialog(0);
                    setChatbot(0);
                }
                else if(log.getUltimo(log.getLog()).equals("|Chatbot evaluado|")){
                    beginDialog(0);
                    setChatbot(0);
                }
                else{
                ultimoMensaje = log.getUltimo(log.getLog());
                mensaje = addMetaDatos("Chatbot: Lo lamento, debes terminar y evaluar la conversación anterior antes de comenzar una nueva.");
                System.out.println("Chatbot: Lo lamento, debes terminar y evaluar la conversación anterior antes de comenzar una nueva.");
                log.addLog(log.getLog(), mensaje);
                log.addLog(log.getLog(), ultimoMensaje);
                }
            }
            else if("!beginDialog 1".equals(mensajeUsuario) || "!beginDialog uno".equals(mensajeUsuario) ||
               "!beginDialog Uno".equals(mensajeUsuario) || "!beginDialog UNO".equals(mensajeUsuario)){
                if(log.getLog().isEmpty()){
                    beginDialog(1);
                    setChatbot(1);
                }
                else if(log.getUltimo(log.getLog()).equals("|Chatbot evaluado|")){
                    beginDialog(1);
                    setChatbot(1);
                }
                else{
                    ultimoMensaje = log.getUltimo(log.getLog());
                    mensaje = addMetaDatos("Chatbot: Lo lamento, debes terminar y evaluar la conversación anterior antes de comenzar una nueva.");
                    System.out.println("Chatbot: Lo lamento, debes terminar y evaluar la conversación anterior antes de comenzar una nueva.");
                    log.addLog(log.getLog(), mensaje);
                    log.addLog(log.getLog(), ultimoMensaje);
                }
            }
            else if("!beginDialog".equals(mensajeUsuario)){
                if(log.getLog().isEmpty()){
                    beginDialog(1);
                    setChatbot(1);
                }
                else if(log.getUltimo(log.getLog()).equals("|Chatbot evaluado|")){
                    beginDialog(1);
                    setChatbot(1);
                }
                else{
                    ultimoMensaje = log.getUltimo(log.getLog());
                    mensaje = addMetaDatos("Chatbot: Lo lamento, debes terminar y evaluar la conversación anterior antes de comenzar una nueva.");
                    System.out.println("Chatbot: Lo lamento, debes terminar y evaluar la conversación anterior antes de comenzar una nueva.");
                    log.addLog(log.getLog(), mensaje);
                    log.addLog(log.getLog(), ultimoMensaje);
                }
            }
            //End beginDialog.
            //Start Conversation.
            else if(log.getUltimo(log.getLog()).equals("|Nombre|")){
                nuevoUsuario.setNombreUsuario(mensajeUsuario);
                if(personalidad == 1){
                    mensaje = addMetaDatos("Chatbot: ¿Cómo estás "+ mensajeUsuario +"?");
                    System.out.println("Chatbot: ¿Cómo estás "+ mensajeUsuario +"?");
                    log.addLog(log.getLog(), addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), mensaje);
                }
                if(personalidad == 0){
                    mensaje = addMetaDatos("Chatbot: ¿Cómo estás "+ mensajeUsuario +"?");
                    System.out.println("Chatbot: ¿Cómo estai "+ mensajeUsuario +"?");
                    log.addLog(log.getLog(), addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), mensaje);
                }
                log.addLog(log.getLog(), "|Respuesta1|");     
            }
            else if(log.getUltimo(log.getLog()).equals("|Respuesta1|") && !"!beginDialog 0".equals(mensajeUsuario) && !"!beginDialog cero".equals(mensajeUsuario) &&
	    !"!beginDialog Cero".equals(mensajeUsuario) && !"!beginDialog CERO".equals(mensajeUsuario) && !"!beginDialog 1".equals(mensajeUsuario) && !"!beginDialog uno".equals(mensajeUsuario) &&
            !"!beginDialog Uno".equals(mensajeUsuario) && !"!beginDialog UNO".equals(mensajeUsuario) && !"!beginDialog".equals(mensajeUsuario) &&  !"!rate 1".equals(mensajeUsuario) &&
            !"!rate 2".equals(mensajeUsuario) && !"!rate 3".equals(mensajeUsuario) && !"!rate 4".equals(mensajeUsuario) && !"!rate 5".equals(mensajeUsuario) && !"!endDialog".equals(mensajeUsuario) &&
            !"!saveLog".equals(mensajeUsuario) && !"!loadLog".equals(mensajeUsuario)){
                mensaje = addMetaDatos("Chatbot: Oh, bueno. Estos son las marcas/modelos de autos de las homocinéticas que disponemos: 1.-Toyota Rav4, 2.-Renault Duster, 3.-Hyundai Tucson, 4.-Nissan Qashqai, 5.-Nissan Kicks, elija la opción que desea.");
                System.out.println("Chatbot: Oh, bueno. Estos son las marcas/modelos de autos de las homocinéticas que disponemos: 1.-Toyota Rav4, 2.-Renault Duster, 3.-Hyundai Tucson, 4.-Nissan Qashqai, 5.-Nissan Kicks, elija la opción que desea.");
                log.addLog(log.getLog(), addMetaDatos("Usuario: "+ mensajeUsuario));
                log.addLog(log.getLog(), mensaje);   
                log.addLog(log.getLog(), "|Respuesta2|");     
            }
            else if(log.getUltimo(log.getLog()).equals("|Respuesta2|") && !"!beginDialog 0".equals(mensajeUsuario) && !"!beginDialog cero".equals(mensajeUsuario) &&
	    !"!beginDialog Cero".equals(mensajeUsuario) && !"!beginDialog CERO".equals(mensajeUsuario) && !"!beginDialog 1".equals(mensajeUsuario) && !"!beginDialog uno".equals(mensajeUsuario) &&
            !"!beginDialog Uno".equals(mensajeUsuario) && !"!beginDialog UNO".equals(mensajeUsuario) && !"!beginDialog".equals(mensajeUsuario) &&  !"!rate 1".equals(mensajeUsuario) &&
            !"!rate 2".equals(mensajeUsuario) && !"!rate 3".equals(mensajeUsuario) && !"!rate 4".equals(mensajeUsuario) && !"!rate 5".equals(mensajeUsuario) && !"!endDialog".equals(mensajeUsuario) &&
            !"!saveLog".equals(mensajeUsuario) && !"!loadLog".equals(mensajeUsuario)){
                mensaje = addMetaDatos("Chatbot: Perfecto, ¿Cuántas querrá?");
                System.out.println("Chatbot: Perfecto, ¿Cuántas querrá?");
                log.addLog(log.getLog(), addMetaDatos("Usuario: "+ mensajeUsuario));
                log.addLog(log.getLog(), mensaje);   
                log.addLog(log.getLog(), "|Respuesta3|");     
            }
            else if(log.getUltimo(log.getLog()).equals("|Respuesta3|") && !"!beginDialog 0".equals(mensajeUsuario) && !"!beginDialog cero".equals(mensajeUsuario) &&
	    !"!beginDialog Cero".equals(mensajeUsuario) && !"!beginDialog CERO".equals(mensajeUsuario) && !"!beginDialog 1".equals(mensajeUsuario) && !"!beginDialog uno".equals(mensajeUsuario) &&
            !"!beginDialog Uno".equals(mensajeUsuario) && !"!beginDialog UNO".equals(mensajeUsuario) && !"!beginDialog".equals(mensajeUsuario) &&  !"!rate 1".equals(mensajeUsuario) &&
            !"!rate 2".equals(mensajeUsuario) && !"!rate 3".equals(mensajeUsuario) && !"!rate 4".equals(mensajeUsuario) && !"!rate 5".equals(mensajeUsuario) && !"!endDialog".equals(mensajeUsuario) &&
            !"!saveLog".equals(mensajeUsuario) && !"!loadLog".equals(mensajeUsuario)){
                mensaje = addMetaDatos("Chatbot: Excelente, ¿Desea comprar algo más?");
                System.out.println("Chatbot: Excelente, ¿Desea comprar algo más?");
                log.addLog(log.getLog(), addMetaDatos("Usuario: "+ mensajeUsuario));
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
                    mensaje = addMetaDatos("Chatbot: ¡Okey! Estos son las marcas/modelos de autos de las homocinéticas que disponemos: 1.-Toyota Rav4, 2.-Renault Duster, 3.-Hyundai Tucson, 4.-Nissan Qashqai, 5.-Nissan Kicks, elija la opción que desea.");
                    System.out.println("Chatbot: ¡Okey! Estos son las marcas/modelos de autos de las homocinéticas que disponemos: 1.-Toyota Rav4, 2.-Renault Duster, 3.-Hyundai Tucson, 4.-Nissan Qashqai, 5.-Nissan Kicks, elija la opción que desea.");
                    log.addLog(log.getLog(), addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), mensaje);
                    log.addLog(log.getLog(), "|Respuesta2|"); 
                }
                else if(mensajeUsuario.equals("No") || mensajeUsuario.equals("no")
                || mensajeUsuario.equals("No, no me gustaría comprar algo más") || mensajeUsuario.equals("no, no me gustaria comprar algo mas"))
                {
                    mensaje = addMetaDatos("Chatbot: ¡Está bien! Todos sus items han sido agregados a su carro.");
                    System.out.println("Chatbot: ¡Está bien! Todos sus items han sido agregados a su carro.");
                    log.addLog(log.getLog(), addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), mensaje);  
                }
                else{
                    mensaje = addMetaDatos("Chatbot: Lo lamento, no logro entenderte, ¿Podrías repetirlo?");
                    System.out.println("Chatbot: Lo lamento, no logro entenderte, ¿Podrías repetirlo?");
                    log.addLog(log.getLog(), addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), mensaje);
                    log.addLog(log.getLog(), "|Error|");
                    log.addLog(log.getLog(), "|Respuesta4|");              
                }
            }
            //End Conversation.
            //Start rate.
            else if("!rate 1".equals(mensajeUsuario)){
                if(log.getUltimo(log.getLog()).equals("|Fin de la Conversación|")){
                   rate(1);
                } 
                else{
                    System.out.println(advertencia);
                    log.addLog(log.getLog(), addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), addMetaDatos(advertencia));
                }
            }
            else if("!rate 2".equals(mensajeUsuario)){
                if(log.getUltimo(log.getLog()).equals("|Fin de la Conversación|")){
                   rate(2);
                } 
                else{
                    System.out.println(advertencia);
                    log.addLog(log.getLog(), addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), addMetaDatos(advertencia));
                }
            }
            else if("!rate 3".equals(mensajeUsuario)){
                if(log.getUltimo(log.getLog()).equals("|Fin de la Conversación|")){
                   rate(3);
                } 
                else{
                    System.out.println(advertencia);
                    log.addLog(log.getLog(), addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), addMetaDatos(advertencia));
                }
            }
            else if("!rate 4".equals(mensajeUsuario)){
                if(log.getUltimo(log.getLog()).equals("|Fin de la Conversación|")){
                   rate(4);
                } 
                else{
                    System.out.println(advertencia);
                    log.addLog(log.getLog(), addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), addMetaDatos(advertencia));
                }
            }
            else if("!rate 5".equals(mensajeUsuario)){
                if(log.getUltimo(log.getLog()).equals("|Fin de la Conversación|")){
                   rate(5);
                } 
                else{
                    System.out.println(advertencia);
                    log.addLog(log.getLog(), addMetaDatos("Usuario: "+ mensajeUsuario));
                    log.addLog(log.getLog(), addMetaDatos(advertencia));
                }
            }
            //End rate.
            //Start endDialog.
            else if("!endDialog".equals(mensajeUsuario)){
                endDialog(personalidad);
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
    }
    
    /**
     * Método de para el comando !beginDialog, el cual dará inicio a la
     * conversación según los parametros dados (la personalidad y en su debido
     * caso, la hora actual).
     * @param seed, parametro entero que ronda entre 0 y 1 que es equivalente
     * a la personalidad del Chatbot.
     */
    public void beginDialog(int seed){
        Scanner lecturaConsolabeginDialog = new Scanner(System.in);
        int Hora = getHora();
        String saludo;
        if(seed == 1){
            if(Hora >= 6 && Hora < 12){
                saludo = addMetaDatos("Chatbot: Buenos Dias, ¿Cuál es tu nombre?");
                System.out.println("Chatbot: Buenos Dias, ¿Cuál es tu nombre?");
                log.addLog(log.getLog(), saludo);
            }
            else if(Hora >= 12 && Hora < 20){
                saludo = addMetaDatos("Chatbot: Buenas Tardes, ¿Cuál es tu nombre?");
                System.out.println("Chatbot: Buenas Tardes, ¿Cuál es tu nombre?");
                log.addLog(log.getLog(), saludo);
            }
            else if(Hora > 20){
                saludo = addMetaDatos("Chatbot: Buenas Noches, ¿Cuál es tu nombre?");
                System.out.println("Chatbot: Buenas Noches, ¿Cuál es tu nombre?");
                log.addLog(log.getLog(), saludo);
            }
            else{
                saludo = addMetaDatos("Chatbot: Buenas, ¿Cuál es tu nombre?");
                System.out.println("Chatbot: Buenas, ¿Cuál es tu nombre?");
                log.addLog(log.getLog(), saludo);
            }
        }
        else{
            saludo = addMetaDatos("Chatbot: Buena!, Cómo te llamas?");
            System.out.println("Chatbot: Buena!, Cómo te llamas?");
            log.addLog(log.getLog(), saludo);
        }
        log.addLog(log.getLog(), "|Nombre|");       
    }
    
    /**
     * Método para el comando !endDialog el cual dará fin a la
     * conversación según los parametros dados (la personalidad y en su debido
     * caso, la hora actual).
     * @param seed, parametro entero que ronda entre 0 y 1 que es equivalente
     * a la personalidad del Chatbot. 
     */
    public void endDialog(int seed){
        Scanner lecturaConsolaEndDialog = new Scanner(System.in);
        int Hora = getHora();
        String despedida;
        if(seed == 1){
            if(Hora >= 6 && Hora < 12){
                despedida = addMetaDatos("Chatbot: Espero haberte sido de utilidad, que tengas un buen día,¡Adiós!.");
                System.out.println("Chatbot: Espero haberte sido de utilidad, que tengas un buen día,¡Adiós!.");
                log.addLog(log.getLog(), despedida);
            }
            else if(Hora >= 12 && Hora < 20){
                despedida = addMetaDatos("Chatbot: Espero haberte sido de utilidad, que tengas una buena tarde,¡Adiós!.");
                System.out.println("Chatbot: Espero haberte sido de utilidad, que tengas una buena tarde,¡Adiós!.");
                log.addLog(log.getLog(), despedida);
            }
            else if(Hora > 20){
                despedida = addMetaDatos("Chatbot: Espero haberte sido de utilidad, que tengas un buena noche,¡Adiós!.");
                System.out.println("Chatbot: Espero haberte sido de utilidad, que tengas un buena noche,¡Adiós!.");
                log.addLog(log.getLog(), despedida);
            }
            else{
                despedida = addMetaDatos("Chatbot: Espero haberte sido de utilidad, ¡Hasta luego!.");
                System.out.println("Chatbot: Espero haberte sido de utilidad, ¡Hasta luego!.");
                log.addLog(log.getLog(), despedida);
            }
        }
        else{
            despedida = addMetaDatos("Chatbot: Dale compa, ¡Nos vemos!.");
            System.out.println("Chatbot: Dale compa, ¡Nos vemos!.");
            log.addLog(log.getLog(), despedida);
        }
        log.addLog(log.getLog(), "|Fin de la Conversación|");
    }
    
    /**
     * Método que permite generar/guardar evualuaciones del usuario y del mismo chatbot
     * dentro de una lista de evaluaciones.
     * @param notaUsuario, parametro entero que representa la nota del usuario
     * según su experiencia con el chatbot.
     */
    public void rate(int notaUsuario){
        String tiempoActual = "Chatbot "+tiempoActual();
        int repeticiones = log.searchRepeticiones();
        if(repeticiones == 7){
            evaluaciones.add("Evaluación de Chatbot: 1 ");
            log.addLog(log.getLog(), addMetaDatos("Evaluación de Chatbot: 1 "));
        }
        else if(repeticiones == 5){
            evaluaciones.add("Evaluación de Chatbot: 2 ");
            log.addLog(log.getLog(), addMetaDatos("Evaluación de Chatbot: 2 "));
        }
        else if(repeticiones == 3){
            evaluaciones.add("Evaluación de Chatbot: 3 ");
            log.addLog(log.getLog(), addMetaDatos("Evaluación de Chatbot: 3 "));
        }
        else if(repeticiones == 2){
            evaluaciones.add("Evaluación de Chatbot: 4 ");
            log.addLog(log.getLog(), addMetaDatos("Evaluación de Chatbot: 4 "));
        }
        else if(repeticiones == 0){
            evaluaciones.add("Evaluación de Chatbot: 5 ");
            log.addLog(log.getLog(), addMetaDatos("Evaluación de Chatbot: 5 "));
        }
        else{
            evaluaciones.add("Evaluación de Chatbot: 0 ");
            log.addLog(log.getLog(), addMetaDatos("Evaluación de Chatbot: 0 "));
        }
        evaluaciones.add("Evaluación de Usuario: " + notaUsuario);
        log.addLog(log.getLog(), addMetaDatos("Evaluación de Usuario: " + notaUsuario));
        System.out.println("Chatbot: He sido evaluado exitosamente, ya puedes iniciar una nueva conversación.");
        log.addLog(log.getLog(), addMetaDatos("Chatbot: He sido evaluado exitosamente, ya puedes iniciar una nueva conversación."));
        addDatosFinales();
        log.addLog(log.getLog(), "|Chatbot evaluado|");
    }
    
    /**
     * Método para añadir los metadatos de tiempo a otro String, uniéndoles como
     * uno solo String.
     * @param Msg, String al que se le añadirán los metadatos.
     * @return String que contiene tanto como los metadatos, como el string dado
     * como parametro.
     */
    public String addMetaDatos(String Msg){
        String stringFinal;
        String tiempoActual = tiempoActual();
        stringFinal = tiempoActual + Msg;
        return stringFinal;
    }
    
    /**
     * Método que obtiene la fecha y la hora actual del equipo en un formato
     * predefinido.
     * @return String de metadatos de fecha y hora.
     */
    public String tiempoActual(){
        DateTimeFormatter formatoTiempoActual = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime tiempoActualLocal = LocalDateTime.now();
        String tiempoActual;
        tiempoActual = ("["+ formatoTiempoActual.format(tiempoActualLocal)+ "] ");
        return tiempoActual;
    }
    
    /**
     * Método que obtiene sólo la hora del equipo.
     * @return entero equivalente a la hora del equipo.
     */
    public int getHora(){
        Calendar calendario = Calendar.getInstance();
        int hora;
        hora = calendario.get(Calendar.HOUR_OF_DAY);
        return hora;
    }
    /**
     * Método que añade datos útiles a el log.
     * Nombre de usuario
     * Personalidad del chatbot que interactuó con este usuario.
     * Evaluación y auto evaluación del Chatbot.
     */
    public void addDatosFinales(){
        log.addLog(log.getLog(), "--------Datos Utiles--------");
        log.addLog(log.getLog(), "----Usuario----");
        log.addLog(log.getLog(), "Nombre: "+ nuevoUsuario.getNombreUsuario());
        log.addLog(log.getLog(), "----Chatbot----");
        log.addLog(log.getLog(), "Personalidad: "+ personalidad);
        log.addLog(log.getLog(), "----Evaluaciones----");
        log.addLog(log.getLog(), (String) evaluaciones.get(0));
        log.addLog(log.getLog(), (String) evaluaciones.get(1));
        log.addLog(log.getLog(), "--------Fin Datos Utiles--------");
    }
}//Cierre de clase.
