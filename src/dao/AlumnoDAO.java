/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import dto.AlumnoDTO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author agustin
 */
public interface AlumnoDAO {
    
     AlumnoDTO buscarAlumno(String nombre, String apellido);
     
     AlumnoDTO buscarAlumno(int legajo);
    
     List<AlumnoDTO> listarAlumnosPorCriterio(String nombre, String apellido);
     
     List<AlumnoDTO> listarAlumnos();
     
     boolean insertarAlumno(String apellido, String nombre, Date fechaNacimiento, String sexo);
     
     boolean modificarAlumno(int legajo, String apellido, String nombre, Date fechaNacimiento, String sexo);
     
     boolean borrarAlumno(int legajo);
     
     void cerrarConexion();
    
}
