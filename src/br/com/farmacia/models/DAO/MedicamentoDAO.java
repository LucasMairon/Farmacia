package br.com.farmacia.models.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

import br.com.farmacia.models.entidade.Medicamento;

public class MedicamentoDAO {

    public static Connection conn;

    public static Medicamento pegar(int id) throws SQLException {
        Medicamento medicamento = null;
        String sql = "SELECT id_medicamento, nome, descricao,preco from medicamento where id_medicamento = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            medicamento = new Medicamento();
            medicamento.setIdMedicamento(rs.getInt("id_medicamento"));
            medicamento.setNome(rs.getString("nome"));
            medicamento.setDescricao(rs.getString("descricao"));
            medicamento.setPreco(rs.getDouble("preco"));
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);
        return medicamento;
    }

    public static ArrayList<Medicamento> pegarTodos() throws SQLException {
        ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();
        Medicamento medicamento = null;
        String sql = "SELECT id_medicamento, nome, descricao, preco from medicamento";
        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            medicamento = new Medicamento();
            medicamento.setIdMedicamento(rs.getInt("id_medicamento"));
            medicamento.setNome(rs.getString("nome"));
            medicamento.setDescricao(rs.getString("descricao"));
            medicamento.setPreco(rs.getDouble("preco"));
            medicamentos.add(medicamento);
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);
        return medicamentos;
    }

    public static int inserir(Medicamento medicamento) throws SQLException {
        String sql = "INSERT INTO medicamento (nome, descricao, preco) VALUES (?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, medicamento.getNome());
        ps.setString(2, medicamento.getDescricao());
        ps.setDouble(3, medicamento.getPreco());
        int resultado = ps.executeUpdate();
        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

    public static int atualizar(Medicamento medicamento) throws SQLException {
        String sql = "UPDATE medicamento set nome = ?, descricao = ?, preco = ? WHERE id_medicamento = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, medicamento.getNome());
        ps.setString(2, medicamento.getDescricao());
        ps.setDouble(3, medicamento.getPreco());
        ps.setInt(4, medicamento.getIdMedicamento());

        int resultado = ps.executeUpdate();
        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

    public static int salvar(Medicamento medicamento) throws SQLException {
        int resultado = 0;
        if (medicamento.getIdMedicamento() != 0)
            resultado = atualizar(medicamento);
        else
            resultado = inserir(medicamento);
        return resultado;
    }

    public static int deletar(Medicamento medicamento) throws SQLException {
        String sql = "DELETE FROM medicamento WHERE id_medicamento = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, medicamento.getIdMedicamento());

        int resultado = ps.executeUpdate();

        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

}