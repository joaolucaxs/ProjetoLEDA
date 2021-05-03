

// PROJETO LEDA
// Projeto de Análise de Algoritmos
// Análise comparativa de algoritmos de ordenação aplicado a dados da COVID-19
// ALUNOS: JOÃO LUCAS FERREIRA LIMA E ELIOENAI ROBERTO LINS SILVA COELHO

public class OnlyComments {
    
    // O CODIGO ESTÁ DIVIDIDO EM 9 CLASSES
    // SENDO ELAS: 
    // Sorts.java, onde está instanciando um objeto de cada uma das classes de ordenação,
    // printando todos os melhores, medios e piores casos de cada objeto de cada classe.
    
    // Arquivo.java onde possui os metodos:
    // - criarDiretorio(): crio um diretorio com a classe File para organizar os arquivos .csv gerados.
    // - abrirArquivoMedioCaso() onde abre a planilha inicial, onde essa planilha é a original
    //      Utilizei um objeto FileInputStream, onde nos permite ler o arquivo "planilhailast.csv" e retornar os dados em byte.
    //      cont = contador de linhas do arquivo
    //      o while conta cada linha (pelo Scanner), usando o metodo split para separar cada elemento e armazenar em uma matriz
    //      O metodo nao recebe nada como parametro e retorna uma matriz de String
    // - abrirArquivo_obitosCrescentecsv() onde abre a planilha "obitosCrescente.csv" e faz o mesmo do metodo abrirArquivoMedioCaso()
    // - abrirArquivo_obitosDecrescentecsv() onde abre a planilha "obitosDecrescente.csv" e faz o mesmo do metodo abrirArquivoMedioCaso()
    // - abrirArquivo_casosCrescentecsv() onde abre a planilha "casosCrescente.csv" e faz o mesmo do metodo abrirArquivoMedioCaso()
    // - abrirArquivo_casosDecrescentecsv() onde abre a planilha "casosDecrescente.csv" e faz o mesmo do metodo abrirArquivoMedioCaso()
    // - abrirArquivo_cidadesCrescentecsv() onde abre a planilha "cidadesCrescente.csv" e faz o mesmo do metodo abrirArquivoMedioCaso()
    // - abrirArquivo_cidadesDecrescentecsv() onde abre a planilha "cidadesDecrescente.csv" e faz o mesmo do metodo abrirArquivoMedioCaso()
    // OBS : os metodos hsabrirArquivo_obitosCrescentecsv(), hsabrirArquivo_obitosDecrescentecsv(), hsabrirArquivo_casosCrescentecsv()
    // hsabrirArquivo_casosDecrescentecsv(), hsabrirArquivo_cidadesCrescentecsv(), hsabrirArquivo_cidadesDecrescentecsv() e hshsabrirArquivoMedioCaso()
    // são metodos particulares do Heap Sort, onde ele necessita apenas dos numeros, então nao contei a primeira linha que tem os cabeçalhos da planilha.
    
    // As classes de ordenação são:
    // SelectionSort.java, InsertionSort.java, MergeSort.java, QuickSort.java, QuickSortMedianaDeTres.java, CountingSort.java e HeapSort.java
    // todas elas possuem em comum os seguintes metodos:
    // - gravarArquivo(): cria um objeto FileOutputStream, onde permite gravar um arquivo e passa para ele os dados ordenados pelas classes de ordenação existentes
    // - abrirMedioCaso(): chama o metodo da classe Arquivo abrirArquivoMedioCaso(), passa os valores de determinada coluna da matriz para uma lista tipada,
    // depois chama o metodo "sort" de cada classe, printando seu tempo de execução em milisegundos e depois chamando o metodo gravarArquivo().
    // - abrirMelhorCaso_Obitos(): chama o metodo da classe Arquivo abrirArquivo_obitosCrescentecsv(), passa os valores de determinada coluna da matriz para uma lista tipada,
    // depois chama o metodo "sort" de cada classe, printando seu tempo de execução em milisegundos
    // - abrirPiorCaso_Obitos(): chama o metodo da classe Arquivo abrirArquivo_obitosDecrescentecsv(), passa os valores de determinada coluna da matriz para uma lista tipada,
    // depois chama o metodo "sort" de cada classe, printando seu tempo de execução em milisegundos
    // - abrirMelhorCaso_Casos(): chama o metodo da classe Arquivo abrirArquivo_casosCrescentecsv(), passa os valores de determinada coluna da matriz para uma lista tipada,
    // depois chama o metodo "sort" de cada classe, printando seu tempo de execução em milisegundos
    // - abrirPiorCaso_Casos(): chama o metodo da classe Arquivo abrirArquivo_casosDecrescentecsv(), passa os valores de determinada coluna da matriz para uma lista tipada,
    // depois chama o metodo "sort" de cada classe, printando seu tempo de execução em milisegundos
    // - abrirMelhorCaso_Cidades(): chama o metodo da classe Arquivo abrirArquivo_cidadesCrescentecsv(), passa os valores de determinada coluna da matriz para uma lista tipada,
    // depois chama o metodo "sort" de cada classe, printando seu tempo de execução em milisegundos
    // - abrirPiorCaso_Cidades(): chama o metodo da classe Arquivo abrirArquivo_cidadesDecrescentecsv(), passa os valores de determinada coluna da matriz para uma lista tipada,
    // depois chama o metodo "sort" de cada classe, printando seu tempo de execução em milisegundos
    
    // Cada classe de ordenação possui seu metodo de ordenaçao "sort" onde obrigatoriamente ele vai receber a matriz e a lista com os elementos de 
    // determinada coluna da matriz e mais alguns parametros exclusivos de cada tipo de ordenação
    // Foram feitas cada implementações nos sorts de cidade, onde utilizamos a classe Collator para fazer a comparação das Strings cidades.
    

}
