/* Nombre de la clase                : CBuscaRegiones
 * Descripción de la clase        : Clase para la consulta de regiones
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
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * Interfaz gráfica de usuario para consultar una region
 * @author Techno Engineers
 * @version 1.0
 */
public class CBuscaRegiones extends javax.swing.JFrame {
    ArrayList<CCuadrosRegiones> lALCuadrosRegiones = new ArrayList<>();
    int lEidRegiones;
    String lSCadenaFoto;
    private CPanelFondo fondo;

    /**
     * Creates new form VtnA
     */
    public CBuscaRegiones() {
        initComponents();
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        fondo = new CPanelFondo("Busqueda de Regiones ...", "../imagenes/ballet.png", 0, 0, 420, 380);
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
        objCBLimpiar = new javax.swing.JButton();
        objCBRegiones = new javax.swing.JComboBox<String>();
        jLabel3 = new javax.swing.JLabel();
        objTFNombre = new javax.swing.JTextField();
        objLFoto = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        objCBEstatus = new javax.swing.JComboBox<String>();

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
        jLabel2.setText("Selecciona la Región:");

        objCBLimpiar.setBackground(new java.awt.Color(255, 255, 255));
        objCBLimpiar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objCBLimpiar.setText("Limpiar");
        objCBLimpiar.setMaximumSize(new java.awt.Dimension(150, 25));
        objCBLimpiar.setMinimumSize(new java.awt.Dimension(150, 25));
        objCBLimpiar.setPreferredSize(new java.awt.Dimension(150, 25));
        objCBLimpiar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                objCBLimpiarActionPerformed(evt);
            }
        });
        objCBLimpiar.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objCBLimpiarKeyPressed(evt);
            }
        });

        objCBRegiones.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objCBRegiones.setEnabled(false);
        objCBRegiones.setMaximumSize(new java.awt.Dimension(150, 25));
        objCBRegiones.setMinimumSize(new java.awt.Dimension(150, 25));
        objCBRegiones.setPreferredSize(new java.awt.Dimension(150, 25));
        objCBRegiones.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objCBRegionesKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Nombre de la Región:");

        objTFNombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objTFNombre.setEnabled(false);
        objTFNombre.setMaximumSize(new java.awt.Dimension(150, 25));
        objTFNombre.setMinimumSize(new java.awt.Dimension(150, 25));
        objTFNombre.setPreferredSize(new java.awt.Dimension(150, 25));

        objLFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        objLFoto.setText("Foto");
        objLFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Estatus de la Región:");

        objCBEstatus.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objCBEstatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "No Activo", "Activo" }));
        objCBEstatus.setEnabled(false);
        objCBEstatus.setMaximumSize(new java.awt.Dimension(150, 25));
        objCBEstatus.setMinimumSize(new java.awt.Dimension(150, 25));
        objCBEstatus.setPreferredSize(new java.awt.Dimension(150, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(30, 30, 30)
                        .addComponent(objCBEstatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(objCBCuadro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(objCBRegiones, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(objTFNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(67, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(objLFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(objCBLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(objCBCuadro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(objCBRegiones, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(objTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(objLFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(objCBEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addComponent(objCBLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
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
                    CCuadrosRegiones objCCuadrosRegiones1 = new CCuadrosRegiones(lALCargaCuadros.get(i), null);
                    lALCuadrosRegiones.add(objCCuadrosRegiones1);
                } else {

                    CCuadrosRegiones objCCuadrosRegiones2 = new CCuadrosRegiones(lALCargaCuadros.get(i), lALCargaRegiones);
                    lALCuadrosRegiones.add(objCCuadrosRegiones2);
                }
            }
        }
        metpbSelecciona(lALCuadrosRegiones, 0, true);
    }//GEN-LAST:event_formWindowOpened

    private void objCBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objCBLimpiarActionPerformed
        // TODO add your handling code here:
        CManipulaInterfaz.cmetpbLimpia(objTFNombre);
        objLFoto.setIcon(null);
        CManipulaInterfaz.cmetpbHabilita(false, objTFNombre, objCBRegiones, objCBEstatus);
        objCBCuadro.setSelectedIndex(0);
        objCBCuadro.requestFocus();
    }//GEN-LAST:event_objCBLimpiarActionPerformed

    private void objCBRegionesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objCBRegionesKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == '\n') {
            Connection lCNConexion = CManipulaDB.cmetpbConectaDB();
            CQuerys objCQuerys2 = new CQuerys();
            String lSNombreRegion = objCBRegiones.getSelectedItem().toString().substring(1);
            ArrayList<Object> lALDatosRegion = objCQuerys2.metpbALSeleccion(lCNConexion,
                    "*", "regiones", "nombre = '" + lSNombreRegion + "'");
            String lSidRegion = lALDatosRegion.get(0).toString().replace(" ", "");
            lEidRegiones = Integer.parseInt(lSidRegion);
            objTFNombre.setText(lALDatosRegion.get(1).toString());
            lSCadenaFoto = lALDatosRegion.get(2).toString().replace(" ", "");
            File objFile1 = new File(lSCadenaFoto);
            //System.out.println("arch=" + objFile1.toString());
            ImageIcon objImageIcon1 = new ImageIcon(objFile1.toString());
            Icon lIicono = new ImageIcon(
                    objImageIcon1.getImage().getScaledInstance(
                            objLFoto.getWidth(),
                            objLFoto.getHeight(),
                            Image.SCALE_DEFAULT));
            objLFoto.setIcon(lIicono);
            objCBEstatus.setSelectedIndex(Integer.parseInt(lALDatosRegion.get(3).toString().replace(" ", "")));
            CManipulaInterfaz.cmetpbHabilita(true, objCBLimpiar);
            CManipulaInterfaz.cmetpbCambiaCuadro(objCBLimpiar);
            //System.out.println("id region="+idreg+"#");
        }
    }//GEN-LAST:event_objCBRegionesKeyPressed

    private void objCBLimpiarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objCBLimpiarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == '\n') {
            CManipulaInterfaz.cmetpbLimpia(objTFNombre);
            objLFoto.setIcon(null);
            CManipulaInterfaz.cmetpbHabilita(false, objTFNombre, objCBRegiones, objCBEstatus);
            objCBCuadro.setSelectedIndex(0);
            objCBCuadro.requestFocus();
        }
    }//GEN-LAST:event_objCBLimpiarKeyPressed

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
    private javax.swing.JComboBox<String> objCBCuadro;
    private javax.swing.JComboBox<String> objCBEstatus;
    private javax.swing.JButton objCBLimpiar;
    private javax.swing.JComboBox<String> objCBRegiones;
    private javax.swing.JLabel objLFoto;
    private javax.swing.JTextField objTFNombre;
    // End of variables declaration//GEN-END:variables
}
