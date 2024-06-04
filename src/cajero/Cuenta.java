/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cajero;


/**
 * Esta clase representa la creación de una cuenta bancaria asociada a un número de cuenta,
 * una divisa y un monto inicial.
 * 
 * @author Daniel
 */
public class Cuenta {
    
    private String nroCuenta;
    private String divisa;
    private String monto;
     /**
     * Constructor de la clase Cuenta. Se crea una cuenta con un número de cuenta,
     * una divisa y un monto inicial.
     * 
     * @param nroCuenta Cadena que representa un número de cuenta de 8 dígitos.
     * @param divisa Tipo de divisa (bolivianos, dólares, euros).
     * @param monto Representa el monto inicial de la cuenta.
     */
    public Cuenta(String nroCuenta, String divisa, String monto) {
        this.nroCuenta = nroCuenta;
        this.divisa = divisa;
        this.monto = monto;
    }

    /**
     * Retorna el número de cuenta de 8 dígitos.
     * 
     * @return Número de cuenta como una cadena.
     */
    public String getNroCuenta() {
        return nroCuenta;
    }
    
    /**
     * Retorna la divisa de la cuenta (bolivianos, dólares, euros).
     * 
     * @return Divisa de la cuenta como una cadena.
     */
    public String getDivisa() {
        return divisa;
    }
    
    /**
     * Retorna el monto disponible en la cuenta.
     * 
     * @return Monto disponible como una cadena.
     */
    public String getMonto() {
        return monto;
    }
    
    /**
     * Retorna una cadena que representa el número de cuenta y la divisa.
     * Ejemplo: 24553355 (bolivianos).
     * 
     * @return Representación de la cuenta como una cadena.
     */
    public String toString(){
        return nroCuenta + "("+ getDivisa()+ ")";
    }
}
