package br.com.farmacia.classes;


public abstract class Pessoa {
    private String nome;
    private String cpf;
    private char sexo;
    private String telefone;
    private String email;
    private String nascimento;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String numeroDaCasa;
    private String complemento;
    public int getIdCliente;


    public Pessoa (String nome, String cpf, char sexo,String telefone, String email, String nascimento, String estado, String cidade, String bairro, String rua, String numeroDaCasa, String complemento){
        this.nome = nome;
        this.cpf = cpf;
        this.sexo =sexo;
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

    
    public abstract void editarPessoa();
    
    public abstract void deletarPessoa(int id);

    public abstract void listarPessoa();
    

    public abstract void vizualizarPessoa();
}
