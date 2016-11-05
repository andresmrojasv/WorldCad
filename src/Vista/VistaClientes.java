/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author ESTACIONPC
 */
public class VistaClientes extends javax.swing.JFrame {

    /**
     * Creates new form VistaCliente
     */
    public VistaClientes() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPDatosPrincipales = new javax.swing.JPanel();
        jLIdentificacion = new javax.swing.JLabel();
        jLNombre = new javax.swing.JLabel();
        jLCorreo = new javax.swing.JLabel();
        jLDireccion = new javax.swing.JLabel();
        jTIdentificacion = new javax.swing.JTextField();
        jTNombre = new javax.swing.JTextField();
        jTDireccion = new javax.swing.JTextField();
        jTCorreo = new javax.swing.JTextField();
        jPDatosComplementarios = new javax.swing.JPanel();
        jLURL = new javax.swing.JLabel();
        jLTelefono = new javax.swing.JLabel();
        jLCiudad = new javax.swing.JLabel();
        jTURL = new javax.swing.JTextField();
        jTTelefono = new javax.swing.JTextField();
        jCCiudad = new javax.swing.JComboBox<>();
        jBRegistrar = new javax.swing.JButton();
        jBModificar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jBConsultar = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jLDatosPrincipales = new javax.swing.JLabel();
        jLDatosComplementarios = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Cliente");

        jPDatosPrincipales.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLIdentificacion.setText("Identificación: ");

        jLNombre.setText("Nombre: ");

        jLCorreo.setText("Correo: ");

        jLDireccion.setText("Direccion: ");

        javax.swing.GroupLayout jPDatosPrincipalesLayout = new javax.swing.GroupLayout(jPDatosPrincipales);
        jPDatosPrincipales.setLayout(jPDatosPrincipalesLayout);
        jPDatosPrincipalesLayout.setHorizontalGroup(
            jPDatosPrincipalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDatosPrincipalesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPDatosPrincipalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLIdentificacion)
                    .addComponent(jLCorreo)
                    .addComponent(jLDireccion)
                    .addComponent(jLNombre))
                .addGap(18, 18, 18)
                .addGroup(jPDatosPrincipalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTIdentificacion)
                    .addComponent(jTNombre)
                    .addComponent(jTDireccion)
                    .addComponent(jTCorreo))
                .addContainerGap())
        );
        jPDatosPrincipalesLayout.setVerticalGroup(
            jPDatosPrincipalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDatosPrincipalesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPDatosPrincipalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLIdentificacion)
                    .addComponent(jTIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPDatosPrincipalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNombre)
                    .addComponent(jTNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPDatosPrincipalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLDireccion)
                    .addComponent(jTDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPDatosPrincipalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCorreo)
                    .addComponent(jTCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPDatosComplementarios.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLURL.setText("URL:");

        jLTelefono.setText("Telefono: ");

        jLCiudad.setText("Ciudad:");

        jCCiudad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Barranquilla", "Bogotá", "Cali", "Cartagena", "Medellin" }));
        jCCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCCiudadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPDatosComplementariosLayout = new javax.swing.GroupLayout(jPDatosComplementarios);
        jPDatosComplementarios.setLayout(jPDatosComplementariosLayout);
        jPDatosComplementariosLayout.setHorizontalGroup(
            jPDatosComplementariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDatosComplementariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPDatosComplementariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLURL)
                    .addComponent(jLTelefono)
                    .addComponent(jLCiudad))
                .addGap(40, 40, 40)
                .addGroup(jPDatosComplementariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPDatosComplementariosLayout.createSequentialGroup()
                        .addComponent(jTURL)
                        .addContainerGap())
                    .addGroup(jPDatosComplementariosLayout.createSequentialGroup()
                        .addGroup(jPDatosComplementariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPDatosComplementariosLayout.setVerticalGroup(
            jPDatosComplementariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPDatosComplementariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPDatosComplementariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLURL)
                    .addComponent(jTURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPDatosComplementariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTelefono)
                    .addComponent(jTTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPDatosComplementariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCiudad)
                    .addComponent(jCCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBRegistrar.setText("Registrar");

        jBModificar.setText("Modificar");

        jBEliminar.setText("Eliminar");

        jBConsultar.setText("Consultar");

        jBSalir.setText("Salir");

        jLDatosPrincipales.setText("Datos Principales");

        jLDatosComplementarios.setText("Datos Complementarios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPDatosComplementarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPDatosPrincipales, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBRegistrar)
                                .addGap(18, 18, 18)
                                .addComponent(jBModificar)
                                .addGap(18, 18, 18)
                                .addComponent(jBConsultar)
                                .addGap(18, 18, 18)
                                .addComponent(jBEliminar)
                                .addGap(18, 18, 18)
                                .addComponent(jBSalir))
                            .addComponent(jLDatosPrincipales)
                            .addComponent(jLDatosComplementarios))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLDatosPrincipales)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPDatosPrincipales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLDatosComplementarios)
                .addGap(1, 1, 1)
                .addComponent(jPDatosComplementarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBRegistrar)
                    .addComponent(jBSalir)
                    .addComponent(jBEliminar)
                    .addComponent(jBConsultar)
                    .addComponent(jBModificar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCCiudadActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jBConsultar;
    public javax.swing.JButton jBEliminar;
    public javax.swing.JButton jBModificar;
    public javax.swing.JButton jBRegistrar;
    public javax.swing.JButton jBSalir;
    public javax.swing.JComboBox<String> jCCiudad;
    public javax.swing.JLabel jLCiudad;
    public javax.swing.JLabel jLCorreo;
    public javax.swing.JLabel jLDatosComplementarios;
    public javax.swing.JLabel jLDatosPrincipales;
    public javax.swing.JLabel jLDireccion;
    public javax.swing.JLabel jLIdentificacion;
    public javax.swing.JLabel jLNombre;
    public javax.swing.JLabel jLTelefono;
    public javax.swing.JLabel jLURL;
    private javax.swing.JPanel jPDatosComplementarios;
    private javax.swing.JPanel jPDatosPrincipales;
    public javax.swing.JTextField jTCorreo;
    public javax.swing.JTextField jTDireccion;
    public javax.swing.JTextField jTIdentificacion;
    public javax.swing.JTextField jTNombre;
    public javax.swing.JTextField jTTelefono;
    public javax.swing.JTextField jTURL;
    // End of variables declaration//GEN-END:variables
}
