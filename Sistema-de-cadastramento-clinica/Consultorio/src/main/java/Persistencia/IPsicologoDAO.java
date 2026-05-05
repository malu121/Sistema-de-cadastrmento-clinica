/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;
import Negocio.Psicologo;
import java.util.List;

/**
 *
 * @author Maria Luiza
 */
public interface IPsicologoDAO {
    public void adiciona(Psicologo psicologo);
    public void altera(Psicologo psicologo);
    public void remove(int id);
    public List<Psicologo> listarTodos();
    public Psicologo getByID(int id);
    
}
