package br.com.farmacia.views;

import java.util.Scanner;


import br.com.farmacia.models.entidade.Pedido;
import br.com.farmacia.utils.Util;

public class MenuPedido {
  
  public static Scanner scan;

  public static void chamaMenuPedido() {
    int opcaoMenuPedido = 0;
    Double pagamento = null, valor = 0.0;
    Integer idPedido = null;
    Integer idCliente = null;

    do {
      opcaoMenuPedido = opcoesMenuPedido();
      switch (opcaoMenuPedido) {
        case 1:
          System.out.println("\nCriar Pedido:");
          idCliente = Util.getInteiro(scan, "Digite o id do cliente que fez o pedido:", "Tente novamente");
          valor = Util.getDouble(scan, "Digite o valor total do pedido: ", "Tente novamente");
          Pedido.criaPedido(idCliente, valor);

          break;
        case 2:
          System.out.println("Buscar Pedido:");
          idPedido = Util.getInteiro(scan, "Digite o id do pedido que deseja buscar:", "Tente novamente: ");
          Pedido.visualizarPedido(idPedido);
          idPedido = null;

          break;
        case 3:
          System.out.println("Listar Pedido:");
          Pedido.listarPedidos();
          break;

        case 4:
          System.out.println("Pagar Pedido:");
          idPedido = Util.getInteiro(scan, "Digite o id do pedido que deseja pagar:", "Tente novamente: ");
          pagamento = Util.getDouble(scan, "Digite o pagamento: ", "Tente novamente: ");
          Pedido.pagarPedido(idPedido, pagamento);
          idPedido = null;
          pagamento = null;
        break;
        case 5:
          System.out.println("Adicionar medicamentos no pedido:");
          System.out.println("essa Funcionalidade está incompleta");
        break;
        case 6:
          System.out.println("Remover medicamentos no pedido:");
          System.out.println("essa Funcionalidade está incompleta");
        break;
        case 7:
          System.out.println("Deletar Pedido:");
          idPedido = Util.getInteiro(scan, "Digite o id do pedido que deseja deletar:", "Tente novamente");
          Pedido.deletarPedido(idPedido);
          idPedido = null;
          break;
        case 0:
          System.out.println("Saindo do menu de pedidos...");
          break;
        default:
          System.out.println("opção inválida, tente novamente\n");
          break;
      }
    } while (opcaoMenuPedido != 0);
  }

  public static int opcoesMenuPedido() {
    Integer opcao = null;
    do {
      System.out.println("\nDigite a operação que deseja fazer com o pedido: ");
      System.out.println("1 - Criar Pedido");
      System.out.println("2 - Buscar Pedido");
      System.out.println("3 - Listar Pedidos");
      System.out.println("4 - Pagar Pedido");
      System.out.println("5 - Adicionar Medicamento em um Pedido");
      System.out.println("6 - Retirar Medicamentos de um pedido");
      System.out.println("7 - Deletar Pedido");
      System.out.println("0 - Sair do menu de Pedidos");
      opcao = Util.getInteiro(scan);
    } while (opcao == null);
    return opcao;
  }
  
}
