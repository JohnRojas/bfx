/* Nombre de la clase                : CAltaDanios 
 * Descripción de la clase        : Clase donde almacena los componentes visuales para la alta de daños
 * Fecha de creación                 : 15/04/2016 
 * Elaboró                                     : Rojas Simón Jonathan y Hernández Benitez Marvin Atzael 
 * Fecha de Liberación              : - 
 * Autorizó                                    : - 
 * Fecha Mantenimiento           : 09/Mayo/2016 
 * Folio mantenimiento             : 01 
 * Descripción del mantto       : Optimización de las consultas a través de más condiciones de daños a la BD
 * Responsable                          : Rojas Simón Jonathan 
 * Revisor                                    : Hernández Benitez Marvin Atzael 
 */
package bfx.danios;

import bfx.clases.CBailarinTmp;
import bfx.clases.CDanios;
import bfx.controladores.CManipulaDB;
import bfx.controladores.CManipulaInterfaz;
import bfx.controladores.CMensajes;
import bfx.controladores.CPanelFondo;
import bfx.controladores.CQuerys;
import bfx.controladores.CValidaciones;
import java.awt.Event;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 * Interfaz gráfica de usuario para dar del alta un daño
 * @author Techno Engineers
 * @version 1.0
 */
public class CAltaDanios extends javax.swing.JFrame
{

    CDanios objCDanios = new CDanios();
    CPanelFondo objCPanelFondo;
    ImageIcon objImageIcon = new ImageIcon(getClass().getResource("../imagenes/ico.png"));
    Image objImage = objImageIcon.getImage();
    public int pbEIncremento = 0;

