/*Nombre de la clase                         : CDanios 
 * Descripción de la clase                 : Clase que permite manipular la operaciones del modelo de negocio del módulo de daños 
 * Fecha de creación                           : 25/Abril/2016 
 * Elaboró                                               : Rojas Simón Jonathan y Hernández Benitez Marvin Atzael 
 * Fecha de Liberación                        : - 
 * Autorizó                                               : - 
 * Fecha Mantenimiento                      : 09/Mayo/2016 
 * Folio mantenimiento                         : 01 
 * Descripción del mantenimiento    : Optimización de las consultas a través de más condiciones de daños a la BD trajin 
 * Responsable                                      : Rojas Simón Jonathan 
 * Revisor                                                : Mauro Sánchez Sánchez
 */
package bfx.clases;

import bfx.controladores.CConexion;
import bfx.controladores.CManipulaDB;
import bfx.controladores.CMensajes;
import bfx.controladores.CQuerys;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Clase que permite utilizar operaciones del modelo de negocio
 * @author Techno Engineers
 * @version 1.0
 */
public class CDanios
{

    /**
     * Constructor vacío
     */
    public CDanios()
    {

    }

    /**
     * Constructor que inicializa un objeto de tipo Daño
     *
     * @param pEIdDanio identificador de daño
     * @param pSFechadepago fecha de pago realizado
     * @param pSFecharegistro fecha de registro del daño
     * @param pEIdUsuario identificador del usuario
     * @param pEIdAsignacionVestuario identificador de la asignacion utilizada
     * @param pEMesesDeDanioDanio meses de daño a partir de la fecha del evento a la fecha actual
     * @param pCStatus estado del daño
     * @param pDMonto el valor de lo que debe por lo dañado
     */
    public CDanios(int pEIdDanio, String pSFechadepago, String pSFecharegistro, int pEIdUsuario, int pEIdAsignacionVestuario, int pEMesesDeDanioDanio, char pCStatus, Double pDMonto)
    {
        this.pvEIdDanio = pEIdDanio;
        this.pvSFechadepago = pSFechadepago;
        this.pvSFechaRegistro = pSFecharegistro;
        this.pvEIdUsuario = pEIdUsuario;
        this.pvEIdAsignacionVestuario = pEIdAsignacionVestuario;
        this.pvEMesesDeDanioDanio = pEMesesDeDanioDanio;
        this.pvCStatus = pCStatus;
        this.pvDMonto = pDMonto;
    }

    public JFrame objJFrame = new JFrame();
    CConexion objCConexion = new CConexion();
    public Connection objConnection = CManipulaDB.cmetpbConectaDB();
    public CQuerys objCQuerys = new CQuerys();

    private DefaultComboBoxModel objDefaultComboBoxModel;
    private ArrayList<Object> objArrayList1 = new ArrayList();
    private ArrayList<Object> objArrayList2 = new ArrayList();
    private ResultSet objResultSet;

    private int pvEIdDanio;
    private String pvSFechadepago;
    private String pvSFechaRegistro;
    private int pvEIdUsuario;
    private int pvEIdBailarinEvento;
    private int pvEIdAsignacionVestuario;
    private int pvEMesesDeDanioDanio;
    private char pvCStatus;
    private Double pvDMonto;
    private String pvSCampos;
    private String pvSTablas;
    private String pvSCondiciones;
    private String pvSNombre = "";
    private String pvSDescripcion1;
    private String pvSMesEvento;
    private String pvSDescripcion2;
    private String pvSFechaEvento;
    private String pvSOrden;
    private String pvSEstado;

    /**
     * getpbEIdDanio
     * Método que retorna el valor del identificador de la tabla daño
     *
     * @return idDanio de tipo Int
     */
    public int getpbEIdDanio()
    {
        return pvEIdDanio;
    }

    /**
     * setpbIdDanio
     * Método que establece el valor del identificador de la tabla daño
     *
     * @param lEIdDanio que indica el identificador de la tabla daño de tipo entero
     */
    public void setpbIdDanio(int lEIdDanio)
    {
        this.pvEIdDanio = lEIdDanio;
    }

    /**
     * getpbSFechaDePago
     * Método que retorna la cadena de la fecha de pago
     *
     * @return fechadepago como cadena de la fecha
     */
    public String getpbSFechaDePago()
    {
        return pvSFechadepago;
    }

    /**
     * setpbFechaDePago
     * Método que establece la cadena de la fecha de pago
     *
     * @param lSFechadepago es el parámetro de cadena de la fecha de pago
     */
    public void setpbFechaDePago(String lSFechadepago)
    {
        this.pvSFechadepago = lSFechadepago;
    }

