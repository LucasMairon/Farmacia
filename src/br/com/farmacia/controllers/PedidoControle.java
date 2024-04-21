package br.com.farmacia.controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.farmacia.models.entidade.Pedido;
import br.com.farmacia.models.entidade.Cliente;
import br.com.farmacia.models.DAO.PedidoDAO;

public class PedidoControle {

    public static void cadastrarPedido(int idCliente,Double valorTotal) {
        Cliente cliente = ClienteControle.buscarCliente(idCliente);
        Pedido pedido = new Pedido(cliente, valorTotal, false);
        try {
            PedidoDAO.salvarPedido(pedido);
            System.out.println("\nPedido cadastrado com sucesso\n");
        } catch (SQLException e) {
            System.out.println("Erro ao criar o pedido");
        }
    }

    // public static void adicionarMedicamentoAoPedido(int idPedido, int idMedicamento) {

    //     try {
    //         Pedido pedido = PedidoDAO.pegar(idPedido);
    //         if(pedido == null){
    //             System.out.println("\nEsse Pedido não está no sistema\n");
    //             return;
    //         }
    //         PedidoDAO.salvarPedido(pedido);
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    // }
    
    public static void pagarPedido(int idPedido, double pagamento) {

        try {
            Pedido pedido = PedidoDAO.pegar(idPedido);
            if(pedido == null){
                System.out.println("\nEsse pedido não está no sistema\n");
                return;
            }
            if(pedido.getStatus() == true){
                System.out.println("\nO pedido já foi pago\n");
                return;
            }
            double trouco;
            if (pagamento < pedido.getValorTotal()) {
                System.out.println("Valor insuficiente");
            }else{
                pedido.setStatus(true);
                trouco = pagamento - pedido.getValorTotal();
                if(trouco > 0){
                    System.out.println("Valor para trouco: " + trouco);
                }else{
                    System.out.println("Pagamento realizado com sucesso");
                }
            }
            PedidoDAO.atualizarPedido(pedido);
        } catch (SQLException e) {
            System.out.println("Erro ao pagar o pedido");
        }
    }

    public static void deletarPedido(int idPedido) {
        try {
            Pedido pedido = PedidoDAO.pegar(idPedido);
            if(pedido == null){
                System.out.println("\nEsse pedido não está no sistema\n");
                return;
            }
            PedidoDAO.deletarPedido(pedido);
            System.out.println("\nPedido deletado com sucesso");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar o pedido");
        }
    }

    public static void listarPedidos() {
        try {
            ArrayList<Pedido> pedidos = PedidoDAO.pegarTodos();
            if(pedidos.size() == 0){
                System.out.println("\nNão há pedidos para lsitar\n");
                return;
            }
            for (Pedido pedido : pedidos)
                System.out.println(pedido);
        } catch (SQLException e) {
            System.out.println("Erro ao listar os pedidos");
        }
    }

    public static void visualizarPedido(int idPedido) {
        Pedido pedido;
        try {
            pedido = PedidoDAO.pegar(idPedido);
            if(pedido == null){
                System.out.println("\nEsse pedido não está no sistema\n");
                return;
            }
            System.out.println(pedido);
        } catch (SQLException e) {
            System.out.println("Erro ao visualizar o pedido");
        }
    }

}

