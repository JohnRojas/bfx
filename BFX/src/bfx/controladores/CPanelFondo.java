/*Nombre de clase		: CPanelFondo
*Descripción de la clase	: Clase que permite colocar el fondo seleccionado en interfaz. 
*Fecha	de creación		: 01/05/2016
*Elaboró			: Mauro S. S.
*Fecha	de Liberación		: 01/05/2016
*Autorizó			: Mauro Sánchez Sánchez
*Fecha Mantenimiento		: 05/06/2016
*Folio mantenimiento		: 02
*Descripción del mantto.	: Se realizó la actualización de métodos y transformacion de código con calidad.
*Responsable			: Jatziry Barrera Hinojosa
*Revisor 			: Diego Enrique Sánchez Ordoñez
*/
package bfx.controladores;
/**
 * Fondo de interfaz.
 * @author: Techno Engineers
 * @versión: 3.0 
 */
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;

public class CPanelFondo extends JDesktopPane
{
    private Image pvIMimagen;

    public CPanelFondo(String lSt, String lSarch, int lEini, int lEfin ,int lEancho, int lEalto)
    {
        this.setLayout(null);
        this.setToolTipText(lSt);
        this.setBounds(lEini,lEfin,lEancho,lEalto);

        try
        {  
            pvIMimagen = ImageIO.read(getClass().getResource(lSarch));
        } catch (Exception lEXe)
        {
            lEXe.printStackTrace();
        }
    }

    public void paintComponent(Graphics lGg)
    {
        super.paintComponent(lGg);
        lGg.drawImage(pvIMimagen, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);  
    }
}
