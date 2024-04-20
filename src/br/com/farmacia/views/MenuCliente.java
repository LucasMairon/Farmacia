package br.com.farmacia.views;


import java.sql.SQLException;
import java.util.Scanner;

import br.com.farmacia.controllers.ClienteControle;
import br.com.farmacia.models.DAO.BancoDeDados;
import br.com.farmacia.utils.Util;



public class MenuCliente {
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws SQLException {
        BancoDeDados.iniciarConexao();
        int menu = 0;
        while (menu !=6) {
            System.out.println("Bem-vindo ao Sistema do Cliente!\n1 - Adicionar Cliente\n2 - Editar Cliente\n3 - Excluir Cliente\n4 - Listar Cliente\n5 - Visualizar Cliente\n6 - sair");
            menu = scan.nextInt();
            scan.nextLine();
            switch (menu) {
                case 1:
                    String nome = "";
                    String cpf = "";
                    String sexo = "";
                    String telefone = "";
                    String email = "";
                    String nascimento = "";
                    String estado = "";
                    String cidade = "";
                    String bairro = "";
                    String rua = "";
                    String numeroDaCasa = "";
                    String complemento = "";

                    do{
                        System.out.println("Digite o nome do Cliente: ");
                        nome = scan.nextLine();
                    }while(!Util.getNome(nome, scan));

                    do{
                        System.out.println("Digite o CPF do cliente: ");
                        cpf = scan.nextLine();
                    }while(!Util.getCpf(cpf, scan));

                    System.out.println("Digite o sexo do Cliente:\nM - masculino\nF - feminino ");
                    sexo = scan.nextLine();

                    do{
                        System.out.println("Digite o telefone do Cliente: ");
                        telefone = scan.nextLine();
                    }while(!Util.getTelefone(telefone, scan));

                    do{
                        System.out.println("Digite o email do Cliente: ");
                        email = scan.nextLine();
                    }while(!Util.getEmail(email, scan));

                    do{
                        System.out.println("Digite a data de nascimento do Cliente: ");
                        nascimento = scan.nextLine();
                    }while(!Util.getData(complemento, scan));

                    System.out.println("Digite o Estado que mora o Cliente: ");
                    estado = scan.nextLine();

                    System.out.println("Digite a cidade que mora o Cliente: ");
                    cidade = scan.nextLine();

                    System.out.println("Digite o Bairro que mora o Cliente: ");
                    bairro = scan.nextLine();

                    System.out.println("Digite a Rua que mora o Cliente: ");
                    rua = scan.nextLine();

                    System.out.println("Digite o numero da casa do Cliente: ");
                    numeroDaCasa = scan.nextLine();

                    System.out.println("Digite o complemento da casa do Cliente: ");
                    complemento = scan.nextLine();

                    ClienteControle.cadastrarCliente(nome, cpf, sexo, telefone, email, nascimento, estado, cidade, bairro, rua, numeroDaCasa, complemento);

                    break;
                case 2:
                    /*Editar Cliente */
                    int idClienteEditar = 0;
                    idClienteEditar = Util.getInteiro(scan, "Informe o ID do cliente: ", "Insira novamente o ID do Cliente");
                    
                    int opcao = 0;
                    String nomeEditado = "";
                    String cpfEditado = "";
                    String sexoEditado = "";
                    String telefoneEditado = "";
                    String emailEditado = "";
                    String nascimentoEditado = "";
                    String estadoEditado = "";
                    String cidadeEditado = "";
                    String bairroEditado = "";
                    String ruaEditado = "";
                    String numeroDaCasaEditado = "";
                    String complementoEditado = "";

                    do {
                        System.out.println("Menu Cliente");
                        System.out.println("Digite qual informacao deseja mudar:\n1 - Editar tudo\n2 - Nome\n3 - CPF\n4 - Sexo\n5 - Telefone\n6 - Email\n7 - Data de Nascimento\n8 - Estado\n9 - Cidade\n10 - Bairro\n11 - Rua\n12 - Numero da casa\n13 - Complemento\n14 - Sair");
                        opcao = Util.getInteiro(scan);
                    } while (opcao==0);
                    boolean editarTodosOsCampos = false;

                    switch(opcao){
                        case 1:
                            editarTodosOsCampos = true;
                        case 2:
                            System.out.println("Digite o nome do cliente: ");
                            nomeEditado = scan.nextLine();
                            if (Util.getNome(nomeEditado, scan)) {
                                if (!editarTodosOsCampos) {
                                    break;
                                }
                            }
                        case 3:
                            System.out.println("Digite o CPF: ");
                            cpfEditado = scan.nextLine();
                            if (Util.getCpf(cpfEditado, scan)) {
                                if (!editarTodosOsCampos) {
                                    break;
                                }
                            }
                        case 4:
                            System.out.println("Digite o sexo do cliente: ");
                            sexoEditado = scan.nextLine();
                            if (!editarTodosOsCampos) {
                                break;
                            }
                        case 5:
                            System.out.println("Digite o telefone: ");
                            telefoneEditado = scan.nextLine();
                            if (Util.getTelefone(telefoneEditado, scan)) {
                                if (!editarTodosOsCampos) {
                                    break;
                                }
                            }
                        case 6:
                            System.out.println("Digite o email: ");
                            emailEditado = scan.nextLine();
                            if (Util.getEmail(emailEditado, scan)) {
                                if (!editarTodosOsCampos) {
                                    break;
                                }
                            }
                        case 7:
                            System.out.println("Digite a data de nascimento: ");
                            nascimentoEditado = scan.nextLine();
                            if (Util.getData(complementoEditado, scan)) {
                                if (!editarTodosOsCampos) {
                                    break;
                                }
                            }
                        case 8:
                            System.out.println("Digite o Estado que mora o cliente: ");
                            estadoEditado = scan.nextLine();
                            if (!editarTodosOsCampos) {
                                break;
                            }
                        case 9:
                            System.out.println("Digite a cidade que mora o cliente: ");
                            cidadeEditado = scan.nextLine();
                            if (!editarTodosOsCampos) {
                                break;
                            }
                        case 10:
                            System.out.println("Digite o Bairro que mora o cliente: ");
                            bairroEditado = scan.nextLine();
                            if (!editarTodosOsCampos) {
                                break;
                            }
                        case 11:
                            System.out.println("Digite a Rua que mora o cliente: ");
                            ruaEditado = scan.nextLine();
                            if (!editarTodosOsCampos) {
                                break;
                            }
                        case 12:
                            System.out.println("Digite o numero da casa do cliente: ");
                            numeroDaCasaEditado = scan.nextLine();
                            if (!editarTodosOsCampos) {
                                break;
                            }
                        case 13:
                            System.out.println("Digite o complemento: ");
                            complementoEditado = scan.nextLine();
                                break;
                        case 14:
                            System.out.println("Saindo...");
                            break;
                        default:
                            System.out.println("Opcao Invalida!");
                            break;
                        } 
                        ClienteControle.atualizarCliente(idClienteEditar, nomeEditado, cpfEditado, sexoEditado, telefoneEditado, emailEditado, nascimentoEditado, estadoEditado, cidadeEditado, bairroEditado, ruaEditado, numeroDaCasaEditado, complementoEditado);

                    break;
                case 3:
                    /*Excluir Cliente */
                    int idClienteExcluir = 0;
                    System.out.println("Informe o ID do cliente: ");
                    idClienteExcluir = Util.getInteiro(scan);
                    scan.nextLine();
                    ClienteControle.deletarCliente(idClienteExcluir);
                    break;
                case 4:
                    /*Listar todos os Clientes */
                    ClienteControle.listarClientes();
                    break;
                case 5:
                    /*Visualizar Cliente */
                    System.out.println("Informe o ID do Cliente:");
                    int idClienteVisualizar = Util.getInteiro(scan);
                    scan.nextLine();

                    ClienteControle.visualizarCliente(idClienteVisualizar);
                    break;
                default:
                    break;
            }
        }

        scan.close();
        BancoDeDados.fecharConexao();
    }
}