    /**
     * getpbSFechaRegistro
     * Método que retorna la cadena de la fecha de registro
     *
     * @return fecharegistro como cadena de la fecha de registro de daño
     */
    public String getpbSFechaRegistro()
    {
        return pvSFechaRegistro;
    }

    /**
     * setpbFechaRegistro
     * Método que establece el valor de la fecha de registro que registra el daño
     *
     * @param lSFecharegistro es el parámetro de la fecha del reporte del daño
     */
    public void setpbFechaRegistro(String lSFecharegistro)
    {
        this.pvSFechaRegistro = lSFecharegistro;
    }

    /**
     * getpbEIdBailarinEvento 
     * Metodo ecapsulado que devuelve el id del bailarin del evento
     *
     * @return idBailarinEvento
     */
    public int getpbEIdBailarinEvento()
    {
        return pvEIdBailarinEvento;
    }

    /**
     * setpbIdBailarinEvento 
     * Método que establece los valores de la propiedad del idBailarinEvento
     *
     * @param lEIdBailarinEvento Indica los posibles valores retornados del idBailarinEvento de la BD trajin
     */
    public void setpbIdBailarinEvento(int lEIdBailarinEvento)
    {
        this.pvEIdBailarinEvento = lEIdBailarinEvento;
    }

    /**
     * getpbEIdAsignacionVestuario 
     * Método que retorna el valor del id de la asignación de vestuario
     *
     * @return idAsignacionVestuario
     */
    public int getpbEIdAsignacionVestuario()
    {
        return pvEIdAsignacionVestuario;
    }

    /**
     * setpbIdAsignacionVestuario 
     * Método que establece el valor del id de asignación de vestuario
     *
     * @param lEIdAsignacionVestuario Indica los posibles valores retornados del
     * idAsignacionVestuario de la BD trajin
     */
    public void setpbIdAsignacionVestuario(int lEIdAsignacionVestuario)
    {
        this.pvEIdAsignacionVestuario = lEIdAsignacionVestuario;
    }

    /**
     * getpbEMesesDeDanioDanio
     * Método que devurlve el valor del atributo de los meses de daño
     *
     * @return mesesDeDanioDanio
     */
    public int getpbEMesesDeDanioDanio()
    {
        return pvEMesesDeDanioDanio;
    }

    /**
     * setpbMesesDeDanioDanio
     * Método que establece el valor del mes de daño a partir del calculo del mismo
     *
     * @param lEMesesDeDanioDanio Recibe la cantidad en entero los meses de daño
     */
    public void setpbMesesDeDanioDanio(int lEMesesDeDanioDanio)
    {
        this.pvEMesesDeDanioDanio = lEMesesDeDanioDanio;
    }

    /**
     * getpbSObjStringDescripcion
     * Método que retorna el valor del atributo objStringDescripcion
     *
     * @return objStringDescripcion de la prenda dañada
     */
    public String getpbSObjStringDescripcion()
    {
        return pvSDescripcion2;
    }

    /**
     * setpbObjStringDescripcion
     * Método que establece los valores de la descripción del vestuario dañado
     *
     * @param lSDescripcion2 Recibe el valor de la descripción de la
     * prenda o accesorio dañado
     */
    public void setpbObjStringDescripcion(String lSDescripcion2)
    {
        this.pvSDescripcion2 = lSDescripcion2;
    }

    /**
     * getpbDObjDMonto
     * Método que retorna el valor del atributo del monto de la deuda del daño
     *
     * @return objDMonto que almacena el valor del daño
     */
    public Double getpbDObjDMonto()
    {
        return pvDMonto;
    }

    /**
     * setpbObjDMonto
     * Método que establece el valor del daño de la prenda o accesorio
     *
     * @param lDMonto que almacena el valor del monto del daño
     */
    public void setpbObjDMonto(Double lDMonto)
    {
        this.pvDMonto = lDMonto;
    }

    /**
     * getpbCObjCStatus 
     * Método que retorna el valor del status de la prenda o accesorio dependiendo del bailarin
     *
     * @return objCStatus que indica el caracter de dañado o reparado
     */
    public char getpbCObjCStatus()
    {
        if (pvCStatus == '1' || pvCStatus == '0' || pvCStatus == '2') //En caso de que no encuentre nada como parametro
        {
            return pvCStatus;
        } else
        {
            return '1' ; //Que muestre los vestuarios que estan dañados
        }
    }

    /**
     * setpbObjCStatus
     * Método que establece el status de la prenda o accesoio dañado
     *
     * @param lCStatus Establece el estado de la prenda o accesorio dañado
     */
    public void setpbObjCStatus(char lCStatus)
    {
        this.pvCStatus = lCStatus; //Para cualquier otro caso
    }

