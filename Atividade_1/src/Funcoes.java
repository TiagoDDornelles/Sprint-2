import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class Funcoes {

    private Connection connection;

    //Costrutor Padrão
    public Funcoes() {
        ConexaoBanco conexaoBanco = new ConexaoBanco();
        Connection connection = conexaoBanco.recuperarConexao();

    }

    //Realização do método Salvar, realizando a consulta com Banco de Dados
    public int salvar(Produto produto) {

        ConexaoBanco conexaoBanco = new ConexaoBanco();
        Connection connection = conexaoBanco.recuperarConexao();

        try {
            String sql = "INSERT INTO PRODUTO (nome, descricao, quantidade, preco) VALUES (?, ?, ?, ?)";

            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                pstm.setString(1,produto.getNome());
                pstm.setString(2, produto.getDescricao());
                pstm.setDouble(3, produto.getQuantidade());
                pstm.setDouble(4, produto.getPreco());

                pstm.execute();

                try (ResultSet rst = pstm.getGeneratedKeys()) {
                    while (rst.next()) {
                        produto.setId(rst.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return produto.getId();
    }

    //Realização do método Alterar, realizando a consulta com Banco de Dados
    public void alterar(String nome, String descricao, Integer id) {
        ConexaoBanco conexaoBanco = new ConexaoBanco();
        Connection connection = conexaoBanco.recuperarConexao();

        try (PreparedStatement stm = connection
                .prepareStatement("UPDATE PRODUTO P SET P.NOME = ?, P.DESCRICAO = ? WHERE ID = ?")) {
            stm.setString(1, nome);
            stm.setString(2, descricao);
            stm.setInt(3, id);
            stm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //Realização do método Deletar, realizando a consulta com Banco de Dados
    public void deletar(Integer id) {
        ConexaoBanco conexaoBanco = new ConexaoBanco();
        Connection connection = conexaoBanco.recuperarConexao();

        try (PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID = ?")) {
            stm.setInt(1, id);
            stm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
