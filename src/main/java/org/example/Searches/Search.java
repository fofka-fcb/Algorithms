package org.example.Searches;

import java.util.Arrays;

public class Search {
    public static void main(String[] args) {
        int[] array = new int[]{11, 17, 2, 35, 67, 5, 21, 48, 54, 79};
//        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(searchBinaryRecursive(array, 0, array.length, 79));
    }

    public static int searchBinaryRecursive(int[] array, int startIndex, int endIndex, int elementToFind) {
        if (endIndex >= startIndex){
            int middleIndex = startIndex + (endIndex - startIndex) / 2;
            if (array[middleIndex] == elementToFind) return middleIndex;
            if (array[middleIndex] > elementToFind)
                return searchBinaryRecursive(array, startIndex, middleIndex - 1, elementToFind);
            else return searchBinaryRecursive(array, middleIndex + 1, endIndex, elementToFind);
        }
        return -1;
    }
}
