/*

QUICKSORT
FUNCIONAMENTO
        O Quicksort adota a estratégia de divisão e conquista. A estratégia consiste em rearranjar as chaves de modo que as chaves "menores" 
    precedam as chaves "maiores". Em seguida o Quicksort ordena as duas sublistas de chaves menores e maiores recursivamente até que a 
    lista completa se encontre ordenada. [3] Os passos são:

    1-)Escolha um elemento da lista, denominado pivô;
    2-)Rearranje a lista de forma que todos os elementos anteriores ao pivô sejam menores que ele, 
        e todos os elementos posteriores ao pivô sejam maiores que ele. Ao fim do processo o pivô estará em sua posição final e 
        haverá duas sublistas não ordenadas. Essa operação é denominada partição;
    3-)Recursivamente ordene a sublista dos elementos menores e a sublista dos elementos maiores;

 */

import java.util.Scanner;
import java.util.Arrays;

public class QuickSortRecursive {

    public static long IFS;

    public static long quickSort(double[] items, boolean desc) {
        if (desc == false) {

            qs(items, 0, items.length - 1);

        } else {
            qs(items, 0, items.length - 1, "decrecente");
        }
        return IFS;
    }

    private static void qs(double[] items, int left, int right) {
        int i, j;
        double pivot, temp;
        i = left;
        j = right;
        pivot = items[(left + right) / 2];

        do {
            while ((items[i] < pivot) && (i < right)) {
                i++;
            }

            while ((pivot < items[j]) && (j > left)) {
                j--;
            }
            IFS++;
            if (i <= j) {
                temp = items[i];
                items[i] = items[j];
                items[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);
        IFS++;
        if (left < j) {
            qs(items, left, j);
        }
        IFS++;
        if (i < right) {
            qs(items, i, right);
        }

    }

    private static void qs(double[] items, int left, int right, String desc) {
        int i, j;
        double pivot, temp;
        i = left;
        j = right;
        pivot = items[(left + right) / 2];

        do {
            while ((items[i] > pivot) && (i < right)) {
                i++;
            }

            while ((pivot > items[j]) && (j > left)) {
                j--;
            }
            IFS++;
            if (i <= j) {
                temp = items[i];
                items[i] = items[j];
                items[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);
        IFS++;
        if (left < j) {
            qs(items, left, j, "decrecente");
        }
        IFS++;
        if (i < right) {
            qs(items, i, right, "decrecente");
        }

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

                returnedIFS = quickSort(array, false);

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
                returnedIFS = quickSort(array, true);
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
