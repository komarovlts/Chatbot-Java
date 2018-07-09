package chatbot;

/**
 * Esta clase define los parametros que tendra el Usuario durante las
 * conversaciones con el Chatbot.
 * @author Omar Antonio Carrasco Escudero - KomarovLTS
 */
public class Usuario {
    //Campos de clase.
    public String nombreUsuario;
    public String pedidoUsuario;
    
    /**
     * Constructor de Usuario.
     */
    public Usuario() {
        this.nombreUsuario = "";
        this.pedidoUsuario = "";
    }//Cierre constructor.
    
    /**
     * Método que obtiene el nombre del usuario actual.
     * @return String del nombre del usuario actual.
     */
    public String getNombreUsuario(){
        return nombreUsuario;
    }
    
    /**
     * Método que obtiene el pedido del usuario actual.
     * @return String con el pedido del usuario actual
     * Este método no fue implementado a cabalidad (su uso y derivados de este)
     * por falta de tiempo además de que no fue solicitado como algo fundamental.
     */
    public String getPedidoUsuario(){
        return pedidoUsuario;
    }
    
    /**
     * Método que cambia el nombre del usuario actual.
     * @param nombreNuevoUsuario, nombre del usuario.
     * @return String con el nombre del usuario actual.
     */
    public String setNombreUsuario(String nombreNuevoUsuario){
        nombreUsuario = nombreNuevoUsuario;
        return nombreUsuario;
    }
    
    /**
     * Método que cambia el pedido del usuario actual.
     * @param pedidoNuevoUsuario, pedido del usuario.
     * @return String con el pedido del usuario actual.
     */
    public String setPedidoUsuario(String pedidoNuevoUsuario){
        pedidoUsuario = pedidoNuevoUsuario;
        return pedidoUsuario;
    }
}//Cierre de clase.
