/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.AgendaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author benja
 */
public class AgendaDAOImplSql implements AgendaDAO{
    
    private ConexionSql conexion = null;
    
    public AgendaDAOImplSql() {
        conexion = ConexionSql.getInstancia();
    }
    
    @Override
    public List<AgendaDTO> listarAgenda(String mecanicoNombre, String estadoTurno) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        List<AgendaDTO> listaAgenda = new ArrayList<>();

        try {
            con = conexion.getConnection();
            String sql = "select * "
                         + "from agendas where estado = ? and mecanico = ?";
            
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, estadoTurno);
            sentencia.setString(2, mecanicoNombre);
            
            rs = sentencia.executeQuery();

            String dia;
            String horario;
            String mecanico;
            String estado;
            AgendaDTO agenda;

            while (rs.next()) {
                dia = rs.getString("dia");
                horario = rs.getString("horario");
                mecanico = rs.getString("mecanico");
                estado = rs.getString("estado");
                agenda = new AgendaDTO(dia, horario, mecanico, estado);
                listaAgenda.add(agenda);
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
        return listaAgenda;
    }

    @Override
    public void cerrarConexion() {
        conexion.desconectar();
    }

    @Override
    public List<AgendaDTO> listarAgendaPorFecha(String mecanicoNombre, String estadoTurno, String fecha) {
        Connection con = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        List<AgendaDTO> listaAgenda = new ArrayList<>();

        try {
            con = conexion.getConnection();
            String sql = "select * from agendas where estado = ? and mecanico = ?"
                    + " and dia = ?";
            
            sentencia = con.prepareStatement(sql);
            sentencia.setString(1, estadoTurno);
            sentencia.setString(2, mecanicoNombre);
            sentencia.setString(3, fecha);
            
            rs = sentencia.executeQuery();

            String dia;
            String horario;
            String mecanico;
            String estado;
            AgendaDTO agenda;

            while (rs.next()) {
                dia = rs.getString("dia");
                horario = rs.getString("horario");
                mecanico = rs.getString("mecanico");
                estado = rs.getString("estado");
                agenda = new AgendaDTO(dia, horario, mecanico, estado);
                listaAgenda.add(agenda);
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
        return listaAgenda;
    }
}
