/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ventanas;

/**
 * Esta clase maneja el estado del índice seleccionado en un ComboBox.
 * 
 * @author Daniel
 */
public class EstadoComboBox {
   
    
    private static int indiceSeleccionado = 0;
    
    /**
     * Establece el índice seleccionado.
     * 
     * @param indice Índice seleccionado a establecer.
     */
    public static void setIndiceSeleccionado(int indice) {
        indiceSeleccionado = indice;
    }

    /**
     * Retorna el índice seleccionado actual.
     * 
     * @return Índice seleccionado actual.
     */
    public static int getIndiceSeleccionado() {
        return indiceSeleccionado;
    }
}