    /**
     * CAltaDanios 
     * Constructor que establece los componentes dentro del JFrame e indica la medida y el objCPanelFondo de pantalla de la GUI
     */
    public CAltaDanios()
    {
        initComponents();
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        objCPanelFondo = new CPanelFondo("Registro de daños" , "../imagenes/ballet.png" , 0 , 0 , 569 , 333);
        this.add(objCPanelFondo);
        this.pack();
        this.setSize(569 , 333);
        objCBidusuariosDanios2.setVisible(false);
        
       InputMap objInputMap = objTFmontoDanios.getInputMap(objTFmontoDanios.WHEN_FOCUSED);
        objInputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
               
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        objCBidusuariosDanios = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        objTFmontoDanios = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        objCBidasignavestuarioDanios = new javax.swing.JComboBox();
        objBaceptarDanios = new javax.swing.JButton();
        objBcancelarDanios = new javax.swing.JButton();
        objCBidusuariosDanios2 = new javax.swing.JComboBox();
        fechaEventos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de daños");
        setMaximumSize(new java.awt.Dimension(569, 333));
        setMinimumSize(new java.awt.Dimension(569, 333));
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

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Usuario");

        objCBidusuariosDanios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objCBidusuariosDanios.setToolTipText("");
        objCBidusuariosDanios.setPreferredSize(new java.awt.Dimension(28, 25));
        objCBidusuariosDanios.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                objCBidusuariosDaniosItemStateChanged(evt);
            }
        });
        objCBidusuariosDanios.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objCBidusuariosDaniosKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Monto $");

        objTFmontoDanios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objTFmontoDanios.setEnabled(false);
        objTFmontoDanios.setMaximumSize(new java.awt.Dimension(100, 25));
        objTFmontoDanios.setMinimumSize(new java.awt.Dimension(100, 25));
        objTFmontoDanios.setPreferredSize(new java.awt.Dimension(100, 25));
        objTFmontoDanios.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFmontoDaniosKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFmontoDaniosKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Fecha del último evento");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Asignación de vestuario");

        objCBidasignavestuarioDanios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objCBidasignavestuarioDanios.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona" }));
        objCBidasignavestuarioDanios.setEnabled(false);
        objCBidasignavestuarioDanios.setPreferredSize(new java.awt.Dimension(75, 25));
        objCBidasignavestuarioDanios.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objCBidasignavestuarioDaniosKeyPressed(evt);
            }
        });

        objBaceptarDanios.setBackground(new java.awt.Color(255, 255, 255));
        objBaceptarDanios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objBaceptarDanios.setText("Aceptar");
        objBaceptarDanios.setEnabled(false);
        objBaceptarDanios.setMaximumSize(new java.awt.Dimension(150, 25));
        objBaceptarDanios.setMinimumSize(new java.awt.Dimension(150, 25));
        objBaceptarDanios.setPreferredSize(new java.awt.Dimension(150, 25));
        objBaceptarDanios.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                objBaceptarDaniosActionPerformed(evt);
            }
        });
        objBaceptarDanios.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objBaceptarDaniosKeyPressed(evt);
            }
        });

        objBcancelarDanios.setBackground(new java.awt.Color(255, 255, 255));
        objBcancelarDanios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objBcancelarDanios.setText("Cancelar");
        objBcancelarDanios.setMaximumSize(new java.awt.Dimension(150, 25));
        objBcancelarDanios.setMinimumSize(new java.awt.Dimension(150, 25));
        objBcancelarDanios.setPreferredSize(new java.awt.Dimension(150, 25));
        objBcancelarDanios.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                objBcancelarDaniosActionPerformed(evt);
            }
        });
        objBcancelarDanios.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objBcancelarDaniosKeyPressed(evt);
            }
        });

        objCBidusuariosDanios2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objCBidusuariosDanios2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0" }));
        objCBidusuariosDanios2.setPreferredSize(new java.awt.Dimension(31, 25));

        fechaEventos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(objCBidasignavestuarioDanios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(objCBidusuariosDanios, 0, 382, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(objTFmontoDanios, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fechaEventos, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(78, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(objCBidusuariosDanios2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(objBaceptarDanios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(objBcancelarDanios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(objCBidusuariosDanios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(objTFmontoDanios, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(fechaEventos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(objCBidasignavestuarioDanios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(objBaceptarDanios, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objBcancelarDanios, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(objCBidusuariosDanios2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * aceptarDaniosActionPerformed 
     * Método que establece la inserción de los campos llenados a la BD trajin y actualiza el valor de existencias y piezas dañadas de inventarios a partir de la descripcion del vestuario
     *
     * @param evt es el evento que manipula a cancelarDaniosActionPerformed(evt)
     */
    private void objBaceptarDaniosActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_objBaceptarDaniosActionPerformed
    {//GEN-HEADEREND:event_objBaceptarDaniosActionPerformed

        objCDanios.setpbMesEvento(fechaEventos.getText());
        objCDanios.setpbObjStringFechaEvento(fechaEventos.getText());
        objCDanios.metpbObtenerMesesDeAdeudo();
        objCDanios.metObtenerCamposInsercion();
        String lSTabla = " inventarios, vestuarios ";
        String lSColumnas = " inventarios.piezasdaniadas, inventarios.existencia";
        String lSNvalores = " inventarios.piezasdaniadas+1 , inventarios.existencia-1 ";
        String lSCondicion = " vestuarios.descripcion='" + objCBidasignavestuarioDanios.getSelectedItem().toString().trim() + "' and vestuarios.idvestuario= inventarios.idvestuario ";
        String lSResultado = objCDanios.objCQuerys.metpbSModificar(objCDanios.objConnection, lSTabla, lSColumnas, lSNvalores, lSCondicion);
        if (lSResultado == null)
        {
            JOptionPane.showMessageDialog(this , "Se han actualizado inventarios");
        } else
        {
            CMensajes.cmetpbFalla(this , lSResultado);
        }
        
        ArrayList<Object> objALStatus = objCDanios.objCQuerys.metpbALSeleccion(objCDanios.objConnection, "status", "usuarios", "idusuario="+objCDanios.getpbEIdUsuario());
        
        if (Integer.parseInt(objALStatus.get(0).toString().trim()) > 2)
        {
            objCDanios.objCQuerys.metpbSModificar(objCDanios.objConnection, "usuarios", "status", "4", "idusuario="+objCDanios.getpbEIdUsuario());
        } else
        {
            objCDanios.objCQuerys.metpbSModificar(objCDanios.objConnection, "usuarios", "status", "2", "idusuario="+objCDanios.getpbEIdUsuario());
        }
        
        objBcancelarDaniosActionPerformed(evt);

    }//GEN-LAST:event_objBaceptarDaniosActionPerformed

    /**
     * idusuariosDaniosKeyPressed Método que valida y selecciona el usuario el
     * cual se va a registrar el daño
     *
     * @param evt manipula las acciones de tecleado
     */
    private void objCBidusuariosDaniosKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_objCBidusuariosDaniosKeyPressed
    {//GEN-HEADEREND:event_objCBidusuariosDaniosKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            
            if (objCBidusuariosDanios.getSelectedIndex() == 0)
            {
                CMensajes.cmetpbFalla(this , "Debes de seleccionar una opción válida");
            } else
            {
                objCBidusuariosDaniosItemStateChanged(null);
                CManipulaInterfaz.cmetpbCambia(objTFmontoDanios);
                //montoDanios.setEnabled(true);
            }
        }
    }//GEN-LAST:event_objCBidusuariosDaniosKeyPressed

    /**
     * montoDaniosKeyPressed 
     * Método que valida y selecciona el monto a cobrar del adeudo
     *
     * @param evt controla el cambio de componente y valida que la caja de texto admita numeros decimales
     */
    private void objTFmontoDaniosKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_objTFmontoDaniosKeyPressed
    {//GEN-HEADEREND:event_objTFmontoDaniosKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            if (CManipulaInterfaz.cmetpbRVerificaVacia(objTFmontoDanios))
            {
                CMensajes.cmetpbFalla(this , "Este campo no puede quedar vacío");
            } else
            {
                try
                {
                    if (Double.parseDouble(objTFmontoDanios.getText()) == 0)
                    {
                        CMensajes.cmetpbFalla(this , "El valor del daño debe ser mayor a cero");
                    } else
                    {
                        if (objTFmontoDanios.getText().trim().charAt(0) == '.')
                        {
                            objTFmontoDanios.setText("0" + objTFmontoDanios.getText());
                        }
                        objCDanios.setpbObjDMonto(Double.parseDouble(objTFmontoDanios.getText()));
                        CManipulaInterfaz.cmetpbCambia(objCBidasignavestuarioDanios);
                    }
                } catch (Exception lEXe)
                {
                    CMensajes.cmetpbFalla(this, "Se esperaba una cantidad entera o decimal");
                    objTFmontoDanios.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_objTFmontoDaniosKeyPressed

    /**
     * idasignavestuarioDaniosKeyPressed 
     * Método que permite seleccionar a través del JCombobox la prenda a registrarse como dañada
     *
     * @param evt controla el cambio y selección del componente
     */
    private void objCBidasignavestuarioDaniosKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_objCBidasignavestuarioDaniosKeyPressed
    {//GEN-HEADEREND:event_objCBidasignavestuarioDaniosKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            objCDanios.setpbDescripcion(objCBidasignavestuarioDanios.getSelectedItem().toString().trim());
            objCDanios.metpbObteneridAsignacionVestuario(objCBidasignavestuarioDanios.getSelectedIndex());
            ArrayList<Object> lALRes = objCDanios.objCQuerys.metpbALSeleccion(objCDanios.objConnection, " danio.idusuario, danio.status, danio.idasignavestuario", " danio ", " danio.idusuario=" + objCDanios.getpbEIdUsuario() + " and danio.idasignavestuario=" + objCDanios.getpbEIdAsignacionVestuario() + " and danio.status='1'");
            if (lALRes.isEmpty() || lALRes.get(0).toString().trim().equals(""))
            {
                CManipulaInterfaz.cmetpbCambia(objBaceptarDanios);
            } else
            {
                CMensajes.cmetpbFalla(this , "La prenda o accesorio " + objCBidasignavestuarioDanios.getSelectedItem().toString() + " ya está registrada como daño para el usuario \n \t" + objCBidusuariosDanios.getSelectedItem().toString());
            }
        }
    }//GEN-LAST:event_objCBidasignavestuarioDaniosKeyPressed

    /**
     * montoDaniosKeyTyped 
     * Método que controla que lo introducido en la caja de texto de monto solo admita decimales y verifica que la cadena no exceda de 7 posiciones
     *
     * @param evt es el evento que manipula y restringe el conjunto de acciones solicitadas
     */
    private void objTFmontoDaniosKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_objTFmontoDaniosKeyTyped
    {//GEN-HEADEREND:event_objTFmontoDaniosKeyTyped
        CValidaciones.cmetpbFlotante(evt);
        String lSCadena;
        int lEm = 0;
        for (int lEi = 0 ; lEi < objTFmontoDanios.getText().length() ; lEi++)
        {
            lSCadena = objTFmontoDanios.getText().substring(lEm , lEi + 1);
            if (lSCadena.equals("."))
            {
                if (evt.getKeyChar() == '0' || evt.getKeyChar() == '1' || evt.getKeyChar() == '2' || evt.getKeyChar() == '3' || evt.getKeyChar() == '4'
                        || evt.getKeyChar() == '5' || evt.getKeyChar() == '6' || evt.getKeyChar() == '7' || evt.getKeyChar() == '8' || evt.getKeyChar() == '9')
                {
                    pbEIncremento++;
                }
            }
            if ((lSCadena.equals(".") && evt.getKeyChar() == '.') || (pbEIncremento > 2) || (objTFmontoDanios.getText().length() >= 7))
            {
                evt.consume();
            }
            lEm ++;
        }
        if (objTFmontoDanios.getText().isEmpty())
        {
            pbEIncremento = 0;
        }
    }//GEN-LAST:event_objTFmontoDaniosKeyTyped

    /**
     * cancelarDaniosKeyPressed 
     * Método que reinicia el formulario y ayuda a reestablecer los valores predeterminados
     *
     * @param evt controla el cambio de componente de la GUI
     */
    private void objBcancelarDaniosKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_objBcancelarDaniosKeyPressed
    {//GEN-HEADEREND:event_objBcancelarDaniosKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            objBcancelarDaniosActionPerformed(null);
        }
    }//GEN-LAST:event_objBcancelarDaniosKeyPressed

    /**
     * cancelarDaniosActionPerformed 
     * Método que ayuda a reiniciar todos los componentes de la GUI como si se volviese a abrir la ventana
     *
     * @param evt no tiene funcionalidad en éste método
     */
    private void objBcancelarDaniosActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_objBcancelarDaniosActionPerformed
    {//GEN-HEADEREND:event_objBcancelarDaniosActionPerformed
        CManipulaInterfaz.cmetpbHabilitaObjetos(false, objTFmontoDanios, objCBidasignavestuarioDanios, objBaceptarDanios);

        objCBidusuariosDanios.removeAllItems();
        objCBidasignavestuarioDanios.removeAllItems();
        objCBidusuariosDanios2.removeAllItems();
        objCBidasignavestuarioDanios.addItem("Selecciona");
        objCBidusuariosDanios2.addItem("0");
        formWindowOpened(null);
        objCBidusuariosDanios.requestFocus();
    }//GEN-LAST:event_objBcancelarDaniosActionPerformed

    /**
     * aceptarDaniosKeyPressed 
     * Método que auxilia al método cancelarDaniosActionPerformed para reiniciar todos los componentes de la GUI
     *
     * @param evt verifica que lo introducido sea solo un salto de línea
     */
    private void objBaceptarDaniosKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_objBaceptarDaniosKeyPressed
    {//GEN-HEADEREND:event_objBaceptarDaniosKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            objBaceptarDaniosActionPerformed(null);
        }
    }//GEN-LAST:event_objBaceptarDaniosKeyPressed

    /**
     * formWindowOpened Método que muestra el nombre de los bailarines asignados
     * al evento x en un JCombobox
     *
     * @param evt no tiene función en éste método
     */
    private void formWindowOpened(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowOpened
    {//GEN-HEADEREND:event_formWindowOpened
        objCBidusuariosDanios.addItem("Selecciona");
        CQuerys objCQuerys = new CQuerys();

        ArrayList<CBailarinTmp> lALArrBailarin = CManipulaDB.cmetpbALCargaDatosBailarinEvento(objCQuerys.metpbALSeleccion(objCDanios.objConnection, " distinct usuarios.idusuario,usuarios.nombre,usuarios.apellidopaterno,usuarios.apellidomaterno, eventos.fecha ", " usuarios,bailarinesevento,eventos,cuadroevento,regionesevento,bailesevento ", " eventos.fecha=(select MAX(eventos.fecha) from eventos)  "
                + " and  usuarios.idUsuario = bailarinesevento.idUsuario"
                + " and eventos.ideventos=cuadroevento.idevento "
                + " and cuadroevento.idcuadroevento=regionesevento.idcuadroevento "
                + " and regionesevento.idregionevento=bailesevento.idregionesevento "
                + " and bailesevento.idbailesevento = bailarinesevento.idbailesevento "));
        if (lALArrBailarin == null)
        {
            CMensajes.cmetpbFalla(this, "No hay usuarios que se puedan visualizar");
            this.dispose();
        } else
        {
            for (int lEi = 0 ; lEi < lALArrBailarin.size() ; lEi++)
            {
                objCBidusuariosDanios.addItem(lALArrBailarin.get(lEi).getpbSNombre() + " " + lALArrBailarin.get(lEi).getpbSApp() + " " + lALArrBailarin.get(lEi).getpbSApm());
                objCBidusuariosDanios2.addItem(lALArrBailarin.get(lEi).getpbEIdBailarin());
            }
            fechaEventos.setText(lALArrBailarin.get(0).getpbSFecha());
        }

    }//GEN-LAST:event_formWindowOpened

    private void objCBidusuariosDaniosItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_objCBidusuariosDaniosItemStateChanged
    {//GEN-HEADEREND:event_objCBidusuariosDaniosItemStateChanged
        if (objCBidusuariosDanios.getSelectedIndex() != 0 || objCBidusuariosDanios2.getSelectedItem().toString().isEmpty() != false)
        {
            objCBidusuariosDanios2.setSelectedIndex(objCBidusuariosDanios.getSelectedIndex());
            try
            {
                 objCDanios.setpbIdUsuario(Integer.parseInt(objCBidusuariosDanios2.getSelectedItem().toString()));
            } catch (Exception e)
            {
                System.out.println("Llego aqui");
            }
            objCDanios.obtenerIdBailarinEvento();

            if (objCDanios.getpbJCObjDefaultComboBoxModel() == null)
            {
                CMensajes.cmetpbMsj(this, "No hay vestuarios disponibles del bailarin");
            } else
            {
                //objCDanios.metpbObtenerDescripcionVestuario();
                objCBidasignavestuarioDanios.setModel(objCDanios.getpbJCObjDefaultComboBoxModel());
                //ManipulaInterfaces.cambiar(montoDanios);
            }
        }
    }//GEN-LAST:event_objCBidusuariosDaniosItemStateChanged

    private void formWindowClosed(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosed
    {//GEN-HEADEREND:event_formWindowClosed
        objCDanios.metpbCerrarConexion();
    }//GEN-LAST:event_formWindowClosed

    /**
     * cmetpbMain
     * Método que inicializa la ventana de forma independiente
     * 
     * @param lASArgs the command line arguments
     */
    public static void main(String lASArgs[])
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(CAltaDanios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                CAltaDanios objCAltaDanios = new CAltaDanios();
                objCAltaDanios.setVisible(true);
                ImageIcon objImageIcon = new ImageIcon(getClass().getResource("../imagenes/ico.png"));
                Image objImage = objImageIcon.getImage();
                objCAltaDanios.setIconImage(objImage);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fechaEventos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton objBaceptarDanios;
    private javax.swing.JButton objBcancelarDanios;
    private javax.swing.JComboBox objCBidasignavestuarioDanios;
    private javax.swing.JComboBox objCBidusuariosDanios;
    private javax.swing.JComboBox objCBidusuariosDanios2;
    private javax.swing.JTextField objTFmontoDanios;
    // End of variables declaration//GEN-END:variables
}
