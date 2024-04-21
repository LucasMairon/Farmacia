package br.com.farmacia.views;


import java.util.Scanner;

import br.com.farmacia.controllers.FuncionarioControle;
import br.com.farmacia.models.entidade.Funcionario;
import br.com.farmacia.utils.Util;

public class MenuFuncionario {

    public static Scanner scan;
    
    public static void chamaMenuFuncionario() {
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
        String senha = "";
        Double salario = 0.0;
        String cargo = "";

            if(FuncionarioControle.count()==0){
            int decisao = 0;
            System.out.println("\nNao ha funcionarios cadastrados!\nCadastre o primeiro funcionario\nO PRIMEIRO FUNCIONARIO A SER CADASTRADO DEVERA SER O GESTOR, QUEM ADMINISTRARA O SISTEMA!");
            decisao = Util.getInteiro(scan, "Deseja cadastrar agora?\n1 - sim\n2 - nao\n", "Tente novamente: ");


            if (decisao == 1) {
              
                nome = Util.getNome(scan, "Digite o nome do Funcionario(apenas letras): ", "Padrão incorreto de nome, tente novamente:");

                cpf = Util.getCpf(scan, "Digite o CPF do Funcionario(Formato 123.456.678-90): ", "Padrão incorreto de CPF, tente novamente:");

                sexo = Util.getSexo(scan, "Digite o sexo do Funcionario:\nM - masculino\nF - feminino ", "Padrão incorreto, Tente novamente(M ou F):");

                telefone = Util.getTelefone(scan, "Digite o telefone do Funcionario(formato (12)34567-8901): " , "Padrão incorreto de telefone, tente novamente:");

                email = Util.getEmail(scan, "Digite o email do Funcionario(formato seuemail@email.com): ", "Padrão incorreto de email, tente novamente:");

                nascimento = Util.getData(scan, "Digite a data de nascimento do Funcionario(formato dd/mm/aaaa ou dd/mm/aa): ", "Padrão incorreto de data, tente novamente:");

                estado = Util.getEstado(scan, "Digite o Estado que mora o Funcionario(apenas letras maiusculas com 2 digitos):", "Padrão incorreto de estado, tente novamente:");

                cidade = Util.getNome(scan, "Digite a cidade que mora o Funcionario: ", "Padrão incorreto de cidade, tente novamente:");

                System.out.println("Digite o Bairro que mora o Funcionario: ");
                bairro = scan.nextLine();

                System.out.println("Digite a Rua que mora o Funcionario: ");
                rua = scan.nextLine();

                System.out.println("Digite o numero da casa do Funcionario: ");
                numeroDaCasa = scan.nextLine();

                System.out.println("Digite o complemento da casa do Funcionario: ");
                complemento = scan.nextLine();

                cargo = Util.getNome(scan, "Informe o cargo do Funcionario: ", "Padrão de cargo incorreto, tente novamente: ");

                salario = Util.getDouble(scan, "Informe o salario do Funcionario:", "Padrão de valor incorreto, tente novamente: ");

                System.out.println("Informe a senha do Funcionario: ");
                senha = scan.nextLine();

                FuncionarioControle.cadastrarFuncionario(nome, cpf, sexo, telefone, email, nascimento, estado, cidade, bairro, rua, numeroDaCasa, complemento, salario, cargo, true, senha);
            }else{
                System.out.println("Saindo do Sistema...");
            }
            }

        System.out.println("\nBem vindo ao menu de Funcionário\n");
        Integer menu = 0;
        do {
            
            menu = Util.getInteiro(scan, "Digite a operação que deseja fazer:\n1 - Criar Funcionario\n2 - Visualizar Funcionario\n3 - Listar funcionarios\n4 - Editar Funcionario\n5 - Excluir Funcionario\n0 - Sair do menu de Funcionarios\n", "Tente novamente: ");

            switch (menu) {
                /*Pega as informações de um funcionario para o cadastro do mesmo */
                case 1:
                    
                    System.out.println("Digite as informacoes abaixo:\n");

                    nome = Util.getNome(scan, "Digite o nome do Funcionario(apenas letras): ", "Padrão incorreto de nome, tente novamente:");

                    cpf = Util.getCpf(scan, "Digite o CPF do Funcionario(Formato 123.456.678-90): ", "Padrão incorreto de CPF, tente novamente:");

                    sexo = Util.getSexo(scan, "Digite o sexo do Funcionario:\nM - masculino\nF - feminino ", "Padrão incorreto, Tente novamente(M ou F):");

                    telefone = Util.getTelefone(scan, "Digite o telefone do Funcionario(formato (12)34567-8901): " , "Padrão incorreto de telefone, tente novamente:");

                    email = Util.getEmail(scan, "Digite o email do Funcionario(formato seuemail@email.com): ", "Padrão incorreto de email, tente novamente:");

                    nascimento = Util.getData(scan, "Digite a data de nascimento do Funcionario(formato dd/mm/aaaa ou dd/mm/aa): ", "Padrão incorreto de data, tente novamente:");

                    estado = Util.getEstado(scan, "Digite o Estado que mora o Funcionario(apenas letras maiusculas com 2 digitos):", "Padrão incorreto de estado, tente novamente:");

                    cidade = Util.getNome(scan, "Digite a cidade que mora o Funcionario: ", "Padrão incorreto de cidade, tente novamente:");

                    System.out.println("Digite o Bairro que mora o Funcionario: ");
                    bairro = scan.nextLine();

                    System.out.println("Digite a Rua que mora o Funcionario: ");
                    rua = scan.nextLine();

                    System.out.println("Digite o numero da casa do Funcionario: ");
                    numeroDaCasa = scan.nextLine();

                    System.out.println("Digite o complemento da casa do Funcionario: ");
                    complemento = scan.nextLine();

                    cargo = Util.getNome(scan, "Informe o cargo do Funcionario: ", "Padrão de cargo incorreto, tente novamente: ");

                    salario = Util.getDouble(scan, "Informe o salario do Funcionario:", "Padrão de valor incorreto, tente novamente: ");

                    FuncionarioControle.cadastrarFuncionario(nome, cpf, sexo, telefone, email, nascimento, estado, cidade, bairro, rua, numeroDaCasa, complemento, salario, cargo, false, "0000");
                    break;
                case 2:
                /*Visualizar Funcionario Especifico*/
                    int idFunc = 0;
                    idFunc = Util.getInteiro(scan, "Digite o ID do funcionario que deseja encontrar: ", "Tente novamente: ");
                    FuncionarioControle.visualizarFuncionario(idFunc);
                    break;
                case 3:
                        System.out.println("Listando Fucinonarios:\n");
                        FuncionarioControle.listarFuncionarios();
                        break;
                case 4:
                    /*Editar Funcionario */
                    Integer IdAdm = null;
                    senha = "";
                    IdAdm = Util.getInteiro(scan,"Informe seu ID: ","Tente novamente");
                    
                    System.out.println("Informe sua senha: ");
                    senha = scan.nextLine();

                    if (FuncionarioControle.verificarADM(IdAdm, senha)) {
                        
                        int idFuncionarioEditar = 0;
                        
                        idFuncionarioEditar = Util.getInteiro(scan, "Informe o ID do funcionario que será editado: ","ERRO!\nInforme novamente o ID do funcionario" );
                        Funcionario.visualizarPessoa(idFuncionarioEditar);
                        Funcionario funcionario = FuncionarioControle.buscarfuncionario(idFuncionarioEditar);
                        if(funcionario == null){
                            System.out.println("\nNão é possível editar um funcionario que não existe\n");
                            break;
                        }

                        nome = funcionario.getNome();
                        cpf = funcionario.getCpf();
                        sexo = funcionario.getSexo();
                        telefone = funcionario.getTelefone();
                        email = funcionario.getEmail();
                        nascimento = funcionario.getNascimento();
                        estado = funcionario.getEstado();
                        cidade = funcionario.getCidade();
                        bairro = funcionario.getBairro();
                        rua = funcionario.getRua();
                        numeroDaCasa = funcionario.getNumeroDaCasa();
                        complemento = funcionario.getComplemento();
                        senha = funcionario.getSenha();
                        salario = funcionario.getSalario();
                        cargo = funcionario.getCargo();
                        
                        int ehAdm = 0;
                        boolean admin = false;
                        Integer opcao = 0;
                        System.out.println("Menu do Funcionario:\n");
                        opcao = Util.getInteiro(scan, "Digite qual informacao deseja mudar:\n1 - Editar tudo\n2 - Nome\n3 - CPF\n4 - Sexo\n5 - Telefone\n6 - Email\n7 - Data de Nascimento\n8 - Estado\n9 - Cidade\n10 - Bairro\n11 - Rua\n12 - Numero da casa\n13 - Complemento\n14 - Cargo\n15 - Salario\n16 - Administracao\n17 - Sair\n","Tente novamente: ");
                        
                        boolean editarTodosOsCampos = false;

                        switch(opcao){
                            case 1:
                                editarTodosOsCampos = true;
                            case 2: 
                                nome = Util.getNome(scan, "Digite o novo nome do Funcionario(apenas letras): ", "Padrão incorreto de nome, tente novamente:");
                    
                                if (!editarTodosOsCampos) {
                                    break;
                                }
                            case 3:
                                cpf = Util.getCpf(scan, "Digite o novo CPF do Funcionario(Formato 123.456.678-90): ", "Padrão incorreto de CPF, tente novamente:");

                                if (!editarTodosOsCampos) {
                                    break;
                                }
                            case 4:
                                sexo = Util.getSexo(scan, "Digite o novo sexo do Funcionario:\nM - masculino\nF - feminino ", "Padrão incorreto, Tente novamente(M ou F):");

                                if (!editarTodosOsCampos) {
                                    break;
                                }
                            case 5:
                                
                                telefone = Util.getTelefone(scan, "Digite o novo telefone do Funcionario(formato (12)34567-8901): " , "Padrão incorreto de telefone, tente novamente");

                                if (!editarTodosOsCampos) {
                                    break;
                                }
                            case 6:
                                email = Util.getEmail(scan, "Digite o novo email do Funcionario(formato seuemail@email.com): ", "Padrão incorreto de email, tente novamente");

                                if (!editarTodosOsCampos) {
                                    break;
                                }
                            case 7:
                                nascimento = Util.getData(scan, "Digite a nova data de nascimento do Funcionario(formato dd/mm/aaaa ou dd/mm/aa): ", "Padrão incorreto de data, tente novamente");

                                if (!editarTodosOsCampos) {
                                    break;
                                }
                            case 8:
                                estado = Util.getEstado(scan, "Digite o novo Estado do Funcionario(apenas letras maiusculas com 2 digitos):", "Padrão incorreto de estado, tente novamente");

                                if (!editarTodosOsCampos) {
                                    break;
                                }
                            case 9:
                                cidade = Util.getNome(scan, "Digite a nova cidade do Funcionario: ", "Padrão incorreto de cidade, tente novamente");

                                if (!editarTodosOsCampos) {
                                    break;
                                }
                            case 10:
                            
                                System.out.println("Digite o Bairro que mora o funcionario: ");
                                bairro = scan.nextLine();
                                if (!editarTodosOsCampos) {
                                    break;
                                }
                            case 11:
                                
                                System.out.println("Digite a Rua que mora o funcionario: ");
                                rua = scan.nextLine();
                                if (!editarTodosOsCampos) {
                                    break;
                                }
                            case 12:
                                
                                System.out.println("Digite o numero da casa do funcionario: ");
                                numeroDaCasa = scan.nextLine();
                                if (!editarTodosOsCampos) {
                                    break;
                                }
                            case 13:
                                
                                System.out.println("Digite o complemento: ");
                                complemento = scan.nextLine();
                                if (!editarTodosOsCampos) {
                                    break;
                                }
                            case 14:
                                
                                cargo = Util.getNome(scan, "Informe o cargo do Funcionario: ", "Padrão de cargo incorreto, tente novamente: ");
                                if (!editarTodosOsCampos) {
                                    break;
                                }
                            case 15:
                                
                                salario = Util.getDouble(scan, "Informe o salario do Funcionario:", "Padrão de valor incorreto, tente novamente: ");
                                if (editarTodosOsCampos) {
                                    break;
                                }
                            case 16:
                                ehAdm = Util.getInteiro(scan, "Funcionario vai administrar o sistema?\n1 - sim\n2 - não\n", "tente novamente");
                                if (ehAdm == 1) {
                                    admin = true;
                                }else{
                                    admin = false;
                                }
                                if (editarTodosOsCampos) {
                                    break;
                                }
                            case 17:
                                System.out.println("Saindo...");
                                break;
                            default:
                                System.out.println("Opcao Invalida!");
                                break;
                            } 
                            FuncionarioControle.atualizarFuncionario(idFuncionarioEditar, nome, cpf, sexo, telefone, email, nascimento, estado, cidade, bairro, rua, numeroDaCasa, complemento, salario, cargo, admin, "0000");
                        break;
                    }else{
                        System.out.println("\nVocê não é administrador, logo, não tem permissão de editar outros funcionários\n");
                        break;
                    }
                        case 5:
                    /*Deletar o Funcionario */
                    Integer adm = null;
                    String senhaAdm = "";
                    adm = Util.getInteiro(scan, "Infome seu id de funcionário:", "tente novamente: ");
                    System.out.println("Informe sua senha: ");
                    senhaAdm = scan.nextLine();
                    if (FuncionarioControle.verificarADM(adm, senhaAdm)) {
                        int idDeletar = 0;
                        
                        idDeletar = Util.getInteiro(scan, "Digite o ID do Funcionario que deseja excluir do sistema: ", "tente novamente: ");
                        FuncionarioControle.deletarFuncionario(idDeletar);
                    }
                    break;
                    /*Sai do Menu Funcionario */
                case 0:
                    System.out.println("Saindo do Menu de Funcionarios...");
                    break;
                default:
                    System.out.println("Opcao Invalida!");
                    break;
                }
        } while (menu!=0);
    }
}    




