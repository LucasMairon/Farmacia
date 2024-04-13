package br.com.farmacia.classes;

import java.util.ArrayList;

public class Cliente extends Pessoa{
    private int idCliente;
    private ArrayList<Pessoa> pessoas = new ArrayList<>();

    public Cliente(String nome, String cpf, char sexo,String telefone, String email, String nascimento, String estado, String cidade, String bairro, String rua, String numeroDaCasa, String complemento, int idCliente){
        super(nome, cpf, sexo, telefone, email, nascimento, estado, cidade, bairro, rua, numeroDaCasa, complemento);
        this.idCliente = idCliente;
    }

    public static Cliente criarCliente(String nome, String cpf, char sexo,String telefone, String email, String nascimento, String estado, String cidade, String bairro, String rua, String numeroDaCasa, String complemento, int idCliente){
        return new Cliente(nome, cpf, sexo, telefone, email, nascimento, estado, cidade, bairro, rua, numeroDaCasa, complemento, idCliente);
    }

    public void editarPessoa(){

    }

    public void listarPessoa(){

    }

    public void deletarPessoa(int id){
        for (Pessoa pessoa : pessoas) {
            if(pessoa.getIdCliente == id){
                System.out.println("Pessoa Encontrada!");
                pessoas.remove(pessoa);
            }
            else{
                System.out.println("Nao Encontrado");
            }
        }  
    }

    public  void vizualizarPessoa(){

    }
    
    public int getIdCliente(){
        return idCliente;
    }
}

