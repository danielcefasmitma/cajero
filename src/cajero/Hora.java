/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cajero;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase Hora para obtener la hora actual formateada.
 * @author Daniel
 */
public class Hora {
    /**
     * Obtiene la hora actual formateada como una cadena.
     * 
     * @return La hora actual formateada en el patrón "yyyy/MM/dd".
     */
    public static String hora(){
        LocalTime now = LocalTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String horaFormateada = now.format(formato);
        return horaFormateada;
    }
}
