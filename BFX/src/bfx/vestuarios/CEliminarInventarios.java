/*Nombre de clase		: CEliminarInventarios
*Descripción de la clase	: Es la clase donde se elimina el último registro del inventario de cada vestuario. 
*Fecha	de creación		: 10/05/2016
*Elaboro			: Oscar De Paz Feliciano
*Fecha	de Liberación		: 18/05/2016
*Autorizó			: Mauro Sánchez Sánchez
*Fecha Mantenimiento		: 19/06/2016
*Folio mantenimiento		: 02
*Descripción del mantto.	: Se realizó mótivo de la eliminación, pruebas y transformacion de código con calidad.
*Responsable			: Oscar De Paz Feliciano
*Revisor 			: Mauro Sánchez Sánchez
 */
package bfx.vestuarios;

/**
 * Interfaz que elimina el último registro de cada vestuario
 *
 * @author: Techno Engineers
 * @version 2.0
 */
import bfx.controladores.CManipulaInterfaz;
import bfx.controladores.CMensajes;
import bfx.controladores.CPanelFondo;
import bfx.controladores.CQuerys;
import bfx.controladores.CValidaciones;
import bfx.clases.CInventarios;
import bfx.clases.CVestuarios;
import bfx.controladores.CManipulaDB;
import java.awt.Image;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class CEliminarInventarios extends javax.swing.JFrame
{

    private CPanelFondo objPanelFondo;
    public static String pbSId;
    JFrame objFrame = new JFrame();
    private ArrayList<CVestuarios> objALVestuarios = new ArrayList<CVestuarios>();
    private ArrayList<CInventarios> objALInventarios = new ArrayList<CInventarios>();
    ImageIcon objImageIcon = new ImageIcon(getClass().getResource("../imagenes/ico.png"));
    Image objImage = objImageIcon.getImage();
    
     /***
     * Contructor por defecto donde se inicalizan los componentes, posición del JFrame y agregación
     * del fondo en el panel.
     */
    public CEliminarInventarios()
    {
        initComponents();
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        objPanelFondo = new CPanelFondo("Elimina inventarios", "../imagenes/ballet.png", 0, 0, 420, 380);
        this.add(objPanelFondo);
        this.setIconImage(objImage);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        objLdescripcion = new javax.swing.JLabel();
        objLtipo = new javax.swing.JLabel();
        objTFdescripcionVestuarios = new javax.swing.JTextField();
        objCBtipoVestuarios = new javax.swing.JComboBox<String>();
        objCBsexoVestuarios = new javax.swing.JComboBox<String>();
        objTFcolorVestuarios = new javax.swing.JTextField();
        objLsexo = new javax.swing.JLabel();
        objLcolor = new javax.swing.JLabel();
        objBeliminarInventarios = new javax.swing.JButton();
        objBcancelarVestuarios = new javax.swing.JButton();
        objLcantidad = new javax.swing.JLabel();
        objLclave = new javax.swing.JLabel();
        objTFcantidadInventarios = new javax.swing.JTextField();
        objTFclaveInventarios = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Eliminar Inventario");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowOpened(java.awt.event.WindowEvent evt)
            {
                formWindowOpened(evt);
            }
        });

        objLdescripcion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objLdescripcion.setText("Descripción: ");
        objLdescripcion.setPreferredSize(new java.awt.Dimension(91, 25));

        objLtipo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objLtipo.setText("Tipo:");
        objLtipo.setPreferredSize(new java.awt.Dimension(91, 25));

        objTFdescripcionVestuarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objTFdescripcionVestuarios.setMaximumSize(new java.awt.Dimension(150, 25));
        objTFdescripcionVestuarios.setMinimumSize(new java.awt.Dimension(150, 25));
        objTFdescripcionVestuarios.setPreferredSize(new java.awt.Dimension(150, 25));
        objTFdescripcionVestuarios.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFdescripcionVestuariosKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFdescripcionVestuariosKeyTyped(evt);
            }
        });

        objCBtipoVestuarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objCBtipoVestuarios.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Prenda", "Accesorio" }));
        objCBtipoVestuarios.setEnabled(false);
        objCBtipoVestuarios.setPreferredSize(new java.awt.Dimension(91, 25));

        objCBsexoVestuarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objCBsexoVestuarios.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hombre", "Mujer" }));
        objCBsexoVestuarios.setEnabled(false);
        objCBsexoVestuarios.setPreferredSize(new java.awt.Dimension(91, 25));

        objTFcolorVestuarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objTFcolorVestuarios.setEnabled(false);
        objTFcolorVestuarios.setMaximumSize(new java.awt.Dimension(150, 25));
        objTFcolorVestuarios.setMinimumSize(new java.awt.Dimension(150, 25));
        objTFcolorVestuarios.setPreferredSize(new java.awt.Dimension(150, 25));

        objLsexo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objLsexo.setText("Sexo:");
        objLsexo.setPreferredSize(new java.awt.Dimension(91, 25));

        objLcolor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objLcolor.setText("Color:");
        objLcolor.setPreferredSize(new java.awt.Dimension(91, 25));

        objBeliminarInventarios.setBackground(new java.awt.Color(255, 255, 255));
        objBeliminarInventarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objBeliminarInventarios.setText("Eliminar");
        objBeliminarInventarios.setEnabled(false);
        objBeliminarInventarios.setMaximumSize(new java.awt.Dimension(150, 25));
        objBeliminarInventarios.setMinimumSize(new java.awt.Dimension(150, 25));
        objBeliminarInventarios.setPreferredSize(new java.awt.Dimension(150, 25));
        objBeliminarInventarios.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                objBeliminarInventariosActionPerformed(evt);
            }
        });
        objBeliminarInventarios.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objBeliminarInventariosKeyPressed(evt);
            }
        });

        objBcancelarVestuarios.setBackground(new java.awt.Color(255, 255, 255));
        objBcancelarVestuarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objBcancelarVestuarios.setText("Cancelar");
        objBcancelarVestuarios.setMaximumSize(new java.awt.Dimension(150, 25));
        objBcancelarVestuarios.setMinimumSize(new java.awt.Dimension(150, 25));
        objBcancelarVestuarios.setPreferredSize(new java.awt.Dimension(150, 25));
        objBcancelarVestuarios.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                objBcancelarVestuariosActionPerformed(evt);
            }
        });
        objBcancelarVestuarios.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objBcancelarVestuariosKeyPressed(evt);
            }
        });

        objLcantidad.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objLcantidad.setText("Cantidad:");
        objLcantidad.setPreferredSize(new java.awt.Dimension(91, 25));

        objLclave.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objLclave.setText("Clave:");
        objLclave.setPreferredSize(new java.awt.Dimension(91, 25));

        objTFcantidadInventarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objTFcantidadInventarios.setEnabled(false);
        objTFcantidadInventarios.setMaximumSize(new java.awt.Dimension(150, 25));
        objTFcantidadInventarios.setMinimumSize(new java.awt.Dimension(150, 25));
        objTFcantidadInventarios.setPreferredSize(new java.awt.Dimension(150, 25));

        objTFclaveInventarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objTFclaveInventarios.setEnabled(false);
        objTFclaveInventarios.setMaximumSize(new java.awt.Dimension(150, 25));
        objTFclaveInventarios.setMinimumSize(new java.awt.Dimension(150, 25));
        objTFclaveInventarios.setPreferredSize(new java.awt.Dimension(150, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(objLsexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(objLtipo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(objLdescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(objLcolor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(objLclave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objLcantidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(objTFcolorVestuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(objCBsexoVestuarios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(objTFdescripcionVestuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(objCBtipoVestuarios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(objTFcantidadInventarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(objTFclaveInventarios, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(objBeliminarInventarios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(objBcancelarVestuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(objLdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objTFdescripcionVestuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(objCBtipoVestuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objLtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(objCBsexoVestuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(objLsexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(objTFcolorVestuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objLcolor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(objTFcantidadInventarios, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objLcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(objTFclaveInventarios, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objLclave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(objBeliminarInventarios, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objBcancelarVestuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * descripcionVestuariosKeyPressed método habilita botón eliminar y cambia boton eliminar dentro del JFrame. 
     * Recibe el parámetro:
     * @param evt : indica un evento
     */
    private void objTFdescripcionVestuariosKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_objTFdescripcionVestuariosKeyPressed
    {//GEN-HEADEREND:event_objTFdescripcionVestuariosKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            CManipulaInterfaz.cmetpbHabilita(true, objBeliminarInventarios);
            CManipulaInterfaz.cmetpbCambia(objBeliminarInventarios);
        }
    }//GEN-LAST:event_objTFdescripcionVestuariosKeyPressed
    /**
     * descripcionVestuariosKeyTyped método que valida que en la caja de texto descripción se
     * ingrese solo letras y números, su longitud maxima es de 249. El parámetro que recibe es:
     * 
     * @param evt : indica una posible  evento
     */
    private void objTFdescripcionVestuariosKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_objTFdescripcionVestuariosKeyTyped
    {//GEN-HEADEREND:event_objTFdescripcionVestuariosKeyTyped
        CValidaciones.cmetpbAlfabetico(evt);
        if (objTFdescripcionVestuarios.getText().length() == 249)
        {
            evt.consume();
        }
    }//GEN-LAST:event_objTFdescripcionVestuariosKeyTyped
    /**
     * eliminarInventariosActionPerformed método que elimina un registro de inventarios.
     * El parámetro que recibe es:
     * @param evt : indica una posible acción de un evento
     */
    private void objBeliminarInventariosActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_objBeliminarInventariosActionPerformed
    {//GEN-HEADEREND:event_objBeliminarInventariosActionPerformed
        int lEConfig = CMensajes.cmetpbEPregunta("¿Desea eliminar el registro \"" + objTFclaveInventarios.getText() + "\"?", "Pregunta", this);
        if (lEConfig == 0)
        {
            Connection lCNcon = CManipulaDB.cmetpbConectaDB();
            CQuerys objSql = new CQuerys();
            String lSS;
            lSS = objSql.metpbSDelete(lCNcon, "inventarios", "idinventario", "" + CMenuInventarios.pbSIdInventario + "");
            CManipulaDB.cmetpbDesconectaDB(lCNcon);
            if (lSS == null)
            {
                CMensajes.cmetpbMsj("El dato se ha eliminado", "Información", 3, this);
            } else
            {
                CMensajes.cmetpbMsj("El dato no se ha eliminado", "Error", 1, this);
            }
        }
        objBcancelarVestuariosActionPerformed(evt);
    }//GEN-LAST:event_objBeliminarInventariosActionPerformed
     /**
     * eliminarInventariosKeyPressed método que  al presionar la tecla enter realiza la función del método
     * eliminarInventariosActionPerformed. Recibe el parámetro:
     * 
     * @param evt : indica un evento
     */
    private void objBeliminarInventariosKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_objBeliminarInventariosKeyPressed
    {//GEN-HEADEREND:event_objBeliminarInventariosKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            objBeliminarInventariosActionPerformed(null);
        }
    }//GEN-LAST:event_objBeliminarInventariosKeyPressed
    /**
     * cancelarVestuariosActionPerformed método que oculta la
     * actual. El parámetro que recibe:
     * 
     * @param evt : indica un evento
     */
    private void objBcancelarVestuariosActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_objBcancelarVestuariosActionPerformed
    {//GEN-HEADEREND:event_objBcancelarVestuariosActionPerformed
        //new CMenuInventarios().setVisible(true);
        dispose();
    }//GEN-LAST:event_objBcancelarVestuariosActionPerformed
     /**
     * cancelarVestuariosKeyPressed método que  al presionar la tecla enter realiza la función del método
     * cancelarVestuariosActionPerformed. Recibe el parámetro:
     * 
     * @param evt : indica un evento
     */
    private void objBcancelarVestuariosKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_objBcancelarVestuariosKeyPressed
    {//GEN-HEADEREND:event_objBcancelarVestuariosKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            objBcancelarVestuariosActionPerformed(null);
        }
    }//GEN-LAST:event_objBcancelarVestuariosKeyPressed
    /**
     * formWindowOpened método que se ejecuta al abrir el JFrame realiza la consulta de los vestuarios con
     * su respectivo inventario ya registrados en la BD. Recibe como parámetro:
     * 
     * @param evt : indica un evento
     */
    private void formWindowOpened(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowOpened
    {//GEN-HEADEREND:event_formWindowOpened
        Connection lCNcon = CManipulaDB.cmetpbConectaDB();
        objALVestuarios = CManipulaDB.cmetpbALCargaVestuarios(CManipulaDB.cmetpbArrayListConsulta(lCNcon, "vestuarios", "idvestuario", "" + CAltaVestuarios.pbSId + ""));
        try
        {
            this.metpvCargarVestuarios(objALVestuarios);
            objALInventarios = CManipulaDB.cmetpbALCargaInventarios(CManipulaDB.cmetpbArrayListConsulta(lCNcon, "inventarios", "idinventario", "" + CMenuInventarios.pbSIdInventario + ""));
            this.metpvCargarInventarios(objALInventarios);
            CManipulaInterfaz.cmetpbCambia(objTFdescripcionVestuarios);

        } catch (Exception lEXe)
        {
            CMensajes.cmetpbMsj("No hay datos a modificar", "Información", 3, this);
        }
        CManipulaDB.cmetpbDesconectaDB(lCNcon);
    }//GEN-LAST:event_formWindowOpened
    /**
     * metpvCargarVestuarios método que muestra los datos del vestuario en el
     * formulario CEliminarInventario. el parámetro que recibe es:
     *
     * @param objALVestuarios : objeto del vestuario que contiene datos para ser
     * utilizados dentro del método metpvCargarVestuarios
     */
    private void metpvCargarVestuarios(ArrayList<CVestuarios> objALVestuarios)
    {
        for (int lEContador = 0 ; lEContador < objALVestuarios.size() ; lEContador++)
        {
            objTFdescripcionVestuarios.setText(objALVestuarios.get(lEContador).getPvSDescripcion().trim());

            if (objALVestuarios.get(lEContador).getPvCTipo() == 'P')
            {
                objCBtipoVestuarios.setSelectedIndex(0);

            } else
            {
                objCBtipoVestuarios.setSelectedIndex(1);
            }
            if (objALVestuarios.get(lEContador).getPvCSexo() == 'H')
            {
                objCBsexoVestuarios.setSelectedIndex(0);
            } else
            {
                objCBsexoVestuarios.setSelectedIndex(1);
            }
            objTFcolorVestuarios.setText(objALVestuarios.get(lEContador).getPvSColor().trim());
        }
    }

    /**
     * metpvCargarInventarios método que muestra los datos del inventario en el
     * formulario CEliminarInventario. el parámetro que recibe es:
     *
     * @param objArrayListInventarios : objeto del inventario que contiene datos
     * para ser utilizados dentro del método metpvCargarInventarios
     */
    private void metpvCargarInventarios(ArrayList<CInventarios> objArrayListInventarios)
    {
        for (int lEContador = 0 ; lEContador < objArrayListInventarios.size() ; lEContador ++)
        {
            objTFcantidadInventarios.setText(String.valueOf(objArrayListInventarios.get(lEContador).getPvECantidad()));
            objTFclaveInventarios.setText(objArrayListInventarios.get(lEContador).getPvSClaveVestuario().trim());
        }
    }
    
    /**
     * main() método principal donde se empezará a inicar los métodos del JFrame.
     * El parámetro que recibe es:
     * 
     * @param args : indica argumentos
     */
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                CEliminarInventarios objAltaVestuarios = new CEliminarInventarios();
                objAltaVestuarios.setVisible(true);
                ImageIcon ImageIcon = new ImageIcon(getClass().getResource("../../imagenes/ico.png"));
                Image image = ImageIcon.getImage();
                objAltaVestuarios.setIconImage(image);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton objBcancelarVestuarios;
    private javax.swing.JButton objBeliminarInventarios;
    private javax.swing.JComboBox<String> objCBsexoVestuarios;
    private javax.swing.JComboBox<String> objCBtipoVestuarios;
    private javax.swing.JLabel objLcantidad;
    private javax.swing.JLabel objLclave;
    private javax.swing.JLabel objLcolor;
    private javax.swing.JLabel objLdescripcion;
    private javax.swing.JLabel objLsexo;
    private javax.swing.JLabel objLtipo;
    private javax.swing.JTextField objTFcantidadInventarios;
    private javax.swing.JTextField objTFclaveInventarios;
    private javax.swing.JTextField objTFcolorVestuarios;
    private javax.swing.JTextField objTFdescripcionVestuarios;
    // End of variables declaration//GEN-END:variables
}
