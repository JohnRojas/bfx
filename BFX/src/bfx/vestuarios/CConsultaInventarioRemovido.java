/* Nombre de la clase                : CConsultaInventarioDesechado
 * Descripción de la clase           : Clase que permite mostrar el inventario desechado a partir del id Inventario
 * Fecha de creación                 : 21/Junio/2016 
 * Elaboró                           : Rojas Simón Jonathan 
 * Fecha de Liberación               : - 
 * Autorizó                          : - 
 * Fecha Mantenimiento               : 23/Mayo/2016 
 * Folio mantenimiento               : 02 
 * Descripción del mantenimiento     : Estantarización de sentencias  
 * Responsable                       : Rojas Simón Jonathan 
 * Revisor                           : Mauro Sánchez Sánchez
 */
package bfx.vestuarios;

import bfx.clases.CInventarioDesechado;
import bfx.controladores.CManipulaDB;
import bfx.controladores.CPanelFondo;
import bfx.controladores.CQuerys;
import java.awt.Image;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 * Interfaz gráfica de usuario para consultar inventarios desechados
 *
 * @author Techno Engineers
 * @version 1.0
 */
public class CConsultaInventarioRemovido extends javax.swing.JFrame
{

    ArrayList<CInventarioDesechado> objArrayListCInventarioRemovidos = new ArrayList<>();
    CQuerys objCQuerys = new CQuerys();
    ImageIcon objImageIcon1 = new ImageIcon(getClass().getResource("../imagenes/ico.png"));
    Image objImage1 = objImageIcon1.getImage();

    /***
     * Contructor por defecto donde se inicalizan los componentes, posición del JFrame y agregación
     * del fondo en el panel.
     */ 
    public CConsultaInventarioRemovido()
    {
        initComponents();
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        CPanelFondo objCPanelFondo = new CPanelFondo("Consulta de inventario eliminados", "../imagenes/ballet.png", 0, 0, 790, 380);
        this.add(objCPanelFondo);
        this.pack();
        this.setSize(790, 380);
        this.setIconImage(objImage1);

        String lSCampos = "inventariodesechado.idinventario "
                + ", inventariodesechado.tipo "
                + ", inventariodesechado.motivo "
                + ", usuarios.nombre "
                + ", usuarios.apellidopaterno "
                + ", usuarios.apellidomaterno "
                + ", count(*) AS cantidad_desechos "
                + ", vestuarios.descripcion";
        String lSTablas = "inventariodesechado , usuarios , inventarios , vestuarios";
        String lSCondiciones = "inventarios.idinventario = "+CMenuInventarios.pbSIdInventario+" and usuarios.idusuario = inventariodesechado.idusuario and "
                + " inventariodesechado.idinventario = inventarios.idinventario and vestuarios.idvestuario = inventarios.idvestuario "
                + " GROUP  BY usuarios.nombre , "
                + "usuarios.apellidopaterno , "
                + "usuarios.apellidomaterno , "
                + "inventariodesechado.motivo , "
                + "inventariodesechado.tipo "
                + "ORDER  BY cantidad_desechos DESC";

        Connection objConnection = CManipulaDB.cmetpbConectaDB();
        objArrayListCInventarioRemovidos = CManipulaDB.cmetpbALCargaInventarioDesechadoDescripcion(objCQuerys.metpbALSeleccion(objConnection, lSCampos, lSTablas, lSCondiciones));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        objTinventariodesechado = new javax.swing.JTable();
        objBregresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de inventario desechado");
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowOpened(java.awt.event.WindowEvent evt)
            {
                formWindowOpened(evt);
            }
        });

        objTinventariodesechado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Id", "Nombre", "A Paterno", "A Materno", "Cantidad", "Descripción", "Tipo", "Motivo"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        objTinventariodesechado.setToolTipText("");
        objTinventariodesechado.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(objTinventariodesechado);

        objBregresar.setBackground(new java.awt.Color(255, 255, 255));
        objBregresar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objBregresar.setText("Regresar");
        objBregresar.setMaximumSize(new java.awt.Dimension(150, 25));
        objBregresar.setMinimumSize(new java.awt.Dimension(150, 25));
        objBregresar.setPreferredSize(new java.awt.Dimension(150, 25));
        objBregresar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                objBregresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(objBregresar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(objBregresar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * formWindowOpened método que se ejecuta al abrir el JFrame realiza la consulta de los inventarios removidos 
     * ya registrados en la BD. Recibe como parámetro:
     * 
     * @param evt : indica un evento
     */
    private void formWindowOpened(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowOpened
    {//GEN-HEADEREND:event_formWindowOpened
        DefaultTableModel objDefaultTableModel = (DefaultTableModel) objTinventariodesechado.getModel();
        Object[] objObject = new Object[objDefaultTableModel.getColumnCount()];
        try
        {
            for (int lEI = 0; lEI < objArrayListCInventarioRemovidos.size(); lEI++)
            {

                objObject[0] = objArrayListCInventarioRemovidos.get(lEI).getPvEIdInventarioDesechado();
                objObject[1] = objArrayListCInventarioRemovidos.get(lEI).getPvSNombre();
                objObject[2] = objArrayListCInventarioRemovidos.get(lEI).getPvSApellidoPaterno();
                objObject[3] = objArrayListCInventarioRemovidos.get(lEI).getPvSApellidoMaterno();
                objObject[4] = objArrayListCInventarioRemovidos.get(lEI).getPvEPiezas();
                objObject[5] = objArrayListCInventarioRemovidos.get(lEI).getPvSDescripcion();
                objObject[6] = objArrayListCInventarioRemovidos.get(lEI).getPvSTipo();
                objObject[7] = objArrayListCInventarioRemovidos.get(lEI).getPvSMotivo();

                objDefaultTableModel.addRow(objObject);

            }
            objTinventariodesechado.setModel(objDefaultTableModel);
            objTinventariodesechado.getColumnModel().getColumn(0).setMaxWidth(0);
            objTinventariodesechado.getColumnModel().getColumn(0).setMinWidth(0);
            objTinventariodesechado.getColumnModel().getColumn(0).setPreferredWidth(0);
            objTinventariodesechado.getColumnModel().getColumn(4).setMaxWidth(0);
            objTinventariodesechado.getColumnModel().getColumn(4).setMinWidth(0);
            objTinventariodesechado.getColumnModel().getColumn(4).setPreferredWidth(0);
        } catch (Exception lEXe)
        {
            System.out.println("error"+ lEXe.getMessage());
        }


    }//GEN-LAST:event_formWindowOpened

    /**
     * objBregresarActionPerformed Metodo para cerrar la ventana
     *
     * @param evt
     */
    private void objBregresarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_objBregresarActionPerformed
    {//GEN-HEADEREND:event_objBregresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_objBregresarActionPerformed

    /**
     * main() método principal donde se empezará a inicar los métodos del JFrame.
     * El parámetro que recibe es:
     * 
     * @param args : indica argumentos
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(CConsultaInventarioRemovido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(CConsultaInventarioRemovido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(CConsultaInventarioRemovido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(CConsultaInventarioRemovido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                CConsultaInventarioRemovido objCConsultaInventarioDesechado = new CConsultaInventarioRemovido();
                objCConsultaInventarioDesechado.setVisible(true);
                ImageIcon objImageIcon = new ImageIcon(getClass().getResource("../imagenes/ico.png"));
                Image objImage = objImageIcon.getImage();
                objCConsultaInventarioDesechado.setIconImage(objImage);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton objBregresar;
    private javax.swing.JTable objTinventariodesechado;
    // End of variables declaration//GEN-END:variables
}
