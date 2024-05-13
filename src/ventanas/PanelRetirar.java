/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ventanas;

import cajero.Cuenta;
import cajero.Evento;
import cajero.GestorCuenta;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel
 */
public class PanelRetirar extends javax.swing.JPanel {

    /**
     * Creates new form PanelRetirar
     */
    public PanelRetirar(String divisa, GestorCuenta gestionador, Container panelOpciones, DefaultTableModel registro, JFrame panelPrincipal) {
        initComponents();
        System.out.println("Panel Opciones: "+ panelOpciones.getComponentCount());
        panelOpciones.remove(1);
        panelOpciones.add(this, BorderLayout.NORTH);
        panelOpciones.revalidate();
        panelOpciones.repaint();
        panelPrincipal.revalidate();
        panelPrincipal.pack();
        lblDivisa.setText(divisa);
        
        
        List<Cuenta> cuentas = gestionador.getCuentas();
        Cuenta[] listaCuentas = new Cuenta[cuentas.size()];        
        for (int i = 0; i < cuentas.size(); i++) {
            listaCuentas[i] = cuentas.get(i); 
        }
             
        jcbSeleccionarCuenta.setModel(new DefaultComboBoxModel(listaCuentas));       
        jcbSeleccionarCuenta.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Cuenta cuenta = (Cuenta) jcbSeleccionarCuenta.getSelectedItem();
                lblMonto.setText(gestionador.saldoDisponible(cuenta.getNroCuenta()));
            }
        });
        
        btnRetirar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registro.setRowCount(0);
                String monto = jtfMontoARetirar.getText();
                Cuenta cuenta = (Cuenta) jcbSeleccionarCuenta.getSelectedItem();
                gestionador.retirar(divisa.toLowerCase(), Double.parseDouble(monto), cuenta.getNroCuenta());
                gestionador.crearEvento(new Evento(cuenta.getNroCuenta(), "Se realizó un retiro.", "-"+monto, gestionador.saldoDisponible(cuenta.getNroCuenta())));
                List<Evento> eventos = gestionador.getEventos(cuenta.getNroCuenta());
                
                for (int i = 0; i < eventos.size(); i++) {
                    Evento evento = eventos.get(i);
                    String[] filaEvento = new String[4];
                    filaEvento[0] = evento.getFecha();
                    filaEvento[1] = evento.getDescripcion();
                    filaEvento[2] = evento.getMonto();
                    filaEvento[3] = evento.getSaldo();
                    registro.addRow(filaEvento);
                }             
                lblMonto.setText(gestionador.saldoDisponible(cuenta.getNroCuenta()));
            }

        });

        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelOpciones panelOpciones = new PanelOpciones(gestionador, panelPrincipal);
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

        btnRetirar = new javax.swing.JButton();
        jtfMontoARetirar = new javax.swing.JTextField();
        btnAtras = new javax.swing.JButton();
        lblMontoARetirar = new javax.swing.JLabel();
        jcbSeleccionarCuenta = new javax.swing.JComboBox<>();
        lblEscojerCuenta = new javax.swing.JLabel();
        lblDivisa = new javax.swing.JLabel();
        lblSaldo = new javax.swing.JLabel();
        lblMonto = new javax.swing.JLabel();

        btnRetirar.setText("Retirar");

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N

        lblMontoARetirar.setText("Monto a Retirar");

        lblEscojerCuenta.setText("Escoge la cuenta");

        lblSaldo.setText("SALDO DISPONIBLE:");

        lblMonto.setText("00000000");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(88, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSaldo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMonto))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMontoARetirar)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jtfMontoARetirar, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblDivisa, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jcbSeleccionarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEscojerCuenta))
                        .addGap(0, 53, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRetirar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAtras)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addComponent(lblEscojerCuenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbSeleccionarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSaldo)
                    .addComponent(lblMonto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMontoARetirar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfMontoARetirar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblDivisa, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(btnRetirar)
                        .addContainerGap(112, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAtras)
                        .addGap(104, 104, 104))))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnRetirar;
    private javax.swing.JComboBox<String> jcbSeleccionarCuenta;
    private javax.swing.JTextField jtfMontoARetirar;
    private javax.swing.JLabel lblDivisa;
    private javax.swing.JLabel lblEscojerCuenta;
    private javax.swing.JLabel lblMonto;
    private javax.swing.JLabel lblMontoARetirar;
    private javax.swing.JLabel lblSaldo;
    // End of variables declaration//GEN-END:variables
}
