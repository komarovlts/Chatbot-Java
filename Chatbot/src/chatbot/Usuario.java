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
    public String NombreUsuario;
    public String PedidoUsuario;
    
    public Usuario() {
        this.NombreUsuario = "";
        this.PedidoUsuario = "";
    }
    
    public String getNombreUsuario(){
        return NombreUsuario;
    }
    
    public String getPedidoUsuario(){
        return PedidoUsuario;
    }
    
    public String setNombreUsuario(String NombreUsuarioEntrante){
        NombreUsuario = NombreUsuarioEntrante;
        return NombreUsuario;
    }
    
    public String setPedidoUsuario(String PedidoUsuarioEntrante){
        PedidoUsuario = PedidoUsuarioEntrante;
        return PedidoUsuario;
    }
}
