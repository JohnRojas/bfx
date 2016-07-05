/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bfx.controladores;

import java.util.ArrayList;

/**
 *
 * @author Anonimus
 */
public class CMayusculasPalabra
{

    public static String cambiaMayuscula(String cadena)
    {
        char[] caracteres = cadena.toCharArray();

        caracteres[0] = Character.toUpperCase(caracteres[0]);

        // el -2 es para evitar una excepción al caernos del arreglo
        for (int i = 0; i < cadena.length() - 2; i++)
        // Es 'palabra'
        {
            if (caracteres[i] == ' ' || caracteres[i] == '.' || caracteres[i] == ',')
            // Reemplazamos
            {
                caracteres[i + 1] = Character.toUpperCase(caracteres[i + 1]);
            }
        }
        System.out.println(caracteres);
        String cadena1=String.valueOf(caracteres);
        return cadena1;
    }
}
