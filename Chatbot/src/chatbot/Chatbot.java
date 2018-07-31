package chatbot;

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
     * Método para obtener la personalidad del Chatbot.
     * @return personalidad del Chatbot representado por un entero, 1 o 0.
     */
    public int getChatbot(){
        return personalidad;
    }

    /**
     * Método de para el comando !beginDialog, el cual dará inicio a la
     * conversación según los parametros dados (la personalidad y en su debido
     * caso, la hora actual).
     * @param seed, parametro entero que ronda entre 0 y 1 que es equivalente
     * a la personalidad del Chatbot.
     * @param log, lista de strings con el historial de la conversación.
     */
    public void beginDialog(int seed, Log log){
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
     * @param log, lista de strings que representa el historial de la conversación.
     */
    public void endDialog(int seed, Log log){
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
     * @param log, lista de strings que representa el historial de la conversación.
     */
    public void rate(int notaUsuario, Log log){
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
     * @param log, lista con el historial de la conversación.
     * @param usuario, datos como el nombre y el pedido del usuario.
     */
    public void addDatosFinales(Log log, Usuario usuario){
        log.addLog(log.getLog(), "--------Datos Utiles--------");
        log.addLog(log.getLog(), "----Usuario----");
        log.addLog(log.getLog(), "Nombre: "+ usuario.getNombreUsuario());
        log.addLog(log.getLog(), "----Chatbot----");
        log.addLog(log.getLog(), "Personalidad: "+ personalidad);
        log.addLog(log.getLog(), "----Evaluaciones----");
        log.addLog(log.getLog(), (String) evaluaciones.get(0));
        log.addLog(log.getLog(), (String) evaluaciones.get(1));
        log.addLog(log.getLog(), "--------Fin Datos Utiles--------");
    }
}//Cierre de clase.
