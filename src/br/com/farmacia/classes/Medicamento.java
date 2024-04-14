package br.com.farmacia.classes;

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

    public void deletar(){}

    public void editar(String nome, String descricao, double preco) {
        if (nome != null)
            this.nome = nome;
        if (descricao != null)
            this.descricao = descricao;
        if (preco >= 0)
            this.preco = preco;
    }

    public static void listar(ArrayList<Medicamento> meds) {

        for (Medicamento med : meds) {
            med.visualizar();
            System.out.println();
        }
    }

    public static Medicamento buscarMedicamento(ArrayList<Medicamento> meds, int idMedicamento) {
        for (Medicamento medicamento : meds)
            if (medicamento.idMedicamento == idMedicamento)
                return medicamento;
        return null;
    }

    public int quantidadeDeMedicamentosValidosEmEstoque() {
        int quantidadeDeMedicamentos = 0;
        for (Lote lote : lotes)
            if (lote.aindaEstaValido())
                quantidadeDeMedicamentos += lote.getQuantidadeEmEstoque();
        return quantidadeDeMedicamentos;
    }

    public Medicamento retirarMedicamento(int quantidadeDoMedicamento) {

        if (quantidadeDeMedicamentosValidosEmEstoque() < quantidadeDoMedicamento)
            return null;

        ArrayList<Lote> novosLotes = new ArrayList<Lote>();

        int quantidadeEmEstoque = 0;
        Lote lote = null;

        for (int i = 0; i < lotes.size() && quantidadeDoMedicamento > 0; i++) {
            quantidadeEmEstoque = lotes.get(i).getQuantidadeEmEstoque();
            if (quantidadeDoMedicamento >= quantidadeEmEstoque) {
                quantidadeDoMedicamento -= quantidadeEmEstoque;
                novosLotes.add(lotes.remove(i));
            } else {
                lote = lotes.get(i);
                novosLotes.add(lote.retirarLote(quantidadeDoMedicamento));
            }
        }

        Medicamento novoMedicamento = new Medicamento(nome, descricao, preco, novosLotes);
        novoMedicamento.idMedicamento = idMedicamento;
        return novoMedicamento;
    }

    public void adicionarLoteAoMedicamento(ArrayList<Lote> lotes) {
        for (Lote lote : lotes)
            adicionarLoteAoMedicamento(lote);
    }

    public void adicionarLoteAoMedicamento(Lote lote) {
        int indexDoLote = this.lotes.indexOf(lote);
        if (indexDoLote >= 0) {
            lotes.get(indexDoLote).acrecentarQuantidadeDoMedicamento(lote.getQuantidadeEmEstoque());
        } else {
            this.lotes.add(lote);
        }
    }

    public void visualizar() {
        System.out.println("Medicamento: ");
        System.out.println("\tId: " + idMedicamento);
        System.out.println("\tNome: " + nome);
        System.out.println("\tDescrição: " + descricao);
        System.out.println("\tPreço: " + preco);
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