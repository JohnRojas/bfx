/*  Nombre de la clase                        : CDanios1
 *  Descripción de la clase                 : Clase que permite crear y manipular objetos para la realización del modelo de negocio
 *  Fecha de creación                          : 15/Abril/2016
 *  Elaboró                                              : Rojas Simón Jonathan y Hernández Benitez Marvin Atzael
 *  Fecha de Liberación                       : -
 *  Autorizó                                             : -
 *  Fecha Mantenimiento                     : 09/Mayo/2016
 *  Folio mantenimiento                       : 01
 *  Descripción del mantenimiento   : Añadir nuevos campos para la manipulación de objetos
 *  Responsable                                     : Rojas Simón Jonathan
 *  Revisor                                               : Mauro Sánchez Sánchez
 */

package bfx.clases;

/**
 * Clase para crear objetos del mismo tipo
 * @author Techno Engineers
 * @version 1.0
 */
public class CDanios1 
{
    private int pvEIdDanio;
    private String pvSNombre;
    private String pvSApaterno;
    private String pvSAmaterno;
    private String pvSPrenda;
    private char pvCStatus;
    private double pvDMonto;
    private String pvSFechaEvento;
    private String pvSFechaDePago;

    /**
     * Constructor que inicializa un objeto de tipo CDanios1 con los siguientes parámetros de entrada
     * @param pEIdDanio el identificador de daño
     * @param pSNombre pvSNombre del bailarin
     * @param pSApaterno appellido paterno del bailarín
     * @param pSAmaterno apellido materno del bailarin
     * @param pSPrenda pvSPrenda del bailarín
     * @param pCStatus estado del bailarín (dañado, reparado)
     * @param pDMonto pvDMonto del bailarín que debe
     * @param pSFechaEvento fecha del evento asociado
     * @param pSFechaDePago fecha del pago
     */
    public CDanios1(int pEIdDanio, String pSNombre, String pSApaterno, String pSAmaterno, String pSPrenda, char pCStatus, double pDMonto, String pSFechaEvento, String pSFechaDePago)
    {
        this.pvEIdDanio = pEIdDanio;
        this.pvSNombre = pSNombre;
        this.pvSApaterno = pSApaterno;
        this.pvSAmaterno = pSAmaterno;
        this.pvSPrenda = pSPrenda;
        this.pvCStatus = pCStatus;
        this.pvDMonto = pDMonto;
        this.pvSFechaEvento = pSFechaEvento;
        this.pvSFechaDePago = pSFechaDePago;
    }

    /**
     * getpbEIdDanio
     * Método que devuelve un valor de tipo entero para obtener el campo pvEIdDanio de la BD
     * 
     * @return pvEIdDanio es el valor asociado
     */
    public int getpbEIdDanio()
    {
        return pvEIdDanio;
    }

    /**
     * setpbIdDanio
     * Método que establece el valor entero al id de daño
     * 
     * @param lEIdDanio es la entrada del valor asociado
     */
    public void setpbIdDanio(int lEIdDanio)
    {
        this.pvEIdDanio = lEIdDanio;
    }

    /**
     * getpbSNombre
     * Método que retorna el valor del nombre del bailarin
     * 
     * @return String
     */
    public String getpbSNombre()
    {
        return pvSNombre;
    }

    /**
     * setpbNombre
     * Método que establece el nombre del objeto de bailarín
     * 
     * @param lSNombre Es la cadena como parámetro de entrada
     */
    public void setpbNombre(String lSNombre)
    {
        this.pvSNombre = lSNombre;
    }

    /**
     * getpbSApaterno
     * Método que retorna la cadena del apellido paterno del bailarín
     * 
     * @return String
     */
    public String getpbSApaterno()
    {
        return pvSApaterno;
    }

    /**
     * setpbApaterno
     * Método que establece el apellido paterno del bailarín
     * 
     * @param lSApaterno es la cadena de entrada del apellido paterno del bailarín
     */
    public void setpbApaterno(String lSApaterno)
    {
        this.pvSApaterno = lSApaterno;
    }

    /**
     * getpbSAmaterno
     * Método que retorna la cadena correspondiente al apellido materno del bailarín
     * 
     * @return String
     */
    public String getpbSAmaterno()
    {
        return pvSAmaterno;
    }

    /**
     * setpbAmaterno
     * Método que establece la cadena correspondiente al apellido materno del bailarín
     * 
     * @param lSAmaterno es la cadena como parámetro de entrada
     */
    public void setpbAmaterno(String lSAmaterno)
    {
        this.pvSAmaterno = lSAmaterno;
    }

    /**
     * getpbSPrenda
     * Método que retorna el valor de la cadena de la prenda
     * 
     * @return String
     */
    public String getpbSPrenda()
    {
        return pvSPrenda;
    }

    /**
     * setpbPrenda
     * Método que establece la cadena de la prenda
     * 
     * @param lSPrenda es el parámetro de entrada de la descripción de la prenda
     */
    public void setpbPrenda(String lSPrenda)
    {
        this.pvSPrenda = lSPrenda;
    }

    /**
     * getpbCStatus
     * Método que retorna el valor del Status de la prenda 
     * 
     * @return char
     */
    public char getpbCStatus()
    {
        return pvCStatus;
    }

    /**
     * setpbStatus
     * Método que establece el valor del status de la prenda
     * 
     * @param lCStatus es el parámetro de entrada correspondiente al Status
     */
    public void setpbStatus(char lCStatus)
    {
        this.pvCStatus = lCStatus;
    }

    /**
     * getpbDMonto
     * Método que retorna el valor del monto 
     * 
     * @return double
     */
    public double getpbDMonto()
    {
        return pvDMonto;
    }

    /**
     * setpbMonto
     * Método que establece el monto del daño
     * 
     * @param lDMonto es el parámetro de entrada
     */
    public void setpbMonto(double lDMonto)
    {
        this.pvDMonto = lDMonto;
    }

    /**
     * getpbSFechaEvento
     * Método que retorna el la cadena correspondiente a la fecha del evento asociado al daño
     * 
     * @return String
     */
    public String getpbSFechaEvento()
    {
        return pvSFechaEvento;
    }

    /**
     * setpbFechaEvento
     * Método que establece el valor de la cadena de la fecha del evento
     * 
     * @param lSFechaEvento es el parámetro de entrada correspondiente a la fecha del evento
     */
    public void setpbFechaEvento(String lSFechaEvento)
    {
        this.pvSFechaEvento = lSFechaEvento;
    }

    /**
     * getpbSFechadepago
     * Método que retorna el valor de la fecha de pago
     * 
     * @return String
     */
    public String getpbSFechadepago()
    {
        return pvSFechaDePago;
    }

    /**
     * setpbFechadepago
     * Método que establece el valor de la fecha de pago asociado al daño
     * 
     * @param lSFechaDePago es el parámetro de entrada del daño
     */
    public void setpbFechadepago(String lSFechaDePago)
    {
        this.pvSFechaDePago = lSFechaDePago;
    }
}