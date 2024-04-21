package br.com.farmacia.models.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.farmacia.models.entidade.Pedido;
import br.com.farmacia.models.entidade.Medicamento;
import br.com.farmacia.controllers.ClienteControle;
import br.com.farmacia.models.entidade.Lote;

public class PedidoDAO {

    public static Connection conn;

    public static Pedido pegar(int id) throws SQLException {
        Pedido pedido = null;
        String sql = "SELECT id_pedido, id_cliente, data_pedido, valor_total, status from pedido where id_pedido = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            pedido = new Pedido();
            pedido.setIdPedido(rs.getInt("id_pedido"));
            pedido.setCliente(ClienteControle.buscarCliente(rs.getInt("id_cliente")));
            pedido.setData(rs.getString("data_pedido"));
            pedido.setValorTotal(rs.getDouble("valor_total"));
            pedido.setStatus(rs.getBoolean("status"));
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);
        return pedido;
    }


    public static ArrayList<Pedido> pegarTodos() throws SQLException {
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
        Pedido pedido = null;
        String sql = "SELECT id_pedido, id_cliente, data_pedido, valor_total, status from pedido";
        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            pedido = new Pedido();
            pedido.setIdPedido(rs.getInt("id_pedido"));
            pedido.setCliente(ClienteControle.buscarCliente(rs.getInt("id_cliente")));
            pedido.setData(rs.getString("data_pedido"));
            pedido.setValorTotal(rs.getDouble("valor_total"));
            pedido.setStatus(rs.getBoolean("status"));
            pedidos.add(pedido);
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);
        return pedidos;
    }


    public static int inserirPedido(Pedido pedido) throws SQLException {
        String sql = "INSERT INTO pedido (id_cliente, data_pedido, valor_total, status) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, pedido.getCliente().getIdCliente());
        ps.setString(2, pedido.getData());
        ps.setDouble(3, pedido.getValorTotal());
        ps.setBoolean(4, pedido.getStatus());

        int resultado = ps.executeUpdate();
        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }


    public static int atualizarPedido(Pedido pedido) throws SQLException {
        String sql = "UPDATE pedido set status = ? WHERE id_pedido = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setBoolean(1, pedido.getStatus());
        ps.setInt(2, pedido.getIdPedido());

        int resultado = ps.executeUpdate();
        BancoDeDados.fecharPreparedStatement(ps);
        return resultado; 
    }


    public static void salvarPedido(Pedido pedido) throws SQLException {

        if (pedido.getIdPedido() != 0)
            atualizarPedido(pedido);
        else
            inserirPedido(pedido);
    }

    public static int deletarPedido(Pedido pedido) throws SQLException {
        String sql = "DELETE FROM pedido WHERE id_pedido = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, pedido.getIdPedido());

        int resultado = ps.executeUpdate();

        BancoDeDados.fecharPreparedStatement(ps);
        return resultado; 
    }

}

