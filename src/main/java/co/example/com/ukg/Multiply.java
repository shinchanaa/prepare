package co.example.com.ukg;

class Multiply {
    public int multiply(int a, int b, Calculator c) {
        System.out.println("multiply");

        if (a == 0 || b == 0) {
            System.out.println("result = 0");
            return 0;
        }

        boolean isNegativeResult = (a < 0) ^ (b < 0); // XOR → result is negative if only one is negative

        int absA = Math.abs(a);
        int absB = Math.abs(b);

        int result = 0;

        for (int i = 0; i < absB; i++) {
            int before = result;
            result = c.add(result, absA);
            System.out.println("Adding " + before + " + " + absA + " = " + result);
        }

        if (isNegativeResult) {
            result = -result;
        }

        System.out.println("result = " + result);
        return result;
    }



    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        Calculator calculator = new Adder();

        int a = 5;
        int b = -3;

        int result = multiply.multiply(a, b, calculator);
        System.out.println("Result of " + a + " * " + b + " is: " + result);
    }
}