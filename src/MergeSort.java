//Wesley Ferreti    142B22
//Dennis Quintal    142B22
/*
    MergeSort:uma ideia básica consiste em Dividir(o problema em vários sub-problemas e resolver esses sub-problemas através da recursividade)
e Conquistar(após todos os sub-problemas terem sido resolvidos ocorre a conquista que é a união das resoluções dos sub-problemas).
Como o algoritmo do Merge Sort usa a recursividade em alguns problemas esta técnica não é muito eficiente devido ao 
alto consumo de memória.

    complexidade pior caso = (n^2)
    complexidade caso médio  = (n log (n))
    complexidade melhor casO = (n log (n))

*/
import java.util.Scanner;

public class MergeSort {

    public static long IFS = 0;

    public static long mergeSort(double[] num, boolean desc) {
        long tempInicial = System.nanoTime();
        if (!desc) {
            sort(num, 0, num.length - 1);//Metodo para Ascendente 
        } else {
            sort(num, 0, num.length - 1, 1);//metodo para Descendente
        }
        long tempFinal = System.nanoTime();
        long tempDecorrido = tempFinal - tempInicial;
        System.out.println("Tempo decorrido em nanosegundos = " + tempDecorrido);
        System.out.println("Tempo decorrido em segundos = " + tempDecorrido * Math.pow(10, -9));
        return IFS;
    }

    public static void sort(double[] array, int inicio, int fim){//Ascendente
        IFS++;
	if (fim <= inicio) {
		return;
	}
	int meio = (inicio + fim) / 2;
	sort(array, inicio, meio);
	sort(array, meio + 1, fim);
	double[] A = new double[meio - inicio + 1];
	double[] B = new double[fim - meio];
	for (int i = 0; i <= meio - inicio; i++) {
		A[i] = array[inicio + i];
	}
	for (int i = 0; i <= fim - meio - 1; i++) {
		B[i] = array[meio + 1 + i];
	}
	int i = 0;
	int j = 0;
	for (int k = inicio; k <= fim; k++) {
                IFS++;
		if (i < A.length && j < B.length) {
                        IFS++;
			if (A[i] < B[j]) {
				array[k] = A[i++];
			} else {
				array[k] = B[j++];
			}
                
		}else{
                    IFS++;
                    if (i < A.length) {
			array[k] = A[i++];
                    }
                    else{
                        IFS++;
                        if (j < B.length) {
                        array[k] = B[j++];
                    }
                }
            }
        }
    }
    public static void sort(double[] array, int inicio, int fim, int descendente){//Descendente
        IFS++;
	if (fim <= inicio) {
		return;
	}
	int meio = (inicio + fim) / 2;
	sort(array, inicio, meio,1);
	sort(array, meio + 1, fim,1);
	double[] A = new double[meio - inicio + 1];
	double[] B = new double[fim - meio];
	for (int i = 0; i <= meio - inicio; i++) {
		A[i] = array[inicio + i];
	}
	for (int i = 0; i <= fim - meio - 1; i++) {
		B[i] = array[meio + 1 + i];
	}
	int i = 0;
	int j = 0;
	for (int k = inicio; k <= fim; k++){
                IFS++;
		if (i < A.length && j < B.length) {
                        IFS++;
			if (A[i] > B[j]){
				array[k] = A[i++];
			} else {
				array[k] = B[j++];
			}
                
		}else{
                    IFS++;
                    if (i < A.length) {
			array[k] = A[i++];
                    }
                    else{
                        IFS++;
                        if (j < B.length) {
                        array[k] = B[j++];
                    }
                }
            }
        }
    }

   
  /* public static void main(String[] args) {
        
        long returnedIFS = 0;
        Scanner tec = new Scanner(System.in);
        StringBuilder s = new StringBuilder("{");
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
                
                returnedIFS = mergeSort(array,false);
                
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
                returnedIFS = mergeSort(array,true);
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

