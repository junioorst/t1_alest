import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length < 1) {
            System.out.println("Uso correto: java Main texto.txt");
            return;
        }
        String caminhoArquivo = args[0];

        Aplicacao app = new Aplicacao();
        app.executar(caminhoArquivo);
    }
}