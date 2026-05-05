/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;
import java.util.Calendar;

/**
 *
 * @author Maria Luiza
 */
public class Paciente {
    //Atributos
    private int idPaciente;
    private String nome;
    private String cpf;
    private Calendar data_nascimento;
    private String sexo;
    private String endereco;
    private String telefone;
    private String foto;
    private String plano_saude;
    private String observacoes;
    private Calendar data_cadastro;
    
    public Paciente() {
        // Inicialização padrão ou vazia
    }

    // --- Construtor Parametrizado (Exemplo com todos os atributos) ---
    public Paciente(int idPaciente, String nome, String cpf, Calendar data_nascimento, 
                    String sexo, String endereco, String telefone, String foto, 
                    String plano_saude, String observacoes, Calendar data_cadastro) {
        this.idPaciente = idPaciente;
        this.nome = nome;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.sexo = sexo;
        this.endereco = endereco;
        this.telefone = telefone;
        this.foto = foto;
        this.plano_saude = plano_saude;
        this.observacoes = observacoes;
        this.data_cadastro = data_cadastro;
    
    }
    public int getIdPaciente(){
        return idPaciente;
    }
    public void setIdPaciente(int idPaciente){
        this.idPaciente = idPaciente;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String novoNome){
        this.nome = novoNome;
    }
    
    public String getCpf(){
        return cpf;
    }
    
    public void setCpf(String novocpf){
        this.cpf = novocpf;
    }
    
    public Calendar getData_nascimento(){
        return data_nascimento;
    }
    public void setData_nascimento(Calendar data_nascimento){
        this.data_nascimento = data_nascimento;
    }
    public String getSexo(){
        return sexo;
    }            
    public void setSexo(String sexo){
        this.sexo = sexo;
  
    }
    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String novoEndereco){
        this.endereco= novoEndereco;
    }
    public String getTelefone(){
        return telefone;
    }
    public void setTelefone(String novoTelefone){
        this.telefone = novoTelefone;
    }
    // foto
    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }

    // plano_saude
    public String getPlano_saude() {
        return plano_saude;
    }
    public void setPlano_saude(String plano_saude) {
        this.plano_saude = plano_saude;
    }

    // observacoes
    public String getObservacoes() {
        return observacoes;
    }
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    // data_cadastro
    public Calendar getData_cadastro() {
        return data_cadastro;
    }
    public void setData_cadastro(Calendar data_cadastro) {
        this.data_cadastro = data_cadastro;
    }
}
    

    

