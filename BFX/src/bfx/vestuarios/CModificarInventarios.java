/*Nombre de clase		: CModificarInventarios
*Descripción de la clase	: Clase que permite modificar cada inventario. 
*Fecha	de creación		: 07/05/2016
*Elaboro			: Oscar De Paz Feliciano.
*Fecha	de Liberación		: 15/05/2016
*Autorizó			: Mauro Sánchez Sánchez
*Fecha Mantenimiento		: 19/06/2016
*Folio mantenimiento		: 02
*Descripción del mantto.	: Se realizó pruebas y transformacion de código con calidad.
*Responsable			: Oscar De Paz Feliciano
*Revisor 			: Mauro Sánchez Sánchez
*/
package bfx.vestuarios;
/**
 * Interfaz para modificar a los registros de inventarios
 * @author: Techno Engineers
 * @versión: 2.0
 */
import bfx.clases.CInventarios;
import bfx.clases.CVestuarios;
import java.awt.Image;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import bfx.controladores.*;

public class CModificarInventarios extends javax.swing.JFrame
{

    CPanelFondo objCPanelFondo;
    public static String pbSId;
    public static String pvSValoresInventarios;
    ArrayList<Object> objArrayList = new ArrayList();
    JFrame objJFrame = new JFrame();
    private int pvEEstado = 0;
    private int pvECantidadExistente = 0;
    private int pvEExistencia;
    private ArrayList<CVestuarios> objALVestuarios = new ArrayList<CVestuarios>();
    private ArrayList<CInventarios> objALInventarios = new ArrayList<CInventarios>();
    ImageIcon objImageIcon = new ImageIcon(getClass().getResource("../imagenes/ico.png"));
    Image objImage = objImageIcon.getImage();
     /***
     * Contructor por defecto donde se inicalizan los componentes, posición del JFrame y agregación
     * del fondo en el panel.
     */
    public CModificarInventarios()
    {
        initComponents();
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        objCPanelFondo = new CPanelFondo("Modificar inventarios" , "../imagenes/ballet.png" , 0 , 0 , 420 , 380);
        this.add(objCPanelFondo);
        objTFexistencia.setVisible(false);
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
        objTFexistencia = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificaciones vestuarios");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowOpened(java.awt.event.WindowEvent evt)
            {
                formWindowOpened(evt);
            }
        });

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
        objBcancelarInventarios.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objBcancelarInventariosKeyPressed(evt);
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

        objTFexistencia.setMaximumSize(new java.awt.Dimension(100, 25));
        objTFexistencia.setMinimumSize(new java.awt.Dimension(100, 25));
        objTFexistencia.setPreferredSize(new java.awt.Dimension(100, 25));
        objTFexistencia.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                objTFexistenciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(23, Short.MAX_VALUE)
                        .addComponent(objBguardarInventarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(objBcancelarInventarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(64, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(objLcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(objTFcantidadInventarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(objLclave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(objTFexistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(objTFclaveInventarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(objLcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objTFcantidadInventarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(objLclave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objTFclaveInventarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(objTFexistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(objBguardarInventarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objBcancelarInventarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

     /**
     * guardarInventariosKeyPressed método que  al presionar la tecla enter realiza la función del método
     * guardarInventariosActionPerformed. Recibe el parámetro:
     * 
     * @param evt : indica un evento
     */
    private void objBguardarInventariosKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_objBguardarInventariosKeyPressed
    {//GEN-HEADEREND:event_objBguardarInventariosKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            objBguardarInventariosActionPerformed(null);
        }
    }//GEN-LAST:event_objBguardarInventariosKeyPressed
   
    /**
     * cancelarInventariosActionPerformed método que muestra la ventana CMenuInventarios y oculta la
     * ventana actual. El parámetro que recibe:
     * 
     * @param evt : indica un evento
     */
    private void objBcancelarInventariosActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_objBcancelarInventariosActionPerformed
    {//GEN-HEADEREND:event_objBcancelarInventariosActionPerformed

        new CMenuInventarios().setVisible(true);
        dispose();
    }//GEN-LAST:event_objBcancelarInventariosActionPerformed
    /**
     * cancelarInventariosKeyPressed método que  al presionar la tecla enter realiza la función del método
     * formWindowOpened. Recibe el parámetro:
     * 
     * @param evt : indica un evento
     */
    private void objBcancelarInventariosKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_objBcancelarInventariosKeyPressed
    {//GEN-HEADEREND:event_objBcancelarInventariosKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            formWindowOpened(null);
        }
    }//GEN-LAST:event_objBcancelarInventariosKeyPressed

    /**
     * formWindowOpened método que se ejecuta al abrir el JFrame realiza la consulta de los inventarios ya
     * registrados en la BD y los agrega en los componentes cantidad y clave. Recibe como parámetro:
     * 
     * @param evt : indica un evento
     */
    private void formWindowOpened(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowOpened
    {//GEN-HEADEREND:event_formWindowOpened
        Connection lCNcon = CManipulaDB.cmetpbConectaDB();
        try
        {
            objALInventarios = CManipulaDB.cmetpbALCargaInventarios(CManipulaDB.cmetpbArrayListConsulta(lCNcon , "inventarios" , "idinventario" , "" + CMenuInventarios.pbSIdInventario + ""));
            this.metpvCargarInventarios(objALInventarios);

        } catch (Exception lEXe)
        {
            CMensajes.cmetpbMsj("No hay datos a modificar" , "Información" , 3 , this);
        }
        CManipulaDB.cmetpbDesconectaDB(lCNcon);
    }//GEN-LAST:event_formWindowOpened

    /**
     * cantidadInventariosKeyPressed método que cambia al campo de textos clave. El parámetro que
     * recibe es: 
     * 
     * @param evt : indica un posible  evento
     */
    private void objTFcantidadInventariosKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_objTFcantidadInventariosKeyPressed
    {//GEN-HEADEREND:event_objTFcantidadInventariosKeyPressed
        if (evt.getKeyChar() == '\n')
        {
//            ManipulaInterfaces.habilita(true, claveInventarios);
            CManipulaInterfaz.cmetpbCambia(objTFclaveInventarios);
        }
    }//GEN-LAST:event_objTFcantidadInventariosKeyPressed

    /**
     * claveInventariosKeyPressed método que cambia al botón guardar. El parámetro que
     * recibe es:
     * 
     * @param evt : indica un posible  evento
     */
    private void objTFclaveInventariosKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_objTFclaveInventariosKeyPressed
    {//GEN-HEADEREND:event_objTFclaveInventariosKeyPressed
        if (evt.getKeyChar() == '\n')
        {
//            ManipulaInterfaces.habilita(true, guardarInventarios);
            CManipulaInterfaz.cmetpbCambia(objBguardarInventarios);
        }
    }//GEN-LAST:event_objTFclaveInventariosKeyPressed

    /**
     * cantidadInventariosKeyTyped método que válida que en la caja de texto cantidad se
      objTFcantidadInventarios números, su longitud maxima es de 9. El parámetro que recibe es:
     * 
     * @param evt : indica una posible  evento
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
     * claveInventariosKeyTyped método que válida que en la caja de texto clave se
     * ingrese solo números y letras, su longitud maxima es de 5. El parámetro que recibe es:
     * 
     * @param evt : indica una posible  evento
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
     * guardarInventariosActionPerformed método que manda los datos para actualizar en inventarios.
     * El parámetro que recibe es: 
     * @param evt : indica un evento
     */
 
    private void objBguardarInventariosActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_objBguardarInventariosActionPerformed
    {//GEN-HEADEREND:event_objBguardarInventariosActionPerformed
        Connection lCNcon = CManipulaDB.cmetpbConectaDB();
        CQuerys objCQuerys = new CQuerys();
        boolean lBCajaVacia = CManipulaInterfaz.cmetpbBVerificaBlancos(objTFcantidadInventarios , objTFclaveInventarios);

        if (!lBCajaVacia)
        {
            if (pvECantidadExistente <= Integer.parseInt(objTFcantidadInventarios.getText()))
            {
                //, piezasdaniadas 
                String lSColumnasI = "idvestuario , cantidad , piezasasignadas , clavevestuario , existencia";
                pvSValoresInventarios = this.metpvSValoresInventarios();
                String lSCondicionI = "idinventario =" + CMenuInventarios.pbSIdInventario;
                CInventarios invAux = metpvCIBuscarClaves(objTFclaveInventarios.getText());
                if (invAux == null)
                {
                    String lSRI = objCQuerys.metpbSModificar(lCNcon , "inventarios" , lSColumnasI , pvSValoresInventarios , lSCondicionI);
                    if (lSRI == null)
                    {
                        CMensajes.cmetpbExito(this);
                        new CMenuInventarios().setVisible(true);
                        dispose();
                        //formWindowOpened(null);
                    } else
                    {
                        CMensajes.cmetpbMsj(this , "Dato no actualizado.");
                    }
                } else
                {
                    CMensajes.cmetpbMsj("La clave del vestuario ya existe." , "Advertencia" , 2 , this);
                    //new CModificarInventarios().setVisible(true);
                }
            } else
            {
                CMensajes.cmetpbMsj("La cantidad no debe ser menor a la existente.", "Notificación", 3, this);
            }
        }
        CManipulaDB.cmetpbDesconectaDB(lCNcon);
    }//GEN-LAST:event_objBguardarInventariosActionPerformed

    private void objTFexistenciaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_objTFexistenciaActionPerformed
    {//GEN-HEADEREND:event_objTFexistenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_objTFexistenciaActionPerformed
    /**
     * metpvCargarInventarios método que carga loobjTFcantidadInventariosrio en el formulario actual. El
     * parátro que recibe es:
     * 
     * @param objALInventarios :objeto tipo inventario contiene datos del inventario antes cargados.
     */
    private void metpvCargarInventarios(ArrayList<CInventarios> objALInventarios)
    {
        for (int lEi = 0 ; lEi < objALInventarios.size() ; lEi ++)
        {
            objTFcantidadInventarios.setText(String.valueOf(objALInventarios.get(lEi).getPvECantidad()));
            pvECantidadExistente = objALInventarios.get(lEi).getPvECantidad();//
            objTFclaveInventarios.setText(objALInventarios.get(lEi).getPvSClaveVestuario().trim());
            objTFexistencia.setText(String.valueOf(objALInventarios.get(lEi).getPvEExistencia()));
            pvEExistencia=objALInventarios.get(lEi).getPvECantidad();     
        }
    }
    /**
     * metpvSValoresInventarios método que obtiene en los sets y gets los valores de los inventarios
     * a través de los formobjTFcantidadInventarios   * @return retorna los valores almacenados en una cadena.
     */
    private String metpvSValoresInventarios()
    {
        System.out.println("cantidad textfield:" + Integer.parseInt(objTFcantidadInventarios.getText()));
        System.out.println("cantidad bd:objTFcantidadInventariosstente");
        int lEExistenciaNueva = pvEExistencia + ((Integer.parseInt(objTFcantidadInventarios.getText()))-(pvECantidadExistente));
        System.out.println("nueva cantidad a ingresar: " + lEExistenciaNueva);
        CInventarios objCInventarios = new CInventarios(0 , Integer.parseInt("" + CAltaVestuarios.pbSId + ""),
                Integer.parseInt(objTFcantidadInventarios.getText()),
                0, 0, objTFclaveInventarios.getText(), lEExistenciaNueva);
        pvSValoresInventarios = objCInventarios.getPvEIdVestuario() + ","
                + objCInventarios.getPvECantidad() + ","
               // + objCInventarios.getPvEPiezasDanadas() + ","
                + objCInventarios.getPvEPiezasAsignadas() + ","
                + "'" + objCInventarios.getPvSClaveVestuario() + "',"
                + objCInventarios.getPvEExistencia();
        return pvSValoresInventarios;
    }
    /**
     * metpbCIClaveVestuario método que busca si existe la clave del inventario.
     * El parámetro que recibe es:
     * 
     * @param lSClaveVestuario : clave del vestuario a buscar
     * @return retorna null sino encuentra ninguna clave de inventario en caso contrario retorna
     * un objeto con la clave existente y otros datos dentro del objeto como id inventario y cantidad.
     */
    private CInventarios metpvCIBuscarClaves(String lSClaveVestuario)
    {
        CInventarios objCInventarios = null;
        Connection lCNcon = CManipulaDB.cmetpbConectaDB();
        CQuerys objCQuerys = new CQuerys();
        objALInventarios = CManipulaDB.cmetpbALCargaInventarios(objCQuerys.metpbALSeleccion(lCNcon , "*" , "inventarios" , "clavevestuario ='" + lSClaveVestuario + "'  and idinventario !=" + CMenuInventarios.pbSIdInventario + ""));

        try
        {
            for (int lEi = 0 ; lEi < objALInventarios.size() ; lEi ++)
            {
                objCInventarios = new CInventarios();
                objCInventarios.setPvEIdInventario(objALInventarios.get(lEi).getPvEIdInventario());
                objCInventarios.setPvECantidad(objALInventarios.get(lEi).getPvECantidad());
                objCInventarios.setPvSClaveVestuario(objALInventarios.get(lEi).getPvSClaveVestuario().trim());
            }
        } catch (Exception lEXe)
        {
            System.out.println("No hay datos para mostrar.");
        }
        return objCInventarios;
    }
    /**
     * main() método principal donde se empezará a inicar los métodos del JFrame.
     * El parámetro que recibe es:
     * 
     * @param args : indica argumentos
     */
    public static void main(String lASArgs[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                CModificarInventarios objAltaVestuarios = new CModificarInventarios();
                objAltaVestuarios.setVisible(true);
                ImageIcon objImageIcon=new ImageIcon(getClass().getResource("../../imagenes/ico.png"));
                Image objImage = objImageIcon.getImage();
                objAltaVestuarios.setIconImage(objImage);
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
    private javax.swing.JTextField objTFexistencia;
    // End of variables declaration//GEN-END:variables
}
