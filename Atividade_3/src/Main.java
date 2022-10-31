import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Inicialização do meu Scanner para este método
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite Quantas vezes Deseja Determinar seus Sentimentos : ");
        int qtdSetimentos = Integer.valueOf(scanner.nextLine());

        // Definido meu Arrays
        String[] teste = new String[qtdSetimentos];

        var feliz = 0;
        var triste = 1;


        //declarado o método Split para comparar
        String s = (":-):-(");
        String[] strs = s.split("[:\\-\\)\\(]");

        for (int i = 0; i < qtdSetimentos; i++) {
            System.out.println("Informe o seu Sentimento: ");
            teste[i] = scanner.nextLine();
        }

        for (int i = 0; i < qtdSetimentos; i++) {

            int c = strs.length;

            //Comparação :-)
            if (teste[i].contains(":-)")) {
                feliz++;
                System.out.println(teste[i] + "\r\nSaída: divertido ");

                //Comparação :-(
            } else if (teste[i].contains(":-(")) {
                triste++;
                System.out.println(teste[i] + "\r\nSaída: chateado ");


                // Método de comparação ficou incompleto
            }
            if (feliz == triste) {
                if (c == ':' || c == '-' || c == ')' || c == '(') {
                    System.out.println(teste[i] + "\r\nSaída: neutro ");
                }

            }

        }
    }
}