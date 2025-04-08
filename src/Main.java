import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner (new File("C:\\Users\\Júnior\\trabalho_alest\\texto.txt"));

        int contador = 0;
        while(sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] palavras = linha.split(" ");

            for(String palavra : palavras) {
                contador++;
            }
        }

        System.out.println("Quantidade de palavras no texto: " + contador);
    }
}