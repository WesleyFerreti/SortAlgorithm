//Wesley Ferreti    142B22
//Dennis Quintal    142B22
/*
    Sobre o algoritmo


*/
import java.util.Scanner;

public class HeapSort {
    public static long IFS = 0;
    public static long heapSort(double[] array,boolean desc){
        long tempInicial = System.nanoTime();
        
	int count = array.length;
	//first place a in max-heap order
	heapify(array, count);
 
	int fim = count - 1;
        if(!desc){
        
            while(fim > 0){

		double tmp = array[fim];
		array[fim] = array[0];
		array[0] = tmp;
		siftDown(array, 0, fim - 1);
		fim--;
            }
        }
        else{
            while(fim > 0){ 
                
		double tmp = array[fim];
		array[fim] = array[0];
		array[0] = tmp;
		siftDown(array, 0, fim - 1,1);
		fim--;
            
            }
        }
        long tempFinal = System.nanoTime();
        long tempDecorrido = tempFinal - tempInicial;
        System.out.println("Tempo decorrido em nanosegundos = "+ tempDecorrido);
        System.out.println("Tempo decorrido em segundos = "+ tempDecorrido*Math.pow(10,-9));
        return IFS;
    }
 
    public static void heapify(double[] array, int count){
	
	int inicio = (count - 2) / 2;
 
	while(inicio >= 0){	
            siftDown(array, inicio, count - 1);
            inicio--;
	}
    }
 
    public static void siftDown(double[] a, int inicio, int fim){
	
	int raiz = inicio;
 
	while((raiz * 2 + 1) <= fim){     
            int filho = raiz * 2 + 1;           
            IFS++;
            if(filho + 1 <= fim && a[filho] < a[filho + 1]){
		filho = filho+1; 
            }
            IFS++;
            if(a[raiz] < a[filho]){
		double tmp = a[raiz];
		a[raiz] = a[filho];
		a[filho] = tmp;
		raiz = filho;       
            }else{
                return;
            }
                    
	}
    }

    public static void siftDown(double[] array, int inicio, int fim,int descendente){
	
	int root = inicio;
 
	while((root * 2 + 1) <= fim){     
            int child = root * 2 + 1;   
	
            if(child + 1 <= fim && array[child]  > array[child + 1]){
                child = child;
            }
            if(array[root] > array[child]){  
		double tmp = array[root];
		array[root] = array[child];
		array[child] = tmp;
		root = child;         
            }else{
		return;
            } 
	}
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
                    
                    returnedIFS = heapSort(array,false);
                    
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
                    returnedIFS = heapSort(array,true);
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
