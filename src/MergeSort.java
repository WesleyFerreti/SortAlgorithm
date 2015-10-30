//Wesley Ferreti    142B22
//Dennis Quintal    142B22
/*
    MergeSort:uma ideia básica consiste em Dividir(o problema em vários sub-problemas e resolver esses sub-problemas através da recursividade)
e Conquistar(após todos os sub-problemas terem sido resolvidos ocorre a conquista que é a união das resoluções dos sub-problemas).
Como o algoritmo do Merge Sort usa a recursividade em alguns problemas esta técnica não é muito eficiente devido ao 
alto consumo de memória e tempo de execução.

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

    public static void sort(double[] array, int i, int j){

        int menor = i;
        int maior = j;
        IFS++;
        if (menor >= maior){
            return;
        }

        int meio = (menor + maior) / 2;

        sort(array, menor, meio);
        sort(array, meio + 1, maior);

        int final_menor = meio;
        int inicio_maior = meio + 1;

        while ((menor <= final_menor) && (inicio_maior <= maior)){
            IFS++;
            if (array[menor] < array[inicio_maior]) {

                menor++;
            } else {

                double temp = array[inicio_maior];

                for (int k = inicio_maior - 1; k >= menor; k--){

                    array[k + 1] = array[k];
                }

                array[menor] = temp;
                menor++;
                final_menor++;
                inicio_maior++;
            }
        }

    }

    public static void sort(double[] num, int i, int j, int descentende){

        int menor = i;
        int maior = j;
        IFS++;
        if (menor >= maior) {

            return;
        }

        int meio = (menor + maior) / 2;

        sort(num, menor, meio, 1);
        sort(num, meio + 1, maior, 1);

        int final_menor = meio;
        int inicio_maior = meio + 1;

        while ((menor <= final_menor) && (inicio_maior <= maior)){
            IFS++;
            if (num[menor] > num[inicio_maior]) {

                menor++;
            } else {

                double temp = num[inicio_maior];

                for (int k = inicio_maior - 1; k >= menor; k--){

                    num[k + 1] = num[k];
                }

                num[menor] = temp;
                menor++;
                final_menor++;
                inicio_maior++;
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
                int n = 0;
                for(int i = array.length; i > 0;i-- ){
                    array[n] = i;
                    n++;
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
