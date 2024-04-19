/* CPSC 24500-001 Assignment 7
 * due 4/19/24
 * Ben Johnson
 * 
 */
import java.util.Scanner;

class Complex {
    private double a;
    private double b;

    // default constructor
    public Complex(double real, double imaginary) {
        this.a = real;
        this.b = imaginary;
    }
    // b is 0
    public Complex(double real) {
    	this.a = real;    	this.b = 0;
    }
    // Copy constructor
    public Complex(Complex complexNumber) {
        this.a = complexNumber.getRealPart();
        this.b = complexNumber.getImaginaryPart();
    }

    // constructor for 0
    public Complex() {
        this.a = 0;
        this.b = 0;
    }

    // Gets a (real part)
    public double getRealPart() {
        return this.a;
    }
    // Gets b (imaginary part)
    public double getImaginaryPart() {
        return this.b;
    }

    public Complex add(Complex other) {
        return new Complex(this.a + other.getRealPart(), this.b + other.getImaginaryPart());
    }

    public Complex subtract(Complex other) {
        return new Complex(this.a - other.getRealPart(), this.b - other.getImaginaryPart());
    }

    public Complex multiply(Complex other) {
        double real = this.a * other.getRealPart() - this.b * other.getImaginaryPart();
        double imaginary = this.a * other.getImaginaryPart() + this.b * other.getRealPart();
        return new Complex(real, imaginary);
    }

    public Complex divide(Complex other) {
        double divisor = Math.pow(other.getRealPart(), 2) + Math.pow(other.getImaginaryPart(), 2);
        double real = (this.a * other.getRealPart() + this.b * other.getImaginaryPart()) / divisor;
        double imaginary = (this.b * other.getRealPart() - this.a * other.getImaginaryPart()) / divisor;
        return new Complex(real, imaginary);
    }

    public double abs() {
        return Math.sqrt(Math.pow(this.a, 2) + Math.pow(this.b, 2));
    }

    // Override toString method
    @Override
    public String toString() {
        if (this.b == 0) {
            return String.valueOf(this.a);
        } else if (this.b < 0) {
            return "(" + this.a + " - " + (-this.b) + "i)";
        } else {
            return "(" + this.a + " + " + this.b + "i)";
        }
    }

    // Compares two complex numbers by abs
    public boolean Comparable(Complex other) {
        return this.abs() < other.abs();
    }


    // Test program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first complex number: ");
        double a1 = scanner.nextDouble();
        double b1 = scanner.nextDouble();
        Complex c1 = new Complex(a1, b1);

        System.out.print("Enter the second complex number: ");
        double a2 = scanner.nextDouble();
        double b2 = scanner.nextDouble();
        Complex c2 = new Complex(a2, b2);

        System.out.println(c1 + " + " + c2 + " = " + c1.add(c2));
        System.out.println(c1 + " - " + c2 + " = " + c1.subtract(c2));
        System.out.println(c1 + " * " + c2 + " = " + c1.multiply(c2));
        System.out.println(c1 + " / " + c2 + " = " + c1.divide(c2));
        System.out.println("|" + c1 + "| = " + c1.abs());
        System.out.println("|" + c2 + "| = " + c2.abs());

        // Test getRealPart method
        double realPartC1 = c1.getRealPart();
        System.out.println("Real part of complex #1: " + realPartC1);

        // Test getImaginaryPart method
        double imaginaryPartC1 = c1.getImaginaryPart();
        System.out.println("Imaginary part of complex #2: " + imaginaryPartC1);

        // Test toString method
        String c1String = c1.toString();
        System.out.println("String of complex #1: " + c1String);
        
     // Test Comparable method
        boolean isSmaller = c1.Comparable(c2);
        if (isSmaller) {
            System.out.println("Complex #1 < Complex #2.");
        } else {
            System.out.println("Complex number 1 > Complex number 2.");
        }        
    }
}
