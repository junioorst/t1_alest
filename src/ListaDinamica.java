public class ListaDinamica {
    private Nodo inicio;

    private class Nodo {
        private String palavra;
        private Nodo proximo;

        private Nodo(String palavra) {
            this.palavra = palavra;
            this.proximo = null;
        }
    }

    public void adicionar(String palavra) {
        Nodo novo = new Nodo(palavra);

        if (inicio == null) {
            inicio = novo;
        } else {
            Nodo atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novo;
        }
    }

    public void exibir() {
        Nodo atual = inicio;
        if (atual == null) {
            System.out.println("Não há palíndromos no texto.");
        } else {
            while (atual != null) {
                System.out.println(atual.palavra);
                atual = atual.proximo;
            }
        }
    }
}