    /**
     * getpbEIdUsuario 
     * Método que retorna el identificador de usuario de la BD trajin
     *
     * @return idUsuario indica la variable de tipo entero que indica el numero de usuario
     */
    public int getpbEIdUsuario()
    {
        return pvEIdUsuario;
    }

    /**
     * setpbIdUsuario 
     * Método que establece el valor del identificador de Usuario de la BD trajin
     *
     * @param lEIdUsuario es la variable que establece el numero del usuario
     */
    public void setpbIdUsuario(int lEIdUsuario)
    {
        this.pvEIdUsuario = lEIdUsuario;
    }

    /**
     * getpbRObjResultSet 
     * Método que retorna el valor de un objeto de tipo ResultSet cuando se hace una consulta a la BD trajin
     *
     * @return objResultSet indica el valor que retorna cuando éste método es llamado
     */
    public ResultSet getpbRObjResultSet()
    {
        return objResultSet;
    }

    /**
     * setpbObjResultSet 
     * Método que establece el valor al hacer una consulta a la BD trajin
     *
     * @param lRResultSet indica el valor o conjunto de valores correspondientes cuando se realiza una consulta
     */
    public void setpbObjResultSet(ResultSet lRResultSet)
    {
        this.objResultSet = lRResultSet;
    }

    /**
     * getpbALObjArrayList3 
     * Método que retorna un objeto de tipo ArrayList cuando se realiza una consulta a la BD a través del método selecciona de la clase Querys
     *
     * @return objArrayList3 indica el conjunto de valores que retorna el método selecciona de la clase Querys
     */
    public ArrayList<Object> getpbALObjArrayList3()
    {
        return objArrayList1;
    }

    /**
     * setpbObjArrayList3 
     * Método que estyablece el valor del objeto de tipo ArrayList cuando re realiza una consulta con el método selecciona de la clase Querys
     *
     * @param lALArrayList1 indica el conjunto de valores que manda e método selecciona de la clase Querys
     */
    public void setpbObjArrayList3(ArrayList<Object> lALArrayList1)
    {
        this.objArrayList1 = lALArrayList1;
    }

    /**
     * getpbSObjSStringCampos5 
     * Método que retorna el conjunto de campos que se mandan a través del los métodos de triggers de la clase Querys a la BD trajin
     *
     * @return objSStringCampos5 incluye todos los campos necesarios para realizar un trigger
     */
    public String getpbSObjSStringCampos5()
    {
        return pvSCampos;
    }

    /**
     * setpbObjSStringCampos5
     * Método que establece el conjunto de campos que se mandan a través de los métodos de triggers de la clase Querys a la BD trajin
     *
     * @param lSCampos indica todos los campos necesarios para realizar tales operaciones
     */
    public void setpbObjSStringCampos5(String lSCampos)
    {
        this.pvSCampos = lSCampos;
    }

    /**
     * getpbSObjSStringTablas6 
     * Método que retorna la(s) necesarias para realizar una operación a la BD trajin
     *
     * @return objSStringTablas6 indica las tablas a manipular
     */
    public String getpbSObjSStringTablas6()
    {
        return pvSTablas;
    }

    /**
     * setpbObjSStringTablas6
     * Método que establece la(s) necesarias para realizar una operación a la BD trajin
     *
     * @param lSTablas indica las tablas a manipular
     */
    public void setpbObjSStringTablas6(String lSTablas)
    {
        this.pvSTablas = lSTablas;
    }

    /**
     * getpbSObjStringCondiciones7 
     * Método que retorna el conjunto de condiciones necesarias para los triggers de la clase Querys
     *
     * @return objStringCondiciones7 engloba todas las condiciones
     */
    public String getpbSObjStringCondiciones7()
    {
        return pvSCondiciones;
    }

    /**
     * setpbObjStringCondiciones7
     * Método que establece el valor de las condiciones necesarias para los triggers de la clase Querys
     *
     * @param lSCondiciones engloba todas las condiciones
     */
    public void setpbObjStringCondiciones7(String lSCondiciones)
    {
        this.pvSCondiciones = lSCondiciones;
    }

    /**
     * getpbSDescripcion
     * Método que retorna la cadena correspondiente a la descripción de la prenda o accesorio dañado
     *
     * @return Descripcion que almacena la cadena de la prenda o accesorio
     */
    public String getpbSDescripcion()
    {
        return pvSDescripcion1;
    }

    /**
     * setpbDescripcion 
     * Método que establece la cadena correspondiente a la descripción de la prenda o accesorio dañado
     *
     * @param lSDescripcion1 que almacena la cadena de la prenda o accesorio
     */
    public void setpbDescripcion(String lSDescripcion1)
    {
        this.pvSDescripcion1 = lSDescripcion1;
    }

