/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cajero;

import cajero.GestorIO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Gestionador {

    private PanelOpciones opciones;
    private Usuario usuario;
    private File directorioUsuarios;
    
    public Gestionador() {
        usuario = null;
        opciones = null;
        directorioUsuarios = new File(System.getProperty("user.dir")+"/src/usuarios/");
        if(!directorioUsuarios.exists()){
            directorioUsuarios.mkdir();
        }
    }

    public void iniciarSesion() {
        GestorIO gestorIO = new GestorIO();
        usuario = recojerDatosInicioSesion();
        File cuenta = new File(directorioUsuarios + usuario.getNombreUsuario()+ ".txt");
        if (cuenta.exists()) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(cuenta)));
                boolean esMismaContraseña = false;
                List<String> lineasArchivo = br.lines().toList();
                String contrasenaDeArchivo = lineasArchivo.get(GestorArchivo.LINEA_SALDO - 1);
                esMismaContraseña = usuario.getContrasena().equals(contrasenaDeArchivo);

                if (esMismaContraseña) {
                    opciones = new PanelOpciones(cuenta);
                } else {                   
                    gestorIO.out("Colocaste una constraseña incorrecta");
                }
            } catch (IOException e) {
                e.printStackTrace();
            };

        }else{
            gestorIO.out("No existe la cuenta");
        }
    }

    public void crearCuenta() {
        usuario = recojerDatosCreacionDeCuenta();
        try {
            File directorio = new File(directorioUsuarios + usuario.getNombreUsuario()+ ".txt");
            directorio.createNewFile();
            escribirDatosUsuario(directorio);

        } catch (IOException ex) {
            Logger.getLogger(Gestionador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void escribirDatosUsuario(File directorio) throws IOException {
        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(directorio, true)));
        br.write(usuario.getNombreUsuario());
        br.newLine();
        br.write(usuario.getNombreTitular());
        br.newLine();
        br.write(""+generarNumeroDeCuenta());
        br.newLine();
        br.write(usuario.getContrasena());
        br.newLine();
        br.write(""+0);
        br.close();
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

    private Usuario recojerDatosInicioSesion() {
        GestorIO gestorIO = new GestorIO();
        gestorIO.out("Ingrese su Nombre de Usuario");
        String nombre = gestorIO.inString();
        gestorIO.out("Ingrese su contrasena");
        String contrasena = gestorIO.inString();
        return new Usuario(nombre, contrasena);
    }

    private Usuario recojerDatosCreacionDeCuenta() {   
        String nombreUsuario = "";
        String nombreTitular = "";
        String contrasena = "";
        GestorIO gestorIO = new GestorIO();
        gestorIO.out("Introduce tu nombre de usuario:");
        nombreUsuario = gestorIO.inString();
        gestorIO.out("Introduce tu nombre completo:");
        nombreTitular = gestorIO.inString();
        boolean contrasenasIguales = false;
        do {
            gestorIO.out("Introduce tu contraseña");
            contrasena = gestorIO.inString();
            gestorIO.out("Introduce tu contraseña otra vez");
            contrasenasIguales = gestorIO.inString().equals(contrasena);
        } while (!contrasenasIguales);
        return new Usuario(nombreUsuario, nombreTitular, contrasena);
    }

}
