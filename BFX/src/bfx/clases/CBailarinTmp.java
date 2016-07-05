/*  Nombre de la clase                  : CBailarinTmp
 *  Descripción de la clase          : Clase que permite manipular la carga de datos de un bailarin (id, pvSNombre, ap, am)
 *  Fecha de creación                   : 04/Junio/2016
 *  Elaboró                                        : Rojas Simón Jonathan y Hernández Benitez Marvin Atzael
 *  Fecha de Liberación                : -
 *  Autorizó                                      : -
 *  Responsable                             : Rojas Simón Jonathan
 *  Revisor                                       : Mauro Sánchez Sánchez
 */

package bfx.clases;

/**
 * Definición de propiedades para la carga de objetos
 * @author Techno Engineers
 * @version 1.0
 */
public class CBailarinTmp {
private int pvEIdBailarin;
private String pvSNombre;
private String pvSApp;
private String pvSApm;
private String pvSFecha;

    /**
     * BailarinTmp Constructor que inicializa un objeto a partir de los siguientes parámetros
     * 
     * @param pEIdBailarin envía el identificador del bailarín asociado
     * @param pSNombre indica el pvSNombre del bailarín
     * @param pSApp indica el apellido paterno del bailarín
     * @param pSApm indica el apellido materno del bailarín
     * @param pSFecha indica la pvSFecha del último evento solicitado
     */
    public CBailarinTmp(int pEIdBailarin, String pSNombre, String pSApp, String pSApm, String pSFecha)
    {
        this.pvEIdBailarin = pEIdBailarin;
        this.pvSNombre = pSNombre;
        this.pvSApp = pSApp;
        this.pvSApm = pSApm;
        this.pvSFecha = pSFecha;
    }

    /**
     * getpbEIdBailarin()
     * Método que retorna el valor del id del bailarín
     * 
     * @return pvEIdBailarin indica el numero entero del identificador del bailarín
     */
    public int getpbEIdBailarin()
    {
        return pvEIdBailarin;
    }

    /**
     * setpbIdBailarin
     * Indica e valor del bailarín a establecer como objeto
     * 
     * @param lEIdBailarin the pvEIdBailarin to set
     */
    public void setpbIdBailarin(int lEIdBailarin)
    {
        this.pvEIdBailarin = lEIdBailarin;
    }

    /**
     * getpbSNombre()
     * Método que retorna el valor del pvSNombre del bailarín
     * 
     * @return el pvSNombre del bailarín
     */
    public String getpbSNombre()
    {
        return pvSNombre;
    }

    /**
     * setpbNombre
     * Método que establece el pvSNombre del bailarín
     * 
     * @param lSNombre the pvSNombre to set
     */
    public void setpbNombre(String lSNombre)
    {
        this.pvSNombre = lSNombre;
    }

    /**
     * getpbSApp
     * Método que retorna la cadena del apellido paterno del bailarín asociado
     * 
     * @return el apellido paterno
     */
    public String getpbSApp()
    {
        return pvSApp;
    }

    /**
     * setpbApp
     * Método que establece el valor del apellido paterno del bailarín
     * 
     * @param lEApp the pvSApp to set
     */
    public void setpbApp(String lEApp)
    {
        this.pvSApp = lEApp;
    }

    /**
     * getpbSApm
     * Método que retorna la cadena del apellido materno del objeto bailarín
     * 
     * @return pvSApm el valor de la cadena del appellido materno
     */
    public String getpbSApm()
    {
        return pvSApm;
    }

    /**
     * setpbApm 
     * Método que establece el valor del apellido materno del objeto de bailarín asociado
     * 
     * @param lSApm el apellido materno del bailarín a establecer
     */
    public void setpbApm(String lSApm)
    {
        this.pvSApm = lSApm;
    }
    
    /**
     * getpbSFecha
     * Método que retorna el valor de la pvSFecha del objeto bailarín
     * 
     * @return pvSFecha que indica la cadena de la pvSFecha del ultimo evento
     */
    public String getpbSFecha()
    {
        return pvSFecha;
    }

    /**
     * setpbFecha
     * Método que establece el valor de la pvSFecha del objeto bailarin
     * 
     * @param lSFecha es la pvSFecha del ultimo evento
     */
    public void setpbFecha(String lSFecha)
    {
        this.pvSFecha = lSFecha;
    }
}