package co.example.com.joyoftheday;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ExecutableClass {

    public static void main(String[] args) {
        // This is the entry point of the Java application.
        System.out.println("Hello, Joy of the Day!");
        ExecutableClass obj = new ExecutableClass();

        List<Employee> employeeList= obj.prepareForExecution();

        //setOneQuestion(obj, employeeList);
    //    setTwoQuestion(obj, employeeList);
        obj.getSecondHighestPaidEmployee(employeeList);
        //failFast_FailSafe();


    }

    private static void setTwoQuestion(ExecutableClass obj, List<Employee> employeeList) {

       // obj.countNoEmpEachDepartment(employeeList);
        //obj.averageSalaryOfEachDepartment(employeeList);
        obj.getYoungestMaleEmployeeInProductDevelopment(employeeList);
    }

    private void getYoungestMaleEmployeeInProductDevelopment(List<Employee> employeeList) {

        System.out.println("getYoungestMaleEmployeeInProductDevelopment");
        System.out.println(employeeList.stream().filter(val->val.getDepartment().equals("Product Development"))
                .collect(Collectors.minBy(Comparator.comparing(Employee::getAge))));

        System.out.println( "other way "+
        employeeList.stream().filter(val->"Male".equals(val.getGender()) && ("Product Development").equals(val.getDepartment()))
                .min(Comparator.comparingInt(Employee::getAge)));


    }

    private void averageSalaryOfEachDepartment(List<Employee> employeeList) {

        Map<String ,Double>empMap= employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));

        empMap.forEach((dep, avgSal) -> {
            System.out.println(dep + " Average Salary: " + String.format("%.2f", avgSal));
        });

    }

    private void countNoEmpEachDepartment(List<Employee> employeeList) {

        Map<String ,Long>empMap= employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
        empMap.forEach((dep,listemp)->
        {
            System.out.println(dep+" has "+listemp);
        });
    }

    private static void setOneQuestion(ExecutableClass obj, List<Employee> employeeList) {
        obj.findNumberOfMaleFemaleEmployee(employeeList);
        obj.printNameOfAllDepartments(employeeList);
        obj.printAverageAgeOfGender(employeeList);
        obj.getHighestPaidEmployee(employeeList);
        obj.getSecondHighestPaidEmployee(employeeList);
        obj.getNameWhoJoinedAfter2015(employeeList);
    }

    private void getSecondHighestPaidEmployee(List<Employee> employeeList) {

        Employee emp1  = new Employee(1,"Ashish",1000,20);
        Employee emp2  = new Employee(2,"Rakesh",1020,23);
        Employee emp3  = new Employee(3,"Bhupendra",500,24);
        Employee emp4  = new Employee(4,"Rajesh",19102,23);
        Employee emp5  = new Employee(5,"Akash",403,22);

        Map<Integer, Employee> map = new HashMap<>();
        map.put(1, emp1);
        map.put(2, emp2);
        map.put(3, emp3);
        map.put(4, emp4);
        map.put(5, emp5);

        List<Employee> sorted  =map.values().stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());
        double second=sorted.size() >1 ? sorted.get(1).getSalary():null;
        System.out.println("Second highest salary: "+ second);


    }

    private void getNameWhoJoinedAfter2015(List<Employee> employeeList) {

        System.out.println("getNameWhoJoinedAfter2015:"+employeeList.stream()
                .filter(emp->emp.yearOfJoining>2015)
                .map(Employee::getName)
                .findFirst());
        employeeList.stream()
                .filter(emp->emp.yearOfJoining>2015)
                .map(Employee::getName)
                .forEach(System.out::println);
    }

    private static void failFast_FailSafe() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");

        for (String s : list) {
           // list.add("C"); // Modifies list during iteration
            // Throws ConcurrentModificationException
        }

        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("A", "Apple");
        map.put("B", "Banana");

        for (String key : map.keySet()) {


            map.put("C", "Cherry"); // No exception
            System.out.println(key);
        }
        System.out.println(map);
    }

    //Get the details of highest paid employee in the organization?
    private void getHighestPaidEmployee(List<Employee> employeeList) {

        System.out.println("Maximum salary: "+ employeeList.stream()
                .mapToDouble(Employee::getSalary).max().orElse(0.0));

        System.out.println("MAX sal other way: "+employeeList.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

        System.out.println("MAX sal another way: "+employeeList.stream()
                .max(Comparator.comparing(Employee::getSalary)));


    }

    //How many male and female employees are there in the organization?
    void findNumberOfMaleFemaleEmployee(List<Employee> list){
        System.out.println("Counting Male and Female: ");
        Map<String,List<Employee>> groupdata=list.stream()
                .collect(Collectors.groupingBy(Employee::getGender));
        System.out.println("Male: "+groupdata.get("Male").stream().count());
        System.out.println("Female: "+groupdata.get("Female").stream().count());

        Map<String,Long> genderCount= list.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
        System.out.println("M:"+genderCount.get("Male"));
        System.out.println("F:"+genderCount.get("Female"));
    }

    //Print the name of all departments in the organization?

    void printNameOfAllDepartments(List<Employee> list){

      /*  List<String> departments= list.stream().map(emp->emp.department)
                .distinct().collect(Collectors.toList());

        System.out.println(departments);*/

        list.stream().map(emp->emp.department)
                .distinct().forEach(System.out::println);

    }

    //What is the average age of male and female employees?
    void printAverageAgeOfGender(List<Employee> list){

        Map<String, Double> avgAgeOfMaleAndFemaleEmployees = list.stream()
                .collect(Collectors.groupingBy(Employee::getGender,
                Collectors.averagingInt(Employee::getAge)));

        System.out.println(avgAgeOfMaleAndFemaleEmployees);
    }


    private List<Employee> prepareForExecution() {
        // This method can be used to prepare the environment before execution.
        System.out.println("Preparing for execution...");
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
        return employeeList;
    }

}