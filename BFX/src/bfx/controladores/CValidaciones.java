/*Nombre de clase		: CValidaciones
*Descripción de la clase	: Clase que contiene las validaciones a aplicar en el sistema
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
 * Verificacion de contenido de campos.
 * @author: Techno Engineers
 * @versión: 3.0 
 */
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CValidaciones
{
       
    private static final String sEstructuraValidaEmail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static boolean bCorreoValido = false;
     /**
     * cmetpbEntero: permite escribir solo dígitos enteros
     *
     * @param lKEevt parametro para manipular el evento
     */
    public static void cmetpbEntero(KeyEvent lKEevt)
    {
        if((lKEevt.getKeyChar() < '0' || lKEevt.getKeyChar() > '9' ) &&
           lKEevt.getKeyCode() != 8)
        {
            lKEevt.setKeyChar((char)8);
        }
    }
      
    /**
     * cmetpbAlfabetico: permite escribir solo caracteres del alfabeto
     *
     * @param lKEevt parametro para manipular el evento
     */
    public static void cmetpbAlfabetico(KeyEvent lKEevt)
    {
        if((lKEevt.getKeyChar() < 'a' || lKEevt.getKeyChar() > 'z' ) &&
           (lKEevt.getKeyChar() < 'A' || lKEevt.getKeyChar() > 'Z' ) &&
           lKEevt.getKeyCode() != 8 && lKEevt.getKeyChar() != ' ' &&
           lKEevt.getKeyChar() != 'á' && lKEevt.getKeyChar() != 'Á' &&
           lKEevt.getKeyChar() != 'é' && lKEevt.getKeyChar() != 'É' &&
           lKEevt.getKeyChar() != 'í' && lKEevt.getKeyChar() != 'Í' &&
           lKEevt.getKeyChar() != 'ó' && lKEevt.getKeyChar() != 'Ó' &&
           lKEevt.getKeyChar() != 'ú' && lKEevt.getKeyChar() != 'Ú' &&
           lKEevt.getKeyChar() != 'ñ' && lKEevt.getKeyChar() != 'Ñ' )
        {
            lKEevt.setKeyChar((char)8);
        }
    }
    
    /**
     * cmetpbAlfabetico: permite escribir solo caracteres del alfabeto y dígitos
     *
     * @param lKEevt parametro para manipular el evento
     */
    public static void cmetpbAlfanumerico(KeyEvent lKEevt)
    {
        if((lKEevt.getKeyChar() < 'a' || lKEevt.getKeyChar() > 'z' ) &&
           (lKEevt.getKeyChar() < 'A' || lKEevt.getKeyChar() > 'Z' ) &&
           (lKEevt.getKeyChar() < '0' || lKEevt.getKeyChar() > '9' ) &&
           lKEevt.getKeyCode() != 8 && lKEevt.getKeyChar() != ' ' &&
           lKEevt.getKeyChar() != 'ñ' && lKEevt.getKeyChar() != 'Ñ' )
        {
            lKEevt.setKeyChar((char)8);
        }
    }
    
    /**
     * cmetpbFlotante: permite escribir dígitos con decimales
     *
     * @param lKEevt parametro para manipular el evento
     */
    public static void cmetpbFlotante(KeyEvent lKEevt)
    {
        if((lKEevt.getKeyChar() < '0' || lKEevt.getKeyChar() > '9' ) &&
           lKEevt.getKeyCode() != 8 && lKEevt.getKeyChar() != '.')
        {
           lKEevt.setKeyChar((char)8);
        }
    }
    
    /**
     * cmetpbCorreo: valida la sintaxis del correo electrónico
     *
     * @param lKEevt parametro para manipular el evento
     */
    public static void cmetpbCorreo(KeyEvent lKEevt)
    {
        if((lKEevt.getKeyChar() < 'a' || lKEevt.getKeyChar() > 'z' ) &&
           (lKEevt.getKeyChar() < '0' || lKEevt.getKeyChar() > '9' ) &&
           lKEevt.getKeyCode() != 8 &&
           lKEevt.getKeyChar() != '.' && lKEevt.getKeyChar() != '@' &&
           lKEevt.getKeyChar() != '_' && lKEevt.getKeyChar() != '-' )
        {
             lKEevt.setKeyChar((char)8);
        }
    }
    
    /**
     * cmetpbHora: valida el formato de la hora 
     *
     * @param lKEevt parametro para manipular el evento
     */
    public static void cmetpbHora(KeyEvent lKEevt)
    {
        if((lKEevt.getKeyChar() < '0' || lKEevt.getKeyChar() > '9' ) &&
           lKEevt.getKeyCode() != 8 && lKEevt.getKeyChar() != ':')
        {
            lKEevt.setKeyChar((char)8);
        }
    }
    
     /**
     * cmetpbFecha: valida el formato de la fecha 
     *
     * @param lKEevt parametro para manipular el evento
     */
    public static void cmetpbFecha(KeyEvent lKEevt)
    {
        if((lKEevt.getKeyChar() < '0' || lKEevt.getKeyChar() > '9' ) &&
           lKEevt.getKeyCode() != 8 && lKEevt.getKeyChar() != '/')
        {
            lKEevt.setKeyChar((char)8);
        }
    }
    
    /**
     * cmetpbBValorFlotante: valida que el texto de un campo de texto sea un numero decimal
     *
     * @param lSs parametro que contiene el texto
     */
    public static boolean cmetpbBValorFlotante(String lSs)
    {
        try
        {
            double lDx = Double.parseDouble(lSs);
            return true;
        }catch(Exception lEXe)
        {
            return false;
        }
    }
    
    /**
     * cmetpbBValorEntero: valida que el texto de un campo de texto sea un numero entero
     *
     * @param lSs parametro que contiene el texto
     */
    public static boolean cmetpbBValorEntero(String lSs)
    {
        try
        {
            double lDx = Integer.parseInt(lSs);
            return true;
        }catch(Exception lEXe)
        {
            return false;
        }
    }
    
    /**
     * cmetpbBValorString: valida que el texto de un campo de texto sea solo alfanumerico
     * @param lSs parametro que contiene el texto
     */
    public static boolean cmetpbBValorString(String lSs)
    {
        try
        {
            String lSx = String.valueOf(lSs);
            return true;
        }catch(Exception lEXe)
        {
            return false;
        }
    }
    
    /**
     * cmetpbCjaEntero: valida que el texto de un campo de texto sea numerico para pasar al siguiente componente
     * @param lJTjt componente de la interfaz
     * @param lOobj componente siguiente de la interfaz
     * @param lJFjf frame que se valida
     */
    public static void cmetpbCjaEntero(JTextField lJTjt, Object lOobj, JFrame lJFjf)
    {

        try
        {
            int lEx = Integer.parseInt(lJTjt.getText());
            CManipulaInterfaz.cmetpbCambia(lOobj);
        } catch (Exception lEXe)
        {
            CMensajes.cmetpbMsj(lJFjf, "Se esperaba un entero");
            CManipulaInterfaz.cmetpbSelecciona(lJTjt);
            lJTjt.requestFocus();

        }

    }
    
    /**
     * cmetpbCjaDouble: valida que el texto de un campo de texto sea un numero decimal  para pasar al siguiente componente
     * @param lJTjt componente de la interfaz
     * @param lOobj componente siguiente de la interfaz
     * @param lJFjf frame que se valida
     */
    public static void cmetpbCjaDouble(JTextField lJTjt, Object lOobj, JFrame lJFjf)
    {

        try
        {
            double lDx = Double.parseDouble(lJTjt.getText());
            CManipulaInterfaz.cmetpbCambia(lOobj);
        } catch (Exception lEXe)
        {
            CMensajes.cmetpbMsj(lJFjf, "Se esperaba un flotante o es un verdaderpo idiota");
            CManipulaInterfaz.cmetpbSelecciona(lJTjt);
            lJTjt.requestFocus();

        }

    }
    
    /**
     * En esta funcion se valida el correo, esto lo hace mediante una expresión regular. También se valida que
     * la caja de correo no este vacía.
     * @param lScadena la cadena es recibida desde su llamado para validarla.
     * @param lJFjf es el frame donde se muestra el mensaje
     * @return valor boleano
     */
    public static boolean metpbBvalidaCorreo(String lScadena,JFrame lJFjf)
    {
        String sCadenaSinEspacios = lScadena.trim(); //Limpia la cadena de los espacios al final y al principio.
        /**
         * En el siguiente if:
         * Valida que la cadena sin espacios sea menor que cero, si eso pasa manda un mensaje de error,
         * ya que se requiere validar que haya correo y que sea valido.
         * Si no se cumple la condición entra en else.
         */
        if (sCadenaSinEspacios.length() == 0) 
        {
            bCorreoValido= true;
        } else
        {
            Pattern pattern = Pattern.compile(sEstructuraValidaEmail); //Guarda la expresión regular en un patrón.
            Matcher matcher = pattern.matcher(lScadena); //Compara la cadena recibida con la expresion almacenada en el patron.
            bCorreoValido = matcher.matches(); //matches nos regresa un valor booleano si se cumple la expresión, lo almacena en bCorreoValido.
            if (bCorreoValido!=true) //Si el correo es falso(invalido) entonces manda un error en pantalla.
            {
                CMensajes.cmetpbMsj(lJFjf, "Correo invalido, intentelo de nuevo.");
            }
        }
        return bCorreoValido; //Regresa el valor, el correo puede ser falso o verdadero.
    }
}
