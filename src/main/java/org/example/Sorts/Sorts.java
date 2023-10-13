package org.example.Sorts;

public class Sorts {

    public static void main(String[] args) {
        int[] array = new int[]{11, 17, 2, 35, 67};
        //bubble sort
//        printArray(array);
//        bubbleSort(array);
//        System.out.println();
//        printArray(array);

        printArray(array);
        combSort(array);
        System.out.println();
        printArray(array);

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
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
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
                gap = (int) (gap / 1.3);
            } else {
                gap = 1;
            }
            isSorted = true;
            for (int i = gap; i < array.length; i++) {
                if (array[i - gap] > array[i]) {
                    int temp = array[i];
                    array[i] = array[i - gap];
                    array[i - gap] = temp;
                    isSorted = false;
                }
            }
        }
    }
}
