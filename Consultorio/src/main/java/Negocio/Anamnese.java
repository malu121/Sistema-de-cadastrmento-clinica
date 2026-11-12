/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author Maria Luiza
 */
/**
 * Representa o registro de Anamnese (Histórico Clínico) de um paciente.
 */
public class Anamnese {
    // Atributos
    private int idAnamnese; // INT
    private String queixas; // TEXT
    private String sintomas; // TEXT
    private String tratamentos_anteriores; // TEXT
    private String medicamentos; // TEXT
    private String infancia; // TEXT
    private String rotina; // TEXT
    private String vicios; // TEXT
    private String hobbies; // TEXT
    private String trabalho; // TEXT
    private String historico_familiar; // TEXT
    private String comportamento; // TEXT
    private String linguagem; // TEXT
    private String humor; // TEXT
    private String hipotese_diagnostica; // TEXT
    private String observacoes; // TEXT
    private int numero_sessoes; // INT
    private double valor_sessao; // DECIMAL
    private String periodicidade; // VARCHAR(20)
    
    // Chaves estrangeiras (Foreign Keys)
    private int idPaciente; // INT
    private int idPsicologo; // INT

    // --- Construtores ---
    
    /**
     * Construtor Padrão (Sem Argumentos).
     */
    public Anamnese() {
        // Inicialização padrão
    }

    /**
     * Construtor Parametrizado (Para inicializar todos os campos, útil na leitura do BD).
     */
    public Anamnese(int idAnamnese, String queixas, String sintomas, String tratamentos_anteriores, 
                    String medicamentos, String infancia, String rotina, String vicios, 
                    String hobbies, String trabalho, String historico_familiar, 
                    String comportamento, String linguagem, String humor, 
                    String hipotese_diagnostica, String observacoes, int numero_sessoes, 
                    double valor_sessao, String periodicidade, int idPaciente, int idPsicologo) {
        
        this.idAnamnese = idAnamnese;
        this.queixas = queixas;
        this.sintomas = sintomas;
        this.tratamentos_anteriores = tratamentos_anteriores;
        this.medicamentos = medicamentos;
        this.infancia = infancia;
        this.rotina = rotina;
        this.vicios = vicios;
        this.hobbies = hobbies;
        this.trabalho = trabalho;
        this.historico_familiar = historico_familiar;
        this.comportamento = comportamento;
        this.linguagem = linguagem;
        this.humor = humor;
        this.hipotese_diagnostica = hipotese_diagnostica;
        this.observacoes = observacoes;
        this.numero_sessoes = numero_sessoes;
        this.valor_sessao = valor_sessao;
        this.periodicidade = periodicidade;
        this.idPaciente = idPaciente;
        this.idPsicologo = idPsicologo;
    }

    // --- Métodos Getters e Setters ---

    // idAnamnese
    public int getIdAnamnese() {
        return idAnamnese;
    }
    public void setIdAnamnese(int idAnamnese) {
        this.idAnamnese = idAnamnese;
    }

    // queixas
    public String getQueixas() {
        return queixas;
    }
    public void setQueixas(String queixas) {
        this.queixas = queixas;
    }

    // sintomas
    public String getSintomas() {
        return sintomas;
    }
    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    // tratamentos_anteriores
    public String getTratamentos_anteriores() {
        return tratamentos_anteriores;
    }
    public void setTratamentos_anteriores(String tratamentos_anteriores) {
        this.tratamentos_anteriores = tratamentos_anteriores;
    }

    // medicamentos
    public String getMedicamentos() {
        return medicamentos;
    }
    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    // infancia
    public String getInfancia() {
        return infancia;
    }
    public void setInfancia(String infancia) {
        this.infancia = infancia;
    }

    // rotina
    public String getRotina() {
        return rotina;
    }
    public void setRotina(String rotina) {
        this.rotina = rotina;
    }

    // vicios
    public String getVicios() {
        return vicios;
    }
    public void setVicios(String vicios) {
        this.vicios = vicios;
    }

    // hobbies
    public String getHobbies() {
        return hobbies;
    }
    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    // trabalho
    public String getTrabalho() {
        return trabalho;
    }
    public void setTrabalho(String trabalho) {
        this.trabalho = trabalho;
    }

    // historico_familiar
    public String getHistorico_familiar() {
        return historico_familiar;
    }
    public void setHistorico_familiar(String historico_familiar) {
        this.historico_familiar = historico_familiar;
    }

    // comportamento
    public String getComportamento() {
        return comportamento;
    }
    public void setComportamento(String comportamento) {
        this.comportamento = comportamento;
    }

    // linguagem
    public String getLinguagem() {
        return linguagem;
    }
    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }

    // humor
    public String getHumor() {
        return humor;
    }
    public void setHumor(String humor) {
        this.humor = humor;
    }

    // hipotese_diagnostica
    public String getHipotese_diagnostica() {
        return hipotese_diagnostica;
    }
    public void setHipotese_diagnostica(String hipotese_diagnostica) {
        this.hipotese_diagnostica = hipotese_diagnostica;
    }

    // observacoes
    public String getObservacoes() {
        return observacoes;
    }
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    // numero_sessoes
    public int getNumero_sessoes() {
        return numero_sessoes;
    }
    public void setNumero_sessoes(int numero_sessoes) {
        this.numero_sessoes = numero_sessoes;
    }

    // valor_sessao
    public double getValor_sessao() {
        return valor_sessao;
    }
    public void setValor_sessao(double valor_sessao) {
        this.valor_sessao = valor_sessao;
    }

    // periodicidade
    public String getPeriodicidade() {
        return periodicidade;
    }
    public void setPeriodicidade(String periodicidade) {
        this.periodicidade = periodicidade;
    }
    
    // idPaciente (Chave Estrangeira)
    public int getIdPaciente() {
        return idPaciente;
    }
    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    // idPsicologo (Chave Estrangeira)
    public int getIdPsicologo() {
        return idPsicologo;
    }
    public void setIdPsicologo(int idPsicologo) {
        this.idPsicologo = idPsicologo;
    }
}
    

