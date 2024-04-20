package br.com.farmacia.models.entidade;

import java.util.ArrayList;


public class Funcionario extends Pessoa{
    private String senha;
    private int idFuncionario;
    private Double salario;
    private String cargo;
    private boolean admin;
    private static ArrayList<Funcionario> funcionarios = new ArrayList<>();
    

    public Funcionario(){
        super();
    }

    
    public Funcionario(String nome, String cpf, String sexo,String telefone, String email, String nascimento, String estado, String cidade, String bairro, String rua, String numeroDaCasa, String complemento,Double salario, String cargo, boolean admin, String senha){
        super(nome, cpf, sexo, telefone, email, nascimento, estado, cidade, bairro, rua, numeroDaCasa, complemento);
        this.salario = salario;
        this.cargo = cargo;
        this.admin = admin;
        this.senha = senha;
    }
    
    
    public static Funcionario criarFuncionario(String nome, String cpf, String sexo,String telefone, String email, String nascimento, String estado, String cidade, String bairro, String rua, String numeroDaCasa, String complemento, Double salario, String cargo, boolean admin, String senha){
        return new Funcionario(nome, cpf, sexo, telefone, email, nascimento, estado, cidade, bairro, rua, numeroDaCasa, complemento,salario, cargo, admin, senha);
    }
    
    



    /*Pelo ID do funcionario especifico abrira um menu pedindo que ele informe qual informação deseja mudar*/
   public  void editarPessoa(String nome, String cpf, String sexo,String telefone, String email, String nascimento, String estado, String cidade, String bairro, String rua, String numeroDaCasa, String complemento, Double salario, String cargo, boolean admin, String senha){
        if (nome!=null) {
          setNome(nome);  
        }
        if (cpf!=null) {
          setCpf(cpf);  
        }
        if (sexo!=null) {
          setSexo(sexo);  
        }
        if (telefone!=null) {
          setTelefone(telefone);  
        }
        if (email!=null) {
          setEmail(email);  
        }
        if (nascimento!=null) {
            setNascimento(nascimento);
        }
        if (estado!=null) {
          setEstado(estado);  
        }
        if (cidade!=null) {
          setCidade(cidade);  
        }
        if (bairro!=null) {
            setBairro(bairro);
        }
        if (rua!=null) {
          setRua(rua);  
        }
        if (numeroDaCasa!=null) {
          setNumeroDaCasa(numeroDaCasa);  
        }
        if (complemento!=null) {
            setComplemento(complemento);
        }
        if (salario!=null) {
            setSalario(salario);
        }
        if (cargo!=null) {
            setCargo(cargo);
        }
        if (admin) {
            setAdmin(admin);
        }
        if (senha!=null) {
            setSenha(senha);
        }
    }



    public int getIdFuncionario(){
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


    public boolean getAdmin() {
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

    public void setSenha(String senha){
        this.senha = senha;
    }

    public String getSenha(){
        return this.senha;
    }

    public String toString(){
        return super.toString()+"\nID = "+idFuncionario+"\nSalario = "+salario+"\nCargo = "+cargo+"\neh ADM = "+admin + "\n\n";
    }

}

