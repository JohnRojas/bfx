/*Nombre de clase		: CUsuariosDE
*Descripción de la clase	: Clase que contiene las propiedades de un Usuario
*Fecha	de creación		: 01/05/2016
*Elaboro			: Jatziry Barrera Hinojosa && Diego Enrique Sánchez Ordoñez
*Fecha	de Liberación		: 01/05/2016
*Autorizó			: Mauro Sánchez Sánchez//Techno Engineers
*Fecha Mantenimiento		: 05/06/2016
*Folio mantenimiento		: 02
*Descripción del mantto.	: Se realizó la actualización de métodos y transformacion de código con calidad.
*Responsable			: Jatziry Barrera Hinojosa
*Revisor 			: Diego Enrique Sánchez Ordoñez
*/
package bfx.clases;
/**
 * Datos encapsulados del usuario.
 * @author: Techno Engineers
 * @versión: 3.0 
 */
public class CUsuariosDE
{
    private int ppvEIdUsuario;
    private char ppvCTipoUsuario;
    private String ppvSNombreDeUsuario;
    private String ppvSContrasena;
    private int ppvEStatus;
    private String ppvSFechaIngreso;
    private int ppvEExpediente;
    private String ppvSNombre;
    private String ppvSApellidoPaterno;
    private String ppvSApellidoMaterno;
    private char ppvCSexo;
    private String ppvSCalle;
    private int ppvENumero;
    private String ppvSColonia;
    private String ppvSCiudad;
    private String ppvSEstado;
    private int ppvECp;
    private String ppvSTelCelular;
    private String ppvSTelCasa;
    private String ppvSTelOficina;
    private String ppvSEmail;
    private String ppvSFechaNacimiento;
    private String ppvSLugarNacimiento;
    private char ppvCEstadoCivil;
    private String ppvSPasaporteSN;
    private String ppvSVigenciaPasaporte;
    private int ppvENoCartillaMilitar;
    private double ppvDEstatura;
    private String ppvSResponsable;
    private String ppvSTelResponsable;
    private String ppvSTipoSanguineo;
    private String ppvSAlergias;
    private String ppvSEnfermedades;
    private String ppvSNombreMedicoCabecera;
    private String ppvSTelMedicoDeCabecera;
    private String ppvSMedicacionDiarrea;
    private String ppvSMedicacionDolorDeCabeza;
    private String ppvSMedicacionDolorDeEstomago;
    private String ppvSMedicacionDolorMuscular;
    private String ppvSMedicacionGripa;
    private String ppvSMedicacionOtro;
    private String ppvSFormaDeEnterarse;
    private String ppvSBaila;
    private String ppvSBaile;
    private String ppvSAnteriorBallet;
    private String ppvSTiempoQueBailo;
    private int ppvEPreguntaSecreta;
    private String ppvSRespuestaSecreta;
    private String ppvSComentario;
    
     /**
     * Se crea un constructor
     * Recibe los valores de los atributos de la tabla Usuarios en la base de datos.
     * @param lEIdUsuario: id del registro
     * @param lCTipoUsuario: inicial del tipo de usuario
     * @param lSNombreDeUsuario: sobre nombre que utiliza el usuario
     * @param lSContrasena: contraseña para registrarse
     * @param lEStatus: estado actual del usuario
     * @param lSFechaIngreso: fecha en la que se inscribio el usuario
     * @param lEExpediente: numero de expediente de documentos
     * @param lSNombre: nombre o nombres del usuario
     * @param lSApellidoPaterno: apellido paterno del usuario
     * @param plApellidoMaterno: apellido materno del usuario
     * @param lCSexo: sexo del usuario
     * @param lSCalle: calle del domicilio del usuario
     * @param lENumero: numero del domicilio del usuario
     * @param lSColonia: colonia del domicilio del usuario
     * @param lSCiudad: ciudad del domicilio del usuario
     * @param lSEstado: estado donde se encuentra viviendo el usuario
     * @param lECp: codigo postal del domicilio del usuario
     * @param lSTelCelular: telefono celular del usuario
     * @param lSTelCasa: telefono fijo del usuario
     * @param lSTelOficina: telefono de oficina del usuario
     * @param lSEmail: correo electrónico del usuario
     * @param lSFechaNacimiento: fecha de nacimiento del usuario
     * @param lSLugarNacimiento: lugar de nacimiento del usuario
     * @param lCEstadoCivil estado civil del usuario
     * @param lSPasaporteSN: respuesta para ver si tiene o no pasaporte
     * @param lSVigenciaPasaporte: fecha en que se vence el pasaporte del usuario
     * @param lENoCartillaMilitar: numero de cartilla militar
     * @param lDEstatura: estatura del usuario
     * @param lSResponsable: nombre de algun familiar o persona responsable del usuario
     * @param lSTelResponsable: telefono del responsable
     * @param lSTipoSanguineo: tipo de sangre del usuario
     * @param lSAlergias: posibles alergias que tenga el usuario
     * @param lSEnfermedades: posibles enfermedades que padece el usuario
     * @param lSNombreMedicoCabecera: nombre del doctor de cabecera del usuario
     * @param lSTelMedicoDeCabecera: telefono del medico de cabecera del usuario
     * @param lSMedicacionDiarrea: medicamento que utiliza el usuario para diarrea
     * @param lSMedicacionDolorDeCabeza: medicamento que utiliza el usuario para dolor de cabeza
     * @param lSMedicacionDolorDeEstomago: medicamento que utiliza el usuario para dolor de estomago
     * @param lSMedicacionDolorMuscular: medicamento que utiliza el usuario para dolor muscular
     * @param lSMedicacionGripa: medicamento que utiliza el usuario para gripa
     * @param lSMedicacionOtro: medicamento que utiliza el usuario
     * @param lSFormaDeEnterarse: medio por el cual se entero el usuario del ballet
     * @param lSBaila: si o no acostumbra a bailar el usuario
     * @param lSBaile: que tipo de bailes sabe el usuario
     * @param lSAnteriorBallet: en que escuela aprendio los bailes que sabe
     * @param lSTiempoQueBailo: por cuantos meses estuvo practicando los bailes el usuario
     * @param lEPreguntaSecreta: pregunta de seguridad que elige el usuario
     * @param lSRespuestaSecreta: respuesta secreta que asigna el usuario
     * @param lSComentario: algun comentario del usuario
     */
    
