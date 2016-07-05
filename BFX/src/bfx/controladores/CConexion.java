/*Nombre de clase		: CConexion
*Descripción de la clase	: Es la clase que determina el metodo de conexion a la base de datos y las especificaciones de la misma.
*Fecha	de creación		: 01/05/2016
*Elaboró			: Mauro S. S.
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
 * Métodos de conexión a la base de datos.
 * @author: Techno Engineers
 * @versión: 3.0 
 */
import java.sql.*;
import javax.swing.JFrame;

public class CConexion
{
    public Connection pbCNcon = null;
    
    /**
     * metpbCNconecta: conecta con una base de datos de oracle o mysql
     * 
     * @param lShost -Nombre del servidor o la dirección ip
     * @param lSinstancia -Es el servicio de escucha de oracle (SID)
     * @param lSusuario -Usuario de labase de datos
     * @param lSpass -Password del pSusuario en la base de datos
     * @param lEmanejador -para oracle (1) para mysql(2)
     * @return pbCNcon -retorna datos de conexión a la base de datos
     * @throws SQLException - Se ejecuta si ocurre un lSerror de conexión a la base de datos
     */
    public Connection metpbCNconecta(String lShost, String lSinstancia, String lSusuario, 
                              String lSpass, int lEmanejador) throws SQLException
    {
        String lSdriver = "";
        String lSerror = "";
        String lSurl = "";
        //ORACLE
        if (lEmanejador == 1 || lEmanejador == 2)
        {
            if (lEmanejador == 1)
            {
                lSdriver = "oracle.jdbc.driver.OracleDriver";
                lSerror = "No se pudo cargar el driver Oracle";
                lSurl = "jdbc:oracle:thin:@" + lShost + ":1521:" + lSinstancia;
            } //MYSQL
            else
            {
                if (lEmanejador == 2)
                {
                    lSdriver = "com.mysql.jdbc.Driver";
                    lSurl = "jdbc:mysql://" + lShost + "/" + lSinstancia;
                }
            }
            
            try
            {
                Class.forName(lSdriver).newInstance();
            } catch (Exception lEXe)
            {// Ocurrió un lSerror al registrar el lSdriver 
                System.out.println(lSerror);
            }
            
            try
            {
                // De esta forma se obtiene la conexi¢n 
                pbCNcon = DriverManager.getConnection(lSurl, lSusuario, lSpass);
                System.out.println("Conexi¢n establecida.");
            } catch (SQLException lSQLEe)
            {// Ocurrió un lSerror pbCNcon la conexi¢n 
                System.out.println("Error con la conexi¢n a la base de datos:");
            }
        } else
        {
                System.out.println("ERROR DEBES MANDAR UN 1 PARA ORACLE O UN 2 PARA MYSQL");
        }
        return pbCNcon;
    }
    
    /**
     * metpbCNconecta: conecta a una base de datos MySQL
     * 
     * @param lSbd -Es la base de datos a la que se quiere conectar
     * @param lSusuario -Usuario de la base de datos
     * @param lSpass -Password del pSusuario en la base de datos
     * @param lJFframe -Interfaz que vera el usuario
     */
    public Connection metpbCNconecta(String lSbd, String lSusuario, String lSpass, JFrame lJFframe)
    {
        String lSurl ="jdbc:mysql://localhost/"+lSbd;   
        
        try
        {
            Driver lDRd = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception lEXe)
        {
            CMensajes.cmetpbMsj(lJFframe, "No se ha podido cargar el Driver JDBC-MySQL "+ lEXe.getMessage()  );
        }
        
        try
        {// De esta forma se obtiene la conexi¢n 
            pbCNcon = DriverManager.getConnection(lSurl, lSusuario, lSpass);
            System.out.println("Conexi¢n establecida.");
        } catch (SQLException lSQLEe)
        {// Ocurrió un lSerror pbCNcon la conexi¢n 
            CMensajes.cmetpbMsj(lJFframe,"Error con la conexi¢n a la base de datos:");
        }
        return pbCNcon;
    }
    
    /**metpbDesconectar: cierra la conexión de la base de datos
     * 
     * @param lCNconect recibe la conexión que se desea cerrar
    **/
    public void metpbDesconectar(Connection lCNconect)
    {
        lCNconect = null;
    }
}
