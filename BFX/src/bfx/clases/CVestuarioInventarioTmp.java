/*Nombre de clase		: CVestuarioInventarioTmp
*Descripción de la clase	: Clase donde se realizan las propiedades de la clase con sus metodos encapsulados.  
*Fecha	de creación		: 01/06/2016
*Elaboro			: Oscar De Paz Feliciano.
*Fecha	de Liberación		: 08/06/2016
*Autorizó			: Mauro Sánchez Sánchez
*Fecha Mantenimiento		: 19/06/2016
*Folio mantenimiento		: 02
*Descripción del mantto.	: Se realizó la transformación de código con calidad..
*Responsable			: Oscar De Paz Feliciano
*Revisor 			: Mauro Sánchez Sánchez
*/
package bfx.clases;
/**
 * Clase CVestuarioInventarioTmp con sus propiedades sets y gets con encapsulamiento y contructores.
 * @author: Techno Engineers
 * @version 2.0
 */
public class CVestuarioInventarioTmp
{

    private static int ppvEConsucutivoIdVestuario = 0;
    private int ppvEIdVestuario;
    private char ppvCTipo;
    private String ppvSDescripcion;
    private String ppvSColor;
    private char ppvCSexo;
    private static int ppvEConsucutivoIdInventario = 0;
    private int ppvEIdInventario;
    private int ppvEIdVestuarioInventario;
    private int ppvECantidad;
    private int ppvEPiezasDanadas;
    private int ppvEPiezasAsignadas;
    private String ppvSClaveVestuario;
    private int ppvEExistencia;
    
    /**
     * CVestuarioInventarioTmp contructor que inicializa los atributos 
     * de un objeto a partir de los siguientes parámetros:
     * 
     * @param lCTipo                  :indica el tipo prenda o accesorio
     * @param lSDescripcion           :indica la descripción de la prenda o accesorio
     * @param lSColor                 :indica el color de la prenda o accesorio
     * @param lCSexo                  :indica el sexo al que pertenece la prenda o accesorio
     * @param lEIdVestuarioInventario :indica el id del vestuario inventario
     * @param lECantidad              :indica la cantidad del inventario de la prenda o accesorio
     * @param lEPiezasDanadas         :indica el número de piezas dañadas de la prenda o accesorio
     * @param lEPiezasAsignadas       :indica el número de piezas asignadas de la prenda o accesorio
     * @param lSClaveVestuario        :indica la clave del vestuario de la prenda o accesorio
     * @param lEExistencia            :indica el número de existencia de la prenda o accesorio
     */

    public CVestuarioInventarioTmp(char lCTipo, String lSDescripcion, String lSColor, char lCSexo, int lEIdVestuarioInventario, int lECantidad, int lEPiezasDanadas, int lEPiezasAsignadas, String lSClaveVestuario, int lEExistencia)
    {
       if(lCTipo==' ')
       {
           lCTipo='P';
       }else
       {
           this.ppvCTipo=lCTipo;
       }
       
       if(lSDescripcion=="" || lSDescripcion==null)
       {
           this.ppvSDescripcion="NULL";
       }else
       {
           this.ppvSDescripcion=lSDescripcion;
       }
       
       if(lSColor=="" || lSColor==null)
       {
           this.ppvSColor="Blanco";
       }else
       {
           this.ppvSColor=lSColor;
       }
       
       if(lCSexo==' ')
       {
           lCSexo='H';
       }else
       {
           this.ppvCSexo=lCSexo;
       }
       
       if(lEIdVestuarioInventario<0)
        {
           System.out.println("El identificador del vestuario no es valido.");
        }else
        {
          this.ppvEIdVestuarioInventario= lEIdVestuarioInventario;  
        }
        
        if(lECantidad < 0)
        {
           lECantidad=0; 
        }else
        {    
           this.ppvECantidad = lECantidad;
        }
        
        if(lEPiezasDanadas < 0)
        {
           lEPiezasDanadas=0; 
        }else
        {    
           this.ppvEPiezasDanadas = lEPiezasDanadas;
        }
        
        if(lEPiezasAsignadas < 0)
        {
           lEPiezasAsignadas=0; 
        }else
        {    
           this.ppvEPiezasAsignadas = lEPiezasAsignadas;
        }
        
        if(lSClaveVestuario=="" || lSClaveVestuario==null)
        {
           lSClaveVestuario="NULL"; 
        }else
        {    
           this.ppvSClaveVestuario = lSClaveVestuario;
        }
        
        if(lEExistencia< 0)
        {
           lEExistencia=0; 
        }else
        {    
           this.ppvEExistencia = lEExistencia;
        }
        ppvEIdVestuario = ++ppvEConsucutivoIdVestuario;
        ppvEIdInventario = ++ppvEConsucutivoIdInventario;
    }

