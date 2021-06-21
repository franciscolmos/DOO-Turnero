/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.EspecialidadDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author francisco
 */
public class EspecialidadDAOImpSql implements EspecialidadDAO {
    private ConexionSql conexion = null;

    public EspecialidadDAOImpSql() {
        conexion = ConexionSql.getInstancia();
    }
    
    @Override
    public List<EspecialidadDTO> listarEspecialidades() {
        Connection con = null;
        Statement sentencia = null;
        ResultSet rs = null;
        List<EspecialidadDTO> listaEspecialidades = new ArrayList<>();

        try {
            con = conexion.getConnection();
            String sql = "select * "
                         + "from especialidades";
            sentencia = con.createStatement();

            rs = sentencia.executeQuery(sql);

            String codigo;
            String nombre;
            String descripcion;
            EspecialidadDTO especialidad;

            while (rs.next()) {
                codigo = rs.getString("codigo");
                nombre = rs.getString("nombre");
                descripcion = rs.getString("descripcion");
                especialidad = new EspecialidadDTO(codigo, nombre, descripcion);
                listaEspecialidades.add(especialidad);
            }

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                rs.close();
                sentencia.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        return listaEspecialidades;
    }

    @Override
    public void cerrarConexion() {
        conexion.desconectar();
    }
}
