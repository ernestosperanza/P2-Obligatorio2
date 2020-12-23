
package Interfaz;

import Dominio.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class VAgregarProducto extends javax.swing.JFrame {

    private Sistema sistema;

    public VAgregarProducto(Sistema unSistema) {
        sistema = unSistema;
        initComponents();
        objetoAPantalla();
    }

    public void objetoAPantalla() {
        listaProductosIngresados.setListData(sistema.listaDeProductosOrdenadaPorNombre().toArray());
        textNombreProducto.setText("");
        textCostoProducto.setText("");
        radioButtonNacional.setSelected(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblNombre = new javax.swing.JLabel();
        lblCosto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        textNombreProducto = new javax.swing.JTextField();
        textCostoProducto = new javax.swing.JTextField();
        btnAgregarProducto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaProductosIngresados = new javax.swing.JList();
        lblListaProductos = new javax.swing.JLabel();
        radioButtonNacional = new javax.swing.JRadioButton();
        radioButtonImportado = new javax.swing.JRadioButton();

        setTitle("Agregar Producto");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        lblNombre.setText("Nombre:");
        getContentPane().add(lblNombre);
        lblNombre.setBounds(20, 20, 70, 30);

        lblCosto.setText("Costo:");
        getContentPane().add(lblCosto);
        lblCosto.setBounds(20, 70, 70, 20);

        jLabel1.setText("Origen:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 120, 70, 20);

        textNombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNombreProductoActionPerformed(evt);
            }
        });
        getContentPane().add(textNombreProducto);
        textNombreProducto.setBounds(90, 30, 120, 20);
        getContentPane().add(textCostoProducto);
        textCostoProducto.setBounds(90, 70, 120, 20);

        btnAgregarProducto.setText("Agregar");
        btnAgregarProducto.setPreferredSize(new java.awt.Dimension(80, 30));
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarProducto);
        btnAgregarProducto.setBounds(90, 210, 80, 30);

        jScrollPane1.setViewportView(listaProductosIngresados);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(240, 60, 300, 200);

        lblListaProductos.setText("Lista productos ingresados:");
        getContentPane().add(lblListaProductos);
        lblListaProductos.setBounds(240, 30, 180, 20);

        buttonGroup1.add(radioButtonNacional);
        radioButtonNacional.setText("Nacional");
        radioButtonNacional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonNacionalActionPerformed(evt);
            }
        });
        getContentPane().add(radioButtonNacional);
        radioButtonNacional.setBounds(90, 120, 78, 20);

        buttonGroup1.add(radioButtonImportado);
        radioButtonImportado.setText("Importado");
        radioButtonImportado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonImportadoActionPerformed(evt);
            }
        });
        getContentPane().add(radioButtonImportado);
        radioButtonImportado.setBounds(90, 150, 88, 20);

        setBounds(0, 0, 560, 302);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        String nombre = textNombreProducto.getText();
        String cost = textCostoProducto.getText();
        
        if(!nombre.isEmpty() && !cost.isEmpty()){
            
        if (sistema.validarNombreProducto(nombre)) {
            
            try {
                float costo = Float.parseFloat(textCostoProducto.getText());
                String origen = "";
                
                if (radioButtonNacional.isSelected()) {
                    origen = "Nacional";
                } else if (radioButtonImportado.isSelected()) {
                    origen = "Importado";
                }
                sistema.crearProducto(nombre.toLowerCase(), costo, origen);
                JOptionPane.showMessageDialog(null, "Alta de producto realizada con exito","", JOptionPane.INFORMATION_MESSAGE);
                objetoAPantalla();
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor numerico","", JOptionPane.ERROR_MESSAGE);
                textCostoProducto.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El nombre tiene que tener al menos 3 caracteres y no repetirse entre los productos de la lista","", JOptionPane.ERROR_MESSAGE);
            objetoAPantalla();
        }
        }else{
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar completos y con datos validos","", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void radioButtonImportadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonImportadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioButtonImportadoActionPerformed

    private void radioButtonNacionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonNacionalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioButtonNacionalActionPerformed

    private void textNombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNombreProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNombreProductoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Prueba.cargarMenu(sistema);
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblListaProductos;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JList listaProductosIngresados;
    private javax.swing.JRadioButton radioButtonImportado;
    private javax.swing.JRadioButton radioButtonNacional;
    private javax.swing.JTextField textCostoProducto;
    private javax.swing.JTextField textNombreProducto;
    // End of variables declaration//GEN-END:variables
}
