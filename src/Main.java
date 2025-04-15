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
                            c != '~' && c != '`' && c!='á' && c!='ó' && c!='é') {
                        texto.append(c);
                    }
                }
                texto.append(" ");
                contador++;
            }
        }

        String resultado = texto.toString();
        String [] palavrasSeparadas = resultado.split(" ");

        for (String palavra : palavrasSeparadas) {
            int contadorLocal = 0;
            for (String s : palavrasSeparadas) {
                if (s.equals(palavra)) {
                    contadorLocal++;
                }
            }
            System.out.println(palavra + ": " + contadorLocal);

        }

        System.out.println("Quantidade de palavras no texto: " + contador);
        System.out.println(resultado);
    }
}