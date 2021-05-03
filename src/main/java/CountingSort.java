
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class CountingSort extends Arquivo {

    public void gravarArquivo(String matriz[][], int arr[], String ordenacao) throws FileNotFoundException, IOException {

        criarDiretorio();
        try (FileOutputStream gerador = new FileOutputStream("C:\\todos_os_arquivos_sorts\\countingSort_ordena_" + ordenacao + ".csv") // AQUI EU CRIO UM ARQUIVO COM O OBJETO FILEOUTPUTSTREAM
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

    public void sort(String matriz[][], int[] A, int k) {

        int[] C = new int[k + 1];

        for (int j = 0; j < A.length; j++) {
            C[A[j]] += 1;
        }

        int sum = 0;
        for (int i = 0; i < C.length; i++) {
            int dum = C[i];
            C[i] = sum;
            sum += dum;
        }

        int B[] = new int[A.length];
        String matrizB[][] = new String[A.length][16];

        for (int i = 0; i < A.length; i++) {
            B[C[A[i]]] = A[i];
            System.arraycopy(matriz[i], 0, matrizB[C[A[i]]], 0, 16);
            C[A[i]]++;

        }

        for (int i = 0; i < A.length; i++) {
            A[i] = B[i];
            System.arraycopy(matrizB[i], 0, matriz[i], 0, 16);
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

        int maior = 0;
        for (int i = 0; i < listaInt.length; i++) { // ALTEREI PRA COMEÇAR A PARTIR DO 0 PARA NAO CONTAR AS OPÇOES DO COMEÇO
            if (listaInt[i] > maior) {
                maior = listaInt[i];
            }
        }

        long inicio = System.currentTimeMillis();
        sort(matriz, listaInt, maior);
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução (MEDIO CASO): " + (fim - inicio) + " ms");
        gravarArquivo(matriz, listaInt, ordenacao);

    }

    void abrirMelhorCaso_Obitos() throws FileNotFoundException, IOException {

        Arquivo arq = new Arquivo();
        String matriz[][] = arq.abrirArquivo_obitosCrescentecsv();

        int cont = matriz.length;

        int listaInt[] = new int[cont];
        for (int i = 1; i < cont; i++) {
            listaInt[i] = Integer.parseInt(matriz[i][10]);
        }
        int maior = 0;
        for (int i = 0; i < listaInt.length; i++) { // ALTEREI PRA COMEÇAR A PARTIR DO 0 PARA NAO CONTAR AS OPÇOES DO COMEÇO
            if (listaInt[i] > maior) {
                maior = listaInt[i];
            }
        }

        long inicio = System.currentTimeMillis();
        sort(matriz, listaInt, maior);
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

        int maior = 0;
        for (int i = 0; i < listaInt.length; i++) { // ALTEREI PRA COMEÇAR A PARTIR DO 0 PARA NAO CONTAR AS OPÇOES DO COMEÇO
            if (listaInt[i] > maior) {
                maior = listaInt[i];
            }
        }

        long inicio = System.currentTimeMillis();
        sort(matriz, listaInt, maior);
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

        int maior = 0;
        for (int i = 0; i < listaInt.length; i++) { // ALTEREI PRA COMEÇAR A PARTIR DO 0 PARA NAO CONTAR AS OPÇOES DO COMEÇO
            if (listaInt[i] > maior) {
                maior = listaInt[i];
            }
        }

        long inicio = System.currentTimeMillis();
        sort(matriz, listaInt, maior);
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

        int maior = 0;
        for (int i = 0; i < listaInt.length; i++) { // ALTEREI PRA COMEÇAR A PARTIR DO 0 PARA NAO CONTAR AS OPÇOES DO COMEÇO
            if (listaInt[i] > maior) {
                maior = listaInt[i];
            }
        }

        long inicio = System.currentTimeMillis();
        sort(matriz, listaInt, maior);
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de execução (PIOR CASO): " + (fim - inicio) + " ms");
    }
}
