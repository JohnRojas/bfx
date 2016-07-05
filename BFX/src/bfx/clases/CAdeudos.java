/*Nombre de clase		: CAdeudos
*Descripción de la clase	: Clase permite axeder a las propiedades de los adeudos
*Fecha	de creación		: 01/05/2016
*Elaboro			: Geovany Pichardo Gutierrez
*Fecha	de Liberación		: 
*Autorizó			: Mauro Sánchez Sánchez//Techno Engineers
*Fecha Mantenimiento		: 25/06/2016
*Folio mantenimiento		: 01
*Descripción del mantto.	: Se realizó la actualización de métodos y transformacion de código con calidad.
*Responsable			: Geovany Pichardo Gutierrez
*Revisor 			: Diego Enrique Sánchez Ordoñez
*/
package bfx.Clases;

/**
 *
 * @author Geovany
 */
public class CAdeudos
{
 
    private int ppvEIdAdeudos;
    private int ppvEIdUsuarios;
    private String ppvSMesAdeudo;
    private int ppvEAnioAdeudo;
    private double ppvDMontoRenta;
    private String ppvSFechaPago;

    public CAdeudos()
    {
        ppvEIdAdeudos = 0;
        ppvEIdUsuarios = 0;
        ppvSMesAdeudo = "";
        ppvEAnioAdeudo = 2000;
        ppvDMontoRenta = 0.00;
        ppvSFechaPago = "";
    }

    public CAdeudos(int lEIdAdeudos, int lEIdUsuarios, String lSMesAdeudo, int lEAnioAdeudo, double lDMontoRenta, String lSFechaPago)
    {
        this.ppvEIdAdeudos = lEIdAdeudos;
        this.ppvEIdUsuarios = lEIdUsuarios;
        this.ppvSMesAdeudo = lSMesAdeudo;
        this.ppvEAnioAdeudo = lEAnioAdeudo;
        this.ppvDMontoRenta = lDMontoRenta;
        this.ppvSFechaPago = lSFechaPago;
    }

    /**
     * @return the ppvEIdAdeudos
     */
    public int getpbEIdAdeudos()
    {
        return ppvEIdAdeudos;
    }

    /**
     * @param lEIdAdeudos the ppvEIdAdeudos to set
     */
    public void setpbIdAdeudos(int lEIdAdeudos)
    {
        this.ppvEIdAdeudos = lEIdAdeudos;
    }

    /**
     * @return the ppvEIdUsuarios
     */
    public int getpbEIdUsuarios()
    {
        return ppvEIdUsuarios;
    }

    /**
     * @param lEIdUsuarios the ppvEIdUsuarios to set
     */
    public void setpbIdUsuarios(int lEIdUsuarios)
    {
        this.ppvEIdUsuarios = lEIdUsuarios;
    }

    /**
     * @return the ppvSMesAdeudo
     */
    public String getpbSMesAdeudo()
    {
        return ppvSMesAdeudo;
    }

    /**
     * @param lSMesAdeudo the ppvSMesAdeudo to set
     */
    public void setpbMesAdeudo(String lSMesAdeudo)
    {
        this.ppvSMesAdeudo = lSMesAdeudo;
    }

    /**
     * @return the ppvEAnioAdeudo
     */
    public int getpbEAnioAdeudo()
    {
        return ppvEAnioAdeudo;
    }

    /**
     * @param lEAnioAdeudo the ppvEAnioAdeudo to set
     */
    public void setpbAnioAdeudo(int lEAnioAdeudo)
    {
        this.ppvEAnioAdeudo = lEAnioAdeudo;
    }

    /**
     * @return the ppvDMontoRenta
     */
    public double getpbDMontoRenta()
    {
        return ppvDMontoRenta;
    }

    /**
     * @param lDMontoRenta the ppvDMontoRenta to set
     */
    public void setpbMontoRenta(double lDMontoRenta)
    {
        this.ppvDMontoRenta = lDMontoRenta;
    }

    /**
     * @return the ppvSFechaPago
     */
    public String getpbSFechaPago()
    {
        return ppvSFechaPago;
    }

    /**
     * @param lSFechaPago the ppvSFechaPago to set
     */
    public void setpbFechaPago(String lSFechaPago)
    {
        this.ppvSFechaPago = lSFechaPago;
    }
            
}
