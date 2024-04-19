package cajero;

import cajero.GestorIO;

public class Cajero {

    public static final int INICIAR_SESION = 1;
    public final int CREAR_CUENTA = 2;
    public final int SALIR = 3;
    private int eleccion;
    private Gestionador gestionador;

    public Cajero() {
        gestionador = new Gestionador();
        int eleccion = 0;

    }


    private void gestionar() {
        do {
            GestorIO gestorIO = new GestorIO();
            gestorIO.out("Escoje una opcion");
            gestorIO.out("1. Iniciar Sesion");
            gestorIO.out("2. Crear Cuenta");
            gestorIO.out("3. Salir");
            eleccion = gestorIO.inInt();
            if (eleccion == INICIAR_SESION) {
                gestionador.iniciarSesion();
            } else if (eleccion == CREAR_CUENTA) {
                gestionador.crearCuenta();
            }

        } while (eleccion != SALIR);
    }

    public static void main(String[] args) {
        Cajero atm = new Cajero();
        atm.gestionar();
    }

}
