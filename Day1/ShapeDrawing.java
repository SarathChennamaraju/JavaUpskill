package practice2;

abstract class Shape {
    // Abstract method draw to be implemented by subclasses
    public abstract void draw();
}

// Line class
class Line extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a line");
    }
}

// Rectangle class
class Rectangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}

// Cube class
class Cube extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a cube");
    }
}

// Other shapes can be added similarly...

public class ShapeDrawing {
    public static void main(String[] args) {
        // Create instances of Line, Rectangle, Cube, etc.
        Line line = new Line();
        Rectangle rectangle = new Rectangle();
        Cube cube = new Cube();

        // Draw all shapes using polymorphism
        drawAllShapes(line, rectangle, cube);
    }

    // Draw all shapes using polymorphism
    private static void drawAllShapes(Shape... shapes) {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}