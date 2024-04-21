package br.com.farmacia.models.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BancoDeDados {
    private static String driver = "org.postgresql.Driver";
    private static String url = "jdbc:postgresql://localhost:5432/farmacia";
    private static String user = "postgres";
    private static String password = "postgres";

    private static Connection conn;

    private BancoDeDados() {
    }

    private static Connection getConnection() throws SQLException {
        if (conn == null)
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                System.out.println("Erro na conexão com o banco");
                e.printStackTrace();
            }
        return conn;
    }

    public static void iniciarConexao() throws SQLException {
        MedicamentoDAO.conn = getConnection();
        LoteDAO.conn = getConnection();
        EstoqueDAO.conn = getConnection();
        FuncionarioDAO.conn = getConnection();
        ClienteDAO.conn = getConnection();
        PedidoDAO.conn = getConnection();
    }

    public static void fecharConexao() throws SQLException {
        conn.close();
    }

    public static void fecharStatement(Statement statement) throws SQLException {
        statement.close();
    }

    public static void fecharPreparedStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.close();
    }

    public static void fecharResultSet(ResultSet resultSet) throws SQLException {
        resultSet.close();
    }
}

