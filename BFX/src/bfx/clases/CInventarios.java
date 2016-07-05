/*Nombre de clase		: CInventarios
*Descripción de la clase	: Clase donde se realizan las propiedades de la clase con sus metodos encapsulados. 
*Fecha	de creación		: 04/05/2016
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
 * Clase CInventarios con sus propiedades sets y gets con encapsulamiento y contructores.
 * @author: Techno Engineers
 * @versión: 2.0 
 */
public class CInventarios
{
    private static int ppvEconsecutivo=0;
    private int ppvEIdInventario;
    private int ppvEIdVestuario;
    private int ppvECantidad;
    private int ppvEPiezasDanadas;
    private int ppvEPiezasAsignadas;
    private String ppvSClaveVestuario;
    private int ppvEExistencia;
    
    /**
     * CInventarios constructor por defecto sin función
     */
    public CInventarios()
    {
 
    }
    
    /**
     * CInventarios contructor que inicializa los atributos 
     * de un objeto a partir de los siguientes parámetros:
     * 
     * @param lEIdInventario     : indica el idinventario que pertenece la tabla inventarios
     * @param lEIdVestuario      : indica el idvestuario que pertenece el vestuario
     * @param lECantidad         : indica la cantidad que pertenece al inventario
     * @param lEPiezasDanadas    : indica las piezas dañadas en el inventario
     * @param lEPiezasAsignadas  : indica las piezas asignadas en el inventario
     * @param lSClaveVestuario   : indica la clave del vestuario
     * @param lEExistencia          : indica la existencia del inventario
     */
    public CInventarios(int lEIdInventario,int lEIdVestuario, int lECantidad, int lEPiezasDanadas, int lEPiezasAsignadas, String lSClaveVestuario, int lEExistencia)
    {
        if(lEIdInventario<=0)
        {
           System.out.println("El identificador del inventario no es valido.");
        }else
        {
          this.ppvEIdInventario = lEIdInventario;  
        }
     
        if(lEIdVestuario<0)
        {
           System.out.println("El identificador del vestuario no es valido.");
        }else
        {
          this.ppvEIdVestuario = lEIdVestuario;  
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
        //pbEIdInventario = ++pvEconsecutivo;
    }
    
    /**
     * getPvEIdVestuario() método que contiene el valor actual del id del vestuario
     * @return retorna el valor del id del vestuario
     */
    public int getPvEIdVestuario()
    {
        return ppvEIdVestuario;
    }
    
    /**
     * setPvEIdVestuario() método que contiene el valor actual del id del vestuario
     * 
     * @param pvEIdVestuario recibe el id inventario 
     */
    public void setPvEIdVestuario(int pvEIdVestuario)
    {
        this.ppvEIdVestuario = pvEIdVestuario;
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

    /**
     * getPvEIdInventario() método que contiene el valor actual del id inventario
     * @return retorna el valor del id inventario
     */
    public int getPvEIdInventario()
    {
        return ppvEIdInventario;
    }

    /**
     * setPvEIdInventario() método que contiene el valor actual del inventario
     * @param pvEIdInventario recibe el id inventario
     */
    public void setPvEIdInventario(int pvEIdInventario)
    {
        this.ppvEIdInventario = pvEIdInventario;
    }

  
}
