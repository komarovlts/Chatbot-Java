/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot;

/**
 *
 * @author Omar Antonio Carrasco Escudero - Kömarøv
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
