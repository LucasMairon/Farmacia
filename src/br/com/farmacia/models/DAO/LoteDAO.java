package br.com.farmacia.models.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

import br.com.farmacia.models.entidade.Lote;

/**
 * LoteBD
 */
public class LoteDAO {

    public static Connection conn;

    public static Lote pegar(int idMedicamento, int idLote) throws SQLException {
        Lote lote = null;
        String sql = "SELECT l.id_lote, l.lote_codigo, l.fabricacao, l.validade, e.qtd_estoque FROM lote AS l INNER JOIN estoque AS e ON l.id_lote = e.id_lote WHERE l.id_lote = ? AND l.id_med = ?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idLote);
        ps.setInt(2, idMedicamento);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            lote = new Lote();
            lote.setIdLote(rs.getInt("id_lote"));
            lote.setLoteCodigo("lote_codigo");
            lote.setQuantidadeEmEstoque(rs.getInt("qtd_estoque"));
            lote.setValidade(rs.getString("validade"));
            lote.setFabricacao(rs.getString("fabricacao"));
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);
        return lote;
    }

    public static Lote pegar(int idMedicamento, int idLote, int idPedido) throws SQLException {
        Lote lote = null;
        String sql = "SELECT l.id_lote, l.lote_codigo, l.fabricacao, l.validade, e.qtd_estoque FROM lote AS l INNER JOIN estoque AS e ON l.id_lote = e.id_lote WHERE l.id_lote = ? AND e.id_ped = ?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idLote);
        ps.setInt(1, idPedido);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            lote = new Lote();
            lote.setIdLote(rs.getInt("id_lote"));
            lote.setLoteCodigo(rs.getString("lote_codigo"));
            lote.setQuantidadeEmEstoque(rs.getInt("qtd_estoque"));
            lote.setValidade(rs.getString("validade"));
            lote.setFabricacao(rs.getString("fabricacao"));
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);
        return lote;
    }

    public static ArrayList<Lote> pegarTodos(int idMedicamento) throws SQLException {
        ArrayList<Lote> lotes = new ArrayList<Lote>();
        Lote lote = null;

        String sql = "SELECT l.id_lote, l.lote_codigo, l.fabricacao, l.validade, e.qtd_estoque FROM lote AS l INNER JOIN estoque AS e on l.id_lote = e.id_lote WHERE l.id_med = ?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idMedicamento);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            lote = new Lote();
            lote.setIdLote(rs.getInt("id_lote"));
            lote.setLoteCodigo(rs.getString("lote_codigo"));
            lote.setQuantidadeEmEstoque(rs.getInt("qtd_estoque"));
            lote.setValidade(rs.getString("validade"));
            lote.setFabricacao(rs.getString("fabricacao"));
            lotes.add(lote);
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);
        return lotes;
    }

    public static Lote pegarIdLote(Lote lote) throws SQLException {
        String sql = "SELECT l.id_lote  from lote AS l WHERE l.lote_codigo = ?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, lote.getLoteCodigo());

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            lote.setIdLote(rs.getInt("id_lote"));
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);
        return lote;
    }

    public static int inserir(Lote lote, int idMedicamento) throws SQLException {
        String sql = "INSERT INTO lote (lote_codigo, fabricacao, validade, id_med) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, lote.getLoteCodigo());
        ps.setString(2, lote.getFabricacao());
        ps.setString(3, lote.getValidade());
        ps.setInt(4, idMedicamento);

        int resultado = ps.executeUpdate();
        BancoDeDados.fecharPreparedStatement(ps);
        pegarIdLote(lote);
        EstoqueDAO.inserir(lote);
        return resultado;
    }

    public static int atualizar(Lote lote, int idMedicamento) throws SQLException {
        String sql = "UPDATE lote set lote_codigo = ?, fabricacao = ?, validade = ? , id_med = ? WHERE id_lote = ?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, lote.getLoteCodigo());
        ps.setString(2, lote.getFabricacao());
        ps.setString(3, lote.getValidade());
        ps.setInt(4, idMedicamento);
        ps.setInt(5, lote.getIdLote());

        int resultado = ps.executeUpdate();
        BancoDeDados.fecharPreparedStatement(ps);
        EstoqueDAO.atualizar(lote);
        return resultado;
    }

    public static void salvar(Lote lote, int idMedicamento) throws SQLException {
        if (lote.getIdLote() != 0)
            atualizar(lote, idMedicamento);
        else
            inserir(lote, idMedicamento);
    }

    public static int deletar(Lote lote, int idMedicamento) throws SQLException {
        int resultado = EstoqueDAO.deletar(lote);
        if (resultado == 0)
            return resultado;

        String sql = "DELETE FROM lote WHERE id_lote = ? AND id_med = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, lote.getIdLote());
        ps.setInt(2, idMedicamento);
        resultado = ps.executeUpdate();
        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }
}
