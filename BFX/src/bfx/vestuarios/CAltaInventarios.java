/*Nombre de clase		: CAltaInventarios
*Descripción de la clase	: Clase donde se realizan las propiedades de la clase con sus metodos encapsulados. 
*Fecha	de creación		: 04/05/2016
*Elaboro			: Oscar De Paz Feliciano y Erick López Hernández.
*Fecha	de Liberación		: 07/05/2016
*Autorizó			: Mauro Sánchez Sánchez
*Fecha Mantenimiento		: 19/06/2016
*Folio mantenimiento		: 02
*Descripción del mantto.	: Se realizó pruebas y transformacion de código con calidad.
*Responsable			: Oscar De Paz Feliciano
*Revisor 			: Mauro Sánchez Sánchez
 */
package bfx.vestuarios;

/**
 * Interfaz para dar de alta los vestuarios junto con su respectivo inventario
 *
 * @author: Techno Engineers
 * @versión: 2.0
 */
import bfx.controladores.CMensajes;
import bfx.controladores.CPanelFondo;
import bfx.controladores.CQuerys;
import bfx.controladores.CManipulaInterfaz;
import bfx.controladores.CValidaciones;
import bfx.clases.CInventarios;
import bfx.clases.CVestuarios;
import bfx.controladores.CManipulaDB;
import java.awt.Image;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class CAltaInventarios extends javax.swing.JFrame
{

    private CPanelFondo objCPanelFondo;
    public static String pbSId;
    public static String pvSValoresInventarios;
    ArrayList<Object> objArrayList = new ArrayList();
    JFrame objFrame = new JFrame();
    private int pvEEstado = 0;
    private ArrayList<CVestuarios> objArrayListVestuarios = new ArrayList<CVestuarios>();
    private ArrayList<CInventarios> objArrayListInventarios = new ArrayList<CInventarios>();
    ImageIcon objImageIcon = new ImageIcon(getClass().getResource("../imagenes/ico.png"));
    Image objImage = objImageIcon.getImage();

    /***
     * Contructor por defecto donde se inicalizan los componentes, posición del JFrame y agregación
     * del fondo en el panel.
     */
    public CAltaInventarios()
    {
        initComponents();
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        objCPanelFondo = new CPanelFondo("Altas de inventarios", "../imagenes/ballet.png", 0, 0, 420, 380);
        this.add(objCPanelFondo);
        this.setIconImage(objImage);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        objBguardarInventarios = new javax.swing.JButton();
        objBcancelarInventarios = new javax.swing.JButton();
        objLcantidad = new javax.swing.JLabel();
        objLclave = new javax.swing.JLabel();
        objTFcantidadInventarios = new javax.swing.JTextField();
        objTFclaveInventarios = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alta de inventarios");
        setResizable(false);

        objBguardarInventarios.setBackground(new java.awt.Color(255, 255, 255));
        objBguardarInventarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objBguardarInventarios.setText("Guardar");
        objBguardarInventarios.setEnabled(false);
        objBguardarInventarios.setMaximumSize(new java.awt.Dimension(150, 25));
        objBguardarInventarios.setMinimumSize(new java.awt.Dimension(150, 25));
        objBguardarInventarios.setPreferredSize(new java.awt.Dimension(150, 25));
        objBguardarInventarios.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                objBguardarInventariosActionPerformed(evt);
            }
        });
        objBguardarInventarios.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objBguardarInventariosKeyPressed(evt);
            }
        });

        objBcancelarInventarios.setBackground(new java.awt.Color(255, 255, 255));
        objBcancelarInventarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objBcancelarInventarios.setText("Cancelar");
        objBcancelarInventarios.setMaximumSize(new java.awt.Dimension(150, 25));
        objBcancelarInventarios.setMinimumSize(new java.awt.Dimension(150, 25));
        objBcancelarInventarios.setPreferredSize(new java.awt.Dimension(150, 25));
        objBcancelarInventarios.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                objBcancelarInventariosActionPerformed(evt);
            }
        });

        objLcantidad.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objLcantidad.setText("Cantidad:");
        objLcantidad.setPreferredSize(new java.awt.Dimension(91, 25));

        objLclave.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objLclave.setText("Clave:");
        objLclave.setPreferredSize(new java.awt.Dimension(91, 25));

        objTFcantidadInventarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objTFcantidadInventarios.setMaximumSize(new java.awt.Dimension(150, 25));
        objTFcantidadInventarios.setMinimumSize(new java.awt.Dimension(150, 25));
        objTFcantidadInventarios.setPreferredSize(new java.awt.Dimension(150, 25));
        objTFcantidadInventarios.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFcantidadInventariosKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFcantidadInventariosKeyTyped(evt);
            }
        });

        objTFclaveInventarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objTFclaveInventarios.setEnabled(false);
        objTFclaveInventarios.setMaximumSize(new java.awt.Dimension(150, 25));
        objTFclaveInventarios.setMinimumSize(new java.awt.Dimension(150, 25));
        objTFclaveInventarios.setPreferredSize(new java.awt.Dimension(150, 25));
        objTFclaveInventarios.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFclaveInventariosKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFclaveInventariosKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(objBguardarInventarios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(objBcancelarInventarios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(objLcantidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(objLclave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(objTFcantidadInventarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(objTFclaveInventarios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(objTFcantidadInventarios, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objLcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(objTFclaveInventarios, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objLclave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(objBguardarInventarios, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objBcancelarInventarios, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * GuardarInventariosActionPerformed método que da de alta un inventario.
     * El parámetro que recibe es:
     * 
     * @param evt : indica una posible acción de un evento
     */
    private void objBguardarInventariosActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_objBguardarInventariosActionPerformed
    {//GEN-HEADEREND:event_objBguardarInventariosActionPerformed

        Connection lCNcon = CManipulaDB.cmetpbConectaDB();
        CQuerys objQuery = new CQuerys();
        boolean lBCajaVacia = CManipulaInterfaz.cmetpbBVerificaBlancos(objTFcantidadInventarios, objTFclaveInventarios);
        if (!lBCajaVacia)
        {
            int lEExistencia = Integer.parseInt(objTFcantidadInventarios.getText());
            CInventarios objInventarios = new CInventarios(0, Integer.parseInt(CAltaVestuarios.pbSId), Integer.parseInt(objTFcantidadInventarios.getText()), 0, 0, objTFclaveInventarios.getText(), lEExistencia);
            String pvSCadena2 = "null," + objInventarios.getPvEIdVestuario() + ","
                    + objInventarios.getPvECantidad() + ","
                    + objInventarios.getPvEPiezasDanadas() + ","
                    + objInventarios.getPvEPiezasAsignadas() + ","
                    + "'" + objInventarios.getPvSClaveVestuario() + "',"
                    + objInventarios.getPvEExistencia();
            CInventarios invAux = metpvCIClaveVestuario(objInventarios.getPvSClaveVestuario());
            System.out.println("invAux=" + invAux);
            if (invAux == null)
            {
                String lSResultado = objQuery.metpbSInsertar(lCNcon, "inventarios", pvSCadena2);
                if (lSResultado == null)
                {
                    CMensajes.cmetpbExito(this);
                    new CMenuInventarios().setVisible(true);
                    dispose();
                } else
                {
                    CMensajes.cmetpbFalla(this);
                }

            } else
            {
                CMensajes.cmetpbMsj("La clave del vestuario ya existe.", "Advertencia", 2, this);
            }
            CManipulaDB.cmetpbDesconectaDB(lCNcon);
        }
    }//GEN-LAST:event_objBguardarInventariosActionPerformed
    /**
     * GuardarInventariosKeyPressed método que al presionar una tecla realiza la función del método
     * GuardarInventariosActionPerformed(). El parámetro que recibe:
     * 
     * @param evt : indica una posible acción de un evento
     */
    private void objBguardarInventariosKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_objBguardarInventariosKeyPressed
    {//GEN-HEADEREND:event_objBguardarInventariosKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            objBguardarInventariosActionPerformed(null);
        }
    }//GEN-LAST:event_objBguardarInventariosKeyPressed
    /**
     * CancelarInventariosActionPerformed método que cierra la ventana actual
     * @param evt : indica una posible acción de un evento
     */
    private void objBcancelarInventariosActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_objBcancelarInventariosActionPerformed
    {//GEN-HEADEREND:event_objBcancelarInventariosActionPerformed
        new CMenuInventarios().setVisible(true);
        dispose();
    }//GEN-LAST:event_objBcancelarInventariosActionPerformed
    /**
     * CantidadInventariosKeyPressed método que cambia a la caja de texto clave 
     * @param evt : indica una posible acción de un evento
     */
    private void objTFcantidadInventariosKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_objTFcantidadInventariosKeyPressed
    {//GEN-HEADEREND:event_objTFcantidadInventariosKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            //CManipulaInterfaz.metpbHabilita(true, claveInventarios);
            CManipulaInterfaz.cmetpbCambia(objTFclaveInventarios);
        }
    }//GEN-LAST:event_objTFcantidadInventariosKeyPressed
    /**
     * ClaveInventariosKeyPressed método que cambia al botón guardar
     * @param evt : indica una posible acción de un evento
     */
    private void objTFclaveInventariosKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_objTFclaveInventariosKeyPressed
    {//GEN-HEADEREND:event_objTFclaveInventariosKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            CManipulaInterfaz.cmetpbCambia(objBguardarInventarios);
        }
    }//GEN-LAST:event_objTFclaveInventariosKeyPressed
    /**
     * CantidadInventariosKeyTyped método que valida que en la caja de texto cantidad
     * se ingrese solo numeros y su longitud sea entre 1 a 9. El parámetro que recibe es:
     * 
     * @param evt : indica una posible acción de un evento
     */
    private void objTFcantidadInventariosKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_objTFcantidadInventariosKeyTyped
    {//GEN-HEADEREND:event_objTFcantidadInventariosKeyTyped
        CValidaciones.cmetpbEntero(evt);
        if (objTFcantidadInventarios.getText().length() == 9)
        {
            evt.consume();
        }
    }//GEN-LAST:event_objTFcantidadInventariosKeyTyped
    /**
     * ClaveInventariosKeyTyped método que valida que en la caja de texto clave se
     * ingrese solo letras y números, su longitud sea entre 1 a 5. El parámetro que recibe es:
     * 
     * @param evt : indica una posible acción de un evento
     */
    private void objTFclaveInventariosKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_objTFclaveInventariosKeyTyped
    {//GEN-HEADEREND:event_objTFclaveInventariosKeyTyped
        CValidaciones.cmetpbAlfanumerico(evt);
        if (objTFclaveInventarios.getText().length() == 5)
        {
            evt.consume();
        }
    }//GEN-LAST:event_objTFclaveInventariosKeyTyped
    /**
     * metpvCIClaveVestuario método que busca claves de inventarios, recibe el
     * siguiente parámetro:
     * 
     * @param ClaveVestuario : clave del vestuario a buscar
     * @return retorna null sino encuentra ninguna clave, en caso contrario retorna un objeto
     * con la clave existente junto con id inventario y cantidad.
     */
    private CInventarios metpvCIClaveVestuario(String ClaveVestuario)
    {
        CInventarios objCInventario = null;
        Connection lCNcon = CManipulaDB.cmetpbConectaDB();
        CQuerys objQuerys = new CQuerys();
        objArrayListInventarios = CManipulaDB.cmetpbALCargaInventarios(objQuerys.metpbALSeleccion(lCNcon, "*", "inventarios", "clavevestuario='" + ClaveVestuario + "'"));

        try
        {
            for (int lEContador = 0 ; lEContador < objArrayListInventarios.size() ; lEContador ++)
            {
                objCInventario = new CInventarios();
                objCInventario.setPvEIdInventario(objArrayListInventarios.get(lEContador).getPvEIdInventario());
                objCInventario.setPvECantidad(objArrayListInventarios.get(lEContador).getPvECantidad());
                objCInventario.setPvSClaveVestuario(objArrayListInventarios.get(lEContador).getPvSClaveVestuario().trim());
            }
        } catch (Exception lEXe)
        {
            System.out.println("No hay datos para mostrar.");
        }
        return objCInventario;
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
                CAltaInventarios objAltaVestuarios = new CAltaInventarios();
                objAltaVestuarios.setVisible(true);
                ImageIcon ImageIcon = new ImageIcon(getClass().getResource("../../imagenes/ico.png"));
                Image image = ImageIcon.getImage();
                objAltaVestuarios.setIconImage(image);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton objBcancelarInventarios;
    private javax.swing.JButton objBguardarInventarios;
    private javax.swing.JLabel objLcantidad;
    private javax.swing.JLabel objLclave;
    private javax.swing.JTextField objTFcantidadInventarios;
    private javax.swing.JTextField objTFclaveInventarios;
    // End of variables declaration//GEN-END:variables
}
