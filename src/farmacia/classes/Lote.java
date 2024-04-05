package farmacia.classes;

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
        if (idLote != other.idLote)
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
