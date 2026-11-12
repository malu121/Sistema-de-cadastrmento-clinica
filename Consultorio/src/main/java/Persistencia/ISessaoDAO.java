/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;
import Negocio.Sessao;
import java.util.List;

/**
 *
 * @author Maria Luiza
 */
public interface ISessaoDAO {
    public void adiciona(Sessao sessao);
    public void altera(Sessao sessao);
    public void remove(int id);
    public List<Sessao> listarTodos();
    public Sessao getByID(int id);
    
}
