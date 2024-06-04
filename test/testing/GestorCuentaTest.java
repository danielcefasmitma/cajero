/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package testing;

import cajero.Cuenta;
import cajero.Evento;
import cajero.Usuario;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel
 */
public class GestorCuentaTest {
    
     private GestorCuenta gestorCuenta;
    
    public GestorCuentaTest() {
         gestorCuenta = new GestorCuenta();
         gestorCuenta.extraerCuentaUsuario("daniel87");
         gestorCuenta.establecerCuentaActual("26331250");
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    
    
    
   @Test
    public void testCrearCuenta() {
        System.out.println("crearCuenta");
        Usuario usuario = new Usuario("test123", "Test", "123", "12788484", "euros", "10");
        gestorCuenta.crearCuenta(usuario);
        boolean existeUsuario = gestorCuenta.existeUsuario("test123");
        boolean expResult = true;
        assertEquals(expResult, existeUsuario);
    }


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
    @Test
    public void testGetEventos() {
        System.out.println("getEventos");
        int expResult = 2;
        List<Evento> result = gestorCuenta.getEventos();
        assertEquals(expResult, result.size());
    }

    

    
    @Test
    public void testExisteUsuario() {
        System.out.println("existeUsuario");
        String nombreUsuario = "daniel87";
        boolean expResult = true;
        boolean result = gestorCuenta.existeUsuario(nombreUsuario);
        assertEquals(expResult, result);
    }

    
    @Test
    public void testContrasenaCoincide() {
        System.out.println("contrasenaCoincide");
        boolean expResult = true;
        boolean result = gestorCuenta.contrasenaCoincide(new char[] {'1','2','3','4'});
        assertEquals(expResult, result);
    }

    
    @Test
    public void testContrasenasCoinciden() {
        System.out.println("contrasenasCoinciden");
        String nuevaContrasena = "1234";
        String contrasenaActual = "4321";
        boolean expResult = false;
        boolean result = gestorCuenta.contrasenasCoinciden(nuevaContrasena, contrasenaActual);
        assertEquals(expResult, result);
       
    }

    
    @Test
    public void testSaldoDisponible() {
        System.out.println("saldoDisponible");
        String expResult = "10.0";
        String result = gestorCuenta.saldoDisponible();
        assertEquals(expResult, result);
    }
    

    
    @Test
    public void testGetTasaCambio() {
        System.out.println("getTasaCambio");
        String divisaOrigen = "dolares";
        String divisaDestino = "bolivianos";
        double expResult = 6.96;
        double result = gestorCuenta.getTasaCambio(divisaOrigen, divisaDestino);
        assertEquals(expResult, result, 0);
    }


    
    @Test
    public void testGetCuentas() {
        System.out.println("getCuentas");
        int expResult = 2;
        Cuenta[] result = gestorCuenta.getCuentas();
        assertEquals(expResult, result.length);
    }

 
    
    @Test
    public void testGetMonto() {
        System.out.println("getMonto");
        String expResult = "10.0";
        String result = gestorCuenta.getMonto();
        assertEquals(expResult, result);
    }

    
    @Test
    public void testGetDivisa() {
        System.out.println("getDivisa");
        String expResult = "bolivianos";
        String result = gestorCuenta.getDivisa();
        assertEquals(expResult, result);
    }


    @Test
    public void testGetNroCuenta() {
        System.out.println("getNroCuenta");
        String expResult = "26331250";
        String result = gestorCuenta.getNroCuenta();
        assertEquals(expResult, result);
    }

    
    @Test
    public void testGetMontoConvertido() {
        System.out.println("getMontoConvertido");
        String divisa = "dolares";
        double monto = 10;
        double expResult = 69.6;
        double result = gestorCuenta.getMontoConvertido("dolares", 10);
        assertEquals(expResult, result, 0);
    }


    
    @Test
    public void testTitularCuenta() {
        System.out.println("titularCuenta");
        String expResult = "Daniel Cefas Mitma";
        String result = gestorCuenta.titularCuenta();
        assertEquals(expResult, result);
    }
    **/
    
}
