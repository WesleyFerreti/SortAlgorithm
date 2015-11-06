//Wesley Ferreti    142B22
//Dennis Quintal    142B32
/*
    O BubbleSort, ou ordenação por flutuação (literalmente "por bolha"), é um algoritmo de ordenação dos mais simples.
A ideia é percorrer o vetor diversas vezes, a cada passagem fazendo flutuar para o topo o maior elemento da sequência. 

    complexidade pior caso  = (n^2)
    complexidade caso médio  = (n^2)
    complexidade melhor casO = (n)

    Recomentado utilizar para Arrays de no maximo 1000 elementos.

*/
import java.util.Scanner;

public class BubbleSort {
    public static long IFS = 0;
    public static long bubbleSort(double[] array, boolean desc){
        long tempInicial = System.nanoTime();
        if(!desc){//Ascendente
                 for (int i = array.length; i >= 1; i--) {  
                    for (int j = 1; j < i; j++) {  
                        IFS++;
                        if (array[j - 1] > array[j]) {  
                            double aux = array[j];  
                            array[j] = array[j - 1];  
                            array[j - 1] = aux;  
                        }  
                    }         
                }  
        }
        else{//Descendente
            for (int i = array.length; i >= 1; i--) {  
                    for (int j = 1; j < i; j++) {  
                        IFS++;
                        if (array[j - 1] < array[j]) {  
                            double aux = array[j];  
                            array[j] = array[j - 1];  
                            array[j - 1] = aux;  
                        }  
                    }         
                }     
        }
        long tempFinal = System.nanoTime();
        long tempDecorrido = tempFinal - tempInicial;
        System.out.println("Tempo decorrido em nanosegundos para ordenação: "+ tempDecorrido);
        System.out.println("Tempo decorrido em segundos para ordenação: "+ tempDecorrido*Math.pow(10,-9));
        return IFS;
    }
    
   /* public static void main(String[] args){
        
        Scanner tec = new Scanner(System.in);
        StringBuilder s = new StringBuilder("{");
        long returnedIFS = 0;
        System.out.print("Digite o tamanho do Arranjo:[10-100000000]\n");
        int size = tec.nextInt();
        
        if(size<10||size>100000000){
            throw new IllegalArgumentException("Tamanho invalido.");
        }
        double[] array = new double[size];    
        System.out.print("\t1:Ascendente\n\t2:Descendente\nDigite:");
        int anwser = tec.nextInt();
        switch(anwser){
                case 1:
                    for(int i = 0; i < array.length;i++){
                        array[i] = array.length-i;
                    }
                    System.out.println("Array preenchido de forma Descendente.");
                    
                    returnedIFS = bubbleSort(array,false);
                    
                    for(int i = 0; i < array.length;i++ ){
                        s.append(array[i]);
                        if(i!=array.length-1){
                            s.append(" ");
                        }
                    }
                    s.append("}");
                    System.out.println("Array ordenado na forma Ascendente:");
                    break;
                case 2:   
                    for(int i = 0; i < array.length;i++){
                        array[i] = (i+1);
                    }
                    System.out.println("Array preenchido de forma Ascendente.");
                    returnedIFS = bubbleSort(array,true);
                    for(int i = 0; i <array.length;i++ ){
                        s.append(array[i]);
                        if(i!=array.length){
                            s.append(" ");
                        }
                    }
                    s.append("}");
                    System.out.println("Array ordenado na forma Descendente:");
                    
                    
                    break;
                default:
                    System.out.println("Invalido.");
       
            }
        System.out.println(s.toString());
        System.out.println("IFS = "+returnedIFS);   
        
    }
    
  */
}
