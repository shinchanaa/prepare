package co.example.com.st;


import java.util.*;
import java.util.stream.Collectors;

public class StreamMain {


    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    public static void main(String[] args) {

        StreamMain sm = new StreamMain();
        Integer max = sm.getMax(sm.numbers);
        Integer secondMaxValue = sm.getSecondMax(sm.numbers);

        System.out.println("Colection: "+Collections.max(sm.numbers, Comparator.comparing(Integer::intValue)));


        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> result = Arrays.asList(sara, eva, viktor);
        System.out.println(getOldestPerson(result).getName());

        System.out.println(Collections.max(result, Comparator.comparing(Person::getAge)).getName());
    }


    public Integer getMax(List<Integer> list) {
        Integer data = list.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("List is empty"));
        System.out.println(data);
        return data;
    }


    public Integer getSecondMax(List<Integer> list) {
        Integer data = list.stream()
                .sorted((a,b)->b-a) // Sort in descending order
                .skip(1) // Skip the first element (max)
                .findFirst() // Get the next element
                .orElseThrow(() -> new IllegalArgumentException("List does not have a second maximum value"));
        System.out.println(data);
        return data;
    }


    public static List<String> transform(List<List<String>> collection) {


        List<String>  flatList= collection.stream().
                flatMap(Collection::stream).toList();


        return flatList;
    }


/*    public static Person getOldestPerson(List<Person> people) {
      //  Person p=                 people.stream().max(Comparator.comparing(p1->p1.getAge())).orElse(new Person("",0));
       Person p = people.stream().max(Comparator.comparing(p1->p1.getAge()))
               .orElse(new Person("", 0));


        return p;
    }*/

    public static Person getOldestPerson(List<Person> people) {
        return people.isEmpty()
                ? new Person("", 0)
                : Collections.max(people, Comparator.comparing(Person::getAge));
    }


}