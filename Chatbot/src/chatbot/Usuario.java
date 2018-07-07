package chatbot;

/**
 *
 * @author Omar Antonio Carrasco Escudero - KomarovLTS
 */
public class Usuario {
    
    public String nombreUsuario;
    public String pedidoUsuario;
    
    public Usuario() {
        this.nombreUsuario = "";
        this.pedidoUsuario = "";
        }
    
    public String getNombreUsuario(){
        return nombreUsuario;
    }
    
    public String getPedidoUsuario(){
        return pedidoUsuario;
    }
    
    public String setNombreUsuario(String nombreNuevoUsuario){
        nombreUsuario = nombreNuevoUsuario;
        return nombreUsuario;
    }
    
    public String setPedidoUsuario(String pedidoNuevoUsuario){
        pedidoUsuario = pedidoNuevoUsuario;
        return pedidoUsuario;
    }
}
