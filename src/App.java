import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws FileNotFoundException {

        ListaEncadeada lista1 = new ListaEncadeada();
        processarArquivo("src/arq.txt", lista1);

        ListaEncadeada lista2 = new ListaEncadeada();
        processarArquivo("src/arq1.txt", lista2);
    }

    public static void processarArquivo(String nomeArquivo, ListaEncadeada listaEncadeada) {
        try {
            File file = new File(nomeArquivo);
            Scanner scanner = new Scanner(file);

            String[] numerosIniciais = scanner.nextLine().trim().split("\\s+");
            for (String numero : numerosIniciais) {
                listaEncadeada.inserirNoFinal(Integer.parseInt(numero));
            }

            int totalEntradas = Integer.parseInt(scanner.nextLine().trim());

            for (int i = 0; i < totalEntradas; i++) {
                String linha = scanner.nextLine().trim();
                String[] comando = linha.split("\\s+");

                if (comando.length < 2) {
                    System.out.println("Comando inválido: " + linha);
                    continue;
                }

                String nomeAcao = comando[0];
                int numero = Integer.parseInt(comando[1]);

                if (nomeAcao.equals("A") && comando.length == 3) {
                    int posicao = Integer.parseInt(comando[2]);
                    listaEncadeada.adicionarNaPosicao(posicao, numero);
                } else if (nomeAcao.equals("R")) {
                    listaEncadeada.remover(numero);
                } else if (nomeAcao.equals("P")) {
                    listaEncadeada.imprimirLista();
                } else {
                    System.out.println("Comando inválido: " + linha);
                }
            }

            System.out.println("Lista final após o processamento do arquivo " + nomeArquivo + ":");
            listaEncadeada.imprimirLista();
            System.out.println();

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + nomeArquivo);
        }
    }
}