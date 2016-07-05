/* Nombre de la clase                : CAltaRegiones 
 * Descripción de la clase        : Clase donde almacena las regiones que que ocupan en el ballet
 * Fecha de creación                 : 15/04/2016 
 * Elaboró                                     : Nava Ramirez Luis Fernando 
 * Fecha de Liberación              : - 
 * Autorizó  : -
 * Fecha Mantenimiento           : 
 * Folio mantenimiento             : 
 * Descripción del mantto       :
 * Responsable                          :  
 * Revisor                                    : 
 */
package bfx.cuadros;

import bfx.clases.*;
import bfx.controladores.CManipulaDB;
import bfx.controladores.CManipulaInterfaz;
import bfx.controladores.CMensajes;
import bfx.controladores.CPanelFondo;
import bfx.controladores.CQuerys;
import bfx.controladores.CValidaciones;
import java.awt.Event;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Interfaz gráfica de usuario para dar del alta una region
 * @author Techno Engineers
 * @version 1.0
 */
public class CAltaRegiones extends javax.swing.JFrame {

    private ArrayList<CCuadros> objCCuadros1 = new ArrayList<CCuadros>();
    private CPanelFondo fondo;
    String lSCadenaFoto;
    

    /**
     * Creates new form VtnA
     */
    public CAltaRegiones() {
        initComponents();
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        fondo = new CPanelFondo("Alta de Regiones ...", "../imagenes/ballet.png", 0, 0, 420, 380);
        this.add(fondo);
        
        InputMap map1 = objTFNombre.getInputMap(objTFNombre.WHEN_FOCUSED);
        map1.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

    }

