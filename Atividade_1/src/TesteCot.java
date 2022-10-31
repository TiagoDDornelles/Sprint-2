
import java.sql.Connection;
import java.sql.SQLException;

// Classe para apenas realizar a consulta se esta ocorrendo a consulta com o Banco de DadosS
public class TesteCot {

    public static void main(String[] args) throws SQLException {
        ConexaoBanco conexaoBanco = new ConexaoBanco();
        Connection connection = conexaoBanco.recuperarConexao();

        System.out.println("Fechando conex�o!!");

        connection.close();
    }
}
