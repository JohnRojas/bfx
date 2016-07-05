/*Nombre de clase		: CMotivoEliminacion
*Descripción de la clase	: Clase donde se realiza el motivo de la eliminación. 
*Fecha	de creación		: 21/06/2016
*Elaboro			: Oscar De Paz Feliciano
*Fecha	de Liberación		: 22/06/2016
*Autorizó			: Mauro Sánchez Sánchez
*Fecha Mantenimiento		: 22/06/2016
*Folio mantenimiento		: 02
*Descripción del mantto.	: Se realizó pruebas y transformacion de código con calidad.
*Responsable			: Oscar De Paz Feliciano
*Revisor 			: Mauro Sánchez Sánchez
 */
package bfx.vestuarios;

/**
 * Interfaz para dar de alta el motivo de la eliminación del inventario
 *
 * @author: Techno Engineers
 * @versión: 2.0
 */
import bfx.controladores.CMensajes;
import bfx.controladores.CPanelFondo;
import bfx.controladores.CQuerys;
import bfx.controladores.CManipulaInterfaz;
import bfx.controladores.CValidaciones;
import bfx.clases.CInventarioDesechado;
import bfx.clases.CInventarios;
import bfx.clases.CVestuarios;
import bfx.clases.CUsuarioTmp;
import bfx.controladores.CManipulaDB;
import static bfx.vestuarios.CMenuInventarios.pbSIdInventario;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class CMotivoEliminacion extends javax.swing.JFrame
{

    private CPanelFondo objCPanelFondo;
    public static String pbSId;
    public static String pvSValoresInventarios;
    ArrayList<Object> objArrayList = new ArrayList();
    JFrame objFrame = new JFrame();
    private int pvEEstado = 0;
    ArrayList<CVestuarios> objALVestuarios = new ArrayList<CVestuarios>();
    ArrayList<CInventarios> objALInventarios = new ArrayList<CInventarios>();
    ArrayList<CUsuarioTmp> objALCUsuarioTmp = new ArrayList<CUsuarioTmp>();
    private int pvEIdUsuario;
    ImageIcon objImageIcon = new ImageIcon(getClass().getResource("../imagenes/ico.png"));
    Image objImage = objImageIcon.getImage();

    /**
     * *
     * Contructor por defecto donde se inicalizan los componentes, posición del
     * JFrame y agregación del fondo en el panel.
     */
    public CMotivoEliminacion()
    {
        initComponents();
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        objCPanelFondo = new CPanelFondo("Motivo eliminación", "../imagenes/ballet.png", 0, 0, 420, 380);
        this.add(objCPanelFondo);
        objLids.setVisible(false);
        this.setIconImage(objImage);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        objBguardarInventarios = new javax.swing.JButton();
        objBcancelarInventarios = new javax.swing.JButton();
        objLmotivo = new javax.swing.JLabel();
        objLusuarios = new javax.swing.JLabel();
        objCBusuarios = new javax.swing.JComboBox<String>();
        objCBmotivo = new javax.swing.JComboBox<String>();
        objLids = new javax.swing.JComboBox<String>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Motivo de la eliminación");
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
        objBguardarInventarios.setText("Aceptar");
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

        objLmotivo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objLmotivo.setText("Elije el motivo por el cual desea eliminar:");
        objLmotivo.setPreferredSize(new java.awt.Dimension(91, 25));

        objLusuarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objLusuarios.setText("Usuario responsable:");
        objLusuarios.setPreferredSize(new java.awt.Dimension(91, 25));

        objCBusuarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objCBusuarios.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "------- Selecciona -------" }));
        objCBusuarios.setEnabled(false);
        objCBusuarios.setMaximumSize(new java.awt.Dimension(150, 25));
        objCBusuarios.setMinimumSize(new java.awt.Dimension(150, 25));
        objCBusuarios.setPreferredSize(new java.awt.Dimension(150, 25));
        objCBusuarios.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                objCBusuariosItemStateChanged(evt);
            }
        });

        objCBmotivo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objCBmotivo.setMaximumSize(new java.awt.Dimension(150, 25));
        objCBmotivo.setMinimumSize(new java.awt.Dimension(150, 25));
        objCBmotivo.setPreferredSize(new java.awt.Dimension(150, 25));
        objCBmotivo.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                objCBmotivoItemStateChanged(evt);
            }
        });

        objLids.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(objLids, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(170, 170, 170))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(objCBusuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objCBmotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(objBguardarInventarios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(objBcancelarInventarios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(objLmotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(objLusuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(objLmotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(objCBmotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(objLusuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(objCBusuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(objLids, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(objBguardarInventarios, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objBcancelarInventarios, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * guardarInventariosActionPerformed método de selección para elimina una
     * pieza dañada, asignada o no asignada. El parámetro que recibe es:
     *
     * @param evt : indica un evento
     */
    private void objBguardarInventariosActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_objBguardarInventariosActionPerformed
    {//GEN-HEADEREND:event_objBguardarInventariosActionPerformed

        int lEOpcionSeleccionada = metpvEConvertirOpcionNumero(objCBmotivo.getSelectedItem().toString());
        String ISMotivo = (String) objCBmotivo.getSelectedItem();
        System.out.println("numero del select: " + lEOpcionSeleccionada);

        switch (lEOpcionSeleccionada)
        {
            case 1:
                //Elimina en piezas dañadas  
                metpvEliminarPiezaDaniada(CMenuInventarios.cpbECantidad, CMenuInventarios.cpbEPiezasDaniadas, CMenuInventarios.cpbEPiezasAsignadas, 0, ISMotivo);
                break;
            case 2:
                //Elimina en piezas asignadas 
                metpvEliminarPiezaAsignada(CMenuInventarios.cpbECantidad, CMenuInventarios.cpbEPiezasDaniadas, CMenuInventarios.cpbEPiezasAsignadas, 1, ISMotivo);
                break;
            case 3:
                //elimina en pieza no asignada
                metpvEliminarPiezaCantidad(CMenuInventarios.cpbECantidad, CMenuInventarios.cpbEPiezasDaniadas, CMenuInventarios.cpbEPiezasAsignadas, 2, ISMotivo);
                break;
            default:
                CMensajes.cmetpbMsj("Seleccione un motivo", "Notificación", 3, this);

        }

    }//GEN-LAST:event_objBguardarInventariosActionPerformed

    /**
     * guardarInventariosKeyPressed método que al presionar la tecla enter
     * realiza la función del método guardarInventariosActionPerformed. Recibe
     * el parámetro:
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
     * cancelarInventariosActionPerformed método que muestra la ventana
     * CMenuInventarios y oculta la ventana actual. El parámetro que recibe:
     *
     * @param evt : indica un evento
     */
    private void objBcancelarInventariosActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_objBcancelarInventariosActionPerformed
    {//GEN-HEADEREND:event_objBcancelarInventariosActionPerformed
        new CMenuInventarios().setVisible(true);
        dispose();
    }//GEN-LAST:event_objBcancelarInventariosActionPerformed

    /**
     * usuarioItemStateChanged método que obtiene el id del usuario del usuario
     * responsable de la eliminación. El parámetro que recibe es:
     *
     * @param evt : indica un evento
     */
    private void objCBusuariosItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_objCBusuariosItemStateChanged
    {//GEN-HEADEREND:event_objCBusuariosItemStateChanged
        CUsuarioTmp objCUsuarioTmp = new CUsuarioTmp();
        if (objCBusuarios.getSelectedIndex() != 0)
        {
            objLids.setSelectedIndex(objCBusuarios.getSelectedIndex());
            try
            {
                objCUsuarioTmp.setPvEIdUsuario(Integer.parseInt(objLids.getSelectedItem().toString()));
                pvEIdUsuario = objCUsuarioTmp.getPvEIdUsuario();
                CManipulaInterfaz.cmetpbHabilita(true, objBguardarInventarios);
                System.out.println("id: " + pvEIdUsuario);
            } catch (Exception lEXe)
            {
                System.out.println("error" + lEXe.getMessage());
            }

        } else
        {
            // CMensajes.metpbMsj(objFrame, "Seleccione un usuario por favor.");
            CManipulaInterfaz.cmetpbHabilita(false, objBguardarInventarios);

        }
    }//GEN-LAST:event_objCBusuariosItemStateChanged

    /**
     * *
     * motivoItemStateChanged método que selecciona los usuarios que cometieron
     * un daño, les fue asiganda una pieza y responsable de piezas no asignadas.
     * Apartir de un motivo. El parámetro que recibe:
     *
     * @param evt : indica un evento
     */
    /**
     * ************************************************************************************************
     */
    private void objCBmotivoItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_objCBmotivoItemStateChanged
    {//GEN-HEADEREND:event_objCBmotivoItemStateChanged
        CManipulaInterfaz.cmetpbCambia(objCBusuarios);
        if (evt.getStateChange() == ItemEvent.SELECTED)
        {
            objCBusuarios.removeAllItems();
            objCBusuarios.addItem("---------------------- Selecciona ------------------------");
            objLids.removeAllItems();
            objLids.addItem("0");
            if (objCBmotivo.getSelectedItem().equals("No se pudo reparar el daño"))
            {
                //Llena combobox usuario, con los usuarios que dañaron prendas o accesorios
                Connection lCNcon = CManipulaDB.cmetpbConectaDB();
                String lSTabla = "usuarios, danio, asignavestuario ";
                String lSCondicion = "asignavestuario.idinventario = " + CMenuInventarios.pbSIdInventario + " AND asignavestuario.idasignavestuario=danio.idasignavestuario AND danio.status = '1' AND danio.idusuario=usuarios.idusuario  AND usuarios.status = 1";
                String lSCampos = "DISTINCT usuarios.idusuario, usuarios.nombre, usuarios.apellidopaterno, usuarios.apellidomaterno";
                metpvLlenaComboBoxUsuarios(lCNcon, lSTabla, lSCondicion, lSCampos);
            } else if (objCBmotivo.getSelectedItem().equals("La pieza asignada se reporto como perdida"))
            {
                //Llena combobox usuario, con los usuarios que se les asignó prendas o accesorios
                Connection lCNcon = CManipulaDB.cmetpbConectaDB();
                String lSCampos = "distinct us.idusuario,us.nombre, us.apellidopaterno, us.apellidomaterno";
                String lSTabla = "usuarios us, asignavestuario asi, bailarinesevento bai, inventarios inv, vestuarios ves";
                String lSCondicion = "asi.idbailarinevento = bai.idbailarinevento AND bai.idusuario = us.idusuario AND us.status = 1 AND asi.idinventario = inv.idinventario AND asi.idinventario = " + CMenuInventarios.pbSIdInventario + " AND inv.idvestuario = ves.idvestuario AND ves.idvestuario = " + CAltaVestuarios.pbSId + "";
                metpvLlenaComboBoxUsuarios(lCNcon, lSTabla, lSCondicion, lSCampos);

            } else if (objCBmotivo.getSelectedItem().equals("La pieza sin asignar se reporto como perdida"))
            {
                //Llena combobox usuario, con los usuarios responsables de las prendas prendas o accesorios no asignadas
                Connection lCNcon = CManipulaDB.cmetpbConectaDB();
                String lSCampos = "us.idusuario,us.nombre, us.apellidopaterno, us.apellidomaterno ";
                String lSTabla = "usuarios us";
                String lSCondicion = "us.tipodeusuario = 'A' AND us.status = 1 ";
                metpvLlenaComboBoxUsuarios(lCNcon, lSTabla, lSCondicion, lSCampos);
            } else
            {
                CMensajes.cmetpbMsj(this, "Elija un motivo por favor.");
            }
        }

    }//GEN-LAST:event_objCBmotivoItemStateChanged

    private void formWindowOpened(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowOpened
    {//GEN-HEADEREND:event_formWindowOpened
        objCBmotivo.addItem("---------------------- Selecciona ------------------------");
        if (CMenuInventarios.cpbEPiezasDaniadas > 0)
        {
            objCBmotivo.addItem("No se pudo reparar el daño");
        }
        if (CMenuInventarios.cpbEPiezasAsignadas > 0)
        {
            objCBmotivo.addItem("La pieza asignada se reporto como perdida");
        }
        objCBmotivo.addItem("La pieza sin asignar se reporto como perdida");
    }//GEN-LAST:event_formWindowOpened
    /**
     * metpvEliminarPiezaDaniada método que elimina piezas dañadas en la tabla
     * inventarios y actualiza cantidad así como existencia. Los parámetros que
     * reciben son:
     *
     * @param lECantidad : contiene la cantidad que hay en la BD
     * @param lEPiezasDaniadas : contiene las piezas dañadas en la BD
     * @param lEPiezasAsignadas : contiene las piezas asignadas en la BD
     * @param lETipo : contiene el tipo de eliminación (dañada, asignada sin
     * asignar)
     * @param ISMotivo : contiene el motivo de la eliminación.
     */
    private void metpvEliminarPiezaDaniada(int lECantidad, int lEPiezasDaniadas, int lEPiezasAsignadas, int lETipo, String ISMotivo)
    {

        int lENuevaCantidadPD = lEPiezasDaniadas - 1;
        int lENuevaCantidad = lECantidad - 1;
        int lENuevaExistencia = ((lENuevaCantidad) - (lENuevaCantidadPD + lEPiezasAsignadas));
        if (lEPiezasDaniadas > 0)
        {
            Connection lCNcon = CManipulaDB.cmetpbConectaDB();
            CQuerys objQuerys = new CQuerys();
            String lSResultado = objQuerys.metpbSModificar(lCNcon, "inventarios", "cantidad,piezasdaniadas,existencia", "" + lENuevaCantidad + "," + lENuevaCantidadPD + "," + lENuevaExistencia + "", "idinventario=" + Integer.parseInt(pbSIdInventario) + "");
            if (lSResultado == null)
            {

                CMensajes.cmetpbMsj("Se ha eliminada una pieza dañada", "Notificación", 3, this);
                metpvInsertarMotivoEliminacion(lETipo, ISMotivo);
                String lSTablas = "danio, asignavestuario";
                String lSCampos = "status,fechadepago";
                String lSValores = "'2', curdate()";
                String lSCondicion = "danio.idusuario=" + pvEIdUsuario + " AND danio.idasignavestuario = asignavestuario.idasignavestuario AND asignavestuario.idinventario =" + Integer.parseInt(CMenuInventarios.pbSIdInventario) + "";
                metpvActualizaDanioVestuarioAsignado(lSTablas, lSCampos, lSValores, lSCondicion);
            } else
            {
                CMensajes.cmetpbMsj(this, "No se pudo eliminar la pieza dañada.");
            }
            CManipulaDB.cmetpbDesconectaDB(lCNcon);
        } else
        {
            CMensajes.cmetpbMsj("No se puede eliminar, no existe ninguna pieza dañada.", "Notificación", 3, this);
        }

    }

    /**
     * metpvEliminarPiezaCantidad método que elimina en cantidad de la tabla
     * inventarios y actualiza existencia. Los parámetros que reciben son:
     *
     * @param lECantidad : contiene la cantidad que hay en la BD
     * @param lEPiezasDaniadas : contiene las piezas dañadas en la BD
     * @param lEPiezasAsignadas : contiene las piezas asignadas en la BD
     * @param lETipo : contiene el tipo de eliminación (dañada, asignada sin
     * asignar)
     * @param ISMotivo : contiene el motivo de la eliminación.
     */
    private void metpvEliminarPiezaCantidad(int lECantidad, int lEPiezasDaniadas, int lEPiezasAsignadas, int lETipo, String ISMotivo)
    {
        int lENuevaCantidad = lECantidad - 1;
        int lENuevaExistencia = ((lENuevaCantidad) - (lEPiezasDaniadas + lEPiezasAsignadas));
        if (lENuevaExistencia >= 0)
        {
            Connection lCNcon = CManipulaDB.cmetpbConectaDB();
            CQuerys objQuerys = new CQuerys();
            String lSResultado = objQuerys.metpbSModificar(lCNcon, "inventarios", "cantidad,existencia", "" + lENuevaCantidad + "," + lENuevaExistencia + "", "idinventario=" + Integer.parseInt(pbSIdInventario) + "");
            if (lSResultado == null)
            {

                CMensajes.cmetpbMsj("Se ha eliminada una pieza", "Notificación", 3, this);
                metpvInsertarMotivoEliminacion(lETipo, ISMotivo);

            } else
            {
                CMensajes.cmetpbMsj(this, "No se pudo eliminar la pieza.");
            }
            CManipulaDB.cmetpbDesconectaDB(lCNcon);
        } else
        {
            CMensajes.cmetpbMsj("No se pudo eliminar, cantidad de piezas insuficiente.", "Notificación", 3, this);
        }
    }

    /**
     * metpvEliminarPiezaAsignada método que elimina piezas asignadas en la
     * tabla inventarios y actualiza cantidad así como existencia. Los
     * parámetros que reciben son:
     *
     * @param lECantidad : contiene la cantidad que hay en la BD
     * @param lEPiezasDaniadas : contiene las piezas dañadas en la BD
     * @param lEPiezasAsignadas : contiene las piezas asignadas en la BD
     * @param lETipo : contiene el tipo de eliminación (dañada, asignada sin
     * asignar)
     * @param ISMotivo : contiene el motivo de la eliminación.
     */
    private void metpvEliminarPiezaAsignada(int lECantidad, int lEPiezasDaniadas, int lEPiezasAsignadas, int lETipo, String ISMotivo)
    {
        int lENuevaCantidadPA = lEPiezasAsignadas - 1;
        int lENuevaCantidad = lECantidad - 1;
        int lENuevaExistencia = ((lENuevaCantidad) - (lEPiezasDaniadas + lENuevaCantidadPA));
        if (lEPiezasAsignadas > 0)
        {
            Connection lCNcon = CManipulaDB.cmetpbConectaDB();
            CQuerys objQuerys = new CQuerys();
            String lSResultado = objQuerys.metpbSModificar(lCNcon, "inventarios", "cantidad,piezasasignadas,existencia", "" + lENuevaCantidad + "," + lENuevaCantidadPA + "," + lENuevaExistencia + "", "idinventario=" + Integer.parseInt(pbSIdInventario) + "");
            if (lSResultado == null)
            {
                CMensajes.cmetpbMsj("Se ha eliminada una pieza asignada.", "Notificación", 3, this);
                metpvInsertarMotivoEliminacion(lETipo, ISMotivo);
                String lSTablas = "asignavestuario, bailarinesevento";
                String lSCampos = "asignavestuario.*";
                String lSCondicion = "asignavestuario.idinventario =" + Integer.parseInt(CMenuInventarios.pbSIdInventario) + " and asignavestuario.idbailarinevento=bailarinesevento.idbailarinevento and bailarinesevento.idusuario=" + pvEIdUsuario + "";
                metpvEliminarAsignacionInventario(lSTablas, lSCampos,lSCondicion);
            } else
            {
                CMensajes.cmetpbMsj(this, "No se pudo eliminar la pieza asignada.");
            }
            CManipulaDB.cmetpbDesconectaDB(lCNcon);
        } else
        {
            CMensajes.cmetpbMsj("No se puede eliminar, no existe ninguna pieza asignada.", "Notificación", 3, this);
        }
    }

    /**
     * metpvInsertarMotivoEliminacion método que inserta el motivo de la
     * eliminación en la tabla de inventariodesecho. Los parámetros que recibe
     * son:
     *
     * @param lETipo : contiene el tipo de eliminación (dañada, asignada sin
     * asignar)
     * @param lSMotivo : contiene el motivo de la eliminación.
     */
    private void metpvInsertarMotivoEliminacion(int lETipo, String lSMotivo)
    {
        Connection lCNcon = CManipulaDB.cmetpbConectaDB();
        try
        {
            String lSTipo = metpvSTipoEliminacion(lETipo);
            CInventarioDesechado objInventarioDesechado = new CInventarioDesechado(0,
                    Integer.parseInt(pbSIdInventario), lSTipo, lSMotivo, pvEIdUsuario);
            String lSValores = "null," + "'" + objInventarioDesechado.getPvEIdInventario() + "',"
                    + "'" + objInventarioDesechado.getPvSTipo() + "',"
                    + "'" + objInventarioDesechado.getPvSMotivo() + "',"
                    + "" + objInventarioDesechado.getPvEIdUsuario() + "";
            CQuerys objQuery = new CQuerys();
            String lSResultado = objQuery.metpbSInsertar(lCNcon, "inventariodesechado", lSValores);

            if (lSResultado == null)
            {
                System.out.println("Se inserto correctamente el inventario desechado.");
            } else
            {
                CMensajes.cmetpbFalla(this);
            }

        } catch (Exception ex)
        {
            CMensajes.cmetpbFalla(this, "Error en DB... " + ex.getMessage());
        }
        CManipulaDB.cmetpbDesconectaDB(lCNcon);
    }

    /**
     * metpvSTipoEliminacion método que asigna el tipo de eliminación. El
     * parámetro que recibe es:
     *
     * @param lETipo : contiene el tipo de eliminacion (0 es dañada, 1 es
     * asignada en otro caso es sin asignar)
     * @return retorna el tipo de daño
     */
    private String metpvSTipoEliminacion(int lETipo)
    {
        String lSEstado = "";
        if (lETipo == 0)
        {
            lSEstado = "dañada";
        } else if (lETipo == 1)
        {
            lSEstado = "Asignada";
        } else
        {
            lSEstado = "Sin asignar";
        }
        return lSEstado;
    }

    /**
     * metpvLlenaComboBoxUsuarios método que llena el segundo comnobox de
     * usuarios, según el motivo. Los parámetros que recibe son:
     *
     * @param lCNcon : contiene la conexión a la BD
     * @param lSTabla : contiene las tablas donde se contemplan los campos
     * @param lSCondicion : contiene la condición para mostrar los registros
     * @param lSCampos ; contiene los campos que se requieren en el combobox
     * (idusuario, nombre, ap y am)
     */
    private void metpvLlenaComboBoxUsuarios(Connection lCNcon, String lSTabla, String lSCondicion, String lSCampos)
    {

        CQuerys objQuerys = new CQuerys();
        objALCUsuarioTmp = CManipulaDB.cmetpbALCargaDatosUsuario(objQuerys.metpbALSeleccion(lCNcon, lSCampos, lSTabla, lSCondicion));
        try
        {
            for (int lEi = 0; lEi < objALCUsuarioTmp.size(); lEi++)
            {
                objLids.addItem(String.valueOf(objALCUsuarioTmp.get(lEi).getPvEIdUsuario()).trim());
                objCBusuarios.addItem(objALCUsuarioTmp.get(lEi).getPvSNombre().trim() + " " + objALCUsuarioTmp.get(lEi).getPvSApp().trim() + " " + objALCUsuarioTmp.get(lEi).getPvSApm().trim());

            }
        } catch (Exception lEXe)
        {
            //CMensajes.metpbFalla(this, "No hay daños de bailarines.");
            CManipulaInterfaz.cmetpbHabilita(false, objBguardarInventarios);
        }
        CManipulaDB.cmetpbDesconectaDB(lCNcon);
    }

    /**
     * metpvActualizaDanioVestuarioAsignado método que actualiza el campo status
     * de la tabla danios y el campo idinventario de la tabla asignavestuario,
     * con el objetivo de ya no ser mostrados los usuarios con daños y piezas
     * asignadas en el combobox de usuarios. Los parámetros que recibe:
     *
     * @param lSTablas : identifica las tablas a utilizar
     * @param lSCampos : identifica los campos de las tablas
     * @param lSValores: identifica las valores que se le daran a los campos
     * @param lSCondicion : identifica la condición para ejecutar el sql
     */
    private void metpvActualizaDanioVestuarioAsignado(String lSTablas, String lSCampos, String lSValores, String lSCondicion)
    {
        Connection lCNcon = CManipulaDB.cmetpbConectaDB();
        CQuerys objQuerys = new CQuerys();
        String lSResultado = objQuerys.metpbSModificar(lCNcon, lSTablas, lSCampos, lSValores, lSCondicion);
        if (lSResultado == null)
        {
            CMensajes.cmetpbMsj("Se ha actualizado el daño", "Notificación", 3, this);
        } else
        {
            CMensajes.cmetpbMsj(this, "No se pudo actualizar el daño.");
        }
        CManipulaDB.cmetpbDesconectaDB(lCNcon);
    }

    private void metpvEliminarAsignacionInventario(String lSTablas, String lSCampos, String lSCondicion)
    {
        Connection lCNcon = CManipulaDB.cmetpbConectaDB();
        CQuerys objQuerys = new CQuerys();
       
        String lSResul = objQuerys.metpbSDeleteM(lCNcon,lSCampos, lSTablas,lSCondicion);
        if (lSResul == null)
        {
            System.out.println("Se eliminó correctamente la asignación del inventario");
        } else
        {
            System.out.println("No se eliminó la asignación del inventario");
        }
        CManipulaDB.cmetpbDesconectaDB(lCNcon);
    }

    /**
     * metpvEConvertirOpcionNumero método que asigna un número a partir de una
     * cadena. El parámetro que recibe es:
     *
     * @param lETipo : contiene el número de eliminacion (1 es dañada, 2 es
     * asignada en otro caso es sin asignar)
     * @return retorna el número según la cadena
     */
    private int metpvEConvertirOpcionNumero(String lSOpcionComboBoxMotivo)
    {
        int lEOpcion = 0;
        if (lSOpcionComboBoxMotivo.equals("No se pudo reparar el daño"))
        {
            lEOpcion = 1;
        } else if (lSOpcionComboBoxMotivo.equals("La pieza asignada se reporto como perdida"))
        {
            lEOpcion = 2;
        } else
        {
            lEOpcion = 3;
        }
        return lEOpcion;
    }

    /**
     * main() método principal donde se empezará a inicar los métodos del
     * JFrame. El parámetro que recibe es:
     *
     * @param args : indica argumentos
     */
    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                CMotivoEliminacion objAltaVestuarios = new CMotivoEliminacion();
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
    private javax.swing.JComboBox<String> objCBmotivo;
    private javax.swing.JComboBox<String> objCBusuarios;
    private javax.swing.JComboBox<String> objLids;
    private javax.swing.JLabel objLmotivo;
    private javax.swing.JLabel objLusuarios;
    // End of variables declaration//GEN-END:variables
}
