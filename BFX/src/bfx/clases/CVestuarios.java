/*Nombre de clase		: CVestuarios
*Descripción de la clase	: Clase donde se realizan las propiedades de la clase con sus metodos encapsulados. 
*Fecha	de creación		: 01/05/2016
*Elaboro			: Oscar De Paz Feliciano y Erick López Hernández.
*Fecha	de Liberación		: 07/05/2016
*Autorizó			: Mauro Sánchez Sánchez
*Fecha Mantenimiento		: 19/06/2016
*Folio mantenimiento		: 02
*Descripción del mantto.	: Se realizó la Transformacion de código con calidad.
*Responsable			: Oscar De Paz Feliciano
*Revisor 			: Mauro Sánchez Sánchez
*/
package bfx.clases;
/**
 * Clase CVestuarios con propiedades sets y gets con encapsulamiento.
 * @author: Techno Engineers
 * @versión: 2.0 
 */
public class CVestuarios
{
    public static int ppbISerial=0;
    private char ppvCTipo;
    private String ppvSDescripcion;
    private String ppvSColor;
    private char ppvCSexo;
    private int ppvEIdVestuario;
    
    /**
     * CVestuarios constructor por defecto sin función
     */
    public CVestuarios()
    {
      ppbISerial=1010;
      ppvCTipo='P';
      ppvSDescripcion="Prenda blanca de hombre por default";
      ppvSColor="blanca";
      ppvCSexo='H';
    }

    /**
     * CVestuarios contructor que inicializa los atributos 
     * de un objeto a partir de los siguientes parámetros:
     * 
     * @param lEIdVestuario  :indica el id del vestuario 
     * @param lCTipo         :indica el tipo prenda o accesorio
     * @param lSDescripcion  :indica la descripción de la prenda o accesorio
     * @param lSColor        :indica el color de la prenda o accesorio
     * @param lCSexo         :indica el sexo al que pertenece la prenda o accesorio
     */
    public CVestuarios(int lEIdVestuario,char lCTipo, String lSDescripcion, String lSColor, char lCSexo)
    {
        this.ppvEIdVestuario=lEIdVestuario;
        this.ppvCTipo = lCTipo;
        this.ppvSDescripcion = lSDescripcion;
        this.ppvSColor = lSColor;
        this.ppvCSexo = lCSexo;
    }
    
    /**
     * getPvCTipo() método que contiene el valor actualdel tipo
     * @return retorna el valor getPvCTipo
     */
    public char getPvCTipo()
    {
        return ppvCTipo;
    }

    /**
     * setPvCTipo() método que contiene el valor actual del tipo
     * @param pvCTipo recibe el tipo
     */
    public void setPvCTipo(char pvCTipo)
    {
        this.ppvCTipo = pvCTipo;
    }

    /**
     * getPvSDescripcion() método que contiene el valor actual la descripción
     * @return retorna el valor getPvSDescripcion
     */
    public String getPvSDescripcion()
    {
        return ppvSDescripcion;
    }

    /**
     * setPvSDescripcion() método que contiene el valor actual de la descripción
     * @param pvSDescripcion recibe la descripcion
     */
    public void setPvSDescripcion(String pvSDescripcion)
    {
        this.ppvSDescripcion = pvSDescripcion;
    }

    /**
     * getPvSColor() método que contiene el valor actual de color
     * @return retorna el valor getPvSColor
     */
    public String getPvSColor()
    {
        return ppvSColor;
    }

    /**
     * setPvSColor() método que contiene el valor actual del color
     * @param pvSColor recibe el color
     */
    public void setPvSColor(String pvSColor)
    {
        this.ppvSColor = pvSColor;
    }

    /**
     * getPvCSexo() método que contiene el valor actual de sexo
     * @return retorna el valor getPvCSexo
     */
    public char getPvCSexo()
    {
        return ppvCSexo;
    }

    /**
     * setpvCSexo () método que contiene el valor actual del sexo
     * @param pvCSexo recibe sexo
     */
    public void setPvCSexo(char pvCSexo)
    {
        this.ppvCSexo = pvCSexo;
    }

    /**
     * getPvEIdVestuario() método que contiene el valor actual de id pvEIdVestuario
     * @return retorna el valor pvEIdVestuario
     */
    public int getPvEIdVestuario()
    {
        return ppvEIdVestuario;
    }

    /**
     * setPvEIdVestuario método que contiene el valor actual pvEIdVestuario
     * @param pvEIdVestuario  recibe el valor pvEIdVestuario
     */
    public void setPvEIdVestuario(int pvEIdVestuario)
    {
        this.ppvEIdVestuario = pvEIdVestuario;
    }
       
}
