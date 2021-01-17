package protec;

import innerclass.Animal;
import test.Horse;

public class TestInner extends Horse {
    public static void main(String[] args) {
        Horse h = new Horse();
        Animal a = new Horse().animal();
        a.eat();
    }
}
