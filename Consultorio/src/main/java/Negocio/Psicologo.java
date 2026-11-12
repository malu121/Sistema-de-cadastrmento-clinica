/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;



/**
 *
 * @author Maria Luiza
 */
public class Psicologo {
    //Atributos
    private int idpsicologo;
    private String nome;
    private String cpf;
    private String crp;
    private String telefone;
    private String login;
    private String senha;
    
    public Psicologo() {
        // Inicialização padrão: os atributos são inicializados com valores default (0 para int, null para String)
    }

    /**
     * Construtor Parametrizado.
     * Útil para instanciar e inicializar todos os atributos de uma vez (ex: ao recuperar dados do MySQL).
     */
    public Psicologo(int idpsicologo, String nome, String cpf, String crp, 
                     String telefone, String login, String senha) {
        this.idpsicologo = idpsicologo;
        this.nome = nome;
        this.cpf = cpf;
        this.crp = crp;
        this.telefone = telefone;
        this.login = login;
        this.senha = senha;
    }

    // --- Métodos Getters e Setters ---
    
    // idpsicologo
    public int getIdpsicologo() {
        return idpsicologo;
    }
    public void setIdpsicologo(int idpsicologo) {
        this.idpsicologo = idpsicologo;
    }

    // nome
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    // cpf
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // crp
    public String getCrp() {
        return crp;
    }
    public void setCrp(String crp) {
        this.crp = crp;
    }

    // telefone
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // login
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    // senha
    public String getSenha() {
        // ATENÇÃO: Em sistemas reais, você NUNCA deve retornar a senha diretamente.
        // O ideal é usar criptografia e hashs (ex: MD5, SHA-256). 
        return senha;
    }
    public void setSenha(String senha) {
        // ATENÇÃO: Em sistemas reais, a senha deve ser hasheada antes de ser salva.
        this.senha = senha;
    }
}
