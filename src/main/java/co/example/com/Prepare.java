package co.example.com;


import java.util.*;

public class Prepare {

    public static void main(String[] args) {

        ImmutableTest immutableTest = new ImmutableTest(1, "test", Arrays.asList("a", "b", "c"));

        immutableTest.getListD().add("12");

        System.out.println("ImmutableTest ID: " + immutableTest.getId());
        System.out.println("ImmutableTest String: " + immutableTest.getStr());
        System.out.println("ImmutableTest List: " + immutableTest.getListD());

        Prepare obj= new Prepare();
        System.out.println(obj.missingNumber(new int[]{-3,1, 3, 4,5}));
        System.out.println(obj.missingNumber(new int[]{1, 2}));

    }


    public int missingNumber(int[] arr) {

        int n= arr.length;
        int count=0;
        boolean [] pos = new boolean[n];

        for(int i=0;i<n;i++){

            if(arr[i]>0 && arr[i]<=n){
                pos[arr[i]-1]=true;count++;
            }
        }

        for (boolean b : pos) {
            System.out.println(b);
        }


        for(int i=0;i<n;i++){
            if(!pos[i])
                return i+1;
        }


    if(count==n)
        return 0;
    return n+1;


    }
}




