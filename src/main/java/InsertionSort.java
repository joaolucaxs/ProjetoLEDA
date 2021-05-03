
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.Collator;
import java.util.Locale;

public class InsertionSort extends Arquivo {

    Collator comparar = Collator.getInstance(new Locale("pt", "br"));

    public void gravarArquivo(String matriz[][], int arr[], String ordenacao) throws FileNotFoundException, IOException {

        criarDiretorio();

        try (FileOutputStream gerador = new FileOutputStream("C:\\todos_os_arquivos_sorts\\insertionSort_ordena_" + ordenacao + ".csv") // AQUI EU CRIO UM ARQUIVO COM O OBJETO FILEOUTPUTSTREAM
                ;
                 PrintStream pr = new PrintStream(gerador) // AQUI UTILIZO O OBJETO PRINTSTREAM
                ) {
            for (int k = 0; k < arr.length; k++) {
                for (int j = 0; j < 16; j++) {
                    pr.print(matriz[k][j] + ",");
                }
                pr.print("\n");
            }
            pr.close();// FECHAR
        }

    }

    public void gravarArquivo(String matriz[][], String arr[]) throws FileNotFoundException, IOException {

        criarDiretorio();

        try (FileOutputStream gerador = new FileOutputStream("C:\\todos_os_arquivos_sorts\\insertionSort_ordena_cidades.csv") // AQUI EU CRIO UM ARQUIVO COM O OBJETO FILEOUTPUTSTREAM
                ;
                 PrintStream pr = new PrintStream(gerador) // AQUI UTILIZO O OBJETO PRINTSTREAM
                ) {
            for (int k = 0; k < arr.length; k++) {
                for (int j = 0; j < 16; j++) {
                    pr.print(matriz[k][j] + ",");
                }
                pr.print("\n");
            }
            pr.close();// FECHAR
        }

    }

    void sort(String matriz[][], int arr[]) {

        int n = arr.length;

        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            String key2[] = new String[16];
            System.arraycopy(matriz[i], 0, key2, 0, 16);
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                System.arraycopy(matriz[j], 0, matriz[j + 1], 0, 16);
                j = j - 1;
            }

            arr[j + 1] = key;
            System.arraycopy(key2, 0, matriz[j + 1], 0, 16);
        }

    }

    void sort(String matriz[][], String arr[]) {

        comparar.setStrength(Collator.CANONICAL_DECOMPOSITION);

        int n = arr.length;

        for (int i = 2; i < n; ++i) {
            String key = arr[i];
            String key2[] = new String[16];
            System.arraycopy(matriz[i], 0, key2, 0, 16);
            int j = i - 1;

            while (arr[j] != null && j >= 0 && comparar.compare(arr[j], key) > 0) {
                arr[j + 1] = arr[j];
                System.arraycopy(matriz[j], 0, matriz[j + 1], 0, 16);
                j = j - 1;
            }

            arr[j + 1] = key;
            System.arraycopy(key2, 0, matriz[j + 1], 0, 16);
        }

    }

    void abrirMedioCaso(int x, String ordenacao) throws FileNotFoundException, IOException {

        Arquivo arq = new Arquivo();
        String matriz[][] = arq.abrirArquivoMedioCaso();
        int cont = matriz.length;
        int listaInt[] = new int[cont];

        for (int i = 1; i < cont; i++) {
            listaInt[i] = Integer.parseInt(matriz[i][x]);
        }

        long inicio = System.currentTimeMillis();
        sort(matriz, listaInt);
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução (MEDIO CASO): " + (fim - inicio) + " ms");
        gravarArquivo(matriz, listaInt, ordenacao);

    }

    void abrirMedioCaso(int x) throws FileNotFoundException, IOException {

        Arquivo arq = new Arquivo();
        String matriz[][] = arq.abrirArquivoMedioCaso();

        int cont = matriz.length;

        String listaString[] = new String[cont];
        for (int i = 1; i < cont; i++) {
            listaString[i] = matriz[i][x];
        }

        long inicio = System.currentTimeMillis();
        sort(matriz, listaString);
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução (MEDIO CASO): " + (fim - inicio) + " ms");
        gravarArquivo(matriz, listaString);
    }

    void abrirMelhorCaso_Obitos() throws FileNotFoundException, IOException {

        Arquivo arq = new Arquivo();
        String matriz[][] = arq.abrirArquivo_obitosCrescentecsv();

        int cont = matriz.length;

        int listaInt[] = new int[cont];
        for (int i = 1; i < cont; i++) {
            listaInt[i] = Integer.parseInt(matriz[i][10]);
        }

        long inicio = System.currentTimeMillis();
        sort(matriz, listaInt);
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução (MELHOR CASO): " + (fim - inicio) + " ms");
    }

    void abrirPiorCaso_Obitos() throws FileNotFoundException, IOException {
        Arquivo arq = new Arquivo();
        String matriz[][] = arq.abrirArquivo_obitosDecrescentecsv();

        int cont = matriz.length;
        int listaInt[] = new int[cont];
        for (int i = 1; i < cont; i++) {
            listaInt[i] = Integer.parseInt(matriz[i][10]);
        }

        long inicio = System.currentTimeMillis();
        sort(matriz, listaInt);
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução (PIOR CASO): " + (fim - inicio) + " ms");
    }

    void abrirMelhorCaso_Casos() throws FileNotFoundException, IOException {

        Arquivo arq = new Arquivo();
        String matriz[][] = arq.abrirArquivo_casosCrescentecsv();

        int cont = matriz.length;

        int listaInt[] = new int[cont];
        for (int i = 1; i < cont; i++) {
            listaInt[i] = Integer.parseInt(matriz[i][7]);
        }

        long inicio = System.currentTimeMillis();
        sort(matriz, listaInt);
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução (MELHOR CASO): " + (fim - inicio) + " ms");
    }

    void abrirPiorCaso_Casos() throws FileNotFoundException, IOException {

        Arquivo arq = new Arquivo();
        String matriz[][] = arq.abrirArquivo_casosDecrescentecsv();

        int cont = matriz.length;

        int listaInt[] = new int[cont];
        for (int i = 1; i < cont; i++) {
            listaInt[i] = Integer.parseInt(matriz[i][7]);
        }

        long inicio = System.currentTimeMillis();
        sort(matriz, listaInt);
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução (PIOR CASO): " + (fim - inicio) + " ms");
    }

    void abrirMelhorCaso_Cidades() throws FileNotFoundException, IOException {

        Arquivo arq = new Arquivo();
        String matriz[][] = arq.abrirArquivo_cidadesCrescentecsv();

        int cont = matriz.length;

        String listaString[] = new String[cont];
        for (int i = 1; i < cont; i++) {
            listaString[i] = matriz[i][4];
        }

        long inicio = System.currentTimeMillis();
        sort(matriz, listaString);
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução (MELHOR CASO): " + (fim - inicio) + " ms");
    }

    void abrirPiorCaso_Cidades() throws FileNotFoundException, IOException {

        Arquivo arq = new Arquivo();
        String matriz[][] = arq.abrirArquivo_cidadesDecrescentecsv();

        int cont = matriz.length;

        String listaString[] = new String[cont];
        for (int i = 1; i < cont; i++) {
            listaString[i] = matriz[i][4];
        }

        long inicio = System.currentTimeMillis();
        sort(matriz, listaString);
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução (PIOR CASO): " + (fim - inicio) + " ms");
    }

}
