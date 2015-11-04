//Wesley Ferreti    142B22
//Dennis Quintal    142B22
/*
   O heapsort utiliza uma estrutura de dados chamada heap, para ordenar os elementos à medida que os insere na estrutura.
Assim, ao final das inserções, os elementos podem ser sucessivamente removidos da raiz da heap, na ordem desejada, 
lembrando-se sempre de manter a propriedade de max-heap.
    A heap pode ser representada como uma árvore (uma árvore binária com propriedades especiais[2]) ou como um vetor. 
Para uma ordenação decrescente, deve ser construída uma heap mínima (o menor elemento fica na raiz). 
Para uma ordenação crescente, deve ser construído uma heap máxima (o maior elemento fica na raiz).

    complexidade pior caso = (n log (n))
    complexidade caso médio = (n log (n))
    complexidade melhor caso = (n log (n))
    
    Apesar de oferecer em qualquer cenario uma relação de (n log(n)) o HeapSort acaba perdendo em velocidade para o QuickSort.
    Alem disso, pode ser considerado um algoritmo instavél.
   
*/
import java.util.Scanner;

public class HeapSort {
    public static long IFS = 0;
    public static long heapSort(double[] array,boolean desc){
        long tempInicial = System.nanoTime();
        
	int count = array.length;
	int fim = count - 1;
        if(!desc){
            heapify(array, count);
            while(fim > 0){

		double tmp = array[fim];
		array[fim] = array[0];
		array[0] = tmp;
		siftDown(array, 0, fim - 1);
		fim--;
            }
        }
        else{
            heapify(array, count,1);
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
    public static void heapify(double[] array, int count, int descendente){
	
	int inicio = (count - 2) / 2;
 
	while(inicio >= 0){	
            siftDown(array, inicio, count - 1,1);
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
    public static void siftDown(double[] a, int inicio, int fim, int descendente){
	
	int raiz = inicio;
 
	while((raiz * 2 + 1) <= fim){     
            int filho = raiz * 2 + 1;           
            IFS++;
            if(filho + 1 <= fim && a[filho] > a[filho + 1]){
		filho = filho+1; 
            }
            IFS++;
            if(a[raiz] > a[filho]){
		double tmp = a[raiz];
		a[raiz] = a[filho];
		a[filho] = tmp;
		raiz = filho;       
            }else{
                return;
            }           
	}
    }

    public static void main(String[] args) {
        
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
     
      
}
