package br.com.farmacia.views;
import java.util.Scanner;

import br.com.farmacia.controllers.MedicamentoControle;
import br.com.farmacia.utils.Util;

public class MenuMedicamento {
    public static Scanner scan;

    public static void chamMenuMedicamento() {
        Integer escolha = 0;
        String nome = "";
        String descricao = "";
        double preco = 0.0;
        int idMedicamento = 0;
        boolean editarTodosOsCampos = false;

        System.out.println(
                "\nBem vindo ao menu do medicamento aqui poderá gerenciar os medicamentos e seus respectivos lotes.\n");

        do {
            do {
                System.out.println("Escolha a ação que deseja realizar");
                System.out.println("1- Cadastrar medicamento");
                System.out.println("2- Listar medicamentos");
                System.out.println("3- Editar medicamento");
                System.out.println("4- Deletar medicamento");
                System.out.println("5- Entrar no menu dos lotes");
                System.out.println("0- Sair do menu do medicamento");
                System.out.print("Escolha: ");
                escolha = Util.getInteiro(scan);
            } while (escolha == null);

            switch (escolha) {
                case 1:
                    System.out.println("criando o medicamento");
                    nome = Util.getNome(scan,"Nome: ","Padrão de nome incorreto, tente novamente");
                    System.out.print("Descrição: ");
                    descricao = scan.nextLine();
                    preco = Util.getDouble(scan, "Preço: ", "Digite novamente o preço: ");
                    MedicamentoControle.cadastrar(nome, descricao, preco);
                    break;
                case 5:
                    idMedicamento = Util.getInteiro(scan, "Digite o id do medicamento\nId: ",
                            "Digite novamente o id do medicamento\nId: ");
                    MenuLote.chamaMenuLote(idMedicamento);
                    break;
                case 2:
                    System.out.println("Listando os medicamentos da farmácia");
                    MedicamentoControle.listarMedicamentos();
                    break;
                case 3:
                    idMedicamento = Util.getInteiro(scan,
                            "digite o id do medicamento do medicamento que deseje editar\nId: ",
                            "digite novamente o id do medicamento do medicamento que deseje editar\nId: ");

                    System.out.println("Menu de edição do medicamento: ");
                    MedicamentoControle.visualizarMedicamento(idMedicamento);
                    do {
                        System.out.println("1- Editar todas as informações");
                        System.out.println("2- Editar o nome");
                        System.out.println("3- Editar descrição");
                        System.out.println("4- Editar o preço");
                        System.out.println("0- sair");
                        System.out.print("Escolha: ");
                        escolha = Util.getInteiro(scan);
                    } while (escolha == null);

                    editarTodosOsCampos = false;
                    nome = descricao = null;
                    preco = -1;
                    System.out.println("Editando o medicamento");
                    switch (escolha) {
                        case 1:
                            editarTodosOsCampos = true;
                        case 2:
                            nome = Util.getNome(scan,"Nome: ","Padrão de nome incorreto, tente novamente");
                            if (!editarTodosOsCampos)
                                break;
                        case 3:
                            System.out.print("Descrição: ");
                            descricao = scan.nextLine();
                            if (!editarTodosOsCampos)
                                break;
                        case 4:
                            preco = Util.getDouble(scan, "Novo preço: ", "Digite novamente o novo preço: ");
                            break;
                        case 0:
                            System.out.println("Saindo do menu de edição do pedido");
                            escolha = -1;
                            break;
                        default:
                            break;
                    }
                    MedicamentoControle.atualizar(idMedicamento, nome, descricao, preco);
                    break;
                case 4:
                    idMedicamento = Util.getInteiro(scan, "Digite o id do medicamento que deseje deletar\nId: ",
                            "Digite novamente o id do medicamento que deseje deletar\nId: ");
                    MedicamentoControle.deletar(idMedicamento);
                    break;
                case 0:
                    System.out.println("Saindo do menu do medicamento, voltando prara o meu principal");
                    break;
                default:
                    System.out.println("A escolha não está entre as opções");
                    break;
            }
            System.out.println();
        } while (escolha != 0);
    }
}