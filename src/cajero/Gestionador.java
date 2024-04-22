/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cajero;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Gestionador {

    private File directorioUsuarios;
    private GestorArchivo gestorArchivo;

    public Gestionador() {
        gestorArchivo = new GestorArchivo();
        directorioUsuarios = new File(System.getProperty("user.dir") + "/src/usuarios/");
        if (!directorioUsuarios.exists()) {
            directorioUsuarios.mkdir();
        }
    }

    public void crearCuenta(String nombreUsuario, String nombreTitular, char[] contrasena) {
        System.out.println(directorioUsuarios);
        try {
            File directorio = new File(directorioUsuarios +"/"+ nombreUsuario+ ".txt");
            directorio.createNewFile();
            escribirDatosUsuario(directorio,nombreUsuario, nombreTitular, contrasena);

        } catch (IOException ex) {
            Logger.getLogger(Gestionador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    private void escribirDatosUsuario(File directorio, String nombreUsuario, String nombreTitular, char[] contrasena) throws IOException {
        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(directorio, true)));
        br.write(nombreUsuario);
        br.newLine();
        br.write(nombreTitular);
        br.newLine();
        br.write(""+generarNumeroDeCuenta());
        br.newLine();
        br.write(procesarContrasena(contrasena));
        br.newLine();
        br.write(""+0);
        br.close();
    }
    
    private String procesarContrasena(char[] contrasena){
        String contrasenaCadena = "";
        for(int i = 0; i < contrasena.length; i++){
            contrasenaCadena += "" + contrasena[i];
        }
        return contrasenaCadena;
    }
 
    private int generarNumeroDeCuenta() {
        SecureRandom sr = null;
        int min = 20000000;
        int max = 30000000;
        try {
            sr = SecureRandom.getInstance("SHA1PRNG");

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Gestionador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sr.nextInt(min, max);

    }
     
    public boolean existeUsuario(String nombreUsuario) {
        return gestorArchivo.existeUsuario(nombreUsuario);

    }

    public boolean contrasenaCoincide(char[] contrasena) {
        return gestorArchivo.contrasenaCoincide(contrasena);
    }

    public String saldoDisponible() {
        return "" + gestorArchivo.saldoDisponible();
    }

    public boolean depositar(int monto) {
        return gestorArchivo.depositarDinero(monto);
    }

    public boolean retirar(int monto) {
        return gestorArchivo.retirarDinero(monto);
    }

    public boolean transferir(String numCuenta, String monto) {
        return gestorArchivo.tranferir(numCuenta, monto);
    }

    public boolean cambiarContrasena(char[] nuevaCont, char[] confirmacionCont) {
        return gestorArchivo.cambiarContraseña(nuevaCont, confirmacionCont);
    }

    public boolean contrasenasCoinciden(char[] nuevaContrasena, char[] confirmacionContrasena) {
        return gestorArchivo.contrasenaCoincide(nuevaContrasena, confirmacionContrasena);
    }

}
