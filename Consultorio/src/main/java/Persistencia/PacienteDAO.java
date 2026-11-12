/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Negocio.Paciente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;
import java.util.Calendar;
import java.util.ArrayList;




/**
 *
 * @author Maria Luiza
 */
public class PacienteDAO implements IPacienteDAO {
    private Connection connection;
    
    public PacienteDAO(){
    this.connection = new ConFactory().getConnection();
    }
    @Override
    public void adiciona(Paciente paciente){
        String sql = "insert into paciente"+"(nome,cpf,data_nascimento, sexo,endereco, telefone,foto,plano_saude,observacoes,data_cadastro)"+
                "values (?,?,?,? ,? ,? ,? ,? ,? ,now()) ";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1,paciente.getNome());
            stmt.setString(2,paciente.getCpf());
            stmt.setDate(3,new Date(paciente.getData_nascimento().getTimeInMillis()));
            stmt.setString(4,paciente.getSexo());
            stmt.setString(5,paciente.getEndereco());
            stmt.setString(6,paciente.getTelefone());
            stmt.setString(7,paciente.getFoto());
            stmt.setString(8,paciente.getPlano_saude());
            stmt.setString(9,paciente.getObservacoes());
            
            
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
            
        }
    }
    
    
    

    @Override
    public void altera(Paciente paciente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Paciente> listarTodos() {
        try {
            List<Paciente> pacientes = new ArrayList<Paciente>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from paciente");
            java.sql.ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
            // criando o objeto Contato (deveria ser Paciente)
                Paciente paciente = new Paciente();
                paciente.setIdPaciente(rs.getInt("idPaciente"));
                paciente.setNome(rs.getString("nome"));
                paciente.setCpf(rs.getString("cpf"));

            // montando a data através do Calendar
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("data_nascimento"));
                paciente.setData_nascimento(data);

                paciente.setSexo(rs.getString("sexo"));
                paciente.setEndereco(rs.getString("endereco"));
                paciente.setTelefone(rs.getString("telefone"));
                paciente.setFoto(rs.getString("foto"));
                paciente.setPlano_saude(rs.getString("plano_saude"));
                paciente.setObservacoes(rs.getString("observacoes"));
            
            // Reutilizando a variável 'data'
                data.setTime(rs.getDate("data_cadastro"));
                paciente.setData_cadastro(data);

            // adicionando o objeto à lista
                pacientes.add(paciente);
        }

        rs.close();
        stmt.close();
        return pacientes;
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    }

    @Override
    public Paciente getByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
    
}
