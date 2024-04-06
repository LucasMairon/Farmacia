package br.com.farmacia.classes;

import java.util.ArrayList;

public class Funcionario{
    private int idFuncionario;
    private Double salario;
    private String cargo;
    private boolean admin;
    private static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private Funcionario funcionario;

    public Funcionario(int idFuncionario, Double salario, String cargo, boolean admin){
        this.idFuncionario = idFuncionario;
        this.salario = salario;
        this.cargo = cargo;
        this.admin = admin;
    }

    public static Funcionario criarFuncionario(int idFuncionario, Double salario, String cargo, boolean admin){
        return new Funcionario(idFuncionario, salario, cargo, admin);
    }
}