/*

INSERTIONSORT
FUNCIONAMENTO
        Insertion sort, ou ordenação por inserção, é um simples algoritmo de ordenação, eficiente quando aplicado a um pequeno número de elementos.
    Em termos gerais, ele percorre um vetor de elementos da esquerda para a direita e à medida que avança vai deixando os elementos 
    mais à esquerda ordenados. O algoritmo de inserção funciona da mesma maneira com que muitas pessoas ordenam 
    cartas em um jogo de baralho como o pôquer

 */

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {

    public static long insertionSort(double[] numeros, boolean desc) {

        long IFS = 0;
        int i, j;
        double eleito;
        if (desc == false) {

            for (i = 1; i < numeros.length; i++) {

                eleito = numeros[i];

                j = i;

                while ((j > 0) && (numeros[j - 1] > eleito)) {
                    numeros[j] = numeros[j - 1];
                    j = j - 1;
                }
                numeros[j] = eleito;
            }

        } else {

            for (i = 1; i < numeros.length; i++) {

                eleito = numeros[i];

                j = i;

                while ((j > 0) && (numeros[j - 1] < eleito)) {
                    numeros[j] = numeros[j - 1];
                    j = j - 1;
                }
                numeros[j] = eleito;
            }

        }

        return IFS;
    }

   /* public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);
        StringBuilder s = new StringBuilder("{");
        long returnedIFS = 0;
        System.out.print("Digite o tamanho do Arranjo:[10-100000000]\n");
        int size = tec.nextInt();

        if (size < 10 || size > 100000000) {
            throw new IllegalArgumentException("Tamanho invalido.");
        }
        double[] array = new double[size];
        System.out.print("\t1:Ascendente\n\t2:Descendente\nDigite:");
        int anwser = tec.nextInt();
        switch (anwser) {
            case 1:
                for (int i = 0; i < array.length; i++) {
                    array[i] = array.length - i;
                }
                System.out.println("Array preenchido de forma Descendente.");

                returnedIFS = insertionSort(array, false);

                for (int i = 0; i < array.length; i++) {
                    s.append(array[i]);
                    if (i != array.length - 1) {
                        s.append(" ");
                    }
                }
                s.append("}");
                System.out.println("Array ordenado na forma Ascendente:");
                break;
            case 2:
                for (int i = 0; i < array.length; i++) {
                    array[i] = (i + 1);
                }
                System.out.println("Array preenchido de forma Ascendente.");
                returnedIFS = insertionSort(array, true);
                for (int i = 0; i < array.length; i++) {
                    s.append(array[i]);
                    if (i != array.length) {
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
        System.out.println("IFS = " + returnedIFS);
    }
*/
}
