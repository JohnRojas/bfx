/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfx.clases;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class CCuadros implements Serializable
{
    public static int pbEconsecutivo = 0;
    private int pvEidCuadro;
    private String pvCnombre;
    private int pvEborrado;
    private int pvEnumero;
    
     public CCuadros() 
    {
        pbEconsecutivo= 1010;
        pvEborrado = 1;
        pvEnumero = ++pbEconsecutivo;
    }
   
    public CCuadros(int numero, String nombre) 
    {
            this.pvCnombre = nombre;
            this.pvEidCuadro = numero;
            System.out.println("clase cuadros " + pvEidCuadro);
    }

    /**
     * Método que permite obtener el valor de la propiedad "idCuadro"
     * @return El identificador del cuadro
     */
    public int getPvEidCuadro() {
        return pvEidCuadro;
    }

    /**
     * Método que permite asignar el valor de la propiedad "idCuadro"
     * @param pvEidCuadro the pvEidCuadro to set
     */
    public void setPvEidCuadro(int pvEidCuadro) {
        this.pvEidCuadro = pvEidCuadro;
    }

    /**
     * Método que permite obtener el valor de la propiedad "nombre"
     * @return El nombre del cuadro
     */
    public String getPvCnombre() {
        return pvCnombre;
    }

    /**
     *  Método que permite asignar el valor de la propiedad "nombre"
     * @param pvCnombre the pvCnombre to set
     */
    public void setPvCnombre(String pvCnombre) {
        this.pvCnombre = pvCnombre;
    }

    /**
    * Método que permite obtener el valor de la propiedad "borrado"
    * @return Valor numérico 1 o 0, el 1 corresponde a cuando el objeto no ha sido eliminado y permanece activo, de otro modo el 0 representa que se ha eliminado
    */
    public int getPvEborrado() {
        return pvEborrado;
    }

    /**
     * Este método permite asignar un valor entero, el modificar la propiedad "borrado" equivale a decidir si el objeto es activo o inactivo, o bien fue eliminado o no.
     * @param pvEborrado Se recibe el valor de borrado 1 o 0.
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
    * Este método nos permite imprimir la información de un objeto de la clase "CCuadros" no devuelve nada asi que solo basta llamarlo para que muestre la información.
    */ 
    public String desp() 
    {
        return "\nId de cuadro = " + pvEidCuadro
            + "\nNombre del cuadro = " + pvCnombre + "\n"+
            "*******************************";
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
}