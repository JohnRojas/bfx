/*
 *  Nombre de la clase: BailarinTmp
 *  Descripción de la clase: Clase que permite manipular la carga de datos de un bailarin (id, nombre, ap, am)
 *  Fecha de creación: 04/Junio/2016
 *  Elaboró: Rojas Simón Jonathan y Hernández Benitez Marvin Atzael
 *  Fecha de Liberación: -
 *  Autorizó: -
 *  Responsable: Rojas Simón Jonathan
 *  Revisor: Mauro Sánchez Sánchez
 */

package bfx.clases;

/**
 * 
 * @author Jonathan Rojas Simón
 */
public class BailarinTmp {
private int idBailarin;
private String nombre;
private String app;
private String apm;
private String fecha;

    /**
     * BailarinTmp(int idBailarin, String nombre, String app, String apm, String fecha)
     * Constructor que inicializa un objeto a partir de los siguientes parámetros
     * @param idBailarin envía el identificador del bailarín asociado
     * @param nombre indica el nombre del bailarín
     * @param app indica el apellido paterno del bailarín
     * @param apm indica el apellido materno del bailarín
     * @param fecha indica la fecha del último evento solicitado
     */
    public BailarinTmp(int idBailarin, String nombre, String app, String apm, String fecha)
    {
        this.idBailarin = idBailarin;
        this.nombre = nombre;
        this.app = app;
        this.apm = apm;
        this.fecha = fecha;
    }

    /**
     * getIdBailarin()
     * Método que retorna el valor del id del bailarín
     * @return the idBailarin indica el numero entero del identificador del bailarín
     */
    public int getIdBailarin()
    {
        return idBailarin;
    }

    /**
     * setIdBailarin(int idBailarin)
     * Indica e valor del bailarín a establecer como objeto
     * @param idBailarin the idBailarin to set
     */
    public void setIdBailarin(int idBailarin)
    {
        this.idBailarin = idBailarin;
    }

    /**
     * getNombre()
     * Método que retorna el valor del nombre del bailarín
     * @return el nombre del bailarín
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * setNombre(String nombre)
     * Método que establece el nombre del bailarín
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    /**
     * String getApp()
     * Método que retorna la cadena del apellido paterno del bailarín asociado
     * @return el apellido paterno
     */
    public String getApp()
    {
        return app;
    }

    /**
     * setApp(String app)
     * Método que establece el valor del apellido paterno del bailarín
     * @param app the app to set
     */
    public void setApp(String app)
    {
        this.app = app;
    }

    /**
     * getApm()
     * Método que retorna la cadena del appellido materno del objeto bailarín
     * @return apm el valor de la cadena del appellido materno
     */
    public String getApm()
    {
        return apm;
    }

    /**
     * setApm(String apm)
     * Método que establece el valor del apellido materno del objeto de bailarín asociado
     * @param apm el apellido materno del bailarín a establecer
     */
    public void setApm(String apm)
    {
        this.apm = apm;
    }
    
    /**
     * getFecha()
     * Método que retorna el valor de la fecha del objeto bailarín
     * @return fecha que indica la cadena de la fecha del ultimo evento
     */
    public String getFecha()
    {
        return fecha;
    }

    /**
     * setFecha(String fecha)
     * Método que establece el valor de la fecha del objeto bailarin
     * @param fecha es la fecha del ultimo evento
     */
    public void setFecha(String fecha)
    {
        this.fecha = fecha;
    }
}