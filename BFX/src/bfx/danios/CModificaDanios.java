/* Nombre de la clase                               : CDanios 
 * Descripción de la clase                       : Clase que permite manipular la operaciones del modelo de negocio del módulo de daños 
 * Fecha de creación                                : 15/Abril/2016 
 * Elaboró                                                    : Rojas Simón Jonathan y Hernández Benitez Marvin Atzael 
 * Fecha de Liberación                             : - 
 * Autorizó                                                   : - 
 * Fecha Mantenimiento                           : 09/Mayo/2016 
 * Folio mantenimiento                             : 01 
 * Descripción del mantenimiento        : Optimización de las consultas a través de más condiciones de daños a la BD trajin 
 * Responsable                                          : Rojas Simón Jonathan 
 * Revisor                                                    : Mauro Sánchez Sánchez
 */
package bfx.danios;

import bfx.clases.CDanios;
import bfx.controladores.CManipulaInterfaz;
//import static bfx.controladores.*;
import bfx.controladores.CMensajes;
import bfx.controladores.CPanelFondo;
import bfx.controladores.CValidaciones;
import javax.swing.ImageIcon;
import java.awt.Image;

/**
 * Interfaz gráfica de usuario para dar del alta un daño
 * @author Techno Engineers
 * @version 1.0
 */
public class CModificaDanios extends javax.swing.JFrame
{
    public int pbEIdUsuario = 0;
    CDanios objCDanios = new CDanios();
    CPanelFondo objCPanelFondo;
    ImageIcon objImageIcon1 = new ImageIcon(getClass().getResource("../imagenes/ico.png"));
    Image objImage1 = objImageIcon1.getImage();
    public int pbEIncremento = 0;

    /**
     * CAltaDanios Constructor que establece los componentes dentro del JFrame e indica la medida y el objCPanelFondo de pantalla de la GUI
     *
     * @param pEIdUsuario que toma el identificador del daño para realizar una modificación
     */
    public CModificaDanios(int pEIdUsuario)
    {
        initComponents();
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        objCPanelFondo = new CPanelFondo("Modificación de daños", "../imagenes/ballet.png", 0, 0, 569, 333);
        this.add(objCPanelFondo);
        this.pack();
        this.setSize(569, 333);
        this.pbEIdUsuario = pEIdUsuario;
        
                
        
//        ImageIcon objImageIcon2 = new ImageIcon(getClass().getResource("../imagenes/xina.png"));
//        Image objImage2 = objImageIcon2.getImage();
        this.setIconImage(objImage1);
    }

