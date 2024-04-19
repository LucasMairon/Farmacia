package br.com.farmacia.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Util {
    public static void limparBuffer(Scanner scan) {
        if (scan.hasNextLine())
            scan.nextLine();
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
