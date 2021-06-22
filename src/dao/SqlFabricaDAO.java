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
    public TurnoDAO getTurnoDao() {
        return new TurnoDAOImplSql();
    }

    @Override
    public VehiculoDAO getVehiculoDao() {
        return new VehiculoDAOImplSql();
    }

    @Override
    public TitularDAO getTitularDao() {
        return new TitularDAOImplSql();
     }

    @Override
    public MecanicoDAO getMecanicoDao() {
        return new MecanicoDAOImplSql();
    }

    @Override
    public CompaniaDAO getCompaniaDao() {
        return new CompaniaDAOImplSql();
    }

    @Override
    public EspecialidadDAO getEspecialidadDAO() {
        return new EspecialidadDAOImpSql();
    }
    
    @Override
    public AgendaDAO getAgendaDao(){
        return new AgendaDAOImplSql();
    }
}
