import java.sql.*;
import java.util.Scanner;


public class TestaCodigo {
    public static void main(final String[] args) throws SQLException {

        //Chamada da classe das funções
        Funcoes funcoes = new Funcoes();
        Scanner scanner = new Scanner(System.in);

        //Realização do inicio das instruções
        int entrada;
        int [] resultado = new int[5];

        do {
            //Tela inicial do console
            System.out.println("1 - Cadastrar novos Produto");
            System.out.println("2 - Alterar Produto");
            System.out.println("3 - Deletar Segundo Produto");
            entrada = scanner.nextInt();

            // Utilizado o método Switch Case para realizar as operações

            switch (entrada) {
                //método Salvar
                case 1:
                    Produto produto1 = new Produto( "IMPRESSORA", "IMPRESSORA HP COM CARTUCHO PRETO", 1.0, 399.99);
                    resultado[0] = funcoes.salvar(produto1);

                    Produto produto2 = new Produto( "FONE", "JBL", 3.0, 600.00);
                    resultado[1] = funcoes.salvar(produto2);

                    Produto produto3 = new Produto("CONTROLE", "XBOX", 5.0, 200.00);
                    resultado[2] = funcoes.salvar(produto3);

                    System.out.println("Produtos Cadastrados!");
                    break;

                // método alterar
                case 2:
                    funcoes.alterar("IMPRESSORA MULTIFUNCIONAL", "HP MULTI", resultado[0]);
                    System.out.println("Produto Alterado!");
                    break;
                //método Deletar
                case 3:
                    funcoes.deletar(resultado[1]);
                    System.out.println("Produto Deletado!");
                    break;
            }
            System.out.println("Realizado as Alterações!!");

        } while (entrada != 0);

        System.out.println("Finalizado Aplicação!!");
    }
}