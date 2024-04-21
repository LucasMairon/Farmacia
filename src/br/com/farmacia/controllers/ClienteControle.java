package br.com.farmacia.controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.farmacia.models.DAO.ClienteDAO;
import br.com.farmacia.models.entidade.Cliente;



public class ClienteControle {

    public static void cadastrarCliente(String nome, String cpf, String sexo, String telefone, String email, String nascimento,
    String estado, String cidade, String bairro, String rua, String numeroDaCasa, String complemento) {
        Cliente cliente =  Cliente.criarCliente(nome, cpf, sexo, telefone, email, nascimento, estado, cidade, bairro, rua, numeroDaCasa, complemento);
        try {
            ClienteDAO.salvar(cliente);
            System.out.println("\nCLiente cadastrado com sucesso\n");
        } catch (SQLException e) {
            System.out.println("Erro ao criar o Cliente");
        }
    }

    public static void atualizarCliente(int idCliente, String nome, String cpf, String sexo, String telefone, String email, String nascimento,
    String estado, String cidade, String bairro, String rua, String numeroDaCasa, String complemento){
        try {
            Cliente cliente = ClienteDAO.pegar(idCliente);
            if(cliente == null){
                System.out.println("Esse cliente não existe\n");
            }else{
                cliente.editarPessoa(nome,  cpf,  sexo, telefone,  email,  nascimento,  estado,  cidade,  bairro,  rua,  numeroDaCasa,  complemento);
                ClienteDAO.salvar(cliente);
                System.out.println("\nCliente editado com sucesso\n");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao editar o Cliente");
        }
    }

    public static void deletarCliente(int idCliente) {
        try {
            Cliente cliente = ClienteDAO.pegar(idCliente);
            if(cliente == null){
                System.out.println("Esse cliente não existe\n");
            }else{
                ClienteDAO.deletar(cliente);
                System.out.println("\nCliente deletado com sucesso\n");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar o Cliente");
        }
    }

    public static void listarClientes() {
        try {
            ArrayList<Cliente> clientes = ClienteDAO.pegarTodos();
            if(clientes.size() == 0){
                System.out.println("Ainda não há clientes no sistema\n");
            }else{
                for (Cliente cliente : clientes)
                    System.out.println(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao Listar os Clientes");
        }
    }

    public static void visualizarCliente(int idCliente) {
        Cliente cliente;
        try {
            cliente = ClienteDAO.pegar(idCliente);
            if(cliente == null){
                System.out.println("Esse cliente não existe\n");
            }else{
                System.out.println("Informações do cliente:");
                System.out.println(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao visualizar o Cliente");
        }
    }
    
    public static Cliente buscarCliente(int idCliente) {
        Cliente cliente;
        try {
            cliente = ClienteDAO.pegar(idCliente);
            if(cliente == null){
                System.out.println("Esse cliente não existe\n");
                return cliente;
            }else{
                return cliente;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar um cliente");
            return null;
        }
    }
}

