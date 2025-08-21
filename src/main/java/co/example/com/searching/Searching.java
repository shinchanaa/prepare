package co.example.com.searching;

public class Searching {


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; //sorted array
        //int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}; //unsorted array
        int target = 11;
       // int result = linearSearch(arr, target);
       // int result = binarySearch(arr, target);
        int result = binarySearchRecursion(arr, target,0,arr.length-1);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }

    private static int linearSearch(int[] arr, int target) {

        for(int i=0;i<arr.length;i++){
            if(target==arr[i]){
                System.out.println("Found");
                return i;
            }
        }
        System.out.println("Not Found");
        return -1;
    }

    private static int binarySearch(int[] arr,int target){

        int left=0;
        int right=arr.length-1;
        int mid;
        while(left<=right){
            mid= (right+left)/2;
            if(arr[mid]==target){
                return mid;
            }else if(target>arr[mid]){
                left=mid+1;
            }else{
                right=mid-1;
            }
            System.out.println( right +" "+ mid+" "+left);
        }
        return -1;
    }


   static int  binarySearchRecursion(int[] arr,int target,int left,int right){
        if(left>right){
            return -1;
        }
        int mid= (left+right)/2;
       if(arr[mid]==target){
           return mid;
       }else if(target>arr[mid]){
           return binarySearchRecursion(arr,target,mid+1,right);
       }else{
           return binarySearchRecursion(arr,target,left,mid-1);
       }

    }



}