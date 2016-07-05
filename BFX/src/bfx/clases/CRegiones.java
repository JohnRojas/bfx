/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfx.clases;

/**
 *
 * @author DELL
 */
public class CRegiones {
    public static int pbEconsecutivo = 0;
    private int pvEidRegiones;
    private String pvCnombre;
    private String pvCimagenReferencia;
    private int pvEestatus;
    private int pvEidCuadro;
    private int pvEborrado;
    private int pvEnumero;
    
     public CRegiones() 
    {
        pbEconsecutivo= 1010;
        pvEborrado = 1;
        pvEnumero = ++pbEconsecutivo;
    }
    
    public CRegiones(int numero, String nombre, String imagen, int status, int cuadro) 
    {
            this.pvCnombre = nombre;
            this.pvCimagenReferencia = imagen;
            this.pvEestatus = status;
            this.pvEidCuadro = cuadro;
            this.pvEidRegiones = numero;
    }

    /**
     * @return the pvEidRegiones
     */
    public int getPvEidRegiones() {
        return pvEidRegiones;
    }

    /**
     * @param pvEidRegiones the pvEidRegiones to set
     */
    public void setPvEidRegiones(int pvEidRegiones) {
        this.pvEidRegiones = pvEidRegiones;
    }

    /**
     * @return the pvCnombre
     */
    public String getPvCnombre() {
        return pvCnombre;
    }

    /**
     * @param pvCnombre the pvCnombre to set
     */
    public void setPvCnombre(String pvCnombre) {
        this.pvCnombre = pvCnombre;
    }

    /**
     * @return the pvCimagenReferencia
     */
    public String getPvCimagenReferencia() {
        return pvCimagenReferencia;
    }

    /**
     * @param pvCimagenReferencia the pvCimagenReferencia to set
     */
    public void setPvCimagenReferencia(String pvCimagenReferencia) {
        this.pvCimagenReferencia = pvCimagenReferencia;
    }

    /**
     * @return the pvEidCuadro
     */
    public int getPvEidCuadro() {
        return pvEidCuadro;
    }

    /**
     * @param pvEidCuadro the pvEidCuadro to set
     */
    public void setPvEidCuadro(int pvEidCuadro) {
        this.pvEidCuadro = pvEidCuadro;
    }

    /**
     * @return the pvEborrado
     */
    public int getPvEborrado() {
        return pvEborrado;
    }

    /**
     * @param pvEborrado the pvEborrado to set
     */
    public void setPvEborrado(int pvEborrado) {
        if(pvEborrado == 0 || pvEborrado == 1)
        {
            this.pvEborrado = pvEborrado;
        }else
        {
            this.pvEborrado = 1;
            System.out.println("Valor no aceptado, se asignará el valor 1");
        }
    }

    /**
     * @return the pvEnumero
     */
    public int getPvEnumero() {
        return pvEnumero;
    }

    /**
     * @param pvEnumero the pvEnumero to set
     */
    public void setPvEnumero(int pvEnumero) {
        this.pvEnumero = pvEnumero;
    }

    /**
     * @return the pvEestatus
     */
    public int getPvEestatus() {
        return pvEestatus;
    }

    /**
     * @param pvEestatus the pvEestatus to set
     */
    public void setPvEestatus(int pvEestatus) {
        this.pvEestatus = pvEestatus;
    }
    
}
