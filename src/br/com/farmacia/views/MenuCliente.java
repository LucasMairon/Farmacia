package br.com.farmacia.views;

import java.util.Scanner;

import br.com.farmacia.controllers.ClienteControle;
import br.com.farmacia.models.DAO.ClienteDAO;
import br.com.farmacia.utils.Util;
import br.com.farmacia.models.entidade.Cliente;



public class MenuCliente {
    public static Scanner scan;
    public static void chamaMenuCliente() {
        int menu = -1;
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
        System.out.println("\nBem-vindo ao Menu do Cliente:\n");
        while (menu != 0) {
            menu = Util.getInteiro(scan, "Digite a operação que deseja realizar:\n1 - Adicionar Cliente\n2 - Editar Cliente\n3 - Excluir Cliente\n4 - Listar Clientes\n5 - Visualizar Cliente\n0 - Sair do menu de Clientes\n", "Tente novamente: ");
            switch (menu) {
                case 1:
                    nome = Util.getNome(scan, "Digite o nome do Cliente(apenas letras): ", "Padrão incorreto de nome, tente novamente:");

                    cpf = Util.getCpf(scan, "Digite o CPF do cliente(Formato 123.456.678-90): ", "Padrão incorreto de CPF, tente novamente:");

                    sexo = Util.getSexo(scan, "Digite o sexo do Cliente:\nM - masculino\nF - feminino ", "Padrão incorreto, Tente novamente(M ou F):");

                    telefone = Util.getTelefone(scan, "Digite o telefone do Cliente(formato (12)34567-8901): " , "Padrão incorreto de telefone, tente novamente:");

                    email = Util.getEmail(scan, "Digite o email do Cliente(formato seuemail@email.com): ", "Padrão incorreto de email, tente novamente:");

                    nascimento = Util.getData(scan, "Digite a data de nascimento do Cliente(formato dd/mm/aaaa ou dd/mm/aa): ", "Padrão incorreto de data, tente novamente:");

                    estado = Util.getEstado(scan, "Digite o Estado que mora o Cliente(apenas letras maiusculas com 2 digitos):", "Padrão incorreto de estado, tente novamente:");

                    cidade = Util.getNome(scan, "Digite a cidade que mora o Cliente: ", "Padrão incorreto de cidade, tente novamente:");

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
                    Cliente cliente = ClienteControle.buscarCliente(idClienteEditar);
                    if(cliente == null){
                        System.out.println("Não é possível editar um cliente que não existe\n");
                        break;
                    }
                    
                    nome = cliente.getNome();
                    cpf = cliente.getCpf();
                    sexo = cliente.getSexo();
                    telefone = cliente.getTelefone();
                    email = cliente.getEmail();
                    nascimento = cliente.getNascimento();
                    estado = cliente.getEstado();
                    cidade = cliente.getCidade();
                    bairro = cliente.getBairro();
                    rua = cliente.getRua();
                    numeroDaCasa = cliente.getNumeroDaCasa();
                    complemento = cliente.getComplemento();
                    int opcao = 0;

                    System.out.println("Menu Cliente");
                    opcao = Util.getInteiro(scan,"Digite qual informacao deseja mudar:\n1 - Editar tudo\n2 - Nome\n3 - CPF\n4 - Sexo\n5 - Telefone\n6 - Email\n7 - Data de Nascimento\n8 - Estado\n9 - Cidade\n10 - Bairro\n11 - Rua\n12 - Numero da casa\n13 - Complemento\n14 - Sair\n", "Tente novamente: ");
                    
                    boolean editarTodosOsCampos = false;

                    switch(opcao){
                        case 1:
                            editarTodosOsCampos = true;
                        case 2:

                            nome = Util.getNome(scan, "Digite o novo nome do Cliente(apenas letras): ", "Padrão incorreto de nome, tente novamente:");
                
                            if (!editarTodosOsCampos) {
                                break;
                            }
                        case 3:
                            cpf = Util.getCpf(scan, "Digite o novo CPF do cliente(Formato 123.456.678-90): ", "Padrão incorreto de CPF, tente novamente:");

                            if (!editarTodosOsCampos) {
                                break;
                            }
                            
                        case 4:
                            sexo = Util.getSexo(scan, "Digite o novo sexo do Cliente:\nM - masculino\nF - feminino ", "Padrão incorreto, Tente novamente(M ou F):");

                            if (!editarTodosOsCampos) {
                                break;
                            }
                        case 5:
                            telefone = Util.getTelefone(scan, "Digite o novo telefone do Cliente(formato (12)34567-8901): " , "Padrão incorreto de telefone, tente novamente");

                            if (!editarTodosOsCampos) {
                                break;
                            }
                            
                        case 6:
                            email = Util.getEmail(scan, "Digite o novo email do Cliente(formato seuemail@email.com): ", "Padrão incorreto de email, tente novamente");

                            if (!editarTodosOsCampos) {
                                break;
                            }
                            
                        case 7:
                            nascimento = Util.getData(scan, "Digite a nova data de nascimento do Cliente(formato dd/mm/aaaa ou dd/mm/aa): ", "Padrão incorreto de data, tente novamente");

                            if (!editarTodosOsCampos) {
                                break;
                            }
                            
                        case 8:
                            estado = Util.getEstado(scan, "Digite o novo Estado do Cliente(apenas letras maiusculas com 2 digitos):", "Padrão incorreto de estado, tente novamente");

                            if (!editarTodosOsCampos) {
                                break;
                            }
                        case 9:
                            cidade = Util.getNome(scan, "Digite a nova cidade do Cliente: ", "Padrão incorreto de cidade, tente novamente");

                            if (!editarTodosOsCampos) {
                                break;
                            }
                        case 10:
                            System.out.println("Digite o Bairro que mora o cliente: ");
                            bairro = scan.nextLine();
                            if (!editarTodosOsCampos) {
                                break;
                            }
                        case 11:
                            System.out.println("Digite a Rua que mora o cliente: ");
                            rua = scan.nextLine();
                            if (!editarTodosOsCampos) {
                                break;
                            }
                        case 12:
                            System.out.println("Digite o numero da casa do cliente: ");
                            numeroDaCasa = scan.nextLine();
                            if (!editarTodosOsCampos) {
                                break;
                            }
                        case 13:
                            System.out.println("Digite o complemento: ");
                            complemento = scan.nextLine();
                            if(!editarTodosOsCampos){
                                break;
                            }
                        case 14:
                            System.out.println("Saindo do menu de edição do cliente...");
                            break;
                        default:
                            System.out.println("Opcao Invalida!");
                            break;
                        } 
                        ClienteControle.atualizarCliente(idClienteEditar, nome, cpf, sexo, telefone, email, nascimento, estado, cidade, bairro, rua, numeroDaCasa, complemento);
                    break;
                case 3:
                    /*Excluir Cliente */
                    int idClienteExcluir = 0;
                    idClienteExcluir = Util.getInteiro(scan, "Informe o ID do cliente: ", "Tente novamente");
                    ClienteControle.deletarCliente(idClienteExcluir);
                    break;
                case 4:
                    /*Listar todos os Clientes */
                    System.out.println("\nCLientes no sistema:\n");
                    ClienteControle.listarClientes();
                    break;
                case 5:
                    /*Visualizar Cliente */
                    int idClienteVisualizar = Util.getInteiro(scan,"Informe o ID do Cliente:", "Tente novamente");

                    ClienteControle.visualizarCliente(idClienteVisualizar);
                    break;
                case 0:
                    System.out.println("Saindo do menu de clientes...");
                    break;
                default:
                    break;
            }
        }
    }
}

