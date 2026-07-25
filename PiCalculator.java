import java.util.Scanner;

public class PiCalculator {
    // Private variables (accessible only within this class)
    private int terms;
    private double radius;

    // Public final constant PI
    public final double PI;

    // Constructor to initialize the values and compute Pi
    public PiCalculator(int terms, double radius) {
        this.terms = terms;
        this.radius = radius;
        this.PI = computeLeibnizPi(terms);
    }

    // Helper method to compute Pi using Leibniz Series
    private double computeLeibnizPi(int numTerms) {
        double sum = 0.0;
        for (int i = 0; i < numTerms; i++) {
            if (i % 2 == 0) {
                sum += 1.0 / (2 * i + 1);
            } else {
                sum -= 1.0 / (2 * i + 1);
            }
        }
        return 4.0 * sum;
    }

    // Public method accessible from anywhere
    public double getPiValue() {
        return this.PI;
    }

    // Protected method accessible within the same package/subclasses
    protected void calculateArea(double r) {
        System.out.println("Protected Method - Displaying Precision Info:");
        System.out.println("Precision used: " + this.terms + " terms");
        System.out.println("Series used: Leibniz Series (4/1 - 4/3 + 4/5 - 4/7 + 4/9 ...)\n");
        
        double area = this.PI * r * r;
        System.out.println("Calculated Area of Circle: " + area);
    }

    // Main driver method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Pi Calculator using Access Specifiers ===");
        System.out.print("Enter the number of terms for Pi approximation: ");
        int inputTerms = scanner.nextInt();
        
        System.out.print("Enter the radius value to compute the area using Pi: ");
        double inputRadius = scanner.nextDouble();

        System.out.println("\nCalculating Pi using Leibniz Series...\n");

        // Create an object of PiCalculator
        PiCalculator calc = new PiCalculator(inputTerms, inputRadius);

        // Access the public method to display the value of Pi
        System.out.println("Public Method - Displaying Result:");
        System.out.println("Approximated value of Pi: " + calc.getPiValue());
        System.out.println();

        // Call the protected method to calculate area and display information
        calc.calculateArea(inputRadius);
        System.out.println();

        // Demonstrate private access restriction
        System.out.println("Private Data - Accessed only within class:");
        System.out.println("Raw computed value (private): " + calc.PI);
        
        // UNCOMMENTING THE LINE BELOW WILL CAUSE A COMPILE-TIME ERROR IN VS CODE:
        // System.out.println(calc.terms); 

        scanner.close();
    }
}