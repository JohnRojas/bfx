/* Nombre de la clase                           : CConsultaDanios 
 * Descripción de la clase                   : Clase que permite manipular la vista de una consulta general y particular de daños
 * Fecha de creación                            : 20/Abril/2016 
 * Elaboró                                                : Rojas Simón Jonathan y Hernández Benitez Marvin Atzael 
 * Fecha de Liberación                         : - 
 * Autorizó                                               : - 
 * Fecha Mantenimiento                      : 09/Mayo/2016 
 * Folio mantenimiento                        : 01 
 * Descripción del mantenimiento   : Optimización de las consultas a través de más condiciones de daños a la BD trajin 
 * Responsable                                     : Rojas Simón Jonathan 
 * Revisor                                               : Mauro Sánchez Sánchez
 */
package bfx.danios;

import bfx.clases.CDanios;
import bfx.clases.CDanios1;
import bfx.controladores.CMensajes;
import bfx.controladores.CPanelFondo;
import bfx.controladores.CValidaciones;
import java.util.Date;
import java.awt.Image;
import java.util.ArrayList;
import java.util.logging.Level;
import javax.swing.ImageIcon;
import java.util.logging.Logger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *  Interfaz gráfica de usuario para consultar daños
 * @author Techno Engineers
 * @version 1.0
 */
public class CConsultaDanios extends javax.swing.JFrame
{

    CDanios objCDanios = new CDanios();
    CPanelFondo objCPanelFondo;
    ImageIcon objImageIcon1 = new ImageIcon(getClass().getResource("../imagenes/ico.png"));
    Image objImage1 = objImageIcon1.getImage();
    public int pbEFila = 0, pbEId = 0;
    public String pbSStatus = "", pbSVestuario="";
    ArrayList<CDanios1> objArrayListDanios1 = objCDanios.metpbALObtenerDanios();
    
    /**
     * CConsultaDanios Es el constructor que establece los componentes de la GUI
     * en un JFrame y establece las medidas del fondo de la GUI
     */
    public CConsultaDanios()
    {
        initComponents();
        DefaultTableModel objDefaultTableModel1 = (DefaultTableModel) objTdanios.getModel();
   
//        objBmodificar.setVisible(false);
//        objBeliminar.setVisible(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        objCPanelFondo = new CPanelFondo("Consulta de daños" , "../imagenes/ballet.png" , 0 , 0 , 780 , 485);
        this.add(objCPanelFondo);
        this.pack();
        this.setSize(780 , 485);

        if (objArrayListDanios1 == null)
        {
            CMensajes.cmetpbFalla(this, "No hay registros de daños, verifique por favor");
            this.dispose();
        } else
        {
            objRBdaniado.setSelected(true);
            objRBascendente.setSelected(true);
            objTFnombreUsuariosKeyReleased(null);
            metpbModificaMedidasColumnas(8, 0);
        }

        this.setIconImage(objImage1);
    }