    public CUsuariosDE(int lEIdUsuario, char lCTipoUsuario, String lSNombreDeUsuario, String lSContrasena, int lEStatus, String lSFechaIngreso, 
            int lEExpediente, String lSNombre, String lSApellidoPaterno, String plApellidoMaterno, char lCSexo, String lSCalle, int lENumero, 
            String lSColonia, String lSCiudad, String lSEstado, int lECp, String lSTelCelular, String lSTelCasa, String lSTelOficina, 
            String lSEmail, String lSFechaNacimiento, String lSLugarNacimiento, char lCEstadoCivil, String lSPasaporteSN, 
            String lSVigenciaPasaporte, int lENoCartillaMilitar, double lDEstatura, String lSResponsable, String lSTelResponsable, 
            String lSTipoSanguineo, String lSAlergias, String lSEnfermedades, String lSNombreMedicoCabecera, String lSTelMedicoDeCabecera, 
            String lSMedicacionDiarrea, String lSMedicacionDolorDeCabeza, String lSMedicacionDolorDeEstomago, String lSMedicacionDolorMuscular, 
            String lSMedicacionGripa, String lSMedicacionOtro, String lSFormaDeEnterarse, String lSBaila, String lSBaile, String lSAnteriorBallet, 
            String lSTiempoQueBailo, int lEPreguntaSecreta, String lSRespuestaSecreta, String lSComentario)
    {
        this.ppvEIdUsuario = lEIdUsuario;
        this.ppvCTipoUsuario = lCTipoUsuario;
        this.ppvSNombreDeUsuario = lSNombreDeUsuario;
        this.ppvSContrasena = lSContrasena;
        this.ppvEStatus = lEStatus;
        this.ppvSFechaIngreso = lSFechaIngreso;
        this.ppvEExpediente = lEExpediente;
        this.ppvSNombre = lSNombre;
        this.ppvSApellidoPaterno = lSApellidoPaterno;
        this.ppvSApellidoMaterno = plApellidoMaterno;
        this.ppvCSexo = lCSexo;
        this.ppvSCalle = lSCalle;
        this.ppvENumero = lENumero;
        this.ppvSColonia = lSColonia;
        this.ppvSCiudad = lSCiudad;
        this.ppvSEstado = lSEstado;
        this.ppvECp = lECp;
        this.ppvSTelCelular = lSTelCelular;
        this.ppvSTelCasa = lSTelCasa;
        this.ppvSTelOficina = lSTelOficina;
        this.ppvSEmail = lSEmail;
        this.ppvSFechaNacimiento = lSFechaNacimiento;
        this.ppvSLugarNacimiento = lSLugarNacimiento;
        this.ppvCEstadoCivil = lCEstadoCivil;
        this.ppvSPasaporteSN = lSPasaporteSN;
        this.ppvSVigenciaPasaporte = lSVigenciaPasaporte;
        this.ppvENoCartillaMilitar = lENoCartillaMilitar;
        this.ppvDEstatura = lDEstatura;
        this.ppvSResponsable = lSResponsable;
        this.ppvSTelResponsable = lSTelResponsable;
        this.ppvSTipoSanguineo = lSTipoSanguineo;
        this.ppvSAlergias = lSAlergias;
        this.ppvSEnfermedades = lSEnfermedades;
        this.ppvSNombreMedicoCabecera = lSNombreMedicoCabecera;
        this.ppvSTelMedicoDeCabecera = lSTelMedicoDeCabecera;
        this.ppvSMedicacionDiarrea = lSMedicacionDiarrea;
        this.ppvSMedicacionDolorDeCabeza = lSMedicacionDolorDeCabeza;
        this.ppvSMedicacionDolorDeEstomago = lSMedicacionDolorDeEstomago;
        this.ppvSMedicacionDolorMuscular = lSMedicacionDolorMuscular;
        this.ppvSMedicacionGripa = lSMedicacionGripa;
        this.ppvSMedicacionOtro = lSMedicacionOtro;
        this.ppvSFormaDeEnterarse = lSFormaDeEnterarse;
        this.ppvSBaila = lSBaila;
        this.ppvSBaile = lSBaile;
        this.ppvSAnteriorBallet = lSAnteriorBallet;
        this.ppvSTiempoQueBailo = lSTiempoQueBailo;
        this.ppvEPreguntaSecreta = lEPreguntaSecreta;
        this.ppvSRespuestaSecreta = lSRespuestaSecreta;
        this.ppvSComentario = lSComentario;
    }

    
    /**
     * Método que permite obtener el valor de la propiedad "pvEIdUsuario"
     * @return Valor numérico 1 hasta N
     */    
    public int getpbEIdUsuario() 
    {
        return ppvEIdUsuario;
    }
    