    public int metpbValidaCamposVacios() {
        if (objTFNombre.getText().equals("")) {
            CMensajes.cmetpbFalla(this, "El campo de la región no debe estar en blanco");
            objTFNombre.requestFocus();
            return 1;
        }
        return 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        objCBCuadro = new javax.swing.JComboBox<String>();
        jLabel2 = new javax.swing.JLabel();
        objTFNombre = new javax.swing.JTextField();
        objBImagen = new javax.swing.JButton();
        objLFoto = new javax.swing.JLabel();
        objBAceptar = new javax.swing.JButton();
        objBCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Altas de ...");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowOpened(java.awt.event.WindowEvent evt)
            {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Selecciona el Cuadro: ");

        objCBCuadro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objCBCuadro.setMaximumSize(new java.awt.Dimension(150, 25));
        objCBCuadro.setMinimumSize(new java.awt.Dimension(150, 25));
        objCBCuadro.setPreferredSize(new java.awt.Dimension(150, 25));
        objCBCuadro.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objCBCuadroKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Nombre de la Región:");

        objTFNombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objTFNombre.setEnabled(false);
        objTFNombre.setMaximumSize(new java.awt.Dimension(150, 25));
        objTFNombre.setMinimumSize(new java.awt.Dimension(150, 25));
        objTFNombre.setPreferredSize(new java.awt.Dimension(150, 25));
        objTFNombre.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFNombreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFNombreKeyTyped(evt);
            }
        });

        objBImagen.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objBImagen.setText("Cargar Imagen");
        objBImagen.setEnabled(false);
        objBImagen.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                objBImagenActionPerformed(evt);
            }
        });
        objBImagen.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objBImagenKeyPressed(evt);
            }
        });

        objLFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        objLFoto.setText("Foto");
        objLFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        objBAceptar.setBackground(new java.awt.Color(255, 255, 255));
        objBAceptar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objBAceptar.setText("Aceptar");
        objBAceptar.setEnabled(false);
        objBAceptar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                objBAceptarActionPerformed(evt);
            }
        });
        objBAceptar.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objBAceptarKeyPressed(evt);
            }
        });

        objBCancelar.setBackground(new java.awt.Color(255, 255, 255));
        objBCancelar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objBCancelar.setText("Cancelar");
        objBCancelar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                objBCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(objBImagen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(objCBCuadro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(objTFNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(objLFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(objBAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(objBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(objCBCuadro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(objTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(objLFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(objBImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(objBAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void objCBCuadroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objCBCuadroKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == '\n') {
            CManipulaInterfaz.cmetpbHabilita(true, objTFNombre);
            CManipulaInterfaz.cmetpbCambiaCuadro(objTFNombre);
        }
    }//GEN-LAST:event_objCBCuadroKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        Connection lCNConexion = CManipulaDB.cmetpbConectaDB();
        objCCuadros1 = CManipulaDB.cmetpbCargaCuadros(CManipulaDB.cmetpbALConsult(lCNConexion, "cuadros", "*", ""));
        try {
            for (int i = 0; i < objCCuadros1.size(); i++) {
                /*System.out.println("i" + i);
                System.out.println("id " + c.get(i).getPvEidCuadro());*/
                objCBCuadro.addItem(objCCuadros1.get(i).getPvCnombre().trim());
            }
        } catch (Exception e) {
            CMensajes.cmetpbConsulta(this, "No hay datos para mostrar."); //, "Información", 3, this);
        }
        CManipulaDB.cmetpbDesconectaDB(lCNConexion);
    }//GEN-LAST:event_formWindowOpened

    private void objTFNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFNombreKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == '\n') {
            CManipulaInterfaz.cmetpbHabilita(true, objBImagen);
            CManipulaInterfaz.cmetpbCambiaCuadro(objBImagen);
        }
    }//GEN-LAST:event_objTFNombreKeyPressed

    private void objTFNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFNombreKeyTyped
        // TODO add your handling code here:
        CValidaciones.cmetpbAlfabetico(evt);
    }//GEN-LAST:event_objTFNombreKeyTyped

    private void objBImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objBImagenActionPerformed
        // TODO add your handling code here:
        File lFarchivo;
        JFileChooser objFileChooser1 = new JFileChooser();
        objFileChooser1.setFileFilter(
                new FileNameExtensionFilter("jpg y png", "jpg", "png"));
        int lEOpcion = objFileChooser1.showOpenDialog(this);
        if (lEOpcion == JFileChooser.APPROVE_OPTION) {
            lFarchivo = objFileChooser1.getSelectedFile();
            lSCadenaFoto = lFarchivo.toString();
            ImageIcon objImageIcon1 = new ImageIcon(lFarchivo.toString());
            Icon lIicono = new ImageIcon(
                    objImageIcon1.getImage().getScaledInstance(
                            objLFoto.getWidth(),
                            objLFoto.getHeight(),
                            Image.SCALE_DEFAULT));
            objLFoto.setIcon(lIicono);
        }
    }//GEN-LAST:event_objBImagenActionPerformed

    private void objBImagenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objBImagenKeyPressed
        // TODO add your handling code here:
        if (this.objLFoto.getIcon() != null) {
            CManipulaInterfaz.cmetpbHabilita(true, objBAceptar);
            CManipulaInterfaz.cmetpbCambiaCuadro(objBAceptar);
        } else {
            objBImagen.requestFocus();
        }
    }//GEN-LAST:event_objBImagenKeyPressed

    private void objBAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objBAceptarActionPerformed
        // TODO add your handling code here:
        int lEValida = this.metpbValidaCamposVacios();
        if (lEValida == 0) {
            int lEidCuadros = objCCuadros1.get(objCBCuadro.getSelectedIndex()).getPvEidCuadro();
            //System.out.println(idC);
            CRegiones objCRegiones1 = new CRegiones(1, String.valueOf(objTFNombre.getText()),
                    lSCadenaFoto.replace("" + (char) 92 + "", "" + (char) 92 + "" + (char) 92 + ""), 1,
                    lEidCuadros);
            String lSDatos = "null, '"
                    + objCRegiones1.getPvCnombre().trim() + "','"
                    + objCRegiones1.getPvCimagenReferencia() + "',"
                    + objCRegiones1.getPvEestatus() + ","
                    + String.valueOf(objCRegiones1.getPvEidCuadro());

            Connection lCNConexion = CManipulaDB.cmetpbConectaDB();

            CQuerys objCQuerys1 = new CQuerys();
            String lCRegiones = objCQuerys1.metpbSInsertar(lCNConexion, "regiones", lSDatos);
            if (lCRegiones == null) {
                CMensajes.cmetpbExito(this);//, "El dato se ha insertado correctamente.");//, "Notificación", 3, this);
            } else {
                CMensajes.cmetpbFalla(this, "Dato no insertado"); //,"Error",1, this);
            }
            CManipulaDB.cmetpbDesconectaDB(lCNConexion);
            objBCancelarActionPerformed(evt);

        } else {
            objTFNombre.requestFocus();
        }

    }//GEN-LAST:event_objBAceptarActionPerformed

    private void objBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objBCancelarActionPerformed
        // TODO add your handling code here:
        CManipulaInterfaz.cmetpbLimpia(objTFNombre);
        objLFoto.setIcon(null);
        CManipulaInterfaz.cmetpbHabilita(false, objTFNombre, objBImagen, objBAceptar);
        objCBCuadro.setSelectedIndex(0);
        objCBCuadro.requestFocus();
    }//GEN-LAST:event_objBCancelarActionPerformed

    private void objBAceptarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objBAceptarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == '\n') {
            objBAceptarActionPerformed(null);
        }
    }//GEN-LAST:event_objBAceptarKeyPressed
    

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
            java.util.logging.Logger.getLogger(CAltaRegiones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CAltaRegiones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CAltaRegiones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CAltaRegiones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton objBAceptar;
    private javax.swing.JButton objBCancelar;
    private javax.swing.JButton objBImagen;
    private javax.swing.JComboBox<String> objCBCuadro;
    private javax.swing.JLabel objLFoto;
    private javax.swing.JTextField objTFNombre;
    // End of variables declaration//GEN-END:variables
}
