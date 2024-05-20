/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ventanas;

import cajero.Evento;
import cajero.GestorCuenta;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel
 */
public class PanelCrearCuentaAdicional extends javax.swing.JPanel {

    /**
     * Creates new form PanelCrearCuentaAdicional
     */
    public PanelCrearCuentaAdicional(GestorCuenta gestionador, Container panelOpciones, DefaultTableModel registro, JFrame panelPrincipal) {
        initComponents();
        panelOpciones.remove(0);
        panelOpciones.add(this, BorderLayout.NORTH);
        panelOpciones.revalidate();
        panelOpciones.repaint();
        panelPrincipal.pack();
        
        lblCuentaGenerada.setText(""+gestionador.generarNumeroDeCuenta());
        jcbSeleccionarDivisa.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                lblCuentaGenerada.setText(""+gestionador.generarNumeroDeCuenta());
                
            }
        });
        
        btnCrearCuenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String montoInicial = JOptionPane.showInputDialog(null, "Depositar Monto Inicial:", "Monto Inicial", JOptionPane.WARNING_MESSAGE);
                String divisa = (String)jcbSeleccionarDivisa.getSelectedItem();
                gestionador.anadirCuenta(divisa.toLowerCase(), lblCuentaGenerada.getText(), montoInicial);
                gestionador.crearEvento(new Evento(lblCuentaGenerada.getText(), "Se crea cuenta", montoInicial, montoInicial));
                lblAviso.setText("Se creó cuenta exitosamente.");
            }

        });

        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {        
                PanelOpciones opciones = new PanelOpciones(gestionador, panelPrincipal);                
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

        jcbSeleccionarDivisa = new javax.swing.JComboBox<>();
        btnCrearCuenta = new javax.swing.JButton();
        lblCuentaGenerada = new javax.swing.JLabel();
        lblNroCuenta = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        lblDivisa = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblCrearCuentaAdicional = new javax.swing.JLabel();
        lblAviso = new javax.swing.JLabel();

        setBackground(new java.awt.Color(134, 190, 225));

        jcbSeleccionarDivisa.setFont(new java.awt.Font("Lucida Console", 1, 14)); // NOI18N
        jcbSeleccionarDivisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bolivianos", "Dolares", "Euros" }));

        btnCrearCuenta.setBackground(new java.awt.Color(0, 174, 237));
        btnCrearCuenta.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        btnCrearCuenta.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearCuenta.setText("Crear Cuenta");

        lblCuentaGenerada.setFont(new java.awt.Font("Lucida Console", 1, 14)); // NOI18N
        lblCuentaGenerada.setForeground(new java.awt.Color(255, 255, 255));
        lblCuentaGenerada.setText("000000000000");
        lblCuentaGenerada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        lblNroCuenta.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        lblNroCuenta.setForeground(new java.awt.Color(255, 255, 255));
        lblNroCuenta.setText("Nro Cuenta");

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N

        lblDivisa.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        lblDivisa.setForeground(new java.awt.Color(255, 255, 255));
        lblDivisa.setText("Divisa");

        jPanel1.setBackground(new java.awt.Color(4, 86, 160));

        lblCrearCuentaAdicional.setFont(new java.awt.Font("Lucida Console", 1, 24)); // NOI18N
        lblCrearCuentaAdicional.setForeground(new java.awt.Color(255, 255, 255));
        lblCrearCuentaAdicional.setText("Crear Cuenta Adicional");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(lblCrearCuentaAdicional)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblCrearCuentaAdicional)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        lblAviso.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        lblAviso.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(126, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDivisa)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCrearCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88)
                                .addComponent(btnAtras))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jcbSeleccionarDivisa, 0, 231, Short.MAX_VALUE)
                                .addComponent(lblAviso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap(44, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNroCuenta)
                            .addComponent(lblCuentaGenerada, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(lblNroCuenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCuentaGenerada, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(lblDivisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbSeleccionarDivisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblAviso, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(btnCrearCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAtras)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnCrearCuenta;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> jcbSeleccionarDivisa;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblCrearCuentaAdicional;
    private javax.swing.JLabel lblCuentaGenerada;
    private javax.swing.JLabel lblDivisa;
    private javax.swing.JLabel lblNroCuenta;
    // End of variables declaration//GEN-END:variables
}
