
package Interfaz;

import Dominio.*;
import javax.swing.JOptionPane;

public class VRegistroFumigacionIndividual extends javax.swing.JFrame {

    private Sistema sistema;

    public VRegistroFumigacionIndividual(Sistema unSistema) {
        sistema = unSistema;
        initComponents();
        agregarItemsProductos();
        agregarItemsPilotos();
        agregarItemsTecnicos();
        objetoAPantalla();
    }

    public void objetoAPantalla() {
        comboBoxPiloto.setSelectedIndex(0);
        comboBoxTecnico.setSelectedIndex(0);
        comboBoxProducto.setSelectedIndex(0);
        comboBoxDia.setSelectedIndex(0);
        textZonaAFumigar.setText("");
    }

    public void agregarItemsProductos() {

        comboBoxProducto.removeAllItems();
        try {
            for (int i = 0; i < sistema.getProducto().size(); i++) {

                comboBoxProducto.addItem(sistema.getProducto().get(i));
            }
        } catch (Exception e) { 
            JOptionPane.showMessageDialog(null, "Error al cargar ComboBox productos" + e);
        }
    }

    public void agregarItemsPilotos() {
        comboBoxPiloto.removeAllItems();
        try {
            for (int i = 0; i < sistema.getPiloto().size(); i++) {

                comboBoxPiloto.addItem(sistema.getPiloto().get(i));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar ComboBox de Piloto" + e);
        }
    }

    public void agregarItemsTecnicos() {
        comboBoxTecnico.removeAllItems();
        try {
            for (int i = 0; i < sistema.getTecnico().size(); i++) {
                comboBoxTecnico.addItem(sistema.getTecnico().get(i));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar ComboBox de Tecnicos" + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboBoxPiloto = new javax.swing.JComboBox();
        comboBoxTecnico = new javax.swing.JComboBox();
        comboBoxProducto = new javax.swing.JComboBox();
        comboBoxDia = new javax.swing.JComboBox();
        textZonaAFumigar = new javax.swing.JTextField();
        lblPilotoQueFumiga = new javax.swing.JLabel();
        lblTecnicoQueFumiga = new javax.swing.JLabel();
        lblProductoQueSeUsa = new javax.swing.JLabel();
        lblDiaQueSeFumiga = new javax.swing.JLabel();
        lblZonaQueSeFumiga = new javax.swing.JLabel();
        btnAgregarFumigacionIndividual = new javax.swing.JButton();

        setTitle("Registro de Fumigaciones Individuales");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        comboBoxDia.setEditable(true);
        comboBoxDia.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        comboBoxDia.setMaximumRowCount(31);
        comboBoxDia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        comboBoxDia.setToolTipText("");
        comboBoxDia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxDiaItemStateChanged(evt);
            }
        });
        comboBoxDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxDiaActionPerformed(evt);
            }
        });

        lblPilotoQueFumiga.setText("Piloto:");

        lblTecnicoQueFumiga.setText("Tecnico:");

        lblProductoQueSeUsa.setText("Producto:");

        lblDiaQueSeFumiga.setText("Dia:");

        lblZonaQueSeFumiga.setText("Zona:");

        btnAgregarFumigacionIndividual.setText("Agregar");
        btnAgregarFumigacionIndividual.setMaximumSize(new java.awt.Dimension(80, 30));
        btnAgregarFumigacionIndividual.setMinimumSize(new java.awt.Dimension(80, 30));
        btnAgregarFumigacionIndividual.setPreferredSize(new java.awt.Dimension(80, 30));
        btnAgregarFumigacionIndividual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarFumigacionIndividualActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(btnAgregarFumigacionIndividual, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 247, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblDiaQueSeFumiga, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(20, 20, 20))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lblZonaQueSeFumiga, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(28, 28, 28)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPilotoQueFumiga, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblTecnicoQueFumiga, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblProductoQueSeUsa, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboBoxPiloto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBoxTecnico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBoxProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textZonaAFumigar, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(comboBoxDia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPilotoQueFumiga, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxPiloto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTecnicoQueFumiga, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductoQueSeUsa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDiaQueSeFumiga, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblZonaQueSeFumiga, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textZonaAFumigar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(btnAgregarFumigacionIndividual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        setBounds(0, 0, 560, 302);
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxDiaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxDiaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxDiaItemStateChanged

    private void comboBoxDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxDiaActionPerformed

    private void btnAgregarFumigacionIndividualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarFumigacionIndividualActionPerformed
        Piloto piloto = (Piloto) comboBoxPiloto.getSelectedItem();
        Tecnico tecnico = (Tecnico) comboBoxTecnico.getSelectedItem();
        Producto producto = (Producto) comboBoxProducto.getSelectedItem();
        int dia = comboBoxDia.getSelectedIndex()+1;
        String zona = textZonaAFumigar.getText();
        if (Prueba.verificarRangosDeZona(zona)) {
            int[] mapaDeRegistro = Prueba.descomponerInput(zona);
            sistema.crearRegistro(piloto, tecnico, producto, dia, zona, mapaDeRegistro);
            JOptionPane.showMessageDialog(null, "Registro guardado con exito","", JOptionPane.INFORMATION_MESSAGE);
            objetoAPantalla();
        } else {
            JOptionPane.showMessageDialog(null, "Utilice solo mayusculas y separe cada caracter por un guion", "Zona no valida", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarFumigacionIndividualActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Prueba.cargarMenu(sistema);
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarFumigacionIndividual;
    public javax.swing.JComboBox comboBoxDia;
    private javax.swing.JComboBox comboBoxPiloto;
    private javax.swing.JComboBox comboBoxProducto;
    private javax.swing.JComboBox comboBoxTecnico;
    private javax.swing.JLabel lblDiaQueSeFumiga;
    private javax.swing.JLabel lblPilotoQueFumiga;
    private javax.swing.JLabel lblProductoQueSeUsa;
    private javax.swing.JLabel lblTecnicoQueFumiga;
    private javax.swing.JLabel lblZonaQueSeFumiga;
    private javax.swing.JTextField textZonaAFumigar;
    // End of variables declaration//GEN-END:variables
}
