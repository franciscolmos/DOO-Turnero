/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author agustin
 */
public abstract class Modelo {
    /***
    * Si no les gusta este factory de modelos usando reflection
    * pueden utilizar el que se hace con un switch
    * @param nombreClaseModelo
    * @return 
    */ 
    public static Modelo fabricarModelo(String nombreClaseModelo) {
        Modelo modelo = null;
        try {            
            modelo = (Modelo) Class.forName(Modelo.class.getPackageName() + "." + nombreClaseModelo).getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            System.err.println(e);
        }
        return modelo;
   } 
}
