/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cajero;
/**
 * Clase Usuario que representa a un usuario con sus datos personales y bancarios.
 * @author Daniel
 */
public class Usuario {

    private String nombreUsuario;
    private String nombreTitular;
    private String contrasena;
    private String nroCuenta;
    private String divisa;
    private String monto;
    
   
    /**
     * Constructor de la clase Usuario.
     * 
     * @param nombreUsuario El nombre de usuario.
     * @param nombreTitular El nombre del titular de la cuenta.
     * @param contrasena La contraseña del usuario.
     * @param nroCuenta El número de cuenta del usuario.
     * @param divisa La divisa de la cuenta.
     * @param montoInicial El monto inicial en la cuenta.
     */
    public Usuario(String nombreUsuario, String nombreTitular, String contrasena, String nroCuenta, String divisa, String montoInicial){
        
        this.nombreUsuario = nombreUsuario;
        this.nombreTitular = nombreTitular;
        this.contrasena = contrasena;
        this.nroCuenta = nroCuenta;
        this.divisa = divisa;
        this.monto = montoInicial;
    }
    
     /**
     * Retorna el nombre de usuario.
     * 
     * @return <code>String</code>. El nombre de Usuario.
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Obtiene el nombre del titular de la cuenta.
     * 
     * @return <code>String</code> El nombre del titular de la cuenta.
     */
    public String getNombreTitular() {
        return nombreTitular;
    }
    
    /**
     * Obtiene el número de cuenta del usuario.
     * 
     * @return <code>String</code> El número de cuenta.
     */
    public String getNumeroCuenta() {
        return nroCuenta;
    }

    /**
     * Obtiene la contraseña del usuario.
     * 
     * @return <code>String</code> La contraseña del usuario.
     */
    public String getContrasena() {
        return contrasena;
    }
    
    /**
     * Obtiene el tipo de divisa en minúsculas.
     * 
     * @return <code>String</code> La divisa de la cuenta en minúsculas.
     */
    public String getTipoDivisa() {
        return divisa.toLowerCase();
    }
    
    /**
     * Obtiene el monto actual en la cuenta.
     * 
     * @return <code>String</code> El monto actual.
     */
    public String getMonto() {
        return monto;
    }
    
    
    private String procesarContrasena(char[] contrasena){
        String contrasenaCadena = "";
        for(int i = 0; i < contrasena.length; i++){
            contrasenaCadena += "" + contrasena[i];
        }
        return contrasenaCadena;
    }

    
}
