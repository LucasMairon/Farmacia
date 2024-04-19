package br.com.farmacia.models.entidade;

import java.util.ArrayList;

public class Funcionario {
    private int idFuncionario;
    private Double salario;
    private String cargo;
    private boolean admin;
    private static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private Funcionario funcionario;

    public Funcionario(int idFuncionario, Double salario, String cargo, boolean admin) {
        this.idFuncionario = idFuncionario;
        this.salario = salario;
        this.cargo = cargo;
        this.admin = admin;
    }

    public static Funcionario criarFuncionario(int idFuncionario, Double salario, String cargo, boolean admin) {
        return new Funcionario(idFuncionario, salario, cargo, admin);
    }

    public static void visualizarFuncionario(int id) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getIdFuncionario() == id) {
                System.out.println("Funcionario encontrado!!!");
                System.out.println(funcionario.toString());

            } else {
                System.out.println("Funcionario nao Encontrado!!");
            }
        }
    }

    public static void editarFuncionario(int idFuncionarioEditar, int novoId, String novoCargo, Double novoSalario) {
        for (Funcionario funcionario : funcionarios) {
            if (idFuncionarioEditar == funcionario.getIdFuncionario()) {
                funcionario.setIdFuncionario(novoId);
                funcionario.setCargo(novoCargo);
                funcionario.setSalario(novoSalario);
            }

        }
    }

    public static void listarFuncionario() {
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.toString());
        }
    }

    public void deletarFucionario(ArrayList<Funcionario> funcionarios, int id) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getIdFuncionario() == id) {
                funcionarios.remove(funcionario);
            }
        }
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public static ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public static void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        Funcionario.funcionarios = funcionarios;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String toString() {
        return "ID: " + idFuncionario + "\nSalario: " + salario + "\nCargo: " + cargo + "\neh ADM: " + admin;
    }
}