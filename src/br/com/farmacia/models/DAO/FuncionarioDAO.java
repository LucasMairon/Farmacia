package br.com.farmacia.models.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

import br.com.farmacia.models.entidade.Funcionario;



public class FuncionarioDAO { 

    public static Connection conn;

    public static Funcionario pegar(int id) throws SQLException {
        Funcionario funcionario = null;
        String sql = "SELECT id_funcionario, nome, cpf, sexo, nascimento, telefone, email, estado, cidade, bairro, rua, numero_da_casa, complemento, salario, cargo, senha, is_admin from funcionario where id_funcionario = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            funcionario = new Funcionario();
            funcionario.setIdFuncionario(rs.getInt("id_funcionario"));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setCpf(rs.getString("cpf"));
            funcionario.setSexo(rs.getString("sexo"));
            funcionario.setNascimento(rs.getString("nascimento"));
            funcionario.setTelefone(rs.getString("telefone"));
            funcionario.setEmail(rs.getString("email"));
            funcionario.setEstado(rs.getString("estado"));
            funcionario.setCidade(rs.getString("cidade"));
            funcionario.setBairro(rs.getString("bairro"));
            funcionario.setRua(rs.getString("rua"));
            funcionario.setNumeroDaCasa(rs.getString("numero_da_casa"));
            funcionario.setComplemento(rs.getString("complemento"));
            funcionario.setSalario(rs.getDouble("salario"));
            funcionario.setCargo(rs.getString("cargo"));
            funcionario.setSenha(rs.getString("senha"));
            funcionario.setAdmin(rs.getBoolean("is_admin"));
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);
        return funcionario;
    }

    public static int count() throws SQLException {
        int quantidadeFuncionarios = 0;
        String sql = "select count(*) from funcionario;";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
           quantidadeFuncionarios = rs.getInt("count");
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);
        return quantidadeFuncionarios;
    }

    public static ArrayList<Funcionario> pegarTodos() throws SQLException {
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        Funcionario funcionario = null;
        String sql = "SELECT id_funcionario, nome, cpf, sexo, nascimento, telefone, email, estado, cidade, bairro, rua, numero_da_casa, complemento, salario, cargo, senha, usuario, is_admin from funcionario";
        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            funcionario = new Funcionario();
            funcionario.setIdFuncionario(rs.getInt("id_funcionario"));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setCpf(rs.getString("cpf"));
            funcionario.setSexo(rs.getString("sexo"));
            funcionario.setNascimento(rs.getString("nascimento"));
            funcionario.setTelefone(rs.getString("telefone"));
            funcionario.setEmail(rs.getString("email"));
            funcionario.setEstado(rs.getString("estado"));
            funcionario.setCidade(rs.getString("cidade"));
            funcionario.setBairro(rs.getString("bairro"));
            funcionario.setRua(rs.getString("rua"));
            funcionario.setNumeroDaCasa(rs.getString("numero_da_casa"));
            funcionario.setComplemento(rs.getString("complemento"));
            funcionario.setSalario(rs.getDouble("salario"));
            funcionario.setCargo(rs.getString("cargo"));
            funcionario.setSenha(rs.getString("senha"));
            funcionario.setAdmin(rs.getBoolean("is_admin"));
            funcionarios.add(funcionario);
        }
        BancoDeDados.fecharResultSet(rs);
        BancoDeDados.fecharPreparedStatement(ps);
        return funcionarios;
    }


    public static int inserir(Funcionario funcionario) throws SQLException {
        String sql = "INSERT INTO funcionario (nome, cpf, sexo, nascimento, telefone, email, estado, cidade, bairro, rua, numero_da_casa, complemento, salario, cargo, senha, is_admin) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, funcionario.getNome());
        ps.setString(2, funcionario.getCpf());
        ps.setString(3,funcionario.getSexo());
        ps.setString(4, funcionario.getNascimento());
        ps.setString(5, funcionario.getTelefone());
        ps.setString(6, funcionario.getEmail());
        ps.setString(7, funcionario.getEstado());
        ps.setString(8, funcionario.getCidade());
        ps.setString(9, funcionario.getBairro());
        ps.setString(10, funcionario.getRua());
        ps.setString(11, funcionario.getNumeroDaCasa());
        ps.setString(12, funcionario.getComplemento());
        ps.setDouble(13, funcionario.getSalario());
        ps.setString(14, funcionario.getCargo());
        ps.setString(15, funcionario.getSenha());
        ps.setBoolean(16, funcionario.getAdmin());
        int resultado = ps.executeUpdate();
        BancoDeDados.fecharPreparedStatement(ps);
        return resultado;
    }


    public static int atualizar(Funcionario funcionario) throws SQLException {
        String sql = "UPDATE funcionario set nome = ?, cpf = ?, sexo = ?, nascimento = ?, telefone = ?, email = ?, estado = ?, cidade = ?, bairro = ?, rua = ?, numero_da_casa = ?, complemento = ?, salario = ?, cargo = ?, senha = ?, is_admin = ? WHERE id_funcionario = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, funcionario.getNome());
        ps.setString(2, funcionario.getCpf());
        ps.setString(3,funcionario.getSexo());
        ps.setString(4, funcionario.getNascimento());
        ps.setString(5, funcionario.getTelefone());
        ps.setString(6, funcionario.getEmail());
        ps.setString(7, funcionario.getEstado());
        ps.setString(8, funcionario.getCidade());
        ps.setString(9, funcionario.getBairro());
        ps.setString(10, funcionario.getRua());
        ps.setString(11, funcionario.getNumeroDaCasa());
        ps.setString(12, funcionario.getComplemento());
        ps.setDouble(13, funcionario.getSalario());
        ps.setString(14, funcionario.getCargo());
        ps.setString(15, funcionario.getSenha());
        ps.setBoolean(16, funcionario.getAdmin());
        ps.setInt(17, funcionario.getIdFuncionario());

        int resultado = ps.executeUpdate();
        BancoDeDados.fecharPreparedStatement(ps);
        return resultado; 
    }


    public static void salvar(Funcionario funcionario) throws SQLException {
        if (funcionario.getIdFuncionario() != 0)
            atualizar(funcionario);
        else
            inserir(funcionario);
    }


    public static int deletar(Funcionario funcionario) throws SQLException {
        String sql = "DELETE FROM funcionario WHERE id_funcionario = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, funcionario.getIdFuncionario());

        int resultado = ps.executeUpdate();

        BancoDeDados.fecharPreparedStatement(ps);
        return resultado; 
    }

}

