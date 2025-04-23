import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Aplicacao {
    private ListaEstatica listaEstatica;
    private ListaDinamica listaDinamica;

    public Aplicacao() {
        this.listaEstatica = new ListaEstatica();
        this.listaDinamica = new ListaDinamica();
    }

    public void executar(String caminhoArquivo) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(caminhoArquivo));
        StringBuilder texto = new StringBuilder();
        int contador = 0;
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] palavras = linha.split(" ");

            for (String word : palavras) {
                word = word.replaceAll("[^a-zA-Z]", "");
                texto.append(word.toLowerCase()).append(" ");
                contador++;
            }
        }
        String resultado = texto.toString();
        String[] palavrasSeparadas = resultado.split(" ");

        System.out.println("Caso de teste: Drácula");
        System.out.println("Total de palavras do texto: " + contador);

        verificarOcorrencias(palavrasSeparadas, contador);
        System.out.println("\nTop 20 palavras com mais ocorrências: ");
        listaEstatica.exibir();

        verificarPalindromo(palavrasSeparadas);
        System.out.println("\nPalíndromos:");
        listaDinamica.exibir();

    }


    public void verificarOcorrencias(String[] palavrasSeparadas, int quantidadePalavras) {
        String[] palavrasUnicas = new String[quantidadePalavras];
        int[] contadores = new int[quantidadePalavras];
        int tamanho = 0;

        for (int i = 0; i < palavrasSeparadas.length; i++) {
            String palavra = palavrasSeparadas[i].toLowerCase();

            if (!palavra.isEmpty()) {
                boolean achou = false;
                for (int j = 0; j < tamanho; j++) {
                    if (palavrasUnicas[j].equals(palavra)) {
                        contadores[j]++;
                        achou = true;
                        break;
                    }
                }

                if (!achou) {
                    palavrasUnicas[tamanho] = palavra;
                    contadores[tamanho] = 1;
                    tamanho++;
                }
            }
        }

        mergeSort(palavrasUnicas, contadores, 0, tamanho - 1);

        int limite = 20;
        for (int i = 0; i < tamanho && i < limite; i++) {
            listaEstatica.adiciona(palavrasUnicas[i], contadores[i]);
        }
    }

    public void mergeSort(String[] palavras, int[] contadores, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;

            mergeSort(palavras, contadores, inicio, meio);
            mergeSort(palavras, contadores, meio + 1, fim);

            int tamanhoEsq = meio - inicio + 1;
            int tamanhoDir = fim - meio;

            String[] esqPalavras = new String[tamanhoEsq];
            int[] esqContadores = new int[tamanhoEsq];
            String[] dirPalavras = new String[tamanhoDir];
            int[] dirContadores = new int[tamanhoDir];

            for (int i = 0; i < tamanhoEsq; i++) {
                esqPalavras[i] = palavras[inicio + i];
                esqContadores[i] = contadores[inicio + i];
            }

            for (int j = 0; j < tamanhoDir; j++) {
                dirPalavras[j] = palavras[meio + 1 + j];
                dirContadores[j] = contadores[meio + 1 + j];
            }

            int i = 0, j = 0, k = inicio;

            while (i < tamanhoEsq && j < tamanhoDir) {
                if (esqContadores[i] >= dirContadores[j]) {
                    palavras[k] = esqPalavras[i];
                    contadores[k] = esqContadores[i];
                    i++;
                } else {
                    palavras[k] = dirPalavras[j];
                    contadores[k] = dirContadores[j];
                    j++;
                }
                k++;
            }

            while (i < tamanhoEsq) {
                palavras[k] = esqPalavras[i];
                contadores[k] = esqContadores[i];
                i++;
                k++;
            }

            while (j < tamanhoDir) {
                palavras[k] = dirPalavras[j];
                contadores[k] = dirContadores[j];
                j++;
                k++;
            }
        }
    }

    public void verificarPalindromo(String[] palavrasSeparadas) {
        for (int i = 0; i < palavrasSeparadas.length; i++) {
            boolean palindromo = true;
            String palavra = palavrasSeparadas[i];
            int esquerda = 0, direita = palavra.length() - 1;

            while (esquerda < direita) {
                if (palavra.charAt(esquerda) != palavra.charAt(direita)) {
                    palindromo = false;
                    break;
                } else {
                    esquerda++;
                    direita--;
                }
            }
            if (palindromo && palavra.length() > 1) {
                listaDinamica.adicionar(palavra);
            }
        }
    }

}
