interface Shape {
    double calculateArea();
}

class Circle implements Shape {
    private double radius;
    public Circle(double radius) { this.radius = radius; }
    public double calculateArea() { return Math.PI * radius * radius; }
    public double getRadius() { return radius; }
}

class Rectangle implements Shape {
    private double length, width;
    public Rectangle(double length, double width) { this.length = length; this.width = width; }
    public double calculateArea() { return length * width; }
    public double getLength() { return length; }
    public double getWidth() { return width; }
}

class Triangle implements Shape {
    private double base, height;
    public Triangle(double base, double height) { this.base = base; this.height = height; }
    public double calculateArea() { return 0.5 * base * height; }
    public double getBase() { return base; }
    public double getHeight() { return height; }
}

public class ShapeAreaCalculator {
    public static void main(String[] args) {
        System.out.println("----- Shape Area Calculator -----\n");

        Circle c = new Circle(5.0);
        System.out.println("Circle:");
        System.out.println("Radius = " + c.getRadius());
        System.out.println("Area of Circle = " + c.calculateArea());

        Rectangle r = new Rectangle(4.0, 6.0);
        System.out.println("\nRectangle:");
        System.out.println("Length = " + r.getLength() + ", Width = " + r.getWidth());
        System.out.println("Area of Rectangle = " + r.calculateArea());

        Triangle t = new Triangle(3.0, 8.0);
        System.out.println("\nTriangle:");
        System.out.println("Base = " + t.getBase() + ", Height = " + t.getHeight());
        System.out.println("Area of Triangle = " + t.calculateArea());
    }
}