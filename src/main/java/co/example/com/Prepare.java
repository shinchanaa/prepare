package co.example.com;


import java.util.*;

public class Prepare {

    public static void main(String[] args) {

        ImmutableTest immutableTest = new ImmutableTest(1, "test", Arrays.asList("a", "b", "c"));

        immutableTest.getListD().add("12");

        System.out.println("ImmutableTest ID: " + immutableTest.getId());
        System.out.println("ImmutableTest String: " + immutableTest.getStr());
        System.out.println("ImmutableTest List: " + immutableTest.getListD());

    }
}




