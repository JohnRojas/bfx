/*Nombre de clase		: CConsultaUsuarios
*Descripción de la clase	: Clase que contiene los métodos para consutar y modificar un registro de pbALusuario.
*Fecha	de creación		: 01/05/2016
*Elaboró			: Jatziry Barrera Hinojosa && Diego Enrique Sánchez Ordoñez
*Fecha	de Liberación		: 01/05/2016
*Autorizó			: Mauro Sánchez Sánchez/Techno Engineers
*Fecha Mantenimiento		: 05/06/2016
*Folio mantenimiento		: 03
*Descripción del mantto.	: Se realizó la actualización de comentarios y transformacion de código pbCNcon calidad.
*Responsable			: Jatziry Barrera Hinojosa && Diego Enrique Sánchez Ordoñez
*Revisor 			: Diego Enrique Sánchez Ordoñez
*/
package bfx.usuarios;
/**
 * Proceso para consultar y modificar información a la base de datos de un usuario.
 * @author: Techno Engineers
 * @versión: 3.0 
 */
import bfx.clases.CInventarios;
import bfx.clases.CUsuariosDE;
import bfx.clases.CVestuarioUsuario;
import bfx.clases.CVestuarios;
import bfx.controladores.CManipulaDB;
import bfx.controladores.*;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class CConsultaUsuarios extends javax.swing.JFrame
{
    
    ListSelectionModel pbLSMusuarios;
    private CPanelFondo pvCPFfondo;
    ArrayList<Object> pbALidU=new ArrayList();
    ArrayList<Object> pbALclavU=new ArrayList();
    String pbSmensajeFalla = "Este campo no puede quedar vacio";
    ArrayList<CUsuariosDE> pbALusuario;
    ArrayList<CVestuarioUsuario> vestuarioUsuario;
    CQuerys objQuerys=new CQuerys();
    Connection con = CManipulaDB.cmetpbConectaDB();
    
    /******************** Variables para cargar vestuario pbALusuario ****************/
    private int iIdUsuario=0;
    ArrayList<CVestuarioUsuario> cVestUsuario = new ArrayList();
    ArrayList<CInventarios> cInventarios = new ArrayList();
    ArrayList<CVestuarios> cVestuarios = new ArrayList();
   /******************************************************************************/
    public void deshabilitaPestanias(JTabbedPane jTPP)
    {
        objTFnombre.requestFocus();
        jTPP.setSelectedIndex(0);
        for (int i = 1; i < 7; i++)
        {
            jTPP.setEnabledAt(i, true);
        }
    }
    
    public void cargaTablaVestuarioUsuario()
    {
        String lSADatosC[] = new String[5];
        cVestUsuario =CManipulaDB.cmetpbALCargaVestuarioUsuario(CManipulaDB.cmetpbALConsult(con, "vestuariousuario", "*", ""));
        cInventarios = CManipulaDB.cmetpbALCargaInventarios(CManipulaDB.cmetpbALConsult(con, "inventarios", "*", ""));
        cVestuarios = CManipulaDB.cmetpbALCargaVestuarios(CManipulaDB.cmetpbALConsult(con, "vestuarios", "*", ""));
        
        try
        {
//            String campo[]=
//        {
//        "Numero","Pieza","Color","Clave"
//        };
        DefaultTableModel lDTMmodelo= (DefaultTableModel) objTvestuarioUsuario.getModel();
            Object[] objColumnas=new Object[lDTMmodelo.getColumnCount()];
            if (cVestUsuario!=null)
            {
                System.out.println("Entra 1");
                for (int lEi = 0; lEi < cVestUsuario.size(); lEi++)
                {
                    System.out.println("id interfaz "+objTFidU.getText());
                    System.out.println("id compara "+cVestUsuario.get(lEi).getpbEidusuario());
                    
                    if (Integer.parseInt(objTFidU.getText())==cVestUsuario.get(lEi).getpbEidusuario() )
                    {
                        System.out.println("entra 2");
                        objColumnas[0] = cVestUsuario.get(lEi).getpbEidvestuarioUsuario();
                        for (int lEj = 0; lEj < cInventarios.size(); lEj++)
                        {
                            if (cVestUsuario.get(lEi).getpbEidinventario()==cInventarios.get(lEj).getPvEIdInventario())
                            {
                                System.out.println("entra 3");
                                objColumnas[4] = cInventarios.get(lEj).getPvSClaveVestuario();
                                objColumnas[3] = cInventarios.get(lEj).getPvEIdInventario();
                                for (int lEx = 0; lEx < cVestuarios.size(); lEx++)
                                {
                                    if (cInventarios.get(lEj).getPvEIdVestuario()==cVestuarios.get(lEx).getPvEIdVestuario())
                                    {
                                        objColumnas[1] = cVestuarios.get(lEx).getPvSDescripcion();
                                        objColumnas[2] = cVestuarios.get(lEx).getPvSColor();
                                    }
                                }
                                
                            }
                        }                  
                        lDTMmodelo.addRow(objColumnas);
                        objTvestuarioUsuario.setModel(lDTMmodelo);
                    }else
                    {
                        if(lEi ==cVestUsuario.size()-1)
                        {
                            CMensajes.cmetpbFalla(this, "El usuario no tiene vestuario asignado");
                        }
                    }
                }
                
            
            }else 
               {CMensajes.cmetpbFalla(this, "El usuario no tiene vestuario asignado");}
        } catch (Exception lEXe)
        {
            CMensajes.cmetpbFalla(this, "El usuario no tiene vestuario asignado");
        }
    }

    
    public CConsultaUsuarios()
    {
        initComponents();
        pvCPFfondo = new CPanelFondo("Consulta de Usuario","../imagenes/ballet.png",0, 0, 420, 380);  
        this.add(pvCPFfondo);
        this.deshabilitaPestanias(jTPPestanias); 
        objCDvigenciaPasaporteE.setVisible(false);
        objCDfechaNacimientoE.setVisible(false);
        objCDfechaIngreso.setVisible(false);
        jLnombre.setVisible(false);
        objTFbusquedaPorNombre.setVisible(false);
        objCBbusquedaPorStatus.setVisible(false);
        objTFnombre.enable(false);
        objTFexpediente.enable(false);
        objCBEstado.setVisible(false);
        tabla();   
        usuarios();    
    }
    
    public void tabla()
    {
         DefaultTableModel objModeloTabla= new DefaultTableModel();
        objModeloTabla.addColumn("Nombre");
        objModeloTabla.addColumn("Apellido P.");
        objModeloTabla.addColumn("Apellido M.");
        objModeloTabla.addColumn("Usuario");
        objModeloTabla.addColumn("Status");
        objModeloTabla.addColumn("Fecha Ingreso");
        objTusuarios.setModel(objModeloTabla);//las agregamos a la tabla
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jButton1 = new javax.swing.JButton();
        jTPPestanias = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        objTusuarios = new javax.swing.JTable();
        objTFbusquedaPorNombre = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        objTFidU = new javax.swing.JTextField();
        jLnombre = new javax.swing.JLabel();
        objBbotonEliminar = new javax.swing.JButton();
        botonModificar = new javax.swing.JButton();
        objCBbusquedaPorStatus = new javax.swing.JComboBox<String>();
        jCBTipoBusqueda = new javax.swing.JComboBox<String>();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        objTFnombre = new javax.swing.JTextField();
        objTFapellidoPaterno = new javax.swing.JTextField();
        objTFapellidoMaterno = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        objTFcalle = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        objTFnumero = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        objTFcolonia = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        objTFciudad = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        objTFcodigoPostal = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        objTFtelefonoCasa = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        objTFtelefonoOficina = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        objTFtelefonoCelular = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        objCstatus = new javax.swing.JComboBox();
        jBSiguiente1 = new javax.swing.JButton();
        jBCancelar1 = new javax.swing.JButton();
        objCBTipo = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        objTFestadoRepublica = new javax.swing.JTextField();
        objTFfechaIngreso = new javax.swing.JTextField();
        etiquetaFechaModificacion = new javax.swing.JLabel();
        objCBEstado = new javax.swing.JComboBox<String>();
        jLabel28 = new javax.swing.JLabel();
        objTFexpediente = new javax.swing.JTextField();
        objCDfechaIngreso = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        objTFnacimiento = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        objCBsexo = new javax.swing.JComboBox<String>();
        jLabel19 = new javax.swing.JLabel();
        objCBestadoCivil = new javax.swing.JComboBox<String>();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        objTFcartillaMilitar = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        objTFestatura = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        objTFaccidente = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        objTFtelefonoResponsable = new javax.swing.JTextField();
        objCBpasaporte = new javax.swing.JComboBox();
        objCDvigenciaPasaporteE = new com.toedter.calendar.JDateChooser();
        jBSiguiente2 = new javax.swing.JButton();
        jBCancelar2 = new javax.swing.JButton();
        jBAnterior = new javax.swing.JButton();
        objCBliberada = new javax.swing.JComboBox();
        objTFfechaNacimiento = new javax.swing.JTextField();
        objTFvigenciaPasaporte = new javax.swing.JTextField();
        objCDfechaNacimientoE = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        objTFalergias = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        objTFenfermedades = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        objTFnombresMedico = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        objTFtelefonoMedico = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        objTFdiarrea = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        objTFdolorCabeza = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        objTFdolorEstomago = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        objTFdolorMuscular = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        objTFgripa = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        objTFotros = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        objCBtiposangre = new javax.swing.JComboBox();
        jBAnterior1 = new javax.swing.JButton();
        jBSiguiente3 = new javax.swing.JButton();
        jBCancelar3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        objTFformaEnterarse = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        objCBbailadoAntes = new javax.swing.JComboBox<String>();
        jLabel44 = new javax.swing.JLabel();
        objTFtipoBaile = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        objTFcompania = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        objTFperiodo = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        objTFcomentario = new javax.swing.JTextField();
        jBAnterior2 = new javax.swing.JButton();
        jBSiguiente4 = new javax.swing.JButton();
        jBCancelar4 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        objTFcorreo = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        objTFusername = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        objTFrespuesta = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        objPFcontrasenia = new javax.swing.JPasswordField();
        objPFconfirmar = new javax.swing.JPasswordField();
        jBAnterior3 = new javax.swing.JButton();
        jBSiguiente5 = new javax.swing.JButton();
        jBCancelar5 = new javax.swing.JButton();
        objCBpreguntaSecreta = new javax.swing.JComboBox<String>();
        jLabel41 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        objTFnombreU = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        objTvestuarioUsuario = new javax.swing.JTable();
        objCBvestuario = new javax.swing.JComboBox<String>();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        objCBcolorV = new javax.swing.JComboBox<String>();
        jScrollPane3 = new javax.swing.JScrollPane();
        objTtablaInventarios = new javax.swing.JTable();
        objBagregarV = new javax.swing.JButton();
        objBquitarV = new javax.swing.JButton();
        objBguardar = new javax.swing.JButton();

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de usuarios");
        setMinimumSize(new java.awt.Dimension(745, 375));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowOpened(java.awt.event.WindowEvent evt)
            {
                formWindowOpened(evt);
            }
        });

        jTPPestanias.setBackground(new java.awt.Color(255, 153, 102));
        jTPPestanias.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTPPestanias.setMaximumSize(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        objTusuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {

            }
        ));
        objTusuarios.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                objTusuariosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                objTusuariosMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(objTusuarios);

        objTFbusquedaPorNombre.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFbusquedaPorNombreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFbusquedaPorNombreKeyTyped(evt);
            }
        });

        jLabel11.setText("Buscar por:");

        objTFidU.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                objTFidUActionPerformed(evt);
            }
        });

        jLnombre.setText("Nombre:");

        objBbotonEliminar.setText("Dar de baja");
        objBbotonEliminar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                objBbotonEliminarActionPerformed(evt);
            }
        });

        botonModificar.setText("Modificar");
        botonModificar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                botonModificarActionPerformed(evt);
            }
        });

        objCBbusquedaPorStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Inactivo", "Activo", "Suspendido por daño", "Suspendido por adeudo", "Suspendido por Daño y Adeudo" }));
        objCBbusquedaPorStatus.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                objCBbusquedaPorStatusActionPerformed(evt);
            }
        });

        jCBTipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "Status" }));
        jCBTipoBusqueda.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jCBTipoBusquedaMouseClicked(evt);
            }
        });
        jCBTipoBusqueda.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jCBTipoBusquedaActionPerformed(evt);
            }
        });
        jCBTipoBusqueda.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                jCBTipoBusquedaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLnombre)
                        .addGap(18, 18, 18)
                        .addComponent(objTFbusquedaPorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(jCBTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(objCBbusquedaPorStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(428, 428, 428)
                                .addComponent(objTFidU, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(92, 92, 92))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(396, 396, 396)
                .addComponent(botonModificar)
                .addGap(32, 32, 32)
                .addComponent(objBbotonEliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(objTFidU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objCBbusquedaPorStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(objTFbusquedaPorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLnombre))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonModificar)
                    .addComponent(objBbotonEliminar))
                .addGap(30, 30, 30))
        );

        jTPPestanias.addTab("Consultar Usuarios", jPanel1);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setMaximumSize(null);

        jLabel2.setText("* Nombre (s): ");

        jLabel3.setText("* Apellido Paterno: ");

        jLabel4.setText("* Apellido Materno");

        objTFnombre.setPreferredSize(new java.awt.Dimension(150, 25));
        objTFnombre.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFnombreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFnombreKeyTyped(evt);
            }
        });

        objTFapellidoPaterno.setEnabled(false);
        objTFapellidoPaterno.setMinimumSize(new java.awt.Dimension(150, 25));
        objTFapellidoPaterno.setPreferredSize(new java.awt.Dimension(150, 25));
        objTFapellidoPaterno.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                objTFapellidoPaternoActionPerformed(evt);
            }
        });
        objTFapellidoPaterno.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFapellidoPaternoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFapellidoPaternoKeyTyped(evt);
            }
        });

        objTFapellidoMaterno.setEnabled(false);
        objTFapellidoMaterno.setMinimumSize(new java.awt.Dimension(150, 25));
        objTFapellidoMaterno.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFapellidoMaternoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFapellidoMaternoKeyTyped(evt);
            }
        });

        jLabel5.setText("* Calle: ");

        objTFcalle.setEnabled(false);
        objTFcalle.setMinimumSize(new java.awt.Dimension(150, 25));
        objTFcalle.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFcalleKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFcalleKeyTyped(evt);
            }
        });

        jLabel6.setText("* Número: ");

        objTFnumero.setEnabled(false);
        objTFnumero.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFnumeroKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFnumeroKeyTyped(evt);
            }
        });

        jLabel7.setText("* Colonia: ");

        objTFcolonia.setEnabled(false);
        objTFcolonia.setMinimumSize(new java.awt.Dimension(150, 25));
        objTFcolonia.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                objTFcoloniaActionPerformed(evt);
            }
        });
        objTFcolonia.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFcoloniaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFcoloniaKeyTyped(evt);
            }
        });

        jLabel8.setText("* Ciudad: ");

        objTFciudad.setEnabled(false);
        objTFciudad.setMinimumSize(new java.awt.Dimension(150, 25));
        objTFciudad.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                objTFciudadActionPerformed(evt);
            }
        });
        objTFciudad.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFciudadKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFciudadKeyTyped(evt);
            }
        });

        jLabel9.setText("* Estado: ");

        jLabel10.setText("* Código Postal: ");

        objTFcodigoPostal.setEnabled(false);
        objTFcodigoPostal.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFcodigoPostalKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFcodigoPostalKeyTyped(evt);
            }
        });

        jLabel12.setText("Telefono Casa: ");

        objTFtelefonoCasa.setEnabled(false);
        objTFtelefonoCasa.setMinimumSize(new java.awt.Dimension(150, 25));
        objTFtelefonoCasa.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                objTFtelefonoCasaActionPerformed(evt);
            }
        });
        objTFtelefonoCasa.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFtelefonoCasaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFtelefonoCasaKeyTyped(evt);
            }
        });

        jLabel13.setText("Telefono Oficina: ");

        objTFtelefonoOficina.setEnabled(false);
        objTFtelefonoOficina.setMinimumSize(new java.awt.Dimension(150, 25));
        objTFtelefonoOficina.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                obobjTFtelefonoOficinaActionPerformed(evt);
            }
        });
        objTFtelefonoOficina.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                obobjTFtelefonoOficinaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                obobjTFtelefonoOficinaKeyTyped(evt);
            }
        });

        jLabel14.setText("* Telefono Celular: ");

        objTFtelefonoCelular.setEnabled(false);
        objTFtelefonoCelular.setMinimumSize(new java.awt.Dimension(150, 25));
        objTFtelefonoCelular.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                obobjTFtelefonoCelularKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                obobjTFtelefonoCelularKeyTyped(evt);
            }
        });

        jLabel1.setText("* Status:");

        objCstatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Inactivo", "Activo", "Suspendido por daños", "Suspendido por adeudos", "Suspendido por daños y adeudos" }));
        objCstatus.setEnabled(false);
        objCstatus.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                objCstatusActionPerformed(evt);
            }
        });
        objCstatus.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objCstatusKeyPressed(evt);
            }
        });

        jBSiguiente1.setText("Siguiente");
        jBSiguiente1.setEnabled(false);
        jBSiguiente1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBSiguiente1ActionPerformed(evt);
            }
        });
        jBSiguiente1.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                jBSiguiente1KeyPressed(evt);
            }
        });

        jBCancelar1.setText("Cancelar");
        jBCancelar1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBCancelar1ActionPerformed(evt);
            }
        });

        objCBTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Usuario", "Administrador" }));
        objCBTipo.setEnabled(false);
        objCBTipo.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objCBTipoKeyPressed(evt);
            }
        });

        jLabel15.setText("* Tipo usuario");

        jLabel25.setText("* Campos obligatorios");

        objTFestadoRepublica.setEnabled(false);
        objTFestadoRepublica.setMinimumSize(new java.awt.Dimension(150, 25));
        objTFestadoRepublica.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFestadoRepublicaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFestadoRepublicaKeyTyped(evt);
            }
        });

        objTFfechaIngreso.setEditable(false);
        objTFfechaIngreso.setMinimumSize(new java.awt.Dimension(150, 25));

        etiquetaFechaModificacion.setText("Fecha de Ingreso");

        objCBEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aguascalientes", "Baja California", "Baja California Sur", "Campeche", "Chiapas", "Chihuahua", "Coahuila", "Colima", "Distrito Federal", "Durango", "Estado de México", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "Michoacán", "Morelos", "Nayarit", "Nuevo León", "Oaxaca", "Puebla", "Querétaro", "Quintana Roo", "San Luis Potosí", "Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatán", "Zacatecas" }));
        objCBEstado.setEnabled(false);
        objCBEstado.setLightWeightPopupEnabled(false);
        objCBEstado.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objCBEstadoKeyPressed(evt);
            }
        });

        jLabel28.setText("Num. Expediente:");

        objTFexpediente.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFexpedienteKeyPressed(evt);
            }
        });

        objCDfechaIngreso.setDateFormatString("dd/MM/yyyy");
        objCDfechaIngreso.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objCDfechaIngresoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(objTFestadoRepublica, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(objCBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(24, 24, 24)
                                        .addComponent(objTFcodigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(160, 160, 160)
                                        .addComponent(jLabel10)))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(objTFtelefonoCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(objCstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(objTFexpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel28)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(objTFcalle, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(objTFnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(objTFcolonia, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(objTFciudad, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(objTFtelefonoOficina, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(objTFtelefonoCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(objCBTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(etiquetaFechaModificacion)
                                    .addComponent(objTFfechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(objCDfechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(objTFnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(objTFapellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(objTFapellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(153, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBSiguiente1)
                        .addGap(10, 10, 10)
                        .addComponent(jBCancelar1)
                        .addGap(60, 60, 60))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)))
                .addGap(6, 6, 6)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(objTFnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objTFapellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objTFapellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(6, 6, 6)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(objTFcalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objTFnumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objTFcolonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objTFciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(objTFexpediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel1))
                                .addGap(11, 11, 11))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(objTFtelefonoCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(objCstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(objTFcodigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(objTFestadoRepublica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(objCBEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(etiquetaFechaModificacion))))
                .addGap(6, 6, 6)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(objTFtelefonoOficina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objTFtelefonoCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(objCBTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(objTFfechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(objCDfechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBCancelar1)
                        .addComponent(jBSiguiente1)))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jTPPestanias.addTab("Datos Personales", jPanel6);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setText("Fecha de Nacimiento (dd/mm/aaaa): ");

        jLabel17.setText("Lugar de Nacimiento: ");

        objTFnacimiento.setEditable(false);
        objTFnacimiento.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFnacimientoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFnacimientoKeyTyped(evt);
            }
        });

        jLabel18.setText("Sexo: ");

        objCBsexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Femenino", "Masculino" }));
        objCBsexo.setEnabled(false);
        objCBsexo.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objCBsexoKeyPressed(evt);
            }
        });

        jLabel19.setText("Estado Civil: ");

        objCBestadoCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Soltero", "Casado", "Divorciado", "Viudo" }));
        objCBestadoCivil.setEnabled(false);
        objCBestadoCivil.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objCBestadoCivilKeyPressed(evt);
            }
        });

        jLabel20.setText("Pasaporte (S/N): ");

        jLabel21.setText("Vigencia de Pasaporte(dd/mm/aaaa): ");

        jLabel22.setText("No. Cartilla Militar: ");

        objTFcartillaMilitar.setEnabled(false);
        objTFcartillaMilitar.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFcartillaMilitarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFcartillaMilitarKeyTyped(evt);
            }
        });

        jLabel23.setText("Liberada (S/N): ");

        jLabel24.setText("Estatura: ");

        objTFestatura.setEnabled(false);
        objTFestatura.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFestaturaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFestaturaKeyTyped(evt);
            }
        });

        jLabel26.setText("En caso de accidente avisar a: ");

        objTFaccidente.setEnabled(false);
        objTFaccidente.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFaccidenteKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFaccidenteKeyTyped(evt);
            }
        });

        jLabel27.setText("Telefono: ");

        objTFtelefonoResponsable.setEnabled(false);
        objTFtelefonoResponsable.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFtelefonoResponsableKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFtelefonoResponsableKeyTyped(evt);
            }
        });

        objCBpasaporte.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Si", "No" }));
        objCBpasaporte.setEnabled(false);
        objCBpasaporte.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objCBpasaporteKeyPressed(evt);
            }
        });

        objCDvigenciaPasaporteE.setDateFormatString("dd/MM/yyyy");
        objCDvigenciaPasaporteE.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objCDvigenciaPasaporteEKeyPressed(evt);
            }
        });

        jBSiguiente2.setText("Siguiente");
        jBSiguiente2.setEnabled(false);
        jBSiguiente2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBSiguiente2ActionPerformed(evt);
            }
        });
        jBSiguiente2.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                jBSiguiente2KeyPressed(evt);
            }
        });

        jBCancelar2.setText("Cancelar");
        jBCancelar2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBCancelar2ActionPerformed(evt);
            }
        });

        jBAnterior.setText("Anterior");
        jBAnterior.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBAnteriorActionPerformed(evt);
            }
        });

        objCBliberada.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Si", "No" }));
        objCBliberada.setEnabled(false);
        objCBliberada.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objCBliberadaKeyPressed(evt);
            }
        });

        objTFfechaNacimiento.setEditable(false);

        objTFvigenciaPasaporte.setEditable(false);

        objCDfechaNacimientoE.setDateFormatString("dd/MM/yyyy");
        objCDfechaNacimientoE.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objCDfechaNacimientoEKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(28, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel20)
                                    .addComponent(objCBpasaporte, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(objTFfechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 61, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(objCDfechaNacimientoE, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(objTFestatura, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(objTFaccidente, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(objTFtelefonoResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(objTFnacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(objTFvigenciaPasaporte, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(objCDvigenciaPasaporteE, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(129, 129, 129)
                                .addComponent(jLabel19))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(objCBsexo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel23)
                                        .addComponent(objCBestadoCivil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(objTFcartillaMilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(objCBliberada, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel22)))
                .addGap(185, 185, 185))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jBAnterior)
                .addGap(10, 10, 10)
                .addComponent(jBSiguiente2)
                .addGap(10, 10, 10)
                .addComponent(jBCancelar2)
                .addGap(60, 60, 60))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(jLabel18))
                    .addComponent(jLabel19))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(objCBsexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(objTFnacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(objCBestadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(objTFfechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addComponent(objCDfechaNacimientoE, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22)
                        .addComponent(jLabel23)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(objCBpasaporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objCBliberada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objTFcartillaMilitar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objTFvigenciaPasaporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(objCDvigenciaPasaporteE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(objTFestatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(objTFtelefonoResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBAnterior)
                            .addComponent(jBSiguiente2)
                            .addComponent(jBCancelar2))
                        .addGap(30, 30, 30))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(objTFaccidente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTPPestanias.addTab("Datos Generales", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel29.setText("Tipo Sanguineo: ");

        jLabel30.setText("Alergias: ");

        objTFalergias.setEnabled(false);
        objTFalergias.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFalergiasKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFalergiasKeyTyped(evt);
            }
        });

        jLabel31.setText("Enfermedades: ");

        objTFenfermedades.setEnabled(false);
        objTFenfermedades.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFenfermedadesKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFenfermedadesKeyTyped(evt);
            }
        });

        jLabel32.setText("Nombres de Medico: ");

        objTFnombresMedico.setEnabled(false);
        objTFnombresMedico.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFnombresMedicoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFnombresMedicoKeyTyped(evt);
            }
        });

        jLabel33.setText("Telefono de Medico: ");

        objTFtelefonoMedico.setEnabled(false);
        objTFtelefonoMedico.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFtelefonoMedicoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFtelefonoMedicoKeyTyped(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel35.setText("Diarrea: ");

        objTFdiarrea.setEnabled(false);
        objTFdiarrea.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFdiarreaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFdiarreaKeyTyped(evt);
            }
        });

        jLabel36.setText("Dolor de Cabeza: ");

        objTFdolorCabeza.setEnabled(false);
        objTFdolorCabeza.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFdolorCabezaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFdolorCabezaKeyTyped(evt);
            }
        });

        jLabel37.setText("Dolor de Estomago: ");

        objTFdolorEstomago.setEnabled(false);
        objTFdolorEstomago.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFdolorEstomagoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFdolorEstomagoKeyTyped(evt);
            }
        });

        jLabel38.setText("Dolor Muscular: ");

        objTFdolorMuscular.setEnabled(false);
        objTFdolorMuscular.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                objTFdolorMuscularActionPerformed(evt);
            }
        });
        objTFdolorMuscular.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFdolorMuscularKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFdolorMuscularKeyTyped(evt);
            }
        });

        jLabel39.setText("Gripa: ");

        objTFgripa.setEnabled(false);
        objTFgripa.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFgripaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFgripaKeyTyped(evt);
            }
        });

        jLabel40.setText("Otros: ");

        objTFotros.setEnabled(false);
        objTFotros.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFotrosKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(objTFdolorCabeza, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(objTFdiarrea, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37)
                            .addComponent(jLabel38)
                            .addComponent(jLabel39)
                            .addComponent(jLabel40))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(objTFdolorEstomago)
                            .addComponent(objTFdolorMuscular)
                            .addComponent(objTFgripa)
                            .addComponent(objTFotros))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(objTFdiarrea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(objTFdolorCabeza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(objTFdolorEstomago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(objTFdolorMuscular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(objTFgripa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(objTFotros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel34.setText("Medicamentos para: ");

        objCBtiposangre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" }));
        objCBtiposangre.setEnabled(false);
        objCBtiposangre.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objCBtiposangreKeyPressed(evt);
            }
        });

        jBAnterior1.setText("Anterior");
        jBAnterior1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBAnterior1ActionPerformed(evt);
            }
        });
        jBAnterior1.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                jBAnterior1KeyPressed(evt);
            }
        });

        jBSiguiente3.setText("Siguiente");
        jBSiguiente3.setEnabled(false);
        jBSiguiente3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBSiguiente3ActionPerformed(evt);
            }
        });
        jBSiguiente3.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                jBSiguiente3KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                jBSiguiente3KeyTyped(evt);
            }
        });

        jBCancelar3.setText("Cancelar");
        jBCancelar3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBCancelar3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(objTFenfermedades, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32)
                            .addComponent(objTFnombresMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33)
                            .addComponent(objTFtelefonoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(52, 52, 52)
                                .addComponent(jLabel30)
                                .addGap(101, 101, 101)
                                .addComponent(jLabel34)))
                        .addGap(36, 413, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(objCBtiposangre, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(objTFalergias, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(89, 89, 89))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBAnterior1)
                .addGap(10, 10, 10)
                .addComponent(jBSiguiente3)
                .addGap(10, 10, 10)
                .addComponent(jBCancelar3)
                .addGap(60, 60, 60))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(jLabel34))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(objCBtiposangre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(objTFalergias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addComponent(jLabel31)
                        .addGap(6, 6, 6)
                        .addComponent(objTFenfermedades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel32)
                        .addGap(10, 10, 10)
                        .addComponent(objTFnombresMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel33)
                        .addGap(6, 6, 6)
                        .addComponent(objTFtelefonoMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBAnterior1)
                    .addComponent(jBSiguiente3)
                    .addComponent(jBCancelar3))
                .addGap(30, 30, 30))
        );

        jTPPestanias.addTab("Datos Médicos", jPanel3);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel42.setText("¿Cómo se entero de la posibilidad de entrar al ballet? ");

        objTFformaEnterarse.setEditable(false);
        objTFformaEnterarse.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                objTFformaEnterarseActionPerformed(evt);
            }
        });
        objTFformaEnterarse.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFformaEnterarseKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFformaEnterarseKeyTyped(evt);
            }
        });

        jLabel43.setText("¿Ha bailado antes?");

        objCBbailadoAntes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Si", "No" }));
        objCBbailadoAntes.setEnabled(false);
        objCBbailadoAntes.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objCBbailadoAntesKeyPressed(evt);
            }
        });

        jLabel44.setText("¿Qué tipo de Baile?");

        objTFtipoBaile.setEnabled(false);
        objTFtipoBaile.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFtipoBaileKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFtipoBaileKeyTyped(evt);
            }
        });

        jLabel45.setText("Compañia: ");

        objTFcompania.setEnabled(false);
        objTFcompania.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFcompaniaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFcompaniaKeyTyped(evt);
            }
        });

        jLabel46.setText("Periodo: ");

        objTFperiodo.setEnabled(false);
        objTFperiodo.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFperiodoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFperiodoKeyTyped(evt);
            }
        });

        jLabel47.setText("Comentario: ");

        objTFcomentario.setEnabled(false);
        objTFcomentario.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFcomentarioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFcomentarioKeyTyped(evt);
            }
        });

        jBAnterior2.setText("Anterior");
        jBAnterior2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBAnterior2ActionPerformed(evt);
            }
        });

        jBSiguiente4.setText("Siguiente");
        jBSiguiente4.setEnabled(false);
        jBSiguiente4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBSiguiente4ActionPerformed(evt);
            }
        });
        jBSiguiente4.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                jBSiguiente4KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                jBSiguiente4KeyTyped(evt);
            }
        });

        jBCancelar4.setText("Cancelar");
        jBCancelar4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBCancelar4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel42)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(objCBbailadoAntes, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(objTFtipoBaile, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel45)
                            .addComponent(objTFcompania)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(objTFperiodo, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel46))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel47)
                            .addComponent(objTFcomentario, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(objTFformaEnterarse))
                .addGap(178, 178, 178))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBAnterior2)
                .addGap(10, 10, 10)
                .addComponent(jBSiguiente4)
                .addGap(10, 10, 10)
                .addComponent(jBCancelar4)
                .addGap(60, 60, 60))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel42)
                .addGap(11, 11, 11)
                .addComponent(objTFformaEnterarse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jLabel44)
                    .addComponent(jLabel45))
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(objCBbailadoAntes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objTFtipoBaile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objTFcompania, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel46)
                    .addComponent(jLabel47))
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(objTFperiodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objTFcomentario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCancelar4)
                    .addComponent(jBSiguiente4)
                    .addComponent(jBAnterior2))
                .addGap(30, 30, 30))
        );

        jTPPestanias.addTab("Datos Adicionales", jPanel5);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel50.setText("Correo Electronico: ");

        objTFcorreo.setEditable(false);
        objTFcorreo.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFcorreoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFcorreoKeyTyped(evt);
            }
        });

        jLabel51.setText("Username:");

        objTFusername.setEnabled(false);
        objTFusername.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFusernameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                objTFusernameKeyTyped(evt);
            }
        });

        jLabel52.setText("Contraseña");

        objTFrespuesta.setEnabled(false);
        objTFrespuesta.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                objTFrespuestaActionPerformed(evt);
            }
        });
        objTFrespuesta.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objTFrespuestaKeyPressed(evt);
            }
        });

        jLabel53.setText("Respuesta Secreta");

        jLabel54.setText("Confirmar Contraseña");

        objPFcontrasenia.setEnabled(false);
        objPFcontrasenia.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objPFcontraseniaKeyPressed(evt);
            }
        });

        objPFconfirmar.setEnabled(false);
        objPFconfirmar.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objPFconfirmarKeyPressed(evt);
            }
        });

        jBAnterior3.setText("Anterior");
        jBAnterior3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBAnterior3ActionPerformed(evt);
            }
        });

        jBSiguiente5.setText("Siguiente");
        jBSiguiente5.setEnabled(false);
        jBSiguiente5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBSiguiente5ActionPerformed(evt);
            }
        });
        jBSiguiente5.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                jBSiguiente5KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                jBSiguiente5KeyTyped(evt);
            }
        });

        jBCancelar5.setText("Cancelar");
        jBCancelar5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBCancelar5ActionPerformed(evt);
            }
        });

        objCBpreguntaSecreta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "¿Cuál es el nombre de tú papá?", "¿Cómo se llama tu primer mascota?", "¿Cuál es tu color favorito?" }));
        objCBpreguntaSecreta.setEnabled(false);
        objCBpreguntaSecreta.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objCBpreguntaSecretaKeyPressed(evt);
            }
        });

        jLabel41.setText("Pregunta Secreta");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBAnterior3)
                .addGap(10, 10, 10)
                .addComponent(jBSiguiente5)
                .addGap(10, 10, 10)
                .addComponent(jBCancelar5)
                .addGap(60, 60, 60))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(objPFconfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(objTFcorreo)
                    .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(objTFusername)
                    .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(objPFcontrasenia)
                    .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(objTFrespuesta)
                    .addComponent(objCBpreguntaSecreta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(435, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel50)
                .addGap(11, 11, 11)
                .addComponent(objTFcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(objTFusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel52)
                .addGap(6, 6, 6)
                .addComponent(objPFcontrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel54)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(objPFconfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(objCBpreguntaSecreta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel53)
                .addGap(6, 6, 6)
                .addComponent(objTFrespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBAnterior3)
                    .addComponent(jBSiguiente5)
                    .addComponent(jBCancelar5))
                .addGap(30, 30, 30))
        );

        jTPPestanias.addTab("Cuenta", jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel58.setText("Selecciona el horario que tiene disponible el bailarin");

        objTFnombreU.setEditable(false);
        objTFnombreU.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                objTFnombreUActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");

        objTvestuarioUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Numero", "Pieza", "Color", "Id", "Clave"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(objTvestuarioUsuario);

        objCBvestuario.setEnabled(false);
        objCBvestuario.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                objCBvestuarioMouseClicked(evt);
            }
        });
        objCBvestuario.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                objCBvestuarioActionPerformed(evt);
            }
        });
        objCBvestuario.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objCBvestuarioKeyPressed(evt);
            }
        });

        jLabel48.setText("Vestuario:");

        jLabel49.setText("Color: ");

        objCBcolorV.setEnabled(false);
        objCBcolorV.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                objCBcolorVMouseClicked(evt);
            }
        });
        objCBcolorV.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                objCBcolorVKeyPressed(evt);
            }
        });

        objTtablaInventarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {

            }
        ));
        objTtablaInventarios.setEnabled(false);
        jScrollPane3.setViewportView(objTtablaInventarios);

        objBagregarV.setText("Agregar");
        objBagregarV.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                objBagregarVActionPerformed(evt);
            }
        });

        objBquitarV.setText("Quitar");
        objBquitarV.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                objBquitarVActionPerformed(evt);
            }
        });

        objBguardar.setText("Guardar");
        objBguardar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                objBguardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(objCBcolorV, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(objCBvestuario, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addGap(204, 204, 204)
                                    .addComponent(jLabel58))
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addGap(269, 269, 269)
                                    .addComponent(objTFnombreU, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(objBagregarV)
                                    .addComponent(objBquitarV))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(objBguardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addGap(228, 228, 228)))
                .addGap(67, 67, 67))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel58)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(objTFnombreU, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(objCBvestuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(objCBcolorV, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(objBagregarV)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(objBquitarV))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(objBguardar))
                        .addContainerGap())
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88))))
        );

        jTPPestanias.addTab("Vestuarios", jPanel8);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTPPestanias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTPPestanias, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void usuarios()
    {
        String campo[]=
        {
        "Nombre","Apellido P.","Apellido M.","Usuario","Status","Fecha Ingreso"
        };
        DefaultTableModel objDefaultTableModel= new DefaultTableModel(null,campo);
        Object[] objColumnas=new Object[objDefaultTableModel.getColumnCount()];
        pbALusuario = CManipulaDB.cmetpbALCargaUsuarios(CManipulaDB.cmetpbALConsult(con, "usuarios", "*", ""));
        if (pbALusuario!=null)
        {
            for (int i = 0; i < pbALusuario.size(); i++)
            {
                objColumnas[0] = pbALusuario.get(i).getpbSNombre();
                objColumnas[1] = pbALusuario.get(i).getpbSApellidoPaterno();
                objColumnas[2] = pbALusuario.get(i).getpbSApellidoMaterno();
                objColumnas[3] = pbALusuario.get(i).getpbSNombreDeUsuario();
                objColumnas[4] = pbALusuario.get(i).getpbEStatus();
                objColumnas[5]=pbALusuario.get(i).getpbSFechaIngreso();
                objDefaultTableModel.addRow(objColumnas);
                //System.out.println(objColumnas[1]=pbALusuario.get(i).getiIdUsuario());
            }
            System.out.println(pbALusuario.get(0).getpbSNombre());
            objTusuarios.setModel(objDefaultTableModel);
            CManipulaDB.cmetpbDesconectaDB(con);
        }else
        {
            CMensajes.cmetpbFalla(this, "No hay datos");
        }          
    }
    
    public void modificaMedidasColumnas(int IIndex, int Imedida)
    {
        objTusuarios.getColumnModel().getColumn(IIndex).setMaxWidth(Imedida);
        objTusuarios.getColumnModel().getColumn(IIndex).setMinWidth(Imedida);
        objTusuarios.getColumnModel().getColumn(IIndex).setPreferredWidth(Imedida);
        
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTPPestanias.setEnabledAt(6, true);
        jTPPestanias.setSelectedIndex(6);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void objTFnombreUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objTFnombreUActionPerformed

    }//GEN-LAST:event_objTFnombreUActionPerformed

    private void jBCancelar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelar5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBCancelar5ActionPerformed

    private void jBSiguiente5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBSiguiente5KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jBSiguiente5KeyTyped

    private void jBSiguiente5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBSiguiente5KeyPressed
        if (evt.getKeyChar() == '\n')
        {
            jBSiguiente5ActionPerformed(null);
        }
    }//GEN-LAST:event_jBSiguiente5KeyPressed

    private void jBSiguiente5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSiguiente5ActionPerformed
        
        jTPPestanias.setEnabledAt(6, true);
        jTPPestanias.setSelectedIndex(6);
        
    }//GEN-LAST:event_jBSiguiente5ActionPerformed

    private void jBAnterior3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAnterior3ActionPerformed
        jTPPestanias.setEnabledAt(5, true);
        jTPPestanias.setSelectedIndex(3);
    }//GEN-LAST:event_jBAnterior3ActionPerformed

    private void objPFconfirmarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objPFconfirmarKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            if (CManipulaInterfaz.cmetpbRVerificaVacia(objPFconfirmar))
            {
                CMensajes.cmetpbFalla(this, pbSmensajeFalla);
                objPFconfirmar.requestFocus();
            } else
            {
                if (objPFcontrasenia.getText().equals(objPFconfirmar.getText()))
                {
                   CManipulaInterfaz.cmetpbCambia(objCBpreguntaSecreta);
                } else
                {
                    CMensajes.cmetpbFalla(this, "Las contraseñas no coinciden, intentalo de nuevo");
                    objPFcontrasenia.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_objPFconfirmarKeyPressed

    private void objPFcontraseniaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objPFcontraseniaKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            
            if (CManipulaInterfaz.cmetpbRVerificaVacia(objPFcontrasenia))
            {
                CMensajes.cmetpbFalla(this, pbSmensajeFalla);
                objPFcontrasenia.requestFocus();
            } else
            {
                CManipulaInterfaz.cmetpbCambia(objPFconfirmar);
            }
        }
    }//GEN-LAST:event_objPFcontraseniaKeyPressed

    private void objTFrespuestaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFrespuestaKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            if (CManipulaInterfaz.cmetpbRVerificaVacia(objTFrespuesta))
            {
                CMensajes.cmetpbFalla(this, pbSmensajeFalla);
                objTFrespuesta.requestFocus();
            } else
            {
                CManipulaInterfaz.cmetpbCambia(jBSiguiente5);
            }
        }
    }//GEN-LAST:event_objTFrespuestaKeyPressed

    private void objTFrespuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objTFrespuestaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_objTFrespuestaActionPerformed

    private void objTFusernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFusernameKeyTyped
        CValidaciones.cmetpbAlfanumerico(evt);
    }//GEN-LAST:event_objTFusernameKeyTyped

    private void objTFusernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFusernameKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            if (CManipulaInterfaz.cmetpbRVerificaVacia(objTFusername))
            {
                CMensajes.cmetpbFalla(this, pbSmensajeFalla);
                objTFusername.requestFocus();
            } else
            {
                CManipulaInterfaz.cmetpbCambia(objPFcontrasenia);
            }
        }
    }//GEN-LAST:event_objTFusernameKeyPressed

    private void objTFcorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFcorreoKeyTyped
        String sCorreo = String.valueOf(evt.getKeyChar());

        if (!sCorreo.matches("[a-zA-Z0-9._@]"))
        {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_objTFcorreoKeyTyped

    private void objTFcorreoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFcorreoKeyPressed

        if (evt.getKeyChar() == '\n')
        {
            boolean lBaux=CValidaciones.metpbBvalidaCorreo(objTFcorreo.getText(), this);
            if (CManipulaInterfaz.cmetpbRVerificaVacia(objTFcorreo) && lBaux==true)
            {
                objTFcorreo.setText("No tiene");
                CManipulaInterfaz.cmetpbCambia(objTFusername);
            } else
            {
                if (lBaux==true)
                {
                    CManipulaInterfaz.cmetpbCambia(objTFusername);
                }else
                {
                    objTFcorreo.setText("");
                    objTFcorreo.requestFocus();
                }       
            }
        }
    }//GEN-LAST:event_objTFcorreoKeyPressed

    private void jBCancelar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelar4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBCancelar4ActionPerformed

    private void jBSiguiente4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBSiguiente4KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jBSiguiente4KeyTyped

    private void jBSiguiente4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBSiguiente4KeyPressed
        if (evt.getKeyChar() == '\n')
        {
            jBSiguiente4ActionPerformed(null);
        }
    }//GEN-LAST:event_jBSiguiente4KeyPressed

    private void jBSiguiente4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSiguiente4ActionPerformed
        if (CManipulaInterfaz.cmetpbBVerificaBlancos(objTFformaEnterarse, objTFtipoBaile, objTFcompania, objTFperiodo, objTFcomentario) == false)
        {
            jTPPestanias.setEnabledAt(5, true);
            jTPPestanias.setSelectedIndex(5);
            objTFcorreo.enable(true);
            objTFcorreo.requestFocus();
        }
    }//GEN-LAST:event_jBSiguiente4ActionPerformed

    private void jBAnterior2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAnterior2ActionPerformed
        jTPPestanias.setEnabledAt(3, true);
        jTPPestanias.setSelectedIndex(2);
    }//GEN-LAST:event_jBAnterior2ActionPerformed

    private void objTFcomentarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFcomentarioKeyTyped
        CValidaciones.cmetpbAlfanumerico(evt);
    }//GEN-LAST:event_objTFcomentarioKeyTyped

    private void objTFcomentarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFcomentarioKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            if (CManipulaInterfaz.cmetpbRVerificaVacia(objTFcomentario))
            {
                objTFcomentario.setText(" ");
                objTFcomentario.requestFocus();
            } else
            {
                CManipulaInterfaz.cmetpbCambia(jBSiguiente4);
            }
        }
    }//GEN-LAST:event_objTFcomentarioKeyPressed

    private void objTFperiodoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFperiodoKeyTyped
        CValidaciones.cmetpbAlfanumerico(evt);
    }//GEN-LAST:event_objTFperiodoKeyTyped

    private void objTFperiodoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFperiodoKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            if (CManipulaInterfaz.cmetpbRVerificaVacia(objTFperiodo))
            {
                CMensajes.cmetpbFalla(this, pbSmensajeFalla);
                objTFperiodo.requestFocus();
            } else
            {
                CManipulaInterfaz.cmetpbCambia(objTFcomentario);
            }
        }
    }//GEN-LAST:event_objTFperiodoKeyPressed

    private void objTFcompaniaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFcompaniaKeyTyped
        CValidaciones.cmetpbAlfabetico(evt);
    }//GEN-LAST:event_objTFcompaniaKeyTyped

    private void objTFcompaniaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFcompaniaKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            if (CManipulaInterfaz.cmetpbRVerificaVacia(objTFcompania) || objTFcompania.getText().equals("Ninguna"))
            {
                objTFcompania.setText("Ninguna");
                objTFcompania.setEnabled(true);
            } else
            {
                CManipulaInterfaz.cmetpbCambia(objTFperiodo);
            }
        }
    }//GEN-LAST:event_objTFcompaniaKeyPressed

    private void objTFtipoBaileKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFtipoBaileKeyTyped
        CValidaciones.cmetpbAlfabetico(evt);
    }//GEN-LAST:event_objTFtipoBaileKeyTyped

    private void objTFtipoBaileKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFtipoBaileKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            if (CManipulaInterfaz.cmetpbRVerificaVacia(objTFtipoBaile))
            {
                CMensajes.cmetpbFalla(this, pbSmensajeFalla);
                objTFtipoBaile.requestFocus();
            } else
            {
               CManipulaInterfaz.cmetpbCambia(objTFcompania);
            }
        }
    }//GEN-LAST:event_objTFtipoBaileKeyPressed

    private void objCBbailadoAntesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objCBbailadoAntesKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            if (objCBbailadoAntes.getSelectedIndex() == 0)
            {
                CManipulaInterfaz.cmetpbCambia(objTFtipoBaile);
            } else
            {
                objTFtipoBaile.setText("Ninguno");
                objTFcompania.setText("Ninguna");
                objTFperiodo.setText("Ninguno");
                CManipulaInterfaz.cmetpbCambia(objTFcomentario);
            }
        }
    }//GEN-LAST:event_objCBbailadoAntesKeyPressed

    private void objTFformaEnterarseKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFformaEnterarseKeyTyped
        CValidaciones.cmetpbAlfabetico(evt);
    }//GEN-LAST:event_objTFformaEnterarseKeyTyped

    private void objTFformaEnterarseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFformaEnterarseKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            if (CManipulaInterfaz.cmetpbRVerificaVacia(objTFformaEnterarse))
            {
                CMensajes.cmetpbFalla(this, pbSmensajeFalla);
                objTFformaEnterarse.requestFocus();
            } else
            {
                CManipulaInterfaz.cmetpbCambia(objCBbailadoAntes);
            }
        }
    }//GEN-LAST:event_objTFformaEnterarseKeyPressed

    private void objTFformaEnterarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objTFformaEnterarseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_objTFformaEnterarseActionPerformed

    private void jBCancelar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelar3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBCancelar3ActionPerformed

    private void jBSiguiente3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBSiguiente3KeyTyped
        if (evt.getKeyChar() == '\n')
        {
            jBSiguiente3ActionPerformed(null);
        }
    }//GEN-LAST:event_jBSiguiente3KeyTyped

    private void jBSiguiente3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBSiguiente3KeyPressed
        if (evt.getKeyChar() == '\n')
        {
            jBSiguiente3ActionPerformed(null);
        }
    }//GEN-LAST:event_jBSiguiente3KeyPressed

    private void jBSiguiente3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSiguiente3ActionPerformed
        if (CManipulaInterfaz.cmetpbBVerificaBlancos(objTFalergias, objTFenfermedades, objTFnombresMedico, objTFtelefonoMedico,
            objTFdiarrea, objTFdolorCabeza, objTFdolorEstomago, objTFdolorMuscular, objTFgripa, objTFotros) == false)
    {
        jTPPestanias.setEnabledAt(4, true);
        jTPPestanias.setSelectedIndex(4);
        objTFformaEnterarse.enable(true);
        objTFformaEnterarse.requestFocus();
        
        }
    }//GEN-LAST:event_jBSiguiente3ActionPerformed

    private void jBAnterior1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBAnterior1KeyPressed
        if (evt.getKeyChar() == '\n')
        {
            jBAnterior1ActionPerformed(null);
        }
    }//GEN-LAST:event_jBAnterior1KeyPressed

    private void jBAnterior1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAnterior1ActionPerformed
        jTPPestanias.setSelectedIndex(1);
        jTPPestanias.setEnabledAt(2, true);
    }//GEN-LAST:event_jBAnterior1ActionPerformed

    private void objCBtiposangreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objCBtiposangreKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            CManipulaInterfaz.cmetpbCambia(objTFalergias);
        }
    }//GEN-LAST:event_objCBtiposangreKeyPressed

    private void objTFotrosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFotrosKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            if (CManipulaInterfaz.cmetpbRVerificaVacia(objTFotros))
            {
                objTFotros.setText("Ninguna");
            }
            CManipulaInterfaz.cmetpbCambia(jBSiguiente3);
        }
    }//GEN-LAST:event_objTFotrosKeyPressed

    private void objTFgripaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFgripaKeyTyped
        CValidaciones.cmetpbAlfabetico(evt);
    }//GEN-LAST:event_objTFgripaKeyTyped

    private void objTFgripaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFgripaKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            if (CManipulaInterfaz.cmetpbRVerificaVacia(objTFgripa))
            {
                objTFgripa.setText("Ninguna");
            }
            CManipulaInterfaz.cmetpbCambia(objTFotros);
        }
    }//GEN-LAST:event_objTFgripaKeyPressed

    private void objTFdolorMuscularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFdolorMuscularKeyTyped
        CValidaciones.cmetpbAlfabetico(evt);
    }//GEN-LAST:event_objTFdolorMuscularKeyTyped

    private void objTFdolorMuscularKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFdolorMuscularKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            if (CManipulaInterfaz.cmetpbRVerificaVacia(objTFdolorMuscular))
            {
                objTFdolorMuscular.setText("Ninguna");
            }
            CManipulaInterfaz.cmetpbCambia(objTFgripa);
        }
    }//GEN-LAST:event_objTFdolorMuscularKeyPressed

    private void objTFdolorMuscularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objTFdolorMuscularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_objTFdolorMuscularActionPerformed

    private void objTFdolorEstomagoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFdolorEstomagoKeyTyped
        CValidaciones.cmetpbAlfabetico(evt);
    }//GEN-LAST:event_objTFdolorEstomagoKeyTyped

    private void objTFdolorEstomagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFdolorEstomagoKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            if (CManipulaInterfaz.cmetpbRVerificaVacia(objTFdolorEstomago))
            {
                objTFdolorEstomago.setText("Ninguna");
            }
            CManipulaInterfaz.cmetpbCambia(objTFdolorMuscular);
        }
    }//GEN-LAST:event_objTFdolorEstomagoKeyPressed

    private void objTFdolorCabezaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFdolorCabezaKeyTyped
        CValidaciones.cmetpbAlfabetico(evt);
    }//GEN-LAST:event_objTFdolorCabezaKeyTyped

    private void objTFdolorCabezaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFdolorCabezaKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            if (CManipulaInterfaz.cmetpbRVerificaVacia(objTFdolorCabeza))
            {
                objTFdolorCabeza.setText("Ninguna");
            }
            CManipulaInterfaz.cmetpbCambia(objTFdolorEstomago);
        }
    }//GEN-LAST:event_objTFdolorCabezaKeyPressed

    private void objTFdiarreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFdiarreaKeyTyped
        CValidaciones.cmetpbAlfabetico(evt);
    }//GEN-LAST:event_objTFdiarreaKeyTyped

    private void objTFdiarreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFdiarreaKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            if (CManipulaInterfaz.cmetpbRVerificaVacia(objTFdiarrea))
            {
                objTFdiarrea.setText("Ninguna");
            }
            CManipulaInterfaz.cmetpbCambia(objTFdolorCabeza);
        }
    }//GEN-LAST:event_objTFdiarreaKeyPressed

    private void objTFtelefonoMedicoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFtelefonoMedicoKeyTyped
        CValidaciones.cmetpbEntero(evt);
    }//GEN-LAST:event_objTFtelefonoMedicoKeyTyped

    private void objTFtelefonoMedicoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFtelefonoMedicoKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            if (CManipulaInterfaz.cmetpbRVerificaVacia(objTFtelefonoMedico))
            {
                objTFtelefonoMedico.setText("S/N");
                CManipulaInterfaz.cmetpbCambia(objTFdiarrea);
            } else
            {
                CManipulaInterfaz.cmetpbCambia(objTFdiarrea);
            }

        }
    }//GEN-LAST:event_objTFtelefonoMedicoKeyPressed

    private void objTFnombresMedicoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFnombresMedicoKeyTyped
        CValidaciones.cmetpbAlfabetico(evt);
    }//GEN-LAST:event_objTFnombresMedicoKeyTyped

    private void objTFnombresMedicoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFnombresMedicoKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            if (CManipulaInterfaz.cmetpbRVerificaVacia(objTFnombresMedico))
            {
                objTFnombresMedico.setText("Ninguno");
                objTFtelefonoMedico.setText("S/N");
                CManipulaInterfaz.cmetpbCambia(objTFdiarrea);
            } else
            {
                CManipulaInterfaz.cmetpbCambia(objTFtelefonoMedico);
            }

        }
    }//GEN-LAST:event_objTFnombresMedicoKeyPressed

    private void objTFenfermedadesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFenfermedadesKeyTyped
        CValidaciones.cmetpbAlfabetico(evt);
    }//GEN-LAST:event_objTFenfermedadesKeyTyped

    private void objTFenfermedadesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFenfermedadesKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            if (CManipulaInterfaz.cmetpbRVerificaVacia(objTFenfermedades))
            {
                objTFenfermedades.setText("Ninguna");
            }
            CManipulaInterfaz.cmetpbCambia(objTFnombresMedico);
        }
    }//GEN-LAST:event_objTFenfermedadesKeyPressed

    private void objTFalergiasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFalergiasKeyTyped
        CValidaciones.cmetpbAlfabetico(evt);
    }//GEN-LAST:event_objTFalergiasKeyTyped

    private void objTFalergiasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFalergiasKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            if (CManipulaInterfaz.cmetpbRVerificaVacia(objTFalergias))
            {
                objTFalergias.setText("Ninguna");
            }
            CManipulaInterfaz.cmetpbCambia(objTFenfermedades);
        }
    }//GEN-LAST:event_objTFalergiasKeyPressed

    private void objCBliberadaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objCBliberadaKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            CManipulaInterfaz.cmetpbCambia(objTFestatura);
        }
    }//GEN-LAST:event_objCBliberadaKeyPressed

    private void jBAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAnteriorActionPerformed
        jTPPestanias.setSelectedIndex(0);
        jTPPestanias.setEnabledAt(1, true);
    }//GEN-LAST:event_jBAnteriorActionPerformed

    private void jBCancelar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelar2ActionPerformed
        CManipulaInterfaz.cmetpbHabilitaObjetos(false, objTFapellidoPaterno, objTFapellidoMaterno, objTFcalle, objTFnumero, objTFcolonia,
            objTFciudad, objTFestadoRepublica, objTFcodigoPostal, objTFtelefonoCasa, objTFtelefonoOficina, objCstatus, 
            objTFtelefonoCelular, objCBTipo);
        dispose();
    }//GEN-LAST:event_jBCancelar2ActionPerformed

    private void jBSiguiente2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBSiguiente2KeyPressed
        if (evt.getKeyChar() == '\n')
        {
            jBSiguiente2ActionPerformed(null);
        }
    }//GEN-LAST:event_jBSiguiente2KeyPressed

    private void jBSiguiente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSiguiente2ActionPerformed
        if (CManipulaInterfaz.cmetpbBVerificaBlancos(objTFnacimiento, objTFcartillaMilitar, objTFestatura, objTFaccidente, objTFtelefonoResponsable) == false)
        {
            jTPPestanias.setEnabledAt(3, true);
            jTPPestanias.setSelectedIndex(3);
            objTFalergias.enable(true);
            objCBtiposangre.enable(true);
        }
    }//GEN-LAST:event_jBSiguiente2ActionPerformed

    private void objCDvigenciaPasaporteEKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objCDvigenciaPasaporteEKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == '\n')
        {
            CManipulaInterfaz.cmetpbCambia(objTFcartillaMilitar);
        }
    }//GEN-LAST:event_objCDvigenciaPasaporteEKeyPressed

    private void objCBpasaporteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objCBpasaporteKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            if (objCBpasaporte.getSelectedIndex() == 1)
            {
                objCDvigenciaPasaporteE.setEnabled(false);
                CManipulaInterfaz.cmetpbCambia(objTFcartillaMilitar);
                objCDvigenciaPasaporteE.equals("null");
            } else
            {
                CManipulaInterfaz.cmetpbCambia(objCDvigenciaPasaporteE);
                CManipulaInterfaz.cmetpbCambia(objTFcartillaMilitar);
            }

        }
    }//GEN-LAST:event_objCBpasaporteKeyPressed

    private void objTFtelefonoResponsableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFtelefonoResponsableKeyTyped
        CValidaciones.cmetpbEntero(evt);
    }//GEN-LAST:event_objTFtelefonoResponsableKeyTyped

    private void objTFtelefonoResponsableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFtelefonoResponsableKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            if (CManipulaInterfaz.cmetpbRVerificaVacia(objTFtelefonoResponsable))
            {
                CMensajes.cmetpbFalla(this, pbSmensajeFalla);
                objTFtelefonoResponsable.requestFocus();
            } else
            {
                CManipulaInterfaz.cmetpbCambia(jBSiguiente2);
            }

        }
    }//GEN-LAST:event_objTFtelefonoResponsableKeyPressed

    private void objTFaccidenteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFaccidenteKeyTyped
        CValidaciones.cmetpbAlfabetico(evt);
    }//GEN-LAST:event_objTFaccidenteKeyTyped

    private void objTFaccidenteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFaccidenteKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            if (CManipulaInterfaz.cmetpbRVerificaVacia(objTFaccidente))
            {
                CMensajes.cmetpbFalla(this, pbSmensajeFalla);
                objTFaccidente.requestFocus();
            } else
            {
                CManipulaInterfaz.cmetpbCambia(objTFtelefonoResponsable);
            }

        }
    }//GEN-LAST:event_objTFaccidenteKeyPressed

    private void objTFestaturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFestaturaKeyTyped
        CValidaciones.cmetpbFlotante(evt);
    }//GEN-LAST:event_objTFestaturaKeyTyped

    private void objTFestaturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFestaturaKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            if (CManipulaInterfaz.cmetpbRVerificaVacia(objTFestatura))
            {
                CMensajes.cmetpbFalla(this, pbSmensajeFalla);
                objTFestatura.requestFocus();
            } else
            {
                CManipulaInterfaz.cmetpbCambia(objTFaccidente);
            }
        }
    }//GEN-LAST:event_objTFestaturaKeyPressed

    private void objTFcartillaMilitarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFcartillaMilitarKeyTyped
        /* TODO add your handling code here:*/ 
        CValidaciones.cmetpbEntero(evt);
    }//GEN-LAST:event_objTFcartillaMilitarKeyTyped

    private void objTFcartillaMilitarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFcartillaMilitarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == '\n')
        {
            if (CManipulaInterfaz.cmetpbRVerificaVacia(objTFcartillaMilitar))
            {
                objTFcartillaMilitar.setText("No tiene");
                objCBliberada.setEnabled(false);
                CManipulaInterfaz.cmetpbCambia(objTFestatura);
            } else
            {
                CManipulaInterfaz.cmetpbCambia(objCBliberada);
            }
        }
    }//GEN-LAST:event_objTFcartillaMilitarKeyPressed

    private void objCBestadoCivilKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objCBestadoCivilKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == '\n')
        {
            CManipulaInterfaz.cmetpbCambia(objCBpasaporte);
        }
    }//GEN-LAST:event_objCBestadoCivilKeyPressed

    private void objCBsexoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objCBsexoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == '\n')
        {
            CManipulaInterfaz.cmetpbCambia(objCBestadoCivil);
        }
    }//GEN-LAST:event_objCBsexoKeyPressed

    private void objTFnacimientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFnacimientoKeyTyped
        CValidaciones.cmetpbAlfabetico(evt);
    }//GEN-LAST:event_objTFnacimientoKeyTyped

    private void objTFnacimientoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFnacimientoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == '\n')
        {
            if (CManipulaInterfaz.cmetpbRVerificaVacia(objTFnacimiento))
            {
                CMensajes.cmetpbFalla(this, pbSmensajeFalla);
                objTFnacimiento.requestFocus();
            } else
            {
                CManipulaInterfaz.cmetpbCambia(objCBsexo);
            }
        }
    }//GEN-LAST:event_objTFnacimientoKeyPressed

    private void objCBTipoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objCBTipoKeyPressed
        if (evt.getKeyChar() == '\n' || evt.getKeyChar() == '\t' || evt.getKeyChar() == 77)
        {
            CManipulaInterfaz.cmetpbCambia(jBSiguiente1);
        }
    }//GEN-LAST:event_objCBTipoKeyPressed

    private void jBCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelar1ActionPerformed
        CManipulaInterfaz.cmetpbHabilitaObjetos(false, objTFapellidoPaterno, objTFapellidoMaterno, objTFcalle, objTFnumero, objTFcolonia,
            objTFciudad, objTFestadoRepublica, objTFcodigoPostal, objTFtelefonoCasa, objTFtelefonoOficina, objCstatus,
            objTFtelefonoCelular, objCBTipo);
        this.deshabilitaPestanias(jTPPestanias);
    }//GEN-LAST:event_jBCancelar1ActionPerformed

    private void jBSiguiente1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBSiguiente1KeyPressed
        jBSiguiente1ActionPerformed(null);
        
    }//GEN-LAST:event_jBSiguiente1KeyPressed

    private void jBSiguiente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSiguiente1ActionPerformed
        if (CManipulaInterfaz.cmetpbBVerificaBlancos(objTFnombre, objTFapellidoPaterno, objTFapellidoMaterno, objTFcalle, objTFnumero,
            objTFcolonia, objTFciudad, objTFcodigoPostal, objTFtelefonoCasa, objTFtelefonoOficina, objTFtelefonoCelular) == false)
        {
        jTPPestanias.setEnabledAt(2, true);
        jTPPestanias.setSelectedIndex(2);
        objTFnacimiento.enable(true);
        }
    }//GEN-LAST:event_jBSiguiente1ActionPerformed

    private void objCstatusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objCstatusKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == '\n' || evt.getKeyChar() == '\t' || evt.getKeyChar() == 77)
        {
            CManipulaInterfaz.cmetpbCambia(objTFexpediente);
        }
    }//GEN-LAST:event_objCstatusKeyPressed

    private void objCstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objCstatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_objCstatusActionPerformed

    private void obobjTFtelefonoCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_obobjTFtelefonoCelularKeyTyped
        if (objTFtelefonoCelular.getText().length() < 10)
        {
            CValidaciones.cmetpbEntero(evt);
        } else
        {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_obobjTFtelefonoCelularKeyTyped

    private void obobjTFtelefonoCelularKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_obobjTFtelefonoCelularKeyPressed
        if (evt.getKeyChar() == '\n' || evt.getKeyChar() == '\t' || evt.getKeyChar() == 77)
        {
            if (CManipulaInterfaz.cmetpbRVerificaVacia(objTFtelefonoCelular))
            {
                CMensajes.cmetpbFalla(this, pbSmensajeFalla);
                objTFtelefonoCelular.requestFocus();
            } else
            {
                CManipulaInterfaz.cmetpbCambia(objCBTipo);
            }
        }
    }//GEN-LAST:event_obobjTFtelefonoCelularKeyPressed

    private void obobjTFtelefonoOficinaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_obobjTFtelefonoOficinaKeyTyped
        if (objTFtelefonoOficina.getText().length() < 10)
        {
            CValidaciones.cmetpbEntero(evt);
        } else
        {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_obobjTFtelefonoOficinaKeyTyped

    private void obobjTFtelefonoOficinaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_obobjTFtelefonoOficinaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == '\n' || evt.getKeyChar() == '\t')
        {
            if (CManipulaInterfaz.cmetpbRVerificaVacia(objTFtelefonoOficina))
            {
                objTFtelefonoOficina.setText("S/N");
                objTFtelefonoOficina.setEnabled(false);
            }
            CManipulaInterfaz.cmetpbCambia(objTFtelefonoCelular);
        }
    }//GEN-LAST:event_obobjTFtelefonoOficinaKeyPressed

    private void obobjTFtelefonoOficinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obobjTFtelefonoOficinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_obobjTFtelefonoOficinaActionPerformed

    private void objTFtelefonoCasaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFtelefonoCasaKeyTyped
        if (objTFtelefonoCasa.getText().length() < 10)
        {
            CValidaciones.cmetpbEntero(evt);
        } else
        {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_objTFtelefonoCasaKeyTyped

    private void objTFtelefonoCasaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFtelefonoCasaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == '\n' || evt.getKeyChar() == '\t' || evt.getKeyChar() == 77)
        {
            if (CManipulaInterfaz.cmetpbRVerificaVacia(objTFtelefonoCasa))
            {
                objTFtelefonoCasa.setText("S/N");
            }
            CManipulaInterfaz.cmetpbCambia(objCstatus);
        }
    }//GEN-LAST:event_objTFtelefonoCasaKeyPressed

    private void objTFtelefonoCasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objTFtelefonoCasaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_objTFtelefonoCasaActionPerformed

    private void objTFcodigoPostalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFcodigoPostalKeyTyped
        if (objTFcodigoPostal.getText().length() < 5)
        {
            CValidaciones.cmetpbEntero(evt);
        } else
        {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_objTFcodigoPostalKeyTyped

    private void objTFcodigoPostalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFcodigoPostalKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == '\n' || evt.getKeyChar() == '\t' || evt.getKeyChar() == 77)
        {
            if (CManipulaInterfaz.cmetpbRVerificaVacia(objTFcodigoPostal))
            {
                CMensajes.cmetpbFalla(this, pbSmensajeFalla);
                objTFcodigoPostal.requestFocus();
            } else
            {
                CManipulaInterfaz.cmetpbCambia(objTFtelefonoCasa);
            }
        }
    }//GEN-LAST:event_objTFcodigoPostalKeyPressed

    private void objTFciudadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFciudadKeyTyped
        CValidaciones.cmetpbAlfabetico(evt);
    }//GEN-LAST:event_objTFciudadKeyTyped

    private void objTFciudadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFciudadKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == '\n' || evt.getKeyChar() == '\t' || evt.getKeyChar() == 77)
        {
            if (CManipulaInterfaz.cmetpbRVerificaVacia(objTFciudad))
            {
                CMensajes.cmetpbFalla(this, pbSmensajeFalla);
                objTFciudad.requestFocus();
            } else
            {
                CManipulaInterfaz.cmetpbCambia(objCBEstado);
            }
        }
    }//GEN-LAST:event_objTFciudadKeyPressed

    private void objTFcoloniaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFcoloniaKeyTyped
        CValidaciones.cmetpbAlfabetico(evt);
    }//GEN-LAST:event_objTFcoloniaKeyTyped

    private void objTFcoloniaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFcoloniaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == '\n' || evt.getKeyChar() == '\t' || evt.getKeyChar() == 77)
        {
            if (CManipulaInterfaz.cmetpbRVerificaVacia(objTFcolonia))
            {
                CMensajes.cmetpbFalla(this, pbSmensajeFalla);
                objTFcolonia.requestFocus();
            } else
            {
                CManipulaInterfaz.cmetpbCambia(objTFciudad);
            }
        }
    }//GEN-LAST:event_objTFcoloniaKeyPressed

    private void objTFcoloniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objTFcoloniaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_objTFcoloniaActionPerformed

    private void objTFnumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFnumeroKeyTyped
        if (objTFnumero.getText().length() < 5)
        {
            CValidaciones.cmetpbEntero(evt);
        } else
        {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_objTFnumeroKeyTyped

    private void objTFnumeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFnumeroKeyPressed
        /* TODO add your handling code here: */
        if (evt.getKeyChar() == '\n' || evt.getKeyChar() == '\t' || evt.getKeyChar() == 77)
        {
            if (CManipulaInterfaz.cmetpbRVerificaVacia(objTFnumero))
            {
                objTFnumero.setText("S/N");
                objTFnumero.setEnabled(false);
            }
            CManipulaInterfaz.cmetpbCambia(objTFcolonia);
        }
    }//GEN-LAST:event_objTFnumeroKeyPressed

    private void objTFcalleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFcalleKeyTyped
        CValidaciones.cmetpbAlfabetico(evt);
    }//GEN-LAST:event_objTFcalleKeyTyped

    private void objTFcalleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFcalleKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == '\n' || evt.getKeyChar() == '\t' || evt.getKeyChar() == 77)
        {
            if (CManipulaInterfaz.cmetpbRVerificaVacia(objTFcalle))
            {
                CMensajes.cmetpbFalla(this, pbSmensajeFalla);
                objTFcalle.requestFocus();
            } else
            {
                CManipulaInterfaz.cmetpbCambia(objTFnumero);
            }
        }
    }//GEN-LAST:event_objTFcalleKeyPressed

    private void objTFapellidoMaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFapellidoMaternoKeyTyped
        CValidaciones.cmetpbAlfabetico(evt);
    }//GEN-LAST:event_objTFapellidoMaternoKeyTyped

    private void objTFapellidoMaternoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFapellidoMaternoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == '\n' || evt.getKeyChar() == '\t' || evt.getKeyChar() == 77)
        {
            if (CManipulaInterfaz.cmetpbRVerificaVacia(objTFapellidoMaterno))
            {
                CMensajes.cmetpbFalla(this, pbSmensajeFalla);
                objTFapellidoMaterno.requestFocus();
            } else
            {
                CManipulaInterfaz.cmetpbCambia(objTFcalle);
            }
        }
    }//GEN-LAST:event_objTFapellidoMaternoKeyPressed

    private void objTFapellidoPaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFapellidoPaternoKeyTyped
         CValidaciones.cmetpbAlfabetico(evt);
    }//GEN-LAST:event_objTFapellidoPaternoKeyTyped

    private void objTFapellidoPaternoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFapellidoPaternoKeyPressed
        /* TODO add your handling code here:*/
        if (evt.getKeyChar() == '\n' || evt.getKeyChar() == '\t' || evt.getKeyChar() == 77)
        {
            if (CManipulaInterfaz.cmetpbRVerificaVacia(objTFapellidoPaterno))
            {
                CMensajes.cmetpbFalla(this, pbSmensajeFalla);
                objTFapellidoPaterno.requestFocus();
            } else
            {
                CManipulaInterfaz.cmetpbCambia(objTFapellidoMaterno);
            }

        }
    }//GEN-LAST:event_objTFapellidoPaternoKeyPressed

    private void objTFapellidoPaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objTFapellidoPaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_objTFapellidoPaternoActionPerformed

    private void objTFnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFnombreKeyTyped
       CValidaciones.cmetpbAlfabetico(evt);
    }//GEN-LAST:event_objTFnombreKeyTyped

    private void objTFnombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFnombreKeyPressed
        if (evt.getKeyChar() == '\n' || evt.getKeyChar() == '\t' || evt.getKeyChar() == 77)
        {
            if(CManipulaInterfaz.cmetpbRVerificaVacia(objTFnombre))
            {
                CMensajes.cmetpbFalla(this, pbSmensajeFalla);
                objTFnombre.requestFocus();
            } else
            {
                CManipulaInterfaz.cmetpbCambia(objTFapellidoPaterno);
            }
        }
    }//GEN-LAST:event_objTFnombreKeyPressed

    private void objTusuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_objTusuariosMouseClicked
        int lErow=objTusuarios.getSelectedRow();
        if (lErow>=0)
        {
            iIdUsuario=pbALusuario.get(lErow).getpbEIdUsuario();
            objBbotonEliminar.setVisible(true);
            botonModificar.setVisible(true);
            objTFidU.setText(String.valueOf(pbALusuario.get(lErow).getpbEIdUsuario()));
            objCBTipo.setSelectedItem(pbALusuario.get(lErow).getpbCTipoUsuario());
            objTFusername.setText(pbALusuario.get(lErow).getpbSNombreDeUsuario());
            objPFcontrasenia.setText(pbALusuario.get(lErow).getpbSContrasena());
            objCstatus.setSelectedItem(pbALusuario.get(lErow).getpbEStatus());
            objTFnombre.setText(pbALusuario.get(lErow).getpbSNombre());
            objTFapellidoPaterno.setText(pbALusuario.get(lErow).getpbSApellidoPaterno());
            objTFapellidoMaterno.setText(pbALusuario.get(lErow).getpbSApellidoMaterno());
            objCBsexo.setSelectedItem(pbALusuario.get(lErow).getpbCSexo());
            objTFcalle.setText(pbALusuario.get(lErow).getpbSCalle());
            objTFnumero.setText(String.valueOf(pbALusuario.get(lErow).getpbENumero()));
            objTFcolonia.setText(pbALusuario.get(lErow).getpbSColonia());
            objTFciudad.setText(pbALusuario.get(lErow).getpbSCiudad());
            objCBEstado.setSelectedItem(pbALusuario.get(lErow).getpbEStatus());
            objTFestadoRepublica.setText(pbALusuario.get(lErow).getpbSEstado());
            objTFcodigoPostal.setText(String.valueOf(pbALusuario.get(lErow).getpbECp()));
            objTFtelefonoCelular.setText(pbALusuario.get(lErow).getpbSTelCelular());
            objTFtelefonoCasa.setText(pbALusuario.get(lErow).getpbSTelCasa());
            objTFtelefonoOficina.setText(pbALusuario.get(lErow).getpbSTelOficina());
            objTFcorreo.setText(pbALusuario.get(lErow).getpbSEmail());
            ////////////////////////////////////////////////////////////////////////////////////////255555555555555

            
            objTFnacimiento.setText(pbALusuario.get(lErow).getpbSLugarNacimiento());
            objCBestadoCivil.setSelectedItem(pbALusuario.get(lErow).getpbCEstadoCivil());
            objCBpasaporte.setSelectedItem(pbALusuario.get(lErow).getpbSPasaporteSN());
            objTFcartillaMilitar.setText(String.valueOf(pbALusuario.get(lErow).getpbENoCartillaMilitar()));
            objTFestatura.setText(String.valueOf(pbALusuario.get(lErow).getpbDEstatura()));
            objTFaccidente.setText(pbALusuario.get(lErow).getpbSResponsable());
            objCBtiposangre.setSelectedItem(pbALusuario.get(lErow).getpbSTipoSanguineo());
            objTFalergias.setText(pbALusuario.get(lErow).getpbSAlergias());
            objTFenfermedades.setText(pbALusuario.get(lErow).getpbSEnfermedades());
            objTFnombresMedico.setText(pbALusuario.get(lErow).getpbSNombreMedicoCabecera());
            objTFtelefonoMedico.setText(pbALusuario.get(lErow).getpbSTelMedicoDeCabecera());
            objTFdiarrea.setText(pbALusuario.get(lErow).getpbSMedicacionDiarrea());
            objTFdolorCabeza.setText(pbALusuario.get(lErow).getpbSMedicacionDolorDeCabeza());
            objTFdolorEstomago.setText(pbALusuario.get(lErow).getpbSMedicacionDolorDeEstomago());
            objTFdolorMuscular.setText(pbALusuario.get(lErow).getpbSMedicacionDolorMuscular());
            objTFgripa.setText(pbALusuario.get(lErow).getpbSMedicacionGripa());
            objTFotros.setText(pbALusuario.get(lErow).getpbSMedicacionOtro());
            objTFformaEnterarse.setText(pbALusuario.get(lErow).getpbSRespuestaSecreta());//por ver
            objCBbailadoAntes.setSelectedItem(pbALusuario.get(lErow).getpbSBaila());
            objTFtipoBaile.setText(pbALusuario.get(lErow).getpbSBaile());
            objTFcompania.setText(pbALusuario.get(lErow).getpbSAnteriorBallet());
            objTFperiodo.setText(pbALusuario.get(lErow).getpbSTiempoQueBailo());
            objTFrespuesta.setText(pbALusuario.get(lErow).getpbSRespuestaSecreta());
            objTFcomentario.setText(pbALusuario.get(lErow).getpbSComentario());
            objTFfechaNacimiento.setText(pbALusuario.get(lErow).getpbSFechaNacimiento());
            objTFvigenciaPasaporte.setText(pbALusuario.get(lErow).getpbSVigenciaPasaporte());
            objTFtelefonoResponsable.setText(pbALusuario.get(lErow).getpbSTelResponsable());
            objCBpreguntaSecreta.setSelectedItem(pbALusuario.get(lErow).getpbSBaila());
            objTFnombreU.setText(objTFnombre.getText());
            DefaultTableModel lDTMm=(DefaultTableModel)objTvestuarioUsuario.getModel();
            for (int lEi = 0; lEi < pbALusuario.size(); lEi++)
            {
                if(pbALusuario.get(lEi).getpbSNombreDeUsuario().equals(objTusuarios.getValueAt(lErow,3)))
                {
                    objTFidU.setText(String.valueOf(pbALusuario.get(lEi).getpbEIdUsuario()));
                }
            }
            while (lDTMm.getRowCount()>0) 
            {
                lDTMm.removeRow(0);
            }
            cargaTablaVestuarioUsuario();
            
        }else
        {
           
        }
    }//GEN-LAST:event_objTusuariosMouseClicked
      public void limpiarCaja()
    {
        objTFidU.setText("");
        objCBTipo.setSelectedItem("");
        objTFusername.setText("");
        objPFcontrasenia.setText("");
        objCstatus.setSelectedItem("");
        objTFnombre.setText("");
        objTFapellidoPaterno.setText("");
        objTFapellidoMaterno.setText("");
        objCBsexo.setSelectedItem("");
        objTFcalle.setText("");
        objTFnumero.setText("");
        objTFcolonia.setText("");
        objTFciudad.setText("");
        objTFestadoRepublica.setText("");
        objTFcodigoPostal.setText("");
        objTFtelefonoCelular.setText("");
        objTFtelefonoCasa.setText("");
        objTFtelefonoOficina.setText("");
        objTFcorreo.setText("");
        objTFnacimiento.setText("");
        objCBestadoCivil.setSelectedItem("");
        objCBpasaporte.setSelectedItem("");
        objTFcartillaMilitar.setText("");
        objTFestatura.setText("");
        objTFaccidente.setText("");
        objCBtiposangre.setSelectedItem("");
        objTFalergias.setText("");
        objTFenfermedades.setText("");
        objTFnombresMedico.setText("");
        objTFtelefonoMedico.setText("");
        objTFdiarrea.setText("");
        objTFdolorCabeza.setText("");
        objTFdolorEstomago.setText("");
        objTFdolorMuscular.setText("");
        objTFgripa.setText("");
        objTFotros.setText("");
        objTFformaEnterarse.setText("");
        objCBbailadoAntes.setSelectedItem("");
        objTFtipoBaile.setText("");
        objTFcompania.setText("");
        objTFperiodo.setText("");
        objTFrespuesta.setText("");
        objTFcomentario.setText("");
        objCBpreguntaSecreta.setSelectedItem("");
        /////////////////////////////////////////////////////////////////////////////////////////////
        //AGREGAR LOS DOS CAMPOS MAS
    }
    private void objTFestadoRepublicaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFestadoRepublicaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_objTFestadoRepublicaKeyPressed

    private void objTFestadoRepublicaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objTFestadoRepublicaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_objTFestadoRepublicaKeyTyped

    private void objBbotonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objBbotonEliminarActionPerformed
        //String resultado=objQuerys.metpbSDelete(con, "usuarios", "idUsuario",String.valueOf(jTFidu.getText().trim()));
        String resultado=objQuerys.metpbSModificar(con, "Usuarios", "status", "0", "idusuario="+objTFidU.getText().trim());
        if (resultado==null) 
        {
            CMensajes.cmetpbExito(this);
            usuarios();
        } else {
            CMensajes.cmetpbFalla(this, "No se pudo realizar la acción");
        }
    }//GEN-LAST:event_objBbotonEliminarActionPerformed

    private void objTFidUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objTFidUActionPerformed

    }//GEN-LAST:event_objTFidUActionPerformed

    private void objCDfechaNacimientoEKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objCDfechaNacimientoEKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_objCDfechaNacimientoEKeyPressed

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
        CManipulaInterfaz.cmetpbHabilita(true, objCBvestuario);
        objTFvigenciaPasaporte.setVisible(false);
        objCDvigenciaPasaporteE.setVisible(true);
        objTFfechaNacimiento.setVisible(false);
        objCDfechaNacimientoE.setVisible(true);
        objTFfechaIngreso.setVisible(false);
        objCDfechaIngreso.setVisible(true);
        objTFestadoRepublica.setVisible(false);
        objCBEstado.setVisible(true);
        jTPPestanias.setEnabledAt(1, true);
        jTPPestanias.setSelectedIndex(1);
        char lCsexoU = objCBsexo.getSelectedItem().toString().charAt(0);
        ArrayList<String> lALvestuarioTemp = new ArrayList();
        String lStempV;
    
            for (int lEi=0; lEi<cVestuarios.size(); lEi++)
            {
                if( lCsexoU==cVestuarios.get(lEi).getPvCSexo())
                {
                    lStempV= cVestuarios.get(lEi).getPvSDescripcion().trim();
               
                    if(!lALvestuarioTemp.contains(lStempV))
                    {
                        lALvestuarioTemp.add(lStempV);
                        objCBvestuario.addItem(lStempV);
                    } 
                }      
            }
         jTPPestanias.setEnabledAt(1, true);
        jTPPestanias.setSelectedIndex(1);
        objTFnombre.enable(true);
 
        CManipulaInterfaz.cmetpbHabilita(true, objTFnombre);
        objTFnombre.requestFocus();
    }//GEN-LAST:event_botonModificarActionPerformed

    private void objCBEstadoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_objCBEstadoKeyPressed

        if (evt.getKeyChar() == '\n' || evt.getKeyChar() == '\t' || evt.getKeyChar() == 77)
        {
            CManipulaInterfaz.cmetpbCambia(objTFcodigoPostal);
        }
    }//GEN-LAST:event_objCBEstadoKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       
    }//GEN-LAST:event_formWindowOpened

    private void objTFbusquedaPorNombreKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_objTFbusquedaPorNombreKeyTyped
    {//GEN-HEADEREND:event_objTFbusquedaPorNombreKeyTyped
        objTFbusquedaPorNombreKeyPressed(evt);
    }//GEN-LAST:event_objTFbusquedaPorNombreKeyTyped

    private void objTFbusquedaPorNombreKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_objTFbusquedaPorNombreKeyPressed
    {//GEN-HEADEREND:event_objTFbusquedaPorNombreKeyPressed
       String campo[]= {"Nombre","Apellido P.","Apellido M.","Usuario","Status","Fecha Ingreso"};
        DefaultTableModel objDefaultTableModel= new DefaultTableModel(null,campo);
        //DefaultTableModel objDefaultTableModel= new DefaultTableModel();
        Object[] objColumnas=new Object[objDefaultTableModel.getColumnCount()];
        
        if (objTFbusquedaPorNombre.getText().isEmpty())
        {
            for (int i = 0; i < pbALusuario.size(); i++)
            {
                objColumnas[0] = pbALusuario.get(i).getpbSNombre();
                objColumnas[1] = pbALusuario.get(i).getpbSApellidoPaterno();
                objColumnas[2] = pbALusuario.get(i).getpbSApellidoMaterno();
                objColumnas[3] = pbALusuario.get(i).getpbSNombreDeUsuario();
                objColumnas[4] = pbALusuario.get(i).getpbEStatus();
                objColumnas[5]=pbALusuario.get(i).getpbSFechaIngreso();
                objDefaultTableModel.addRow(objColumnas);
                //System.out.println(objColumnas[1]=pbALusuario.get(i).getiIdUsuario());
            }
            objTusuarios.setModel(objDefaultTableModel);
        }
        if (!objTFbusquedaPorNombre.getText().isEmpty())
        {
            String keypress="";
            if (evt.getKeyChar() != '\n') 
            {
                keypress=String.valueOf(evt.getKeyChar());
            }
            String cadena=CMayusculasPalabra.cambiaMayuscula(objTFbusquedaPorNombre.getText()+keypress);
            for (int i = 0; i < pbALusuario.size(); i++)
            {
                if (String.valueOf(pbALusuario.get(i).getpbSNombre().trim()).equals(cadena))
                {
                    objColumnas[0] = pbALusuario.get(i).getpbSNombre();
                    objColumnas[1] = pbALusuario.get(i).getpbSApellidoPaterno();
                    objColumnas[2] = pbALusuario.get(i).getpbSApellidoMaterno();
                    objColumnas[3] = pbALusuario.get(i).getpbSNombreDeUsuario();
                    objColumnas[4] = pbALusuario.get(i).getpbEStatus();
                    objColumnas[5]=pbALusuario.get(i).getpbSFechaIngreso();
                    objDefaultTableModel.addRow(objColumnas);
                }
                objTusuarios.setModel(objDefaultTableModel);
            }   
        }
    }//GEN-LAST:event_objTFbusquedaPorNombreKeyPressed

    private void objTFexpedienteKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_objTFexpedienteKeyPressed
    {//GEN-HEADEREND:event_objTFexpedienteKeyPressed
        if (evt.getKeyChar() == '\n' || evt.getKeyChar() == '\t' || evt.getKeyChar() == 77)
        {
            CManipulaInterfaz.cmetpbCambia(objTFtelefonoOficina);
        }
    }//GEN-LAST:event_objTFexpedienteKeyPressed

    private void objTFciudadActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_objTFciudadActionPerformed
    {//GEN-HEADEREND:event_objTFciudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_objTFciudadActionPerformed

    private void objCBbusquedaPorStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objCBbusquedaPorStatusActionPerformed
        String campo[]=
        {
            "Nombre","Apellido P.","Apellido M.","Usuario","Status","Fecha Ingreso"
        };
        DefaultTableModel objDefaultTableModel= new DefaultTableModel(null,campo);
        Object[] objColumnas=new Object[objDefaultTableModel.getColumnCount()];
        
        if (objCBbusquedaPorStatus.getSelectedItem()=="Activo")
        {
            for (int i = 0; i<pbALusuario.size() ; i++)
            {
                if(pbALusuario.get(i).getpbEStatus()== 1)
                {
                    objColumnas[0] = pbALusuario.get(i).getpbSNombre();
                    objColumnas[1] = pbALusuario.get(i).getpbSApellidoPaterno();
                    objColumnas[2] = pbALusuario.get(i).getpbSApellidoMaterno();
                    objColumnas[3] = pbALusuario.get(i).getpbSNombreDeUsuario();
                    objColumnas[4] = pbALusuario.get(i).getpbEStatus();
                    objColumnas[5]=pbALusuario.get(i).getpbSFechaIngreso();
                    objDefaultTableModel.addRow(objColumnas);
                    //System.out.println(objColumnas[1]=pbALusuario.get(i).getiIdUsuario());
                }
            }
            System.out.println(pbALusuario.get(0).getpbSNombre());
            objTusuarios.setModel(objDefaultTableModel);
        }else if(objCBbusquedaPorStatus.getSelectedItem()=="Inactivo")
        {
            for (int i = 0; i<pbALusuario.size() ; i++)
            {
                if(pbALusuario.get(i).getpbEStatus()== 0)
                {
                    objColumnas[0] = pbALusuario.get(i).getpbSNombre();
                    objColumnas[1] = pbALusuario.get(i).getpbSApellidoPaterno();
                    objColumnas[2] = pbALusuario.get(i).getpbSApellidoMaterno();
                    objColumnas[3] = pbALusuario.get(i).getpbSNombreDeUsuario();
                    objColumnas[4] = pbALusuario.get(i).getpbEStatus();
                    objColumnas[5]=pbALusuario.get(i).getpbSFechaIngreso();
                    objDefaultTableModel.addRow(objColumnas);
                    //System.out.println(objColumnas[1]=pbALusuario.get(i).getiIdUsuario());
                }
            }
            System.out.println(pbALusuario.get(0).getpbSNombre());
            objTusuarios.setModel(objDefaultTableModel);

        }else if(objCBbusquedaPorStatus.getSelectedItem()=="Suspendido por daño")
        {
            System.out.println("Vetado");
            for (int i = 0; i<pbALusuario.size() ; i++)
            {
                if(pbALusuario.get(i).getpbEStatus()== 2)
                {
                    objColumnas[0] = pbALusuario.get(i).getpbSNombre();
                    objColumnas[1] = pbALusuario.get(i).getpbSApellidoPaterno();
                    objColumnas[2] = pbALusuario.get(i).getpbSApellidoMaterno();
                    objColumnas[3] = pbALusuario.get(i).getpbSNombreDeUsuario();
                    objColumnas[4] = pbALusuario.get(i).getpbEStatus();
                    objColumnas[5]=pbALusuario.get(i).getpbSFechaIngreso();
                    objDefaultTableModel.addRow(objColumnas);
                    //System.out.println(objColumnas[1]=pbALusuario.get(i).getiIdUsuario());
                }
            }
            System.out.println(pbALusuario.get(0).getpbSNombre());
            objTusuarios.setModel(objDefaultTableModel);
        }else if(objCBbusquedaPorStatus.getSelectedItem()=="Suspendido por adeudo")
        {
            System.out.println("Vetado");
            for (int i = 0; i<pbALusuario.size() ; i++)
            {
                if(pbALusuario.get(i).getpbEStatus()== 3)
                {
                    objColumnas[0] = pbALusuario.get(i).getpbSNombre();
                    objColumnas[1] = pbALusuario.get(i).getpbSApellidoPaterno();
                    objColumnas[2] = pbALusuario.get(i).getpbSApellidoMaterno();
                    objColumnas[3] = pbALusuario.get(i).getpbSNombreDeUsuario();
                    objColumnas[4] = pbALusuario.get(i).getpbEStatus();
                    objColumnas[5]=pbALusuario.get(i).getpbSFechaIngreso();
                    objDefaultTableModel.addRow(objColumnas);
                    //System.out.println(objColumnas[1]=pbALusuario.get(i).getiIdUsuario());
                }
            }
            System.out.println(pbALusuario.get(0).getpbSNombre());
            objTusuarios.setModel(objDefaultTableModel);
        }else if(objCBbusquedaPorStatus.getSelectedItem()=="Suspendido por Daño y Adeudo")
        {
            System.out.println("Vetado");
            for (int i = 0; i<pbALusuario.size() ; i++)
            {
                if(pbALusuario.get(i).getpbEStatus()== 4)
                {
                    objColumnas[0] = pbALusuario.get(i).getpbSNombre();
                    objColumnas[1] = pbALusuario.get(i).getpbSApellidoPaterno();
                    objColumnas[2] = pbALusuario.get(i).getpbSApellidoMaterno();
                    objColumnas[3] = pbALusuario.get(i).getpbSNombreDeUsuario();
                    objColumnas[4] = pbALusuario.get(i).getpbEStatus();
                    objColumnas[5]=pbALusuario.get(i).getpbSFechaIngreso();
                    objDefaultTableModel.addRow(objColumnas);
                    //System.out.println(objColumnas[1]=pbALusuario.get(i).getiIdUsuario());
                }
            }
            System.out.println(pbALusuario.get(0).getpbSNombre());
            objTusuarios.setModel(objDefaultTableModel);
        } else
        {
            for (int i = 0; i<pbALusuario.size() ; i++)
            {
                objColumnas[0] = pbALusuario.get(i).getpbSNombre();
                objColumnas[1] = pbALusuario.get(i).getpbSApellidoPaterno();
                objColumnas[2] = pbALusuario.get(i).getpbSApellidoMaterno();
                objColumnas[3] = pbALusuario.get(i).getpbSNombreDeUsuario();
                objColumnas[4] = pbALusuario.get(i).getpbEStatus();
                objColumnas[5] = pbALusuario.get(i).getpbSFechaIngreso();
                objDefaultTableModel.addRow(objColumnas);
            }
            System.out.println(pbALusuario.get(0).getpbSNombre());
            objTusuarios.setModel(objDefaultTableModel);
        }
    }//GEN-LAST:event_objCBbusquedaPorStatusActionPerformed

    private void jCBTipoBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBTipoBusquedaActionPerformed
       
    }//GEN-LAST:event_jCBTipoBusquedaActionPerformed

    private void jCBTipoBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCBTipoBusquedaKeyPressed
        // TODO add your handling code here:
        if(jCBTipoBusqueda.getSelectedIndex()==0)
        {
            jLnombre.setVisible(true);
            objTFbusquedaPorNombre.setVisible(true);
            objCBbusquedaPorStatus.setVisible(false);
        } else
        {
            if(jCBTipoBusqueda.getSelectedIndex()==1)
            {
                objCBbusquedaPorStatus.setVisible(true);
                objTFbusquedaPorNombre.setText("");
                jLnombre.setVisible(false);
                objTFbusquedaPorNombre.setVisible(false);
            }
        }
    }//GEN-LAST:event_jCBTipoBusquedaKeyPressed

    private void jCBTipoBusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCBTipoBusquedaMouseClicked
        if(jCBTipoBusqueda.getSelectedIndex()==0)
        {
            jLnombre.setVisible(true);
            objTFbusquedaPorNombre.setVisible(true);
            objCBbusquedaPorStatus.setVisible(false);
        } else
        {
            if(jCBTipoBusqueda.getSelectedIndex()==1)
            {
                objCBbusquedaPorStatus.setVisible(true);
                objTFbusquedaPorNombre.setText("");
                jLnombre.setVisible(false);
                objTFbusquedaPorNombre.setVisible(false);
            }
        }
    }//GEN-LAST:event_jCBTipoBusquedaMouseClicked

    private void objCBvestuarioMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_objCBvestuarioMouseClicked
    {//GEN-HEADEREND:event_objCBvestuarioMouseClicked
        ArrayList<Object> lALcolores = new ArrayList();
        char lCsexoU = objCBsexo.getSelectedItem().toString().charAt(0);
        String lSprenda;

        for (int lEi = 0; lEi < cVestuarios.size(); lEi ++)
        {
            if(cVestuarios.get(lEi).getPvSDescripcion().trim().equals(objCBvestuario.getSelectedItem().toString()) && lCsexoU==cVestuarios.get(lEi).getPvCSexo())
            {
                lALcolores.add(cVestuarios.get(lEi).getPvSColor().trim());
            }
        }
        objCBcolorV.setModel(new DefaultComboBoxModel(lALcolores.toArray()));
    }//GEN-LAST:event_objCBvestuarioMouseClicked

    private void objCBvestuarioKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_objCBvestuarioKeyPressed
    {//GEN-HEADEREND:event_objCBvestuarioKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            CManipulaInterfaz.cmetpbHabilita(true, objCBcolorV);
            ArrayList<Object> lALcolores = new ArrayList();
            char lCsexoU = objCBsexo.getSelectedItem().toString().charAt(0);

            for (int lEi = 0; lEi < cVestuarios.size(); lEi ++)
            {
                if(cVestuarios.get(lEi).getPvSDescripcion().trim().equals(objCBvestuario.getSelectedItem().toString()) && lCsexoU==cVestuarios.get(lEi).getPvCSexo())
                {
                    lALcolores.add(cVestuarios.get(lEi).getPvSColor().trim());
                }
            }

            objCBcolorV.setModel(new DefaultComboBoxModel(lALcolores.toArray()));
        }
    }//GEN-LAST:event_objCBvestuarioKeyPressed

    private void objCBcolorVMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_objCBcolorVMouseClicked
    {//GEN-HEADEREND:event_objCBcolorVMouseClicked
        //agregamos los titulos de las tabla
        String campo[]=
        {
            "Numero","Pieza","Color","Id","Clave"
        };

        DefaultTableModel objDefaultTableModel= new DefaultTableModel(null,campo);
        Object[] objAOcolumnas = new Object[objDefaultTableModel.getColumnCount()];

        int lEidVestuario=0;
        for (int lEi = 0; lEi < cVestuarios.size(); lEi ++)
        {
            if(cVestuarios.get(lEi).getPvSDescripcion().trim().equals(objCBvestuario.getSelectedItem().toString())
                && objCBcolorV.getSelectedItem().toString().equals(cVestuarios.get(lEi).getPvSColor().trim()))
            {
                lEidVestuario=cVestuarios.get(lEi).getPvEIdVestuario();
            }

            if (cInventarios!=null)
            {
                for (int lEj = 0; lEj < cInventarios.size(); lEj++)
                {
                    if (cInventarios.get(lEj).getPvEIdVestuario()==lEidVestuario)
                    {
                        objAOcolumnas[0] = lEidVestuario;
                        objAOcolumnas[1] = objCBvestuario.getSelectedItem().toString();
                        objAOcolumnas[2] = objCBcolorV.getSelectedItem().toString();
                        objAOcolumnas[3] = cInventarios.get(lEj).getPvEIdInventario();
                        objAOcolumnas[4] = cInventarios.get(lEj).getPvSClaveVestuario();
                        objDefaultTableModel.addRow(objAOcolumnas);
                    } else
                    {
                        if (lEj==cInventarios.size())
                        {
                            CMensajes.cmetpbFalla(this, "No hay datos de ese vestuario");
                        }
                    }
                }
                objTtablaInventarios.setModel(objDefaultTableModel);
            }else
            {
                CMensajes.cmetpbFalla(this, "No hay datos");
            }
        }
    }//GEN-LAST:event_objCBcolorVMouseClicked

    private void objCBcolorVKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_objCBcolorVKeyPressed
    {//GEN-HEADEREND:event_objCBcolorVKeyPressed
        if (evt.getKeyChar() == '\n')
        {
            objTtablaInventarios.enable(true);
            //agregamos los titulos de las tabla
            String campo[]=
            {
                "Numero","Pieza","Color","Id","Clave"
            };
            DefaultTableModel objDefaultTableModel1 = new DefaultTableModel(null,campo);
            Object[] objAOcolumnas = new Object[objDefaultTableModel1.getColumnCount()];

            int lEidVestuario=0;
            for (int lEi = 0; lEi < cVestuarios.size(); lEi ++)
            {
                if(cVestuarios.get(lEi).getPvSDescripcion().trim().equals(objCBvestuario.getSelectedItem().toString())
                    && objCBcolorV.getSelectedItem().toString().equals(cVestuarios.get(lEi).getPvSColor().trim()))
                {
                    lEidVestuario=cVestuarios.get(lEi).getPvEIdVestuario();
                }
            }

            if (cInventarios!=null)
            {
                for (int lEi = 0; lEi < cInventarios.size(); lEi++)
                {
                    if (cInventarios.get(lEi).getPvEIdVestuario()==lEidVestuario)
                    {
                        objAOcolumnas[0] = lEidVestuario;
                        objAOcolumnas[1] = objCBvestuario.getSelectedItem().toString();
                        objAOcolumnas[2] = objCBcolorV.getSelectedItem().toString();
                        objAOcolumnas[3] = cInventarios.get(lEi).getPvEIdInventario();
                        objAOcolumnas[4] = cInventarios.get(lEi).getPvSClaveVestuario();
                        objDefaultTableModel1.addRow(objAOcolumnas);
                    }else
                    {
                        if (lEi==cInventarios.size())
                        {
                            CMensajes.cmetpbFalla(this, "No hay datos de ese vestuario");
                        }
                    }
                }
                objTtablaInventarios.setModel(objDefaultTableModel1);
            }else
            {
                CMensajes.cmetpbFalla(this, "No hay datos");
            }
        }
    }//GEN-LAST:event_objCBcolorVKeyPressed

    private void objBagregarVActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_objBagregarVActionPerformed
    {//GEN-HEADEREND:event_objBagregarVActionPerformed
        int lEfilaSel = objTtablaInventarios.getSelectedRow();
        DefaultTableModel lDTMm = (DefaultTableModel) objTvestuarioUsuario.getModel();
        boolean lBaux=false;
        try
        {
            String lSnumeroVestuario,lSidInventario,lSpieza,lScolor,lSclave;
            lSnumeroVestuario= objTtablaInventarios.getValueAt(lEfilaSel, 0).toString();
            lSpieza=objTtablaInventarios.getValueAt(lEfilaSel, 1).toString();
            lScolor=objTtablaInventarios.getValueAt(lEfilaSel, 2).toString();
            lSidInventario=objTtablaInventarios.getValueAt(lEfilaSel, 3).toString();
            lSclave=objTtablaInventarios.getValueAt(lEfilaSel, 4).toString();

            if (objTvestuarioUsuario.getRowCount() != 0)
                {
                    for (int i = 0; i < objTvestuarioUsuario.getRowCount(); i++)
                    {
                        String lSauxComparaTIS= objTvestuarioUsuario.getValueAt(i,4).toString();

                        if(!lSauxComparaTIS.equalsIgnoreCase(lSclave))
                        {
                            lBaux=true;
                        } else
                        {
                            CMensajes.cmetpbFalla(this, "Este vestuario ya esta seleccionado para el usuario, elige uno distinto.");
                            lBaux= false;
                            break;
                        }
                    }
                } else
                {
                    lBaux= true;
                }
            

            if(lBaux==true)
            {
                String lFilaSeleccionada[]={lSnumeroVestuario,lSpieza,lScolor,lSidInventario,lSclave};
                lDTMm.addRow(lFilaSeleccionada);
                objTvestuarioUsuario.setModel(lDTMm);
            }

        } catch (Exception lEXe)
        {
            CMensajes.cmetpbFalla(this, "Selecciona una fila"+lEXe);
        }

    }//GEN-LAST:event_objBagregarVActionPerformed

    private void objBquitarVActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_objBquitarVActionPerformed
    {//GEN-HEADEREND:event_objBquitarVActionPerformed
        int lEfilaSel;
        try
        {
            lEfilaSel = objTvestuarioUsuario.getSelectedRow();
            if(lEfilaSel==-1)
            {
                CMensajes.cmetpbFalla(this, "No seleccionaste ninguna fila de la tabla");
            }else
            {
                DefaultTableModel m = (DefaultTableModel) objTvestuarioUsuario.getModel();
                m.removeRow(lEfilaSel);
            }
        } catch (Exception lEXe)
        {
        }
    }//GEN-LAST:event_objBquitarVActionPerformed

    private void objTusuariosMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_objTusuariosMouseEntered
    {//GEN-HEADEREND:event_objTusuariosMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_objTusuariosMouseEntered

    private void objCBvestuarioActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_objCBvestuarioActionPerformed
    {//GEN-HEADEREND:event_objCBvestuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_objCBvestuarioActionPerformed

    private void objBguardarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_objBguardarActionPerformed
    {//GEN-HEADEREND:event_objBguardarActionPerformed
        CQuerys objConsulta=new CQuerys();
        String campos="tipodeusuario,nombreDeUsuario,contrasenia,status,fechaingreso,expediente,nombre,apellidopaterno,apellidomaterno,sexo,calle,"
                + "numero,colonia,ciudad,estado,cp,telcelular,telcasa,teloficina,correo,fechanac,lugarnacimiento,estadocivil,pasaporte,vigenciapasaporte,nocartillamilitar,"
                + "estatura,responsable,telresponsable,tiposanguineo,alergias,enfermedades,nombremedicocabecera,telmedicocabecera,"
                + "medicaciondiarrea,medicaciondolorcabeza,medicaciondolorestomago,medicaciondolormuscular,medicaciongripa,medicacionotro,formadeenterarse,baila,baile,lugardondebailaba,"
                + "tiempoquebailo,preguntasecreta,respuestasecreta,comentario";
        int num,noCartillaMilitar;
        if (objTFnumero.equals("S/N"))
        {
           num=0;
        } else
        {
            num =Integer.parseInt(objTFnumero.getText());
        }
        String sFechanac = new SimpleDateFormat("yyyy/MM/dd").format(objCDfechaNacimientoE.getDate());
        String sFechaing = new SimpleDateFormat("yyyy/MM/dd").format(objCDfechaIngreso.getDate());
        String sVigenciaPas = new SimpleDateFormat("yyyy/MM/dd").format(objCDvigenciaPasaporteE.getDate());
        if (objTFcartillaMilitar.getText().equals("No tiene"))
        {
            noCartillaMilitar=0;
        } else
        {
            noCartillaMilitar=Integer.parseInt(objTFcartillaMilitar.getText());
        }
        
        CUsuariosDE objCModificarUsuario = new CUsuariosDE (1,objCBTipo.getSelectedItem().toString().charAt(0),objTFusername.getText().trim(),
                objPFcontrasenia.getText(),objCstatus.getSelectedIndex(),sFechaing, Integer.parseInt(objTFexpediente.getText()),
                objTFnombre.getText().trim(),objTFapellidoPaterno.getText().trim(),objTFapellidoMaterno.getText(),objCBsexo.getSelectedItem().toString().charAt(0),
                objTFcalle.getText().trim(),num,objTFcolonia.getText().trim(),objTFciudad.getText().trim(),String.valueOf(objCBEstado.getSelectedItem()),
                Integer.parseInt(objTFcodigoPostal.getText()),objTFtelefonoCelular.getText().trim(),objTFtelefonoCasa.getText().trim(),objTFtelefonoOficina.getText().trim(),objTFcorreo.getText().trim(),
                sFechanac,objTFnacimiento.getText(),objCBestadoCivil.getSelectedItem().toString().charAt(0),String.valueOf(objCBpasaporte.getSelectedItem()),
                sVigenciaPas,noCartillaMilitar,Double.parseDouble(objTFestatura.getText()),objTFestatura.getText(),objTFtelefonoResponsable.getText().trim(),
                String.valueOf(objCBtiposangre.getSelectedItem()),objTFalergias.getText().trim(),objTFenfermedades.getText().trim(),objTFnombresMedico.getText(),
                objTFtelefonoMedico.getText().trim(),objTFdiarrea.getText().trim(),objTFdolorCabeza.getText().trim(),objTFdolorEstomago.getText(),objTFdolorMuscular.getText(),objTFgripa.getText(),
                objTFotros.getText(),objTFformaEnterarse.getText(),objCBbailadoAntes.getSelectedItem().toString(),objTFtipoBaile.getText(),objTFcompania.getText(),
                objTFperiodo.getText(),objCBpreguntaSecreta.getSelectedIndex(),objTFrespuesta.getText(),objTFcomentario.getText());
        
        String s = "'"+objCModificarUsuario.getpbCTipoUsuario()+"','"+
                objCModificarUsuario.getpbSNombreDeUsuario()+"','"+
                objCModificarUsuario.getpbSContrasena().trim()+"','"+
                String.valueOf(objCModificarUsuario.getpbEStatus())+"','"+
                objCModificarUsuario.getpbSFechaIngreso()+"','"+
                String.valueOf(objCModificarUsuario.getpbEExpediente())+"','"+
                objCModificarUsuario.getpbSNombre()+"','"+
                objCModificarUsuario.getpbSApellidoPaterno()+"','"+
                objCModificarUsuario.getpbSApellidoMaterno()+"','"+
                objCModificarUsuario.getpbCSexo()+"','"+
                objCModificarUsuario.getpbSCalle()+"','"+
                String.valueOf(objCModificarUsuario.getpbENumero())+"','"+
                objCModificarUsuario.getpbSColonia()+"','"+
                objCModificarUsuario.getpbSCiudad()+"','"+
                objCModificarUsuario.getpbSEstado()+"','"+
                String.valueOf(objCModificarUsuario.getpbECp())+"','"+
                objCModificarUsuario.getpbSTelCelular()+"','"+
                objCModificarUsuario.getpbSTelCasa()+"','"+
                objCModificarUsuario.getpbSTelOficina()+"','"+
                objCModificarUsuario.getpbSEmail()+"','"+
                objCModificarUsuario.getpbSFechaNacimiento()+"','"+
                objCModificarUsuario.getpbSLugarNacimiento()+"','"+
                objCModificarUsuario.getpbCEstadoCivil()+"','"+
                objCModificarUsuario.getpbSPasaporteSN()+"','"+
                objCModificarUsuario.getpbSVigenciaPasaporte()+"','"+
                String.valueOf(objCModificarUsuario.getpbENoCartillaMilitar())+"','"+
                String.valueOf(objCModificarUsuario.getpbDEstatura())+"','"+
                objCModificarUsuario.getpbSResponsable()+"','"+
                objCModificarUsuario.getpbSTelResponsable()+"','"+
                objCModificarUsuario.getpbSTipoSanguineo()+"','"+
                objCModificarUsuario.getpbSAlergias()+"','"+
                objCModificarUsuario.getpbSEnfermedades()+"','"+
                objCModificarUsuario.getpbSNombreMedicoCabecera()+"','"+
                objCModificarUsuario.getpbSTelMedicoDeCabecera()+"','"+
                objCModificarUsuario.getpbSMedicacionDiarrea()+"','"+
                objCModificarUsuario.getpbSMedicacionDolorDeCabeza()+"','"+
                objCModificarUsuario.getpbSMedicacionDolorDeEstomago()+"','"+
                objCModificarUsuario.getpbSMedicacionDolorMuscular()+"','"+
                objCModificarUsuario.getpbSMedicacionGripa()+"','"+
                objCModificarUsuario.getpbSMedicacionOtro()+"','"+
                objCModificarUsuario.getpbSFormaDeEnterarse()+"','"+
                objCModificarUsuario.getpbSBaila()+"','"+
                objCModificarUsuario.getpbSBaile()+"','"+
                objCModificarUsuario.getpbSAnteriorBallet()+"','"+
                objCModificarUsuario.getpbSTiempoQueBailo()+"','"+
                objCModificarUsuario.getpbEPreguntaSecreta()+"','"+
                objCModificarUsuario.getpbSRespuestaSecreta()+"','"+
                objCModificarUsuario.getpbSComentario()+"'";
        
        String objResultado=objConsulta.metpbSModificar(con, "usuarios", campos,s,"idusuario="+objTFidU.getText().trim());
        if (objResultado==null)
        {
            CMensajes.cmetpbExito(this);
        }else
        {
            CMensajes.cmetpbFalla(this);
        }
        
        int LEidUaux= Integer.parseInt(objTFidU.getText().trim());
        String lSmVU=null;
        objConsulta.metpbSDelete(con, "vestuariousuario", "idusuario",""+LEidUaux);
        for (int lEi = 0; lEi < objTvestuarioUsuario.getRowCount(); lEi++)
        {
            DefaultTableModel lDTMm = (DefaultTableModel) objTvestuarioUsuario.getModel();
            int lEidInventario= Integer.parseInt(objTvestuarioUsuario.getValueAt(lEi, 3).toString().trim());
            CVestuarioUsuario objCVestuarioUsuario1 = new CVestuarioUsuario(1,LEidUaux,lEidInventario);
            String lSv = "null"+",'"+objCVestuarioUsuario1.getpbEidusuario()+"','"+ objCVestuarioUsuario1.getpbEidinventario()+"'";
            lSv= objConsulta.metpbSInsertar(con, "vestuariousuario", lSv);
        }
        
        if (lSmVU!=null)
        {
            CMensajes.cmetpbMsj(this, "El dato se ha insertado correctamente.");
        }else
        {
            CMensajes.cmetpbMsj(this,"Dato no insertado");
        }
        
        
        
    }//GEN-LAST:event_objBguardarActionPerformed

    private void objCDfechaIngresoKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_objCDfechaIngresoKeyPressed
    {//GEN-HEADEREND:event_objCDfechaIngresoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_objCDfechaIngresoKeyPressed

    private void objCBpreguntaSecretaKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_objCBpreguntaSecretaKeyPressed
    {//GEN-HEADEREND:event_objCBpreguntaSecretaKeyPressed
        if (evt.getKeyChar() == '\n' || evt.getKeyChar() == '\t' || evt.getKeyChar() == 77)
        {
            CManipulaInterfaz.cmetpbCambia(objTFrespuesta);
        }        
    }//GEN-LAST:event_objCBpreguntaSecretaKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
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



//.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } 

catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(CConsultaUsuarios.class 


.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 

catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(CConsultaUsuarios.class 


.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 

catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(CConsultaUsuarios.class 


.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                CConsultaUsuarios objCConsultaUsuarios1= new CConsultaUsuarios();
                objCConsultaUsuarios1.setVisible(true);
                objCConsultaUsuarios1.setLayout(null);
                objCConsultaUsuarios1.setLocationRelativeTo(null);
                ImageIcon ImageIcon = new ImageIcon(getClass().getResource("../imagenes/ballet.png"));         
                Image image = ImageIcon.getImage();
                objCConsultaUsuarios1.setIconImage(image); 
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonModificar;
    private javax.swing.JLabel etiquetaFechaModificacion;
    private javax.swing.JButton jBAnterior;
    private javax.swing.JButton jBAnterior1;
    private javax.swing.JButton jBAnterior2;
    private javax.swing.JButton jBAnterior3;
    private javax.swing.JButton jBCancelar1;
    private javax.swing.JButton jBCancelar2;
    private javax.swing.JButton jBCancelar3;
    private javax.swing.JButton jBCancelar4;
    private javax.swing.JButton jBCancelar5;
    private javax.swing.JButton jBSiguiente1;
    private javax.swing.JButton jBSiguiente2;
    private javax.swing.JButton jBSiguiente3;
    private javax.swing.JButton jBSiguiente4;
    private javax.swing.JButton jBSiguiente5;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jCBTipoBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLnombre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTPPestanias;
    private javax.swing.JButton objBagregarV;
    private javax.swing.JButton objBbotonEliminar;
    private javax.swing.JButton objBguardar;
    private javax.swing.JButton objBquitarV;
    private javax.swing.JComboBox<String> objCBEstado;
    private javax.swing.JComboBox objCBTipo;
    private javax.swing.JComboBox<String> objCBbailadoAntes;
    private javax.swing.JComboBox<String> objCBbusquedaPorStatus;
    private javax.swing.JComboBox<String> objCBcolorV;
    private javax.swing.JComboBox<String> objCBestadoCivil;
    private javax.swing.JComboBox objCBliberada;
    private javax.swing.JComboBox objCBpasaporte;
    private javax.swing.JComboBox<String> objCBpreguntaSecreta;
    private javax.swing.JComboBox<String> objCBsexo;
    private javax.swing.JComboBox objCBtiposangre;
    private javax.swing.JComboBox<String> objCBvestuario;
    private com.toedter.calendar.JDateChooser objCDfechaIngreso;
    private com.toedter.calendar.JDateChooser objCDfechaNacimientoE;
    private com.toedter.calendar.JDateChooser objCDvigenciaPasaporteE;
    private javax.swing.JComboBox objCstatus;
    private javax.swing.JPasswordField objPFconfirmar;
    private javax.swing.JPasswordField objPFcontrasenia;
    private javax.swing.JTextField objTFaccidente;
    private javax.swing.JTextField objTFalergias;
    private javax.swing.JTextField objTFapellidoMaterno;
    private javax.swing.JTextField objTFapellidoPaterno;
    private javax.swing.JTextField objTFbusquedaPorNombre;
    private javax.swing.JTextField objTFcalle;
    private javax.swing.JTextField objTFcartillaMilitar;
    private javax.swing.JTextField objTFciudad;
    private javax.swing.JTextField objTFcodigoPostal;
    private javax.swing.JTextField objTFcolonia;
    private javax.swing.JTextField objTFcomentario;
    private javax.swing.JTextField objTFcompania;
    private javax.swing.JTextField objTFcorreo;
    private javax.swing.JTextField objTFdiarrea;
    private javax.swing.JTextField objTFdolorCabeza;
    private javax.swing.JTextField objTFdolorEstomago;
    private javax.swing.JTextField objTFdolorMuscular;
    private javax.swing.JTextField objTFenfermedades;
    private javax.swing.JTextField objTFestadoRepublica;
    private javax.swing.JTextField objTFestatura;
    private javax.swing.JTextField objTFexpediente;
    private javax.swing.JTextField objTFfechaIngreso;
    private javax.swing.JTextField objTFfechaNacimiento;
    private javax.swing.JTextField objTFformaEnterarse;
    private javax.swing.JTextField objTFgripa;
    private javax.swing.JTextField objTFidU;
    private javax.swing.JTextField objTFnacimiento;
    private javax.swing.JTextField objTFnombre;
    private javax.swing.JTextField objTFnombreU;
    private javax.swing.JTextField objTFnombresMedico;
    private javax.swing.JTextField objTFnumero;
    private javax.swing.JTextField objTFotros;
    private javax.swing.JTextField objTFperiodo;
    private javax.swing.JTextField objTFrespuesta;
    private javax.swing.JTextField objTFtelefonoCasa;
    private javax.swing.JTextField objTFtelefonoCelular;
    private javax.swing.JTextField objTFtelefonoMedico;
    private javax.swing.JTextField objTFtelefonoOficina;
    private javax.swing.JTextField objTFtelefonoResponsable;
    private javax.swing.JTextField objTFtipoBaile;
    private javax.swing.JTextField objTFusername;
    private javax.swing.JTextField objTFvigenciaPasaporte;
    private javax.swing.JTable objTtablaInventarios;
    private javax.swing.JTable objTusuarios;
    private javax.swing.JTable objTvestuarioUsuario;
    // End of variables declaration//GEN-END:variables
}
