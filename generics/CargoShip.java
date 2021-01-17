package generics;

import net.mindview.util.Generator;

import java.util.ArrayList;
import java.util.Random;

class Container {
    private final int id;
    private String description;
    private double price;
    public Container(int id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
        System.out.println(toString());
    }
    public String toString() {
        return id + ": " + description + ", price: $" + price;
    }
    public static Generator<Container> generator =
            new Generator<Container>() {
                private Random rand = new Random(47);
                @Override
                public Container next() {
                    return new Container(rand.nextInt(1000), "Test",
                            Math.round(rand.nextDouble() * 1000.0) + 0.99);
                }
            };

}
class Row extends ArrayList<Container> {
    public Row(int nContainers) {
        Generators.fill(this, Container.generator, nContainers);
    }
}
class Column extends ArrayList<Row> {
    public Column(int nRow, int nContainers) {
        for (int i = 0; i < nRow; i++) {
            add(new Row(nContainers));
        }
    }
}


public class CargoShip extends ArrayList<Column> {
    public CargoShip(int nColumn, int nRow, int nContainers) {
        for (int i = 0; i < nColumn; i++) {
            add(new Column(nRow, nContainers));
        }
    }

    public static void main(String[] args) {
        System.out.println(new CargoShip(14, 5, 10));
    }
}
