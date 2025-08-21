package co.example.com.searching.sorting;


import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6, 89, 101, 4444, -8, -20};
        bubbleSort(arr); // Sorted: [1, 2, 5, 5, 6, 9]
        Arrays.stream(arr).forEach(value -> System.out.print(value + " "));
    }

    private static void bubbleSort(int[] arr) {
        int temp;
        int n = arr.length;
        boolean swapped = false;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

}