/* Nombre de la clase                : CConsultaRentasParametros 
 * Descripción de la clase        : Clase donde almacena los  bailes que que ocupan en el ballet
 * Fecha de creación                 : 15/04/2016 
 * Elaboró                                     : Rogelio Bernal / Carlos Trujilo 
 * Fecha de Liberación              : - 
 * Autorizó  : -
 * Fecha Mantenimiento           : 
 * Folio mantenimiento             : 
 * Descripción del mantto       :
 * Responsable                          :  
 * Revisor                                    : 
 */
package bfx.rentas;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import bfx.controladores.*;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Interfaz gráfica de rentas parametros para consultar Rentas Parametros
 * @author Techno Engineers
 * @version 1.0
 */
public class CConsultaRentasParametros extends javax.swing.JFrame {
    
    static CConsultaRentasParametros objPantallaConsultaRenta1 = new CConsultaRentasParametros();
    private ArrayList <CRentasParametros> lALc= new ArrayList<CRentasParametros>();
    ImageIcon objImageIcon = new ImageIcon(getClass().getResource("../imagenes/ico.png"));
    Image objImage = objImageIcon.getImage();
    /**
     * Creates new form CConsultaRentasParametros
     */
    public CConsultaRentasParametros() {
        initComponents();   
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

        objLconsultaRentas = new javax.swing.JLabel();
        pvJSConsultaRentas1 = new javax.swing.JScrollPane();
        objTconsultaRentas = new javax.swing.JTable();
        objBaceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(66, 112, 158));
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowOpened(java.awt.event.WindowEvent evt)
            {
                formWindowOpened(evt);
            }
        });

        objLconsultaRentas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objLconsultaRentas.setText("Consulta rentas");

        objTconsultaRentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {},
                {},
                {},
                {}
            },
            new String []
            {

            }
        ));
        pvJSConsultaRentas1.setViewportView(objTconsultaRentas);

        objBaceptar.setBackground(new java.awt.Color(255, 255, 255));
        objBaceptar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objBaceptar.setText("Aceptar");
        objBaceptar.setMaximumSize(new java.awt.Dimension(150, 25));
        objBaceptar.setMinimumSize(new java.awt.Dimension(150, 25));
        objBaceptar.setPreferredSize(new java.awt.Dimension(150, 25));
        objBaceptar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                objBaceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(pvJSConsultaRentas1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(objBaceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(objLconsultaRentas)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(objLconsultaRentas)
                .addGap(18, 18, 18)
                .addComponent(pvJSConsultaRentas1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(objBaceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        DefaultTableModel objDTModelo = new DefaultTableModel();
        objDTModelo.addColumn("Id");
        objDTModelo.addColumn("Renta Ant");
        objDTModelo.addColumn("Fecha Ant");
        objDTModelo.addColumn("Renta Act");
        objDTModelo.addColumn("Fecha Act");
        objTconsultaRentas.setModel(objDTModelo);//las agregamos a la tabla
        
        Connection lCNConexion =CManipulaDB.cmetpbConectaDB();
        lALc = CManipulaDB.cmetpbALCargaRentas(CManipulaDB.cmetpbALConsult(lCNConexion, "rentasparametros", "*",""));
        if (!lALc.isEmpty()) 
        {
             for (int i = 0; i < lALc.size(); i++)
                {
                    //variables a ocupar
                    Object[] lAODatos = new Object[5];
                    lAODatos[0] = lALc.get(i).getPpvERentaParametro();
                    lAODatos[1] = lALc.get(i).getPpvSRentaAnterior().trim();
                    lAODatos[2] = lALc.get(i).getPpvSFechaRentaAnterior().trim();
                    lAODatos[3] = lALc.get(i).getPpvSRentaActual().trim();
                    lAODatos[4] = lALc.get(i).getPpvSFechaRentaActual().trim();
                    objDTModelo.addRow(lAODatos);
                    
                }
                objTconsultaRentas.setModel(objDTModelo);
                objTconsultaRentas.setEnabled(false);
                
        } else {
            CMensajes.cmetpbFalla(this,"No hay datos en la busqueda");
        }
        CManipulaDB.cmetpbDesconectaDB(lCNConexion);
    }//GEN-LAST:event_formWindowOpened

    private void objBaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objBaceptarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_objBaceptarActionPerformed

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
            java.util.logging.Logger.getLogger(CConsultaRentasParametros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CConsultaRentasParametros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CConsultaRentasParametros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CConsultaRentasParametros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                objPantallaConsultaRenta1.setTitle("Consulta Rentas");
                objPantallaConsultaRenta1.setVisible(true);
                objPantallaConsultaRenta1.setLocationRelativeTo(null);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton objBaceptar;
    private javax.swing.JLabel objLconsultaRentas;
    private javax.swing.JTable objTconsultaRentas;
    private javax.swing.JScrollPane pvJSConsultaRentas1;
    // End of variables declaration//GEN-END:variables
}
