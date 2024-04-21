package br.com.farmacia;

import java.util.Scanner;

import br.com.farmacia.models.DAO.BancoDeDados;
import br.com.farmacia.views.MenuCliente;
import br.com.farmacia.views.MenuFuncionario;
import br.com.farmacia.views.MenuLote;
import br.com.farmacia.views.MenuMedicamento;
import br.com.farmacia.views.MenuPedido;
import br.com.farmacia.utils.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        int opcao;
        Scanner scan = new Scanner(System.in);
        BancoDeDados.iniciarConexao();
        MenuMedicamento.scan = scan;
        MenuLote.scan = scan;
        MenuCliente.scan = scan;
        MenuFuncionario.scan = scan;
        MenuPedido.scan = scan;
        System.out.println("\nBem vindo ao Sistema de Gerenciamento de Farmácia\n");
        do{
            opcao = opcoesMenuPrincipal(scan);
            switch(opcao){
                case 1:
                    MenuFuncionario.chamaMenuFuncionario();
                    break;
                case 2:
                    MenuCliente.chamaMenuCliente();
                    break;
                case 3:
                    MenuMedicamento.chamMenuMedicamento();
                    break;
                case 4:
                    MenuPedido.chamaMenuPedido();
                    break;
                case 0:
                    System.out.println("Finalizando a execução do programa");
                    break;
                default:
                    System.out.println("\nEssa opção não existe\n");
                    break;
            }
        }while(opcao != 0);
        scan.close();
        BancoDeDados.fecharConexao();
    }

    public static int opcoesMenuPrincipal(Scanner scan) {
        Integer opcao = null;
        do {
            System.out.println("1 - Acessar menu de Funcionarios");
            System.out.println("2 - Acessar menu de Clientes");
            System.out.println("3 - Acessar menu de Medicamentos");
            System.out.println("4 - Acessar menu de Pedidos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
          opcao = Util.getInteiro(scan);
        } while (opcao == null);
        return opcao;
      }
}
