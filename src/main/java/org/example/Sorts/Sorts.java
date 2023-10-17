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

        //quickSort
//        printArray(array);
//        quickSort(array);
//        System.out.println();
//        printArray(array);

        //countSort
        printArray(array);
        countSort(array);
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
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > current) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = current;
        }
    }

    public static void quickSort(int[] array) {
        recursionQuickSort(array, 0, array.length - 1);
    }

    public static void recursionQuickSort(int[] array, int min, int max) {
        if (array.length == 0) return;
        if (min >= max) return;

        int middle = min + (max - min) / 2;
        int middleElement = array[middle];

        int i = min, j = max;
        while (i <= j) {
            while (array[i] < middleElement) {
                i++;
            }
            while (array[j] > middleElement) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j++;
            }
        }
        if (min < j) recursionQuickSort(array, min, j);
        if (max > i) recursionQuickSort(array, i, max);
    }


    public static void countSort(int[] array) {
        final int MAX_VALUE = 100;

        int[] count = new int[MAX_VALUE];

        for (int i = 0; i < array.length; i++) {
            count[array[i]] = count[array[i]] + 1;
        }

        int arrayindex = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                array[arrayindex] = i;
                arrayindex++;
            }
        }
    }
}