    /**
     * getpbJCObjDefaultComboBoxModel 
     * Método que retorna el valor del objeto de tipo DefaultComboBoxModel para almacenar conjuntos de valores
     *
     * @return objDefaultComboBoxModel que almacena el conjunto de valores de tipo JCombobox
     */
    public DefaultComboBoxModel getpbJCObjDefaultComboBoxModel()
    {
        return objDefaultComboBoxModel;
    }

    /**
     * setpbObjDefaultComboBoxModel
     * Método que establece el valor del objeto de tipo DefaultComboboxModel para almacenar conjuntos de valores
     *
     * @param lJCModel que almacena el conjunto de valores de tipo JCombobox
     */
    public void setpbObjDefaultComboBoxModel(DefaultComboBoxModel lJCModel)
    {
        this.objDefaultComboBoxModel = lJCModel;
    }

    /**
     * getpbSMesEvento 
     * Método que devuelve el valor en cadena correspodiente al mes del evento
     *
     * @return MesEvento que almacena la cadena del mes
     */
    public String getpbSMesEvento()
    {
        return pvSMesEvento;
    }

    /**
     * setpbMesEvento 
     * Método que establece el valor del mes del evento recibiendo como parámetro al MesEvento
     *
     * @param lSMesEvento Almacena la cadena del mes del evento
     */
    public void setpbMesEvento(String lSMesEvento)
    {
        this.pvSMesEvento = lSMesEvento;
    }

    /**
     * getpbSObjStringNombre 
     * Método que retorna el nombre completo del bailarin del evento
     *
     * @return objStringNombre es la cadena que almacena el nombre completo del bailarín del evento
     */
    public String getpbSObjStringNombre()
    {
        return pvSNombre;
    }

    /**
     * setpbObjStringNombre 
     * Método que establece el nombre completo del bailarin del evento
     *
     * @param lSNombre almacena el nombre completo del bailarin del evento
     */
    public void setpbObjStringNombre(String lSNombre)
    {
        this.pvSNombre = lSNombre;
    }

    /**
     * getpbSObjStringFechaEvento
     * Método que establece la ultima fecha del evento
     *
     * @return objStringFechaEvento acumula a la cadena de la ultima fecha del evento
     */
    public String getpbSObjStringFechaEvento()
    {
        return pvSFechaEvento;
    }

    /**
     * setpbObjStringFechaEvento 
     * Método que establece la fecha del evento
     *
     * @param lSFechaEvento almacena la cadena de la fecha del ultimo evento
     */
    public void setpbObjStringFechaEvento(String lSFechaEvento)
    {
        this.pvSFechaEvento = lSFechaEvento;
    }

    /**
     * getpbSObjStringOrden 
     * Método que establece el orden de la consulta de daños de la BD trajin
     *
     * @return objStringOrden almacena nulo, desc o asc
     */
    public String getpbSObjStringOrden()
    {
        if (pvSOrden == null)
        {
            return pvSOrden = "desc" ;
        } else
        {
            return pvSOrden ;
        }
    }

    /**
     * setpbObjStringOrden 
     * Método que establece el orden de la consulta a la BD (ascendente, descendente)
     *
     * @param lSOrden almacena la prioridad de la busqueda
     */
    public void setpbObjStringOrden(String lSOrden)
    {
        this.pvSOrden = lSOrden;
    }

    /**
     * getpbSObjStringEstado 
     * Método que retorna el valor del estado
     *
     * @return objStringEstado almacena nulo, dañado o reparado
     */
    public String getpbSObjStringEstado()
    {
        if (pvSEstado == null)
        {
            return pvSEstado = "1";
        } else if (pvSEstado.equals("Dañado"))
        {
            return pvSEstado = "1";
        } else if (pvSEstado.equals("Reparado"))
        {
            return pvSEstado = "0";
        }
        return pvSEstado;
    }

    /**
     * setpbObjStringEstado
     * Método que establece el valor del estado a partir de la GUI
     *
     * @param lSEstado acumula rl valor del estado (dañado, reparado)
     */
    public void setpbObjStringEstado(String lSEstado)
    {
        this.pvSEstado = lSEstado;
    }

    /**
     * getpbALObjArrayList4 
     * Método que establece el valor de otro ArrayList como una variable auxiliar
     *
     * @return objArrayList4 retorna un ArrayList de tipo Object
     */
    public ArrayList<Object> getpbALObjArrayList4()
    {
        return objArrayList2;
    }

