
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.Collator;
import java.util.Locale;

public class HeapSort extends Arquivo {

    Collator comparar = Collator.getInstance(new Locale("pt", "br"));

    public void gravarArquivo(String matriz[][], int arr[], String ordenacao) throws FileNotFoundException, IOException {

        criarDiretorio();
        try (FileOutputStream gerador = new FileOutputStream("C:\\todos_os_arquivos_sorts\\heapSort_ordena_" + ordenacao + ".csv") // AQUI EU CRIO UM ARQUIVO COM O OBJETO FILEOUTPUTSTREAM
                ;
                 PrintStream pr = new PrintStream(gerador) // AQUI UTILIZO O OBJETO PRINTSTREAM
                ) {
            pr.print("epidemiological_week,date,order_for_place,state,city,city_ibge_code,place_type,last_available_confirmed,last_available_confirmed_per_100k_inhabitants,new_confirmed,last_available_deaths,new_deaths,last_available_death_rate,estimated_population,is_last,is_repeated,\n");

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
        try (FileOutputStream gerador = new FileOutputStream("C:\\todos_os_arquivos_sorts\\heapSort_ordena_cidades.csv") // AQUI EU CRIO UM ARQUIVO COM O OBJETO FILEOUTPUTSTREAM
                ;
                 PrintStream pr = new PrintStream(gerador) // AQUI UTILIZO O OBJETO PRINTSTREAM
                ) {

            pr.print("epidemiological_week,date,order_for_place,state,city,city_ibge_code,place_type,last_available_confirmed,last_available_confirmed_per_100k_inhabitants,new_confirmed,last_available_deaths,new_deaths,last_available_death_rate,estimated_population,is_last,is_repeated,\n");

            for (int k = 0; k < arr.length; k++) {
                for (int j = 0; j < 16; j++) {
                    pr.print(matriz[k][j] + ",");
                }
                pr.print("\n");
            }
            pr.close();// FECHAR
        }

    }

    public void sort(String matriz[][], int arr[]) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(matriz, arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            for (int k = 0; k < 16; k++) {
                String temp1 = matriz[0][k];
                matriz[0][k] = matriz[i][k];
                matriz[i][k] = temp1;
            }
            heapify(matriz, arr, i, 0);
        }
    }

