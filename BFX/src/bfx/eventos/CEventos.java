/*Nombre de clase		: CEventos
*Descripción de la clase	: Es la clase en donde se realiza las consultas de los vestuarios con su parte de inventarios. 
*Fecha	de creación		: 28/06/2016
*Elaboro			: Oscar De Paz Feliciano, Jonathan Rojas Simón, Diego Enrique Sánchez Ordoñez
*Fecha	de Liberación		: 08/06/2016
*Autorizó			: Mauro Sánchez Sánchez
*Fecha Mantenimiento		: 28/06/2016
*Folio mantenimiento		: 02
*Descripción del mantto.	: Se realizó pruebas, formulario y transformacion de código con calidad.
*Responsable			: Oscar De Paz Feliciano, Jonathan Rojas Simón, Diego Enrique Sánchez Ordoñez
*Revisor 			: Mauro Sánchez Sánchez
 */
package bfx.eventos;

/**
 * Interfaz para consultas generales y específicas en vestuarios e inventarios
 *
 * @author: Techno Engineers
 * @version 2.0
 */
import bfx.vestuarios.*;
import bfx.clases.CVestuarioInventarioTmp;
import java.awt.Image;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import bfx.controladores.*;

public class CEventos extends javax.swing.JFrame
{

    CPanelFondo objCPanelFondo;
    ArrayList<CVestuarioInventarioTmp> objALVestuarioInventario = new ArrayList<CVestuarioInventarioTmp>();
    JFrame objJFrame = new JFrame();
    private boolean pvBBandera = false;
    private Connection pvCNcon = CManipulaDB.cmetpbConectaDB();
    ImageIcon objImageIcon = new ImageIcon(getClass().getResource("../imagenes/xina.png"));
    Image objImage = objImageIcon.getImage();
    /***
     * Contructor por defecto donde se inicalizan los componentes, posición del JFrame y agregación
     * del fondo en el panel.
     */    
    public CEventos()
    {
        initComponents();
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        objCPanelFondo = new CPanelFondo("Altas de eventos", "../imagenes/ballet.png", 0, 0, 790, 380);
        this.add(objCPanelFondo);
        this.pack();
        this.setSize(790, 380);
        this.setIconImage(objImage);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        objTTablaDetalleEvento = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        objBbailarines = new javax.swing.JButton();
        objBBailes = new javax.swing.JButton();
        jLClave = new javax.swing.JLabel();
        objTFevento = new javax.swing.JTextField();
        jLSexo = new javax.swing.JLabel();
        objTFfecha = new javax.swing.JTextField();
        objBregistrarEvento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alta de eventos");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowOpened(java.awt.event.WindowEvent evt)
            {
                formWindowOpened(evt);
            }
        });

        objTTablaDetalleEvento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String []
            {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(objTTablaDetalleEvento);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingrese datos del evento", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial", 0, 12))); // NOI18N
        jPanel1.setOpaque(false);

        objBbailarines.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objBbailarines.setText("Seleccionar bailarines ...");

        objBBailes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objBBailes.setText("Detalles del baile ...");

        jLClave.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLClave.setText("Nombre del evento:");
        jLClave.setPreferredSize(new java.awt.Dimension(91, 25));

        jLSexo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLSexo.setText("Fecha de evento: ");
        jLSexo.setPreferredSize(new java.awt.Dimension(91, 25));

        objBregistrarEvento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        objBregistrarEvento.setText("Registrar Evento");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(objBregistrarEvento, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addComponent(jLClave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLSexo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objBbailarines, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addComponent(objTFevento, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(objTFfecha, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(objBBailes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(objTFevento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(objTFfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(objBbailarines, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(objBBailes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(objBregistrarEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
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

    }//GEN-LAST:event_formWindowOpened

    
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
                CEventos objCConsultarVestuarios = new CEventos();
                objCConsultarVestuarios.setVisible(true);
                ImageIcon objImageIcon = new ImageIcon(getClass().getResource("../imagenes/xina.png"));
                Image objImage = objImageIcon.getImage();
                objCConsultarVestuarios.setIconImage(objImage);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLClave;
    private javax.swing.JLabel jLSexo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton objBBailes;
    private javax.swing.JButton objBbailarines;
    private javax.swing.JButton objBregistrarEvento;
    private javax.swing.JTextField objTFevento;
    private javax.swing.JTextField objTFfecha;
    private javax.swing.JTable objTTablaDetalleEvento;
    // End of variables declaration//GEN-END:variables
}
