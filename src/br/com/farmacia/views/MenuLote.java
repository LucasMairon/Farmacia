package br.com.farmacia.views;
import java.util.Scanner;

import br.com.farmacia.controllers.LoteControle;
import br.com.farmacia.controllers.MedicamentoControle;
import br.com.farmacia.utils.Util;;

public class MenuLote {
    public static Scanner scan;

    public static void chamaMenuLote(int idMedicamento) {
        Integer escolha = null;
        Integer quantidadeEmEstoque;
        int idLote = 0;
        String validade;
        String fabricacao;
        String loteCodigo;
        boolean editarTodosOsCampos = false;

        System.out.println("\nBem vindo ao gerenciamento dos lotes\n");

        do {
            do {
                System.out.println("Escolha a ação que deseja realizar");
                System.out.println("1- Adicionar lote ao medicamento");
                System.out.println("2- Listar lotes ");
                System.out.println("3- Editar lote");
                System.out.println("4- Deletar lote");
                System.out.println("0- Volta ao menu do medicamento");
                System.out.print("Escolha: ");
                escolha = Util.getInteiro(scan);
            } while (escolha == null);

            switch (escolha) {
                case 1:
                    System.out.println("Criando lote");
                    System.out.print("Código do lote: ");
                    loteCodigo = scan.nextLine();
                    quantidadeEmEstoque = Util.getInteiro(scan,"Quantidade em estoque: ","Tente novamente: ");
                    fabricacao = Util.getData(scan, "Data de Fabricação(formato dd/mm/yyyy ou dd/mm/yy):", "Tente novamente");
                    validade = Util.getData(scan, "Data de Validade(formato dd/mm/yyyy ou dd/mm/yy)", "Tente novamente");
                    MedicamentoControle.adicionarLoteAoMedicamento(idMedicamento, loteCodigo, quantidadeEmEstoque, fabricacao, validade);

                    break;
                case 2:
                    LoteControle.listarLotes(idMedicamento);
                    break;
                case 3:
                    loteCodigo = fabricacao = validade = null;
                    quantidadeEmEstoque = null;

                    System.out.println("Editar o lote");
                    idLote = Util.getInteiro(scan, "Digite o id do Lote:", "Tente novamente");

                    switch (escolha) {
                        case 1:
                            editarTodosOsCampos = true;
                        case 2:
                            System.out.print("Código do lote: ");
                            loteCodigo = scan.nextLine();
                            if (!editarTodosOsCampos)
                                break;
                        case 3:
                            quantidadeEmEstoque = Util.getInteiro(scan,"Quantidade em estoque: ","Tente novamente: ");
                            Util.limparBuffer(scan);
                            if (!editarTodosOsCampos)
                                break;
                        case 4:
                            fabricacao = Util.getData(scan, "Data de Fabricação(formato dd/mm/yyyy ou dd/mm/yy):", "Tente novamente");
                            if (!editarTodosOsCampos)
                                break;
                        case 5:
                            validade = Util.getData(scan, "Data de Validade(formato dd/mm/yyyy ou dd/mm/yy)", "Tente novamente");
                            break;
                        default:
                            System.out.println("A escolha não está entre as opções do menu");
                            break;
                    }
                    LoteControle.editarLote(idMedicamento, idLote, loteCodigo, quantidadeEmEstoque, fabricacao, validade);
                    break;
                case 4:
                    idLote = Util.getInteiro(scan, "Digite o id do lote que deseja excluir: ", "Tente novamente");
                    LoteControle.deletarLote(idLote, idMedicamento);
                case 0:
                    System.out.println("Voltando ao menu do medicamento");
                    break;
                default:
                    System.out.println("A escolha não está entre as opções do menu");
                    break;
            }
        } while (escolha != 0);
    }
}
