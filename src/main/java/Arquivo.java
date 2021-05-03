
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Arquivo extends Sorts {

    public void criarDiretorio(){
        String name = "C:\\todos_os_arquivos_sorts";
        new File(name).mkdir();
    }
    
    public String[][] abrirArquivoMedioCaso() throws FileNotFoundException, IOException {

        try (FileInputStream inputStream1 = new FileInputStream("C:\\planilhas_csv_utilizadas\\planilhaislast.csv");
                Scanner sc1 = new Scanner(inputStream1, "UTF-8");) {

            int cont = 0;

            String matriz[][] = new String[5617][16];
            String[] lista;

            while (sc1.hasNext()) {
                String line = sc1.nextLine();
                lista = line.split(",");
                matriz[cont] = lista;
                cont++;
            }
            
            return matriz;
        }
        
    }
    
    public String[][] abrirArquivo_obitosCrescentecsv() throws FileNotFoundException, IOException {

       try (FileInputStream inputStream1 = new FileInputStream("C:\\planilhas_csv_utilizadas\\obitosCrescente.csv");
                Scanner sc1 = new Scanner(inputStream1, "UTF-8");) {

            int cont = 0;

            String matriz[][] = new String[5617][16];
            String[] lista;

            while (sc1.hasNext()) {
                String line = sc1.nextLine();
                lista = line.split(";");
                matriz[cont] = lista;
                cont++;
            }
            
            return matriz;
        }
        
    }
    
    public String[][] abrirArquivo_obitosDecrescentecsv() throws FileNotFoundException, IOException {

       try (FileInputStream inputStream1 = new FileInputStream("C:\\planilhas_csv_utilizadas\\obitosDecrescente.csv");
                Scanner sc1 = new Scanner(inputStream1, "UTF-8");) {

            int cont = 0;

            String matriz[][] = new String[5617][16];
            String[] lista;

            while (sc1.hasNext()) {
                String line = sc1.nextLine();
                lista = line.split(";");
                matriz[cont] = lista;
                cont++;
            }
            
            return matriz;
        }
        
    }
    
    public String[][] abrirArquivo_casosCrescentecsv() throws FileNotFoundException, IOException {

       try (FileInputStream inputStream1 = new FileInputStream("C:\\planilhas_csv_utilizadas\\casosCrescente.csv");
                Scanner sc1 = new Scanner(inputStream1, "UTF-8");) {

            int cont = 0;

            String matriz[][] = new String[5617][16];
            String[] lista;

            while (sc1.hasNext()) {
                String line = sc1.nextLine();
                lista = line.split(";");
                matriz[cont] = lista;
                cont++;
            }
            
            return matriz;
        }
        
    }
    
    public String[][] abrirArquivo_casosDecrescentecsv() throws FileNotFoundException, IOException {

       try (FileInputStream inputStream1 = new FileInputStream("C:\\planilhas_csv_utilizadas\\casosDecrescente.csv");
                Scanner sc1 = new Scanner(inputStream1, "UTF-8");) {

            int cont = 0;

            String matriz[][] = new String[5617][16];
            String[] lista;

            while (sc1.hasNext()) {
                String line = sc1.nextLine();
                lista = line.split(";");
                matriz[cont] = lista;
                cont++;
            }
            
            return matriz;
        }
        
    }
    
    public String[][] abrirArquivo_cidadesCrescentecsv() throws FileNotFoundException, IOException {

       try (FileInputStream inputStream1 = new FileInputStream("C:\\planilhas_csv_utilizadas\\cidadesCrescente.csv");
                Scanner sc1 = new Scanner(inputStream1, "UTF-8");) {

            int cont = 0;

            String matriz[][] = new String[5617][16];
            String[] lista;

            while (sc1.hasNext()) {
                String line = sc1.nextLine();
                lista = line.split(";");
                matriz[cont] = lista;
                cont++;
            }
            
            return matriz;
        }
        
    }
    
    public String[][] abrirArquivo_cidadesDecrescentecsv() throws FileNotFoundException, IOException {

       try (FileInputStream inputStream1 = new FileInputStream("C:\\planilhas_csv_utilizadas\\cidadesDecrescente.csv");
                Scanner sc1 = new Scanner(inputStream1, "UTF-8");) {

            int cont = 0;

            String matriz[][] = new String[5617][16];
            String[] lista;

            while (sc1.hasNext()) {
                String line = sc1.nextLine();
                lista = line.split(";");
                matriz[cont] = lista;
                cont++;
            }
            
            return matriz;
        }
        
    }
    
    ////// HEAP SORT 
    
    
    public String[][] hsabrirArquivoMedioCaso() throws FileNotFoundException, IOException {

        try (FileInputStream inputStream1 = new FileInputStream("C:\\planilhas_csv_utilizadas\\planilhaislast.csv");
                Scanner sc1 = new Scanner(inputStream1, "UTF-8");) {

            int cont = 0;
            String matriz[][] = new String[5617][16];
            String[] lista;

            sc1.nextLine();

            while (sc1.hasNext()) {
                String line = sc1.nextLine();
                lista = line.split(",");
                matriz[cont] = lista;
                cont++;
            }
            
            return matriz;
        }
        
    }
    
    public String[][] hsabrirArquivo_obitosCrescentecsv() throws FileNotFoundException, IOException {

       try (FileInputStream inputStream1 = new FileInputStream("C:\\planilhas_csv_utilizadas\\obitosCrescente.csv");
                Scanner sc1 = new Scanner(inputStream1, "UTF-8");) {

            int cont = 0;
            String matriz[][] = new String[5617][16];
            String[] lista;

            sc1.nextLine();

            while (sc1.hasNext()) {
                String line = sc1.nextLine();
                lista = line.split(";");
                matriz[cont] = lista;
                cont++;
            }
            
            return matriz;
        }
        
    }
    
    public String[][] hsabrirArquivo_obitosDecrescentecsv() throws FileNotFoundException, IOException {

       try (FileInputStream inputStream1 = new FileInputStream("C:\\planilhas_csv_utilizadas\\obitosDecrescente.csv");
                Scanner sc1 = new Scanner(inputStream1, "UTF-8");) {

            int cont = 0;
            String matriz[][] = new String[5617][16];
            String[] lista;

            sc1.nextLine();

            while (sc1.hasNext()) {
                String line = sc1.nextLine();
                lista = line.split(";");
                matriz[cont] = lista;
                cont++;
            }
            
            return matriz;
        }
        
    }
    
    public String[][] hsabrirArquivo_casosCrescentecsv() throws FileNotFoundException, IOException {

       try (FileInputStream inputStream1 = new FileInputStream("C:\\planilhas_csv_utilizadas\\casosCrescente.csv");
                Scanner sc1 = new Scanner(inputStream1, "UTF-8");) {

            int cont = 0;
            String matriz[][] = new String[5617][16];
            String[] lista;

            sc1.nextLine();

            while (sc1.hasNext()) {
                String line = sc1.nextLine();
                lista = line.split(";");
                matriz[cont] = lista;
                cont++;
            }
            
            return matriz;
        }
        
    }
    
    public String[][] hsabrirArquivo_casosDecrescentecsv() throws FileNotFoundException, IOException {

       try (FileInputStream inputStream1 = new FileInputStream("C:\\planilhas_csv_utilizadas\\casosDecrescente.csv");
                Scanner sc1 = new Scanner(inputStream1, "UTF-8");) {

            int cont = 0;
            String matriz[][] = new String[5617][16];
            String[] lista;

            sc1.nextLine();

            while (sc1.hasNext()) {
                String line = sc1.nextLine();
                lista = line.split(";");
                matriz[cont] = lista;
                cont++;
            }
            
            return matriz;
        }
        
    }
    
    public String[][] hsabrirArquivo_cidadesCrescentecsv() throws FileNotFoundException, IOException {

       try (FileInputStream inputStream1 = new FileInputStream("C:\\planilhas_csv_utilizadas\\cidadesCrescente.csv");
                Scanner sc1 = new Scanner(inputStream1, "UTF-8");) {

            int cont = 0;
            String matriz[][] = new String[5617][16];
            String[] lista;

            sc1.nextLine();

            while (sc1.hasNext()) {
                String line = sc1.nextLine();
                lista = line.split(";");
                matriz[cont] = lista;
                cont++;
            }
            
            return matriz;
        }
        
    }
    
    public String[][] hsabrirArquivo_cidadesDecrescentecsv() throws FileNotFoundException, IOException {

       try (FileInputStream inputStream1 = new FileInputStream("C:\\planilhas_csv_utilizadas\\cidadesDecrescente.csv");
                Scanner sc1 = new Scanner(inputStream1, "UTF-8");) {

            int cont = 0;
            String matriz[][] = new String[5617][16];
            String[] lista;

            sc1.nextLine();

            while (sc1.hasNext()) {
                String line = sc1.nextLine();
                lista = line.split(";");
                matriz[cont] = lista;
                cont++;
            }
            
            return matriz;
        }
        
    }
}
