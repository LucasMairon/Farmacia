package br.com.farmacia.controllers;



import java.sql.SQLException;
import java.util.ArrayList;

import br.com.farmacia.models.DAO.FuncionarioDAO;
import br.com.farmacia.models.entidade.Funcionario;



public class FuncionarioControle {
    
    public static void cadastrarFuncionario(String nome, String cpf, String sexo, String telefone, String email, String nascimento,
    String estado, String cidade, String bairro, String rua, String numeroDaCasa, String complemento,
     Double salario, String cargo, boolean admin, String senha) {
        Funcionario funcionario =  Funcionario. criarFuncionario(nome, cpf, sexo, telefone, email, nascimento, estado, cidade, bairro, rua, numeroDaCasa, complemento, salario, cargo, admin, senha);
        try {
            FuncionarioDAO.salvar(funcionario);
            System.out.println("\nFuncionario cadastrado com sucesso\n");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar o Funcionario");
        }
    }

    public static void atualizarFuncionario(int idFuncionario, String nome, String cpf, String sexo, String telefone, String email, String nascimento, String estado, String cidade, String bairro, String rua, String numeroDaCasa, String complemento, Double salario, String cargo, boolean admin, String senha) {

        try {
            Funcionario funcionario = FuncionarioDAO.pegar(idFuncionario);
            if(funcionario == null){
                System.out.println("\nEsse funcionario não está no sistema\n");
            }else{
                funcionario.editarPessoa( nome,  cpf,  sexo, telefone,  email,  nascimento,  estado,  cidade,  bairro,  rua,  numeroDaCasa,  complemento,  salario,  cargo,  admin, senha);
                FuncionarioDAO.salvar(funcionario);
                System.out.println("\nFuncionario editado com sucesso\n");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao editar o funcionario");
        }
    }

    public static int count(){
        int resultado = 0;
        try {
            resultado = FuncionarioDAO.count();
        } catch (Exception e) {
            System.out.println("Erro ao acessar a tabela funcionario!");
        }
        return resultado;
    }

    public static void deletarFuncionario(int idFuncionario) {
        try {
            Funcionario funcionario = FuncionarioDAO.pegar(idFuncionario);
            if(funcionario == null){
                System.out.println("\nEsse funcionario não está no sistema\n");
            }else{
                FuncionarioDAO.deletar(funcionario);
                System.out.println("\nFuncionario deletado com sucesso\n");
            }
        } catch (SQLException e) {
           System.out.println("Erro ao deletar o funcionario");
        }
    }

    public static void listarFuncionarios() {
        try {
            ArrayList<Funcionario> funcionarios = FuncionarioDAO.pegarTodos();
            if(funcionarios.size() == 0){
                System.out.println("\nNão há funcionarios para listar\n");
            }else{
                for (Funcionario funcionario : funcionarios)
                    System.out.println(funcionario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void visualizarFuncionario(int idFuncionario) {
        Funcionario funcionario;
        try {
            funcionario = FuncionarioDAO.pegar(idFuncionario);
            if(funcionario == null){
                System.out.println("\nEsse funcionario não está no sistema\n");
            }else{
                System.out.println(funcionario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Boolean verificarADM(int idFuncionario, String senha){
        Funcionario funcionario = null;
        boolean autorizacao = false;
        try {
            funcionario = FuncionarioDAO.pegar(idFuncionario);
            if(funcionario == null){
                System.out.println("\nNão há funcionarios no sistema\n");
            }else if (funcionario.getAdmin() && funcionario.getSenha().equals(senha)) {
                autorizacao = true;
                System.out.println("Funcionario gestor reconhecido!");
            }else{
                System.out.println("O funcionário não é gestor");
            }
        } catch (SQLException e) {
            
            
        }
        return autorizacao;
    }

    public static Funcionario buscarfuncionario(int idFuncionario) {
        Funcionario funcionario;
        try {
            funcionario = FuncionarioDAO.pegar(idFuncionario);
            if(funcionario == null){
                System.out.println("Esse funcionario não existe\n");
                return funcionario;
            }else{
                return funcionario;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}

