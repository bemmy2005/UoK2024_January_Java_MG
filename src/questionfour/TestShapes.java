package questionfour;

public class TestShapes {
    public static void main(String[] args) {
        // Test Circle
        Circle circle1 = new Circle();
        System.out.println("Circle 1: " + circle1);

        Circle circle2 = new Circle(3.5);
        System.out.println("Circle 2: " + circle2);

        Circle circle3 = new Circle(2.0, "blue", false);
        System.out.println("Circle 3: " + circle3);

        System.out.println("Area of Circle 3: " + circle3.getArea());
        System.out.println("Perimeter of Circle 3: " + circle3.getPerimeter());

        // Test Rectangle
        Rectangle rectangle1 = new Rectangle();
        System.out.println("Rectangle 1: " + rectangle1);

        Rectangle rectangle2 = new Rectangle(4.0, 3.0);
        System.out.println("Rectangle 2: " + rectangle2);

        Rectangle rectangle3 = new Rectangle(5.0, 2.0, "green", true);
        System.out.println("Rectangle 3: " + rectangle3);

        System.out.println("Area of Rectangle 3: " + rectangle3.getArea());
        System.out.println("Perimeter of Rectangle 3: " + rectangle3.getPerimeter());

        // Test Square
        Square square1 = new Square();
        System.out.println("Square 1: " + square1);

        Square square2 = new Square(5.0);
        System.out.println("Square 2: " + square2);

        Square square3 = new Square(4.0, "yellow", true);
        System.out.println("Square 3: " + square3);

        System.out.println("Area of Square 3: " + square3.getArea());
        System.out.println("Perimeter of Square 3: " + square3.getPerimeter());
    }
}