    /**
     * Método que permite asignar el número de usuario que tiene el usuario.
     * @param lEIdUsuario número de usuario que se le asigna para identificarlo
    */
    public void setpbIdUsuario(int lEIdUsuario) 
    {
        this.ppvEIdUsuario = lEIdUsuario;
    }

     /**
     * Método que permite obtener el valor de la propiedad "TipoDeUsuario"
     * @return Valor tipo char (U-A)
     */
    public char getpbCTipoUsuario() 
    {
        return ppvCTipoUsuario;
    }

    /**
     * Método que permite asignar el tipo de usuario que tiene la persona.
     * @param lCTipoUsuario tipo de usuario que se le asigna para identificarlo como bailarin o administrador
    */
    public void setpbTipoUsuario(char lCTipoUsuario) 
    {
        this.ppvCTipoUsuario = lCTipoUsuario;
    }

    /**
     * Método que permite obtener el sobre nombre que elige el usuario
     * @return Cadena alfanumérica
     */ 
    public String getpbSNombreDeUsuario() 
    {
        return ppvSNombreDeUsuario;
    }

    /**
     * Método que permite asignar el nombre de usuario que dió la persona.
     * @param lSNombreDeUsuario nombre de usuario
    */
    public void setpbNombreDeUsuario(String lSNombreDeUsuario) 
    {
        this.ppvSNombreDeUsuario = lSNombreDeUsuario;
    }

    /**
     * Método que permite obtener la cadena del dato "contraseña" del usuario
     * @return Cadena alfanumérica
     */ 
    public String getpbSContrasena() 
    {
        return ppvSContrasena;
    }

    /**
     * Método que permite asignar la contraseña del usuario a una variable.
     * @param lSContrasena contraseña para ingresar al sistema
    */
    public void setpbContrasena(String lSContrasena) 
    {
        this.ppvSContrasena = lSContrasena;
    }

    /**
     * Método que permite obtener el status de activo, inactivo o vetado que tiene el usuario
     * @return Valor de tipo char
     */ 
    public int getpbEStatus() 
    {
        return ppvEStatus;
    }

    /**
     * Método que permite asignar el nombre de usuario que dió la persona.
     * @param lEStatus
    */
    public void setpbStatus(int lEStatus) 
    {
        this.ppvEStatus = lEStatus;
    }

    /**
     * Método que permite obtener la fecha en que ingreso el usuario al ballet
     * @return Cadena alfanumérica de formato date
     */ 
    public String getpbSFechaIngreso() 
    {
        return ppvSFechaIngreso;
    }

    /**
     * Método que permite asignar la fecha de ingreso que tiene el usuario.
     * @param lSFechaIngreso
    */
    public void setpbFechaIngreso(String lSFechaIngreso) 
    {
        this.ppvSFechaIngreso = lSFechaIngreso;
    }

    /**
     * Método que permite obtener el número de expediente que tiene el usuario
     * @return Valor numérico 1 hasta N
     */ 
    public int getpbEExpediente() 
    {
        return ppvEExpediente;
    }

