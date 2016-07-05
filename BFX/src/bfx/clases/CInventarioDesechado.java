/*Nombre de clase		: CInventarioDesechado
*Descripción de la clase	: Clase donde se realizan las propiedades de la clase con sus metodos encapsulados. 
*Fecha	de creación		: 02/05/2016
*Elaboro			: Oscar De Paz Feliciano 
*Fecha	de Liberación		: 19/06/2016
*Autorizó			: Mauro Sánchez Sánchez
*Fecha Mantenimiento		: 19/06/2016
*Folio mantenimiento		: 02
*Descripción del mantto.	: Se realizó la transformación de código con calidad.
*Responsable			: Oscar De Paz Feliciano
*Revisor 			: Oscar De Paz Feliciano
*/
package bfx.clases;
/**
 * Clase CInventarioDesechado con sus propiedades sets y gets con encapsulamiento y contructores.
 * @author: Techno Engineers
 * @versión: 2.0 
 */
public class CInventarioDesechado
{
    private int ppvEIdInventarioDesechado;
    private int ppvEIdInventario;
    private String ppvSTipo;
    private String ppvSMotivo;
    private int ppvEIdUsuario;
    private String ppvSNombre;
    private String ppvSApellidoPaterno;
    private String ppvSApellidoMaterno;
    private int ppvEPiezas;
    private String ppvSDescripcion;

    
    /**
     * CInventarioDesechado constructor por defecto sin función
     */
    public CInventarioDesechado()
    {
        
    }
    
    /**
     * CInventarioDesechado contructor que inicializa los atributos a
     * de un objeto a partir de los siguientes parámetros:
     * 
     * @param lEIdInventarioDesechado   : hace referencia al identificador del inventario desechado
     * @param lEIdInventario            : indica el idinventario que pertenece el desecho
     * @param lSTipo                    : indica el tipo por el cual se esta eliminando
     * @param lSMotivo                  : indica el motivo por el cual se esta aliminando
     * @param lEIdUsuario               : indica el id del usuario quien es responsable de la eliminación
     */
    public CInventarioDesechado(int lEIdInventarioDesechado,int lEIdInventario, String lSTipo,String lSMotivo, int lEIdUsuario)
    {
       if(lEIdInventarioDesechado<=0)
        {
           System.out.println("El identificador del inventario desechado no es valido.");
        }else
        {
          this.ppvEIdInventarioDesechado= lEIdInventarioDesechado;  
        } 
       
       if(lEIdInventario<=0)
        {
           System.out.println("El identificador del inventario no es valido.");
        }else
        {
          this.ppvEIdInventario= lEIdInventario;  
        }
       
       if(lSTipo=="" || lSTipo==null)
        {
           lSTipo="dañada";
        }else
        {
          this.ppvSTipo= lSTipo;  
        }
       
       if(lSMotivo=="" || lSMotivo==null)
        {
           lSTipo="No se pudo reparar el daño.";
        }else
        {
          this.ppvSMotivo= lSMotivo;  
        }
       if(lEIdUsuario<0)
        {
           System.out.println("El identificador del usuario desechado no es valido.");
        }else
        {
          this.ppvEIdUsuario= lEIdUsuario;  
        } 
    }
    
    public CInventarioDesechado(int pvEIdInventarioDesechado, String pvSTipo, String pvSMotivo, String pvSNombre, String pvSApellidoPaterno, String pvSApellidoMaterno, int pEPiezas, String pSDescripcion)
    {
        this.ppvEIdInventarioDesechado = pvEIdInventarioDesechado;
        this.ppvSTipo = pvSTipo;
        this.ppvSMotivo = pvSMotivo;
        this.ppvSNombre = pvSNombre;
        this.ppvSApellidoPaterno = pvSApellidoPaterno;
        this.ppvSApellidoMaterno = pvSApellidoMaterno;
        this.ppvEPiezas = pEPiezas;
        this.ppvSDescripcion = pSDescripcion;
    }
    /**
     * getPvEIdInventarioDesechado() método que contiene el valor actual del id del inventario desechado
     * 
     * @return   retorna el valor del id del inventario desechado
     */
    public int getPvEIdInventarioDesechado()
    {
        return ppvEIdInventarioDesechado;
    }

    /**
     * setPvEIdInventarioDesechado() método que indica el valor del inventario desechado a establecer como objeto
     * 
     * @param pvEIdInventarioDesechado recibe el id inventario desechado
     */
    public void setPvEIdInventarioDesechado(int pvEIdInventarioDesechado)
    {
        this.ppvEIdInventarioDesechado = pvEIdInventarioDesechado;
    }

    /**
     * getPvEIdInventario() método que contiene el valor actual del id del inventario 
     * @return  retorna el valor del id del inventario 
     */
    public int getPvEIdInventario()
    {
        return ppvEIdInventario;
    }
    
    /**
     * setPvEIdInventario() método que indica el valor del inventario a establecer como objeto
     * @param pvEIdInventario recibe el id inventario 
     */
    public void setPvEIdInventario(int pvEIdInventario)
    {
        this.ppvEIdInventario = pvEIdInventario;
    }
    
    /**
     * getPvSTipo() método que contiene el valor actual del tipo
     * @return  retorna el valor del tipo
     */
    public String getPvSTipo()
    {
        return ppvSTipo;
    }

    /**
     * setPvSTipo() método que indica el valor del tipo a establecer como objeto
     * @param pvSTipo recibe el tipo
     */
    public void setPvSTipo(String pvSTipo)
    {
        this.ppvSTipo = pvSTipo;
    }

    /**
     * getPvSMotivo() método que contiene el valor actual del motivo
     * @return retorna el valor del motivo
     */
    public String getPvSMotivo()
    {
        return ppvSMotivo;
    }
    
    /**
     * setPvSMotivo método que indica el valor del motivo a establecer como objeto
     * @param pvSMotivo recibe el motivo
     */
    public void setPvSMotivo(String pvSMotivo)
    {
        this.ppvSMotivo = pvSMotivo;
    }
    
    /**
     * getPvEIdUsuario() método que contiene el valor actual del id usuario
     * @return retorna el valor del id usuario
     */
    public int getPvEIdUsuario()
    {
        return ppvEIdUsuario;
    }

    /**
     * setPvSMotivo método que indica el valor del id usuario lo establecer como objeto
     * @param pvEIdUsuario recibe el id usuario
     */
    public void setPvEIdUsuario(int pvEIdUsuario)
    {
        this.ppvEIdUsuario = pvEIdUsuario;
    }

    public String getPvSNombre()
    {
        return ppvSNombre;
    }

    public void setPvSNombre(String pvSNombre)
    {
        this.ppvSNombre = pvSNombre;
    }

    public String getPvSApellidoPaterno()
    {
        return ppvSApellidoPaterno;
    }

    public void setPvSApellidoPaterno(String pvSApellidoPaterno)
    {
        this.ppvSApellidoPaterno = pvSApellidoPaterno;
    }

    public String getPvSApellidoMaterno()
    {
        return ppvSApellidoMaterno;
    }

    public void setPvSApellidoMaterno(String pvSApellidoMaterno)
    {
        this.ppvSApellidoMaterno = pvSApellidoMaterno;
    }

    public int getPvEPiezas()
    {
        return ppvEPiezas;
    }

    public void setPvEPiezas(int pvEPiezas)
    {
        this.ppvEPiezas = pvEPiezas;
    }

    public String getPvSDescripcion()
    {
        return ppvSDescripcion;
    }

    public void setPvSDescripcion(String pvSDescripcion)
    {
        this.ppvSDescripcion = pvSDescripcion;
    }
}
