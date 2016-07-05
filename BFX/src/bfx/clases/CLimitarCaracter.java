/* Nombre de la clase                : CLimitarCaracter 
 * Descripción de la clase        : Clase donde se ocupan los metodos para limitar caracteres en jTextFields
 * Fecha de creación                 : 15/04/2016 
 * Elaboró                                     : Rogelio Bernal / Carlos Trujilo 
 * Fecha de Liberación              : - 
 * Autorizó  : -
 * Fecha Mantenimiento           : 
 * Folio mantenimiento             : 
 * Descripción del mantto       :
 * Responsable                          :  
 * Revisor                                    : 
 */
package bfx.controladores;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * Clase para limitar caracteres que ingresan en los jTextFields
 * @author Techno Engineers
 * @version 1.0
 */
public class CLimitarCaracter extends PlainDocument{
    
    private JTextField pvJTeditor;
    private int pvENum;

    public CLimitarCaracter(JTextField pvJTeditor, int pvENum) {
        this.pvJTeditor = pvJTeditor;
        this.pvENum = pvENum;
    }
    
    public void insertString(int arg0, String arg1, AttributeSet arg2) throws BadLocationException {
    
        if(pvJTeditor.getText().length() + arg1.length() > this.pvENum){
              return; 
        }super.insertString(arg0, arg1, arg2);
    }
} 