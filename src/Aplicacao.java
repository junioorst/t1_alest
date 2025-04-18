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

    public void executar() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("C:\\Users\\Júnior\\trabalho_alest\\texto.txt"));
        StringBuilder texto = new StringBuilder();
        int contador = 0;
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] palavras = linha.split(" ");

            for (String words : palavras) {
                for (int i = 0; i < words.length(); i++) {
                    char c = words.charAt(i);
                    if (c != '!' && c != '@' && c != '#' && c != '$' && c != '%' && c != '^' &&
                            c != '&' && c != '*' && c != '(' && c != ')' && c != '-' && c != '_' &&
                            c != '=' && c != '+' && c != '{' && c != '}' && c != '[' && c != ']' &&
                            c != '|' && c != '\\' && c != ':' && c != ';' && c != '"' && c != '\'' &&
                            c != '<' && c != '>' && c != ',' && c != '.' && c != '?' && c != '/' &&
                            c != '~' && c != '`' && c != 'á' && c != 'ó' && c != 'é') {
                        texto.append(c);
                    }
                }
                texto.append(" ");
                contador++;
            }
        }
        String resultado = texto.toString();
        String[] palavrasSeparadas = resultado.split("\\s+");

        System.out.println("Total de palavras do texto: " + contador);

        verificarOcorrencias(palavrasSeparadas);
        System.out.println("\nTop 20 palavras com mais ocorrências: ");
        listaEstatica.exibir();

        verificarPalindromo(palavrasSeparadas);
        System.out.println("\nPalíndromos:");
        listaDinamica.exibir();

    }


    public void verificarOcorrencias(String[] palavrasSeparadas) {
        String[] ocorrencias = new String[100];
        int[] numOcorrencias = new int[100];
        int index = 0;

        for (int i = 0; i < palavrasSeparadas.length; i++) {
            int contadorLocal = 0;

            String palavraMinuscula = palavrasSeparadas[i].toLowerCase();
            boolean jaContada = false;
            for (int j = 0; j < i; j++) {
                if (palavraMinuscula.equals(palavrasSeparadas[j].toLowerCase())) {
                    jaContada = true;
                    break;
                }
            }

            if (!jaContada) {
                for (String palavra : palavrasSeparadas) {
                    String minuscula = palavra.toLowerCase();
                    if (minuscula.equals(palavrasSeparadas[i].toLowerCase())) {
                        contadorLocal++;
                    }
                }
                if (!palavrasSeparadas[i].isEmpty()) {
                    ocorrencias[index] = palavrasSeparadas[i];
                    numOcorrencias[index] = contadorLocal;
                    index++;
                }
            }
        }

        int tamanho = ocorrencias.length;
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho - 1 - i; j++) {
                if (numOcorrencias[j] < numOcorrencias[j + 1]) {
                    int temp = numOcorrencias[j];
                    numOcorrencias[j] = numOcorrencias[j + 1];
                    numOcorrencias[j + 1] = temp;

                    String tempp = ocorrencias[j];
                    ocorrencias[j] = ocorrencias[j + 1];
                    ocorrencias[j + 1] = tempp;
                }
            }
        }

        for (int i = 0; i < tamanho; i++) {
            if (ocorrencias[i] != null && numOcorrencias[i] != 0) {
                listaEstatica.adiciona(ocorrencias[i], numOcorrencias[i]);
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
