/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfx.clases;

import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class CCuadrosRegiones
{
    private CCuadros objCCuadrosCargaCuadros1;
    private ArrayList<CRegiones> pvAregiones;

    public CCuadrosRegiones(CCuadros objCCuadrosCargaCuadros2, ArrayList<CRegiones> lALregiones)
    {
        this.objCCuadrosCargaCuadros1 = objCCuadrosCargaCuadros2;
        this.pvAregiones = lALregiones;
    }

    /**
     * @return the objCCuadrosCargaCuadros1
     */
    public CCuadros getObjCCuadrosCargaCuadros1() {
        return objCCuadrosCargaCuadros1;
    }

    /**
     * @param objCCuadrosCargaCuadros1 the objCCuadrosCargaCuadros1 to set
     */
    public void setObjCCuadrosCargaCuadros1(CCuadros objCCuadrosCargaCuadros1) {
        this.objCCuadrosCargaCuadros1 = objCCuadrosCargaCuadros1;
    }

    /**
     * @return the pvAregiones
     */
    public ArrayList<CRegiones> getPvAregiones() {
        return pvAregiones;
    }

    /**
     * @param pvAregiones the pvAregiones to set
     */
    public void setPvAregiones(ArrayList<CRegiones> pvAregiones) {
        this.pvAregiones = pvAregiones;
    }
    
    
    
}
