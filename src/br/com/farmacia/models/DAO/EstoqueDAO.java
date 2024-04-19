package br.com.farmacia.models.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.farmacia.models.entidade.Lote;

public class EstoqueDAO {
    public static Connection conn;

    public static int inserir(Lote lote) throws SQLException {
        String sql = "INSERT INTO estoque (id_lote, qtd_estoque) VALUES (?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, lote.getIdLote());
        ps.setInt(2, lote.getQuantidadeEmEstoque());
        int resultado = ps.executeUpdate();
        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

    public static int inserir(Lote lote, int idPedido) throws SQLException {
        String sql = "INSERT INTO estoque (id_ped, id_lote, qtd_estoque) VALUES (?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idPedido);
        ps.setInt(2, lote.getIdLote());
        ps.setInt(3, lote.getQuantidadeEmEstoque());
        int resultado = ps.executeUpdate();
        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

    public static int atualizar(Lote lote) throws SQLException {
        String sql = "UPDATE estoque SET qtd_estoque = ? WHERE id_lote = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, lote.getQuantidadeEmEstoque());
        ps.setInt(2, lote.getIdLote());

        int resultado = ps.executeUpdate();
        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

    public static int atualizar(Lote lote, int idPedido) throws SQLException {
        String sql = "UPDATE estoque SET qtd_estoque = ? WHERE id_lote = ? AND id_ped = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, lote.getQuantidadeEmEstoque());
        ps.setInt(2, lote.getIdLote());
        ps.setInt(3, idPedido);

        int resultado = ps.executeUpdate();
        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

    public static int deletar(Lote lote) throws SQLException {
        String sql = "DELETE FROM estoque WHERE id_lote = ? AND id_ped IS null";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, lote.getIdLote());

        int resultado = ps.executeUpdate();

        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

    public static int deletar(Lote lote, int idPedido) throws SQLException {
        String sql = "DELETE FROM estoque WHERE id_lote = ? AND id_ped = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, lote.getIdLote());
        ps.setInt(1, idPedido);

        int resultado = ps.executeUpdate();

        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }
}
