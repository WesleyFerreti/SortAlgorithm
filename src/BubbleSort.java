
import java.util.Scanner;
//hhhhwewewewewe

public class BubbleSort {
    
    public static long bubbleSort(double[] array,boolean desc){
        long tempInicial = System.nanoTime();
        long IFS = 0;
        if(!desc){
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
        else{
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
        System.out.println("Tempo decorrido em nanosegundos = "+ tempDecorrido);
        System.out.println("Tempo decorrido em segundos = "+ tempDecorrido*Math.pow(10,-9));
        return IFS;
    }
    
    
    
    
    /*public static void main(String[] args) {
        
        Scanner tec = new Scanner(System.in);
        StringBuilder s = new StringBuilder("{");
        long IFS = 0;
        System.out.print("Digite o tamanho do Arranjo:[100-1000000]\n");
        int size = tec.nextInt();
        
        if(size<100||size>1000000){
            throw new IllegalArgumentException("Tamanho invalido.");
        }
        double[] array = new double[size];    
        System.out.print("\t1:Ascendente\n\t2:Descendente\nDigite:");
        int anwser = tec.nextInt();
        switch(anwser){
                case 1:
                    int n;
                    for(int w = 0; w < 10; w++){
                        n=0;
                    for(int i = array.length; i > 0;i-- ){
                        array[n] = i;
                        n++;
                    }
                    System.out.println("Array preenchido de forma Descendente.");
                    
                    IFS = bubbleSort(array,false);
                    }
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
                    IFS = bubbleSort(array,true);
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
        System.out.println("IFS = "+IFS);   
        
            
    }
    
  */ 
}