    /**
     * setpbObjArrayList4 
     * Método que establece el valor de otro ArrayList como una variable auxiliar
     *
     * @param lALArrayList2 recibe un ArrayList de tipo Object
     */
    public void setpbObjArrayList4(ArrayList<Object> lALArrayList2)
    {
        this.objArrayList2 = lALArrayList2;
    }

    /**
     * metpbConsultaUsuarios 
     * Método que realiza una consulta a la base de datos de todos los usuarios que han dañado alguna prenda o accesorio
     */
    public void metpbConsultaUsuarios()
    {
        try
        {
            Statement objStmt = objConnection.createStatement();
            setpbObjResultSet(objStmt.executeQuery("select usuarios.idusuario,usuarios.nombre,usuarios.apellidopaterno,usuarios.apellidomaterno "
                    + "from usuarios,bailarinesevento where usuarios.idUsuario = bailarinesevento.idUsuario;"));
        } catch (SQLException lSQLEex)
        {
            CMensajes.cmetpbFalla(objJFrame , "No se pudo concretar la acción, verificque otra vez " + lSQLEex.getMessage());
        }
    }

    /**
     * metpbObtenerFechaEvento 
     * Método que ayuda a obtener la fecha del ultimo evento y lo almacena en el objeto de tipo ArrayList
     */
    public void metpbObtenerFechaEvento()
    {
        pvSCampos = "MAX(eventos.fecha) as fecha";
        pvSTablas = "eventos";
        setpbObjArrayList3(objCQuerys.metpbALSeleccion(objConnection, pvSCampos, pvSTablas, ""));
    }

    /**
     * obtenerIdBailarinEvento 
     * Método que ayuda a obtener el id del bailarin del evento para realizar una comparación de lo asignado
     */
    public void obtenerIdBailarinEvento()
    {
        pvSCampos = "bailarinesevento.idbailarinevento";
        pvSTablas = " usuarios , bailarinesevento, eventos , cuadroevento , regionesevento , bailesevento ";
        pvSCondiciones = " usuarios.idUsuario = bailarinesevento.idUsuario "
                + " and usuarios.idusuario = " + getpbEIdUsuario() + ""
                /*+ " and usuarios.idusuario=1"*/
                + " and eventos.ideventos = (select MAX(eventos.ideventos) from eventos)"
                + " and eventos.ideventos = cuadroevento.idevento"
                + " and cuadroevento.idcuadroevento = regionesevento.idcuadroevento"
                + " and regionesevento.idregionevento = bailesevento.idregionesevento"
                + " and bailesevento.idbailesevento = bailarinesevento.idbailesevento";

        setpbObjArrayList3(objCQuerys.metpbALSeleccion(objConnection , pvSCampos , pvSTablas , pvSCondiciones));

        String lSCadena = "( ";

        for (int lEi = 0 ; lEi < objArrayList1.size() ; lEi ++)
        {
            if (lEi == 0)
            {
                lSCadena += " idbailarinevento = " + objArrayList1.get(lEi);
            } else
            {
                lSCadena += " or idbailarinevento = " + objArrayList1.get(lEi);
            }
        }
        lSCadena += " ) ";
        System.out.println(lSCadena);
        /*setIdBailarinEvento(Integer.parseInt(objArrayList3.get(0).toString()));*/
        setpbObjArrayList4(objArrayList1);
        metpbObtenerDescripcionVestuario(lSCadena);

    }

    /**
     * metpbSRecortaResultado 
     * Método que ayuda a recortar los corchetes generados del método Selección de la clase Querys
     *
     * @param objArrayList3 Recibe los valores retornados del método Selecciona de la clase Querys
     * @return getpbALObjArrayList3
     */
    public String metpbSRecortaResultado(ArrayList<Object> objArrayList3)
    {
        return getpbALObjArrayList3().toString().substring(1 , getpbALObjArrayList3().toString().length() - 2);
    }

    /**
     * metpbObtenerDescripcionVestuario 
     * Método que retorna la descripción del vestuario a partir del id del bailarin del evento
     *
     * @param lSCadena que trae todos los valores como identificadores asociados
     */
    public void metpbObtenerDescripcionVestuario(String lSCadena)
    {

        pvSCampos = "vestuarios.descripcion";
        pvSTablas = "vestuarios , inventarios , asignavestuario";
        pvSCondiciones = "asignavestuario.idinventario = inventarios.idinventario and "
                + "inventarios.idvestuario = vestuarios.idvestuario and "
                + lSCadena;
        setpbObjArrayList3(objCQuerys.metpbALSeleccion(objConnection, pvSCampos, pvSTablas, pvSCondiciones));

        setpbObjDefaultComboBoxModel(new DefaultComboBoxModel(getpbALObjArrayList3().toArray()));

    }

