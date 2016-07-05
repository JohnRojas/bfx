/* Nombre de la clase                : CRentasParametros 
 * Descripción de la clase        : Clase donde almacena las las propiedades que se ocupan en parametros rentas
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

/**
 * Datos encapsulados del rentasparametros.
 * @author: Techno Engineers
 * @versión: 1.0 
 */
public class CRentasParametros {

    /**
     * @return the ppvEConsecutivo
     */
    public static int getPpvEConsecutivo() {
        return ppvEConsecutivo;
    }

    /**
     * @param aConsecutivo the ppvEConsecutivo to set
     */
    public static void setPpvEConsecutivo(int aConsecutivo) {
        ppvEConsecutivo = aConsecutivo;
    }
    
    private int ppvERentaParametro;
    private String ppvSRentaAnterior;
    private String ppvSFechaRentaAnterior;
    private String ppvSRentaActual;
    private String ppvSFechaRentaActual;
    private static int ppvEConsecutivo=0;
    
    /**
     * Este es un constructor de objetos para la clase "RentasParametros", se puede hacer llamado a este método cuando se conozcan los valores para las propiedades del objeto. En caso de que lo valores no correspondan a los permitidos, según sean los casos. Se asignará un valor por defecto.
     * @param lERentaParametro Identificador de la Renta, se recibe como  numero
     * @param lSRentaAnterior La cantidad de renta anterior, recibido en formato numero, se comprueba que este no esté vacío.
     * @param lSFechaRentaAnterior La fecha de renta anterior, recibido en formato de texto, se comprueba que este no esté vacío.
     * @param lSRentaActual La cantidad de renta actual, se recibe como numero
     * @param lSFechaRentaActual La fecha de renta actual, se recibe en formato de texto
     */
    public CRentasParametros(int lERentaParametro, String lSRentaAnterior,
            String lSFechaRentaAnterior, String lSRentaActual, String lSFechaRentaActual)
    {
        this.ppvERentaParametro = lERentaParametro;
        this.ppvSRentaAnterior = lSRentaAnterior;
        this.ppvSFechaRentaAnterior = lSFechaRentaAnterior; 
        this.ppvSRentaActual = lSRentaActual;
        this.ppvSFechaRentaActual = lSFechaRentaActual;
    }

    /**
     * @return the ppvERentaParametro
     */
    public int getPpvERentaParametro() {
        return ppvERentaParametro;
    }

    /**
     * @param ppvERentaParametro the ppvERentaParametro to set
     */
    public void setPpvERentaParametro(int ppvERentaParametro) {
        this.ppvERentaParametro = ppvERentaParametro;
    }

    /**
     * @return the ppvSRentaAnterior
     */
    public String getPpvSRentaAnterior() {
        return ppvSRentaAnterior;
    }

    /**
     * @param pvDRentaAnterior the ppvSRentaAnterior to set
     */
    public void setPvDRentaAnterior(double pvDRentaAnterior) {
        this.setPvDRentaAnterior(pvDRentaAnterior);
    }

    /**
     * @return the ppvSFechaRentaAnterior
     */
    public String getPpvSFechaRentaAnterior() {
        return ppvSFechaRentaAnterior;
    }

    /**
     * @param ppvSFechaRentaAnterior the ppvSFechaRentaAnterior to set
     */
    public void setPpvSFechaRentaAnterior(String ppvSFechaRentaAnterior) {
        this.ppvSFechaRentaAnterior = ppvSFechaRentaAnterior;
    }

    /**
     * @return the ppvSRentaActual
     */
    public String getPpvSRentaActual() {
        return ppvSRentaActual;
    }

    /**
     * @param pvDRentaActual the ppvSRentaActual to set
     */
    public void setPvDRentaActual(double pvDRentaActual) {
        this.setPvDRentaActual(pvDRentaActual);
        
        if(pvDRentaActual < 0)
        {
            System.out.println("Renta Actual invalida, se le asignara por defecto 0.");
            this.setPvDRentaActual(0);
        }else
        {
            this.setPvDRentaActual(pvDRentaActual);
        }
        
    }

    /**
     * @return the ppvSFechaRentaActual
     */
    public String getPpvSFechaRentaActual() {
        return ppvSFechaRentaActual;
    }

    /**
     * @param ppvSFechaRentaActual the ppvSFechaRentaActual to set
     */
    public void setPpvSFechaRentaActual(String ppvSFechaRentaActual) {
        this.ppvSFechaRentaActual = ppvSFechaRentaActual;
    }
    
    public String metpbResp() 
    {
        return "\nId Renta Parametro = " + getPpvERentaParametro()
            + "\nRenta Anterior = " + getPpvSRentaAnterior()
            + "\nFecha Renta Anterior = " + getPpvSFechaRentaAnterior()
            + "\nRenta Actual = " + getPpvSRentaActual()
            + "\nFecha Renta Actual = " + getPpvSFechaRentaActual() + "\n"+
            "*******************************";
    } 

    /**
     * @param ppvSRentaAnterior the ppvSRentaAnterior to set
     */
    public void setPpvSRentaAnterior(String ppvSRentaAnterior) {
        this.ppvSRentaAnterior = ppvSRentaAnterior;
    }

    /**
     * @param ppvSRentaActual the ppvSRentaActual to set
     */
    public void setPpvSRentaActual(String ppvSRentaActual) {
        this.ppvSRentaActual = ppvSRentaActual;
    }
}
