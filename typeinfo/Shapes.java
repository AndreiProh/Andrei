package typeinfo;

import java.util.*;

abstract class Shape {
    void draw() { System.out.println(this + ".draw()"); }
    abstract public String toString();
}

class Circle extends Shape {
    public String toString() { return "Circle"; }
}

class Square extends Shape {
    public String toString() { return "Square"; }
}

class Triangle extends Shape {
    public String toString() { return "Triangle"; }
}
class Rhomboid extends Shape {
    public String toString() { return "Rhomboid";}
}

public class Shapes {
    public static void rotate(Shape shape) {
        if (shape instanceof Circle) {
            return;
        }
        System.out.println(shape.toString() + " rotate");
    }
    public static void main(String[] args) {

    }
}