    /**
     * metpbObteneridAsignacionVestuario 
     * Método que establece el id de la asignación de vestuario como requisito a la inserción a la BD trajin
     *
     * @param lEIndice es la que indica el indice
     */
    public void metpbObteneridAsignacionVestuario(int lEIndice)
    {
        setpbIdBailarinEvento(Integer.parseInt(objArrayList2.get(lEIndice).toString().trim()));
        pvSCampos = "asignavestuario.idasignavestuario";
        pvSTablas = "vestuarios , inventarios , asignavestuario";
        pvSCondiciones = "asignavestuario.idinventario = inventarios.idinventario and "
                + "inventarios.idvestuario = vestuarios.idvestuario and "
                + "idbailarinevento = " + getpbEIdBailarinEvento() + " and "
                + "vestuarios.descripcion = '" + getpbSDescripcion() + "'";
        objArrayList1 = objCQuerys.metpbALSeleccion(objConnection, pvSCampos, pvSTablas, pvSCondiciones);
        setpbIdAsignacionVestuario(Integer.parseInt(metpbSRecortaResultado(objArrayList1)));
    }

    /**
     * metpbObtenerMesesDeAdeudo 
     * Método que ayuda a calcular la diferencia de meses que hay entre la fecha del evento y el registro de la fecha de registro de daño
     */
    public void metpbObtenerMesesDeAdeudo()
    {
        pvSCampos = " distinct curdate() ";
        pvSTablas = " eventos ";

        objArrayList1 = objCQuerys.metpbALSeleccion(objConnection, pvSCampos, pvSTablas, "");

        String lSAnio1 = objArrayList1.get(0).toString().trim().substring(0, 4);
        String lSMes1 = objArrayList1.get(0).toString().trim().substring(5, 7);
        String lSResultado2 = lSAnio1 + lSMes1;

        String lSAnio = getpbSMesEvento().trim().substring(0, 4);
        String lSMes = getpbSMesEvento().trim().substring(5, 7);
        String lSResultado1 = lSAnio + lSMes;

        objArrayList1 = objCQuerys.metpbALSeleccion(objConnection , " distinct ABS(PERIOD_DIFF(" + lSResultado1 + " , " + lSResultado2 + ")) " , " eventos " , "");
        setpbMesesDeDanioDanio(Integer.parseInt(objArrayList1.get(0).toString().trim()));

    }

    /**
     * metObtenerCamposInsercion
     * Método que establece los campos necesarios para realizar una inserción a la tabla Daños de la BD trajin
     */
    public void metObtenerCamposInsercion()
    {
        pvSCampos = "null,"
                + getpbDObjDMonto() + ",'"
                + "1',"
                + getpbEIdUsuario() + ","
                + getpbEMesesDeDanioDanio() + ","
                + getpbEIdAsignacionVestuario()
                + ",'" + pvSFechaEvento + "'"
                + ",null";
        objCQuerys.metpbSInsertar(objConnection, "danio", pvSCampos);
        try
        {
            //objConnection2.close();
            CMensajes.cmetpbExito(objJFrame);
        } catch (Exception lEXEx)
        {
            CMensajes.cmetpbMsj(objJFrame, "Error en DB... " + lEXEx.getMessage());
        }
    }

    /**
     * metpbCerrarConexion
     * Método que perite cerrar la coneción a la base de datos trajin
     */
    public void metpbCerrarConexion()
    {
        objCConexion.metpbDesconectar(objConnection);
    }

    /**
     * metpbALObtenerDanios
     * Método que consulta los datos que serán mostrados en la tabla para consultar daños
     *
     * @return ArrayList de la clase CDanios1
     */
    public ArrayList<CDanios1> metpbALObtenerDanios()
    {
        ArrayList<CDanios1> lALDanios;
        CDanios objCDanios = new CDanios();
        CQuerys objCQuerys = new CQuerys();
        pvSCampos = " danio.iddanio , usuarios.nombre , usuarios.apellidopaterno , usuarios.apellidomaterno , vestuarios.descripcion , danio.status , danio.monto , danio.fecharegistro , danio.fechadepago ";
        pvSTablas = " usuarios,vestuarios , danio , bailarinesevento , inventarios , asignavestuario ";
        pvSCondiciones = " bailarinesevento.idusuario = usuarios.idusuario and vestuarios.idvestuario = inventarios.idvestuario"
                + " and inventarios.idinventario = asignavestuario.idinventario and danio.idasignavestuario = asignavestuario.idasignavestuario "
                + " and bailarinesevento.idbailarinevento = asignavestuario.idbailarinevento order by danio.fecharegistro asc";

        lALDanios = CManipulaDB.cmetpbALCargaDatosDanios(objCQuerys.metpbALSeleccion(objCDanios.objConnection, pvSCampos, pvSTablas, pvSCondiciones));

        return lALDanios;
    }

