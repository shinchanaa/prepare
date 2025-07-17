package co.example.com;



import java.util.*;
import java.util.stream.Collectors;

class Student {
    int id;
    List<Integer> marks;

    public Student(int id, List<Integer> marks) {
        this.id = id;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public static void main(String[] args) {

        List<Student> listStud = Arrays.asList(
                new Student(1, Arrays.asList(98, 95, 100)),  // total = 293
                new Student(2, Arrays.asList(80, 90, 85)),   // total = 255
                new Student(3, Arrays.asList(96, 97, 98))    // total = 291
        );

     /*   List<Integer> marks= listStud.stream().filter(s->s.getMarks().stream()
                .mapToInt(Integer::intValue)
                .sum() > 290)
                .collect(Collectors.toList());*/

/*        //find out the total marks of each Student which is greater that 290.
        Map<Integer, Integer> totalMarks = listStud.stream()
                .collect(Collectors.toMap(
                        Student::getId,
                        s -> s.getMarks().stream().mapToInt(Integer::intValue).sum()
                ));*/

        //find out the total marks only of each Student which is greater that 290.

        Map<Integer, Integer> totalMarks = listStud.stream()
                .filter(s -> s.getMarks().stream().mapToInt(a-> a).sum() > 290)
                .collect(Collectors.toMap(
                        Student::getId,
                        s -> s.getMarks().stream().mapToInt(Integer::intValue).sum()
                ));

        // Filter students with total marks > 290
        Map<Integer, Integer> studentTotalMarks = listStud.stream()
                .collect(Collectors.toMap(
                        Student::getId,
                        s -> s.getMarks().stream().mapToInt(Integer::intValue).sum()
                ))
                .entrySet().stream()
                .filter(e -> e.getValue() > 290)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        // Output
        studentTotalMarks.forEach((id, total) ->
                System.out.println("Student ID: " + id + ", Total Marks: " + total));

        List<Student> marksList = listStud.stream()
                .filter(s -> s.getMarks().stream().mapToInt(a -> a).sum() > 290)
                .toList();

        System.out.println(totalMarks);

        Parent p = new Child();
        p.m1(); // Output: m1 parent → because static methods are resolved at compile-time based on reference type



    }




}
