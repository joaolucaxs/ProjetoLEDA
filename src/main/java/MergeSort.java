
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.Collator;
import java.util.Locale;

public class MergeSort extends Arquivo{

    Collator comparar = Collator.getInstance(new Locale("pt", "br"));

    public void gravarArquivo(String matriz[][], int arr[], String ordenacao) throws FileNotFoundException, IOException {

        criarDiretorio();
        try (FileOutputStream gerador = new FileOutputStream("C:\\todos_os_arquivos_sorts\\mergeSort_ordena_" + ordenacao + ".csv") // AQUI EU CRIO UM ARQUIVO COM O OBJETO FILEOUTPUTSTREAM
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
        try (FileOutputStream gerador = new FileOutputStream("C:\\todos_os_arquivos_sorts\\mergeSort_ordena_cidades.csv") // AQUI EU CRIO UM ARQUIVO COM O OBJETO FILEOUTPUTSTREAM
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
    
    void merge(String matriz[][], int arr[], int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        String matrizL[][] = new String[n1][16];
        String matrizR[][] = new String[n2][16];

        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
            System.arraycopy(matriz[l + i], 0, matrizL[i], 0, 16);
        }

        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
            System.arraycopy(matriz[m + 1 + j], 0, matrizR[j], 0, 16);
        }

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                System.arraycopy(matrizL[i], 0, matriz[k], 0, 16);
                i++;

            } else {
                arr[k] = R[j];
                System.arraycopy(matrizR[j], 0, matriz[k], 0, 16);
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            System.arraycopy(matrizL[i], 0, matriz[k], 0, 16);
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            System.arraycopy(matrizR[j], 0, matriz[k], 0, 16);
            j++;
            k++;
        }
    }

    void sort(String matriz[][], int arr[], int l, int r) {
        if (l < r) {

            int m = l + (r - l) / 2;
            sort(matriz, arr, l, m);
            sort(matriz, arr, m + 1, r);
            merge(matriz, arr, l, m, r);
        }
    }

    void merge(String matriz[][], String arr[], int l, int m, int r) {

        comparar.setStrength(Collator.CANONICAL_DECOMPOSITION);

        int n1 = m - l + 1;
        int n2 = r - m;

        String L[] = new String[n1];
        String R[] = new String[n2];

        String matrizL[][] = new String[n1][16];
        String matrizR[][] = new String[n2][16];

        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
            System.arraycopy(matriz[l + i], 0, matrizL[i], 0, 16);
        }

        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
            System.arraycopy(matriz[m + 1 + j], 0, matrizR[j], 0, 16);
        }

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (comparar.compare(L[i], R[j]) < 0 || comparar.compare(L[i], R[j]) == 0) {
                arr[k] = L[i];
                System.arraycopy(matrizL[i], 0, matriz[k], 0, 16);
                i++;

            } else {
                arr[k] = R[j];
                System.arraycopy(matrizR[j], 0, matriz[k], 0, 16);
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            System.arraycopy(matrizL[i], 0, matriz[k], 0, 16);
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            System.arraycopy(matrizR[j], 0, matriz[k], 0, 16);
            j++;
            k++;
        }
    }

    void sort(String matriz[][], String arr[], int l, int r) {
        if (l < r) {

            int m = l + (r - l) / 2;
            sort(matriz, arr, l, m);
            sort(matriz, arr, m + 1, r);
            merge(matriz, arr, l, m, r);
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
        sort(matriz, listaInt, 1, listaInt.length - 1);
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
        sort(matriz, listaString, 1, listaString.length - 1);
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
        sort(matriz, listaInt, 1, listaInt.length - 1);
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
        sort(matriz, listaInt, 1, listaInt.length - 1);
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
        sort(matriz, listaInt, 1, listaInt.length - 1);
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
        sort(matriz, listaInt, 1, listaInt.length - 1);
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
        sort(matriz, listaString, 1, listaString.length - 1);
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
        sort(matriz, listaString, 1, listaString.length - 1);
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução (PIOR CASO): " + (fim - inicio) + " ms");
    }
    
}
