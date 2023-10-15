package org.example.Sorts;

public class Sorts {

    public static void main(String[] args) {
        int[] array = new int[]{11, 17, 2, 35, 67, 5, 21, 48, 54, 79};
        //bubble sort
//        printArray(array);
//        bubbleSort(array);
//        System.out.println();
//        printArray(array);

        //comb sort
//        printArray(array);
//        combSort(array);
//        System.out.println();
//        printArray(array);

        //selection sort
//        printArray(array);
//        selectionSort(array);
//        System.out.println();
//        printArray(array);

        //standing sort
//        printArray(array);
//        standingSort(array);
//        System.out.println();
//        printArray(array);

    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "; ");
        }
    }

    public static void bubbleSort(int[] array) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    isSorted = false;
                }
            }
        }
    }

    public static void combSort(int[] array) {
        boolean isSorted = false;
        int gap = array.length;
        while (!isSorted || gap != 1) {
            if (gap > 1) {
                gap = (int) (gap / 1.25);
            } else {
                gap = 1;
            }
            isSorted = true;
            for (int i = gap; i < array.length; i++) {
                if (array[i] < array[i - gap]) {
                    int temp = array[i - gap];
                    array[i - gap] = array[i];
                    array[i] = temp;
                    isSorted = false;
                }
            }
        }
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            int minValue = array[minIndex];
            for (int x = minIndex + 1; x < array.length; x++) {
                if (array[x] < minValue) {
                    minValue = array[x];
                    minIndex = x;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    public static void standingSort(int[] array) {
        for (int i = 1; i < array.length; i++){
            int current = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > current) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = current;
        }
    }
}