    /**
     * CModificaDanios
     * Contructor vacío
     */
    public CModificaDanios()
    {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        objLusuario = new javax.swing.JLabel();
        objLmonto = new javax.swing.JLabel();
        objTFmontoDanios = new javax.swing.JTextField();
        objLfecha = new javax.swing.JLabel();
        objLasignacion = new javax.swing.JLabel();
        objBaceptarDanios = new javax.swing.JButton();
        objBcancelarDanios = new javax.swing.JButton();
        objLstatus = new javax.swing.JLabel();
        objCBstatusDanio = new javax.swing.JComboBox();
        objLfechaEventos = new javax.swing.JLabel();
        objLidusuariosDanios = new javax.swing.JLabel();
        objLvestuarioDanio = new javax.swing.JLabel();
        objLidusuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificación de daños");
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

        objLusuario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objLusuario.setText("Usuario");

        objLmonto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objLmonto.setText("Monto $");

        objTFmontoDanios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objTFmontoDanios.setPreferredSize(new java.awt.Dimension(6, 25));
        objTFmontoDanios.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                objTFmontoDaniosFocusGained(evt);
            }
        });
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

        objLfecha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objLfecha.setText("Fecha de evento (aaaa-mm-dd)");

        objLasignacion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objLasignacion.setText("Asignación de vestuario");

        objBaceptarDanios.setBackground(new java.awt.Color(255, 255, 255));
        objBaceptarDanios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objBaceptarDanios.setText("Aceptar");
        objBaceptarDanios.setEnabled(false);
        objBaceptarDanios.setPreferredSize(new java.awt.Dimension(91, 25));
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
        objBcancelarDanios.setText("Regresar");
        objBcancelarDanios.setPreferredSize(new java.awt.Dimension(91, 25));
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

        objLstatus.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objLstatus.setText("Status");

        objCBstatusDanio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objCBstatusDanio.setEnabled(false);
        objCBstatusDanio.setMinimumSize(new java.awt.Dimension(72, 25));
        objCBstatusDanio.setPreferredSize(new java.awt.Dimension(90, 25));
        objCBstatusDanio.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objCBstatusDanioKeyPressed(evt);
            }
        });

        objLfechaEventos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        objLidusuariosDanios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        objLvestuarioDanio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(objLidusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objLusuario))
                .addGap(10, 10, 10)
                .addComponent(objLidusuariosDanios, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(objLmonto)
                .addGap(19, 19, 19)
                .addComponent(objTFmontoDanios, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(objLfecha)
                .addGap(10, 10, 10)
                .addComponent(objLfechaEventos, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(objLasignacion)
                .addGap(6, 6, 6)
                .addComponent(objLvestuarioDanio, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(objLstatus)
                .addGap(26, 26, 26)
                .addComponent(objCBstatusDanio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(objBaceptarDanios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(objBcancelarDanios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(objLidusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(objLusuario))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(objLidusuariosDanios, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(objTFmontoDanios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objLfechaEventos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(objLmonto)
                            .addComponent(objLfecha))))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(objLasignacion))
                    .addComponent(objLvestuarioDanio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(objLstatus))
                    .addComponent(objCBstatusDanio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(objBaceptarDanios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objBcancelarDanios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * aceptarDaniosActionPerformed 
     * Método que establece la inserción de los campos llenados a la BD trajin
     *
     * @param evt es el evento que manipula a cancelarDaniosActionPerformed(evt)
     */
    private void objBaceptarDaniosActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_objBaceptarDaniosActionPerformed
    {//GEN-HEADEREND:event_objBaceptarDaniosActionPerformed
        objCDanios.setpbObjDMonto(Double.parseDouble(objTFmontoDanios.getText()));
        if (objCBstatusDanio.getSelectedItem().toString().equals("Dañado"))
        {
            objCDanios.setpbObjCStatus('1');
        }else if (objCBstatusDanio.getSelectedItem().toString().equals("Reparado"))
        {
            objCDanios.setpbObjCStatus('0');
        }
        
//        if (objCBstatusDanio.getSelectedIndex() == 0)
//        {
//             objCDanios.setpbObjCStatus('1');
//        } else
//        {
//            objCDanios.setpbObjCStatus('0');
//        }
        System.out.println(objCDanios.getpbDObjDMonto());
        System.out.println(objCDanios.getpbCObjCStatus());

        objCDanios.metpbModificaDanio(pbEIdUsuario, objLvestuarioDanio.getText().trim());

        objBcancelarDaniosActionPerformed(evt);
    }//GEN-LAST:event_objBaceptarDaniosActionPerformed

    /**
     * montoDaniosKeyPressed 
     * Método que valida y selecciona el monto a cobrar de adeudo
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
                        if (objTFmontoDanios.getText().charAt(0) == '.')
                        {
                            objTFmontoDanios.setText("0" + objTFmontoDanios.getText());
                        }
                        objCDanios.setpbObjDMonto(Double.parseDouble(objTFmontoDanios.getText()));
                        CManipulaInterfaz.cmetpbCambia(objCBstatusDanio);
                    }
                } catch (Exception lEXe)
                {
                    CMensajes.cmetpbFalla(this , "Se esperaba una cantidad entera o decimal");
                    objTFmontoDanios.requestFocus();
                }
            }
        }
        
    }//GEN-LAST:event_objTFmontoDaniosKeyPressed

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
        for (int lEi = 0 ; lEi < objTFmontoDanios.getText().length() ; lEi ++)
        {
            lSCadena = objTFmontoDanios.getText().substring(lEm , lEi + 1);
            if (lSCadena.equals("."))
            {
                if (evt.getKeyChar() == '0' || evt.getKeyChar() == '1' || evt.getKeyChar() == '2' || evt.getKeyChar() == '3' || evt.getKeyChar() == '4'
                        || evt.getKeyChar() == '5' || evt.getKeyChar() == '6' || evt.getKeyChar() == '7' || evt.getKeyChar() == '8' || evt.getKeyChar() == '9')
                {
                    pbEIncremento ++;
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
        CConsultaDanios objCConsultaDanios = new CConsultaDanios();
        objCConsultaDanios.setVisible(true);
        objCConsultaDanios.setLocationRelativeTo(null);
        this.dispose();
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
     * formWindowOpened 
     * Método que muestra el nombre de los bailarines asignados al evento x en un JCombobox
     *
     * @param evt no tiene función en éste método
     */
    private void formWindowOpened(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowOpened
    {//GEN-HEADEREND:event_formWindowOpened

        objCDanios.metpbConsultaDanio(pbEIdUsuario);
        
        
        objLidusuariosDanios.setText(objCDanios.getpbALObjArrayList3().get(0).toString().trim() + " " + objCDanios.getpbALObjArrayList3().get(1).toString().trim() + " " + objCDanios.getpbALObjArrayList3().get(2).toString().trim());
        objTFmontoDanios.setText(objCDanios.getpbALObjArrayList3().get(4).toString().trim());
        objLfechaEventos.setText(objCDanios.getpbALObjArrayList3().get(5).toString().trim());
        
       
        if (objCDanios.getpbALObjArrayList3().get(3).toString().trim().equals("1"))
        {
            objCBstatusDanio.addItem("Dañado");
            objCBstatusDanio.addItem("Reparado");
        } else if (objCDanios.getpbALObjArrayList3().get(3).toString().trim().equals("0"))
        {
            objCBstatusDanio.addItem("Reparado");
            objCBstatusDanio.addItem("Dañado");
        }
        
        objLvestuarioDanio.setText(objCDanios.getpbALObjArrayList3().get(7).toString());
        objLidusuario.setText(objCDanios.getpbALObjArrayList3().get(8).toString());
        
    }//GEN-LAST:event_formWindowOpened

    /**
     * Método que invoca a metpbCerrarConexion para cerrar la conexión a la BD trajin
     *
     * @param evt no tiene función en éste método
     */
    private void formWindowClosed(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosed
    {//GEN-HEADEREND:event_formWindowClosed
        objCDanios.metpbCerrarConexion();
    }//GEN-LAST:event_formWindowClosed

    /**
     * objStatusDanioKeyPressed
     * Método para cambiar la selección del componente
     * 
     * @param evt sirve para controlar lo que se ha pulsado
     */
    private void objCBstatusDanioKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_objCBstatusDanioKeyPressed
    {//GEN-HEADEREND:event_objCBstatusDanioKeyPressed
        String lSBandera="";
        if (evt.getKeyChar() == '\n')
        {
            if (objCBstatusDanio.getSelectedItem().toString().trim().equals("Dañado"))
            {
                lSBandera="1";
            }else if(objCBstatusDanio.getSelectedItem().toString().trim().equals("Reparado"))
            {
                lSBandera="0";
            }
            if (Double.parseDouble(objCDanios.getpbALObjArrayList3().get(4).toString().trim()) == Double.parseDouble(objTFmontoDanios.getText().trim()) &&
                    objCDanios.getpbALObjArrayList3().get(3).toString().trim().equals(lSBandera))
            {
                CMensajes.cmetpbFalla(this , "Para hacer una modificación debes de cambiar al menos un sólo valor");
                evt.consume();
            } else
            {
                CManipulaInterfaz.cmetpbCambia(objBaceptarDanios);
            }
            
        }
    }//GEN-LAST:event_objCBstatusDanioKeyPressed

    /**
     * montoDaniosFocusGained
     * Método para deshabilidar dos objetos una vez que se enfoque el componente
     * 
     * @param evt no tiene función en éste método
     */
    private void objTFmontoDaniosFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_objTFmontoDaniosFocusGained
    {//GEN-HEADEREND:event_objTFmontoDaniosFocusGained
        CManipulaInterfaz.cmetpbHabilitaObjetos(false, objBaceptarDanios, objCBstatusDanio);
    }//GEN-LAST:event_objTFmontoDaniosFocusGained

    /**
     * cmetpbMain
     * Método para cargar la interfaz pos si sola
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                CModificaDanios objCModificaDanios = new CModificaDanios(1);
                objCModificaDanios.setVisible(true);
                ImageIcon objImageIcon = new ImageIcon(getClass().getResource("../imagenes/ico.png"));
                Image objImage = objImageIcon.getImage();
                objCModificaDanios.setIconImage(objImage);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton objBaceptarDanios;
    private javax.swing.JButton objBcancelarDanios;
    private javax.swing.JComboBox objCBstatusDanio;
    private javax.swing.JLabel objLasignacion;
    private javax.swing.JLabel objLfecha;
    private javax.swing.JLabel objLfechaEventos;
    private javax.swing.JLabel objLidusuario;
    private javax.swing.JLabel objLidusuariosDanios;
    private javax.swing.JLabel objLmonto;
    private javax.swing.JLabel objLstatus;
    private javax.swing.JLabel objLusuario;
    private javax.swing.JLabel objLvestuarioDanio;
    private javax.swing.JTextField objTFmontoDanios;
    // End of variables declaration//GEN-END:variables
}
