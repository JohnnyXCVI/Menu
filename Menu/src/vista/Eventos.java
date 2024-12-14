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
public class Eventos {
    public void guardar(app.Eventos ventana){
        if(ventana.evento_txt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, "Debes ingresar la categoria del evento");
            return;
        }
        if(ventana.cod_txt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, "Debes de ingresar un codigo");
            return;
        }
        if(ventana.descripcion_txt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, "Debes poner una descripcion");
            return;
        }
        if(ventana.area_txt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(ventana, "debes ingresar un area");
            return;
        }
        
        new modelos.BaseDatos().lista_eventos.add(new modelos.Eventos(
                ventana.evento_txt.getText(), 
                ventana.cod_txt.getText(), 
                ventana.descripcion_txt.getText(), 
                ventana.area_txt.getText(), 
                ventana.estado_cb.getSelectedItem().toString()));
        
        ventana.evento_txt.setText("");
        ventana.cod_txt.setText("");
        ventana.descripcion_txt.setText("");
        ventana.area_txt.setText("");
        
        cargarTabla(ventana.eventos_tb);
    }
    
    public void cargarTabla(JTable tabla){
        //se obtiene la lista de la tabla
        ArrayList<modelos.Eventos> lista = new modelos.BaseDatos().lista_eventos;
        //se crea un modelo de tabla para insertar datos
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        //se recorre la lista y agregamos en la tabla
        modelo.setNumRows(0);
        //for e
        for (modelos.Eventos eventos : lista){
            modelo.addRow(new Object[]{
                eventos.getEvento(),
                eventos.getCod(),
                eventos.getDescripcion(),
                eventos.getArea(),
                eventos.getEstado()
            });
        }
    }
    
    public void eliminar(JTable tabla){
        int fila = tabla.getSelectedRow();
        if (fila == -1){
            JOptionPane.showMessageDialog(null, "Debes seleccionar un registro");
            return;
        }
        
        if(JOptionPane.showConfirmDialog(
                null, 
                "¿Estas seguro que deseas eliminar el registro?", 
                "¡¡¡ATENCION!!!", 
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            new modelos.BaseDatos().lista_eventos.remove(fila);
            cargarTabla(tabla);
        }
    }
}
