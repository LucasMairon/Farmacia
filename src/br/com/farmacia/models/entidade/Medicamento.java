package br.com.farmacia.models.entidade;

/**
 * Medicamento
 */
public class Medicamento {
    private int idMedicamento;
    private String nome;
    private String descricao;
    private double preco;


    public Medicamento() {
    }

    public Medicamento(String nome, String descricao, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void editarMedicamento(String nome, String descricao, double preco) {
        if (nome != null)
            this.nome = nome;
        if (descricao != null)
            this.descricao = descricao;
        if (preco >= 0)
            this.preco = preco;
    }

    @Override
    public String toString() {
        return "Medicamento:" + '\n' +
                "\tidMedicamento: " + idMedicamento + '\n' +
                "\tnome: " + nome + '\n' +
                "\tdescricao: " + descricao + '\n' +
                "\tpreco: " + preco + '\n';
    }
}