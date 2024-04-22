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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class GestorArchivo {

    final static int LINEA_NOMBRE_TITULAR = 2;
    final static int LINEA_NUMERO_CUENTA = 3;
    final static int LINEA_CONSTRASENA = 4;
    final static int LINEA_SALDO = 5;
    private File cuenta;
    private String directorioUsuarios = System.getProperty("user.dir") + "/src/usuarios/";

    
    public GestorArchivo(){
    }

    public int saldoDisponible() {
        List<String> contenido = getContenidoArchivo();
        return Integer.parseInt(contenido.get(LINEA_SALDO - 1));
    }

    public List<String> getContenidoArchivo() {
        List<String> contenido = null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(cuenta)));
            contenido = new ArrayList<>(br.lines().toList());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return contenido;
    }

    public boolean retirarDinero(int monto) {
        boolean sePudoRetirar = false;
        int dineroARetirar = monto;
        if (dineroARetirar < saldoDisponible()) {
            sePudoRetirar = true;
            int nuevoSaldoDisponible = saldoDisponible() - dineroARetirar;
            escribirEnArchivo(LINEA_SALDO - 1, nuevoSaldoDisponible + "");
        }
        return sePudoRetirar;
    }

    public boolean depositarDinero(int monto) {
        boolean sePudoDepositar = false;
        int dineroADepositar = monto;
        if (monto > 0) {
            sePudoDepositar = true;
            int nuevoSaldoDisponible = saldoDisponible() + dineroADepositar;
            escribirEnArchivo(LINEA_SALDO - 1, nuevoSaldoDisponible + "");
        }
        return sePudoDepositar;
    }

    public boolean cambiarContraseña(char[] nueva, char[] confirmacion) {
        String nuevaContrasena = "";
        boolean esMismaConstrasena = true;
        if (nueva.length == confirmacion.length) {           
            for (int i = 0; esMismaConstrasena && i < nueva.length; i++) {
                esMismaConstrasena = esMismaConstrasena && (nueva[i] == confirmacion[i]);
                if (esMismaConstrasena) {
                    nuevaContrasena = nuevaContrasena + "" + nueva[i];
                }
                nueva[i] = 0;
                confirmacion[i] = 0;
            }
            if (esMismaConstrasena) {
                escribirEnArchivo(LINEA_CONSTRASENA - 1, nuevaContrasena);
            }
        }
        return esMismaConstrasena;

    }
   
    public boolean existeUsuario(String nombreUsuario) {
        cuenta = new File(directorioUsuarios + nombreUsuario + ".txt");
        System.out.println(cuenta.exists());
        return cuenta.exists();
    }

    public boolean tranferir(String numCuenta, String montoATransferir) {
        File directorio = new File(directorioUsuarios);
        File[] cuentas = directorio.listFiles();
        boolean existeCuenta = false;
        try {
            int i = 0;
            while (!existeCuenta && i < cuentas.length) {
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(cuentas[i])));
                List<String> contenidoCuenta = br.lines().toList();
                String numCuentaArchivo = contenidoCuenta.get(LINEA_NUMERO_CUENTA - 1);
                existeCuenta = numCuenta.equals(numCuentaArchivo);
                if (!existeCuenta) {
                    i++;
                }
            }
            retirarDinero(Integer.parseInt(montoATransferir));
            File cuentaOrigen = cuenta;
            cuenta = cuentas[i];
            depositarDinero(Integer.parseInt(montoATransferir));
            escribirEnArchivo(LINEA_SALDO - 1, saldoDisponible() + "");
            cuenta = cuentaOrigen;
        } catch (IOException e) {
            e.printStackTrace();

        }
        return existeCuenta;
    }

    public boolean contrasenaCoincide(char[] contrasena) {
        boolean esMismaContraseña = false;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(cuenta)));
            List<String> contenidoCuenta = br.lines().toList();
            String contrasenaDeArchivo = contenidoCuenta.get(GestorArchivo.LINEA_CONSTRASENA - 1);
            String contrasenaIngresada = "";
            for (int i = 0; i < contrasena.length; i++) {
                contrasenaIngresada += "" + contrasena[i];
                contrasena[i] = 0;
            }
            esMismaContraseña = contrasenaIngresada.equals(contrasenaDeArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        };
        return esMismaContraseña;
    }

    public boolean contrasenaCoincide(char[] nueva, char[] confirmacion) {
        boolean esMismaConstrasena = true;
        if (nueva.length == confirmacion.length) {           
            for (int i = 0; esMismaConstrasena && i < nueva.length; i++) {
                esMismaConstrasena = esMismaConstrasena && (nueva[i] == confirmacion[i]);
            }
        }
        return esMismaConstrasena;
    }
    
    private void escribirEnArchivo(int nroLinea, String reemplazo) {
        List<String> contenido = getContenidoArchivo();
        contenido.set(nroLinea, reemplazo);
        StringBuilder sb = new StringBuilder();
        for (String registro : contenido) {
            sb.append(registro);
            sb.append("\n");
        }
        try {
            BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(cuenta, false)));
            br.write(sb.toString());
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
