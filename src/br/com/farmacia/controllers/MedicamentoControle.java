package br.com.farmacia.controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.farmacia.models.DAO.LoteDAO;
import br.com.farmacia.models.DAO.MedicamentoDAO;
import br.com.farmacia.models.entidade.Lote;
import br.com.farmacia.models.entidade.Medicamento;

public class MedicamentoControle {

    public static void cadastrar(String nome, String descricao, double preco) {
        Medicamento medicamento = new Medicamento(nome, descricao, preco);
        try {
            MedicamentoDAO.salvar(medicamento);
            System.out.println("Medicamneto cadastrado com sucesso");
        } catch (SQLException e) {
            System.out.println("Error ao salvar o medicamento");
        }
    }

    public static void atualizar(int idMedicamento, String nome, String descricao, double preco) {

        try {
            Medicamento medicamento = MedicamentoDAO.pegar(idMedicamento);
            if (medicamento == null) {
                System.out.println("Medicamento não encontrado");
                return;
            }
            medicamento.editarMedicamento(nome, descricao, preco);
            MedicamentoDAO.salvar(medicamento);
            System.out.println("Medicamento atualizado");
            System.out.println(medicamento.toString() + '\n');
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o medicamento");
        }
    }

    public static void deletar(int idMedicamento) {
        try {
            Medicamento medicamento = MedicamentoDAO.pegar(idMedicamento);
            if (medicamento == null) {
                System.out.println("Medicamento não encontrado");
                return;
            }
            MedicamentoDAO.deletar(medicamento);
        } catch (SQLException e) {
            System.out.println("Erro ao deletar o medicamento");
        }
    }

    public static void listarMedicamentos() {
        try {
            ArrayList<Medicamento> medicamentos = MedicamentoDAO.pegarTodos();
            if (medicamentos.size() == 0) {
                System.out.println("Não há medicamentos para listar");
                return;
            }
            System.out.println("\nMedicamentos disponíveis na farmacia:\n");
            for (Medicamento medicamento : medicamentos)
                System.out.println(medicamento + "\n");
        } catch (SQLException e) {
            System.out.println("Erro ao listar os medicamentos");
        }
    }

    public static void visualizarMedicamento(int idMedicamento) {
        Medicamento medicamento;
        try {
            medicamento = MedicamentoDAO.pegar(idMedicamento);
            if (medicamento == null) {
                System.out.println("Medicamento não encontrado");
                return;
            }
            System.out.println(medicamento);
            LoteControle.listarLotes(idMedicamento);
        } catch (SQLException e) {
            System.out.println("Erro ao visualizar medicamento");
        }
    }

    public static void visualizarLotesDoMedicamento(int idMedicamento) {
        Medicamento medicamento;
        try {
            medicamento = MedicamentoDAO.pegar(idMedicamento);
            if (medicamento == null) {
                System.out.println("Medicamento não encontrado");
                return;
            }
            System.out.println(medicamento);
        } catch (SQLException e) {
            System.out.println("Erro ao visualizar medicamento");
        }
    }

    public static void adicionarLoteAoMedicamento(int idMedicamento, String loteCodigo, int quantidadeEmEstoque, String fabricacao, String validade) {
        Lote novo_Lote = new Lote(quantidadeEmEstoque, validade, fabricacao, loteCodigo);
        try {
            LoteDAO.salvar(novo_Lote, idMedicamento);
            System.out.println("Lote adicionado ao medicamento");
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar o lote ao medicamento");
        }
    }

    public static void removerLoteDoMedicamento(Medicamento medicamento, Lote lote) {
        try {
            LoteDAO.deletar(lote, medicamento.getIdMedicamento());
            System.out.println("Medicamento deletado com sucesso");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar o medicamento");
        }
    }

}
