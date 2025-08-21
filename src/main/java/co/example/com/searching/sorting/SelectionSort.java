package co.example.com.searching.sorting;


import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = {5, 2, 9, 1, 5, 6, 89, 101, 4444, -8, -20};
		selectionSort(arr); // Sorted: [1, 2, 5, 5, 6, 9]
		Arrays.stream(arr).forEach(value -> System.out.print(value + " "));
	}

	private static void selectionSort(int[] arr) {

		int n=arr.length;
		int minIndex;
		int temp;
		for(int i=0;i<n-1;i++){
			minIndex=i;
			for(int j=i+1;j<n;j++){
				if(arr[minIndex]>arr[j])
					minIndex=j;
			}

			if(minIndex!=i){
				temp=arr[minIndex];
				arr[minIndex]=arr[i];
				arr[i]=temp;
			}
		}
	}

}