    /**
     * metpbConsultaDanio
     * Método que realiza una consulta multitabla a la BD
     *
     * @param lEIdUsuario indica la condicion a realizar la consulta
     */
    public void metpbConsultaDanio(int lEIdUsuario)
    {
        pvSCampos = "usuarios.nombre,usuarios.apellidopaterno,usuarios.apellidomaterno,danio.status,danio.monto,danio.fecharegistro,danio.fechadepago,vestuarios.descripcion,usuarios.idusuario";
        pvSTablas = "usuarios,danio,bailarinesevento,asignavestuario,inventarios,vestuarios";
        pvSCondiciones = "danio.iddanio =" + lEIdUsuario + " and danio.idasignavestuario=asignavestuario.idasignavestuario and "
                + "asignavestuario.idbailarinevento = bailarinesevento.idbailarinevento  and bailarinesevento.idusuario = usuarios.idusuario"
                + " and asignavestuario.idinventario = inventarios.idinventario and inventarios.idvestuario = vestuarios.idvestuario";
        objArrayList1 = objCQuerys.metpbALSeleccion(objConnection, pvSCampos, pvSTablas, pvSCondiciones);
    }

    /**
     * metpbModificaDanio
     * Método que especifica los nuevos valores a partir de una modificación
     *
     * @param lEIdDanio envía el id del danio que se va a realizar una modificación
     * @param lSVestuario envía la descripcion del vestuario asociado
     */
    public void metpbModificaDanio(int lEIdDanio, String lSVestuario)
    {
        String lSTabla = " inventarios , vestuarios ";
        String lSColumnas = " inventarios.piezasdaniadas, inventarios.existencia";
        String lSNvalores = "";
        ArrayList<Object> objArrayList = new ArrayList<>();
        
        if ((Double.parseDouble(getpbALObjArrayList3().get(4).toString().trim()) == getpbDObjDMonto() && getpbALObjArrayList3().get(3).toString().trim().equals(String.valueOf(getpbCObjCStatus())) == false)
                || (Double.parseDouble(getpbALObjArrayList3().get(4).toString().trim()) != getpbDObjDMonto() && getpbALObjArrayList3().get(3).toString().trim().equals(String.valueOf(getpbCObjCStatus())) == false))
        {
            if (getpbCObjCStatus() == '0')
            {
                objCQuerys.metpbSModificar(objConnection , "danio" , "monto,status,fechadepago" , "" + getpbDObjDMonto() + " , " + getpbCObjCStatus() + ", curdate()" , "idDanio = " + lEIdDanio);
                lSNvalores = " inventarios.piezasdaniadas - 1 , inventarios.existencia + 1 ";
                CMensajes.cmetpbExito(objJFrame);
                
                String lSCampos = " usuarios.nombre,danio.status ";
                String lSTablas = " usuarios,danio ";
                String lSCondiciones = " danio.idusuario = usuarios.idusuario and "
                        + " danio.status = '1' and "
                        + " usuarios.idusuario = "+getpbALObjArrayList3().get(8).toString().trim();
                
                ArrayList<Object> lALCadenaPrueba = objCQuerys.metpbALSeleccion(objConnection , lSCampos , lSTablas , lSCondiciones);
                if (lALCadenaPrueba.get(0).toString().trim().equals(""))
                {
                    int lEStatus = Integer.parseInt(objCQuerys.metpbALSeleccion(objConnection, "status", "usuarios", "idusuario = "+getpbALObjArrayList3().get(8).toString().trim()).get(0).toString().trim());
                    System.out.println(lEStatus);
                    switch (lEStatus)
                    {
                        case 2:
                            objCQuerys.metpbSModificar(objConnection, "usuarios", "status", "1", "idusuario = "+getpbALObjArrayList3().get(8).toString().trim());
                            break;
                        case 4:
                            objCQuerys.metpbSModificar(objConnection, "usuarios", "status", "3", "idusuario = "+getpbALObjArrayList3().get(8).toString().trim());
                            break;
                    }
                }                 

            } else if (getpbCObjCStatus() == '1')
            {
                objArrayList = metALConsultaDanios();
                if (objArrayList.isEmpty() || objArrayList.get(0).toString().trim().equals(""))
                {
                    objCQuerys.metpbSModificar(objConnection , "danio" , "monto,status,fechadepago" , "" + getpbDObjDMonto() + "," + getpbCObjCStatus() + ",null", "idDanio = " + lEIdDanio);
                    lSNvalores = " inventarios.piezasdaniadas+1 , inventarios.existencia-1 ";
                    CMensajes.cmetpbExito(objJFrame);
                    
                    int lEStatus = Integer.parseInt(objCQuerys.metpbALSeleccion(objConnection, "status", "usuarios", "idusuario = " + getpbALObjArrayList3().get(8).toString().trim()).get(0).toString().trim());
                    System.out.println(lEStatus);
                    switch (lEStatus)
                    {
                        case 1:
                            objCQuerys.metpbSModificar(objConnection, "usuarios", "status", "2", "idusuario = " + getpbALObjArrayList3().get(8).toString().trim());
                            break;
                        case 3:
                            objCQuerys.metpbSModificar(objConnection, "usuarios", "status", "4", "idusuario = " + getpbALObjArrayList3().get(8).toString().trim());
                            break;
                    }
                } else
                {
                    CMensajes.cmetpbFalla(objJFrame, "Existe un daño dentro de la base de datos que cumple con todos los datos");
                }

            }

            String lSCondicion = " vestuarios.descripcion='" + lSVestuario + "' and vestuarios.idvestuario= inventarios.idvestuario ";

            if (objArrayList.isEmpty() || objArrayList.get(0).toString().trim().equals(""))
            {
                String resultado = objCQuerys.metpbSModificar(objConnection, lSTabla, lSColumnas, lSNvalores, lSCondicion);
                if (resultado == null)
                {
                    JOptionPane.showMessageDialog(objJFrame , "Se han actualizado inventarios");
                } else
                {
                    CMensajes.cmetpbFalla(objJFrame , resultado);
                }
            } 
        } else if (Double.parseDouble(getpbALObjArrayList3().get(4).toString().trim()) != getpbDObjDMonto() && getpbALObjArrayList3().get(3).toString().trim().equals(String.valueOf(getpbCObjCStatus())))
        {
            if (getpbCObjCStatus() == '0')
            {
                objCQuerys.metpbSModificar(objConnection , "danio" , "monto , status , fechadepago" , "" + getpbDObjDMonto() + "," + getpbCObjCStatus() + ",curdate()" , "idDanio = " + lEIdDanio);
            } else if (getpbCObjCStatus() == '1')
            {
                objCQuerys.metpbSModificar(objConnection , "danio" , "monto , status , fechadepago" , "" + getpbDObjDMonto() + "," + getpbCObjCStatus() + ",null" , "idDanio = " + lEIdDanio);
            }
            CMensajes.cmetpbExito(objJFrame);
            System.out.println("Aqui si debes de entrar");

        }
    }

