package br.com.farmacia.classes.Pedido;

import java.util.ArrayList;

/**
 * Medicamento
 */
public class Medicamento {
        private int idMedicamento;
    private String nome;
    private String descricao;
    private double preco;
    private ArrayList<Lote> lotes;

    public Medicamento(){}
    
    public Medicamento(String nome, String descricao, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.lotes = new ArrayList<Lote>();
    }

    public Medicamento(String nome, String descricao, double preco, ArrayList<Lote> lotes) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.lotes = lotes;
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

    public ArrayList<Lote> getLotes() {
        return lotes;
    }

    public void setLotes(ArrayList<Lote> lotes) {
        this.lotes = lotes;
    }

    @Override
    public String toString() {
        return "Medicamento:" + '\n' +
                "\tidMedicamento: " + idMedicamento + '\n' +
                "\tnome: " + nome + '\n' +
                "\tdescricao: " + descricao + '\n' +
                "\tpreco: " + preco + '\n' +
                "\tlotes: \n\n" + lotes;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Medicamento other = (Medicamento) obj;
        if (idMedicamento != other.idMedicamento)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idMedicamento;
        return result;
    }
}