package ventanas;

import cajero.Evento;
import cajero.GestorCuenta;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 * PanelTransferir es una clase que representa el panel de transferencia de
 * fondos en la interfaz gráfica de usuario de un cajero automático. Esta clase
 * permite al usuario transferir fondos a otra cuenta utilizando la divisa
 * especificada.
 *
 * Los componentes de este panel incluyen campos de texto para ingresar el
 * número de cuenta de destino y el monto a transferir, botones para realizar la
 * transferencia y regresar a la pantalla anterior, etiquetas para mostrar la
 * divisa seleccionada, el saldo disponible en la cuenta y mensajes de aviso.
 * 
 * @author Daniel
 */
public class PanelTransferir extends javax.swing.JPanel {

    /**
     * Constructor público que recibe la divisa, un objeto GestorCuenta, un
     * contenedor para los paneles de opciones, un modelo de tabla para el
     * registro de eventos y el marco principal de la aplicación como
     * parámetros. En el constructor se inicializan los componentes del panel y
     * se configuran los eventos de los botones para realizar la transferencia y
     * regresar a la pantalla de opciones.
     *
     * @param divisa Divisa seleccionada para la transferencia
     * @param gestionador Instancia de GestorCuenta para manejar las operaciones
     * relacionadas con la cuenta.
     * @param panelOpciones Contenedor para los paneles de opciones
     * @param registro Modelo de tabla para el registro de eventos
     * @param panelPrincipal Marco principal de la aplicación
     */
    public PanelTransferir(String divisa, GestorCuenta gestionador, Container panelOpciones, DefaultTableModel registro, JFrame panelPrincipal) {
        initComponents();
        panelOpciones.remove(1);
        panelOpciones.add(this, BorderLayout.NORTH);
        panelOpciones.revalidate();
        panelOpciones.repaint();
        panelPrincipal.pack();
        lblDivisa.setText(divisa);
        lblMonto.setText(String.format("%.2f", Double.parseDouble(gestionador.saldoDisponible())));
        lblDivisaSaldo.setText(gestionador.getDivisa());

        btnTranferir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double montoExistente = Double.parseDouble(gestionador.saldoDisponible());
                double montoATranferir = Double.parseDouble(jtfMontoATransferir.getText());

                if (montoExistente >= montoATranferir) {
                    registro.setRowCount(0);
                    String numCuenta = jtfNroCuentaAbonado.getText();
                    double montoConvertido = gestionador.getMontoConvertido(divisa.toLowerCase(), montoATranferir);
                    double montoConvertidoDestino = gestionador.getMontoConvertido(divisa.toLowerCase(), montoATranferir, numCuenta);
                    gestionador.transferir(lblDivisa.getText().toLowerCase(), montoATranferir, jtfNroCuentaAbonado.getText());
                    gestionador.crearEvento(new Evento(gestionador.getNroCuenta(), "Se realizó una transferencia.", Double.toString(montoConvertido), gestionador.saldoDisponible()));
                    gestionador.crearEvento(new Evento(numCuenta, "Se realizo un transferencia externa:" + gestionador.getNroCuenta(), Double.toString(montoConvertidoDestino), gestionador.saldoDisponible()));
                    List<Evento> eventos = gestionador.getEventos();
                    for (int i = 0; i < eventos.size(); i++) {
                        Evento evento = eventos.get(i);
                        String[] filaEvento = new String[4];
                        filaEvento[0] = evento.getFecha();
                        filaEvento[1] = evento.getDescripcion();
                        filaEvento[2] = String.format("%.2f", Double.parseDouble(evento.getMonto()));
                        filaEvento[3] = String.format("%.2f", Double.parseDouble(evento.getSaldo()));
                        registro.addRow(filaEvento);
                    }

                    lblMonto.setText(String.format("%.2f", Double.parseDouble(gestionador.saldoDisponible())));
                    lblAviso.setText("Operación Exitosa");
                    lblAviso.setForeground(new Color(0, 153, 0));
                } else {
                    lblAviso.setText("Entrada Inválida");
                    lblAviso.setForeground(new Color(204, 0, 0));
                }
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

        btnTranferir = new javax.swing.JButton();
        jtfNroCuentaAbonado = new javax.swing.JTextField();
        jtfMontoATransferir = new javax.swing.JTextField();
        lblMontoATransferir = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        lblCuentaAbono = new javax.swing.JLabel();
        lblDivisa = new javax.swing.JLabel();
        lblSaldoDisponible = new javax.swing.JLabel();
        lblMonto = new javax.swing.JLabel();
        lblDivisaSaldo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblAviso = new javax.swing.JLabel();

        setBackground(new java.awt.Color(134, 190, 225));

        btnTranferir.setBackground(new java.awt.Color(0, 174, 237));
        btnTranferir.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        btnTranferir.setForeground(new java.awt.Color(255, 255, 255));
        btnTranferir.setText("Transferir");

        lblMontoATransferir.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        lblMontoATransferir.setForeground(new java.awt.Color(255, 255, 255));
        lblMontoATransferir.setText("Monto a Transferir");

        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N

        lblCuentaAbono.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        lblCuentaAbono.setForeground(new java.awt.Color(255, 255, 255));
        lblCuentaAbono.setText("Nro: Cuenta de Abono");

        lblDivisa.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        lblDivisa.setForeground(new java.awt.Color(255, 255, 255));

        lblSaldoDisponible.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        lblSaldoDisponible.setForeground(new java.awt.Color(255, 255, 255));
        lblSaldoDisponible.setText("Saldo Disponible:");

        lblMonto.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        lblMonto.setForeground(new java.awt.Color(255, 255, 255));
        lblMonto.setText("0000000000");

        lblDivisaSaldo.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        lblDivisaSaldo.setForeground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(4, 86, 160));

        jLabel1.setFont(new java.awt.Font("Lucida Console", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Transferencia");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(21, 21, 21))
        );

        lblAviso.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        lblAviso.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMontoATransferir)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtfMontoATransferir, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDivisa, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblCuentaAbono)
                    .addComponent(jtfNroCuentaAbonado, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAviso, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(53, 53, 53)
                            .addComponent(btnTranferir)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAtras))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(lblSaldoDisponible)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblMonto)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblDivisaSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDivisaSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblSaldoDisponible)
                                .addComponent(lblMonto)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(lblCuentaAbono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(jtfNroCuentaAbonado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(lblMontoATransferir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDivisa, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfMontoATransferir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblAviso, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(btnTranferir))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAtras)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnTranferir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jtfMontoATransferir;
    private javax.swing.JTextField jtfNroCuentaAbonado;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblCuentaAbono;
    private javax.swing.JLabel lblDivisa;
    private javax.swing.JLabel lblDivisaSaldo;
    private javax.swing.JLabel lblMonto;
    private javax.swing.JLabel lblMontoATransferir;
    private javax.swing.JLabel lblSaldoDisponible;
    // End of variables declaration//GEN-END:variables
}