    /**
     * Método que permite asignar el número de expediente que tiene el usuario.
     * @param lEExpediente
    */
    public void setpbExpediente(int lEExpediente) 
    {
        this.ppvEExpediente = lEExpediente;
    }

    /**
     * Método que permite obtener el nombre o nombres del usuario.
     * @return Valor alfabético
     */ 
    public String getpbSNombre() 
    {
        return ppvSNombre;
    }

    /**
     * Método que permite asignar el nombre del usuario.
     * @param lSNombre
    */
    public void setpbNombre(String lSNombre) 
    {
        this.ppvSNombre = lSNombre;
    }

    /**
     * Método que permite obtener la cadena del apellido paterno del usuario
     * @return Valor alfabético
     */ 
    public String getpbSApellidoPaterno() 
    {
        return ppvSApellidoPaterno;
    }

    /**
     * Método que permite asignar Apellido Paterno del usuario.
     * @param lSApellidoPaterno
    */
    public void setpbApellidoPaterno(String lSApellidoPaterno) 
    {
        this.ppvSApellidoPaterno = lSApellidoPaterno;
    }

    /**
     * Método que permite obtener la cadena del apellido materno del usuario
     * @return Valor alfabético
     */ 
    public String getpbSApellidoMaterno() 
    {
        return ppvSApellidoMaterno;
    }

    /**
     * Método que permite asignar el Apellido Materno del usuario.
     * @param lSApellidoMaterno
    */
    public void setpbApellidoMaterno(String lSApellidoMaterno) 
    {
        this.ppvSApellidoMaterno = lSApellidoMaterno;
    }

    /**
     * Método que permite obtener el primer carácter del sexo del usuario
     * @return Valor de tipo char
     */ 
    public char getpbCSexo() 
    {
        return ppvCSexo;
    }

    /**
     * Método que permite asignar el primer carácter del sexo del usuario.
     * @param lCSexo
    */
    public void setpbSexo(char lCSexo) 
    {
        this.ppvCSexo = lCSexo;
    }

    /**
     * Método que permite obtener la calle del domicilio del usuario
     * @return Valor alfanumérico
     */ 
    public String getpbSCalle() 
    {
        return ppvSCalle;
    }

    /**
     * Método que permite asignar la calle del domicilio del usuario.
     * @param lSCalle
    */
    public void setpbCalle(String lSCalle) 
    {
        this.ppvSCalle = lSCalle;
    }

    /**
     * Método que permite obtener el número del domicilio del usuario
     * @return Valor Enteroo
     */ 
    public int getpbENumero() 
    {
        return ppvENumero;
    }

    /**
     * Método que permite asignar el número del domicilio del usuario.
     * @param lENumero
    */
    public void setpbNumero(int lENumero) 
    {
        this.ppvENumero = lENumero;
    }

    /**
     * Método que permite obtener la colonia del domicilio del usuario.
     * @return Valor alfanumérico
     */ 
    public String getpbSColonia() 
    {
        return ppvSColonia;
    }

    /**
     * Método que permite asignar la colonia del domicilio del usuario.
     * @param lSColonia
    */
    public void setpbColonia(String lSColonia) 
    {
        this.ppvSColonia = lSColonia;
    }

    /**
     * Método que permite obtener la ciudad del domicilio del usuario.
     * @return Valor alfabético
     */ 
    public String getpbSCiudad() 
    {
        return ppvSCiudad;
    }

    /**
     * Método que permite asignar la ciudad del domicilio del usuario.
     * @param lSCiudad
    */
    public void setpbCiudad(String lSCiudad) 
    {
        this.ppvSCiudad = lSCiudad;
    }

    /**
     * Método que permite obtener el estado del domicilio del usuario.
     * @return Valor alfabético
     */ 
    public String getpbSEstado()
    {
        return ppvSEstado;
    }

    /**
     * Método que permite asignar el estado del domicilio del usuario.
     * @param lSEstado
    */
    public void setpbEstado(String lSEstado) 
    {
        this.ppvSEstado = lSEstado;
    }

    /**
     * Método que permite obtener el código postal del domicilio del usuario.
     * @return Valor Entero
     */ 
    public int getpbECp() 
    {
        return ppvECp;
    }

    /**
     * Método que permite asignar el código postal del domicilio del usuario.
     * @param lECp
    */
    public void setpbCp(int lECp)
    {
        this.ppvECp = lECp;
    }

    /**
     * Método que permite obtener el teléfono celular del usuario.
     * @return Valor de tipo string con un máximo de 10 caracteres.
     */ 
    public String getpbSTelCelular() 
    {
        return ppvSTelCelular;
    }

