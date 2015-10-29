

import java.util.Scanner;


public class HeapSort {
    
    public static long heapSort(double[] a,boolean desc){
        long tempInicial = System.nanoTime();
        long IFS = 0;
	int count = a.length;
	//first place a in max-heap order
	heapify(a, count);
 
	int end = count - 1;
        if(!desc){
        
	while(end > 0){
            IFS++;
		//swap the root(maximum value) of the heap with the
		//last element of the heap
		double tmp = a[end];
		a[end] = a[0];
		a[0] = tmp;
		//put the heap back in max-heap order
		siftDown(a, 0, end - 1);
		//decrement the size of the heap so that the previous
		//max value will stay in its proper place
		end--;
	}
        }
        else{
            while(end > 0){
            IFS++;
		//swap the root(maximum value) of the heap with the
		//last element of the heap
		double tmp = a[end];
		a[end] = a[0];
		a[0] = tmp;
		//put the heap back in max-heap order
		siftDown(a, 0, end - 1,1);
		//decrement the size of the heap so that the previous
		//max value will stay in its proper place
		end--;
            
        }
    }
        long tempFinal = System.nanoTime();
        long tempDecorrido = tempFinal - tempInicial;
        System.out.println("Tempo decorrido em nanosegundos = "+ tempDecorrido);
        System.out.println("Tempo decorrido em segundos = "+ tempDecorrido*Math.pow(10,-9));
        return IFS;
    }
 
public static void heapify(double[] a, int count){
	//start is assigned the index in a of the last parent node
	int start = (count - 2) / 2; //binary heap
 
	while(start >= 0){
		//sift down the node at index start to the proper place
		//such that all nodes below the start index are in heap
		//order
		siftDown(a, start, count - 1);
		start--;
	}
	//after sifting down the root all nodes/elements are in heap order
}
 
public static void siftDown(double[] a, int start, int end){
	//end represents the limit of how far down the heap to sift
	int root = start;
 
	while((root * 2 + 1) <= end){      //While the root has at least one child
		int child = root * 2 + 1;           //root*2+1 points to the left child
		//if the child has a sibling and the child's value is less than its sibling's...
		if(child + 1 <= end && a[child] < a[child + 1])
			child = child+1;           //... then point to the right child instead
		if(a[root] < a[child]){     //out of max-heap order
			double tmp = a[root];
			a[root] = a[child];
			a[child] = tmp;
			root = child;                //repeat to continue sifting down the child now
		}else
			return;
	}
}

public static void siftDown(double[] a, int start, int end,int descendente){
	//end represents the limit of how far down the heap to sift
	int root = start;
 
	while((root * 2 + 1) <= end){      //While the root has at least one child
		int child = root * 2 + 1;           //root*2+1 points to the left child
		//if the child has a sibling and the child's value is less than its sibling's...
		if(child + 1 <= end && a[child]  > a[child + 1])
                    child = child;
			     //... then point to the right child instead
		if(a[root] > a[child]){     //out of max-heap order
			double tmp = a[root];
			a[root] = a[child];
			a[child] = tmp;
			root = child;                //repeat to continue sifting down the child now
		}else
			return;
	}
}

    
   /* public static void main(String[] args) {
        
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
                    for(int w = 0 ;w<10;w++){
                        n=0;
                    for(int i = array.length; i > 0;i-- ){
                        array[n] = i;
                        n++;
                    }
                    System.out.println("Array preenchido de forma Descendente.");
                    
                    IFS = heapSort(array,false);
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
                    IFS = heapSort(array,true);
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
