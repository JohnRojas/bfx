/*Nombre de clase		: CManipulaInterfaz
*Descripción de la clase	: Es la clase en donde se declaran los metodos que permiten utilizar los componentes de la interfaz. 
*Fecha	de creación		: 01/05/2016
*Elaboró			: Mauro S. S. && Techno Engineers
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
 * Métodos para manipular el frame.
 * @author: Techno Engineers
 * @versión: 3.0 
 */
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CManipulaInterfaz
{

    /**
     * Método que permite habilitar un componente de la interfaz.
     *
     * @param lBb bandera que permite activar un componente
     * @param lAOobjs arreglo de objetos que contiene los componentes a habilitar
     */
    public static void cmetpbHabilita (boolean lBb, Object... lAOobjs)
    {
        try
        {//Se recorre el arreglo de los componentes a habilitar
            for (int lEi = 0; lEi < lAOobjs.length; lEi++)
            {//Se habilitan los campos de texto
                if (lAOobjs[lEi] instanceof JTextField)
                {
                    JTextField lJTj = (JTextField) lAOobjs[lEi];
                    lJTj.setEnabled(lBb);
                } else
                {//Se habilitan los botones
                    if (lAOobjs[lEi] instanceof JButton)
                    {
                        JButton lJBj = (JButton) lAOobjs[lEi];
                        lJBj.setEnabled(lBb);
                    } else
                    {//Se habilitan las listas
                        if (lAOobjs[lEi] instanceof JComboBox)
                        {
                            JComboBox lJCj = (JComboBox) lAOobjs[lEi];
                            lJCj.setEnabled(lBb);
                        } else
                        {//Se habilitan los menu
                            if (lAOobjs[lEi] instanceof JMenuItem)
                            {
                                JMenuItem lJMj = (JMenuItem) lAOobjs[lEi];
                                lJMj.setEnabled(lBb);
                            } else
                            {//Se habilitan los paneles
                                if (lAOobjs[lEi] instanceof JPanel)
                                {
                                    JPanel lJPj = (JPanel) lAOobjs[lEi];
                                    lJPj.setEnabled(lBb);
                                }else
                                {//Se habilitan las areas de fecha
                                    if (lAOobjs[lEi] instanceof JDateChooser)
                                    {
                                        JDateChooser lJDj = (JDateChooser) lAOobjs[lEi];
                                        lJDj.requestFocus();
                                    }
                                }
                                
                            }
                        }
                    }
                }
            }
        } catch (Exception lEXe)
        {
            CMensajes.cmetpbMsj(null,"Error al habilitar: " + lEXe.getMessage());
        }
    }

    /**
     * Método que permite pasar de un componente a otro en el frame (interfaz).
     *
     * @param lOobj componente de la interfaz al que se desea cambiar el cursor o seleccion.
     */
    public static void cmetpbCambia (Object lOobj)
    {//Se cambia con enter a un campo de texto 
        cmetpbHabilita(true,lOobj);
        if (lOobj instanceof JTextField)
        {//Se quitan espacios en blanco y se comienza a escribir con 0 caracteres, en color negro.
            JTextField lJTj = (JTextField) lOobj;
            cmetpbSelecciona(lJTj);
            lJTj.setForeground(Color.black);
            lJTj.requestFocus();
        } else
        {//Se cambia con enter al boton
            if (lOobj instanceof JButton)
            {
                JButton lJBj = (JButton) lOobj;
                lJBj.requestFocus();
            } else
            {//Se cambia con enter a una lista de opciones
                if (lOobj instanceof JComboBox)
                {
                    JComboBox lJCj = (JComboBox) lOobj;
                    lJCj.requestFocus();
                }else
                {//Se cambia con enter a un campo de fecha
                    if (lOobj instanceof JDateChooser)
                    {
                        JDateChooser lJDj = (JDateChooser) lOobj;
                        lJDj.requestFocus();

                    }
                                        
                }
            }
        }
    }

    /**
     * Método que establece las condiciones para escribir en un campo de texto.
     *
     * @param lJTjt componente de la interfaz(jTextField) que se valida para usarse.
     */
    public static void cmetpbSelecciona (JTextField lJTjt)
    {
        lJTjt.setSelectionStart(0);
        lJTjt.setSelectionEnd(lJTjt.getText().length());
    }

    /**
     * Método que establece alguna etiqueta a componentes enviados.
     *
     * @param lAOobjs componentes de la interfaz para etiquetar.
     */
    public static void cmetpbEtiqueta (Object... lAOobjs)
    {
        try
        {
            for (int lEi = 0; lEi < lAOobjs.length; lEi += 2)
            {
                JTextField lJTj = (JTextField) lAOobjs[lEi];
                String lSs = (String) lAOobjs[lEi + 1];
                lJTj.setForeground(Color.gray);
                lJTj.setText(lSs);
            }
        } catch (Exception lEXe)
        {
            CMensajes.cmetpbMsj(null,"Error al etiquetar: " + lEXe.getMessage());
        }
    }

     /**
     * Método que quita el texto en los componentes de la interfaz.
     *
     * @param lAOobjs componentes de la interfaz para dejar en blanco.
     */
    public static void cmetpbLimpia (Object... lAOobjs)
    {
        try
        {
            for (int lEi = 0; lEi < lAOobjs.length ; lEi++)
            {//Limpia el espacio de texto
                if (lAOobjs[lEi] instanceof JTextField)
                {
                    JTextField lJTj = (JTextField) lAOobjs[lEi];
                    lJTj.setText("");
                } else
                {//quita las opciones de la lista
                    if (lAOobjs[lEi] instanceof JComboBox)
                    {
                        JComboBox lJCj = (JComboBox) lAOobjs[lEi];
                        lJCj.setSelectedIndex(0);
                    }
                }
            }
        } catch (Exception lEXe)
        {
            CMensajes.cmetpbMsj(null,"Error al limpiar campo(s): " + lEXe.getMessage());
        }
    }
    
    
    /**
     * Método que habilita y limpia los componentes enviados.
     *
     * @param lBb parametro booleano para saber si estan activos o inactivos
     * @param lAOarr objeto que se quiere habilitar
     */
    public static void cmetpbHabilitaObjetos(boolean lBb, Object... lAOarr)
    {
        for (int lEi = 0; lEi < lAOarr.length; lEi++)
        {
            cmetpbLimpia(lAOarr[lEi]);
            cmetpbHabilita(lBb,lAOarr[lEi]);

        }
    }
    
     /**
     * Método que verifica si esta vacio el jTextField
     *
     * @param lJTjt parametro que se verifica
     */
    public static boolean cmetpbRVerificaVacia(JTextField lJTjt)
    {
        if (lJTjt.getText().equals(""))
        {
            return true;
        } else
        {
            return false;
        }
    }
    
     /**
     * Método que valida si los campos que se envian estan en blanco
     *
     * @param lAOarr objetos que se verifican con o sin contenido
     */
    public static boolean cmetpbBVerificaBlancos(Object... lAOarr)
    {
        for (int lEi = 0; lEi < lAOarr.length; lEi++)
        {
            if (lAOarr[lEi] instanceof JTextField)
            {
                JTextField lJTjf = (JTextField) lAOarr[lEi];
                lJTjf.setBorder(BorderFactory.createLineBorder(Color.gray));//
                if (lJTjf.getText().equals(""))
                {
                    lJTjf.setBorder(BorderFactory.createLineBorder(Color.RED)); //
                    CMensajes.cmetpbFalla(null, "No puedes dejar espacios en blanco");
                    lJTjf.requestFocus();
                    return true;
                }
            }else if(lAOarr[lEi] instanceof JPasswordField)
            {
                JPasswordField jpf= (JPasswordField) lAOarr[lEi];
                if (jpf.getText().equals(""))
                {
                    CMensajes.cmetpbFalla(null, "No puedes dejar espacios en blanco en contraseña");
                    jpf.requestFocus();
                    return true;
                }
            }  
        }
        return false;
    }
    
    /**
     * Método que permite pasar de un componente a otro en el frame (interfaz).
     *
     * @param lOobj componente de la interfaz al que se desea cambiar el cursor o seleccion.
     */
    public static void cmetpbCambiaCuadro (Object lOobj)
    {//Se cambia con enter a un campo de texto 
        //cmetpbHabilita(true,lOobj);
        if (lOobj instanceof JTextField)
        {//Se quitan espacios en blanco y se comienza a escribir con 0 caracteres, en color negro.
            JTextField lJTj = (JTextField) lOobj;
            cmetpbSelecciona(lJTj);
            lJTj.setForeground(Color.black);
            lJTj.requestFocus();
        } else
        {//Se cambia con enter al boton
            if (lOobj instanceof JButton)
            {
                JButton lJBj = (JButton) lOobj;
                lJBj.requestFocus();
            } else
            {//Se cambia con enter a una lista de opciones
                if (lOobj instanceof JComboBox)
                {
                    JComboBox lJCj = (JComboBox) lOobj;
                    lJCj.requestFocus();
                }/*else
                {//Se cambia con enter a un campo de fecha
                    if (lOobj instanceof JDateChooser)
                    {
                        JDateChooser lJDj = (JDateChooser) lOobj;
                        lJDj.requestFocus();

                    }
                                        
                }*/
            }
        }
    }
    
}
