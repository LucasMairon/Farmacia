package br.com.farmacia.models.entidade;

import java.util.ArrayList;

public class Cliente extends Pessoa{
    private int idCliente;
    private static ArrayList<Cliente> clientes = new ArrayList<>();

    public Cliente(){
        super();
    }

    public Cliente(String nome, String cpf, String sexo,String telefone, String email, String nascimento, String estado, String cidade, String bairro, String rua, String numeroDaCasa, String complemento){
        super(nome, cpf, sexo, telefone, email, nascimento, estado, cidade, bairro, rua, numeroDaCasa, complemento);
    }

    public static Cliente criarCliente(String nome, String cpf, String sexo,String telefone, String email, String nascimento, String estado, String cidade, String bairro, String rua, String numeroDaCasa, String complemento){
        return new Cliente(nome, cpf, sexo, telefone, email, nascimento, estado, cidade, bairro, rua, numeroDaCasa, complemento);
    }

    public void editarPessoa(String nome, String cpf, String sexo,String telefone, String email, String nascimento, String estado, String cidade, String bairro, String rua, String numeroDaCasa, String complemento){
        if (nome!=null) {
            setNome(nome);  
          }
          if (cpf!=null) {
            setCpf(cpf);  
          }
          if (sexo!=null) {
            setSexo(sexo);  
          }
          if (telefone!=null) {
            setTelefone(telefone);  
          }
          if (email!=null) {
            setEmail(email);  
          }
          if (nascimento!=null) {
            setNascimento(nascimento);
          }
          if (estado!=null) {
            setEstado(estado);  
          }
          if (cidade!=null) {
            setCidade(cidade);  
          }
          if (bairro!=null) {
            setBairro(bairro);
          }
          if (rua!=null) {
            setRua(rua);  
          }
          if (numeroDaCasa!=null) {
            setNumeroDaCasa(numeroDaCasa);  
          }
          if (complemento!=null) {
            setComplemento(complemento);
          }
    }

    public String toString(){
        return super.toString() + "\nID do Cliente: " + this.idCliente + "\n\n";
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static void setClientes(ArrayList<Cliente> clientes) {
        Cliente.clientes = clientes;
    }
}

