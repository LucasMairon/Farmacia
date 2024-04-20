package br.com.farmacia.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Util {
    public static void limparBuffer(Scanner scan) {
        if (scan.hasNextLine())
            scan.nextLine();
    }

    public static boolean getNome(String nome,Scanner scan){
        boolean padraoNome = false;
        while(padraoNome == false){
            
            if(nome.matches("^[a-zA-Zá-úÀ-Ù\\s]+$")){
                padraoNome = true;
            }else{
                System.out.print("\nPadrão de nome incorreto, tente novamente: ");
                nome = scan.nextLine();
            }
        }
        return padraoNome;
    }

    public static boolean getCpf(String cpf,Scanner scan){
        boolean padraoCpf = false;
        while(padraoCpf == false){
            if(cpf.matches("^\\d{3}.\\d{3}.\\d{3}-\\d{2}$")){
                padraoCpf = true;
            }else{
                System.out.print("\nPadrão de CPF incorreto, tente novamente: ");
                cpf = scan.nextLine();
            }
        }
        return padraoCpf;
     }

    public static boolean getTelefone(String telefone,Scanner scan){
        boolean padraoTelefone = false;
        while(padraoTelefone == false){
            if(telefone.matches("^\\d{5}-\\d{4}$")){
                padraoTelefone = true;
            }else{
                System.out.print("\nPadrão de Telefone incorreto, tente novamente: ");
                telefone = scan.nextLine();
            }
        }
        return padraoTelefone;
     }

    public static boolean getEmail(String email,Scanner scan){
        boolean padraoEmail = false;
        while(padraoEmail == false){
            if(email.matches("^[a-z0-9._]+@[a-z]+\\.([a-z]{3,})(\\.[a-z]{2,})?$")){
                padraoEmail = true;
            }else{
                System.out.print("\nPadrão de email incorreto, tente novamente: ");
                email = scan.nextLine();
            }
        }
        return padraoEmail;
    }

    public static boolean getData(String data,Scanner scan){
        boolean padraoData = false;
        while(padraoData == false){
            if(data.matches("^\\d{2}\\/\\d{2}\\/\\d{2,4}$")){
                padraoData = true;
            }else{
                System.out.print("\nPadrão de data incorreto, tente novamente: ");
                data = scan.nextLine();
            }
        }
        return padraoData;
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
}