    /**
     * Método que permite asignar el teléfono celular del usuario.
     * @param lSTelCelular
    */
    public void setpbTelCelular(String lSTelCelular) 
    {
        this.ppvSTelCelular = lSTelCelular;
    }

    /**
     * Método que permite obtener el teléfono de casa del usuario.
     * @return Valor de tipo string con un máximo de 10 caracteres.
     */ 
    public String getpbSTelCasa() 
    {
        return ppvSTelCasa;
    }

    /**
     * Método que permite asignar el teléfono de casa del usuario.
     * @param lSTelCasa
    */
    public void setpbTelCasa(String lSTelCasa) 
    {
        this.ppvSTelCasa = lSTelCasa;
    }

    /**
     * Método que permite obtener el teléfono de oficina del usuario.
     * @return Valor de tipo string con un máximo de 10 caracteres
     */
    public String getpbSTelOficina() 
    {
        return ppvSTelOficina;
    }

    /**
     * Método que permite asignar el teléfono de oficina del usuario.
     * @param lSTelOficina
    */
    public void setpbTelOficina(String lSTelOficina) 
    {
        this.ppvSTelOficina = lSTelOficina;
    }

    /**
     * Método que permite obtener el correo electrónico del usuario.
     * @return Valor de tipo string
     */
    public String getpbSEmail() 
    {
        return ppvSEmail;
    }

    /**
     * Método que permite asignar el correo electrónico del usuario.
     * @param lSEmail
    */
    public void setpbEmail(String lSEmail) 
    {
        this.ppvSEmail = lSEmail;
    }

    /**
     * Método que permite obtener la fecha de nacimiento del usuario.
     * @return Valor de tipo string con formato date
     */
    public String getpbSFechaNacimiento()
    {
        return ppvSFechaNacimiento;
    }

    /**
     * Método que permite asignar la fecha de nacimiento del usuario.
     * @param lSFechaNacimiento
    */
    public void setpbFechaNacimiento(String lSFechaNacimiento) 
    {
        this.ppvSFechaNacimiento = lSFechaNacimiento;
    }

    /**
     * Método que permite obtener el lugar de nacimiento del usuario.
     * @return Valor de tipo string 
     */
    public String getpbSLugarNacimiento() 
    {
        return ppvSLugarNacimiento;
    }

    /**
     * Método que permite asignar el lugar de nacimiento del usuario
     * @param lSLugarNacimiento
    */
    public void setpbLugarNacimiento(String lSLugarNacimiento) 
    {
        this.ppvSLugarNacimiento = lSLugarNacimiento;
    }

    /**
     * Método que permite obtener el estado civil del usuario
     * @return Valor de tipo char
     */
    public char getpbCEstadoCivil() 
    {
        return ppvCEstadoCivil;
    }

    /**
     * Método que permite asignar el estado civil del usuario
     * @param lCEstadoCivil
    */
    public void setpbEstadoCivil(char lCEstadoCivil) 
    {
        this.ppvCEstadoCivil = lCEstadoCivil;
    }

    /**
     * Método que permite obtener la respuesta de SI o NO tiene pasaporte el usuario
     * @return Valor de tipo string 
     */
    public String getpbSPasaporteSN() 
    {
        return ppvSPasaporteSN;
    }

    /**
     * Método que permite asignar la respuesta de si tiene o no pasaporte el usuario
     * @param lSPasaporteSN
    */
    public void setpbPasaporteSN(String lSPasaporteSN) 
    {
        this.ppvSPasaporteSN = lSPasaporteSN;
    }

    /**
     * Método que permite obtener la fecha de vigencia del pasaporte del usuario
     * @return Valor de tipo string con formato date
     */
    public String getpbSVigenciaPasaporte() 
    {
        return ppvSVigenciaPasaporte;
    }

    /**
     * Método que permite asignar la vigencia del pasaporte del usuario
     * @param lSVigenciaPasaporte
    */
    public void setpbVigenciaPasaporte(String lSVigenciaPasaporte) 
    {
        this.ppvSVigenciaPasaporte = lSVigenciaPasaporte;
    }

    /**
     * Método que permite obtener el número de cartilla militar del usuario en caso de ser de sexo masculino
     * @return Valor de tipo entero
     */
    public int getpbENoCartillaMilitar() 
    {
        return ppvENoCartillaMilitar;
    }

    /**
     * Método que permite asignar el número de cartilla militar del usuario
     * @param lENoCartillaMilitar
    */
    public void setpbNoCartillaMilitar(int lENoCartillaMilitar) 
    {
        this.ppvENoCartillaMilitar = lENoCartillaMilitar;
    }

    /**
     * Método que permite obtener la estatura del usuario
     * @return Valor de tipo double 
     */
    public double getpbDEstatura() 
    {
        return ppvDEstatura;
    }

