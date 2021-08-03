/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author agustin
 */
public abstract class FabricaDAO {
    
    public abstract TurnoDAO getTurnoDao();
    
    public abstract VehiculoDAO getVehiculoDao();
    
    public abstract TitularDAO getTitularDao();
    
    public abstract MecanicoDAO getMecanicoDao();
    
    public abstract CompaniaDAO getCompaniaDao();
    
    public abstract EspecialidadDAO getEspecialidadDAO();

    public abstract AgendaDAO getAgendaDao();
    
    public abstract FichaMecanicaDAO getFichaMecanicaDao();
    
    public static FabricaDAO getFactory(String nombreClase){
        try {            
            return (FabricaDAO) Class.forName(FabricaDAO.class.getPackageName() + "." + nombreClase).getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            System.err.println(e);
            throw new IllegalArgumentException();
        }
    }
}
