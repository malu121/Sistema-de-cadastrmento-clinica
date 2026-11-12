/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;
import Negocio.Anamnese;
import java.util.List;

/**
 *
 * @author Maria Luiza
 */
public interface IAnamneseDAO {
    public void adiciona(Anamnese Anamnese);
    public void altera(Anamnese anamnese);
    public void remove(int id);
    public List<Anamnese> listarTodos();
    public Anamnese getByID(int id);
    
}
