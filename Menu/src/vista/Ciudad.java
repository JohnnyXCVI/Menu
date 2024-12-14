/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelos.BaseDatos;
/**
 *
 * @author JDfla
 */
public class Ciudad {
    public void guardar(app.Ciudad ventana){
        if (ventana.nombre_txt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, "Debes ingresar un nombre");
            return;
        }
        if (ventana.cod_txt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, "Debes ingresar un codigo");
            return;
        }
        if (ventana.descripcion_txt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, "Debes ingresar un descripcion");
            return;
        }
        
        new modelos.BaseDatos().lista_ciudad.add(new modelos.Ciudad(
                ventana.nombre_txt.getText(), 
                ventana.cod_txt.getText(), 
                ventana.descripcion_txt.getText(), 
                ventana.departamento_cb.getSelectedItem().toString(), 
                ventana.estado_cb.getSelectedItem().toString()));
        
        ventana.nombre_txt.setText("");
        ventana.cod_txt.setText("");
        ventana.descripcion_txt.setText("");
        
        cargarTabla(ventana.ciudades_tb);
    }
    
    public void cargarTabla(JTable tabla){
        //se obtiene la lista de ciudades
        ArrayList<modelos.Ciudad> lista = new modelos.BaseDatos().lista_ciudad;
        //se crea un modelo de la tabla para insertar datos
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        //recorremos la lista y agregamos la tabla
        modelo.setNumRows(0);
        //for e
        for (modelos.Ciudad ciudad : lista) {
            modelo.addRow(new Object[]{
                ciudad.getNombre(),
                ciudad.getCod(),
                ciudad.getDescripcion(),
                ciudad.getDepartamento(),
                ciudad.getEstado()
            });
        }
    }
    
    public void eliminar(JTable tabla){
        int fila = tabla.getSelectedRow();
        if (fila == -1){
            JOptionPane.showMessageDialog(null, "Debes Seleccionar una fila");
            return;
        }
        if (JOptionPane.showConfirmDialog(
                null, 
                "Estás seguro de eliminar el registro", 
                "ATENCION", 
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            new modelos.BaseDatos().lista_ciudad.remove(fila);
            cargarTabla(tabla);
        }
    }
}
