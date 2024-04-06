package br.com.farmacia.classes;

public class Pessoa {
    String nome;
    String cpf;
    char sexo;
    String telefone;
    String email;
    String nascimento;
    String estado;
    String cidade;
    String bairro;
    String rua;
    String numeroDaCasa;
    String complemento;


    Pessoa (String nome, String cpf, char sexo,String telefone, String email, String nascimento, String estado, String cidade, String bairro, String rua, String numeroDaCasa, String complemento){
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

    public static Pessoa  criarpessoa(String nome, String cpf, char sexo,String telefone, String email, String nascimento, String estado, String cidade, String bairro, String rua, String numeroDaCasa, String complemento){
        return new Pessoa(nome, cpf, sexo, telefone, email, nascimento, estado, cidade, bairro, rua, numeroDaCasa, complemento);
    }
    public void editarPessoa(){
    }

    public void deletarPessoa(){
    }

    public void listarPessoa(){
    }

    public void vizualizarPessoa(){
    }
}
