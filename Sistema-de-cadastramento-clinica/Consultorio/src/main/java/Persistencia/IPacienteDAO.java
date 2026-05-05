/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;
import Negocio.Paciente;
import java.util.List;

/**
 *
 * @author Maria Luiza
 */
public interface IPacienteDAO {
    public void adiciona(Paciente paciente);
    public void altera(Paciente paciente);
    public void remove(int id);
    public List<Paciente> listarTodos();
    public Paciente getByID(int id);
    
    
}
