package Interfaz;

import Dominio.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;


public class VConsulta extends javax.swing.JFrame {

    private Sistema sistema;
    public Color rosado = new Color(255, 175, 174);
    public Color transparente = new Color(255, 255, 255, 0);

    public VConsulta(Sistema unSistema) {

        sistema = unSistema;
        initComponents();
        agregarItemsProductos();
        //agregarItemsDias();
        cargarMatrizConsulta(sistema.getMapaPrincipal());

    }

    public void setPaneles() {

        jPanelLetras.setLayout(new GridLayout(16, 1));
        jPanel2.setLayout(new GridLayout(16, 50));
        jScrollPane1.setPreferredSize(new Dimension(730, 360));
        jScrollPane1.setViewportView(jPanel2);

    }

    public void setLabel(String letra, int y, Dimension dimension,
            Color color, Color colorLetra, JPanel panel) {

        JLabel label1 = new JLabel(letra);
        label1.setBounds(0, y, 30, 20);
        label1.setPreferredSize(dimension);
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setVerticalAlignment(JLabel.CENTER);
        label1.setBackground(color);
        label1.setForeground(colorLetra);
        label1.setOpaque(true);
        panel.add(label1);
    }

    public void cargarMatrizConsulta(int[][] unMapa) {

        setPaneles();
        String letras = "AABCDEFGHIJKLMNO";

        for (int i = 0; i < 16; i++) {

            int y = i * 20;

            if (i != 0) {

                String text = "  " + letras.charAt(i) + "  ";
                setLabel(text, y, new Dimension(40, 21), rosado, Color.black, jPanelLetras);

            }
        }

        for (int i = 0; i < 16; i++) {

            for (int j = 1; j < 51; j++) {

                int valor = unMapa[i][j];

                int y = i * 20;

                if (i == 0) {

                    String text = "       " + j + "      ";
                    setLabel(text, y, new Dimension(70, 20), rosado, Color.black, jPanel2);

                } else {

                    Color color = new Color(definirColor(valor, encontrarMax(unMapa)), 0, 0);
                    String text = "       " + valor + "      ";
                    setLabel(text, y, new Dimension(70, 20), color, Color.white, jPanel2);
                }
            }
        }
    }

    public int definirColor(int unValor, int unMax) {
        int numero;
        if (unMax != 0) {
            numero = (unValor * 255) / unMax;
        } else {
            numero = 0;
        }
        return numero;
    }

    public int encontrarMax(int[][] unMapa) {
        int maximo = Integer.MIN_VALUE;
        for (int i = 0; i < 16; i++) {
            for (int j = 1; j < 51; j++) {
                if (unMapa[i][j] > maximo) {
                    maximo = unMapa[i][j];
                }
            }
        }
        return maximo;
    }

    public void agregarItemsProductos() {

        comboBoxProductosFiltro.removeAllItems();
        Producto producto = new Producto("Todos los productos");
        comboBoxProductosFiltro.addItem(producto);

        try {
            for (int i = 0; i < sistema.getProducto().size(); i++) {

                comboBoxProductosFiltro.addItem(sistema.getProducto().get(i));
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error al cargar ComboBox productos" + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        panelPrimero = new javax.swing.JPanel();
        lblFiltroConsulta = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        comboBoxProductosFiltro = new javax.swing.JComboBox();
        btnFiltrar = new javax.swing.JButton();
        comboBoxDiasFiltro = new javax.swing.JComboBox();
        jPanelLetras = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();

        setTitle("Consulta");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panelPrimero.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFiltroConsulta.setText("Dia:");
        panelPrimero.add(lblFiltroConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 20));

        jLabel1.setText("Producto: ");
        panelPrimero.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 70, 20));

        panelPrimero.add(comboBoxProductosFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 220, -1));

        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });
        panelPrimero.add(btnFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, -1, -1));

        comboBoxDiasFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        panelPrimero.add(comboBoxDiasFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 110, -1));

        javax.swing.GroupLayout jPanelLetrasLayout = new javax.swing.GroupLayout(jPanelLetras);
        jPanelLetras.setLayout(jPanelLetrasLayout);
        jPanelLetrasLayout.setHorizontalGroup(
            jPanelLetrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );
        jPanelLetrasLayout.setVerticalGroup(
            jPanelLetrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 333, Short.MAX_VALUE)
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(500, 300));

        jPanel2.setMaximumSize(new java.awt.Dimension(3000, 3000));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 718, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 114, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanelLetras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panelPrimero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPrimero, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jPanelLetras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        setBounds(0, 0, 845, 478);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed

        Producto producto = (Producto) comboBoxProductosFiltro.getSelectedItem();
        int[][] unMapa = new int[16][51];
        sistema.iniciarMapa(unMapa);
        int dia = comboBoxDiasFiltro.getSelectedIndex();

        if (dia != 0) {

            if (producto.getNombre().equalsIgnoreCase("Todos los productos")) {

                for (int i = 0; i < sistema.getRegistro().size(); i++) {

                    if (sistema.getRegistro().get(i).getDia() == dia) {
                        sistema.actualizarMapa(sistema.getRegistro().get(i).getMapa(), unMapa);
                    }
                }

            } else {

                for (int i = 0; i < sistema.getRegistro().size(); i++) {

                    if (sistema.getRegistro().get(i).getProducto().equals(producto)
                            && sistema.getRegistro().get(i).getDia() == dia) {

                        sistema.actualizarMapa(sistema.getRegistro().get(i).getMapa(), unMapa);
                    }
                }
            }
            jPanel2.removeAll();
            cargarMatrizConsulta(unMapa);

        } else {
            otraOpcion(unMapa);
        }
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Prueba.cargarMenu(sistema);
    }//GEN-LAST:event_formWindowClosing

    public void otraOpcion(int[][] unMapaX) {

        Producto producto = (Producto) comboBoxProductosFiltro.getSelectedItem();

        if (producto.getNombre().equalsIgnoreCase("Todos los productos")) {
            jPanel2.removeAll();
            cargarMatrizConsulta(sistema.getMapaPrincipal());

        } else {

            for (int i = 0; i < sistema.getRegistro().size(); i++) {

                if (sistema.getRegistro().get(i).getProducto().equals(producto)) {
                    sistema.actualizarMapa(sistema.getRegistro().get(i).getMapa(), unMapaX);
                }
            }
            jPanel2.removeAll();
            cargarMatrizConsulta(unMapaX);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JComboBox comboBoxDiasFiltro;
    private javax.swing.JComboBox comboBoxProductosFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelLetras;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFiltroConsulta;
    private javax.swing.JPanel panelPrimero;
    // End of variables declaration//GEN-END:variables
}