    /**
     * metALConsultaDanios 
     * Método para buscar si hay algún daño en la base de datos que pueda producir inconsistencias de datos
     *
     * @return ArrayList
     */
    public ArrayList<Object> metALConsultaDanios()
    {
        ArrayList<Object> lALConsulta = objCQuerys.metpbALSeleccion(objConnection , " danio.idusuario,"
                + " danio.status,"
                + "danio.idasignavestuario,"
                + "eventos.fecha ", " danio"
                + ", usuarios"
                + ", vestuarios"
                + ", inventarios"
                + ", asignavestuario"
                + ", eventos"
                + ", cuadroevento"
                + ", regionesevento"
                + ", bailesevento"
                + ", bailarinesevento" , "danio.status='1' and"
                + " usuarios.nombre='" + getpbALObjArrayList3().get(0).toString().trim() + "' and"
                + " usuarios.apellidopaterno='" + getpbALObjArrayList3().get(1).toString().trim() + "' and"
                + " usuarios.apellidomaterno='" + getpbALObjArrayList3().get(2).toString().trim() + "' and"
                + " vestuarios.descripcion = '" + getpbALObjArrayList3().get(7).toString().trim() + "' and"
                + " eventos.fecha ='" + getpbALObjArrayList3().get(5).toString().trim() + "' and"
                + " eventos.ideventos = cuadroevento.idevento and"
                + " cuadroevento.idcuadroevento = regionesevento.idcuadroevento and"
                + " regionesevento.idregionevento = bailesevento.idregionesevento and"
                + " bailesevento.idbailesevento = bailarinesevento.idbailesevento and"
                + " bailarinesevento.idbailarinevento = asignavestuario.idbailarinevento and"
                + " usuarios.idusuario = danio.idusuario and"
                + " danio.idasignavestuario = asignavestuario.idasignavestuario and"
                + " vestuarios.idvestuario = inventarios.idvestuario and"
                + " inventarios.idinventario = asignavestuario.idinventario");

        return lALConsulta;
    }

}