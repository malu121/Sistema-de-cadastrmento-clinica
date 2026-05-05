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
public class Sessao {
    private int idSessao; // INT
    private Calendar data; // DATETIME
    private String queixas_paciente; // TEXT
    private String plano_tratamento; // TEXT
    private String diagnostico_final; // TEXT
    private String resumo_sessao; // TEXT
    private int evolucao; // INT (Pode representar um código ou nível de evolução)
    private boolean pago; // BIT(1)
    
    // Chave estrangeira (Foreign Key)
    private int idAnamnese; // INT

    // --- Construtores ---
    
    /**
     * Construtor Padrão (Sem Argumentos).
     */
    public Sessao() {
        // Inicialização padrão
    }

    /**
     * Construtor Parametrizado.
     * Útil para instanciar e inicializar todos os atributos.
     */
    public Sessao(int idSessao, Calendar data, String queixas_paciente, String plano_tratamento, 
                  String diagnostico_final, String resumo_sessao, int evolucao, 
                  boolean pago, int idAnamnese) {
        
        this.idSessao = idSessao;
        this.data = data;
        this.queixas_paciente = queixas_paciente;
        this.plano_tratamento = plano_tratamento;
        this.diagnostico_final = diagnostico_final;
        this.resumo_sessao = resumo_sessao;
        this.evolucao = evolucao;
        this.pago = pago;
        this.idAnamnese = idAnamnese;
    }

    // --- Métodos Getters e Setters ---

    // idSessao
    public int getIdSessao() {
        return idSessao;
    }
    public void setIdSessao(int idSessao) {
        this.idSessao = idSessao;
    }

    // data
    public Calendar getData() {
        return data;
    }
    public void setData(Calendar data) {
        this.data = data;
    }

    // queixas_paciente
    public String getQueixas_paciente() {
        return queixas_paciente;
    }
    public void setQueixas_paciente(String queixas_paciente) {
        this.queixas_paciente = queixas_paciente;
    }

    // plano_tratamento
    public String getPlano_tratamento() {
        return plano_tratamento;
    }
    public void setPlano_tratamento(String plano_tratamento) {
        this.plano_tratamento = plano_tratamento;
    }

    // diagnostico_final
    public String getDiagnostico_final() {
        return diagnostico_final;
    }
    public void setDiagnostico_final(String diagnostico_final) {
        this.diagnostico_final = diagnostico_final;
    }

    // resumo_sessao
    public String getResumo_sessao() {
        return resumo_sessao;
    }
    public void setResumo_sessao(String resumo_sessao) {
        this.resumo_sessao = resumo_sessao;
    }

    // evolucao
    public int getEvolucao() {
        return evolucao;
    }
    public void setEvolucao(int evolucao) {
        this.evolucao = evolucao;
    }

    // pago (Usando 'is' para booleanos, que é a convenção Java)
    public boolean isPago() {
        return pago;
    }
    public void setPago(boolean pago) {
        this.pago = pago;
    }

    // idAnamnese (Chave Estrangeira)
    public int getIdAnamnese() {
        return idAnamnese;
    }
    public void setIdAnamnese(int idAnamnese) {
        this.idAnamnese = idAnamnese;
    }
}

