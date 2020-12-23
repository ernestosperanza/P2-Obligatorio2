
package Interfaz;

import Dominio.*;
import javax.swing.JOptionPane;

public class VAgregarTecnico extends javax.swing.JFrame {

    private Sistema sistema;

    public VAgregarTecnico(Sistema unSistema) {
        sistema = unSistema;
        initComponents();
        objetoAPantalla();
    }

    public void objetoAPantalla() {
        listaTecnicosIngresados.setListData(sistema.listaDeTecnicosOrdenadaCrecientemente().toArray());
        textNombreTecnico.setText("");
        textCedulaTecnico.setText("");
        textMailTecnico.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        lblCedula = new javax.swing.JLabel();
        lblMail = new javax.swing.JLabel();
        textNombreTecnico = new javax.swing.JTextField();
        textCedulaTecnico = new javax.swing.JTextField();
        textMailTecnico = new javax.swing.JTextField();
        lblTecnicosIngresados = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaTecnicosIngresados = new javax.swing.JList();
        btnAgregarTecnico = new javax.swing.JButton();

        setTitle("Agregar Tecnico");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        lblNombre.setText("Nombre:");
        getContentPane().add(lblNombre);
        lblNombre.setBounds(20, 50, 60, 20);

        lblCedula.setText("Cedula:");
        getContentPane().add(lblCedula);
        lblCedula.setBounds(20, 90, 50, 20);

        lblMail.setText("Mail:");
        getContentPane().add(lblMail);
        lblMail.setBounds(20, 130, 40, 20);
        getContentPane().add(textNombreTecnico);
        textNombreTecnico.setBounds(80, 50, 120, 22);
        getContentPane().add(textCedulaTecnico);
        textCedulaTecnico.setBounds(80, 90, 120, 22);
        getContentPane().add(textMailTecnico);
        textMailTecnico.setBounds(80, 130, 120, 22);

        lblTecnicosIngresados.setText("Lista de tecnicos ingresados:");
        getContentPane().add(lblTecnicosIngresados);
        lblTecnicosIngresados.setBounds(220, 20, 190, 30);

        jScrollPane1.setViewportView(listaTecnicosIngresados);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(220, 50, 320, 210);

        btnAgregarTecnico.setText("Agregar");
        btnAgregarTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTecnicoActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarTecnico);
        btnAgregarTecnico.setBounds(80, 200, 80, 30);

        setBounds(0, 0, 560, 302);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTecnicoActionPerformed
        String nombre = textNombreTecnico.getText();
        String cedula = textCedulaTecnico.getText();
        String mail = textMailTecnico.getText();

        if (!cedula.isEmpty() && !nombre.isEmpty()
                && !mail.isEmpty()) {

            if (sistema.validarCedulaTecnico(cedula)) {

                if (sistema.validarMail(mail)) {

                    sistema.crearTecnico(nombre.toLowerCase(), cedula, mail.toLowerCase());
                    JOptionPane.showMessageDialog(null, "Alta de tecnico realizada con exito","", JOptionPane.INFORMATION_MESSAGE);
                    objetoAPantalla();
                } else {
                    JOptionPane.showMessageDialog(null, "Ya existe un usuario con ese mail","", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Cedula no valida, verifique que la cedula sea correcta y contenga 8 digitos y un guion","", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar completos y con datos validos","", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarTecnicoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Prueba.cargarMenu(sistema);
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarTecnico;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblMail;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTecnicosIngresados;
    private javax.swing.JList listaTecnicosIngresados;
    private javax.swing.JTextField textCedulaTecnico;
    private javax.swing.JTextField textMailTecnico;
    private javax.swing.JTextField textNombreTecnico;
    // End of variables declaration//GEN-END:variables
}
