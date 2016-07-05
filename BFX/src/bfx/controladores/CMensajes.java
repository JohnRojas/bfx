/*Nombre de clase		: CMensajes
*Descripción de la clase	: Clase donde se declaran los metodos para llamar al querer mostrar un mensaje informativo en interfaz. 
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
 * Respectivos mensajes para el usuario.
 * @author: Techno Engineers
 * @versión: 3.0 
 */
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CMensajes
{
    /**
     * cmetpbExito: Método que manda un mensaje de exito al usuario
     *
     * @param lJFframe interfaz en donde se visualiza el mensaje
     */
    public static void cmetpbExito(JFrame lJFframe)
    {
        JOptionPane.showMessageDialog(lJFframe, "La acción solicitada se ha realizado con éxito");
    }
    
    /**
     * cmetpbFalla: Método que manda un mensaje de falla al usuario
     *
     * @param lJFframe interfaz en donde se visualiza el mensaje
     */
    public static void cmetpbFalla(JFrame lJFframe)
    {
        JOptionPane.showMessageDialog(lJFframe, "La acción solicitada no se pudo concretar, verifique porfavor");
    }
    
    /**
     * cmetpbFalla: Método que manda un mensaje de exito al usuario
     *
     * @param lJFframe interfaz en donde se visualiza el mensaje
     * @param lSs mensaje que se visualizará
     */
    public static void cmetpbFalla(JFrame lJFframe, String lSs)
    {
        JOptionPane.showMessageDialog(lJFframe, lSs);
    }
    
    /**
     * cmetpbConsulta: Método que retorna un mensaje al usuario
     *
     * @param lJFframe interfaz en donde se vera el mensaje
     * @param lSs mensaje que se visualizará
     */
    public static int cmetpbConsulta(JFrame lJFframe,String lSs)
    {
        return JOptionPane.showConfirmDialog(lJFframe, lSs);
    }
    
    /**
     * cmetpbMsj: Método que muestra un mensaje de excepcion al usuario
     *
     * @param lJFframe interfaz en donde se vera el mensaje
     * @param lSs mensaje que se visualizará
     */
    public static void cmetpbMsj(JFrame lJFframe , String lSs)
    {
        if(lJFframe== null)
        {
            JOptionPane.showConfirmDialog(lJFframe, lSs);
        }
    }
    
    /**
     * cmetpbMsj: Método que muestra un mensaje con icono de error, precaución o información
     *
     * @param lSs mensaje que se visualizará
     * @param lSt titulo del mensaje
     * @param lEOpc número de opcion
     * @param lJFframe interfaz en donde se vera el mensaje
     */
    public static void cmetpbMsj(String lSs, String lSt, int lEOpc, JFrame lJFframe)
    {
        if (lJFframe == null)
        {
            System.out.println(lSs);
        } else
        {
            switch (lEOpc)
            {
                case 1:
                    JOptionPane.showMessageDialog(lJFframe, lSs, lSt,
                            JOptionPane.ERROR_MESSAGE);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(lJFframe, lSs, lSt,
                            JOptionPane.WARNING_MESSAGE);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(lJFframe, lSs, lSt,
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(lJFframe, lSs);
            }
        }
    }

    /**
     * cmetpbMsj: Método que muestra un menu con un combobox dentro
     * 
     * @param lJCmotivo combo rellenado con texto
     * @param lAOpcion número de opcion
     * @param lSTitulo titulo del mensaje
     * @return retorna el número de opción.
     */
    public static int cmetpbEMsjMenu(JComboBox<String> lJCmotivo, Object[] lAOpcion, String lSTitulo)
    {
        int lEValor = JOptionPane.showOptionDialog(null,
                lJCmotivo,
                lSTitulo,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,
                lAOpcion, lAOpcion[0]);
        return lEValor;
    }
    /**
     * cmetpbMsj: Método que muestra una pregunta en un panel
     * 
     * @param lSs  mensaje que se visualizará
     * @param lSt  titulo del mensaje
     * @param lJFframe interfaz en donde se vera el mensaje
     * @return  regresa el número 0 si fue aceptada y 1 si se cancela
     */
    public static int cmetpbEPregunta(String lSs, String lSt, JFrame lJFframe)
    {
        return JOptionPane.showConfirmDialog(lJFframe, lSs, lSt, JOptionPane.YES_NO_OPTION);
    }
}
