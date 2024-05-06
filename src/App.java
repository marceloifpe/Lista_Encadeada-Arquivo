import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {

        ListaEncadeada listaEncadeada = new ListaEncadeada();

        File file = new File("src/arq.txt");
        Scanner scanner = new Scanner(file);

        String initialList = scanner.nextLine();
        String[] valores = initialList.split(" ");
        for (String valor : valores) {
            listaEncadeada.inserirNoFinal(Integer.parseInt(valor));
        }

        int numAcoes = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numAcoes; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");

            if (parts.length >= 3) {
                String nomeAcao = parts[0];
                int numero = Integer.parseInt(parts[1]);
                int posicao = Integer.parseInt(parts[2]);

                if (nomeAcao.equals("A")) {
                    listaEncadeada.adicionarNaPosicao(posicao, numero);
                } else if (nomeAcao.equals("R")) {
                    listaEncadeada.removerPrimeiraOcorrencia(numero);
                } else if (nomeAcao.equals("P")) {
                    listaEncadeada.imprimirLista();
                }
            } else {
                System.out.println("Formato inválido nessa linha: " + line);
            }
        }

        // Imprimindo a lista final
        listaEncadeada.imprimirLista();

        scanner.close();
    }
}