    /**
     * Método que permite asignar la estatura del usuario
     * @param lDEstatura
    */
    public void setpbEstatura(double lDEstatura) 
    {
        this.ppvDEstatura = lDEstatura;
    }

    /**
     * Método que permite obtener el nombre del responsable del usuario
     * @return Valor de tipo string 
     */
    public String getpbSResponsable() 
    {
        return ppvSResponsable;
    }

    /**
     * Método que permite asignar el nombre del responsable del usuario
     * @param lSResponsable
    */
    public void setpbResponsable(String lSResponsable) 
    {
        this.ppvSResponsable = lSResponsable;
    }

    /**
     * Método que permite obtener el teléfono del responsable del usuario
     * @return Valor de tipo string con un número máximo de 10 caracteres
     */
    public String getpbSTelResponsable() 
    {
        return ppvSTelResponsable;
    }

    /**
     * Método que permite asignar el teléfono del responsable del usuario
     * @param lSTelResponsable
    */
    public void setpbTelResponsable(String lSTelResponsable) 
    {
        this.ppvSTelResponsable = lSTelResponsable;
    }

    /**
     * Método que permite obtener el tipo de sangre del usuario
     * @return Valor de tipo string 
     */
    public String getpbSTipoSanguineo() 
    {
        return ppvSTipoSanguineo;
    }

    /**
     * Método que permite asignar el tipo de sangre del usuario
     * @param lSTipoSanguineo
    */
    public void setpbTipoSanguineo(String lSTipoSanguineo)
    {
        this.ppvSTipoSanguineo = lSTipoSanguineo;
    }

    /**
     * Método que permite obtener el nombre de las alergias del usuario
     * @return Valor de tipo string 
     */
    public String getpbSAlergias() 
    {
        return ppvSAlergias;
    }

    /**
     * Método que permite asignar las alergias del usuario
     * @param lSAlergias
    */
    public void setpbAlergias(String lSAlergias) 
    {
        this.ppvSAlergias = lSAlergias;
    }

    /**
     * Método que permite obtener el nombre de las enfermedades del usuario
     * @return Valor de tipo string 
     */
    public String getpbSEnfermedades() 
    {
        return ppvSEnfermedades;
    }

    /**
     * Método que permite asignar el del usuario
     * @param lSEnfermedades
    */
    public void setpbEnfermedades(String lSEnfermedades) 
    {
        this.ppvSEnfermedades = lSEnfermedades;
    }

    /**
     * Método que permite obtener el nombre del medicamento de cabecera del usuario
     * @return Valor de tipo string 
     */
    public String getpbSNombreMedicoCabecera() 
    {
        return ppvSNombreMedicoCabecera;
    }

    /**
     * Método que permite asignar el nombre del médico de cabecera del usuario
     * @param lSNombreMedicoCabecera
    */
    public void setpbNombreMedicoCabecera(String lSNombreMedicoCabecera) 
    {
        this.ppvSNombreMedicoCabecera = lSNombreMedicoCabecera;
    }

    /**
     * Método que permite obtener el teléfono del médico de cabecera del usuario
     * @return Valor de tipo string 
     */
    public String getpbSTelMedicoDeCabecera() 
    {
        return ppvSTelMedicoDeCabecera;
    }

    /**
     * Método que permite asignar el nombre del medico de cabecera del usuario
     * @param lSTelMedicoDeCabecera
    */
    public void setpbTelMedicoDeCabecera(String lSTelMedicoDeCabecera) 
    {
        this.ppvSTelMedicoDeCabecera = lSTelMedicoDeCabecera;
    }

    /**
     * Método que permite obtener el nombre del medicamento para diarrea que usa el usuario
     * @return Valor de tipo string 
     */
    public String getpbSMedicacionDiarrea() 
    {
        return ppvSMedicacionDiarrea;
    }
    
    /**
     * Método que permite asignar el medicamento del usuario para diarrea
     * @param lSMedicacionDiarrea
    */
    public void setpbMedicacionDiarrea(String lSMedicacionDiarrea) 
    {
        this.ppvSMedicacionDiarrea = lSMedicacionDiarrea;
    }

    /**
     * Método que permite obtener el nombre del medicamento para dolor de cabeza que usa el usuario
     * @return Valor de tipo string 
     */
    public String getpbSMedicacionDolorDeCabeza() 
    {
        return ppvSMedicacionDolorDeCabeza;
    }

    /**
     * Método que permite asignar el medicamento del usuario para dolor de cabeza
     * @param lSMedicacionDolorDeCabeza
    */
    public void setpbMedicacionDolorDeCabeza(String lSMedicacionDolorDeCabeza)
    {
        this.ppvSMedicacionDolorDeCabeza = lSMedicacionDolorDeCabeza;
    }

