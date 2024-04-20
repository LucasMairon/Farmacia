package br.com.farmacia.models.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

import br.com.farmacia.models.entidade.Cliente;



public class ClienteDAO {

    public static Connection conn;

    public static Cliente pegar(int id) throws SQLException {
        Cliente cliente = null;
        String sql = "SELECT id_cliente, nome, cpf, sexo, nascimento, telefone, email, estado, cidade, bairro, rua, numero_da_casa, complemento from cliente where id_cliente = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            cliente = new Cliente();
            cliente.setIdCliente(rs.getInt("id_cliente"));
            cliente.setNome(rs.getString("nome"));
            cliente.setCpf(rs.getString("cpf"));
            cliente.setSexo(rs.getString("sexo"));
            cliente.setNascimento(rs.getString("nascimento"));
            cliente.setTelefone(rs.getString("telefone"));
            cliente.setEmail(rs.getString("email"));
            cliente.setEstado(rs.getString("estado"));
            cliente.setCidade(rs.getString("cidade"));
            cliente.setBairro(rs.getString("bairro"));
            cliente.setRua(rs.getString("rua"));
            cliente.setNumeroDaCasa(rs.getString("numero_da_casa"));
            cliente.setComplemento(rs.getString("complemento"));
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);
        return cliente;
    }

    public static ArrayList<Cliente> pegarTodos() throws SQLException {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        Cliente cliente = null;
        String sql = "SELECT id_cliente, nome, cpf, sexo, nascimento, telefone, email, estado, cidade, bairro, rua, numero_da_casa, complemento from cliente";
        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            cliente = new Cliente();
            cliente.setIdCliente(rs.getInt("id_cliente"));
            cliente.setNome(rs.getString("nome"));
            cliente.setCpf(rs.getString("cpf"));
            cliente.setSexo(rs.getString("sexo"));
            cliente.setNascimento(rs.getString("nascimento"));
            cliente.setTelefone(rs.getString("telefone"));
            cliente.setEmail(rs.getString("email"));
            cliente.setEstado(rs.getString("estado"));
            cliente.setCidade(rs.getString("cidade"));
            cliente.setBairro(rs.getString("bairro"));
            cliente.setRua(rs.getString("rua"));
            cliente.setNumeroDaCasa(rs.getString("numero_da_casa"));
            cliente.setComplemento(rs.getString("complemento"));
            clientes.add(cliente);
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);
        return clientes;
    }

    public static int inserir(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO cliente (nome, cpf, sexo, nascimento, telefone, email, estado, cidade, bairro, rua, numero_da_casa, complemento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getCpf());
        ps.setString(3, cliente.getSexo());
        ps.setString(4, cliente.getNascimento());
        ps.setString(5, cliente.getTelefone());
        ps.setString(6, cliente.getEmail());
        ps.setString(7, cliente.getEstado());
        ps.setString(8, cliente.getCidade());
        ps.setString(9, cliente.getBairro());
        ps.setString(10, cliente.getRua());
        ps.setString(11, cliente.getNumeroDaCasa());
        ps.setString(12, cliente.getComplemento());
        int resultado = ps.executeUpdate();
        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

    public static int atualizar(Cliente cliente) throws SQLException {
        String sql = "UPDATE cliente set nome = ?, cpf = ?, sexo = ?, nascimento = ?, telefone = ?, email = ?, estado = ?, cidade = ?, bairro = ?, rua = ?, numero_da_casa = ?, complemento = ? WHERE id_cliente = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getCpf());
        ps.setString(3, cliente.getSexo());
        ps.setString(4, cliente.getNascimento());
        ps.setString(5, cliente.getTelefone());
        ps.setString(6, cliente.getEmail());
        ps.setString(7, cliente.getEstado());
        ps.setString(8, cliente.getCidade());
        ps.setString(9, cliente.getBairro());
        ps.setString(10, cliente.getRua());
        ps.setString(11, cliente.getNumeroDaCasa());
        ps.setString(12, cliente.getComplemento());
        ps.setInt(13, cliente.getIdCliente());

        int resultado = ps.executeUpdate();
        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

    public static int salvar(Cliente cliente) throws SQLException {
        int resultado = 0;
        if (cliente.getIdCliente() != 0)
            resultado = atualizar(cliente);
        else
            resultado = inserir(cliente);
        return resultado;
    }

    public static int deletar(Cliente cliente) throws SQLException {
        String sql = "DELETE FROM cliente WHERE id_cliente = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, cliente.getIdCliente());

        int resultado = ps.executeUpdate();

        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }

}
