/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ventanas;

import cajero.Gestionador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import cajero.*;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.Action;
import javax.swing.JFrame;

/**
 *
 * @author Daniel
 */
public class PanelSesionInicio extends javax.swing.JPanel {

    /**
     * Creates new form Principal
     */
    private Gestionador gestionador;

    public PanelSesionInicio(Gestionador gestionador, JFrame panelPrincipal) {
        initComponents();
        panelPrincipal.getContentPane().removeAll(); 
        panelPrincipal.getContentPane().add(this, BorderLayout.CENTER);
        panelPrincipal.getContentPane().revalidate();
        panelPrincipal.getContentPane().repaint();
        panelPrincipal.pack();
        
        btnIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreUsuario = jtNombreUsuario.getText();
                boolean existeUsuario = gestionador.existeUsuario(nombreUsuario);

                if (existeUsuario) {
                    PanelContrasena inicioSesion = new PanelContrasena(gestionador, panelPrincipal);
                }else{
  
                }
            }

        });
        
        btnCrearCuenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelCrearCuenta panelCrearCuenta = new PanelCrearCuenta(gestionador, panelPrincipal);
                
            }
        });
        
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelPrincipal.dispose();
            }
        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnIniciarSesion = new javax.swing.JButton();
        btnCrearCuenta = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jtNombreUsuario = new javax.swing.JTextField();

        btnIniciarSesion.setText("Inciar Sesion");

        btnCrearCuenta.setText("Crear Cuenta");

        btnSalir.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCrearCuenta)
                            .addComponent(btnIniciarSesion))))
                .addContainerGap(162, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(jtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnIniciarSesion)
                .addGap(43, 43, 43)
                .addComponent(btnCrearCuenta)
                .addGap(42, 42, 42)
                .addComponent(btnSalir)
                .addContainerGap(107, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearCuenta;
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnSalir;
    private javax.swing.JTextField jtNombreUsuario;
    // End of variables declaration//GEN-END:variables
}