/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;
import Negocio.Psicologo;
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
public class PsicologoDAO implements IPsicologoDAO {
    private Connection connection;
    
    public PsicologoDAO(){
    this.connection = new ConFactory().getConnection();
    }
    @Override
    public void adiciona(Psicologo psicologo){
        String sql = "insert into psicologo"+"(nome,cpf, crp, telefone,login,senha)"+
                "values (?,?,?,?,?,?) ";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1,psicologo.getNome());
            stmt.setString(2,psicologo.getCpf());
            stmt.setString(3,psicologo.getCrp());
            stmt.setString(4,psicologo.getTelefone());
            stmt.setString(5,psicologo.getLogin());
            stmt.setString(6,psicologo.getSenha());
            
            stmt.execute();
            stmt.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
            
        }
    
    }
    
    public Psicologo autenticar(String login, String senha) {
    
        String sql = "SELECT idPsicologo, nome FROM psicologo WHERE login = ? AND senha = ?";
        Psicologo psicologo = null;
    
        try (java.sql.PreparedStatement stmt = connection.prepareStatement(sql)) {
        
            stmt.setString(1, login);
            stmt.setString(2, senha);
        
            try (java.sql.ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    psicologo = new Psicologo();
                    psicologo.setIdpsicologo(rs.getInt("idPsicologo"));
                    psicologo.setNome(rs.getString("nome"));
                }
            }
        } catch (java.sql.SQLException e) {
        throw new RuntimeException("Erro de autenticação: " + e.getMessage(), e);
        }
        return psicologo; // Retorna o objeto (sucesso) ou null (falha)
    }
        @Override
    public void altera(Psicologo psicologo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Psicologo> listarTodos() {
        try {
            List<Psicologo> psicologos = new ArrayList<Psicologo>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from psicologo");
            java.sql.ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
            // criando o objeto Contato
               Psicologo psicologo = new Psicologo();
               psicologo.setIdpsicologo(rs.getInt("idpsicologo"));
               psicologo.setNome(rs.getString("nome"));
               psicologo.setCpf(rs.getString("cpf"));
               psicologo.setCrp(rs.getString("crp"));
               psicologo.setTelefone(rs.getString("telefone"));
               psicologo.setLogin(rs.getString("login"));
               psicologo.setSenha(rs.getString("senha"));

            // adicionando o objeto à lista
               psicologos.add(psicologo);
        }

        rs.close();
        stmt.close();
        return psicologos;
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
 // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Psicologo getByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}           
    

