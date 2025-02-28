package org.example;

public class Calculator {
    // Square root function
    public double sqrt(double x) {
        return Math.sqrt(x);
    }

    // Factorial function
    public long factorial(int x) {
        if (x == 0) return 1;
        long result = 1;
        for (int i = 1; i <= x; i++) {
            result *= i;
        }
        return result;
    }

    // Natural logarithm (base e) function
    public double ln(double x) {
        return Math.log(x);
    }

    // Power function
    public double power(double x, double b) {
        return Math.pow(x, b);
    }
}
