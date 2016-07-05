/*Nombre de clase		: CVestuarioUsuario
*Descripción de la clase	: Clase que contiene las propiedades del vestuario de un Usuario
*Fecha	de creación		: 01/05/2016
*Elaboro			: Jatziry Barrera Hinojosa && Diego Enrique Sánchez Ordoñez
*Fecha	de Liberación		: 01/05/2016
*Autorizó			: Mauro Sánchez Sánchez//Techno Engineers
*Fecha Mantenimiento		: 05/06/2016
*Folio mantenimiento		: 02
*Descripción del mantto.	: Se realizó la actualización de métodos y transformacion de código con calidad.
*Responsable			: Jatziry Barrera Hinojosa
*Revisor 			: Diego Enrique Sánchez Ordoñez
*/
package bfx.clases;
/**
 * Datos encapsulados del usuario.
 * @author: Techno Engineers
 * @versión: 3.0 
 */
public class CVestuarioUsuario 
{
    public static int ppbEconsecutivo = 0;
    private int ppvEidvestuarioUsuario;
    private int ppvEidusuario;
    private int ppvEidinventario;
    //private int pvEauxId;

    /**
     * Se crea un constructor
     * Recibe los valores de los atributos de la tabla VestuarioUsuarios en la base de datos.
     * @param lEidvestuarioUsuario: id del registro
     * @param lEidusuario: es el número de usuario
     * @param lEidinventario: es el número de vestuario que le queda al usuario
     * */
    public CVestuarioUsuario(int lEidvestuarioUsuario, int lEidusuario, int lEidinventario/*, int pEauxId*/) 
    {
        this.ppvEidvestuarioUsuario = lEidvestuarioUsuario;
        this.ppvEidusuario = lEidusuario;
        this.ppvEidinventario = lEidinventario;
        //this.pvEauxId = pvEauxId;
    }

    
    /**
     * Método que permite obtener el valor de la propiedad idvestuarioUsuario
     * @return Valor numérico 1 hasta N
    */
    public int getpbEidvestuarioUsuario() 
    {
        return ppvEidvestuarioUsuario;
    }

    /**
     * Método que permite asignar el número de vestuario que tiene el usuario.
     * @param lEidvestuarioUsuario número de vestario que se le asigna para identificarla
    */
    public void setpbidvestuarioUsuario(int lEidvestuarioUsuario) 
    {
        this.ppvEidvestuarioUsuario = lEidvestuarioUsuario;
    }

    /**
     * Método que permite obtener el valor de la propiedad idusuario
     * @return Valor numérico 1 hasta N
    */
    public int getpbEidusuario() 
    {
        return ppvEidusuario;
    }

    /**
     * Método que permite asignar el número que tiene el usuario.
     * @param lEidusuario número de usuario que se le asigno para identificarlo
    */
    public void setpbidusuario(int lEidusuario) 
    {
        this.ppvEidusuario = lEidusuario;
    }

    /**
     * Método que permite obtener el valor de la propiedad idinventario
     * @return Valor numérico 1 hasta N
    */
    public int getpbEidinventario() {
        return ppvEidinventario;
    }

    /**
     * Método que permite asignar el número que tiene la pieza en el inventario.
     * @param lEidinventario número de inventario que se le asigno para identificarlo
    */
    public void setpbidinventario(int lEidinventario) {
        this.ppvEidinventario = lEidinventario;
    }


 

//    public int getpbEauxId() {
//        return pvEauxId;
//    }
//
//    public void setpbauxId(int pEauxId) {
//        this.pvEauxId = pEauxId;
//    }
    
    /**
    * Este método nos permite imprimir la información de un objeto de la clase "VestuarioUsuario" no devuelve nada asi que sólo basta llamarlo para que muestre la información.
    */
    public String metpbRespVU() 
    {
        return "\nID del registro = " + ppvEidvestuarioUsuario
                +"\nID del usuario = " + ppvEidusuario
            + "\nID del vestuario a medida del usuario = " + ppvEidinventario + "\n"+
            "*******************************";      
        
    }
    
}
