package br.com.farmacia;

import java.util.Scanner;

import br.com.farmacia.models.DAO.BancoDeDados;
import br.com.farmacia.views.MenuLote;
import br.com.farmacia.views.MenuMedicamento;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);
        BancoDeDados.iniciarConexao();
        MenuMedicamento.scan = scan;
        MenuLote.scan = scan;
        MenuMedicamento.main();
        scan.close();
        BancoDeDados.fecharConexao();
    }
}
