/*  Nombre de la clase               : CUsuarioTmp
 *  Descripción de la clase          : Clase que permite manipular la carga de datos de un usuario 
 *  Fecha de creación                : 20/Junio/2016
 *  Elaboró                          : Oscar De Paz Feliciano
 *  Fecha de Liberación              : -
 *  Autorizó                         : -
 *  Responsable                      : Oscar De Paz Feliciano
 *  Revisor                          : Mauro Sánchez Sánchez
 */
package bfx.clases;

/**
 * Definición de propiedades para la carga de objetos
 *
 * @author Techno Engineers
 * @version 1.0
 */
public class CUsuarioTmp
{

    private int ppvEIdUsuario;
    private String ppvSNombre;
    private String ppvSApp;
    private String ppvSApm;

    public CUsuarioTmp()
    {

    }

    /**
     * CUsuarioTmp Constructor que inicializa un objeto a partir de los
     * siguientes parámetros
     *
     * @param lEIdUsuario :envía el identificador del usuario asociado
     * @param lSNombre :indica el pvSNombre del usuario
     * @param lSApp : indica el apellido paterno del usuario
     * @param lSApm : indica el apellido materno del usuario
     */
    public CUsuarioTmp(int lEIdUsuario, String lSNombre, String lSApp, String lSApm)
    {
        this.ppvEIdUsuario = lEIdUsuario;
        this.ppvSNombre = lSNombre;
        this.ppvSApp = lSApp;
        this.ppvSApm = lSApm;
    }

    /**
     * getpbEIdUsuario() Método que retorna el valor del id del usuario
     *
     * @return pvEIdUsuario indica el numero entero del identificador del usurio
     */
    public int getPvEIdUsuario()
    {
        return ppvEIdUsuario;
    }

    /**
     * setPvEIdUsuario Indica e valor del usuario a establecer como objeto
     *
     * @param pvEIdUsuario recibe el parámetro id usuario
     */
    public void setPvEIdUsuario(int pvEIdUsuario)
    {
        this.ppvEIdUsuario = pvEIdUsuario;
    }

    /**
     * getpbSNombre() Método que retorna el valor del pvSNombre del usuario
     *
     * @return el pvSNombre del usuario
     */
    public String getPvSNombre()
    {
        return ppvSNombre;
    }

    /**
     * setpbNombre Método que establece el pvSNombre del usuario
     *
     * @param pvSNombre
     */
    public void setPvSNombre(String pvSNombre)
    {
        this.ppvSNombre = pvSNombre;
    }

    /**
     * getpbSApp Método que establece el valor del apellido paterno del usuario
     *
     * @return el apellido paterno
     */
    public String getPvSApp()
    {
        return ppvSApp;
    }

    /**
     * setpbApp Método que establece el valor del apellido paterno del usuario
     *
     * @param pvSApp del usuario
     */
    public void setPvSApp(String pvSApp)
    {
        this.ppvSApp = pvSApp;
    }

    /**
     * getpbSApm Método que retorna la cadena del apellido materno del objeto
     * usuario
     *
     * @return el valor de la cadena del appellido materno
     */
    public String getPvSApm()
    {
        return ppvSApm;
    }

    /**
     * setpbApm Método que establece el valor del apellido materno del objeto de
     * usuario asociado
     *
     * @param pvSApm el apellido materno del bailarín a establecer
     */
    public void setPvSApm(String pvSApm)
    {
        this.ppvSApm = pvSApm;
    }
}
