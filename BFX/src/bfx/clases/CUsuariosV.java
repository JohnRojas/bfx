/*Nombre de clase		: CUsuariosV
*Descripción de la clase	: Clase que contiene las propiedades de un Usuario mas el vestuario que le queda
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
import java.util.ArrayList;

public class CUsuariosV 
{
    CUsuariosDE objCUsuariosDE1;
    ArrayList<CVestuarioUsuario> plALvU;

    public CUsuariosV(CUsuariosDE lCUobj, ArrayList<CVestuarioUsuario> lALvU) {
        this.objCUsuariosDE1 = lCUobj;
        this.plALvU = lALvU;
    }

    public CUsuariosDE getpbObj() {
        return objCUsuariosDE1;
    }

    public void setpbObj(CUsuariosDE lCUobj) {
        this.objCUsuariosDE1 = lCUobj;
    }

    public ArrayList<CVestuarioUsuario> getpbvU() {
        return plALvU;
    }

    public void setpbvU(ArrayList<CVestuarioUsuario> lALvU) {
        this.plALvU = lALvU;
    }
    
}
