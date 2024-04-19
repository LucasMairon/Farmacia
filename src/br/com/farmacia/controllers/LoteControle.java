package br.com.farmacia.controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.farmacia.models.DAO.LoteDAO;
import br.com.farmacia.models.DAO.MedicamentoDAO;
import br.com.farmacia.models.entidade.Lote;
import br.com.farmacia.models.entidade.Medicamento;

public class LoteControle {


    public static void visualizarLote(int idMedicamento, int id_lote) {
        try {
            Lote lote = LoteDAO.pegar(idMedicamento, id_lote);
            Medicamento medicamento = MedicamentoDAO.pegar(idMedicamento);
            if (lote == null) {
                System.out.println("Lote do medicamento " + medicamento.getNome() + " não encontrado");
                return;
            }
            System.out.println("Lote do medicamento: " + medicamento.getNome());
            System.out.println(lote);
        } catch (SQLException e) {
            System.out.println("Erro ao visualizar o lote");
        }
    }

    public static void listarLotes(int idMedicamento) {
        try {
            Medicamento medicamento = MedicamentoDAO.pegar(idMedicamento);
            ArrayList<Lote> lotes = LoteDAO.pegarTodos(idMedicamento);
            if (lotes.size() == 0) {
                System.out.println("Ainda não foram adicionados lotes ao medicamento: " + medicamento.getNome());
                return;
            }
            System.out.println("Listando lotes do Medicamento: " + medicamento.getNome() + "\n");
            for (Lote lote : lotes) {
                System.out.println(lote);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar lotes do medicamento");
        }
    }

    public static void editarLote(int idMedicamento, int idLote, String loteCodigo, int quantidadeEmEstoque,
            String fabricacao, String validade) {
        Lote lote;
        try {
            lote = LoteDAO.pegar(idMedicamento, idLote);
            lote.editarLote(loteCodigo, quantidadeEmEstoque, fabricacao, validade);
            LoteDAO.salvar(lote, idMedicamento);
        } catch (SQLException e) {
            System.out.println("Erro ao editar o lote");
        }

    }

    public static void deletarLote(int idLote, int idMedicamento) {
        try {
            Lote lote = LoteDAO.pegar(idMedicamento, idLote);
            if (lote == null) {
                System.out.println("Lote não encontrado");
                return;
            }
            LoteDAO.deletar(lote, idMedicamento);
            System.out.println("Lote deletado com sucesso");
        } catch (SQLException e) {
            System.out.println("erro ao deletar o lote: " + e.getMessage());
        }
    }

}
