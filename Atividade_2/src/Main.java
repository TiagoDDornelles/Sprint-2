import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, SQLException {

        //chamada da classe de conexão ao banco de dados
        ConexaoBanco connectionFactory = new ConexaoBanco();
        Connection connection = connectionFactory.recuperarConexao();

        // Será solicitado para entrar com um usuario
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nome do usuario: ");
        String usuario = scanner.nextLine();

        // Arrays utilizadas
        String[] qtfilme = new String[1];
        String[] qtpag = new String[1];

        // Vai informar quantos filmes deseja filtrar e qual a página deseja acessar, foi utilizado a consulta no banco de dados utilizado um LIMIT para realizar a paginação
        for (int i = 0; i < 1; i++) {
            System.out.println("Informe quantos filmes deseja filtrar: " + usuario + "");
            qtfilme[i] = scanner.nextLine();
            System.out.println("Qual página deseja acessar: "+ usuario + "");
            qtpag[i] = scanner.nextLine();
        }

        PreparedStatement stm = connection.prepareStatement("SELECT ID, NOME, DESCRICAO, ANO FROM FILMES LIMIT "+qtpag[0]+","+qtfilme[0]);
        stm.execute();
        ResultSet rst = stm.getResultSet();

        while(rst.next()) {
            Integer id = rst.getInt("ID");
            String nome = rst.getString("NOME");
            String descricao = rst.getString("DESCRICAO");
            Integer ano = rst.getInt("ANO");
            System.out.println("ID: "+id+ " NOME: "+nome+ " DESCRIÇÃO: "+descricao+ " ANO: "+ano);

        }
        rst.close();
        stm.close();
        connection.close();

    }
}


