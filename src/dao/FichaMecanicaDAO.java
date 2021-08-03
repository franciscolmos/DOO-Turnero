/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author felipe
 */
public interface FichaMecanicaDAO {
    
    public boolean insertarFicha(int legajoMecanico);
    
    public boolean registrarFichaMecanica(String nroFicha, String obs);
}