    /**
     * getPvEIdVestuario() método que contiene el valor actual del id vestuario
     * @return retorna el valor de  id vestuario
     */
    public int getPvEIdVestuario()
    {
        return ppvEIdVestuario;
    }

    /**
     * setPvEExistencia() método que contiene el valor actual del id vestuario
     * @param pvEIdVestuario recibe la id del vestuario
     */
    public void setPvEIdVestuario(int pvEIdVestuario)
    {
        this.ppvEIdVestuario = pvEIdVestuario;
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
     * @param pvSDescripcion recibe la descripción
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
     * @param pvSColor retorna el color
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
     * setPvCSexo() método que contiene el valor actual del sexo
     * @param pvCSexo retorna el sexo
     */
    public void setPvCSexo(char pvCSexo)
    {
        this.ppvCSexo = pvCSexo;
    }

    /**
     * getPvEIdInventario() método que contiene el valor actual de id inventario
     * @return retorna el valor pvEIdInventario
     */
    public int getPvEIdInventario()
    {
        return ppvEIdInventario;
    }

    /**
     * setPvEIdInventario método que contiene el valor actual pvEIdInventario
     * @param pvEIdInventario recibe el valor pvEIdInventario
     */
    public void setPvEIdInventario(int pvEIdInventario)
    {
        this.ppvEIdInventario = pvEIdInventario;
    }

    /**
     * getPvEIdVestuarioInventario() método que contiene el valor actual de id vestuario inventario
     * @return retorna el valor id vestuario inventario
     */
    public int getPvEIdVestuarioInventario()
    {
        return ppvEIdVestuarioInventario;
    }

    /**
     * setPvEIdVestuarioInventario() método que contiene el valor actual IdVestuarioInventario
     * @param pvEIdVestuarioInventario recibe la pvEIdVestuarioInventario
     */
    public void setPvEIdVestuarioInventario(int pvEIdVestuarioInventario)
    {
        this.ppvEIdVestuarioInventario = pvEIdVestuarioInventario;
    }

    /**
     * getPvECantidad() método que contiene el valor actual de la cantidad
     * @return retorna el valor de la cantidad
     */
    public int getPvECantidad()
    {
        return ppvECantidad;
    }

    /**
     * setPvECantidad() método que contiene el valor actual de la cantidad
     * @param pvECantidad recibe la cantidad
     */
    public void setPvECantidad(int pvECantidad)
    {
        this.ppvECantidad = pvECantidad;
    }

    /**
     * getPvEPiezasDanadas() método que contiene el valor actual de la pieza dañada
     * @return retorna el valor de la pieza dañada
     */
    public int getPvEPiezasDanadas()
    {
        return ppvEPiezasDanadas;
    }

    /**
     * setPvEPiezasDanadas() método que contiene el valor actual de la pieza dañada
     * @param pvEPiezasDanadas recibe la pieza dañada
     */
    public void setPvEPiezasDanadas(int pvEPiezasDanadas)
    {
        this.ppvEPiezasDanadas = pvEPiezasDanadas;
    }

    /**
     * getPvEPiezasAsignadas() método que contiene el valor actual de la pieza asignada
     * @return retorna el valor de la pieza asignada
     */
    public int getPvEPiezasAsignadas()
    {
        return ppvEPiezasAsignadas;
    }

    /**
     * setPvEPiezasAsignadas() método que contiene el valor actual de la pieza asignada
     * @param pvEPiezasAsignadas recibe la número de pieza asignada
     */
    public void setPvEPiezasAsignadas(int pvEPiezasAsignadas)
    {
        this.ppvEPiezasAsignadas = pvEPiezasAsignadas;
    }

    /**
     * getPvSClaveVestuario() método que contiene el valor actual de la clave del vestuario
     * @return retorna el valor de la clave del vestuario
     */
    public String getPvSClaveVestuario()
    {
        return ppvSClaveVestuario;
    }

    /**
      * setPvSClaveVestuario() método que contiene el valor actual de la clave del vestuario
     * @param pvSClaveVestuario recibe la clave del vestuario
     */
    public void setPvSClaveVestuario(String pvSClaveVestuario)
    {
        this.ppvSClaveVestuario = pvSClaveVestuario;
    }
    
    /**
     * getPvEExistencia() método que contiene el valor actual de la existencia
     * @return retorna el valor de la existencia
     */
    public int getPvEExistencia()
    {
        return ppvEExistencia;
    }
    
    /**
     * setPvEExistencia() método que contiene el valor actual de la existencia
     * @param pvEExistencia recibe la existencia del inventario 
     */
    public void setPvEExistencia(int pvEExistencia)
    {
        this.ppvEExistencia = pvEExistencia;
    }
}
