

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
            
		//swap the root(maximum value) of the heap with the
		//last element of the heap
		double tmp = array[fim];
		array[fim] = array[0];
		array[0] = tmp;
		//put the heap back in max-heap order
		siftDown(array, 0, fim - 1);
		//decrement the size of the heap so that the previous
		//max value will stay in its proper place
		fim--;
            }
        }
        else{
            while(fim > 0){
            
		//swap the root(maximum value) of the heap with the
		//last element of the heap
		double tmp = array[fim];
		array[fim] = array[0];
		array[0] = tmp;
		//put the heap back in max-heap order
		siftDown(array, 0, fim - 1,1);
		//decrement the size of the heap so that the previous
		//max value will stay in its proper place
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
	//start is assigned the index in a of the last parent node
	int inicio = (count - 2) / 2; //binary heap
 
	while(inicio >= 0){
		//sift down the node at index start to the proper place
		//such that all nodes below the start index are in heap
		//order
            siftDown(array, inicio, count - 1);
            inicio--;
	}
	//after sifting down the root all nodes/elements are in heap order
    }
 
    public static void siftDown(double[] a, int inicio, int fim){
	//end represents the limit of how far down the heap to sift
	int raiz = inicio;
 
	while((raiz * 2 + 1) <= fim){      //While the root has at least one child
		int filho = raiz * 2 + 1;           //root*2+1 points to the left child
		//if the child has a sibling and the child's value is less than its sibling's...
                IFS++;
		if(filho + 1 <= fim && a[filho] < a[filho + 1]){
			filho = filho+1;           //... then point to the right child instead
                }
                IFS++;
		if(a[raiz] < a[filho]){     //out of max-heap order
			double tmp = a[raiz];
			a[raiz] = a[filho];
			a[filho] = tmp;
			raiz = filho;                //repeat to continue sifting down the child now
		}else{
                    return;
                }
                    
	}
    }

    public static void siftDown(double[] array, int inicio, int fim,int descendente){
	//end represents the limit of how far down the heap to sift
	int root = inicio;
 
	while((root * 2 + 1) <= fim){      //While the root has at least one child
            int child = root * 2 + 1;           //root*2+1 points to the left child
		//if the child has a sibling and the child's value is less than its sibling's...
            if(child + 1 <= fim && array[child]  > array[child + 1]){
                child = child;
			     //... then point to the right child instead
            }
            if(array[root] > array[child]){     //out of max-heap order
		double tmp = array[root];
		array[root] = array[child];
		array[child] = tmp;
		root = child;                //repeat to continue sifting down the child now
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
