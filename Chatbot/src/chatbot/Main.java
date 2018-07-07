package chatbot;

import java.io.IOException;

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
        Chatbot nuevaConversacion = new Chatbot();
        System.out.println("Este chatbot te ayuda a realizar un pedido de homocinéticas");
        nuevaConversacion.conversacion();
    }	 
}
