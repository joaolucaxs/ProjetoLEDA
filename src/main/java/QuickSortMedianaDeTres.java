
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.Collator;
import java.util.Locale;

public class QuickSortMedianaDeTres extends Arquivo {

    Collator comparar = Collator.getInstance(new Locale("pt", "br"));

    public void gravarArquivo(String matriz[][], int arr[], String ordenacao) throws FileNotFoundException, IOException {

        criarDiretorio();
        try (FileOutputStream gerador = new FileOutputStream("C:\\todos_os_arquivos_sorts\\quickSortMedianaDeTres_ordena_" + ordenacao + ".csv") // AQUI EU CRIO UM ARQUIVO COM O OBJETO FILEOUTPUTSTREAM
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
        try (FileOutputStream gerador = new FileOutputStream("C:\\todos_os_arquivos_sorts\\quickSortMedianaDeTres_ordena_cidades.csv") // AQUI EU CRIO UM ARQUIVO COM O OBJETO FILEOUTPUTSTREAM
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

    void swap(String matriz[][], int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        for (int k = 0; k < 16; k++) {
            String temp1 = matriz[i][k];
            matriz[i][k] = matriz[j][k];
            matriz[j][k] = temp1;
        }
    }

    int partition(String matriz[][], int[] arr, int low, int high) {
        int meio = (low + high) / 2;
        int a = arr[low];
        int b = arr[meio];
        int c = arr[high];
        int medianaIndice;
        if (a < b) {
            if (b < c) {
                //a < b && b < c
                medianaIndice = meio;
            } else {
                if (a < c) {
                    //a < c && c <= b
                    medianaIndice = high;
                } else {
                    //c <= a && a < b
                    medianaIndice = low;
                }
            }
        } else {
            if (c < b) {
                //c < b && b <= a
                medianaIndice = meio;
            } else {
                if (c < a) {
                    //b <= c && c < a
                    medianaIndice = high;
                } else {
                    //b <= a && a <= c
                    medianaIndice = low;
                }
            }
        }

        swap(matriz, arr, medianaIndice, high);

        int pivo = arr[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] <= pivo) {
                i = i + 1;
                swap(matriz, arr, i, j);
            }
        }

        swap(matriz, arr, i + 1, high);
        return (i + 1);

    }

    void quickSort(String matriz[][], int arr[], int low, int high) {

        if (low < high) {

            int pi = partition(matriz, arr, low, high);

            quickSort(matriz, arr, low, pi - 1);
            quickSort(matriz, arr, pi + 1, high);
        }
    }

    void swap(String matriz[][], String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        for (int k = 0; k < 16; k++) {
            String temp1 = matriz[i][k];
            matriz[i][k] = matriz[j][k];
            matriz[j][k] = temp1;
        }
    }

    int partition(String matriz[][], String[] arr, int low, int high) {

        comparar.setStrength(Collator.CANONICAL_DECOMPOSITION);

        int meio = (low + high) / 2;
        String a = arr[low];
        String b = arr[meio];
        String c = arr[high];
        int medianaIndice;
        if (comparar.compare(a, b) < 0) {
            if (comparar.compare(b, c) < 0) {
                //a < b && b < c
                medianaIndice = meio;
            } else {
                if (comparar.compare(a, c) < 0) {
                    //a < c && c <= b
                    medianaIndice = high;
                } else {
                    //c <= a && a < b
                    medianaIndice = low;
                }
            }
        } else {
            if (comparar.compare(c, b) < 0) {
                //c < b && b <= a
                medianaIndice = meio;
            } else {
                if (comparar.compare(c, a) < 0) {
                    //b <= c && c < a
                    medianaIndice = high;
                } else {
                    //b <= a && a <= c
                    medianaIndice = low;
                }
            }
        }

        swap(matriz, arr, medianaIndice, high);

        String pivo = arr[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (comparar.compare(arr[j], pivo) < 0 || comparar.compare(arr[j], pivo) == 0) {
                i = i + 1;
                swap(matriz, arr, i, j);
            }
        }

        swap(matriz, arr, i + 1, high);
        return (i + 1);

    }

    void quickSort(String matriz[][], String arr[], int low, int high) {

        if (low < high) {

            int pi = partition(matriz, arr, low, high);

            quickSort(matriz, arr, low, pi - 1);
            quickSort(matriz, arr, pi + 1, high);
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

        int tamanho = listaInt.length;
        long inicio = System.currentTimeMillis();
        quickSort(matriz, listaInt, 1, tamanho - 1);
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

        int tamanho = listaString.length;
        long inicio = System.currentTimeMillis();
        quickSort(matriz, listaString, 1, tamanho - 1);
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

        int tamanho = listaInt.length;
        long inicio = System.currentTimeMillis();
        quickSort(matriz, listaInt, 1, tamanho - 1);
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

        int tamanho = listaInt.length;
        long inicio = System.currentTimeMillis();
        quickSort(matriz, listaInt, 1, tamanho - 1);
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

        int tamanho = listaInt.length;
        long inicio = System.currentTimeMillis();
        quickSort(matriz, listaInt, 1, tamanho - 1);
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

        int tamanho = listaInt.length;
        long inicio = System.currentTimeMillis();
        quickSort(matriz, listaInt, 1, tamanho - 1);
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

        int tamanho = listaString.length;
        long inicio = System.currentTimeMillis();
        quickSort(matriz, listaString, 1, tamanho - 1);
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
        int tamanho = listaString.length;
        long inicio = System.currentTimeMillis();
        quickSort(matriz, listaString, 1, tamanho - 1);
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução (PIOR CASO): " + (fim - inicio) + " ms");
    }
}
