/*Nombre de clase		: CManipulaDB
*Descripción de la clase	: Clase que contiene los métodos "carga" de los respectivos módulos.
*Fecha	de creación		: 01/05/2016
*Elaboró			: Techno Engineers
*Fecha	de Liberación		: 01/05/2016
*Autorizó			: Mauro Sánchez Sánchez
*Fecha Mantenimiento		: 05/06/2016
*Folio mantenimiento		: 02
*Descripción del mantto.	: Se realizó la actualización de comentarios y transformacion de código con calidad.
*Responsable			: Jatziry Barrera Hinojosa
*Revisor 			: Diego Enrique Sánchez Ordoñez
*/
package bfx.controladores;
/**
 * Métodos para cargar informacion de la base de datos al sistema.
 * @author: Techno Engineers
 * @versión: 3.0 
 */
import bfx.Clases.CAdeudos;
import bfx.clases.CBailarinTmp;
import bfx.clases.CBailes;
import bfx.clases.CCuadros;
import bfx.clases.CDanios;
import bfx.clases.CDanios1;
import bfx.clases.CInventarioDesechado;
import bfx.clases.CInventarios;
import bfx.clases.CRegiones;
import bfx.clases.CUsuarioTmp;
import bfx.clases.CVestuarioInventarioTmp;
import bfx.clases.CUsuariosDE;
import bfx.clases.CVestuarioUsuario;
import bfx.clases.CVestuarios;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public class CManipulaDB 
{
    /**
     * cmetpbALCargaUsuarios: coloca la informacion del arraylist de usuarios en campos establecidos
     * 
     * @param lALusuarios -arreglo de objetos que contiene la información
     * @return lALc -retorna un array list de datos para manipular
     */
    public static ArrayList<CAdeudos> cmetpbALCargaAdeudos(ArrayList<Object> lALAdeudos)
    {
        try
        {
            ArrayList<CAdeudos> lALc = new ArrayList<>();
            for (int lEi = 0; lEi < lALAdeudos.size(); lEi += 6)
            {
                int lEid = Integer.parseInt((lALAdeudos.get(lEi).toString().trim()));
                if (lEid != 0 && lEid > 0)
                {
                    int ppvEIdAdeudos = lEid;
                    int ppvIdUsuarios = Integer.parseInt(((String) lALAdeudos.get(lEi + 1)).trim());
                    String ppvSMesAdeudo = ((String) lALAdeudos.get(lEi + 2)).trim();
                    int ppvEAnioAdeudo = Integer.parseInt(((String) lALAdeudos.get(lEi + 3)).trim());
                    double ppvDMontoRenta = Double.parseDouble(((String) lALAdeudos.get(lEi + 4)).trim());
                    String ppvSFechaPago = ((String) lALAdeudos.get(lEi + 5)).trim();
                    
                    CAdeudos objCAdeudos = new CAdeudos(ppvEIdAdeudos, ppvIdUsuarios, ppvSMesAdeudo,
                            ppvEAnioAdeudo, ppvDMontoRenta, ppvSFechaPago);
                    lALc.add(objCAdeudos);
                }
            }
            return lALc;
        } catch (Exception lEXe)
        {
            CMensajes.cmetpbMsj(null, "Error en la base de datos con el dato: " + lEXe.getMessage() + " .");
            return null;
        }
    }

    public static ArrayList<CAdeudos> cmetpbALConsultaAdeudos(Connection lCNcon, String lStabla, String lSid, String lSs)
    {
        ArrayList<CAdeudos> lALc = cmetpbALCargaAdeudos(cmetpbALConsult(lCNcon, lStabla, lSid, lSs));
        return lALc;
    }
    public static ArrayList<CUsuariosDE> cmetpbALCargaUsuarios(ArrayList<Object> lALusuarios)
    {
        ArrayList<CUsuariosDE> lALc = new ArrayList<>(); 
        try
        {
            for (int lEi = 0; lEi < lALusuarios.size(); lEi += 49)
            {
                int lEid =Integer.parseInt((lALusuarios.get(lEi).toString().trim()));
                if (lEid != 0 && lEid > 0)
                {
                    int lEidUsuario = lEid;
                    char[] lCtipoUsuarioAux=lALusuarios.get(lEi+1).toString().trim().toCharArray();
                    String lSnombreDeUsuario=(String) lALusuarios.get(lEi+2);
                    String lScontrasenia=(String) lALusuarios.get(lEi+3);
                    int lEStatus=Integer.parseInt(((String) lALusuarios.get(lEi + 4)).trim());
                    String lSfechaIngreso=(String) lALusuarios.get(lEi+5);
                    int lEexpediente=Integer.parseInt(((String) lALusuarios.get(lEi + 6)).trim());
                    String lSnombre=(String) lALusuarios.get(lEi+7);
                    String lSapellidoPaterno=(String) lALusuarios.get(lEi+8);
                    String lSapellidoMaterno=(String) lALusuarios.get(lEi+9);
                    char[] lCsexoAux=lALusuarios.get(lEi+10).toString().trim().toCharArray();
                    String lScalle=(String) lALusuarios.get(lEi+11);  
                    int lEnumero=Integer.parseInt(((String) lALusuarios.get(lEi + 12)).trim());
                    String lScolonia=(String) lALusuarios.get(lEi+13);
                    String lSciudad=(String) lALusuarios.get(lEi+14);
                    String lSestado=(String) lALusuarios.get(lEi+15);
                    int lEcp=Integer.parseInt(((String) lALusuarios.get(lEi + 16)).trim());
                    String lStelCelular=(String) lALusuarios.get(lEi+17);
                    String lStelCasa=(String) lALusuarios.get(lEi+18);
                    String lStelOficina=(String) lALusuarios.get(lEi+19);
                    String lSemail=(String) lALusuarios.get(lEi+20);
                    String lSfechaNacimiento=(String) lALusuarios.get(lEi+21);
                    String lSlugarNacimiento=(String) lALusuarios.get(lEi+22);
                    char[] lCestadoCivilAux= lALusuarios.get(lEi+23).toString().trim().toCharArray();
                    String lSpasaporteSN=(String) lALusuarios.get(lEi+24);
                    String lSvigenciaPasaporte=(String) lALusuarios.get(lEi+25);
                    int lEnoCartillaMilitar=Integer.parseInt(((String) lALusuarios.get(lEi + 26)).trim());
                    double lEestatura= Double.parseDouble(((String) lALusuarios.get(lEi + 27)).trim());
                    String lSresponsable=(String) lALusuarios.get(lEi+28);
                    String lStelResponsable=(String) lALusuarios.get(lEi+29);
                    String lStipoSanguineo=(String) lALusuarios.get(lEi+30);
                    String lSalergias=(String) lALusuarios.get(lEi+31);
                    String lSenfermedades=(String) lALusuarios.get(lEi+32);
                    String lSnombreMedicoCabecera=(String) lALusuarios.get(lEi+33);
                    String lStelMedicoDeCabecera=(String) lALusuarios.get(lEi+34);
                    String lSmedicacionDiarrea=(String) lALusuarios.get(lEi+35);
                    String lSmedicacionDolorDeCabeza=(String) lALusuarios.get(lEi+36);
                    String lSmedicacionDolorDeEstomago=(String) lALusuarios.get(lEi+37);
                    String lSmedicacionDolorMuscular=(String) lALusuarios.get(lEi+38);
                    String lSmedicacionGripa=(String) lALusuarios.get(lEi+39);
                    String lSmedicacionOtro=(String) lALusuarios.get(lEi+40);
                    String lSformaDeEnterarse=(String) lALusuarios.get(lEi+41);
                    String lSbaila=(String) lALusuarios.get(lEi+42);
                    String lSbailes=(String) lALusuarios.get(lEi+43);
                    String lSanteriorBallet=(String) lALusuarios.get(lEi+44);
                    String lStiempoQueBailo=(String) lALusuarios.get(lEi+45);
                    int lEpreguntaSecreta=Integer.parseInt(((String) lALusuarios.get(lEi + 46)).trim());
                    String lSrespuestaSecreta=(String) lALusuarios.get(lEi+47);
                    String lScomentario=(String) lALusuarios.get(lEi+48);
                    
                    char lCtipoUsuario = lCtipoUsuarioAux[0];
                    char lCsexo = lCsexoAux[0];
                    char lCestadoCivil = lCestadoCivilAux[0];
                    
                    CUsuariosDE objCUsuariosDE1 = new CUsuariosDE(lEidUsuario,lCtipoUsuario,lSnombreDeUsuario, lScontrasenia,lEStatus,lSfechaIngreso,lEexpediente,lSnombre,
                    lSapellidoPaterno,lSapellidoMaterno,lCsexo,lScalle,lEnumero,lScolonia,lSciudad,lSestado,lEcp,lStelCelular,lStelCasa,lStelOficina,lSemail,
                    lSfechaNacimiento,lSlugarNacimiento,lCestadoCivil,lSpasaporteSN,lSvigenciaPasaporte,lEnoCartillaMilitar,lEestatura,lSresponsable,lStelResponsable,
                    lStipoSanguineo,lSalergias, lSenfermedades,lSnombreMedicoCabecera,lStelMedicoDeCabecera,lSmedicacionDiarrea,lSmedicacionDolorDeCabeza,
                    lSmedicacionDolorDeEstomago,lSmedicacionDolorMuscular,lSmedicacionGripa,lSmedicacionOtro,lSformaDeEnterarse,lSbaila,lSbailes,lSanteriorBallet,
                    lStiempoQueBailo,lEpreguntaSecreta,lSrespuestaSecreta,lScomentario);
                    
                    lALc.add(objCUsuariosDE1);
                }
            }
            return lALc;
        } catch (Exception lEXe)
        {
            CMensajes.cmetpbMsj(null,"Error en la base de datos con el dato: " + lEXe.getMessage()+ " .");
            return null;
        }
    }
        
    /**
     * cmetpbSConsultaUsuarios: Permite hacer una consulta en la información de usuarios (del arraylist).
     * 
     * @param lALobj -arreglo de objetos que contiene la información
     * @return lSs -retorna un dato tipo string
     */
    public static String cmetpbSConsultaUsuarios(ArrayList<CUsuariosDE> lALobj)
    {
        if (lALobj != null)
        {
            String lSs="";
            for (int lEi = 0; lEi < lALobj.size(); lEi++)
            {
                lSs+=lALobj.get(lEi).metpbResp();
            }
            return lSs;
        } else
        {
            return "no hay datos encontrados";
        }
    }
    
    /**
     * cmetpbALCargaVestuarioUsuario: Permite hacer una carga de la iformación del vestuario de usuarios.
     * 
     * @param lALvestuarioU -arreglo de objetos que contiene la información de la tabla vestuarioUsuario.
     * @return lALc -retorna arraylist
     */
    public static ArrayList<CVestuarioUsuario> cmetpbALCargaVestuarioUsuario(ArrayList<Object> lALvestuarioU)
    {
        try
        {
            ArrayList<CVestuarioUsuario> lALc = new ArrayList<>();
            for (int lEi = 0; lEi < lALvestuarioU.size(); lEi += 3)
            {
                int lEid =Integer.parseInt((lALvestuarioU.get(lEi).toString().trim()));
                if (lEid != 0 && lEid > 0)
                {
                    int lEidVU = Integer.parseInt(((String) lALvestuarioU.get(lEi)).trim());
                    int lEidU =Integer.parseInt(((String) lALvestuarioU.get(lEi+1)).trim());
                    int lEidI =Integer.parseInt(((String) lALvestuarioU.get(lEi+2)).trim());
                    
                    CVestuarioUsuario objCVestuarioUsuario1 = new CVestuarioUsuario(lEidVU, lEidU, lEidI);
                    lALc.add(objCVestuarioUsuario1);
                }
            }
            return lALc;
        }  catch (Exception lEXe)
        {
            CMensajes.cmetpbMsj(null,"Error en la base de datos con el dato: " + lEXe.getMessage()+ " .");
            return null;
        }
    }
    
    /**
     * cmetpbALConsultaU: Permite hacer una consulta de un dato específico con todos los campos de la tabla usuarios.
     * 
     * @param lCNcon para la conexión a la base de datos
     * @param lStabla es la tabla a la que se realiza la consulta
     * @param lSid indica el parametro del registro a consultar
     * @param lSs indica el número serial o dato específico que lleva el registro a consultar
     * @return lALc -retorna un arraylist con la informacion de la tabla usuarios.
     */
    public static ArrayList <CUsuariosDE> cmetpbALConsultaU(Connection lCNcon,  String lStabla, String lSid, String lSs)
    {
            
            ArrayList<CUsuariosDE> lALc=cmetpbALCargaUsuarios(cmetpbALConsult(lCNcon,lStabla,lSid,lSs));
            return lALc;
    }
    
    /**
     * cmetpbALConsultaU: conecta con la base de datos y obtiene la información de la tabla usuarios
     * 
     * @param lCNcon permite la conexión a la base de datos
     * @param lStabla indica la tabla a la que se realiza la consulta
     * @param lSid indica el parametro del registro a consultar
     * @param lSs indica el número serial o dato específico que lleva el registro a consultar
     * @return lALcad -retorna un arraylist con la informacion de la tabla usuarios.
     */
    public static ArrayList <Object> cmetpbALConsult(Connection lCNcon,  String lStabla, String lSid, String lSs)
    {
            int lEx=0;
            CQuerys objCQuerys1 = new CQuerys();
            ArrayList<Object> lALcad;
            try
            {
                lEx= Integer.parseInt(lSs);
                lALcad =  objCQuerys1.metpbALSeleccion(lCNcon, "*", lStabla, lSid+ "=" + String.valueOf(lEx));
            }catch(Exception lEXe)
            {
                 lALcad =  objCQuerys1.metpbALSeleccion(lCNcon, "*", lStabla, "");
            }
            return lALcad;
    }
    
    
    /**
     * cmetpbArrayListConsulta
     * método que consulta tablas
     * 
     * @param lCNConeccion recibe la conección
     * @param lSTabla      recibe las tablas a utilizar
     * @param lSId         recibe id de la tabla
     * @param lSCadena     recibe el valor del id
     * @return retorna     los valores de un consulta
     */
    public static ArrayList<Object> cmetpbArrayListConsulta(Connection lCNConeccion, String lSTabla, String lSId, String lSCadena)
    {
        int lEX = 0;
        CQuerys objQuerys = new CQuerys();
        ArrayList<Object> lALCadena;
        try
        {
            lEX = Integer.parseInt(lSCadena);
            lALCadena = objQuerys.metpbALSeleccion(lCNConeccion, "*", lSTabla, lSId + "=" + String.valueOf(lEX));
        } catch (Exception ex)
        {
            lALCadena = objQuerys.metpbALSeleccion(lCNConeccion, "*", lSTabla, "");
        }

        return lALCadena;
    }
    
    
    /**
     * cmetpbConectaDB: conecta con la base de datos
     * 
     * @return null o mensaje de exito con acceso a la base de datos
     */
     public static Connection cmetpbConectaDB()
    {
        CConexion objCConexion1 = new CConexion();
        try
        {
            return objCConexion1.metpbCNconecta("localhost", "trajin", "root", "123456", 2);
                           
        } catch (SQLException lEXex)
        {
            return null;
        }
    }

     /**
     * cmetpbDesconectaDB: desconecta la base de datos
     * @param lCNcon indica la base de datos
     */
    public static void cmetpbDesconectaDB(Connection lCNcon)
    {
        CConexion objCConexion2 = new CConexion();
        objCConexion2.metpbDesconectar(lCNcon);
    }
    
     /**
     * cmetpbALCargaInventarioDesechadoDescripcion método que obtiene la carga de los inventarios desechos.
     * 
     * @param lAReg :arreglo de objetos
     * @return retorna lista de objetos de inventarios desechados
     */
    public static ArrayList<CInventarioDesechado> cmetpbALCargaInventarioDesechadoDescripcion(ArrayList<Object> lAReg)
    {
        try
        {
            ArrayList<CInventarioDesechado> objArrayListInventarioDesechado = new ArrayList<CInventarioDesechado>();
            for (int lEContador = 0; lEContador < lAReg.size(); lEContador += 8)
            {
                String lEId = (String) lAReg.get(lEContador).toString().trim();
                System.out.println("" + lEId);
                if (lEId != "" && lEId != "")
                {
                    int lEIdInventarioDesechado=Integer.parseInt(lAReg.get(lEContador).toString().trim());
                    String lSTipo = lAReg.get(lEContador + 1).toString().trim();
                    String lSMotivo = lAReg.get(lEContador + 2).toString().trim();
                    String lSNombre = lAReg.get(lEContador + 3).toString().trim();
                    String lSAPaterno = lAReg.get(lEContador + 4).toString().trim();
                    String lSAMaterno = lAReg.get(lEContador + 5).toString().trim();
                    int lEPiezas = Integer.parseInt(lAReg.get(lEContador + 6).toString().trim());
                    String lSDescripcion = lAReg.get(lEContador + 7).toString().trim();
                            
                    CInventarioDesechado objCInventarioDesechado = new CInventarioDesechado(lEIdInventarioDesechado , lSTipo , lSMotivo , lSNombre, lSAPaterno , lSAMaterno , lEPiezas , lSDescripcion);
                    objArrayListInventarioDesechado.add(objCInventarioDesechado);
                }
            }
            return objArrayListInventarioDesechado;
        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    
    
    // CARGAS DE VESTUARIOS E INVENTARIOS
    
    
    /**
     * cmetpbALCargaVestuarios
     * método que carga los atributos de la clase CVestuarios
     * 
     * @param lALReg recibe una lista de arreglo de tipo objeto
     * @return retorna arreglo de objetos del vestuario
     */
    public static ArrayList<CVestuarios> cmetpbALCargaVestuarios(ArrayList<Object> lALReg)
    {
        try
        {
            ArrayList<CVestuarios> objArrayListVestuarios = new ArrayList<CVestuarios>();
            for (int lEContador = 0 ; lEContador < lALReg.size() ; lEContador += 5)
            {
                String lSId = (String) lALReg.get(lEContador);
                if (lSId != "" && lSId != "")
                {
                    int lEIdVestuario=Integer.parseInt(lALReg.get(lEContador).toString().trim());
                    char lCTipo = lALReg.get(lEContador + 1).toString().charAt(1);
                    String lSDescripcion = (String) lALReg.get(lEContador + 2);
                    String lSColor = (String) lALReg.get(lEContador + 3);
                    char lCSexo = lALReg.get(lEContador + 4).toString().charAt(1);
                    CVestuarios objCVestuarios = new CVestuarios(lEIdVestuario,lCTipo, lSDescripcion, lSColor, lCSexo);
                    objArrayListVestuarios.add(objCVestuarios);

                }
            }
            return objArrayListVestuarios;
        } catch (Exception lEXe)
        {
            System.out.println(lEXe.getMessage());
            return null;
        }
    }

    /**
     * cmetpbALCargaInventarios
     * método que carga los atributos de la clase CInventarios
     * 
     * @param lALReg recibe una lista de arreglo de tipo objeto
     * @return  retorna arreglo de objetos del inventarios
     */
    public static ArrayList<CInventarios> cmetpbALCargaInventarios(ArrayList<Object> lALReg)
    {
        try
        {
            ArrayList<CInventarios> objArrayListInventarios = new ArrayList<CInventarios>();
            for (int lEContador = 0 ; lEContador < lALReg.size() ; lEContador += 7)
            {
                String lSId = (String) lALReg.get(lEContador);
                System.out.println("" + lSId);
                if (lSId != "" && lSId != "")
                {
                    int lEIdInventario=Integer.parseInt(lALReg.get(lEContador).toString().trim());
                    int lEIdVestuario = Integer.parseInt(((String) lALReg.get(lEContador + 1)).trim());
                    int lECantidad = Integer.parseInt((lALReg.get(lEContador + 2).toString()).trim());
                    int lEPiezasDanadas = Integer.parseInt((lALReg.get(lEContador + 3).toString()).trim());
                    int lEPiezasAsignadas = Integer.parseInt((lALReg.get(lEContador + 4).toString()).trim());
                    String lEClave = (String) lALReg.get(lEContador + 5);
                    int lEExistencia =Integer.parseInt(lALReg.get(lEContador+6).toString().trim());
                    CInventarios objCInventarios = new CInventarios(lEIdInventario,lEIdVestuario, lECantidad, lEPiezasDanadas, lEPiezasAsignadas, lEClave,lEExistencia);
                    objArrayListInventarios.add(objCInventarios);

                }
            }
            return objArrayListInventarios;
        } catch (Exception lEXe)
        {
            System.out.println(lEXe.getMessage());
            return null;
        }
    }

    /**
     * cmetpbALCargaVestuarioInvetario
     * método que carga los atributos de la clase CVestuarioInventarioTmp
     * 
     * @param lALreg recibe una lista de arreglo de tipo objeto
     * @return retorna arreglo de objetos del vestuarios e inventarios
     */
    public static ArrayList<CVestuarioInventarioTmp> cmetpbALCargaVestuarioInvetario(ArrayList<Object> lALreg)
    {
        try
        {
            ArrayList<CVestuarioInventarioTmp> objArrayListVestuarioInventario = new ArrayList<CVestuarioInventarioTmp>();
            if (lALreg.size() != 1)
            {
                for (int lEContador = 0 ; lEContador < lALreg.size() ; lEContador += 12)
                {
                    String lSIdV = (String) lALreg.get(lEContador);
                    String lSIdI = (String) lALreg.get(lEContador + 5);
                    if ((lSIdV != "" && lSIdV != "") || (lSIdI != "" && lSIdI != ""))
                    {
                        char lCTipo = lALreg.get(lEContador + 1).toString().charAt(1);
                        String lSDescripcion = (String) lALreg.get(lEContador + 2);
                        String lSColor = (String) lALreg.get(lEContador + 3);
                        char lCSexo = lALreg.get(lEContador + 4).toString().charAt(1);
                        int lEIdVestuario = Integer.parseInt(((String) lALreg.get(lEContador + 6)).trim());
                        int lECcantidad = Integer.parseInt((lALreg.get(lEContador + 7).toString()).trim());
                        int lEPiezasDanadas = Integer.parseInt((lALreg.get(lEContador + 8).toString()).trim());
                        int lEPiezasAsignadas = Integer.parseInt((lALreg.get(lEContador + 9).toString()).trim());
                        String lEClave = lALreg.get(lEContador + 10).toString();
                        int lEExistencia=Integer.parseInt(lALreg.get(lEContador+11).toString().trim());
                        CVestuarioInventarioTmp objCVestuarioInventarioTmp = new CVestuarioInventarioTmp(lCTipo, lSDescripcion, lSColor, lCSexo, lEIdVestuario, lECcantidad, lEPiezasDanadas, lEPiezasAsignadas, lEClave,lEExistencia);
                        objArrayListVestuarioInventario.add(objCVestuarioInventarioTmp);
                    }
                }
            } else
            {
                objArrayListVestuarioInventario = null;
            }
            return objArrayListVestuarioInventario;
        } catch (Exception lEXe)
        {
            System.out.println(lEXe.getMessage());
            return null;
        }
    }
    
 /**
  * cmetpbALCargaInventarioDesechado
  * método que carga los atributos de la clase CInventarioDesechado
  * 
  * @param  recibe una lista de arreglo de tipo objeto
  * @return retorna arreglo de objetos del inventario desechado
  */   
 public static ArrayList<CInventarioDesechado> cmetpbALCargaInventarioDesechado(ArrayList<Object> lALReg)
    {
        try
        {
            ArrayList<CInventarioDesechado> objArrayListInventarioDesechado = new ArrayList<CInventarioDesechado>();
            for (int lEContador = 0 ; lEContador < lALReg.size() ; lEContador += 5)
            {
                String lEId = (String) lALReg.get(lEContador);
                System.out.println("" + lEId);
                if (lEId != "" && lEId != "")
                {
                    int lEIdInventarioDesechado=Integer.parseInt(lALReg.get(lEContador).toString().trim());
                    int lEIdInventario = Integer.parseInt(((String) lALReg.get(lEContador + 1)).trim());
                    String lSTipo = (String) lALReg.get(lEContador + 2);
                    String lSMotivo = (String) lALReg.get(lEContador + 3);
                    int  lEIdUsuario = Integer.parseInt(lALReg.get(lEContador + 4).toString().trim());
                    CInventarioDesechado objCInventarioDesechado = new CInventarioDesechado(lEIdInventarioDesechado,lEIdInventario, lSTipo, lSMotivo,lEIdUsuario);
                    objArrayListInventarioDesechado.add(objCInventarioDesechado);
                }
            }
            return objArrayListInventarioDesechado;
        } catch (Exception lEXe)
        {
            System.out.println(lEXe.getMessage());
            return null;
        }
    }
 /**
     * cmetpbALCargaDatosBailarinEvento 
     * Método que ordena todos los datos del ArrayList reg
     *
     * @param lALReg trae todos los datos necesarios
     * @return ArrayList de clase CBailarinTmp para manipular las propiedades del objeto especificado
     */
    public static ArrayList<CUsuarioTmp> cmetpbALCargaDatosUsuario(ArrayList<Object> lALReg)
    {
        try
        {
            ArrayList<CUsuarioTmp> objArrayList = new ArrayList<>();
            for (int lEi = 0 ; lEi < lALReg.size() ; lEi += 4)
            {
                String lSId = lALReg.get(lEi).toString().trim();
                if (lSId != "" && lSId != " ")
                {
                    int lEIdUsuario = Integer.parseInt(lSId);
                    String lSNombre = lALReg.get(lEi + 1).toString().trim();
                    String lSApellidoPat = lALReg.get(lEi + 2).toString().trim();
                    String lSApellidoMat = lALReg.get(lEi + 3).toString().trim();
                    CUsuarioTmp objUsuarioTmp = new CUsuarioTmp(lEIdUsuario, lSNombre , lSApellidoPat , lSApellidoMat);
                    objArrayList.add(objUsuarioTmp );
                }
            }

            return objArrayList;
        } catch (Exception lEXe)
        {
            System.out.println(lEXe.getMessage());
            return null;
        }
    }
    
    //CARGAS DE DAÑOS
    
      /**
     * cmetpbALCargaDatosBailarinEvento 
     * Método que ordena todos los datos del ArrayList reg
     *
     * @param lALReg trae todos los datos necesarios
     * @return ArrayList de clase CBailarinTmp para manipular las propiedades del objeto especificado
     */
    public static ArrayList<CBailarinTmp> cmetpbALCargaDatosBailarinEvento(ArrayList<Object> lALReg)
    {
        try
        {
            ArrayList<CBailarinTmp> objArrayList = new ArrayList<>();
            for (int lEI = 0 ; lEI < lALReg.size() ; lEI += 5)
            {
                String lSId = lALReg.get(lEI).toString().trim();
                if (lSId != "" && lSId != " ")
                {
                    int lEIdUsuario = Integer.parseInt(lSId);
                    String lSNombre = lALReg.get(lEI + 1).toString().trim();
                    String lSApellidoPat = lALReg.get(lEI + 2).toString().trim();
                    String lSApellidoMat = lALReg.get(lEI + 3).toString().trim();
                    String lSFecha = lALReg.get(lEI + 4).toString().trim();
                    CBailarinTmp objBailarinTmp = new CBailarinTmp(lEIdUsuario , lSNombre , lSApellidoPat , lSApellidoMat , lSFecha);
                    objArrayList.add(objBailarinTmp);
                }
            }

            return objArrayList;
        } catch (Exception lEXE)
        {
            System.out.println(lEXE.getMessage());
            return null;
        }
    }

    /**
     * cmetpbALCargaDanios
     * Método que ordena los valores del ArrayList de daños
     *
     * @param lALReg es el ArrayList que trae todos los valores dados de una consulta
     * @return ArraList de CDanios para obtener los datos de forma más precisa
     *
     */
    public static ArrayList<CDanios> cmetpbALCargaDanios(ArrayList<Object> lALReg)
    {
        try
        {
            ArrayList<CDanios> objDanios = new ArrayList<>();
            for (int lEI = 0 ; lEI < lALReg.size() ; lEI += 8)
            {
                String lSId = lALReg.get(lEI).toString().trim();
                if (lSId != "" && lSId != " ")
                {
                    int lEIdDanio = Integer.parseInt(lSId);
                    double lDMonto = Double.parseDouble(lALReg.get(lEI + 1).toString().trim());
                    char lCStatus = lALReg.get(lEI + 2).toString().trim().charAt(0);
                    int lEIdUsuario = Integer.parseInt(lALReg.get(lEI + 3).toString().trim());
                    int lEMesesDanio = Integer.parseInt(lALReg.get(lEI + 4).toString().trim());
                    int lEIdAsignaVestuario = Integer.parseInt(lALReg.get(lEI + 5).toString().trim());
                    String lSFechaPago = lALReg.get(lEI + 6).toString().trim();
                    String lSFechaRegistro = lALReg.get(lEI + 7).toString().trim();
                    CDanios objCDanios = new CDanios(lEIdDanio, lSFechaPago, lSFechaRegistro, lEIdUsuario, lEIdAsignaVestuario, lEMesesDanio, lCStatus, lDMonto);
                    objDanios.add(objCDanios);
                }
            }

            return objDanios;
        } catch (Exception lEXE)
        {
            System.out.println(lEXE.getMessage());
            return null;
        }
    }

    /**
     * cmetpbALCargaDatosDanios 
     * Método que ordena todos los campos a partir de un ArrayList de tipo Object
     *
     * @param lALReg Es el parámetro del cual se retorna una consulta normal que se hace a través del método Seleccion() de la clase Querys
     * @return ArrayList de tipo CDanios1 para poder manipular los datos de una mejor manera accediando a sus propiedades
     */
    public static ArrayList<CDanios1> cmetpbALCargaDatosDanios(ArrayList<Object> lALReg)
    {
        try
        {
            ArrayList<CDanios1> objArrayList = new ArrayList<>();
            for (int lEI = 0 ; lEI < lALReg.size() ; lEI += 9)
            {
                String lSId = lALReg.get(lEI).toString().trim();
                if (lSId != "" && lSId != " ")
                {
                    int lEIdDanio = Integer.parseInt(lSId);
                    String lSNombre = lALReg.get(lEI + 1).toString().trim();
                    String lSAPaterno = lALReg.get(lEI + 2).toString().trim();
                    String lSAMaterno = lALReg.get(lEI + 3).toString().trim();
                    String lSPrenda = lALReg.get(lEI + 4).toString().trim();
                    char lCStatus = lALReg.get(lEI + 5).toString().trim().charAt(0);
                    double lDMonto = Double.parseDouble(lALReg.get(lEI + 6).toString().trim());
                    String lSFechaevento = lALReg.get(lEI + 7).toString().trim();
                    String lSFechadepago = lALReg.get(lEI + 8).toString().trim();
                    CDanios1 objCDanios1 = new CDanios1(lEIdDanio, lSNombre, lSAPaterno, lSAMaterno, lSPrenda, lCStatus, lDMonto, lSFechaevento, lSFechadepago);
                    objArrayList.add(objCDanios1);
                }
            }
            return objArrayList;
        } catch (Exception lEXE)
        {
            System.out.println(lEXE.getMessage());
            return null;
        }
    }

// CARGAS RENTAS
    
    
    /**
     * cmetpbALCargaRentas: coloca la informacion del arraylist de rentas en campos establecidos
     * 
     * @param lALrentas -arreglo de objetos que contiene la información
     * @return lALc -retorna un array list de datos para manipular
     */
    public static ArrayList<CRentasParametros> cmetpbALCargaRentas(ArrayList<Object> lALrentas)
    { 
        try
        {
            ArrayList<CRentasParametros> lALc = new ArrayList<>();
            for (int i = 0; i < lALrentas.size(); i += 5)
            {
                int pvEId =Integer.parseInt((lALrentas.get(i).toString().trim() ));
                System.out.println("entré");
                
                if (pvEId != 0 && pvEId > 0)
                {
                    System.out.println("entré al if");
                    int pvERentaParametro = pvEId;
                    System.out.println("pvERentaParametro:" + pvERentaParametro);
                    
                    String pvDRentaAnterior = ((String) lALrentas.get(i + 1)).trim();
                    System.out.println("pvDRentaAnterior:" + pvDRentaAnterior);
                    
                    String pvSFechaRentaAnterior = (String) lALrentas.get(i + 2);
                    System.out.println("pvSFechaRentaAnterior:" + pvSFechaRentaAnterior);
                    
                    String pvDRentaActual = ((String) lALrentas.get(i + 3)).trim();
                    System.out.println("pvDRentaActual:" + pvDRentaActual);
                    
                    String pvSFechaRentaActual = (String) lALrentas.get(i + 4);
                    System.out.println("pvSFechaRentaActual:" + pvSFechaRentaActual);
                    
                    CRentasParametros objCRentasParametros = new CRentasParametros(pvERentaParametro,pvDRentaAnterior,pvSFechaRentaAnterior,  pvDRentaActual, pvSFechaRentaActual);
                    lALc.add(objCRentasParametros);
                }
            }
            return lALc;
        } catch (Exception lEXe)
        {
            CMensajes.cmetpbMsj(null,"Error en la base de datos con el dato: " + lEXe.getMessage()+ " .");
            return null;
        }
       
    }
        
    /**
     * cmetpbSConsultaRentas: Permite hacer una consulta en la información de usuarios (del arraylist).
     * 
     * @param lALobj -arreglo de objetos que contiene la información
     * @return lSs -retorna un dato tipo string
     */
    public static String cmetpbSConsultaRentas(ArrayList<CRentasParametros> lALobj)
    {
        if (lALobj != null)
        {
            String lSs="";
            for (int lEi = 0; lEi < lALobj.size(); lEi++)
            {
                lSs+=lALobj.get(lEi).metpbResp();
            }
            return lSs;
        } else
        {
            return "no hay datos encontrados";
        }
    }
  
    /**
     * cmetpbALConsultaR: Permite hacer una consulta de un dato específico con todos los campos de la tabla rentasparametros.
     * 
     * @param lCNcon para la conexión a la base de datos
     * @param lStabla es la tabla a la que se realiza la consulta
     * @param lSid indica el parametro del registro a consultar
     * @param lSs indica el número serial o dato específico que lleva el registro a consultar
     * @return lALc -retorna un arraylist con la informacion de la tabla usuarios.
     */
    public static ArrayList <CRentasParametros> cmetpbALConsultaR(Connection lCNcon,  String lStabla, String lSid, String lSs)
    {
            
            ArrayList<CRentasParametros> lALc=cmetpbALCargaRentas(cmetpbALConsult(lCNcon,lStabla,lSid,lSs));
            return lALc;
    }
    
    //CARGA CUADROS
    /**
     * cmetpbALCargaCuadros: coloca la informacion del arraylist de cuadros en campos establecidos
     * 
     * @param lALCuadros -arreglo de objetos que contiene la información
     * @return lALDatosCuadros -retorna un Array List de datos para manipular
     */
    public static ArrayList<CCuadros> cmetpbCargaCuadros(ArrayList<Object> lALCuadros) {
        try {
            ArrayList<CCuadros> lALDatosCuadros = new ArrayList<>();
            for (int i = 0; i < lALCuadros.size(); i += 2) {
                String lSNombre = (String) lALCuadros.get(i + 1);
                if (lSNombre != "" && lSNombre != " ") {
                    int lEidCuadro = Integer.parseInt(((String) lALCuadros.get(i)).trim());
                    /*System.out.println("lEid" + lEid);
                    String lCnombre = s;*/
                    CCuadros objCCuadros2 = new CCuadros(lEidCuadro, lSNombre);
                    lALDatosCuadros.add(objCCuadros2);

                }
            }
            return lALDatosCuadros;
        } catch (Exception lEXe) {
            System.out.println(lEXe.getMessage());
            return null;
        }
    }

    /**
     * cmetpbALCargaBailes: coloca la informacion del arraylist de bailes en campos establecidos
     * 
     * @param lALBailes -arreglo de objetos que contiene la información
     * @return lALDatosBailes -retorna un Array List de datos para manipular
     */
    public static ArrayList<CBailes> cmetpbCargaBailes(ArrayList<Object> lALBailes) {
        try {
            ArrayList<CBailes> lALDatosBailes = new ArrayList<>();
            for (int i = 0; i < lALBailes.size(); i += 5) {
                String lSNombre = ((String) lALBailes.get(i + 1));
                if (lSNombre != "" && lSNombre != " ") {
                    int lEidBailes = Integer.parseInt(((String) lALBailes.get(i)).trim());
                    //String lSNombre = ((String) lALBailes.get(i + 1));
                    String lSDuracion = ((String) lALBailes.get(i + 2));
                    int lEEstatus = Integer.parseInt(((String) lALBailes.get(i + 3)).trim());
                    int lEidRegiones = Integer.parseInt(((String) lALBailes.get(i + 4)).trim());

                    CBailes objCBailes2 = new CBailes(lEidBailes, lSNombre, lSDuracion, lEEstatus, lEidRegiones);
                    lALDatosBailes.add(objCBailes2);
                }
            }
            return lALDatosBailes;
        } catch (Exception lEXe) {
            System.out.println(lEXe.getMessage());
            return null;
        }
    }

    /**
     * cmetpbALCargaRegiones: coloca la informacion del arraylist de regiones en campos establecidos
     * 
     * @param lALRegiones -arreglo de objetos que contiene la información
     * @return lALDatosRegiones -retorna un Array List de datos para manipular
     */
    public static ArrayList<CRegiones> cmetpbCargaRegiones(ArrayList<Object> lALRegiones) {
        try {
            ArrayList<CRegiones> lALDatosRegiones = new ArrayList<>();
            for (int i = 0; i < lALRegiones.size(); i += 5) {
                String lSNombre = ((String) lALRegiones.get(i + 1));
                if (lSNombre != "" && lSNombre != " ") {
                    int lEidRegion = Integer.parseInt(((String) lALRegiones.get(i)).trim());
                    //String lSNombre =((String) lALRegiones.get(i+1));
                    String lSImagen = ((String) lALRegiones.get(i + 2));
                    int lEEstatus = Integer.parseInt(((String) lALRegiones.get(i + 3)).trim());
                    int lEidCuadros = Integer.parseInt(((String) lALRegiones.get(i + 4)).trim());

                    CRegiones objCregiones2 = new CRegiones(lEidRegion, lSNombre, lSImagen, lEEstatus, lEidCuadros);
                    lALDatosRegiones.add(objCregiones2);
                }
            }
            return lALDatosRegiones;
        } catch (Exception lEXe) {
            System.out.println(lEXe.getMessage());
            return null;
        }
    } 
   
    
    /**
     * cmetpbSConsultaCuadros: Permite hacer una consulta en la información de usuarios (del arraylist).
     * 
     * @param lALobj -arreglo de objetos que contiene la información
     * @return lSs -retorna un dato tipo string
     */
    public static String cmetpbSConsultaCuadros(ArrayList<CCuadros> lALobj)
    {
        if (lALobj != null)
        {
            String lSs="";
            for (int lEi = 0; lEi < lALobj.size(); lEi++)
            {
                lSs+=lALobj.get(lEi).desp();
            }
            return lSs;
        } else
        {
            return "no hay datos encontrados";
        }
    }
}
