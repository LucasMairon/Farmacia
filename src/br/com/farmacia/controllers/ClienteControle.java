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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void atualizarCliente(int idCliente, String nome, String cpf, String sexo, String telefone, String email, String nascimento,
    String estado, String cidade, String bairro, String rua, String numeroDaCasa, String complemento){


        try {
            Cliente cliente = ClienteDAO.pegar(idCliente);
            Cliente.editarPessoa(idCliente);
            ClienteDAO.salvar(cliente);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deletarCliente(int idCliente) {
        try {
            Cliente cliente = ClienteDAO.pegar(idCliente);
            ClienteDAO.deletar(cliente);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listarClientes() {
        try {
            ArrayList<Cliente> clientes = ClienteDAO.pegarTodos();
            for (Cliente cliente : clientes)
                System.out.println(cliente);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void visualizarCliente(int idCliente) {
        Cliente cliente;
        try {
            cliente = ClienteDAO.pegar(idCliente);
            System.out.println(cliente);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

