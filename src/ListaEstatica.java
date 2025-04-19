public class ListaEstatica {
    private String[] listaOcorrencias;
    private int index;

    public ListaEstatica() {
        listaOcorrencias = new String[20];
        index = 0;
    }

    public void adiciona(String palavra, int ocorrencia) {
        if (palavra != null && ocorrencia != 0 && index < listaOcorrencias.length) {
            listaOcorrencias[index] = palavra + " - " + ocorrencia;
            index++;
        }

    }

    public void exibir() {
        for (int i = 0; i < listaOcorrencias.length; i++) {
            if (listaOcorrencias[i] != null) {
                System.out.println((i+1) + ". " + listaOcorrencias[i]);
            }
        }
    }
}
