/* Nombre de la clase                : CBuscaBailes 
 * Descripción de la clase        : Clase para la consulta de los bailes
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
import bfx.controladores.CPanelFondo;
import bfx.controladores.CQuerys;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Interfaz gráfica de usuario para consultar un Baile
 * @author Techno Engineers
 * @version 1.0
 */

public class CBuscaBailes extends javax.swing.JFrame {
    ArrayList<CCuadrosRegiones> lALCuadrosRegiones = new ArrayList<>();
    int lEidRegiones, lEidBailes;
    String lSCadenaFoto;
    private CPanelFondo fondo;

    /**
     * Creates new form VtnA
     */
    public CBuscaBailes() {
        initComponents();
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        fondo = new CPanelFondo("Busqueda de Bailes ...", "../imagenes/ballet.png", 0, 0, 420, 380);
        this.add(fondo);

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
        pvJBLimpiar = new javax.swing.JButton();
        objCBRegiones = new javax.swing.JComboBox<String>();
        jLabel3 = new javax.swing.JLabel();
        objTFNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        objCBBaile = new javax.swing.JComboBox<String>();
        objTFDuracion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        objCBEstatus = new javax.swing.JComboBox<String>();
        jLabel6 = new javax.swing.JLabel();

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
        objCBCuadro.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objCBCuadroKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Selecciona la Región:");

        pvJBLimpiar.setBackground(new java.awt.Color(255, 255, 255));
        pvJBLimpiar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        pvJBLimpiar.setText("Limpiar");
        pvJBLimpiar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                pvJBLimpiarActionPerformed(evt);
            }
        });
        pvJBLimpiar.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                pvJBLimpiarKeyPressed(evt);
            }
        });

        objCBRegiones.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objCBRegiones.setEnabled(false);
        objCBRegiones.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objCBRegionesKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Nombre del Baile:");

        objTFNombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objTFNombre.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Selecciona el Baile:");

        objCBBaile.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objCBBaile.setEnabled(false);
        objCBBaile.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objCBBaileKeyPressed(evt);
            }
        });

        objTFDuracion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objTFDuracion.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Duraciòn del Baile: (mm:ss)");

        objCBEstatus.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objCBEstatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Activo", "Activo" }));
        objCBEstatus.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Estatus del Baile:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(42, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(39, 39, 39))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(objTFNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(objCBBaile, 0, 150, Short.MAX_VALUE)
                                    .addComponent(objCBCuadro, 0, 150, Short.MAX_VALUE)
                                    .addComponent(objCBRegiones, 0, 150, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(objCBEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(objTFDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(pvJBLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(objCBCuadro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(objCBRegiones, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(objCBBaile, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(objTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(objTFDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(objCBEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(46, 46, 46)
                .addComponent(pvJBLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void objCBCuadroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objCBCuadroKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == '\n') {
            metpbSelecciona(lALCuadrosRegiones, objCBCuadro.getSelectedIndex(), true);
            //CManipulaInterfaz.cmetpbHabilita(true, regiones);
            //CManipulaInterfaz.cmetpbCambiaCuadro(regiones);
        }
    }//GEN-LAST:event_objCBCuadroKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        Connection lCNConexion = CManipulaDB.cmetpbConectaDB();
        CQuerys objCQuerys1 = new CQuerys();
        ArrayList<CCuadros> lALCargaCuadros = CManipulaDB.cmetpbCargaCuadros(objCQuerys1.metpbALSeleccion(lCNConexion,
                "*", "cuadros", ""));
        if (lALCargaCuadros == null) {
            JOptionPane.showMessageDialog(this, "NO hay datos que consultar");
            objCBCuadro.setEnabled(false);
            objCBRegiones.setEnabled(false);
        } else {
            for (int i = 0; i < lALCargaCuadros.size(); i++) {
                objCBCuadro.addItem(lALCargaCuadros.get(i).getPvCnombre());
                ArrayList<CRegiones> lALCargaRegiones = CManipulaDB.cmetpbCargaRegiones(objCQuerys1.metpbALSeleccion(lCNConexion,
                        "*", "regiones", "idcuadro = " + lALCargaCuadros.get(i).getPvEidCuadro()));
                if (lALCargaRegiones == null) {
                    //JOptionPane.showMessageDialog(this, "NO hay datos que consultar");
                    objCBRegiones.setEnabled(false);
                    CCuadrosRegiones objCuadrosRegiones1 = new CCuadrosRegiones(lALCargaCuadros.get(i), null);
                    lALCuadrosRegiones.add(objCuadrosRegiones1);
                } else {
                    CCuadrosRegiones objCuadrosRegiones2 = new CCuadrosRegiones(lALCargaCuadros.get(i), lALCargaRegiones);
                    lALCuadrosRegiones.add(objCuadrosRegiones2);
                }
            }
        }
        metpbSelecciona(lALCuadrosRegiones, 0, true);
    }//GEN-LAST:event_formWindowOpened

    private void pvJBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pvJBLimpiarActionPerformed
        // TODO add your handling code here:
        CManipulaInterfaz.cmetpbLimpia(objTFNombre, objTFDuracion);
        CManipulaInterfaz.cmetpbHabilita(false, objTFNombre, objCBRegiones, objCBBaile, objTFDuracion, objCBEstatus);
        objCBBaile.removeAllItems();
        objCBCuadro.setSelectedIndex(0);
        objCBCuadro.requestFocus();
    }//GEN-LAST:event_pvJBLimpiarActionPerformed

    private void objCBRegionesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objCBRegionesKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == '\n') {
            Connection lCNConexion = CManipulaDB.cmetpbConectaDB();
            CQuerys objCQuerys2 = new CQuerys();
            String lSNombreRegion = objCBRegiones.getSelectedItem().toString().substring(1);
            ArrayList<Object> lALidRegion = objCQuerys2.metpbALSeleccion(lCNConexion,
                    "idregiones", "regiones", "nombre = '" + lSNombreRegion+ "'");
            String lSidRegion = lALidRegion.get(0).toString().replace(" ", "");
            lEidRegiones = Integer.parseInt(lSidRegion);
            ArrayList<CBailes> lALbailes = CManipulaDB.cmetpbCargaBailes(objCQuerys2.metpbALSeleccion(lCNConexion,
                    "*", "bailes", "idregiones = " + lEidRegiones + " and status = 1"));
            
            if (lALbailes != null) {
                for (int i = 0; i < lALbailes.size(); i++) {
                    objCBBaile.addItem(lALbailes.get(i).getPvCnombreBaile());
                }
                CManipulaInterfaz.cmetpbHabilita(true, objCBBaile);
                CManipulaInterfaz.cmetpbCambiaCuadro(objCBBaile);
                
            } else {
                CManipulaInterfaz.cmetpbHabilita(false, objCBBaile);
                objCBRegiones.requestFocus();
            }
            
            //System.out.println("id region="+idreg+"#");   

        }
    }//GEN-LAST:event_objCBRegionesKeyPressed

    private void objCBBaileKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objCBBaileKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == '\n') {
            Connection lCNConexion = CManipulaDB.cmetpbConectaDB();
            CQuerys objCQuerys3 = new CQuerys();
            String lSNombreBaile = objCBBaile.getSelectedItem().toString().substring(1);
            ArrayList<Object> lALDatosBaile = objCQuerys3.metpbALSeleccion(lCNConexion,
                    "*", "bailes", "nombre = '" + lSNombreBaile + "'");
            String lSidBaile = lALDatosBaile.get(0).toString().replace(" ", "");
            lEidBailes = Integer.parseInt(lSidBaile);
            objTFNombre.setText(lALDatosBaile.get(1).toString().substring(1));
            objTFDuracion.setText(lALDatosBaile.get(2).toString().substring(4));
            objCBEstatus.setSelectedIndex(Integer.parseInt(lALDatosBaile.get(3).toString().replace(" ", "")));
            CManipulaInterfaz.cmetpbHabilita(true, pvJBLimpiar);
            CManipulaInterfaz.cmetpbCambiaCuadro(pvJBLimpiar);
            //System.out.println("id region="+idreg+"#");
        }
    }//GEN-LAST:event_objCBBaileKeyPressed

    private void pvJBLimpiarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pvJBLimpiarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == '\n') {
            CManipulaInterfaz.cmetpbLimpia(objTFNombre, objTFDuracion);
            CManipulaInterfaz.cmetpbHabilita(false, objTFNombre, objCBRegiones, objCBBaile, objTFDuracion, objCBEstatus);
            objCBBaile.removeAllItems();
            objCBCuadro.setSelectedIndex(0);
            objCBCuadro.requestFocus();
        }
    }//GEN-LAST:event_pvJBLimpiarKeyPressed

    public void metpbSelecciona(ArrayList<CCuadrosRegiones> lALCuadroRegiones, int lEidCuadroRegiones, boolean lBbandera) {
        if (lALCuadroRegiones != null) {
            if (lALCuadroRegiones.get(lEidCuadroRegiones).getPvAregiones() != null) {
                objCBRegiones.removeAllItems();
                CManipulaInterfaz.cmetpbCambiaCuadro(objCBRegiones);
                objCBRegiones.setEnabled(true);
                for (int i = 0; i < lALCuadroRegiones.get(lEidCuadroRegiones).getPvAregiones().size(); i++) {
                    objCBRegiones.addItem(lALCuadroRegiones.get(lEidCuadroRegiones).getPvAregiones().get(i).getPvCnombre());
                }
            } else {
                objCBRegiones.removeAllItems();
                objCBCuadro.requestFocus();
                objCBRegiones.setEnabled(false);
            }
        }
    }

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
            java.util.logging.Logger.getLogger(CBuscaBailes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CBuscaBailes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CBuscaBailes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CBuscaBailes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox<String> objCBBaile;
    private javax.swing.JComboBox<String> objCBCuadro;
    private javax.swing.JComboBox<String> objCBEstatus;
    private javax.swing.JComboBox<String> objCBRegiones;
    private javax.swing.JTextField objTFDuracion;
    private javax.swing.JTextField objTFNombre;
    private javax.swing.JButton pvJBLimpiar;
    // End of variables declaration//GEN-END:variables
}
