/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author JDfla
 */
public class Proveedor {
    private String razon_social;
    private String ruc;
    private String direccion;
    private String telefono;
    private String estado;

    public Proveedor() {
    }

    public Proveedor(String razon_social, String ruc, String direccion, String telefono, String estado) {
        this.razon_social = razon_social;
        this.ruc = ruc;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = estado;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
