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
public class CBailes {
    public static int pbEconsecutivo = 0;
    private int pvEidBailes;
    private String pvCnombreBaile;
    private String pvCduracion;
    private int pvEestatus;
    private int pvEidRegiones;
    private int pvEborrado;
    private int pvEnumero;
    
    public CBailes() 
    {
        pbEconsecutivo= 1010;
        pvEborrado = 1;
        pvEnumero = ++pbEconsecutivo;
    }
    
    public CBailes(int numero, String nombre, String duracion, int status, int regiones) 
    {
            this.pvCnombreBaile = nombre;
            this.pvCduracion = duracion;
            this.pvEestatus = status;
            this.pvEidRegiones = regiones;
            this.pvEidBailes = numero;
    }

    /**
     * @return the pvEidBailes
     */
    public int getPvEidBailes() {
        return pvEidBailes;
    }

    /**
     * @param pvEidBailes the pvEidBailes to set
     */
    public void setPvEidBailes(int pvEidBailes) {
        this.pvEidBailes = pvEidBailes;
    }

    /**
     * @return the pvCnombreBaile
     */
    public String getPvCnombreBaile() {
        return pvCnombreBaile;
    }

    /**
     * @param pvCnombreBaile the pvCnombreBaile to set
     */
    public void setPvCnombreBaile(String pvCnombreBaile) {
        this.pvCnombreBaile = pvCnombreBaile;
    }

    /**
     * @return the pvCduracion
     */
    public String getPvCduracion() {
        return pvCduracion;
    }

    /**
     * @param pvCduracion the pvCduracion to set
     */
    public void setPvCduracion(String pvCduracion) {
        this.pvCduracion = pvCduracion;
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
