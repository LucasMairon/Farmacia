package br.com.farmacia.models.entidade;

public abstract class Pessoa {
    private String nome;
    private String cpf;
    private String sexo;
    private String telefone;
    private String email;
    private String nascimento;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String numeroDaCasa;
    private String complemento;

    public Pessoa(){}

    public Pessoa (String nome, String cpf, String sexo,String telefone, String email, String nascimento, String estado, String cidade, String bairro, String rua, String numeroDaCasa, String complemento){
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.telefone = telefone;
        this.email = email;
        this.nascimento = nascimento;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numeroDaCasa = numeroDaCasa;
        this.complemento = complemento;
    }

    
    public static void editarPessoa(int id){}
    

    public static void deletarPessoa(int id){}


    public static void listarPessoa(){}
    

    public static void visualizarPessoa(int Id){}


    @Override
    public String toString() {
        return "nome: " + this.nome + "\ncpf: " + cpf + "\nsexo: " + sexo + "\ntelefone: " + telefone + "\nemail: " + email + "\nnascimento: " + nascimento + "\nestado: " + estado + "\ncidade: " + cidade + "\nbairro: " + bairro + "\nrua: " + rua + "\nnumeroDaCasa: " + numeroDaCasa + "\ncomplemento: " + complemento;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getCpf() {
        return cpf;
    }


    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public String getSexo() {
        return sexo;
    }


    public void setSexo(String sexo) {
        this.sexo = sexo;
    }


    public String getTelefone() {
        return telefone;
    }


    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getNascimento() {
        return nascimento;
    }


    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }


    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }


    public String getCidade() {
        return cidade;
    }


    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    public String getBairro() {
        return bairro;
    }


    public void setBairro(String bairro) {
        this.bairro = bairro;
    }


    public String getRua() {
        return rua;
    }


    public void setRua(String rua) {
        this.rua = rua;
    }


    public String getNumeroDaCasa() {
        return numeroDaCasa;
    }


    public void setNumeroDaCasa(String numeroDaCasa) {
        this.numeroDaCasa = numeroDaCasa;
    }


    public String getComplemento() {
        return complemento;
    }


    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    
}

