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

    public GestorArchivo(File cuenta) {
        this.cuenta = cuenta;
    }

    public void consultarSaldo() {
        GestorIO gestorIO = new GestorIO();
        gestorIO.out("" + saldoDisponible());
    }

    private int saldoDisponible() {
        List<String> contenido = getContenidoArchivo();
        return Integer.parseInt(contenido.get(LINEA_SALDO-1));
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

    public void retirarDinero() {
        GestorIO gestorIO = new GestorIO();
        gestorIO.out("Ingrese la Cantidad de Dinero a Retirar");
        int dineroARetirar = gestorIO.inInt();
        if (dineroARetirar < saldoDisponible()) {
            int nuevoSaldoDisponible = saldoDisponible() - dineroARetirar;
            escribirEnArchivo(LINEA_SALDO-1, nuevoSaldoDisponible + "");
        } else {
            gestorIO.out("No tiene saldo suficiente para retirar.");
        }
    }

    public void depositarDinero() {
        GestorIO gestorIO = new GestorIO();
        gestorIO.out("Ingrese la Cantidad de Dinero a Depositar");
        int dineroADepositar = gestorIO.inInt();
        int nuevoSaldoDisponible = saldoDisponible() + dineroADepositar;
        escribirEnArchivo(LINEA_SALDO-1, nuevoSaldoDisponible + "");

    }

    public void transferirDinero() {
        GestorIO gestorIO = new GestorIO();
        gestorIO.out("¿A que cuenta desea depositar?");
        String usuarioADepositar = gestorIO.inString();
        File cuentaADepositar = new File(System.getProperty("user.dir") + "/src/usuarios/" + usuarioADepositar + ".txt");

        if (cuentaADepositar.exists()) {
            gestorIO.out("¿Qúé monto desea depositar?");
            String montoADepositar = gestorIO.inString();
            File cuentaOrigen = cuenta;
            cuenta = cuentaADepositar;
            escribirEnArchivo(LINEA_SALDO-1, montoADepositar);
            cuenta = cuentaOrigen;
        } else {
            gestorIO.out("No existe esta cuenta.");
        }
    }

    public void cambiarContraseña() {
        GestorIO gestorIO = new GestorIO();
        gestorIO.out("Escriba su contraseña antigua");
        String contrasenaAntigua = gestorIO.inString();
        String contrasenaActual = getContenidoArchivo().get(LINEA_CONSTRASENA-1);
        if (contrasenaActual.equals(contrasenaAntigua)) {
            gestorIO.out("Escriba su nueva Contraseña");
            String nuevaConstrasena = gestorIO.inString();
            gestorIO.out("Escriba su nueva contraseña otra vez");
            String nuevaConstrasenaRepeticion = gestorIO.inString();
            if (nuevaConstrasena.equals(nuevaConstrasenaRepeticion)) {
                escribirEnArchivo(LINEA_CONSTRASENA-1, nuevaConstrasena);
            } else {
                gestorIO.out("Las constraseñas no coinciden");
            }
        } else {
            gestorIO.out("No es una contraseña correcta");
        }
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
