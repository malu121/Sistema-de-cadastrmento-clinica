/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Negocio.Sessao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Maria Luiza
 */
public class SessaoDAO implements ISessaoDAO {
    private Connection connection;
    
    public SessaoDAO(){
    this.connection = new ConFactory().getConnection();
    }
    @Override
    public void adiciona(Sessao sessao){
        String sql = "insert into sessao"+"(data,queixas_paciente,plano_tratamento,diagnostico_final,resumo_sessao,evolucao,pago)"+
                "values (?,?,?,? ,? ,?,?) ";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            long milissegundos = sessao.getData().getTimeInMillis();
            stmt.setTimestamp(1, new java.sql.Timestamp(milissegundos));
            stmt.setString(2,sessao.getQueixas_paciente());
            stmt.setString(3,sessao.getPlano_tratamento());
            stmt.setString(4,sessao.getDiagnostico_final());
            stmt.setString(5,sessao.getResumo_sessao());
            stmt.setInt(6,sessao.getEvolucao());
            stmt.setBoolean(7,sessao.isPago());
            
            
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
            
        }
    }
        @Override
    public void altera(Sessao sessao) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Sessao> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Sessao getByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
}
