package Interfaz;

import Dominio.Sistema;
import java.util.*;
import javax.swing.*;

public class VAgregarPiloto extends javax.swing.JFrame {

    private Sistema sistema;

    public VAgregarPiloto(Sistema unSistema) {
        sistema = unSistema;
        initComponents();
        objetoAPantalla();
    }

    public void objetoAPantalla() {
        listaPilotosIngresados.setListData(sistema.listaDePilotosOrdenadaDecrecientemente().toArray());
        textNombrePiloto.setText("");
        textCedulaPiloto.setText("");
        textDireccionPiloto.setText("");
        textAñosExp.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textNombrePiloto = new javax.swing.JTextField();
        textCedulaPiloto = new javax.swing.JTextField();
        textDireccionPiloto = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblAñosDeExperiencia = new javax.swing.JLabel();
        btnAgregarPiloto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaPilotosIngresados = new javax.swing.JList();
        lblPilotosIngresados = new javax.swing.JLabel();
        textAñosExp = new javax.swing.JTextField();

        setTitle("Agregar Piloto");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        textNombrePiloto.setToolTipText("Nombre");
        textNombrePiloto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNombrePilotoActionPerformed(evt);
            }
        });
        getContentPane().add(textNombrePiloto);
        textNombrePiloto.setBounds(90, 20, 130, 20);

        textCedulaPiloto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCedulaPilotoActionPerformed(evt);
            }
        });
        getContentPane().add(textCedulaPiloto);
        textCedulaPiloto.setBounds(90, 60, 130, 22);
        getContentPane().add(textDireccionPiloto);
        textDireccionPiloto.setBounds(90, 100, 130, 20);

        lblNombre.setText("Nombre:");
        getContentPane().add(lblNombre);
        lblNombre.setBounds(20, 20, 60, 20);

        lblCedula.setText("Cedula:");
        getContentPane().add(lblCedula);
        lblCedula.setBounds(20, 60, 50, 20);

        lblDireccion.setText("Direccion:");
        getContentPane().add(lblDireccion);
        lblDireccion.setBounds(20, 100, 70, 20);

        lblAñosDeExperiencia.setText("Años de Experiencia:");
        getContentPane().add(lblAñosDeExperiencia);
        lblAñosDeExperiencia.setBounds(20, 140, 140, 20);

        btnAgregarPiloto.setText("Agregar");
        btnAgregarPiloto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPilotoActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarPiloto);
        btnAgregarPiloto.setBounds(80, 210, 80, 30);

        jScrollPane1.setViewportView(listaPilotosIngresados);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(240, 50, 300, 200);

        lblPilotosIngresados.setText("Lista pilotos ingresados:");
        getContentPane().add(lblPilotosIngresados);
        lblPilotosIngresados.setBounds(240, 20, 160, 20);

        textAñosExp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textAñosExpActionPerformed(evt);
            }
        });
        getContentPane().add(textAñosExp);
        textAñosExp.setBounds(160, 140, 60, 22);

        setBounds(0, 0, 560, 302);
    }// </editor-fold>//GEN-END:initComponents

    private void textNombrePilotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNombrePilotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNombrePilotoActionPerformed

    private void btnAgregarPilotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPilotoActionPerformed
        String nombre = textNombrePiloto.getText().trim();
        String cedula = textCedulaPiloto.getText().trim();
        String direccion = textDireccionPiloto.getText().trim();
        
        if (!direccion.isEmpty() && !nombre.isEmpty() && 
                !cedula.isEmpty() && !textAñosExp.getText().isEmpty()){
            
             if (sistema.validarCedulaPiloto(cedula)) {
                
                try {
                    int añosDeExperiencia = Integer.parseInt(textAñosExp.getText());
                    sistema.crearPiloto(nombre.toLowerCase(), cedula, direccion.toLowerCase(), añosDeExperiencia);
                    JOptionPane.showMessageDialog(null, "Alta de piloto realizado con exito","", JOptionPane.INFORMATION_MESSAGE);
                    objetoAPantalla();
                
                } catch (Exception e){
                    JOptionPane.showMessageDialog(null, "El campo Años de experiencia solo soporta numeros, por favor ingrese un numero","", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Cedula no valida, verifique que la cedula sea correcta y contenga 8 numeros y un guion","", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Todos los campos deben se completados para generar un nuevo piloto","", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarPilotoActionPerformed

    private void textCedulaPilotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCedulaPilotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCedulaPilotoActionPerformed

    private void textAñosExpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textAñosExpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textAñosExpActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Prueba.cargarMenu(sistema);
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarPiloto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAñosDeExperiencia;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPilotosIngresados;
    private javax.swing.JList listaPilotosIngresados;
    private javax.swing.JTextField textAñosExp;
    private javax.swing.JTextField textCedulaPiloto;
    private javax.swing.JTextField textDireccionPiloto;
    private javax.swing.JTextField textNombrePiloto;
    // End of variables declaration//GEN-END:variables
}