    /**
     * Método que permite obtener el nombre del medicamento para dolor de estómago que usa el usuario
     * @return Valor de tipo string 
     */
    public String getpbSMedicacionDolorDeEstomago()
    {
        return ppvSMedicacionDolorDeEstomago;
    }

    /**
     * Método que permite asignar el medicamento del usuario para dolor de estómago
     * @param lSMedicacionDolorDeEstomago
    */
    public void setpbMedicacionDolorDeEstomago(String lSMedicacionDolorDeEstomago) 
    {
        this.ppvSMedicacionDolorDeEstomago = lSMedicacionDolorDeEstomago;
    }

    /**
     * Método que permite obtener el nombre del medicamento para dolor muscular que usa el usuario
     * @return Valor de tipo string 
     */
    public String getpbSMedicacionDolorMuscular() 
    {
        return ppvSMedicacionDolorMuscular;
    }

    /**
     * Método que permite asignar el medicamento del usuario para dolor muscular
     * @param lSMedicacionDolorMuscular
    */
    public void setpbMedicacionDolorMuscular(String lSMedicacionDolorMuscular)
    {
        this.ppvSMedicacionDolorMuscular = lSMedicacionDolorMuscular;
    }

    /**
     * Método que permite obtener el nombre del medicamento para gripa que usa el usuario
     * @return Valor de tipo string 
     */
    public String getpbSMedicacionGripa() 
    {
        return ppvSMedicacionGripa;
    }

    /**
     * Método que permite asignar el medicamento del usuario para la gripa
     * @param lSMedicacionGripa
    */
    public void setpbMedicacionGripa(String lSMedicacionGripa) 
    {
        this.ppvSMedicacionGripa = lSMedicacionGripa;
    }

    /**
     * Método que permite obtener el nombre del medicamento que usa el usuario
     * @return Valor de tipo string 
     */
    public String getpbSMedicacionOtro() 
    {
        return ppvSMedicacionOtro;
    }

    /**
     * Método que permite asignar el medicamento del usuario
     * @param lSMedicacionOtro
    */
    public void setpbMedicacionOtro(String lSMedicacionOtro) 
    {
        this.ppvSMedicacionOtro = lSMedicacionOtro;
    }

    /**
     * Método que permite obtener la forma en que se entero el usuario del ballet
     * @return Valor de tipo string 
     */
    public String getpbSFormaDeEnterarse() 
    {
        return ppvSFormaDeEnterarse;
    }

    /**
     * Método que permite asignar la Forma De Enterarse del ballet
     * @param lSFormaDeEnterarse
    */
    public void setpbFormaDeEnterarse(String lSFormaDeEnterarse) 
    {
        this.ppvSFormaDeEnterarse = lSFormaDeEnterarse;
    }

    /**
     * Método que permite obtener la respuesta de si baila o no el usuario
     * @return Valor de tipo string 
     */
    public String getpbSBaila() 
    {
        return ppvSBaila;
    }

    /**
     * Método que permite asignar la respuesta de si baila o no el usuario
     * @param lSBaila
    */
    public void setpbBaila(String lSBaila) 
    {
        this.ppvSBaila = lSBaila;
    }

    /**
     * Método que permite obtener el nombre de los bailes que sabe el usuario
     * @return Valor de tipo string 
     */
    public String getpbSBaile() 
    {
        return ppvSBaile;
    }

    /**
     * Método que permite asignar los bailes que sabe el usuario
     * @param lSBaile
    */
    public void setpbBaile(String lSBaile) 
    {
        this.ppvSBaile = lSBaile;
    }

    /**
     * Método que permite obtener el nombre del ballet en que bailaba antes el usuario
     * @return Valor de tipo string 
     */
    public String getpbSAnteriorBallet() 
    {
        return ppvSAnteriorBallet;
    }

    /**
     * Método que permite asignar el nombre del ballet en que bailó del usuario
     * @param lSAnteriorBallet
    */
    public void setpbAnteriorBallet(String lSAnteriorBallet) 
    {
        this.ppvSAnteriorBallet = lSAnteriorBallet;
    }

    /**
     * Método que permite obtener los meses que estuvo bailando el usuario
     * @return Valor de tipo string 
     */
    public String getpbSTiempoQueBailo() 
    {
        return ppvSTiempoQueBailo;
    }

    /**
     * Método que permite asignar el tiempo en meses que bailó el usuario
     * @param lSTiempoQueBailo
    */
    public void setpbTiempoQueBailo(String lSTiempoQueBailo) 
    {
        this.ppvSTiempoQueBailo = lSTiempoQueBailo;
    }

