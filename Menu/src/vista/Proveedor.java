/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JDfla
 */
public class Proveedor {
    public void guardar(app.Proveedor ventana){
        if (ventana.razon_social_txt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, "Debes ingresar una razón social");
            return;
        }
        if (ventana.ruc_txt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, "Debes ingresar un RUC al proveedor");
            return;
        }
        if (ventana.telefono_txt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, "Debes ingresar un nº de telefono");
            return;
        }
        if (ventana.direccion_txt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, "Debes ingresar una dirección");
            return;
        }
        
        new modelos.BaseDatos().lista_proveedor.add(new modelos.Proveedor(
                ventana.razon_social_txt.getText(),
                ventana.ruc_txt.getText(),
                ventana.direccion_txt.getText(),
                ventana.telefono_txt.getText(),
                ventana.estado_box.getSelectedItem().toString()));
        
        cargarTabla(ventana.proveedor_tb);
    }
    public void cargarTabla(JTable tabla){
        //se obtiene la lista de proveedores
        ArrayList<modelos.Proveedor> lista = new modelos.BaseDatos().lista_proveedor;
        //se crea un modelo de tabla para insertar datos
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        //recorremos la lista y agregamos en la tabla
        modelo.setNumRows(0);
        //fore
        for (modelos.Proveedor proveedor : lista) {
            modelo.addRow(new Object[]{
                proveedor.getRazon_social(),
                proveedor.getRuc(),
                proveedor.getTelefono(),
                proveedor.getDireccion(),
                proveedor.getEstado()
            });
        }
    }
    public void eliminar(JTable tabla){
        int fila = tabla.getSelectedRow();
        if (fila == -1){
            JOptionPane.showMessageDialog(null, "Debes seleccionar una fila");
            return;
        }
        
        if (JOptionPane.showConfirmDialog(
                null, 
                "Estas seguro de eliminar el registro?", 
                "ATENCIÓN", 
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            new modelos.BaseDatos().lista_proveedor.remove(fila);
            cargarTabla(tabla);
        }
    }
    public void editar(){
    
    }
    
}
