/*Nombre de clase		: CQuerys
*Descripción de la clase	: Clase con los métodos para hacer consultas en base de datos
*Fecha	de creación		: 01/05/2016
*Elaboró			: Mauro S. S.
*Fecha	de Liberación		: 01/05/2016
*Autorizó			: Mauro Sánchez Sánchez
*Fecha Mantenimiento		: 05/06/2016
*Folio mantenimiento		: 02
*Descripción del mantto.	: Se realizó la actualización de métodos y transformacion de código con calidad.
*Responsable			: Jatziry Barrera Hinojosa
*Revisor 			: Diego Enrique Sánchez Ordoñez
*/
package bfx.controladores;
/**
 * Busqueda y seleccion en base de datos.
 * @author: Techno Engineers
 * @versión: 3.0 
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CQuerys
{
    /**
     * metpbSInsertar: Inserta un registro en una tabla de mysql
     *
     * @param lCNcon se requiere un objeto Connection
     * @param lStabla es el nombre de la tabla
     * @param lScolumnas son las columnas que se van a modificar
     * @param lSvalues un string con los valores a insertar separados por comas
     * @return una cadena de tipo string o null
     */
    public String metpbSInsertar(Connection lCNcon, String lStabla, String lScolumnas, String lSvalues)
    {
        try
        {
            Statement lSTstmt = lCNcon.createStatement();
            String lSmyquery = "insert into " + lStabla + " (" + lScolumnas + ")" + " values(" + lSvalues + ");";
            System.out.println(lSmyquery);
            lSTstmt.executeUpdate(lSmyquery);
            return null;
        } catch (Exception lEXe)
        {
            return "Error al intentar ejecutar la alta..." + lEXe.getMessage();
        }
    }

    /**
     * metpbSInsertar: Inserta un registro en una tabla de oracle o access
     *
     * @param lCNcon se requiere un objeto Connection
     * @param lStabla es el nombre de la tabla
     * @param lSvalues un string con los valores a insertar separados por comas
     * @return una cadena de tipo string o null
     */
    public String metpbSInsertar(Connection lCNcon, String lStabla, String lSvalues)
    {
        try
        {
            Statement lSTstmt = lCNcon.createStatement();
            String lSmyquery = "insert into " + lStabla + " values(" + lSvalues + ");";
            System.out.println(lSmyquery);
            lSTstmt.executeUpdate(lSmyquery);
            return null;
        } catch (Exception lEXe)
        {
            return "no se pudo realizar la alta..." + lEXe.getMessage();
            
        }
    }

    /**
     * metpbSDelete: Elimina un registro de una tabla de mySQL
     *
     * @param lCNcon se requiere un obejto Connection
     * @param lStabla es el nombre de la tabla
     * @param lScampo
     * @param lScondicion mediante la que se va a efectuar el Delete
     * @return una cadena de tipo string o null
     */
    public String  metpbSDelete(Connection lCNcon, String lStabla, String lScampo, String lScondicion)
    {
        try
        {
            Statement lSTstmt = lCNcon.createStatement();
            String lSmyquery = "delete from " + lStabla + " where " + lScampo + "=" + lScondicion;
            System.out.println(lSmyquery);
            lSTstmt.executeUpdate(lSmyquery);
            return null;
        } catch (Exception lEXe)
        {
            return "No se pudo eliminar el registro..."+ lEXe.getMessage();
        }

    }

    /**
     * metpbSDelete: Elimina todos los registros de una tabla
     *
     * @param lCNcon se requiere un obejto Connection
     * @param lStabla es el nombre de la tabla
     * @return una cadena de tipo string o null
     */
    public String metpbSDelete(Connection lCNcon, String lStabla)
    {
        try
        {
            Statement lSTstmt = lCNcon.createStatement();
            String lSmyquery = "delete from " + lStabla;
            System.out.println(lSmyquery);
            lSTstmt.executeUpdate(lSmyquery);
            return null;
        } catch (Exception lEXe)
        {
            return "No se pudo eliminar el registro..."+ lEXe.getMessage();
        }
    }

    /**
     * metpbSModificar: método para modificar un registro
     *
     * @param lCNcon -se requiere un objeto Connection
     * @param lStabla -es el nombre de la tabla
     * @param lScolumnas -es la columnas a modificar
     * @param lSnvalores -es el valor a modificar
     * @param lScondicion -es la condicion de los datos a modificar
     * @return una cadena de tipo string o null
     */
    public String  metpbSModificar(Connection lCNcon, String lStabla, String lScolumnas, String lSnvalores, String lScondicion)
    {
        ArrayList lALcol, lALnval = new ArrayList();
        lALcol = metpbALSepararCadena(lScolumnas);
        lALnval = metpbALSepararCadena(lSnvalores);
        String lSvamodificar = "";
        if (lALcol.size() == lALnval.size())
        {
            for (int lEi = 0; lEi < lALcol.size() - 1; lEi++)
            {
                lSvamodificar += String.valueOf(lALcol.get(lEi)) + " = " + String.valueOf(lALnval.get(lEi)) + " , ";
            }
            lSvamodificar += String.valueOf(lALcol.get(lALcol.size() - 1)) + " = " + String.valueOf(lALnval.get(lALcol.size() - 1));
            try
            {
                Statement lSTstmt = lCNcon.createStatement();
                String lSmyquery = " update " + lStabla + " set " + lSvamodificar + " where " + lScondicion;
                System.out.println(lSmyquery); //impresion de prueba
                lSTstmt.executeUpdate(lSmyquery);
            } catch (Exception lEXe)
            {
                return "No se pudo concretar el proceso, verifique porfavor..." + lEXe.getMessage();
            }
            return null;
        } else
        {
            return "EL NUMERO DE VALORES Y DE COLUMNAS A MODIFICAR NO COINCIDEN";
        }
    }

    /**
     * metpbALSeleccion: método para seleccionar informacion de la base de datos
     * 
     * @param lCNcon parametro que se recibe con la conexion a la base de lALdatos
     * @param lScampos refiere a todos los campos de la tabla donde desea consultar datos debe ser campo llave
     * @param lStabla nombre de la tabla a la que se desea conectar
     * @param lScondicion dato que asocie al campo llave a buscar
     * @return  lista de objetos tipo Object en forma de cadenas
     */
    public ArrayList<Object> metpbALSeleccion(Connection lCNcon, String lScampos, String lStabla, String lScondicion)
    {

        ArrayList<Object> lALreg = new ArrayList();
        String lScond = "";
        if (!lScondicion.equals(""))
        {
            lScond = " where " + lScondicion;
        }
        try
        {
            Statement lSTstmt = lCNcon.createStatement();
            String lSmyquery = " select " + lScampos + " from " + lStabla + lScond;
            System.out.println(lSmyquery); //impresion de pureba
            ResultSet lRrs = lSTstmt.executeQuery(lSmyquery);
            
            while (lRrs.next())
            {
                for (int lEi = 1; lEi < (lRrs.getMetaData().getColumnCount()) + 1; lEi++)
                {
                    lALreg.add(lRrs.getObject(lEi));
                }
            }
            
            String lScadena = lALreg.toString();
            lScadena = lScadena.substring(1);
            lScadena = lScadena.replace("]", " ");
            lALreg=metpbALSepararCadena(lScadena);
        } catch (Exception lEXe)
        {
             System.out.println("Exception");
        }
        return lALreg;
    }

     /**
     * metpbALSepararCadena: separa caracteres de una cadena 
     * 
     * @param lScadena parametro con la cadena que se separará
     * @return  lista de caracteres de la cadena separada
     */
    public ArrayList metpbALSepararCadena(String lScadena)
    {
        ArrayList lALdatos = new ArrayList();
        String lSpalabra = "";
        StringTokenizer lSTtokenizer = new StringTokenizer(lScadena, ",");
        while (lSTtokenizer.hasMoreTokens())
        {
            lSpalabra = lSTtokenizer.nextToken();
            lALdatos.add(lSpalabra);
        }
        System.out.println(lALdatos.toString());
        return lALdatos;

    }
    
    /**
     * metpbStruncate: hace la consulta con el truncate en base de datos
     * 
     * @param lCcon parametro que conecta a la base de datos
     * @param lStabla nombre de la tabla de la base de datos
     * @param lScond condicion para hacer el truncate
     * @return una cadena de tipo string o null
     */
    public String metpbStruncate(Connection lCcon, String lStabla,  String lScond)
    {
        try
        {
            Statement lSTstmt = lCcon.createStatement();
            String lSmyquery = "truncate " + lStabla +" "+ lScond + ";";
            System.out.println(lSmyquery);
            lSTstmt.executeUpdate(lSmyquery);
            return null;
        } catch (Exception lEXe)
        {
            return "Error al intentar ejecutar alter..." + lEXe.getMessage();
        }
    }
    
    public String  metpbSDeleteM(Connection lCNcon, String lSCampos,String lStablas, String lScondicion)
    {
        try
        {
            Statement lSTstmt = lCNcon.createStatement();
            String lSmyquery = "delete "+lSCampos+" from " + lStablas + " where " + lScondicion;
            System.out.println(lSmyquery);
            lSTstmt.executeUpdate(lSmyquery);
            return null;
        } catch (Exception lEXe)
        {
            return "No se pudo eliminar el registro..."+ lEXe.getMessage();
        }

    }
}
