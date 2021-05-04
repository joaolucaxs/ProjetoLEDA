
import java.io.IOException;
import java.io.*;
import java.awt.GraphicsEnvironment;

public class Sorts {

    public static void main(String[] args) throws IOException {
        
        Console console = System.console();
        if(console == null && !GraphicsEnvironment.isHeadless()){
            //System.out.println(filename);
            //trocar o direitorio
            String filename = "C:\\Users\\leoni\\sorts.jar";
            //System.out.println(filename);
            Runtime.getRuntime().exec(new String[]{"cmd","/c","start","cmd","/k","java -jar \""  + filename + "\""});
        }

        int obitos = 10; // Obitos acumulados = 10 coluna da matriz 
        int casos = 7; // Casos acumulados = 7 coluna da matriz
        int cidades = 4; // Cidades = 4 coluna da matriz
        
        System.out.println("\n--------- SELECTION SORT ---------");
        SelectionSort selection = new SelectionSort();
        System.out.println("\n### Ordenação por obitos ### ");
        selection.abrirMelhorCaso_Obitos();
        selection.abrirMedioCaso(obitos, "obitos");
        selection.abrirPiorCaso_Obitos();

        System.out.println("\n### Ordenação por casos ### ");
        selection.abrirMelhorCaso_Casos();
        selection.abrirMedioCaso(casos, "casos");
        selection.abrirPiorCaso_Casos();

        System.out.println("\n### Ordenação por cidades ### ");
        selection.abrirMelhorCaso_Cidades();
        selection.abrirMedioCaso(cidades);
        selection.abrirPiorCaso_Cidades();

        System.out.println("\n\n\n--------- INSERTION SORT ---------");
        InsertionSort insertion = new InsertionSort();
        System.out.println("\n### Ordenação por obitos ### ");
        insertion.abrirMelhorCaso_Obitos();
        insertion.abrirMedioCaso(obitos, "obitos");
        insertion.abrirPiorCaso_Obitos();

        System.out.println("\n### Ordenação por casos ### ");
        insertion.abrirMelhorCaso_Casos();
        insertion.abrirMedioCaso(casos, "casos");
        insertion.abrirPiorCaso_Casos();

        System.out.println("\n### Ordenação por cidades ### ");
        insertion.abrirMelhorCaso_Cidades();
        insertion.abrirMedioCaso(cidades);
        insertion.abrirPiorCaso_Cidades();

        System.out.println("\n\n\n--------- MERGE SORT ---------");

        MergeSort merge = new MergeSort();
        System.out.println("\n### Ordenação por obitos ### ");
        merge.abrirMelhorCaso_Obitos();
        merge.abrirMedioCaso(obitos, "obitos");
        merge.abrirPiorCaso_Obitos();

        System.out.println("\n### Ordenação por casos ### ");
        merge.abrirMelhorCaso_Casos();
        merge.abrirMedioCaso(casos, "casos");
        merge.abrirPiorCaso_Casos();

        System.out.println("\n### Ordenação por cidades ### ");
        merge.abrirMelhorCaso_Cidades();
        merge.abrirMedioCaso(cidades);
        merge.abrirPiorCaso_Cidades();

        System.out.println("\n\n\n--------- QUICK SORT ---------");

        QuickSort quick = new QuickSort();
        System.out.println("\n### Ordenação por obitos ### ");
        quick.abrirMelhorCaso_Obitos();
        quick.abrirMedioCaso(obitos, "obitos");
        quick.abrirPiorCaso_Obitos();

        System.out.println("\n### Ordenação por casos ### ");
        quick.abrirMelhorCaso_Casos();
        quick.abrirMedioCaso(casos, "casos");
        quick.abrirPiorCaso_Casos();

        System.out.println("\n### Ordenação por cidades ### ");
        quick.abrirMelhorCaso_Cidades();
        quick.abrirMedioCaso(cidades);
        quick.abrirPiorCaso_Cidades();

        System.out.println("\n\n\n----- QUICK SORT MEDIANA DE TRES -----");

        QuickSortMedianaDeTres quickMedianaDeTres = new QuickSortMedianaDeTres();
        System.out.println("\n### Ordenação por obitos ### ");
        quickMedianaDeTres.abrirMelhorCaso_Obitos();
        quickMedianaDeTres.abrirMedioCaso(obitos, "obitos");
        quickMedianaDeTres.abrirPiorCaso_Obitos();

        System.out.println("\n### Ordenação por casos ### ");
        quickMedianaDeTres.abrirMelhorCaso_Casos();
        quickMedianaDeTres.abrirMedioCaso(casos, "casos");
        quickMedianaDeTres.abrirPiorCaso_Casos();

        System.out.println("\n### Ordenação por cidades ### ");
        quickMedianaDeTres.abrirMelhorCaso_Cidades();
        quickMedianaDeTres.abrirMedioCaso(cidades);
        quickMedianaDeTres.abrirPiorCaso_Cidades();

        System.out.println("\n\n\n--------- COUNTING SORT ---------");

        CountingSort counting = new CountingSort();
        System.out.println("\n### Ordenação por obitos ### ");
        counting.abrirMelhorCaso_Obitos();
        counting.abrirMedioCaso(obitos, "obitos");
        counting.abrirPiorCaso_Obitos();

        System.out.println("\n### Ordenação por casos ### ");
        counting.abrirMelhorCaso_Casos();
        counting.abrirMedioCaso(casos, "casos");
        counting.abrirPiorCaso_Casos();

        System.out.println("\n\n\n--------- HEAP SORT ---------");

        HeapSort heap = new HeapSort();
        System.out.println("\n### Ordenação por obitos ### ");
        heap.abrirMelhorCaso_Obitos();
        heap.abrirMedioCaso(obitos, "obitos");
        heap.abrirPiorCaso_Obitos();

        System.out.println("\n### Ordenação por casos ### ");
        heap.abrirMelhorCaso_Casos();
        heap.abrirMedioCaso(casos, "casos");
        heap.abrirPiorCaso_Casos();

        System.out.println("\n### Ordenação por cidades ### ");
        heap.abrirMelhorCaso_Cidades();
        heap.abrirMedioCaso(cidades);
        heap.abrirPiorCaso_Cidades();

        System.out.println("\n\n PASTA 'todos_os_arquivos_sorts' CRIADA NO DISCO C:\\ COM TODOS OS ARQUIVOS ORDENADOS !!!!");

    }

}
