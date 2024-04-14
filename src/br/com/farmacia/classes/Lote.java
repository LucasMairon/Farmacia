package br.com.farmacia.classes.Pedido;

public class Lote {
    private int idLote;
    private int quantidadeEmEstoque;
    private String validade;
    private String fabricacao;
    private String loteCodigo;

    public Lote(){}

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

    public void deletar(){}

    public boolean aindaEstaValido() {
        // Todo: fazer a lógica pra saber se o Lote do medicamento ainda está válido.
        return true;
    }

    public Lote retirarLote(int quantidadeDoMedicamento) {
        this.quantidadeEmEstoque -= quantidadeDoMedicamento;
        return new Lote(quantidadeDoMedicamento, validade, fabricacao, loteCodigo);
    }

    public void acrecentarQuantidadeDoMedicamento(int quantidadeDoMedicamento) {
        this.quantidadeEmEstoque += quantidadeDoMedicamento;
    }

    public static Lote buscarLote(ArrayList<Lote> lotes, int idLote) {
        for (Lote lote : lotes)
            if (lote.idLote == idLote)
                return lote;
        return null;
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

    public void visualizar() {
         System.out.println(this);
    }

    @Override
    public String toString() {
        return "Lote:" + '\n' +
                "\tidMedicamento: " + idLote + '\n' +
                "\tcodigo do lote: " + loteCodigo + '\n' +
                "\tquantidade em estoque: " + quantidadeEmEstoque + '\n' +
                "\tfavricação: " + fabricacao + '\n' +
                "\tvalidade: " + validade;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Lote other = (Lote) obj;
        if (loteCodigo != other.loteCodigo)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idLote;
        return result;
    }

}
