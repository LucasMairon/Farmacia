package br.com.farmacia.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Util {
    public static void limparBuffer(Scanner scan) {
        if (scan.hasNextLine())
            scan.nextLine();
    }

    public static String getNome(Scanner scan,String mensagem, String mensagemDeErro){
        boolean padraoNome = false;
        System.out.println(mensagem);
        String nome = scan.nextLine();
        while(padraoNome == false){
            if(nome.matches("^([a-zA-Zá-úÁ-Ú]|\\s)+$".trim())){
                padraoNome = true;
            }else{
                System.out.print("\n" + mensagemDeErro);
                nome = scan.nextLine();
            }
        }
        return nome;
    }

    public static String getCpf(Scanner scan, String mensagem, String mensagemDeErro){
        boolean padraoCpf = false;
        System.out.println(mensagem);
        String cpf = scan.nextLine();
        while(padraoCpf == false){
            if(cpf.matches("^\\d{3}.\\d{3}.\\d{3}-\\d{2}$".trim())){
                padraoCpf = true;
            }else{
                System.out.print("\n" + mensagemDeErro);
                cpf = scan.nextLine();
            }
        }
        return cpf;
     }

    public static String getTelefone(Scanner scan, String mensagem, String mensagemDeErro){
        boolean padraoTelefone = false;
        System.out.println(mensagem);
        String telefone = scan.nextLine();
        while(padraoTelefone == false){
            if(telefone.matches("^\\(\\d{2}\\)\\d{5}-\\d{4}$".trim())){
                padraoTelefone = true;
            }else{
                System.out.print("\n" + mensagemDeErro);
                telefone = scan.nextLine();
            }
        }
        return telefone;
     }

    public static String getEmail(Scanner scan, String mensagem, String mensagemDeErro){
        boolean padraoEmail = false;
        System.out.println(mensagem);
        String email = scan.nextLine();
        while(padraoEmail == false){
            if(email.matches("^[a-z0-9._]+@[a-z]+\\.([a-z]{3,})(\\.[a-z]{2,})?$".trim())){
                padraoEmail = true;
            }else{
                System.out.print("\nPadrão de email incorreto, tente novamente: ");
                email = scan.nextLine();
            }
        }
        return email;
    }

    public static String getData(Scanner scan, String mensagem, String mensagemDeErro){
        boolean padraoData = false;
        System.out.println(mensagem);
        String data = scan.nextLine();
        while(padraoData == false){
            if(data.matches("^\\d{2}\\/\\d{2}\\/\\d{2,4}$".trim())){
                padraoData = true;
            }else{
                System.out.print("\n" + mensagemDeErro);
                data = scan.nextLine();
            }
        }
        return data;
    }
    
    public static String getSexo(Scanner scan, String mensagem, String mensagemDeErro){
        boolean padraoSexo = false;
        System.out.println(mensagem);
        String sexo = scan.nextLine();
        while(padraoSexo == false){
            if(sexo.matches("^[MF]$".trim())){
                padraoSexo = true;
            }else{
                System.out.print("\n" + mensagemDeErro);
                sexo = scan.nextLine();
            }
        }
        return sexo;
    }
    
    public static String getEstado(Scanner scan, String mensagem, String mensagemDeErro){
        boolean padraoEstado = false;
        System.out.println(mensagem);
        String estado = scan.nextLine();
        while(padraoEstado == false){
            if(estado.matches("^[A-Z]{2}$".trim())){
                padraoEstado = true;
            }else{
                System.out.print("\n" + mensagemDeErro);
                estado = scan.nextLine();
            }
        }
        return estado;
    }

    public static Integer getInteiro(Scanner scan) {
        Integer escolha = null;
        try {
            escolha = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida");
        } finally {
            limparBuffer(scan);
            System.out.println();
        }
        return escolha;
    }

    public static int getInteiro(Scanner scan, String mensagem, String mensagemErro) {
        Integer valor = null;
        System.out.print(mensagem);
        valor = getInteiro(scan);
        while (valor == null) {
            System.out.print(mensagemErro);
            valor = getInteiro(scan);
        }
        return valor;
    }

    public static double getDouble(Scanner scan, String mensagem, String mensagemErro) {
        Double valor = null;
        System.out.print(mensagem);
        do {
            try {
                valor = scan.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("\nEntrada inválida");
                System.out.print(mensagemErro);
            } finally {
                limparBuffer(scan);
            }
        } while (valor == null);
        return valor;
    }

    public static int getQuantidade(Scanner scan, String mensagem, String mensagemErro) {
        Integer valor = null;
        System.out.print(mensagem);
        valor = getInteiro(scan);
        while (valor == null || valor <= 0) {
            System.out.print(mensagemErro);
            valor = getInteiro(scan);
        }
        return valor;
    }
}
