/*Nombre de clase		: CAltaVestuarios
*Descripción de la clase	: Es la clase en donde se realiza las altas de los vestuarios así como su consulta. 
*Fecha	de creación		: 01/05/2016
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
 * Interfaz para dar de alta y consultar vestuarios.
 *
 * @author: Techno Engineers
 * @versión: 2.0
 */
import bfx.clases.CVestuarios;
import java.awt.Image;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import bfx.controladores.*;

public class CAltaVestuarios extends javax.swing.JFrame
{

    private CPanelFondo pvCPFondo;
    private String pvSCadena1;
    public static String pbSId;
    ArrayList<Object> objArrayListObject = new ArrayList();
    ArrayList<CVestuarios> objArrayListCVestuarios = new ArrayList<CVestuarios>();
    JFrame objJFrame = new JFrame();
    private int pvEEstado = 0;
    ImageIcon objImageIcon = new ImageIcon(getClass().getResource("../imagenes/ico.png"));
    Image objImage = objImageIcon.getImage();

     /***
     * Contructor por defecto donde se inicalizan los componentes, posición del JFrame y agregación
     * del fondo en el panel.
     */
    public CAltaVestuarios()
    {
        initComponents();
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        pvCPFondo = new CPanelFondo("Altas de vestuarios", "../imagenes/ballet.png", 0, 0, 440, 580);
        this.add(pvCPFondo);
        this.setIconImage(objImage);
    }
    /**
     * Método que oculta la columna id vestuario.
     */
    private void metpvVOcultarColumnas()
    {
        objTtablaAltaVestuarios.getColumnModel().getColumn(0).setMaxWidth(0);
        objTtablaAltaVestuarios.getColumnModel().getColumn(0).setMinWidth(0);
        objTtablaAltaVestuarios.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        objPingreseDatosVestuarios = new javax.swing.JPanel();
        objBcancelarVestuarios = new javax.swing.JButton();
        objLsexo = new javax.swing.JLabel();
        objCBsexoVestuarios = new javax.swing.JComboBox<String>();
        objBguardarVestuarios = new javax.swing.JButton();
        objLTipo = new javax.swing.JLabel();
        objLcolor = new javax.swing.JLabel();
        objLdescripcion = new javax.swing.JLabel();
        objCBtipoVestuarios = new javax.swing.JComboBox<String>();
        objTFdescripcionVestuarios = new javax.swing.JTextField();
        objTFcolorVestuarios = new javax.swing.JTextField();
        objPconsultaVestuario = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        objTtablaAltaVestuarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Altas de vestuarios");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowOpened(java.awt.event.WindowEvent evt)
            {
                formWindowOpened(evt);
            }
        });

        objPingreseDatosVestuarios.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingrese datos del vestuario", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        objPingreseDatosVestuarios.setForeground(new java.awt.Color(7, 0, 0));
        objPingreseDatosVestuarios.setToolTipText("");
        objPingreseDatosVestuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        objPingreseDatosVestuarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objPingreseDatosVestuarios.setOpaque(false);

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

        objLsexo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objLsexo.setText("Sexo:");
        objLsexo.setPreferredSize(new java.awt.Dimension(91, 25));

        objCBsexoVestuarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objCBsexoVestuarios.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hombre", "Mujer" }));
        objCBsexoVestuarios.setEnabled(false);
        objCBsexoVestuarios.setMaximumSize(new java.awt.Dimension(150, 25));
        objCBsexoVestuarios.setMinimumSize(new java.awt.Dimension(150, 25));
        objCBsexoVestuarios.setPreferredSize(new java.awt.Dimension(150, 25));
        objCBsexoVestuarios.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objCBsexoVestuariosKeyPressed(evt);
            }
        });

        objBguardarVestuarios.setBackground(new java.awt.Color(255, 255, 255));
        objBguardarVestuarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objBguardarVestuarios.setText("Guardar");
        objBguardarVestuarios.setEnabled(false);
        objBguardarVestuarios.setMaximumSize(new java.awt.Dimension(150, 25));
        objBguardarVestuarios.setMinimumSize(new java.awt.Dimension(150, 25));
        objBguardarVestuarios.setPreferredSize(new java.awt.Dimension(150, 25));
        objBguardarVestuarios.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                objBguardarVestuariosActionPerformed(evt);
            }
        });
        objBguardarVestuarios.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objBguardarVestuariosKeyPressed(evt);
            }
        });

        objLTipo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objLTipo.setText("Tipo:");
        objLTipo.setPreferredSize(new java.awt.Dimension(91, 25));

        objLcolor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objLcolor.setText("Color:");
        objLcolor.setPreferredSize(new java.awt.Dimension(91, 25));

        objLdescripcion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objLdescripcion.setText("Descripción: ");
        objLdescripcion.setPreferredSize(new java.awt.Dimension(91, 25));

        objCBtipoVestuarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objCBtipoVestuarios.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Prenda", "Accesorio" }));
        objCBtipoVestuarios.setEnabled(false);
        objCBtipoVestuarios.setMaximumSize(new java.awt.Dimension(150, 25));
        objCBtipoVestuarios.setMinimumSize(new java.awt.Dimension(150, 25));
        objCBtipoVestuarios.setPreferredSize(new java.awt.Dimension(150, 25));
        objCBtipoVestuarios.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objCBtipoVestuariosKeyPressed(evt);
            }
        });

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

        objTFcolorVestuarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objTFcolorVestuarios.setEnabled(false);
        objTFcolorVestuarios.setMaximumSize(new java.awt.Dimension(150, 25));
        objTFcolorVestuarios.setMinimumSize(new java.awt.Dimension(150, 25));
        objTFcolorVestuarios.setPreferredSize(new java.awt.Dimension(150, 25));
        objTFcolorVestuarios.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFcolorVestuariosKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFcolorVestuariosKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout objPingreseDatosVestuariosLayout = new javax.swing.GroupLayout(objPingreseDatosVestuarios);
        objPingreseDatosVestuarios.setLayout(objPingreseDatosVestuariosLayout);
        objPingreseDatosVestuariosLayout.setHorizontalGroup(
            objPingreseDatosVestuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, objPingreseDatosVestuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(objPingreseDatosVestuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(objLsexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(objLTipo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(objLdescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(objLcolor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(objPingreseDatosVestuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(objTFcolorVestuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objCBsexoVestuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(objPingreseDatosVestuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(objTFdescripcionVestuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(objCBtipoVestuarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(objPingreseDatosVestuariosLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(objBguardarVestuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(objBcancelarVestuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        objPingreseDatosVestuariosLayout.setVerticalGroup(
            objPingreseDatosVestuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(objPingreseDatosVestuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(objPingreseDatosVestuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(objLdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objTFdescripcionVestuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(objPingreseDatosVestuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(objCBtipoVestuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objLTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(objPingreseDatosVestuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(objCBsexoVestuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(objLsexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(objPingreseDatosVestuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(objTFcolorVestuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objLcolor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(objPingreseDatosVestuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(objBguardarVestuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objBcancelarVestuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        objPconsultaVestuario.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Consulta de vestuario", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));
        objPconsultaVestuario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objPconsultaVestuario.setOpaque(false);

        jScrollPane1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        objTtablaAltaVestuarios = new javax.swing.JTable()
        {
            public boolean isCellEditable (int row, int column)
            {
                if (column == 2 || column == 3)
                return true;
                return false;
            }
        };
        objTtablaAltaVestuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        objTtablaAltaVestuarios.getTableHeader().setResizingAllowed(false);
        objTtablaAltaVestuarios.getTableHeader().setReorderingAllowed(false);
        objTtablaAltaVestuarios.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                objTtablaAltaVestuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(objTtablaAltaVestuarios);

        javax.swing.GroupLayout objPconsultaVestuarioLayout = new javax.swing.GroupLayout(objPconsultaVestuario);
        objPconsultaVestuario.setLayout(objPconsultaVestuarioLayout);
        objPconsultaVestuarioLayout.setHorizontalGroup(
            objPconsultaVestuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(objPconsultaVestuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        objPconsultaVestuarioLayout.setVerticalGroup(
            objPconsultaVestuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(objPconsultaVestuarioLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(objPconsultaVestuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(objPingreseDatosVestuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(objPingreseDatosVestuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(objPconsultaVestuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * descripcionVestuariosKeyPressed método que cambia al combobox tipo vestuario. El
     * parámetro que recibe es:
     * 
     * @param evt : indica una posible  evento
     */
    private void objTFdescripcionVestuariosKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_objTFdescripcionVestuariosKeyPressed
    {//GEN-HEADEREND:event_objTFdescripcionVestuariosKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            if (objTFdescripcionVestuarios.getText().trim().equals(""))
            {
                CMensajes.cmetpbFalla(this, "No pudes dejar espacios en blanco");
            } else
            {
                CManipulaInterfaz.cmetpbCambia(objCBtipoVestuarios);
            }
            
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
     * tipoVestuariosKeyPressed método que cambia a la caja de texto sexo
     * @param evt : indica una posible  evento
     */
    private void objCBtipoVestuariosKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_objCBtipoVestuariosKeyPressed
    {//GEN-HEADEREND:event_objCBtipoVestuariosKeyPressed
        CManipulaInterfaz.cmetpbCambia(objCBsexoVestuarios);
    }//GEN-LAST:event_objCBtipoVestuariosKeyPressed
    /**
     * sexoVestuariosKeyPressed método que cambia a la caja de texto color
     * @param evt : indica una posible  evento
     */
    private void objCBsexoVestuariosKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_objCBsexoVestuariosKeyPressed
    {//GEN-HEADEREND:event_objCBsexoVestuariosKeyPressed
        CManipulaInterfaz.cmetpbCambia(objTFcolorVestuarios);
    }//GEN-LAST:event_objCBsexoVestuariosKeyPressed

    /**
     * colorVestuariosKeyPressed método que cambia al botón guardar
     * @param evt : indica una posible  evento
     */
    private void objTFcolorVestuariosKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_objTFcolorVestuariosKeyPressed
    {//GEN-HEADEREND:event_objTFcolorVestuariosKeyPressed
//        CValidaciones.cmetpbAlfanumerico(evt);
        if (evt.getKeyChar() == '\n')
        {
            if (objTFcolorVestuarios.getText().trim().equals(""))
            {
                CMensajes.cmetpbFalla(this, "No puedes dejar espacios en blanco");
            } else
            {
                CManipulaInterfaz.cmetpbCambia(objBguardarVestuarios);
            }
        }
    }//GEN-LAST:event_objTFcolorVestuariosKeyPressed
    /**
     * colorVestuariosKeyTyped método que valida que en la caja de texto color se
     * ingrese solo letras y números, su longitud maxima es de 49. El parámetro que recibe es:
     * 
     * @param evt : indica una posible  evento
     */
    private void objTFcolorVestuariosKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_objTFcolorVestuariosKeyTyped
    {//GEN-HEADEREND:event_objTFcolorVestuariosKeyTyped
        CValidaciones.cmetpbAlfabetico(evt);
        if (objTFcolorVestuarios.getText().length() == 49)
        {
            evt.consume();
        }
    }//GEN-LAST:event_objTFcolorVestuariosKeyTyped

    /**
     * guardarInventariosActionPerformed método que da de alta un vestuario.
     * El parámetro que recibe es:
     * @param evt : indica una posible acción de un evento
     */
    private void objBguardarVestuariosActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_objBguardarVestuariosActionPerformed
    {//GEN-HEADEREND:event_objBguardarVestuariosActionPerformed
        Connection lCNcon = CManipulaDB.cmetpbConectaDB();
        try
        {
            boolean lBCajaVacia = CManipulaInterfaz.cmetpbBVerificaBlancos(objTFdescripcionVestuarios, objTFcolorVestuarios);
            if (!lBCajaVacia)
            {
                CVestuarios lVEAuxiliar = metpvCVBuscarExistenciaVestuario(objTFdescripcionVestuarios.getText().trim(), objTFcolorVestuarios.getText().trim(), objCBsexoVestuarios.getSelectedItem().toString().charAt(0));
                if (lVEAuxiliar == null)
                {
                    CVestuarios objVestuarios = new CVestuarios(0, (objCBtipoVestuarios.getSelectedItem().toString().charAt(0)),
                            objTFdescripcionVestuarios.getText().trim(),
                            objTFcolorVestuarios.getText().trim(),
                            objCBsexoVestuarios.getSelectedItem().toString().charAt(0));
                    pvSCadena1 = "null," + "'" + objVestuarios.getPvCTipo() + "',"
                            + "'" + objVestuarios.getPvSDescripcion().trim() + "',"
                            + "'" + objVestuarios.getPvSColor().trim() + "',"
                            + "'" + objVestuarios.getPvCSexo() + "'";
                    CQuerys objQuery = new CQuerys();
                    String lSResultado = objQuery.metpbSInsertar(lCNcon, "vestuarios", pvSCadena1);

                    if (lSResultado == null)
                    {
                        CMensajes.cmetpbExito(this);
                        objBcancelarVestuariosActionPerformed(evt);
                        formWindowOpened(null);
                    } else
                    {
                        CMensajes.cmetpbFalla(this);
                    }
                } else
                {
                    CMensajes.cmetpbMsj("Ya existe el registro.", "Advertencia", 2, this);
                }
            }
            CManipulaDB.cmetpbDesconectaDB(lCNcon);
        } catch (Exception lEXe)
        {
            CMensajes.cmetpbFalla(this, "Error en DB... " + lEXe.getMessage());
        }
        
    }//GEN-LAST:event_objBguardarVestuariosActionPerformed

    /**
    * guardarVestuariosKeyPressed método que  al presionar la tecla enter realiza la función del método
    * guardarVestuariosActionPerformed. Recibe el parámetro:
    * 
     * @param evt : indica un evento
     */
    private void objBguardarVestuariosKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_objBguardarVestuariosKeyPressed
    {//GEN-HEADEREND:event_objBguardarVestuariosKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            objBguardarVestuariosActionPerformed(null);
        }
    }//GEN-LAST:event_objBguardarVestuariosKeyPressed

    /**
     * cancelarVestuariosActionPerformed método habilita y desabilita componentes dentro del JFrame 
     * además inicializa los combobox y se posiciona en el campo de textos descripción
     * @param evt : indica un evento
     */
    private void objBcancelarVestuariosActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_objBcancelarVestuariosActionPerformed
    {//GEN-HEADEREND:event_objBcancelarVestuariosActionPerformed
        CManipulaInterfaz.cmetpbHabilitaObjetos(false, objTFdescripcionVestuarios, objCBtipoVestuarios, objCBsexoVestuarios, objTFcolorVestuarios);
        CManipulaInterfaz.cmetpbHabilitaObjetos(true, objTFdescripcionVestuarios);
        objCBtipoVestuarios.setSelectedIndex(0);
        objCBsexoVestuarios.setSelectedIndex(0);
        objTFdescripcionVestuarios.requestFocus();
    }//GEN-LAST:event_objBcancelarVestuariosActionPerformed
   /**
    * cancelarVestuariosKeyPressed método que  al presionar una tecla realiza la función del método
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
     * formWindowOpened método que se ejecuta al abrir el JFrame realiza la consulta de los vestuarios ya
     * registrados en la BD. Recibe como parámetro:
     * 
     * @param evt : indica un evento
     */
    private void formWindowOpened(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowOpened
    {//GEN-HEADEREND:event_formWindowOpened

        String lSACampos[] =
        {
            "id", "Descripción"
        };
        DefaultTableModel objDefaultTableModel = new DefaultTableModel(null, lSACampos);
        Connection lCNcon = CManipulaDB.cmetpbConectaDB();
        CQuerys objQuerys = new CQuerys();
        objArrayListCVestuarios = CManipulaDB.cmetpbALCargaVestuarios(objQuerys.metpbALSeleccion(lCNcon, "*", "vestuarios", ""));
        try
        {
            Object[] objObject = new Object[objDefaultTableModel.getColumnCount()];
            for (int lEContador = 0 ; lEContador < objArrayListCVestuarios.size() ; lEContador++)
            {
                objObject[0] = objArrayListCVestuarios.get(lEContador).getPvEIdVestuario();
                objObject[1] = objArrayListCVestuarios.get(lEContador).getPvSDescripcion() + " / " + objArrayListCVestuarios.get(lEContador).getPvCSexo() + " / " + objArrayListCVestuarios.get(lEContador).getPvSColor() + "";
                objDefaultTableModel.addRow(objObject);

            }
        } catch (Exception lEXe)
        {
            CMensajes.cmetpbFalla(this, "No hay datos para mostrar.");
        }
        objTtablaAltaVestuarios.setModel(objDefaultTableModel);
        this.metpvVOcultarColumnas();
        CManipulaDB.cmetpbDesconectaDB(lCNcon);
    }//GEN-LAST:event_formWindowOpened
    /**
     * tablaAltaVestuariosMouseClicked método que obtiene el id vestuario que se seleciona
     * a partir de una tabla. El parámetro que recibe es:
     * 
     * @param evt : indica un evento
     */
    private void objTtablaAltaVestuariosMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_objTtablaAltaVestuariosMouseClicked
    {//GEN-HEADEREND:event_objTtablaAltaVestuariosMouseClicked
        int lEFila;
        new CMenuInventarios().setVisible(true);
        lEFila = objTtablaAltaVestuarios.getSelectedRow();
        pbSId = (objTtablaAltaVestuarios.getModel().getValueAt(lEFila, 0).toString());
    }//GEN-LAST:event_objTtablaAltaVestuariosMouseClicked
    /**
     * metpvCVBuscarExistenciaVestuario método que busca si un vestuario ya esta registrado
     * los parámetros para realizar la busqueda son los siguientes:
     * 
     * @param lSDescripcion : Descripción del vestuario
     * @param lSColor       : Color del vestuario
     * @param lCSexo        : Sexo del genero del vestuario
     * @return retorna null sino existe un vestuario de lo contrario retorna objeto con los datos 
     * del vestuario existente.
     */
    private CVestuarios metpvCVBuscarExistenciaVestuario(String lSDescripcion, String lSColor, char lCSexo)
    {
        CVestuarios objCVestuario = null;
        Connection lCNcon = CManipulaDB.cmetpbConectaDB();
        CQuerys objQuerys = new CQuerys();
        objArrayListCVestuarios = CManipulaDB.cmetpbALCargaVestuarios(objQuerys.metpbALSeleccion(lCNcon, "*", "vestuarios", "descripcion = '" + lSDescripcion + "' AND color='" + lSColor + "' AND sexo='" + lCSexo + "'"));
        try
        {
            for (int lEContador = 0 ; lEContador < objArrayListCVestuarios.size() ; lEContador ++)
            {
                objCVestuario = new CVestuarios();
                objCVestuario.setPvSDescripcion(objArrayListCVestuarios.get(lEContador).getPvSDescripcion().trim());
                objCVestuario.setPvCTipo(objArrayListCVestuarios.get(lEContador).getPvCTipo());
                objCVestuario.setPvCSexo(objArrayListCVestuarios.get(lEContador).getPvCSexo());
                objCVestuario.setPvSColor(objArrayListCVestuarios.get(lEContador).getPvSColor());
            }
        } catch (Exception lEXe)
        {
            System.out.println("No hay datos para mostrar.");
        }
        return objCVestuario;
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
                CAltaVestuarios objAltaVestuarios = new CAltaVestuarios();
                objAltaVestuarios.setVisible(true);
                ImageIcon ImageIcon = new ImageIcon(getClass().getResource("../imagenes/ico.png"));
                Image image = ImageIcon.getImage();
                objAltaVestuarios.setIconImage(image);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton objBcancelarVestuarios;
    private javax.swing.JButton objBguardarVestuarios;
    private javax.swing.JComboBox<String> objCBsexoVestuarios;
    private javax.swing.JComboBox<String> objCBtipoVestuarios;
    private javax.swing.JLabel objLTipo;
    private javax.swing.JLabel objLcolor;
    private javax.swing.JLabel objLdescripcion;
    private javax.swing.JLabel objLsexo;
    private javax.swing.JPanel objPconsultaVestuario;
    private javax.swing.JPanel objPingreseDatosVestuarios;
    private javax.swing.JTextField objTFcolorVestuarios;
    private javax.swing.JTextField objTFdescripcionVestuarios;
    private javax.swing.JTable objTtablaAltaVestuarios;
    // End of variables declaration//GEN-END:variables
}
