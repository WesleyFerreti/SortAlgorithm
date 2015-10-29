
import java.util.Scanner;


public class MergeSort {

    public static long mergeSort(double[]num, boolean desc){

        long IFS;
        
        if(!desc){        
            long tempInicial = System.nanoTime();
            IFS =  sort(num,0,num.length-1);//Metodo para Ascendente
            long tempFinal = System.nanoTime();
            double tempDecorrido = tempFinal - tempInicial;
            System.out.println("Tempo decorrido em nanosegundos = "+ tempDecorrido);
            System.out.println("Tempo decorrido em segundos = "+ tempDecorrido*Math.pow(10,-9));
        }else{
            IFS =  sort(num,0,num.length-1,1);//metodo para Descendente
        }
        return IFS;
 
    }
    
    
    
    public static long sort(double[] num, int i, int j) {
        
	int IFS = 0;
	int low = i;
        int high = j;
	
	if (low >= high) {
		
		return 0;
	}
 
	int middle = (low + high) / 2;
		
	sort(num, low, middle);
	sort(num, middle + 1, high);
		
	int end_low = middle;
	int start_high = middle + 1;
		
	while ((low <= end_low) && (start_high <= high)) {
            IFS++;
            if (num[low] < num[start_high]) {
				
                low++;
            } 
            else {
				
		double Temp = num[start_high];
				
		for (int k = start_high- 1; k >= low; k--) {
                    IFS++;
                    num[k+1] = num[k];
		}
				
		num[low] = Temp;
		low ++;
		end_low ++;
		start_high ++;
            }
	}        
        return IFS;

    }
    
    
    public static long sort(double[] num, int i, int j,int descentende) {
                
	int IFS =0;
	int low = i;
	int high = j;
		
	if (low >= high) {
			
            return IFS;
	}
 
	int middle = (low + high) / 2;
		
	sort(num, low, middle,1);
	sort(num, middle + 1, high,1);
		
	int end_low = middle;
	int start_high = middle + 1;
		
	while ((low <= end_low) && (start_high <= high)) {
		
            if (num[low] > num[start_high]) {
		
		low++;
            } 
            else {
				
		double Temp = num[start_high];
				
		for (int k = start_high - 1; k >= low; k--) {
                    IFS++;
                    num[k+1] = num[k];
		}
				
		num[low] = Temp;
		low ++;
		end_low ++;
		start_high ++;
            }
	}
        return IFS;
    }
    
    public static void main(String[] args) {
        
        long IFS = 0;
        Scanner tec = new Scanner(System.in);
        StringBuilder s = new StringBuilder("{");
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
                
                    IFS = mergeSort(array,false);
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
                IFS = mergeSort(array,true);
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

}