    /**
     * Método que permite obtener el numero de la pregunta secreta que elige el usuario.
     * @return Valor Entero 
     */
    public int getpbEPreguntaSecreta()
    {
        return ppvEPreguntaSecreta;
    }

    /**
     * Método que permite asignar el número de pregunta del usuario
     * @param lEPreguntaSecreta
    */
    public void setpbPreguntaSecreta(int lEPreguntaSecreta) 
    {
        this.ppvEPreguntaSecreta = lEPreguntaSecreta;
    }

    /**
     * Método que permite obtener la respuesta secreta que dió el usuario
     * @return Valor de tipo string 
     */
    public String getpbSRespuestaSecreta() 
    {
        return ppvSRespuestaSecreta;
    }

    /**
     * Método que permite asignar la respuesta secreta que dió del usuario
     * @param lSRespuestaSecreta
    */
    public void setpbRespuestaSecreta(String lSRespuestaSecreta)
    {
        this.ppvSRespuestaSecreta = lSRespuestaSecreta;
    }

    /**
     * Método que permite obtener el comentario que agregó el usuario
     * @return Valor de tipo string 
     */
    public String getpbSComentario()
    {
        return ppvSComentario;
    }

    /**
     * Método que permite asignar el comentario que dió del usuario
     * @param lSComentario
    */
    public void setpbComentario(String lSComentario) 
    {
        this.ppvSComentario = lSComentario;
    }
 
    
    /**
    * Este método nos permite imprimir la información de un objeto de la clase "Usuario" no devuelve nada asi que sólo basta llamarlo para que muestre la información.
    */
    public String  metpbResp() 
    {
        return "\nID del usuario = " + ppvEIdUsuario
                +"\nTipo de usuario = " + ppvCTipoUsuario
            + "\nSobre nombre del usuario = " + ppvSNombreDeUsuario
            + "\nContraseña del Usuario = " + ppvSContrasena
            + "\nEstado actual del usuario = " + ppvEStatus
            + "\nFecha de ingreso = " + ppvSFechaIngreso
            + "\nNúmero de expediente = " + ppvEExpediente
            + "\nNombre completo del usuario = " + ppvSNombre+" "+ppvSApellidoPaterno+" "+ppvSApellidoMaterno
            + "\nSexo del usuario = " + ppvCSexo
            + "\nDirección = Calle: " + ppvSCalle+" número: "+ppvENumero+", Colonia: "+ppvSColonia+", Ciudad: "+ppvSCiudad+", Estado: "+ppvSEstado+" C.P. "+ppvECp
            + "\nTeléfono celular = " + ppvSTelCelular
            + "\nTeléfono fijo = " + ppvSTelCasa
            + "\nTeléfono de oficina = " + ppvSTelOficina
            + "\nCorreo electrónico = " + ppvSEmail
            + "\nFceha de nacimiento = " + ppvSFechaNacimiento +" lugar: "+ppvSLugarNacimiento
            + "\nEstado civil = " + ppvCEstadoCivil
            + "\nPasaporte = " + ppvSPasaporteSN+ " Vigencia: "+ppvSVigenciaPasaporte
            + "\nNúmero de cartilla militar = " + ppvENoCartillaMilitar
            + "\nEstatura = " + ppvDEstatura
            + "\nResponable del usuario = " + ppvSResponsable + " Teléfono: "+ ppvSTelResponsable
            + "\nTipo sanguineo = " + ppvSTipoSanguineo
            + "\nAlergias = " + ppvSAlergias
            + "\nEnfermedades = " + ppvSEnfermedades
            + "\nMedico de cabecera = " +ppvSNombreMedicoCabecera+" Teléfono: "+ppvSTelMedicoDeCabecera
            + "\nMedicamento para diarrea = " + ppvSMedicacionDiarrea
            + "\nMedicamento para dolor de cabeza = " + ppvSMedicacionDolorDeCabeza
            + "\nMedicamento para dolor de estomago = " + ppvSMedicacionDolorDeEstomago
            + "\nMedicamento para dolor muscular = " + ppvSMedicacionDolorMuscular
            + "\nMedicamento para gripa = " + ppvSMedicacionGripa
            + "\nOtro medicamento = " + ppvSMedicacionOtro
            + "\nForma de enterarse del Ballet = " + ppvSFormaDeEnterarse
            + "\n¿Baila? = " + ppvSBaila + ", ¿Qué baila? " + ppvSBaile +", ¿Dónde bailaba? " + ppvSAnteriorBallet+", ¿Por cuántos meses bailó? "+ ppvSTiempoQueBailo
            + "\nPregunta secreta = " + ppvEPreguntaSecreta
            + "\nRespuesta secreta = " + ppvSRespuestaSecreta
            + "\nComentario = " + ppvSComentario + "\n"+
            "*******************************";      
        
    }
    
}
