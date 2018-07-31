package chatbot;

import java.io.IOException;
import java.util.Scanner;

/**
 * Esta clase sólo realiza la instancia y llamada que da el paso a toda la 
 * ejecución del chatbot.
 * @author Omar Antonio Carrasco Escudero - KomarovLTS
 * Documentación realizada tomando como guía: 
 * https://www.aprenderaprogramar.com/index.php?option=com_
 * content&view=article&id=646:documentar-proyectos-java-con-
 * javadoc-comentarios-simbolos-tags-deprecated-param-etc-cu00680b&catid=
 * 68&Itemid=188
 */
public class Main {
       
    public static void main(String[] args) throws IOException {
        Dialog nuevaConversacion = new Dialog();
        Log log = new Log();
        System.out.println("Este chatbot te ayuda a realizar un pedido de homocinéticas");
        Scanner lecturaConsolaConversacion = new Scanner(System.in);
        String mensajeUsuario = lecturaConsolaConversacion.nextLine();
            while(!"!stop".equals(mensajeUsuario)){                
            if("!beginDialog 0".equals(mensajeUsuario) || "!beginDialog cero".equals(mensajeUsuario) ||
	    "!beginDialog Cero".equals(mensajeUsuario) || "!beginDialog CERO".equals(mensajeUsuario)){
                nuevaConversacion.conversacionNormal(0, log);
                if(log.getUltimo(log.getLog()).equals("|Fin|")){
                    nuevaConversacion.setOffDialog();
                    return;
                }
            }
            else if("!beginDialog 1".equals(mensajeUsuario) || "!beginDialog uno".equals(mensajeUsuario) ||
               "!beginDialog Uno".equals(mensajeUsuario) || "!beginDialog UNO".equals(mensajeUsuario)){
                nuevaConversacion.conversacionNormal(1, log);
                if(log.getUltimo(log.getLog()).equals("|Fin|")){
                    nuevaConversacion.setOffDialog();
                    return;
                }
            }
            else if("!beginDialog".equals(mensajeUsuario)){
                nuevaConversacion.conversacionNormal(0, log);
                if(log.getUltimo(log.getLog()).equals("|Fin|")){
                    nuevaConversacion.setOffDialog();
                    return;
                }
            }
            //End beginDialog.
            else if("!loadLog".equals(mensajeUsuario)){
                System.out.println("Ingrese el nombre del archivo: ");
                mensajeUsuario = lecturaConsolaConversacion.nextLine();
                log.loadLog(mensajeUsuario);
                nuevaConversacion.conversacionCargada(log);
            }
            else if("!saveLog".equals(mensajeUsuario)){
                log.saveLog(log.getLog());
            }
            mensajeUsuario = lecturaConsolaConversacion.nextLine();   
        }
        nuevaConversacion.setOffDialog();
    }	 
}
