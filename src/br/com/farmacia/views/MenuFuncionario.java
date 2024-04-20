package br.com.farmacia.views;


import java.sql.SQLException;
import java.util.Scanner;

import br.com.farmacia.controllers.FuncionarioControle;
import br.com.farmacia.models.DAO.BancoDeDados;
import br.com.farmacia.models.entidade.Funcionario;
import br.com.farmacia.utils.Util;




public class MenuFuncionario {

    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws SQLException {
        BancoDeDados.iniciarConexao();
            
            if(FuncionarioControle.count()==0){
            int decisao = 0;
            System.out.println("Nao ha funcionarios cadastrado!\nCadastre o primeiro funcionario\nO PRIMEIRO FUNCIONARIO A SER CADASTRADO DEVERA SER O GESTOR, QUEM ADMINISTRARA O SISTEMA!");
            System.out.println("Deseja cadastrar agora\n1 - sim\n2 - nao");
            decisao = Util.getInteiro(scan);

            if (decisao == 1) {
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
                
                System.out.println("Digite o nome do funcionario: ");
                nome = scan.nextLine();
                Util.getNome(nome, scan);
                System.out.println("Digite o CPF com os pontos e traço: ");
                cpf = scan.nextLine();
                Util.getCpf(cpf, scan);
                System.out.println("Digite o sexo do funcionario:\nM - masculino\nF - feminino ");
                sexo = scan.nextLine();
                System.out.println("Digite o telefone sem DDD e com traco: ");
                telefone = scan.nextLine();
                Util.getTelefone(telefone, scan);
                System.out.println("Digite o email: ");
                email = scan.nextLine();
                Util.getEmail(email, scan);
                System.out.println("Digite a data de nascimento: ");
                nascimento = scan.nextLine();
                Util.getData(cargo, scan);
                System.out.println("Digite o Estado que mora o funcionario: ");
                estado = scan.nextLine();
                System.out.println("Digite a cidade que mora o funcionario: ");
                cidade = scan.nextLine();
                System.out.println("Digite o Bairro que mora o funcionario: ");
                bairro = scan.nextLine();
                System.out.println("Digite a Rua que mora o funcionario: ");
                rua = scan.nextLine();
                System.out.println("Digite o numero da casa do funcionario: ");
                numeroDaCasa = scan.nextLine();
                System.out.println("Digite o complemento: ");
                complemento = scan.nextLine();
                System.out.println("Informe o Cargo do funcionario: ");
                cargo = scan.nextLine();
                System.out.println("Informe o salario: ");
                salario = scan.nextDouble();
                scan.nextLine();
                System.out.println("Informe a senha: ");
                senha = scan.nextLine();  
                FuncionarioControle.cadastrarFuncionario(nome, cpf, sexo, telefone, email, nascimento, estado, cidade, bairro, rua, numeroDaCasa, complemento, salario, cargo, true, senha);
            }else{
                System.out.println("Saindo do Sistema...");
            }
        }else{


        Integer menu = 0;
        do {
            
            do {
                System.out.println("Sistema Gerenciamento de Farmacia");
                System.out.println("1 - Criar Funcionario\n2 - Visualizar Funcionario\n3 - Listar funcionarios\n4 - Editar Funcionario\n5 - Excluir Funcionario\n6 - Sair");
                menu = Util.getInteiro(scan);
            } while (menu==null);


            switch (menu) {
                /*Pega as informações de um funcionario para o cadastro do mesmo */
                case 1:
                    String nome = "";
                    String cpf = "";
                    String sexo ;
                    String telefone = "";
                    String email = "";
                    String nascimento = "";
                    String estado = "";
                    String cidade = "";
                    String bairro = "";
                    String rua = "";
                    String numeroDaCasa = "";
                    String complemento = "";
                    Double salario = 0.0;
                    String cargo = "";
                    
                    System.out.println("Digite as informacoes abaixo");
                    do{
                        System.out.println("Digite o nome do funcionario: ");
                        nome = scan.nextLine();
                    }while (Util.getNome(nome, scan)==false);

                    do{
                        System.out.println("Digite o CPF com os pontos e traco: ");
                        cpf = scan.nextLine();    
                    }while(Util.getCpf(cpf, scan)==false);
                                        
                    System.out.println("Digite o sexo do funcionario: ");
                    sexo = scan.nextLine();

                    do{
                        System.out.println("Digite o telefone sem o DDD e com traco: ");
                        telefone = scan.nextLine();
                    }while(Util.getTelefone(telefone, scan)==false);
                    
                    do{
                        System.out.println("Digite o email: ");
                        email = scan.nextLine(); 
                    }while(Util.getEmail(email, scan)==false);
                    
                    do{
                        System.out.println("Digite a data de nascimento com o formato dd/mm/aa: ");
                        nascimento = scan.nextLine();  
                    }while(Util.getData(cargo, scan)==false);
                    
                    System.out.println("Digite o Estado que mora o funcionario: ");
                    estado = scan.nextLine();

                    System.out.println("Digite a cidade que mora o funcionario: ");
                    cidade = scan.nextLine();

                    System.out.println("Digite o Bairro que mora o funcionario: ");
                    bairro = scan.nextLine();

                    System.out.println("Digite a Rua que mora o funcionario: ");
                    rua = scan.nextLine();

                    System.out.println("Digite o numero da casa do funcionario: ");
                    numeroDaCasa = scan.nextLine();

                    System.out.println("Digite o complemento: ");
                    complemento = scan.nextLine();

                    System.out.println("Informe o Cargo do funcionario: ");
                    cargo = scan.nextLine();

                    salario = Util.getDouble(scan, "Informe o salario do funcionario: ", "Informe novamente o salario: ");

                    FuncionarioControle.cadastrarFuncionario(nome, cpf, sexo, telefone, email, nascimento, estado, cidade, bairro, rua, numeroDaCasa, complemento, salario, cargo, false, "0000");
                    break;
                case 2:
                /*Visualizar Funcionario Especifico*/
                    int idFunc = 0;
                    System.out.println("Digite o ID do funcionario que deseja encontrar: ");
                    idFunc = scan.nextInt();
                    FuncionarioControle.visualizarFuncionario(idFunc);
                    break;
                case 3:
                        System.out.println("Listando Fucinonarios");
                        FuncionarioControle.listarFuncionarios();
                        break;
                case 4:
                    /*Editar Funcionario */
                    Integer IdAdm = null;
                    String senha = "";
                    do{
                        System.out.println("Informe seu ID: ");
                        IdAdm = Util.getInteiro(scan);
                    }while (IdAdm==null);
                    System.out.println("Informe sua senha: ");
                    senha = scan.nextLine();

                    if (FuncionarioControle.verificarADM(IdAdm, senha)) {
                        
                        int idFuncionarioEditar = 0;
                        
                        idFuncionarioEditar = Util.getInteiro(scan, "Informe o ID do funcionario que será editado","ERRO!\nInforme novamente o ID do funcionario" );
                        Funcionario.visualizarPessoa(idFuncionarioEditar);
                        

                        String nomeEditado = null;
                        String cpfEditado = null;
                        String sexoEditado = null;
                        String telefoneEditado = null;
                        String emailEditado = null;
                        String nascimentoEditado = null;
                        String estadoEditado = null;
                        String cidadeEditado = null;
                        String bairroEditado = null;
                        String ruaEditado = null;
                        String numeroDaCasaEditado = null;
                        String complementoEditado = null;
                        String cargoEditado = null;
                        Double salarioEditado = -1.0;
                        int ehAdm = 0;
                        boolean admin = false;
                        Integer opcao = 0;
                        do {
                            System.out.println("Menu do Funcionario");
                            System.out.println("Digite qual informacao deseja mudar:\n1 - Editar tudo\n2 - Nome\n3 - CPF\n4 - Sexo\n5 - Telefone\n6 - Email\n7 - Data de Nascimento\n8 - Estado\n9 - Cidade\n10 - Bairro\n11 - Rua\n12 - Numero da casa\n13 - Complemento\n14 - Cargo\n15 - Salario\n16 - Administracao\n17 - Sair");
                            opcao = Util.getInteiro(scan);
                            scan.nextLine();
                        } while (opcao==null);
                        boolean editarTodosOsCampos = false;

                        switch(opcao){
                            case 1:
                                editarTodosOsCampos = true;
                            case 2: 
                                System.out.println("Digite o nome do funcionario: ");
                                nomeEditado = scan.nextLine();
                                if (Util.getNome(nomeEditado, scan)==true) {
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
                                
                                System.out.println("Digite o sexo do funcionario: ");
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
                                if (Util.getData(nascimentoEditado, scan)) {
                                    if (!editarTodosOsCampos) {
                                        break;
                                    }
                                }
                            case 8:
                                System.out.println("Digite o Estado que mora o funcionario: ");
                                estadoEditado = scan.nextLine();
                                
                                if (!editarTodosOsCampos) {
                                    break;
                                }
                            case 9:
                                
                                System.out.println("Digite a cidade que mora o funcionario: ");
                                cidadeEditado = scan.nextLine();
                                if (!editarTodosOsCampos) {
                                    break;
                                }
                            case 10:
                            
                                System.out.println("Digite o Bairro que mora o funcionario: ");
                                bairroEditado = scan.nextLine();
                                if (!editarTodosOsCampos) {
                                    break;
                                }
                            case 11:
                                
                                System.out.println("Digite a Rua que mora o funcionario: ");
                                ruaEditado = scan.nextLine();
                                if (!editarTodosOsCampos) {
                                    break;
                                }
                            case 12:
                                
                                System.out.println("Digite o numero da casa do funcionario: ");
                                numeroDaCasaEditado = scan.nextLine();
                                if (!editarTodosOsCampos) {
                                    break;
                                }
                            case 13:
                                
                                System.out.println("Digite o complemento: ");
                                complementoEditado = scan.nextLine();
                                if (!editarTodosOsCampos) {
                                    break;
                                }
                            case 14:
                                
                                System.out.println("Informe o Cargo do funcionario: ");
                                cargoEditado = scan.nextLine();
                                if (!editarTodosOsCampos) {
                                    break;
                                }
                            case 15:
                                
                                Util.getDouble(scan, "Informe o salario do funcionario: ", "Insira novamente o Salario: ");
                                if (editarTodosOsCampos) {
                                    break;
                                }
                            case 16:
                                System.out.println("Funcionario vai administrar: ");
                                ehAdm = scan.nextInt();
                                if (ehAdm==1) {
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
                        FuncionarioControle.atualizarFuncionario(idFuncionarioEditar, nomeEditado, cpfEditado, sexoEditado, telefoneEditado, emailEditado, nascimentoEditado, estadoEditado, cidadeEditado, bairroEditado, ruaEditado, numeroDaCasaEditado, complementoEditado, salarioEditado, cargoEditado, admin, "0000");
                        break;
                    }else{
                        break;
                    }
                        case 5:
                    /*Deletar o Funcionario */
                    Integer adm = null;
                    String senhaAdm = "";
                    do {
                        System.out.println("Infome o id do funcionario");
                        adm = Util.getInteiro(scan);
                    } while (adm==null);
                    System.out.println("Informe sua senha: ");
                    senhaAdm = scan.nextLine();
                    if (FuncionarioControle.verificarADM(adm, senhaAdm)) {
                        
                        int idDeletar = 0;
                        
                        System.out.println("Digite o ID do Funcionario que deseja exluir do sistema: ");
                        idDeletar = Util.getInteiro(scan);
                        scan.nextLine();
                        FuncionarioControle.deletarFuncionario(idDeletar);
                    }
                    break;
                    /*Sai do Menu Funcionario */
                case 6:
                    System.out.println("Saindo do Sistema...");
                    break;
                default:
                    System.out.println("Opcao Invalida!");
                    break;
                }
        } while (menu!=6);
        scan.close();
        BancoDeDados.fecharConexao();
    }
    }
}    

