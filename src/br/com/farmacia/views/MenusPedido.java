package br.com.farmacia.views;

import java.util.Scanner;

import br.com.farmacia.models.entidade.Pedido;

import java.util.InputMismatchException;

public class MenusPedido {

  public static void editarPedido(Pedido pedido, Scanner scan) {

    if (status == true) {
      System.out.println("O pedido já foi pago, não é permitido editar");
      return;
    }
    int opcaoMenuEditar;
    double pagamento;
    double trouco;

    do {
      opcaoMenuEditar = menuEditarPedido(scan);
      switch (opcaoMenuEditar) {
        case 1:
          System.out.println("Digite o valor do pagamento: ");
          pagamento = getPagamento(pagamento, scan);
          trouco = pedido.pagarPedido(pagamento);
          if (trouco > 0) {
            System.out.println("Valor para trouco: " + trouco);
          } else if (trouco == 0) {
            System.out.println("Pagamento realizado com sucesso");
          }
          break;
        case 2:
          System.out.println("Editar medicamentos no pedido: ");
          break;
        case 3:
          System.out.println("Saindo do menu de edição de pedido...");
          break;
        default:
          System.out.println("opção inválida");
          break;
      }
    } while (opcaoMenuEditar != 3);
  }

  public static void opcoesMenuPedido(Scanner scan) {
    int opcaoMenuPedido;
    int idPedido;
    Pedido pedido;
    do {
      opcaoMenuPedido = menuPedido(scan);
      switch (opcaoMenuPedido) {
        case 1:
          System.out.println("\nCriar Pedido:");

          break;
        case 2:
          System.out.println("\nEditar Pedido:");
          System.out.print("Digite o id do pedido que deseja editar: ");
          idPedido = getInteiro(idPedido, scan);
          pedido = buscaPedido(idPedido);
          if (pedido == null) {
            System.out.println("Esse pedido não existe");
          } else {
            editarPedido(pedido, scan);
          }
          break;
        case 3:
          System.out.print("\nDigite o id do pedido que deseja buscar: ");
          idPedido = getInteiro(idPedido, scan);
          pedido = Pedido.buscaPedido(idPedido);
          if (pedido == null) {
            System.out.println("Pedido não encontrado");
          } else {
            System.out.println("Pedido encontrado:");
            System.out.println(pedido.toString());
          }

          break;
        case 4:
          System.out.println("Listar Pedido:");
          Pedido.listarPedido();
          break;

        case 5:
          System.out.println("Deletar Pedido:");
          System.out.print("Digite o id do pedido que deseja deltar: ");
          idPedido = getInteiro(idPedido, scan);
          pedido = buscaPedido(idPedido);
          if (pedido == null) {
            System.out.println("Esse pedido não existe");
          } else {
            pedido.deletarPedido(idPedido);
            System.out.println("Pedido deletado com sucesso");
          }
          break;
        case 6:
          System.out.println("Saindo do menu de pedidos...");
          break;
        default:
          System.out.println("opção inválida, tente novamente");
          break;
      }
    } while (opcaoMenuPedido != 5);
  }

  public static int menuPedido(Scanner scan) {
    int opcao;
    do {
      System.out.println("Digite a operação que deseja fazer com o pedido: ");
      System.out.println("1 - Criar Pedido");
      System.out.println("2 - Editar Pedido");
      System.out.println("3 - Buscar Pedido");
      System.out.println("4 - Listar Pedidos");
      System.out.println("5 - deletar Pedidos");
      System.out.println("6 - Sair");

      try {
        opcao = scan.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Opção inválida, digite um número");
      }

    } while (opcao != 5);
    return opcao;
  }

  public static int menuEditarPedido(Scanner scan) {
    int opcao = 0;
    do {
      System.out.println("Digite o dado que deseja editar do pedido: ");
      System.out.println("1 - Pagar Pedido");
      System.out.println("2 - Editar Medicamentos no pedido");
      System.out.println("3 - Sair");
      try {
        opcao = scan.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Opção inválida, digite um número");
      }
    } while (opcao != 3);
    return opcao;
  }

  public static Double getPagamento(Double pagamento, Scanner scan) {
    while (true) {
      try {
        pagamento = scan.nextDouble();
        break;
      } catch (InputMismatchException e) {
        System.out.println("Opção inválida, digite um número");
      }
    }
    return pagamento;
  }

  public static int getInteiro(int inteiro, Scanner scan) {
    while (true) {
      try {
        inteiro = scan.nextInt();
        break;
      } catch (InputMismatchException e) {
        System.out.println("Opção inválida, digite um número");
      }
    }
    return inteiro;
  }

}
