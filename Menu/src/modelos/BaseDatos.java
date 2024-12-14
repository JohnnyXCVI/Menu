/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.ArrayList;

/**
 *
 * @author JDfla
 */
public class BaseDatos {
    public static ArrayList<Proveedor> lista_proveedor = new ArrayList<>();
    public static ArrayList<Producto> lista_producto = new ArrayList<>();
    public static ArrayList<Ciudad> lista_ciudad = new ArrayList<>();
    public static ArrayList<Eventos> lista_eventos = new ArrayList<>();
    
    public void iniciarDatos(){
        //Lista de proveedor
        lista_proveedor.add(new Proveedor(
                "Proveedor 1", 
                "4564-7", 
                "Itaugua", 
                "03760650", 
                "Activo"));
        lista_proveedor.add(new Proveedor(
                "Proveedor 2", 
                "39756-7", 
                "Itaugua", 
                "5606059", 
                "Activo"));
        lista_proveedor.add(new Proveedor(
                "Proveedor 3", 
                "5748-2", 
                "Itaugua", 
                "945868", 
                "Activo"));
        
        //lista de productos
        
        lista_producto.add(new Producto(
                "teclado", 
                38000, 
                "sate", 
                "Teclados", 
                "Activo"));
        lista_producto.add(new Producto(
                "parlante", 
                40000, 
                "LUO", 
                "parlantes", 
                "Activo"));
        lista_producto.add(new Producto(
                "auriculares", 
                25000, 
                "Kolke", 
                "Auriculares", 
                "Activo"));
        
        //listado de ciudad
        lista_ciudad.add(new Ciudad(
                "ciudad 1", 
                "c1", 
                "description 1", 
                "DEPARTAMENTO 1", 
                "Activo"));
        
        lista_ciudad.add(new Ciudad(
                "ciudad 2", 
                "c2", 
                "description 2", 
                "DEPARTAMENTO 2", 
                "Inactivo"));
        
        //listado de eventos
        lista_eventos.add(new Eventos(
                "Conferencia", 
                "0001", 
                "descripcion 202401", 
                "UTCD Flial Itaugua", 
                "Activo"));
        lista_eventos.add(new Eventos(
                "Aniversario", 
                "0002", 
                "descripcion 202402", 
                "Hotel Olimpo", 
                "Inactivo"));
    }
}
