/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cajero;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * <ul>
 * <li>Esta clase representa un evento generado por el usuario al interactuar con la cuenta.</li>
 * <li>Estos eventos están asociados a gestiones como consultar saldo, depositar, retirar, transferir y crear cuenta.</li>
 * </ul>
 * 
 * @author Daniel
 */
public class Evento {

    private String nroCuenta;
    private String descripcion;
    private String monto;
    private String saldo;

 
    /**
     * Constructor de la clase Evento. Se crea un evento con un número de cuenta,
     * una descripción del evento, un monto y un saldo resultante.
     * 
     * @param nroCuenta Cadena que representa un número de cuenta de 8 dígitos.
     * @param descripcion Breve descripción del evento que se generó, puede ser:
     * <p>
     * Ejemplo:<br>
     *          - Se creó cuenta<br>
     *          - Se realizó un retiro<br>
     *          - Se realizó un depósito<br>
     *          - Se realizó una transferencia<br>
     *          - Se realizó una transferencia de la cuenta: 2341234<br>
     * </p>
     * @param monto Representa el monto de la operación.
     * @param saldo Representa el saldo actual después de la operación.
     */
    public Evento(String nroCuenta, String descripcion, String monto, String saldo) {
        this.nroCuenta = nroCuenta;
        this.descripcion = descripcion;
        this.monto = monto;
        this.saldo = saldo;
    }
    
    /**
     * Retorna el número de cuenta.
     * 
     * @return Número de cuenta como una cadena.
     */
    public String getNroCuenta() {
        return nroCuenta;
    }
    
    /**
     * Retorna la descripción de la operación.
     * 
     * @return Descripción de la operación como una cadena.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Retorna el monto de la operación.
     * 
     * @return Monto de la operación como una cadena.
     */
    public String getMonto() {
        return monto;
    }

    /**
     * Retorna el saldo después de una operación.
     * 
     * @return Saldo actual como una cadena.
     */
    public String getSaldo() {
        return saldo;
    }
    
    /**
     * Retorna la fecha en que se generó el evento.
     * 
     * @return Fecha del evento como una cadena en el formato yyyy/MM/dd.
     */
    public String getFecha() {
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String fechaFormateada = fechaActual.format(formato);
        return fechaFormateada;
    }
}
