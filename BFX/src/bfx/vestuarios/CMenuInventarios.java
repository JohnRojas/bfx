/*Nombre de clase		: CMenuInventarios
*Descripción de la clase	: Es la clase muestran todos los inventarios de cada vestuario. 
*Fecha	de creación		: 02/05/2016
*Elaboro			: Oscar De Paz Feliciano y Erick López Hernández.
*Fecha	de Liberación		: 19/06/2016
*Autorizó			: Mauro Sánchez Sánchez
*Fecha Mantenimiento		: 19/06/2016
*Folio mantenimiento		: 02
*Descripción del mantto.	: Se realizó pruebas y transformacion de código con calidad.
*Responsable			: Oscar De Paz Feliciano
*Revisor 			: Mauro Sánchez Sánchez
 */
package bfx.vestuarios;

/**
 * Interfaz para consultar inventarios de cada vestuario
 *
 * @author: Techno Engineers
 * @versión: 2.0
 */
import bfx.controladores.CManipulaInterfaz;
import bfx.controladores.CMensajes;
import bfx.controladores.CPanelFondo;
import bfx.controladores.CQuerys;
import bfx.clases.CInventarios;
import bfx.controladores.CManipulaDB;
import static bfx.controladores.CManipulaDB.cmetpbALConsult;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class CMenuInventarios extends javax.swing.JFrame
{

    private CPanelFondo objCPanelFondo;
    JFrame objFrame = new JFrame();
    DefaultTableModel objDefaultTableModel;
    public static String pbSIdInventario;
    private int pvECantidad = 0;
    public boolean pbBBandera = false;
    private ArrayList<CInventarios> objALInventarios = new ArrayList<CInventarios>();
    private String pvSClaveVestuario = "";
    public static int cpbECantidad = 0;
    public static int cpbEPiezasDaniadas = 0;
    public static int cpbEPiezasAsignadas = 0;
    ImageIcon objImageIcon = new ImageIcon(getClass().getResource("../imagenes/ico.png"));
    Image objImage = objImageIcon.getImage();

     /***
     * Contructor por defecto donde se inicalizan los componentes, posición del JFrame y agregación
     * del fondo en el panel.
     */
    public CMenuInventarios()
    {
        initComponents();
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        objCPanelFondo = new CPanelFondo("Menú inventarios", "../imagenes/ballet.png", 0, 0, 420, 380);
        this.add(objCPanelFondo);
        pbSIdInventario = " ";
        this.setIconImage(objImage);
    }

     /**
     * Método que oculta la columna id inventarios.
     */
    private void metpvOcultarColumnas()
    {
        objTtablaAltaInventarios.getColumnModel().getColumn(0).setMaxWidth(0);
        objTtablaAltaInventarios.getColumnModel().getColumn(0).setMinWidth(0);
        objTtablaAltaInventarios.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jSlider1 = new javax.swing.JSlider();
        jScrollPane1 = new javax.swing.JScrollPane();
        objTtablaAltaInventarios = new javax.swing.JTable();
        objBagregarInventario = new javax.swing.JButton();
        objBmodificar = new javax.swing.JButton();
        objBeliminar = new javax.swing.JButton();
        objBremovido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Altas de Inventarios");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowOpened(java.awt.event.WindowEvent evt)
            {
                formWindowOpened(evt);
            }
        });

        objTtablaAltaInventarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objTtablaAltaInventarios.setModel(new javax.swing.table.DefaultTableModel(
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
        objTtablaAltaInventarios.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                objTtablaAltaInventariosMouseClicked(evt);
            }
        });
        objTtablaAltaInventarios.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTtablaAltaInventariosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(objTtablaAltaInventarios);

        objBagregarInventario.setBackground(new java.awt.Color(255, 255, 255));
        objBagregarInventario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objBagregarInventario.setText("Agregar ");
        objBagregarInventario.setMaximumSize(new java.awt.Dimension(100, 25));
        objBagregarInventario.setMinimumSize(new java.awt.Dimension(100, 25));
        objBagregarInventario.setPreferredSize(new java.awt.Dimension(100, 25));
        objBagregarInventario.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                objBagregarInventarioActionPerformed(evt);
            }
        });

        objBmodificar.setBackground(new java.awt.Color(255, 255, 255));
        objBmodificar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objBmodificar.setText("Modificar");
        objBmodificar.setEnabled(false);
        objBmodificar.setMaximumSize(new java.awt.Dimension(100, 25));
        objBmodificar.setMinimumSize(new java.awt.Dimension(100, 25));
        objBmodificar.setPreferredSize(new java.awt.Dimension(100, 25));
        objBmodificar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                objBmodificarActionPerformed(evt);
            }
        });

        objBeliminar.setBackground(new java.awt.Color(255, 255, 255));
        objBeliminar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objBeliminar.setText("Eliminar");
        objBeliminar.setEnabled(false);
        objBeliminar.setMaximumSize(new java.awt.Dimension(100, 25));
        objBeliminar.setMinimumSize(new java.awt.Dimension(100, 25));
        objBeliminar.setOpaque(false);
        objBeliminar.setPreferredSize(new java.awt.Dimension(100, 25));
        objBeliminar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                objBeliminarActionPerformed(evt);
            }
        });

        objBremovido.setBackground(new java.awt.Color(255, 255, 255));
        objBremovido.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objBremovido.setText("Removido");
        objBremovido.setEnabled(false);
        objBremovido.setMaximumSize(new java.awt.Dimension(100, 25));
        objBremovido.setMinimumSize(new java.awt.Dimension(100, 25));
        objBremovido.setPreferredSize(new java.awt.Dimension(100, 25));
        objBremovido.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                objBremovidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(objBagregarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(objBmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(objBeliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(objBremovido, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(objBagregarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objBmodificar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objBeliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objBremovido, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * formWindowOpened método que se ejecuta al abrir el JFrame realiza la consulta de los inventarios ya
     * registrados en la BD. Recibe como parámetro:
     * 
     * @param evt : indica un evento
     */
    private void formWindowOpened(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowOpened
    {//GEN-HEADEREND:event_formWindowOpened

        String saCampos[] =
        {
            "id", "Cantidad", "Clave de vestuario"
        };

        objDefaultTableModel = new DefaultTableModel(null, saCampos);
        objTtablaAltaInventarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        objTtablaAltaInventarios.setSelectionBackground(Color.gray);

        Connection lCNcon = CManipulaDB.cmetpbConectaDB();
        objALInventarios = CManipulaDB.cmetpbALCargaInventarios(cmetpbALConsult(lCNcon, "inventarios", "inventarios.idvestuario", "" + Integer.parseInt(CAltaVestuarios.pbSId + "")));
        try
        {
            Object[] objObject = new Object[objDefaultTableModel.getColumnCount()];
            for (int lEi = 0 ; lEi < objALInventarios.size() ; lEi++)
            {
                objObject[0] = objALInventarios.get(lEi).getPvEIdInventario();
                objObject[1] = objALInventarios.get(lEi).getPvECantidad();
                objObject[2] = objALInventarios.get(lEi).getPvSClaveVestuario().trim();
                objDefaultTableModel.addRow(objObject);
            }
        } catch (Exception lEXe)
        {
            CMensajes.cmetpbFalla(this, "No hay datos para mostrar.");
        }
        objTtablaAltaInventarios.setModel(objDefaultTableModel);
        this.metpvOcultarColumnas();
        CManipulaDB.cmetpbDesconectaDB(lCNcon);

    }//GEN-LAST:event_formWindowOpened

    /**
     * jAgregarInventarioActionPerformed método que muestra la ventana CAltaInventarios y oculta la
     * actual. El parámetro que recibe:
     * 
     * @param evt : indica un evento
     */
    private void objBagregarInventarioActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_objBagregarInventarioActionPerformed
    {//GEN-HEADEREND:event_objBagregarInventarioActionPerformed
        new CAltaInventarios().setVisible(true);
        dispose();
    }//GEN-LAST:event_objBagregarInventarioActionPerformed
    /**
     * metpbCIClaveVestuario método que busca si existe la clave del inventario.
     * El parámetro que recibe es:
     * 
     * @param  lSClaveVestuario  : clave del vestuario a buscar
     * @return retorna null sino encuentra ninguna clave de vestuario en caso contrario retorna
     * un objeto con la clave existente y otros datos dentro del objeto como id inventario y cantidad. 
     */
    public CInventarios metpbCIClaveVestuario(String lSClaveVestuario)
    {
        CInventarios objCInventario = null;
        Connection lCNcon = CManipulaDB.cmetpbConectaDB();
        CQuerys objQuerys = new CQuerys();
        objALInventarios = CManipulaDB.cmetpbALCargaInventarios(objQuerys.metpbALSeleccion(lCNcon, "*", "inventarios", "clavevestuario='" + lSClaveVestuario + "'"));

        try
        {
            for (int lEContador = 0 ; lEContador < objALInventarios.size() ; lEContador ++)
            {
                objCInventario = new CInventarios();
                objCInventario.setPvEIdInventario(objALInventarios.get(lEContador).getPvEIdInventario());
                objCInventario.setPvECantidad(objALInventarios.get(lEContador).getPvECantidad());
                objCInventario.setPvSClaveVestuario(objALInventarios.get(lEContador).getPvSClaveVestuario().trim());
            }
        } catch (Exception lEXe)
        {
            CMensajes.cmetpbFalla(this, "No hay datos para mostrar.");
        }
        return objCInventario;
    }


    private void objTtablaAltaInventariosKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_objTtablaAltaInventariosKeyPressed
    {//GEN-HEADEREND:event_objTtablaAltaInventariosKeyPressed
    }//GEN-LAST:event_objTtablaAltaInventariosKeyPressed
   
    /**
     * jBModificarActionPerformed método que muestra la ventana CModificarInventarios y oculta la
     * actual. El parámetro que recibe:
     * 
     * @param evt : indica un evento
     */
    private void objBmodificarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_objBmodificarActionPerformed
    {//GEN-HEADEREND:event_objBmodificarActionPerformed
        new CModificarInventarios().setVisible(true);
        dispose();
    }//GEN-LAST:event_objBmodificarActionPerformed
                                     
    /**
     * tablaAltaInventariosMouseClicked método que obtiene el id inventario que se seleciona
     * a partir de una tabla. El parámetro que recibe es:
     * 
     * @param evt : indica un evento
     */
    private void objTtablaAltaInventariosMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_objTtablaAltaInventariosMouseClicked
    {//GEN-HEADEREND:event_objTtablaAltaInventariosMouseClicked
        int lEFila;
        lEFila = objTtablaAltaInventarios.rowAtPoint(evt.getPoint());
        pbSIdInventario = objTtablaAltaInventarios.getModel().getValueAt(lEFila, 0).toString();
        CManipulaInterfaz.cmetpbHabilita(true, objBmodificar);
        CManipulaInterfaz.cmetpbHabilita(true, objBeliminar);
        CManipulaInterfaz.cmetpbHabilita(true, objBremovido);
    }//GEN-LAST:event_objTtablaAltaInventariosMouseClicked
    /**
     * jBEliminarActionPerformed método carga en un objeto los datos de la tabla inventarios, que son cantidad, 
     * piezas dañadas y piezas asignadas. Según el caso pueder ir a las ventanas CEliminarInventarios o CMotivoEliminacion.
     * El parámetro que recibe es:
     * @param evt : indica una posible acción de un evento
     */
    private void objBeliminarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_objBeliminarActionPerformed
    {//GEN-HEADEREND:event_objBeliminarActionPerformed

        Connection lCNcon = CManipulaDB.cmetpbConectaDB();
        CQuerys objQuerys = new CQuerys();
        objALInventarios = CManipulaDB.cmetpbALCargaInventarios(objQuerys.metpbALSeleccion(lCNcon, "*", "inventarios ", "idinventario=" + Integer.parseInt(pbSIdInventario) + ""));

        try
        {
            for (int lEContador = 0 ; lEContador < objALInventarios.size() ; lEContador++)
            {
                cpbECantidad = objALInventarios.get(lEContador).getPvECantidad();
                cpbEPiezasDaniadas = objALInventarios.get(lEContador).getPvEPiezasDanadas();
                cpbEPiezasAsignadas = objALInventarios.get(lEContador).getPvEPiezasAsignadas();
            }
        } catch (Exception lEXe)
        {
            System.out.println("No hay datos para mostrar.");
        }

        if (cpbECantidad == 1)
        {
            new CEliminarInventarios().setVisible(true);
            dispose();
        } else
        {
            new CMotivoEliminacion().setVisible(true);
           dispose();
        }
    }//GEN-LAST:event_objBeliminarActionPerformed
    /**
     * desechosActionPerformed método que va a la ventana consultar Inventarios
     * desechos. El parámetro que recibe: 
     * @param evt  : indica evento
     */
    private void objBremovidoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_objBremovidoActionPerformed
    {//GEN-HEADEREND:event_objBremovidoActionPerformed
        new CConsultaInventarioRemovido().setVisible(true);
    }//GEN-LAST:event_objBremovidoActionPerformed
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
                CMenuInventarios objCMenuInventarios = new CMenuInventarios();
                objCMenuInventarios.setVisible(true);
                ImageIcon ImageIcon = new ImageIcon(getClass().getResource("../../imagenes/ico.png"));
                Image image = ImageIcon.getImage();
                objCMenuInventarios.setIconImage(image);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JButton objBagregarInventario;
    private javax.swing.JButton objBeliminar;
    private javax.swing.JButton objBmodificar;
    private javax.swing.JButton objBremovido;
    private javax.swing.JTable objTtablaAltaInventarios;
    // End of variables declaration//GEN-END:variables
}
