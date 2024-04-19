package br.com.farmacia.models.entidade;

public class Lote {
    private int idLote;
    private int quantidadeEmEstoque;
    private String validade;
    private String fabricacao;
    private String loteCodigo;

    public Lote() {
    }

    public Lote(int quantidadeEmEstoque, String validade, String fabricacao, String loteCodigo) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.validade = validade;
        this.fabricacao = fabricacao;
        this.loteCodigo = loteCodigo;
    }

    public int getIdLote() {
        return idLote;
    }

    public void setIdLote(int idLote) {
        this.idLote = idLote;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getFabricacao() {
        return fabricacao;
    }

    public void setFabricacao(String fabricacao) {
        this.fabricacao = fabricacao;
    }

    public String getLoteCodigo() {
        return loteCodigo;
    }

    public void setLoteCodigo(String loteCodigo) {
        this.loteCodigo = loteCodigo;
    }

    public void editarLote(String loteCodigo, int quantidadeEmEstoque, String fabricacao, String validade) {
        if (loteCodigo != null)
            this.loteCodigo = loteCodigo;
        if (quantidadeEmEstoque >= 0)
            this.quantidadeEmEstoque = quantidadeEmEstoque;
        if (fabricacao != null)
            this.fabricacao = fabricacao;
        if (validade != null)
            this.validade = validade;
    }

    @Override
    public String toString() {
        return "Lote:" + '\n' +
                "\tId do lote: " + idLote + '\n' +
                "\tCódigo do lote: " + loteCodigo + '\n' +
                "\tQuantidade em estoque: " + quantidadeEmEstoque + '\n' +
                "\tFabricação: " + fabricacao + '\n' +
                "\tValidade: " + validade + '\n';
    }
}