    /**
     * metpbModificaMedidasColumnas
     * Método que modifica las medidas de la vista de la tabla
     *
     * @param lEIndex establece la columna a modificar
     * @param lEMedida ayuda a establecer la medida
     */
    public void metpbModificaMedidasColumnas(int lEIndex , int lEMedida)
    {
        
        objTdanios.getColumnModel().getColumn(lEIndex).setMaxWidth(lEMedida);
        objTdanios.getColumnModel().getColumn(lEIndex).setMinWidth(lEMedida);
        objTdanios.getColumnModel().getColumn(lEIndex).setPreferredWidth(lEMedida);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        bGfechas = new javax.swing.ButtonGroup();
        bGstatus = new javax.swing.ButtonGroup();
        objLnombreBailarin = new javax.swing.JLabel();
        objTFnombreUsuarios = new javax.swing.JTextField();
        objSPtabla = new javax.swing.JScrollPane();
        objTdanios = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex, int colIndex)
            {
                return false; //Disallow the editing of any cell
            }
        };
        objTdanios = new javax.swing.JTable();
        objBregresar = new javax.swing.JButton();
        objPfechas = new javax.swing.JPanel();
        objRBdescendente = new javax.swing.JRadioButton();
        objRBascendente = new javax.swing.JRadioButton();
        objPstatus = new javax.swing.JPanel();
        objRBdaniado = new javax.swing.JRadioButton();
        objRBreparado = new javax.swing.JRadioButton();
        objRBdadoBaja = new javax.swing.JRadioButton();
        objBmodificar = new javax.swing.JButton();
        objBeliminar = new javax.swing.JButton();
        objSPtextArea = new javax.swing.JScrollPane();
        objTAdesglose = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de daños");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosed(java.awt.event.WindowEvent evt)
            {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt)
            {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        objLnombreBailarin.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objLnombreBailarin.setText("Nombre del bailarín");
        getContentPane().add(objLnombreBailarin);
        objLnombreBailarin.setBounds(40, 37, 109, 15);

        objTFnombreUsuarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objTFnombreUsuarios.setPreferredSize(new java.awt.Dimension(6, 25));
        objTFnombreUsuarios.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                objTFnombreUsuariosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFnombreUsuariosKeyTyped(evt);
            }
        });
        getContentPane().add(objTFnombreUsuarios);
        objTFnombreUsuarios.setBounds(167, 32, 150, 25);

        objTdanios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objTdanios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Id", "Nombre", "AP", "AM", "Prenda", "Status", "Monto", "Fecha evento", "Fecha pago"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        objTdanios.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                objTdaniosMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt)
            {
                objTdaniosMouseReleased(evt);
            }
        });
        objSPtabla.setViewportView(objTdanios);

        getContentPane().add(objSPtabla);
        objSPtabla.setBounds(40, 224, 700, 161);

        objBregresar.setBackground(new java.awt.Color(255, 255, 255));
        objBregresar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objBregresar.setText("Regresar");
        objBregresar.setPreferredSize(new java.awt.Dimension(91, 25));
        objBregresar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                objBregresarActionPerformed(evt);
            }
        });
        getContentPane().add(objBregresar);
        objBregresar.setBounds(40, 410, 150, 25);

        objPfechas.setBackground(new java.awt.Color(255, 255, 255));
        objPfechas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fechas", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N
        objPfechas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        objRBdescendente.setBackground(new java.awt.Color(255, 255, 255));
        bGfechas.add(objRBdescendente);
        objRBdescendente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objRBdescendente.setText("Descendente");
        objRBdescendente.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                objRBdescendenteMouseClicked(evt);
            }
        });

        objRBascendente.setBackground(new java.awt.Color(255, 255, 255));
        bGfechas.add(objRBascendente);
        objRBascendente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objRBascendente.setText("Ascendente");
        objRBascendente.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                objRBascendenteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout objPfechasLayout = new javax.swing.GroupLayout(objPfechas);
        objPfechas.setLayout(objPfechasLayout);
        objPfechasLayout.setHorizontalGroup(
            objPfechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(objPfechasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(objPfechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(objRBascendente)
                    .addComponent(objRBdescendente))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        objPfechasLayout.setVerticalGroup(
            objPfechasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, objPfechasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(objRBascendente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(objRBdescendente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(objPfechas);
        objPfechas.setBounds(40, 100, 136, 100);

        objPstatus.setBackground(new java.awt.Color(255, 255, 255));
        objPstatus.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Status", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N
        objPstatus.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        objRBdaniado.setBackground(new java.awt.Color(255, 255, 255));
        bGstatus.add(objRBdaniado);
        objRBdaniado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objRBdaniado.setText("Dañado");
        objRBdaniado.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                objRBdaniadoMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt)
            {
                objRBdaniadoMouseReleased(evt);
            }
        });

        objRBreparado.setBackground(new java.awt.Color(255, 255, 255));
        bGstatus.add(objRBreparado);
        objRBreparado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objRBreparado.setText("Reparado");
        objRBreparado.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                objRBreparadoMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt)
            {
                objRBreparadoMouseReleased(evt);
            }
        });

        bGstatus.add(objRBdadoBaja);
        objRBdadoBaja.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objRBdadoBaja.setText("Dado de baja");
        objRBdadoBaja.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                objRBdadoBajaMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt)
            {
                objRBdadoBajaMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout objPstatusLayout = new javax.swing.GroupLayout(objPstatus);
        objPstatus.setLayout(objPstatusLayout);
        objPstatusLayout.setHorizontalGroup(
            objPstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(objPstatusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(objPstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(objRBdaniado)
                    .addComponent(objRBreparado))
                .addGap(18, 18, 18)
                .addComponent(objRBdadoBaja)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        objPstatusLayout.setVerticalGroup(
            objPstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(objPstatusLayout.createSequentialGroup()
                .addGroup(objPstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(objPstatusLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(objRBdaniado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(objRBreparado))
                    .addGroup(objPstatusLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(objRBdadoBaja)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(objPstatus);
        objPstatus.setBounds(205, 100, 220, 100);

        objBmodificar.setBackground(new java.awt.Color(255, 255, 255));
        objBmodificar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objBmodificar.setText("Modificar registro");
        objBmodificar.setEnabled(false);
        objBmodificar.setPreferredSize(new java.awt.Dimension(91, 25));
        objBmodificar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                objBmodificarActionPerformed(evt);
            }
        });
        getContentPane().add(objBmodificar);
        objBmodificar.setBounds(310, 410, 150, 25);

        objBeliminar.setBackground(new java.awt.Color(255, 255, 255));
        objBeliminar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objBeliminar.setText("Eliminar registro");
        objBeliminar.setEnabled(false);
        objBeliminar.setPreferredSize(new java.awt.Dimension(123, 25));
        objBeliminar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                objBeliminarActionPerformed(evt);
            }
        });
        getContentPane().add(objBeliminar);
        objBeliminar.setBounds(610, 410, 150, 25);

        objTAdesglose.setEditable(false);
        objTAdesglose.setColumns(20);
        objTAdesglose.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objTAdesglose.setRows(8);
        objTAdesglose.setText("Ningún registro seleccionado");
        objTAdesglose.setToolTipText("");
        objSPtextArea.setViewportView(objTAdesglose);

        getContentPane().add(objSPtextArea);
        objSPtextArea.setBounds(530, 50, 210, 160);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * nombreUsuariosKeyTyped 
     * Método que ayuda a validar que la caja de texto admita solamente cadenas
     *
     * @param evt es el evento que manipula la acción de tecleado
     */
    private void objTFnombreUsuariosKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_objTFnombreUsuariosKeyTyped
    {//GEN-HEADEREND:event_objTFnombreUsuariosKeyTyped
        
        CValidaciones.cmetpbAlfabetico(evt);
        if (objRBdaniado.isSelected())
        {
            metpbModificaMedidasColumnas(8,0);
        }
        
    }//GEN-LAST:event_objTFnombreUsuariosKeyTyped

    /**
     * nombreUsuariosKeyReleased 
     * Método que establece el modelo de la tabla jTable1 dentro de la GUI y permite realizar una consulta a la BD
     *
     * @param evt es el evento que maneja el cambio de reistros
     */
    private void objTFnombreUsuariosKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_objTFnombreUsuariosKeyReleased
    {//GEN-HEADEREND:event_objTFnombreUsuariosKeyReleased
  
        if (objArrayListDanios1 == null)
        {
            this.dispose();
        } else
        {
            objCDanios.setpbObjStringNombre(objTFnombreUsuarios.getText().trim());
            this.metpbMuestraDatos();          
        }

    }//GEN-LAST:event_objTFnombreUsuariosKeyReleased

    /**
     * jButton1ActionPerformed 
     * Método que permite salirse de la vista de la ventana de ésta clase
     *
     * @param evt no tiene función en éste método
     */
    private void objBregresarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_objBregresarActionPerformed
    {//GEN-HEADEREND:event_objBregresarActionPerformed
        
        this.dispose();
        
    }//GEN-LAST:event_objBregresarActionPerformed

    /**
     * objjRadioButtonAscendenteMouseClicked 
     * Método que ayuda a establecer un filtro de fechas ascendente a la BD trajin
     *
     * @param evt no tiene función en éste método
     */
    private void objRBascendenteMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_objRBascendenteMouseClicked
    {//GEN-HEADEREND:event_objRBascendenteMouseClicked
        
        metpbOrdenamientoBurbujaFechas(objRBascendente.getText());
        objTFnombreUsuariosKeyReleased(null);
        if (objRBdaniado.isSelected())
        {
            metpbModificaMedidasColumnas(8 , 0);
        }
        
    }//GEN-LAST:event_objRBascendenteMouseClicked

    /**
     * objjRadioButtonDescendenteMouseClicked 
     * Método que ayuda a establecer un filtro de fechas descendente a la BD trajin
     *
     * @param evt no tiene función en éste método
     */
    private void objRBdescendenteMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_objRBdescendenteMouseClicked
    {//GEN-HEADEREND:event_objRBdescendenteMouseClicked

        metpbOrdenamientoBurbujaFechas(objRBdescendente.getText());
        objTFnombreUsuariosKeyReleased(null);
        
    }//GEN-LAST:event_objRBdescendenteMouseClicked

    /**
     * objjRadioButtonDaniadoMouseClicked
     * Método que permite establecer un filtro de búsqueda de prendas o accesorios dañados a través del status
     *
     * @param evt no tiene función en éste método
     */
    private void objRBdaniadoMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_objRBdaniadoMouseClicked
    {//GEN-HEADEREND:event_objRBdaniadoMouseClicked
        
        metpbReestablecerBotones(false);
        
        objCDanios.setpbObjCStatus('1');
        objTFnombreUsuariosKeyReleased(null);
        metpbModificaMedidasColumnas(8 , 0);
        if (objTdanios.getRowCount() == 0)
        {
            CMensajes.cmetpbFalla(this, "No hay registros de prendas o accesorios dañados");
        }
        
    }//GEN-LAST:event_objRBdaniadoMouseClicked

    /**
     * objjRadioButtonReparadoMouseClicked 
     * Método que permite establecer un filtro de búsqueda de prendas o accesorios reparados a través del status
     *
     * @param evt no tiene función en ést método
     */
    private void objRBreparadoMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_objRBreparadoMouseClicked
    {//GEN-HEADEREND:event_objRBreparadoMouseClicked
        metpbReestablecerBotones(false);

        objCDanios.setpbObjCStatus('0');
        objTFnombreUsuariosKeyReleased(null);
        if (objTdanios.getRowCount() == 0)
        {
            CMensajes.cmetpbFalla(this, "No hay registros de prendas o accesorios reparados");
        }
        
    }//GEN-LAST:event_objRBreparadoMouseClicked

    /**
     * formWindowClosed 
     * Método que engloba a metpbCerrarConexion() que permite cerrar la conexión a la BD trajin
     *
     * @param evt no tiene función específica en este momento
     */
    private void formWindowClosed(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosed
    {//GEN-HEADEREND:event_formWindowClosed
        
        objCDanios.metpbCerrarConexion();
        
    }//GEN-LAST:event_formWindowClosed

    /**
     * objDaniosMouseClicked
     * Metodo que establece el valor del pbEId del daño
     *
     * @param evt es la variable que manipula el cambio de la impresión del pbEId
     */
    private void objTdaniosMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_objTdaniosMouseClicked
    {//GEN-HEADEREND:event_objTdaniosMouseClicked
        
        pbEFila = objTdanios.rowAtPoint(evt.getPoint());
        pbEId = Integer.parseInt(objTdanios.getValueAt(pbEFila , 0).toString());
        pbSStatus = objTdanios.getValueAt(pbEFila , 5).toString();
        pbSVestuario = objTdanios.getValueAt(pbEFila , 4).toString();
        
        if (objRBdaniado.isSelected())
        {
            metpbReestablecerBotones(true);
        } else if(objRBreparado.isSelected())
        {
            metpbReestablecerBotones(true);
        }
        
        objTAdesglose.setText("Nombre: " + objTdanios.getValueAt(pbEFila , 1).toString() + "\n"
                + "A Paterno: " + objTdanios.getValueAt(pbEFila , 2).toString() + "\n"
                + "A Materno: " + objTdanios.getValueAt(pbEFila , 3).toString() + "\n"
                + "Vestuario: " + pbSVestuario +"\n"
                + "Status: " + pbSStatus + "\n"
                + "Monto: " + objTdanios.getValueAt(pbEFila , 6).toString() + "\n"
                + "Fecha Evento: " + objTdanios.getValueAt(pbEFila , 7).toString() + "\n"
                + "Fecha Pago: " + objTdanios.getValueAt(pbEFila , 8).toString() + "\n"
        );
        
    }//GEN-LAST:event_objTdaniosMouseClicked

    /**
     * objDaniosMouseClicked
     * Método que invoca a la ventana de modificación de daños
     * 
     * @param evt no tiene función en éste método
     */
    private void objBmodificarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_objBmodificarActionPerformed
    {//GEN-HEADEREND:event_objBmodificarActionPerformed
        
        CModificaDanios objCModificaDanios = new CModificaDanios(Integer.parseInt(objTdanios.getValueAt(pbEFila , 0).toString()));
        objCModificaDanios.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_objBmodificarActionPerformed

    /**
     * formWindowOpened
     * Método que establece al jTable en selección simple y también cierra por si sola cuando no se encuentran registros de daños
     * 
     * @param evt no tiene función en éste método 
     */
    private void formWindowOpened(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowOpened
    {//GEN-HEADEREND:event_formWindowOpened

        if (objArrayListDanios1 == null)
        {
            this.dispose();
        }else
        {
            objTdanios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }
        
    }//GEN-LAST:event_formWindowOpened

    /**
     * jBEliminarActionPerformed
     * Método que permite eliminar registros de daños
     * 
     * @param evt no tiene función en éste método
     */
    private void objBeliminarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_objBeliminarActionPerformed
    {//GEN-HEADEREND:event_objBeliminarActionPerformed
        int lEResultado =CMensajes.cmetpbEPregunta("¿Desea eliminar el registro seleccionado?" , "Confirmar eliminación" , this);
        System.out.println(lEResultado);
        if (lEResultado==0)
        {
            String lSResultado = objCDanios.objCQuerys.metpbSDelete(objCDanios.objConnection, "danio", "iddanio", String.valueOf(pbEId));
            if (lSResultado == null)
            {
                CMensajes.cmetpbExito(this);
                                
                if (pbSStatus.trim().equals("Dañado"))
                {
                    objCDanios.objCQuerys.metpbSModificar(objCDanios.objConnection, " inventarios , vestuarios "
                            ,  "inventarios.piezasdaniadas, inventarios.existencia"
                            , " inventarios.piezasdaniadas - 1 , inventarios.existencia + 1 " 
                            , " vestuarios.descripcion='" + pbSVestuario + "' and vestuarios.idvestuario= inventarios.idvestuario ");
                    CMensajes.cmetpbFalla(this, "Se han actualizado inventarios");
                }
                
                for (int lEI = 0; lEI < objArrayListDanios1.size(); lEI++)
                {
                    if (objArrayListDanios1.get(lEI).getpbEIdDanio() == pbEId)
                    {
                        objArrayListDanios1.get(lEI).setpbIdDanio(0);
                        objTFnombreUsuariosKeyReleased(null);
                    }
                }
                
                objTAdesglose.setText("Ningún registro seleccionado");
                
            } else
            {
                CMensajes.cmetpbFalla(this, "No se pudo eliminar el registro, verifique por favor");
            }
        } else if (lEResultado == 1 || lEResultado == -1)
        {
            CMensajes.cmetpbFalla(this, "Eliminación cancelada");
        }
        
        if (objRBdaniado.isSelected())
        {
            objRBdaniadoMouseClicked(null);
        } else if(objRBreparado.isSelected())
        {
            objRBreparadoMouseClicked(null);
        }
        
    }//GEN-LAST:event_objBeliminarActionPerformed

    /**
     * objjRadioButtonDaniadoMouseReleased
     * Método para auxiliar al mouse clicked para que el radiobutton cambie
     * 
     * @param evt no tiene función en éste método
     */
    private void objRBdaniadoMouseReleased(java.awt.event.MouseEvent evt)//GEN-FIRST:event_objRBdaniadoMouseReleased
    {//GEN-HEADEREND:event_objRBdaniadoMouseReleased
        objRBdaniadoMouseClicked(null);
    }//GEN-LAST:event_objRBdaniadoMouseReleased

    /**
     * objjRadioButtonReparadoMouseReleased
     * Método para auxiliar al mouse clicked para que el radiobutton cambie
     * 
     * @param evt no tiene función en éste método
     */
    private void objRBreparadoMouseReleased(java.awt.event.MouseEvent evt)//GEN-FIRST:event_objRBreparadoMouseReleased
    {//GEN-HEADEREND:event_objRBreparadoMouseReleased
        objRBreparadoMouseClicked(null);
    }//GEN-LAST:event_objRBreparadoMouseReleased

    /**
     * objRBdadoBajaMouseClicked
     * Método para establecer los registros que fueron dados de baja
     * 
     * @param evt no tiene función en éste método
     */
    private void objRBdadoBajaMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_objRBdadoBajaMouseClicked
    {//GEN-HEADEREND:event_objRBdadoBajaMouseClicked

        metpbReestablecerBotones(false);
        
         objCDanios.setpbObjCStatus('2');
        objTFnombreUsuariosKeyReleased(null);
        metpbModificaMedidasColumnas(8 , 0);
        if (objTdanios.getRowCount() == 0)
        {
            CMensajes.cmetpbFalla(this, "No hay registros de prendas o accesorios dados de baja");
        }
     
    }//GEN-LAST:event_objRBdadoBajaMouseClicked

    /**
     * objRBdadoBajaMouseReleased
     * Método para reaccionar el radiobutton de forma más sencible
     * 
     * @param evt no tiene función en éste método
     */
    private void objRBdadoBajaMouseReleased(java.awt.event.MouseEvent evt)//GEN-FIRST:event_objRBdadoBajaMouseReleased
    {//GEN-HEADEREND:event_objRBdadoBajaMouseReleased
         objRBdadoBajaMouseClicked(null);
    }//GEN-LAST:event_objRBdadoBajaMouseReleased

    /**
     * objTdaniosMouseReleased
     * Método para establecer el cambio de selección del registro, funciona cuando se hace clic en el registro y cuando se suelta el clic
     * 
     * @param evt controla el cambio de registro
     */
    private void objTdaniosMouseReleased(java.awt.event.MouseEvent evt)//GEN-FIRST:event_objTdaniosMouseReleased
    {//GEN-HEADEREND:event_objTdaniosMouseReleased
        objTdaniosMouseClicked(evt);
    }//GEN-LAST:event_objTdaniosMouseReleased

    /**
     * metpbMuestraDatos
     * Método que realiza la búsqueda por filtros (status , nombre) en base al manejo de memoria
     */
    public void metpbMuestraDatos()
    {
        DefaultTableModel objDefaultTableModel = (DefaultTableModel) objTdanios.getModel();
        
        int lEFilas = objTdanios.getRowCount() -1;
        for (int lEI = lEFilas ; lEI >=0 ; lEI --)
        {
            objDefaultTableModel.removeRow(lEI);
        }

        objDefaultTableModel = (DefaultTableModel) objTdanios.getModel();
        
        Object[] objObject = new Object[objDefaultTableModel.getColumnCount()];

        for (int lEi = 0 ; lEi < objArrayListDanios1.size() ; lEi ++)
        {
            if (objArrayListDanios1.get(lEi).getpbSNombre().contains(objCDanios.getpbSObjStringNombre()) && objArrayListDanios1.get(lEi).getpbCStatus() == objCDanios.getpbCObjCStatus() && objArrayListDanios1.get(lEi).getpbEIdDanio() != 0)
            {
                objObject[0] = objArrayListDanios1.get(lEi).getpbEIdDanio();
                objObject[1] = objArrayListDanios1.get(lEi).getpbSNombre();
                objObject[2] = objArrayListDanios1.get(lEi).getpbSApaterno();
                objObject[3] = objArrayListDanios1.get(lEi).getpbSAmaterno();
                objObject[4] = objArrayListDanios1.get(lEi).getpbSPrenda();
                if (objArrayListDanios1.get(lEi).getpbCStatus() == '1')
                {
                    objObject[5] = "Dañado";
                } else if(objArrayListDanios1.get(lEi).getpbCStatus() == '0')
                {
                    objObject[5] = "Reparado";
                } else /*if(objArrayListDanios1.get(lEI).getpbCStatus() == '2')*/
                {
                    objObject[5] = "Baja";
                }
                objObject[6] = objArrayListDanios1.get(lEi).getpbDMonto();
                objObject[7] = objArrayListDanios1.get(lEi).getpbSFechaEvento();
                if (objArrayListDanios1.get(lEi).getpbSFechadepago().equalsIgnoreCase("null"))
                {
                    objObject[8] = "No pagado";
                } else
                {
                    objObject[8] = objArrayListDanios1.get(lEi).getpbSFechadepago();
                }

                objDefaultTableModel.addRow(objObject);

            }

        }
        objTdanios.setModel(objDefaultTableModel);
        metpbModificaMedidasColumnas(0 , 0);
        if (objRBdaniado.isSelected())
        {
            metpbModificaMedidasColumnas(8, 0);
        }

    }

    /**
     * metpbOrdenamientoBurbujaFechas
     * Método que ordena el arraylist de daños con el algoritmo burbuja
     *
     * @param lSOrden especifica el ordenamiento de los datos por fecha (ascendente, descendente)
     */
    public void metpbOrdenamientoBurbujaFechas(String lSOrden)
    {
        CDanios1 objCDanios1 = new CDanios1(0 , "" , "" , "" , "" , ' ' , 0 , "" , "");

        SimpleDateFormat objSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date objDate1 = null, objDate2 = null;
        if (lSOrden.equals("Ascendente"))
        {
            for (int lEi = 1 ; lEi < objArrayListDanios1.size() ; lEi ++)
            {
                for (int lEj = 0 ; lEj < objArrayListDanios1.size() - 1 ; lEj ++)
                {
                    try
                    {
                        objDate1 = (Date) objSimpleDateFormat.parse(objArrayListDanios1.get(lEj).getpbSFechaEvento());
                        objDate2 = (Date) objSimpleDateFormat.parse(objArrayListDanios1.get(lEj + 1).getpbSFechaEvento());
                    } catch (ParseException lPEEx)
                    {
                        Logger.getLogger(CConsultaDanios.class.getName()).log(Level.SEVERE , null , lPEEx);
                    }
                    if (objDate1.compareTo(objDate2) > 0)
                    {
                        objCDanios1.setpbIdDanio(objArrayListDanios1.get(lEj).getpbEIdDanio());
                        objCDanios1.setpbNombre(objArrayListDanios1.get(lEj).getpbSNombre());
                        objCDanios1.setpbApaterno(objArrayListDanios1.get(lEj).getpbSApaterno());
                        objCDanios1.setpbAmaterno(objArrayListDanios1.get(lEj).getpbSAmaterno());
                        objCDanios1.setpbPrenda(objArrayListDanios1.get(lEj).getpbSPrenda());
                        objCDanios1.setpbStatus(objArrayListDanios1.get(lEj).getpbCStatus());
                        objCDanios1.setpbMonto(objArrayListDanios1.get(lEj).getpbDMonto());
                        objCDanios1.setpbFechaEvento(objArrayListDanios1.get(lEj).getpbSFechaEvento());
                        objCDanios1.setpbFechadepago(objArrayListDanios1.get(lEj).getpbSFechadepago());
                        objArrayListDanios1.get(lEj).setpbIdDanio(objArrayListDanios1.get(lEj + 1).getpbEIdDanio());
                        objArrayListDanios1.get(lEj).setpbNombre(objArrayListDanios1.get(lEj + 1).getpbSNombre());
                        objArrayListDanios1.get(lEj).setpbApaterno(objArrayListDanios1.get(lEj + 1).getpbSApaterno());
                        objArrayListDanios1.get(lEj).setpbAmaterno(objArrayListDanios1.get(lEj + 1).getpbSAmaterno());
                        objArrayListDanios1.get(lEj).setpbPrenda(objArrayListDanios1.get(lEj + 1).getpbSPrenda());
                        objArrayListDanios1.get(lEj).setpbStatus(objArrayListDanios1.get(lEj + 1).getpbCStatus());
                        objArrayListDanios1.get(lEj).setpbMonto(objArrayListDanios1.get(lEj + 1).getpbDMonto());
                        objArrayListDanios1.get(lEj).setpbFechaEvento(objArrayListDanios1.get(lEj + 1).getpbSFechaEvento());
                        objArrayListDanios1.get(lEj).setpbFechadepago(objArrayListDanios1.get(lEj + 1).getpbSFechadepago());
                        objArrayListDanios1.get(lEj + 1).setpbIdDanio(objCDanios1.getpbEIdDanio());
                        objArrayListDanios1.get(lEj + 1).setpbNombre(objCDanios1.getpbSNombre());
                        objArrayListDanios1.get(lEj + 1).setpbApaterno(objCDanios1.getpbSApaterno());
                        objArrayListDanios1.get(lEj + 1).setpbAmaterno(objCDanios1.getpbSAmaterno());
                        objArrayListDanios1.get(lEj + 1).setpbPrenda(objCDanios1.getpbSPrenda());
                        objArrayListDanios1.get(lEj + 1).setpbStatus(objCDanios1.getpbCStatus());
                        objArrayListDanios1.get(lEj + 1).setpbMonto(objCDanios1.getpbDMonto());
                        objArrayListDanios1.get(lEj + 1).setpbFechaEvento(objCDanios1.getpbSFechaEvento());
                        objArrayListDanios1.get(lEj + 1).setpbFechadepago(objCDanios1.getpbSFechadepago());
                    }
                }

            }
        } else if (lSOrden.equals("Descendente"))
        {
            for (int lEi = 1 ; lEi < objArrayListDanios1.size() ; lEi ++)
            {
                for (int lEj = 0 ; lEj < objArrayListDanios1.size() - 1 ; lEj ++)
                {
                    try
                    {
                        objDate1 = (Date) objSimpleDateFormat.parse(objArrayListDanios1.get(lEj).getpbSFechaEvento());
                        objDate2 = (Date) objSimpleDateFormat.parse(objArrayListDanios1.get(lEj + 1).getpbSFechaEvento());
                    } catch (ParseException lPEEx)
                    {
                        Logger.getLogger(CConsultaDanios.class.getName()).log(Level.SEVERE, null, lPEEx);
                    }
                    if (objDate1.compareTo(objDate2) < 0)
                    {
                        objCDanios1.setpbIdDanio(objArrayListDanios1.get(lEj).getpbEIdDanio());
                        objCDanios1.setpbNombre(objArrayListDanios1.get(lEj).getpbSNombre());
                        objCDanios1.setpbApaterno(objArrayListDanios1.get(lEj).getpbSApaterno());
                        objCDanios1.setpbAmaterno(objArrayListDanios1.get(lEj).getpbSAmaterno());
                        objCDanios1.setpbPrenda(objArrayListDanios1.get(lEj).getpbSPrenda());
                        objCDanios1.setpbStatus(objArrayListDanios1.get(lEj).getpbCStatus());
                        objCDanios1.setpbMonto(objArrayListDanios1.get(lEj).getpbDMonto());
                        objCDanios1.setpbFechaEvento(objArrayListDanios1.get(lEj).getpbSFechaEvento());
                        objCDanios1.setpbFechadepago(objArrayListDanios1.get(lEj).getpbSFechadepago());
                        objArrayListDanios1.get(lEj).setpbIdDanio(objArrayListDanios1.get(lEj + 1).getpbEIdDanio());
                        objArrayListDanios1.get(lEj).setpbNombre(objArrayListDanios1.get(lEj + 1).getpbSNombre());
                        objArrayListDanios1.get(lEj).setpbApaterno(objArrayListDanios1.get(lEj + 1).getpbSApaterno());
                        objArrayListDanios1.get(lEj).setpbAmaterno(objArrayListDanios1.get(lEj + 1).getpbSAmaterno());
                        objArrayListDanios1.get(lEj).setpbPrenda(objArrayListDanios1.get(lEj + 1).getpbSPrenda());
                        objArrayListDanios1.get(lEj).setpbStatus(objArrayListDanios1.get(lEj + 1).getpbCStatus());
                        objArrayListDanios1.get(lEj).setpbMonto(objArrayListDanios1.get(lEj + 1).getpbDMonto());
                        objArrayListDanios1.get(lEj).setpbFechaEvento(objArrayListDanios1.get(lEj + 1).getpbSFechaEvento());
                        objArrayListDanios1.get(lEj).setpbFechadepago(objArrayListDanios1.get(lEj + 1).getpbSFechadepago());
                        objArrayListDanios1.get(lEj + 1).setpbIdDanio(objCDanios1.getpbEIdDanio());
                        objArrayListDanios1.get(lEj + 1).setpbNombre(objCDanios1.getpbSNombre());
                        objArrayListDanios1.get(lEj + 1).setpbApaterno(objCDanios1.getpbSApaterno());
                        objArrayListDanios1.get(lEj + 1).setpbAmaterno(objCDanios1.getpbSAmaterno());
                        objArrayListDanios1.get(lEj + 1).setpbPrenda(objCDanios1.getpbSPrenda());
                        objArrayListDanios1.get(lEj + 1).setpbStatus(objCDanios1.getpbCStatus());
                        objArrayListDanios1.get(lEj + 1).setpbMonto(objCDanios1.getpbDMonto());
                        objArrayListDanios1.get(lEj + 1).setpbFechaEvento(objCDanios1.getpbSFechaEvento());
                        objArrayListDanios1.get(lEj + 1).setpbFechadepago(objCDanios1.getpbSFechadepago());
                    }
                }

            }
        }
    }
    
    /**
     * metpbReestablecerBotones
     * Método para habilitar o inabilitar botones, además reestablece el JTextArea del desglose de datos
     * 
     * @param lBBandera variable que establece el valor booleano para habilitar componentes
     */
    public void metpbReestablecerBotones(boolean lBBandera)
    {
        objBeliminar.setEnabled(lBBandera);
        objBmodificar.setEnabled(lBBandera);
        objTAdesglose.setText("Ningún registro seleccionado");
    }

    /**
     * cmetpbMain
     * Método para incializar el componente por si solo
     * 
     * @param lSArgs the command line arguments
     */
    public static void main(String lSArgs[])
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
            java.util.logging.Logger.getLogger(CConsultaDanios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(CConsultaDanios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(CConsultaDanios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(CConsultaDanios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                CConsultaDanios objCConsultaDanios = new CConsultaDanios();
                objCConsultaDanios.setLocationRelativeTo(null);
                objCConsultaDanios.setVisible(true);
                ImageIcon objImageIcon = new ImageIcon(getClass().getResource("../imagenes/ico.png"));
                Image objImage = objImageIcon.getImage();
                objCConsultaDanios.setIconImage(objImage);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bGfechas;
    private javax.swing.ButtonGroup bGstatus;
    private javax.swing.JButton objBeliminar;
    private javax.swing.JButton objBmodificar;
    private javax.swing.JButton objBregresar;
    private javax.swing.JLabel objLnombreBailarin;
    private javax.swing.JPanel objPfechas;
    private javax.swing.JPanel objPstatus;
    private javax.swing.JRadioButton objRBascendente;
    private javax.swing.JRadioButton objRBdadoBaja;
    private javax.swing.JRadioButton objRBdaniado;
    private javax.swing.JRadioButton objRBdescendente;
    private javax.swing.JRadioButton objRBreparado;
    private javax.swing.JScrollPane objSPtabla;
    private javax.swing.JScrollPane objSPtextArea;
    private javax.swing.JTextArea objTAdesglose;
    private javax.swing.JTextField objTFnombreUsuarios;
    private javax.swing.JTable objTdanios;
    // End of variables declaration//GEN-END:variables
}
