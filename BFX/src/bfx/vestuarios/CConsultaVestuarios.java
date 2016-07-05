/*Nombre de clase		: CConsultaVestuarios
*Descripción de la clase	: Es la clase en donde se realiza las consultas de los vestuarios con su parte de inventarios. 
*Fecha	de creación		: 01/06/2016
*Elaboro			: Oscar De Paz Feliciano y Erick López Hernández.
*Fecha	de Liberación		: 08/06/2016
*Autorizó			: Mauro Sánchez Sánchez
*Fecha Mantenimiento		: 19/06/2016
*Folio mantenimiento		: 02
*Descripción del mantto.	: Se realizó pruebas y transformacion de código con calidad.
*Responsable			: Oscar De Paz Feliciano
*Revisor 			: Mauro Sánchez Sánchez
 */
package bfx.vestuarios;

/**
 * Interfaz para consultas generales y específicas en vestuarios e inventarios
 *
 * @author: Techno Engineers
 * @version 2.0
 */
import bfx.clases.CVestuarioInventarioTmp;
import java.awt.Image;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import bfx.controladores.*;

public class CConsultaVestuarios extends javax.swing.JFrame
{

    CPanelFondo objCPanelFondo;
    ArrayList<CVestuarioInventarioTmp> objALVestuarioInventario = new ArrayList<CVestuarioInventarioTmp>();
    JFrame objJFrame = new JFrame();
    private boolean pvBBandera = false;
    private Connection pvCNcon = CManipulaDB.cmetpbConectaDB();
    ImageIcon objImageIcon = new ImageIcon(getClass().getResource("../imagenes/ico.png"));
    Image objImage = objImageIcon.getImage();
    /***
     * Contructor por defecto donde se inicalizan los componentes, posición del JFrame y agregación
     * del fondo en el panel.
     */    
    public CConsultaVestuarios()
    {
        initComponents();
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        objCPanelFondo = new CPanelFondo("Consula de vestuarios", "../imagenes/ballet.png", 0, 0, 790, 380);
        this.add(objCPanelFondo);
        this.pack();
        this.setSize(790, 380);
        this.setIconImage(objImage);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        objLclave = new javax.swing.JLabel();
        objCBtipoVestuarios = new javax.swing.JComboBox<String>();
        objCBsexoVestuarios = new javax.swing.JComboBox<String>();
        objLsexo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        objTtablaAltaInventarios = new javax.swing.JTable();
        objLInventario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultas de vestuarios");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowOpened(java.awt.event.WindowEvent evt)
            {
                formWindowOpened(evt);
            }
        });

        objLclave.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objLclave.setText("Tipo:");
        objLclave.setPreferredSize(new java.awt.Dimension(91, 25));

        objCBtipoVestuarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objCBtipoVestuarios.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--------- Selecciona --------", "Prenda", "Accesorio" }));
        objCBtipoVestuarios.setMaximumSize(new java.awt.Dimension(150, 25));
        objCBtipoVestuarios.setMinimumSize(new java.awt.Dimension(150, 25));
        objCBtipoVestuarios.setPreferredSize(new java.awt.Dimension(150, 25));
        objCBtipoVestuarios.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                objCBtipoVestuariosItemStateChanged(evt);
            }
        });

        objCBsexoVestuarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objCBsexoVestuarios.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--------- Selecciona --------", "Hombre", "Mujer" }));
        objCBsexoVestuarios.setEnabled(false);
        objCBsexoVestuarios.setMaximumSize(new java.awt.Dimension(150, 25));
        objCBsexoVestuarios.setMinimumSize(new java.awt.Dimension(150, 25));
        objCBsexoVestuarios.setPreferredSize(new java.awt.Dimension(150, 25));
        objCBsexoVestuarios.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                objCBsexoVestuariosItemStateChanged(evt);
            }
        });

        objLsexo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objLsexo.setText("Sexo:");
        objLsexo.setPreferredSize(new java.awt.Dimension(91, 25));

        objTtablaAltaInventarios = new javax.swing.JTable()
        {
            public boolean isCellEditable (int row, int column)
            {
                return false;
            }
        };
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
        objTtablaAltaInventarios.getTableHeader().setResizingAllowed(false);
        objTtablaAltaInventarios.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(objTtablaAltaInventarios);

        objLInventario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objLInventario.setText("Inventario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(725, Short.MAX_VALUE)
                .addComponent(objLInventario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(objLsexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(objLclave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(objCBsexoVestuarios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(objCBtipoVestuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(objCBtipoVestuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objLclave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(objCBsexoVestuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(objLsexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(objLInventario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * formWindowOpened método que se ejecuta al abrir el JFrame realiza la consulta de los vestuarios con
     * su respectivo inventario ya registrados en la BD. Recibe como parámetro:
     * 
     * @param evt : indica un evento
     */
    private void formWindowOpened(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowOpened
    {//GEN-HEADEREND:event_formWindowOpened

        String lSCampos = "*";
        String lSTablas = "vestuarios , inventarios ";
        String lSCondicion = "vestuarios.idvestuario = inventarios.idvestuario";
        metpvConsultarVestuarioInventario(lSTablas, lSCampos, lSCondicion);
    }//GEN-LAST:event_formWindowOpened

    /**
     * tipoVestuariosItemStateChanged método que indica diferentes filtros de consulta
     * apartir de tipo. El parámetro que recibe es: 
     * @param evt : indica un evento
     */
    private void objCBtipoVestuariosItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_objCBtipoVestuariosItemStateChanged
    {//GEN-HEADEREND:event_objCBtipoVestuariosItemStateChanged
        if (pvBBandera == true)
        {
            objCBsexoVestuariosItemStateChanged(evt);
        } else
        {
            String lSCampos = "*";
            String lSTablas = "vestuarios ves , inventarios inv";
            String lSCondicion = "ves.idvestuario = inv.idvestuario AND tipo like '%" + String.valueOf(objCBtipoVestuarios.getSelectedItem().toString().charAt(0)) + "%' ;";
            metpvConsultarVestuarioInventario(lSTablas, lSCampos, lSCondicion);
        }
        CManipulaInterfaz.cmetpbCambia(objCBsexoVestuarios);
    }//GEN-LAST:event_objCBtipoVestuariosItemStateChanged
    /**
     * sexoVestuariosItemStateChanged método que indica diferentes filtros de consulta
     * apartir de tipo. El parámetro que recibe es: 
     * @param evt : indica un evento
     */
    private void objCBsexoVestuariosItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_objCBsexoVestuariosItemStateChanged
    {//GEN-HEADEREND:event_objCBsexoVestuariosItemStateChanged
        pvBBandera = true;
        String lSCampos = "*";
        String lSTablas = "vestuarios ves , inventarios inv";
        String lSCondicion = "ves.idvestuario = inv.idvestuario AND tipo LIKE '%" + String.valueOf(objCBtipoVestuarios.getSelectedItem().toString().charAt(0)) + "%' AND sexo LIKE '%" + String.valueOf(objCBsexoVestuarios.getSelectedItem().toString().charAt(0)) + "%';";
        metpvConsultarVestuarioInventario(lSTablas, lSCampos, lSCondicion);
    }//GEN-LAST:event_objCBsexoVestuariosItemStateChanged
  
    /**
     * metpvConsultarVestuarioInventario método que consulta los datos de vestuario junto con su respectivo
     * inventario. Los parámetros que recibe son:
     * 
     * @param lSTablas     : identifica las tablas vestuarios e inventarios
     * @param lSCampos     : identifica todos los campos de las tablas
     * @param lSCondicion  : indentifica la condición para mostrar ciertos datos
     */
    private void metpvConsultarVestuarioInventario(String lSTablas, String lSCampos, String lSCondicion)
    {
        String lASCampos[] =
        {
            "Tipo", "Descripción", "Color", "Sexo", "Cantidad", "Piezas Dañadas", "Piezas Asignadas", "Clave de vestuario"
        };

        DefaultTableModel objDefaultTableModel = new DefaultTableModel(null, lASCampos);
        CQuerys objCQuerys = new CQuerys();

        objALVestuarioInventario = CManipulaDB.cmetpbALCargaVestuarioInvetario(objCQuerys.metpbALSeleccion(pvCNcon, lSCampos, lSTablas, lSCondicion));
        try
        {
            Object[] objObject = new Object[objDefaultTableModel.getColumnCount()];
            if (objALVestuarioInventario != null)
            {
                for (int lEi = 0 ; lEi < objALVestuarioInventario.size() ; lEi ++)
                {
                    objObject[0] = objALVestuarioInventario.get(lEi).getPvCTipo();
                    objObject[1] = objALVestuarioInventario.get(lEi).getPvSDescripcion();
                    objObject[2] = objALVestuarioInventario.get(lEi).getPvSColor();
                    objObject[3] = objALVestuarioInventario.get(lEi).getPvCSexo();
                    objObject[4] = objALVestuarioInventario.get(lEi).getPvECantidad();
                    objObject[5] = objALVestuarioInventario.get(lEi).getPvEPiezasDanadas();
                    objObject[6] = objALVestuarioInventario.get(lEi).getPvEPiezasAsignadas();
                    objObject[7] = objALVestuarioInventario.get(lEi).getPvSClaveVestuario();
                    objDefaultTableModel.addRow(objObject);
                }
            }
        } catch (Exception lEXe)
        {
            CMensajes.cmetpbFalla(this, "No hay datos para mostrar.");
        }

        objTtablaAltaInventarios.setModel(objDefaultTableModel);
        CManipulaDB.cmetpbDesconectaDB(pvCNcon);
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
                CConsultaVestuarios objCConsultarVestuarios = new CConsultaVestuarios();
                objCConsultarVestuarios.setVisible(true);
                ImageIcon objImageIcon = new ImageIcon(getClass().getResource("../imagenes/ico.png"));
                Image objImage = objImageIcon.getImage();
                objCConsultarVestuarios.setIconImage(objImage);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> objCBsexoVestuarios;
    private javax.swing.JComboBox<String> objCBtipoVestuarios;
    private javax.swing.JLabel objLInventario;
    private javax.swing.JLabel objLclave;
    private javax.swing.JLabel objLsexo;
    private javax.swing.JTable objTtablaAltaInventarios;
    // End of variables declaration//GEN-END:variables
}
