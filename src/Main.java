import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
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
        String[] palavrasSeparadas = resultado.split(" ");

        String[] ocorrencias = new String[20];
        int[] numOcorrencias = new int[20];
        int index = 0;

        for (int i = 0; i < palavrasSeparadas.length; i++) {
            int contadorLocal = 0;

            boolean jaContada = false;
            for (int j = 0; j < i; j++) {
                if (palavrasSeparadas[i].equals(palavrasSeparadas[j])) {
                    jaContada = true;
                    break;
                }
            }

            if (!jaContada) {
                for (String palavra : palavrasSeparadas) {
                    if (palavra.equals(palavrasSeparadas[i])) {
                        contadorLocal++;
                    }
                }
                ocorrencias[index] = palavrasSeparadas[i];
                numOcorrencias[index] = contadorLocal;
                index++;
            }
        }
        System.out.println("Quantidade de palavras no texto: " + contador);
        System.out.println(resultado);
    }
}