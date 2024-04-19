/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cajero;

import cajero.GestorIO;
import java.io.File;


/**
 *
 * @author Daniel
 */
public class PanelOpciones {

    private final int CONSULTAR_SALDO = 1;
    private final int RETIRAR_DINERO = 2;
    private final int DEPOSITAR_DINERO = 3;
    private final int TRANSFERIR_DINERO = 4;
    private final int CAMBIAR_CONTRASENA = 5;
    private final int SALIR = 6;
    private int eleccion;
    private GestorArchivo gestorArchivo;

    public PanelOpciones(File cuenta) {
        eleccion = 0;
        gestorArchivo = new GestorArchivo(cuenta);
        realizarOperaciones(cuenta);
    }

    private void realizarOperaciones(File cuenta) {

        do {
            mostrarOpciones();
            eleccion = new GestorIO().inInt();
            switch (eleccion) {
                case CONSULTAR_SALDO:
                    gestorArchivo.consultarSaldo();
                    break;
                case RETIRAR_DINERO:
                    gestorArchivo.retirarDinero();
                    break;
                case DEPOSITAR_DINERO:
                    gestorArchivo.depositarDinero();
                    break;
                case TRANSFERIR_DINERO:
                    gestorArchivo.transferirDinero();
                    break;
                case CAMBIAR_CONTRASENA:
                    gestorArchivo.cambiarContraseña();
                    break;
            }
        } while (eleccion != SALIR);
    }

    private void mostrarOpciones() {
        GestorIO gestorIO = new GestorIO();
        gestorIO.out("¿Qué Operacion Desea Realizar?");
        gestorIO.out("1.¿Consultar Saldo?");
        gestorIO.out("2.¿Retirar Dinero?");
        gestorIO.out("3.¿Depositar Dinero?");
        gestorIO.out("4.¿Transferir Dinero a otra cuenta?");
        gestorIO.out("5.¿Cambiar Contraseña?");
        gestorIO.out("6. Salir");
    }

}
