public class ListaEncadeada {
    No cabeca;

    public void remover(int numero) {
        if (cabeca == null) {
            System.out.println("Lista vazia");
            return;
        }
        if (cabeca.dado == numero) {
            cabeca = cabeca.proximo;
            return;
        }
        No atual = cabeca;
        while (atual.proximo != null) {
            if (atual.proximo.dado == numero) {
                atual.proximo = atual.proximo.proximo;
                return;
            }
            atual = atual.proximo;
        }
        System.out.println("Elemento não encontrado: " + numero);
    }

    public void inserirNoFinal(int dado) {
        No novoNo = new No(dado);
        if (cabeca == null) {
            cabeca = novoNo;
            return;
        }
        No atual = cabeca;
        while (atual.proximo != null) {
            atual = atual.proximo;
        }
        atual.proximo = novoNo;
    }

    public void imprimirLista() {
        No atual = cabeca;
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    public void adicionarNaPosicao(int posicao, int dado) {
        if (posicao == 1) {
            No novoNo = new No(dado);
            novoNo.proximo = cabeca;
            cabeca = novoNo;
            return;
        }
        No atual = cabeca;
        for (int i = 1; i < posicao - 1 && atual != null; i++) {
            atual = atual.proximo;
        }
        if (atual == null) {
            System.out.println("Posição fora do alcance");
            return;
        }
        No novoNo = new No(dado);
        novoNo.proximo = atual.proximo;
        atual.proximo = novoNo;
    }
}