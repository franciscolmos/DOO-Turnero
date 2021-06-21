/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author agustin
 */
public class SqlFabricaDAO extends FabricaDAO {

    @Override
    public AlumnoDAO getAlumnoDao() {
        return new AlumnoDAOImplSql();
    }

    @Override
    public TurnoDAO getTurnoDao() {
        return new TurnoDAOImplSql();
    }

    @Override
    public VehiculoDAO getVehiculoDao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TitularDAO getTitularDao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MecanicoDAO getMecanicoDao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CompaniaDAO getCompaniaDao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
