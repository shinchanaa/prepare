package co.example.com.st;


import co.example.com.Main;

import java.util.*;
import java.util.stream.Collectors;

public class MainClass {


    public static void main(String[] args) {

        //System.out.println("Testing if [william, jones, aaron, seppe, frank, gilliam] returns 14");
       /* System.out.println("Length: " +
        getTotalNumberOfLettersOfNamesLongerThanFive("william", "jones", "aaron", "seppe", "frank", "gilliam"));
*/
        List<List<String>> collection = Arrays.asList(
                Arrays.asList("Viktor", "Farcic"),
                Arrays.asList("John", "Doe", "Third"));

        List<String> transform = transform(collection);
       // System.out.println("Transformed collection: " + transform);


        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> result = Arrays.asList(sara, eva, viktor);
        //System.out.println(getOldestPerson(result).getName());

      //  System.out.println(getString(List.of(1, 2, 3, 43, 5)).toString());

        kadaneAlgo();


    }

    public static int getTotalNumberOfLettersOfNamesLongerThanFive(String... names) {
        int total = Arrays.stream(names).filter(name->name.length()>5)
                .mapToInt(value -> value.length()).sum();
        return total;
    }



    public static List<String> transform(List<List<String>> collection) {
        List<String> newCollection = collection.stream().flatMap(data->data.stream()).collect(Collectors.toList());
        return newCollection;
    }


    public static Person getOldestPerson(List<Person> people) {
        /*Person oldestPerson = new Person("", 0);
        for (Person person : people) {
            if (person.getAge() > oldestPerson.getAge()) {
                oldestPerson = person;
            }
        }*/

       Person oldestPerson1 = people.stream().max((p1,p2)->p1.getAge()-p2.getAge()).orElse(new Person("",0));
       Person oldestPerson2 = people.stream().max(Comparator.comparingInt(Person::getAge)).orElse(new Person("",0));
       Person oldestPerson = people.stream().max(Comparator.comparing(Person::getAge)).orElse(new Person("",0));
       Person oldestPerson4 = people.stream().max(Comparator.comparing(Person::getAge)).orElse(new Person("",0));

        System.out.println("Oldest person using max with lambda: " + oldestPerson1.getName() + ", Age: " + oldestPerson1.getAge());
        System.out.println("Oldest person using max with Comparator: " + oldestPerson2.getName() + ", Age: " + oldestPerson2.getAge());
        System.out.println("Oldest person using max with method reference: " + oldestPerson.getName() + ", Age: " + oldestPerson.getAge());
        return oldestPerson;
    }

    //List<Integer> numbers = asList(1, 2, 3, 4, 5);
    public static int calculate(List<Integer> numbers) {
        int total = numbers.stream().mapToInt(a-> a).sum();
        return total;
    }

    public static int calculateReduce(List<Integer> numbers) {
        int total = numbers.stream().reduce(0,(a,b)->a+b);
        return total;
    }

/*    Person sara = new Person("Sara", 4);
    Person viktor = new Person("Viktor", 40);
    Person eva = new Person("Eva", 42);
    Person anna = new Person("Anna", 5);*/
    public static Set<String> getKidNames(List<Person> people) {

        Set<String> kids=  people.stream()
                .filter(a->a.getAge()<18)
                .map(Person::getName)
                .collect(Collectors.toSet());

        return kids;
    }


    public static Map<Boolean, List<Person>> partitionAdults(List<Person> people) {
        Map<Boolean, List<Person>> map = new HashMap<>();
        map.put(true, new ArrayList<>());
        map.put(false, new ArrayList<>());
        for (Person person : people) {
            map.get(person.getAge() >= 18).add(person);
        }
        return map;
    }


    public static Object getString(List<Integer> list) {
        return list.stream().map(a->{
            if(a%2==0)
                return "e"+a;
            return "o"+a;
        }).collect(Collectors.joining(","));
    }






    public static void kadaneAlgo(){
        // Implementation of Kadane's algorithm
        // This method can be used to find the maximum subarray sum in linear time
        MainClass obj = new MainClass();
        int[] arr = {2, 3, -8, 7, -1, 2, 3};
      //  int[] arr = {-2, -3, 4, -1, -2, 1,5, -3};
       // int[] arr = {-2, -3, -8, -7, -1, -2, -3};


        System.out.println(obj.maxSubarraySum_Simple(arr));
        System.out.println(obj.maxSubarraySum_Better(arr));
        System.out.println(obj.maxSubarraySum_Optimal(arr));
    }

    private int maxSubarraySum_Optimal(int[] arr) {
        System.out.println("Optimal Method");
        int maxSoFar = Integer.MIN_VALUE;
        int sum=0;
        List<Integer> subArray = new ArrayList<>();
        int subArraystartIndex = -1;
        int subArrayEndIndex = -1;
        int start=-1;
        for(int i=0;i<arr.length;i++){

            if(sum==0){
                start = i;
            }

            sum+=arr[i];

            if(maxSoFar<sum){
                maxSoFar = sum;
                subArraystartIndex = start;   subArrayEndIndex = i;
            }

            if(sum<0)
            { sum=0;
            }

        }
        System.out.println("SubArray: " + subArraystartIndex);
        System.out.println("SubArray: " + Arrays.toString(Arrays.copyOfRange(arr, subArraystartIndex,subArrayEndIndex+1)));
        return maxSoFar;
    }


    public int maxSubarraySum_Simple(int[] arr) {
        // Code here
        System.out.println("Simple Method");
        int res;

        boolean isAllNegative = true;
        boolean isAllPositive = true;
        for(int a:arr){
            if(a>0){
                isAllNegative=false;
                break;
            }
        }

        for(int a:arr){
            if(a<0){
                isAllPositive=false;
                break;
            }
        }

        if(isAllNegative){
            res= Arrays.stream(arr).max().orElse(0);
            return res;
        }

        if (isAllPositive){
            res= Arrays.stream(arr).sum();
            return res;
        }

        int maxSoFar = 0;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum=0;
            for(int j=i;j<arr.length;j++){
                sum= giveSum(arr,i,j);
                //System.out.println("From i:"+i+" To "+(j)+" MaxSoFar: " + maxSoFar + ", Sum: " + sum);
                if(maxSoFar<sum){

                    maxSoFar = sum;
                }
            }

            //System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");



        }
        return maxSoFar;

    }

    int giveSum(int arr[],int i,int j){
        if(i>j){
            return 0;
        }
        return arr[i]+giveSum(arr,i+1,j);
    }

    public int maxSubarraySum_Better(int[] arr) {
        // Code here
        System.out.println("Better Method");
        int res;

        boolean isAllNegative = true;
        boolean isAllPositive = true;
        for(int a:arr){
            if(a>0){
                isAllNegative=false;
                break;
            }
        }

        for(int a:arr){
            if(a<0){
                isAllPositive=false;
                break;
            }
        }

        if(isAllNegative){
            res= Arrays.stream(arr).max().orElse(0);
            return res;
        }

        if (isAllPositive){
            res= Arrays.stream(arr).sum();
            return res;
        }

        int maxSoFar = 0;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum=0;
            for(int j=i;j<arr.length;j++){
                sum+= arr[j];
               // System.out.println("From i:"+i+" To "+(j)+" MaxSoFar: " + maxSoFar + ", Sum: " + sum);
                if(maxSoFar<sum){

                    maxSoFar = sum;
                }
            }

          //  System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");



        }
        return maxSoFar;

    }
}