    void heapify(String matriz[][], int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            for (int k = 0; k < 16; k++) {
                String swap1 = matriz[i][k];
                matriz[i][k] = matriz[largest][k];
                matriz[largest][k] = swap1;
            }

            heapify(matriz, arr, n, largest);
        }
    }

    public void sort(String matriz[][], String arr[]) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(matriz, arr, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            String temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            for (int k = 0; k < 16; k++) {
                String temp1 = matriz[0][k];
                matriz[0][k] = matriz[i][k];
                matriz[i][k] = temp1;
            }
            heapify(matriz, arr, i, 0);
        }
    }

    void heapify(String matriz[][], String arr[], int n, int i) {

        comparar.setStrength(Collator.CANONICAL_DECOMPOSITION);

        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && comparar.compare(arr[l], arr[largest]) > 0) {
            largest = l;
        }

        if (r < n && comparar.compare(arr[r], arr[largest]) > 0) {
            largest = r;
        }

        if (largest != i) {
            String swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            for (int k = 0; k < 16; k++) {
                String swap1 = matriz[i][k];
                matriz[i][k] = matriz[largest][k];
                matriz[largest][k] = swap1;
            }

            heapify(matriz, arr, n, largest);
        }
    }

    void abrirMedioCaso(int x, String ordenacao) throws FileNotFoundException, IOException {

        Arquivo arq = new Arquivo();
        String matriz[][] = arq.hsabrirArquivoMedioCaso();
        int cont = matriz.length;
        int listaInt[] = new int[cont];

        for (int i = 0; i < cont; i++) {
            if (matriz[i][x] != null) {

                listaInt[i] = Integer.parseInt(matriz[i][x]);
            }
        }

        long inicio = System.currentTimeMillis();
        sort(matriz, listaInt);
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução (MEDIO CASO): " + (fim - inicio) + " ms");
        gravarArquivo(matriz, listaInt, ordenacao);

    }

    void abrirMedioCaso(int x) throws FileNotFoundException, IOException {

        Arquivo arq = new Arquivo();
        String matriz[][] = arq.hsabrirArquivoMedioCaso();

        int cont = matriz.length - 1;

        String listaString[] = new String[cont];
        for (int i = 0; i < cont; i++) {
            if (matriz[i][x] != null) {

                listaString[i] = matriz[i][x];
            }
        }

        long inicio = System.currentTimeMillis();
        sort(matriz, listaString);
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução (MEDIO CASO): " + (fim - inicio) + " ms");
        gravarArquivo(matriz, listaString);
    }

    void abrirMelhorCaso_Obitos() throws FileNotFoundException, IOException {

        Arquivo arq = new Arquivo();
        String matriz[][] = arq.hsabrirArquivo_obitosCrescentecsv();

        int cont = matriz.length;

        int listaInt[] = new int[cont];
        for (int i = 0; i < cont; i++) {
            if (matriz[i][10] != null) {
                listaInt[i] = Integer.parseInt(matriz[i][10]);
            }
        }

        long inicio = System.currentTimeMillis();
        sort(matriz, listaInt);
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução (MELHOR CASO): " + (fim - inicio) + " ms");
    }

    void abrirPiorCaso_Obitos() throws FileNotFoundException, IOException {
        Arquivo arq = new Arquivo();
        String matriz[][] = arq.hsabrirArquivo_obitosDecrescentecsv();

        int cont = matriz.length;
        int listaInt[] = new int[cont];
        for (int i = 0; i < cont; i++) {
            if (matriz[i][10] != null) {
                listaInt[i] = Integer.parseInt(matriz[i][10]);
            }
        }

        long inicio = System.currentTimeMillis();
        sort(matriz, listaInt);
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução (PIOR CASO): " + (fim - inicio) + " ms");
    }

    void abrirMelhorCaso_Casos() throws FileNotFoundException, IOException {

        Arquivo arq = new Arquivo();
        String matriz[][] = arq.hsabrirArquivo_casosCrescentecsv();

        int cont = matriz.length;

        int listaInt[] = new int[cont];
        for (int i = 0; i < cont; i++) {
            if (matriz[i][7] != null) {
                listaInt[i] = Integer.parseInt(matriz[i][7]);
            }
        }

        long inicio = System.currentTimeMillis();
        sort(matriz, listaInt);
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução (MELHOR CASO): " + (fim - inicio) + " ms");
    }

    void abrirPiorCaso_Casos() throws FileNotFoundException, IOException {

        Arquivo arq = new Arquivo();
        String matriz[][] = arq.hsabrirArquivo_casosDecrescentecsv();

        int cont = matriz.length;

        int listaInt[] = new int[cont];
        for (int i = 0; i < cont; i++) {
            if (matriz[i][7] != null) {
                listaInt[i] = Integer.parseInt(matriz[i][7]);
            }
        }

        long inicio = System.currentTimeMillis();
        sort(matriz, listaInt);
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução (PIOR CASO): " + (fim - inicio) + " ms");
    }

    void abrirMelhorCaso_Cidades() throws FileNotFoundException, IOException {

        Arquivo arq = new Arquivo();
        String matriz[][] = arq.hsabrirArquivo_cidadesCrescentecsv();

        int cont = matriz.length - 1;

        String listaString[] = new String[cont];
        for (int i = 0; i < cont; i++) {
            if (matriz[i][4] != null) {
                listaString[i] = matriz[i][4];
            }
        }

        long inicio = System.currentTimeMillis();
        sort(matriz, listaString);
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução (MELHOR CASO): " + (fim - inicio) + " ms");
    }

    void abrirPiorCaso_Cidades() throws FileNotFoundException, IOException {

        Arquivo arq = new Arquivo();
        String matriz[][] = arq.hsabrirArquivo_cidadesDecrescentecsv();

        int cont = matriz.length - 1;

        String listaString[] = new String[cont];
        for (int i = 0; i < cont; i++) {
            if (matriz[i][4] != null) {
                listaString[i] = matriz[i][4];
            }
        }

        long inicio = System.currentTimeMillis();
        sort(matriz, listaString);
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução (PIOR CASO): " + (fim - inicio) + " ms");
    }

}
