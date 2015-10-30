//Wesley Ferreti    142B22
//Dennis Quintal    142B22
/*
    Sobre o algoritmo


*/
import java.util.Scanner;
import java.util.Stack;

public class QuickSort{
    public static long IFS = 0;
    public static long quickSort(double[] array,boolean desc){

        Stack<Integer> stack = new Stack<>();//stack == Pilha
        stack.push(0);
        stack.push(array.length);
        long tempInicial = System.nanoTime();    
        if(!desc){ 
            
            while (!stack.isEmpty()) {
        
                int fim = stack.pop();
                int inicio = stack.pop();
                IFS++;
                if (fim - inicio < 2){
                    continue;
                }
                int pivot = inicio + ((fim-inicio)/2);
                pivot = particiona(array,pivot,inicio,fim);

                stack.push(pivot+1);
                stack.push(fim);

                stack.push(inicio);
                stack.push(pivot);
                    
            }
            
        }
        else{     
            while (!stack.isEmpty()) {
                    
                int fim = stack.pop();
                int inicio = stack.pop();
                IFS++;
                if (fim - inicio < 2){
                    continue;
                }
                int pivot = inicio + ((fim-inicio)/2);
                pivot = particiona(array,pivot,inicio,fim,1);

                stack.push(pivot+1);
                stack.push(fim);

                stack.push(inicio);
                stack.push(pivot);
            }  
        }
        long tempFinal = System.nanoTime();
        long tempDecorrido = tempFinal - tempInicial;  
        System.out.println("Tempo decorrido em nanosegundos = "+ tempDecorrido);
        System.out.println("Tempo decorrido em segundos = "+ tempDecorrido*Math.pow(10,-9));
        return IFS;   
    }

    private static int particiona(double[] array, int pivot, int inicio, int fim) {//Ascendente
        int l = inicio;
        int h = fim - 2;
        double piv = array[pivot];
        troca(array,pivot,fim-1);

        while (l < h) {
            IFS++;
            if (array[l] < piv){
                l++;
            }else if (array[h] >= piv){ 
                h--;
            }else{ 
                troca(array,l,h);
            }
        }
        int idx = h;
        IFS++;
        if (array[h] < piv){
            idx++;
        }
        troca(array,fim-1,idx);
        return idx;
    }
    private static int particiona(double[] array, int pivot, int inicio, int fim, int descendente) {//Descendente
        int l = inicio;
        int h = fim - 2;
        double piv = array[pivot];
        troca(array,pivot,fim-1);

        while (l < h) {
            IFS++;
            if (array[l] > piv) {
                l++;
            } else if (array[h] <= piv) { 
                h--;
            } else { 
                troca(array,l,h);
            }
        }
        int idx = h;
        IFS++;
        if (array[h] > piv) idx++;
            troca(array,fim-1,idx);
            return idx;
    }
    private static void troca(double[] array, int i, int j) { 
        double temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
        
  /*  public static void main(String[] args) {
        
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
                    int n = 0;
                    for(int i = array.length; i > 0;i-- ){
                        array[n] = i;
                        n++;
                    }
                    System.out.println("Array preenchido de forma Descendente.");
                    
                    returnedIFS = quickSort(array,false);
                    
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
                    returnedIFS = quickSort(array,true);
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
