package co.themafia.hbm;
// Generated 10/03/2013 10:50:03 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Pedido generated by hbm2java
 */
public class Pedido  implements java.io.Serializable {


     private int idPedido;
     private Proveedor proveedor;
     private Mediopago mediopago;
     private Usuario usuario;
     private Set<Confirmacion> confirmacions = new HashSet<Confirmacion>(0);
     private Set<Conceptousuario> conceptousuarios = new HashSet<Conceptousuario>(0);
     private Set<Disco> discos = new HashSet<Disco>(0);
     private Set<Cancion> cancions = new HashSet<Cancion>(0);

    public Pedido() {
    }

	
    public Pedido(int idPedido, Proveedor proveedor, Mediopago mediopago, Usuario usuario) {
        this.idPedido = idPedido;
        this.proveedor = proveedor;
        this.mediopago = mediopago;
        this.usuario = usuario;
    }
    public Pedido(int idPedido, Proveedor proveedor, Mediopago mediopago, Usuario usuario, Set<Confirmacion> confirmacions, Set<Conceptousuario> conceptousuarios, Set<Disco> discos, Set<Cancion> cancions) {
       this.idPedido = idPedido;
       this.proveedor = proveedor;
       this.mediopago = mediopago;
       this.usuario = usuario;
       this.confirmacions = confirmacions;
       this.conceptousuarios = conceptousuarios;
       this.discos = discos;
       this.cancions = cancions;
    }
   
    public int getIdPedido() {
        return this.idPedido;
    }
    
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
    public Proveedor getProveedor() {
        return this.proveedor;
    }
    
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    public Mediopago getMediopago() {
        return this.mediopago;
    }
    
    public void setMediopago(Mediopago mediopago) {
        this.mediopago = mediopago;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Set<Confirmacion> getConfirmacions() {
        return this.confirmacions;
    }
    
    public void setConfirmacions(Set<Confirmacion> confirmacions) {
        this.confirmacions = confirmacions;
    }
    public Set<Conceptousuario> getConceptousuarios() {
        return this.conceptousuarios;
    }
    
    public void setConceptousuarios(Set<Conceptousuario> conceptousuarios) {
        this.conceptousuarios = conceptousuarios;
    }
    public Set<Disco> getDiscos() {
        return this.discos;
    }
    
    public void setDiscos(Set<Disco> discos) {
        this.discos = discos;
    }
    public Set<Cancion> getCancions() {
        return this.cancions;
    }
    
    public void setCancions(Set<Cancion> cancions) {
        this.cancions = cancions;
    }




}


