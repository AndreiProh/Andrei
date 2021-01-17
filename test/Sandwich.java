package test;

import static net.mindview.util.Print.*;

class Meal {
    Meal() { print("Meal()"); }
}

class Bread {
    Bread() { print("Bread()"); }
}

class Cheese {
    Cheese() { print("Cheese()"); }
}

class Lettuce {
    Lettuce() { print("Lettuce()"); }
}

class Lunch extends Meal {
    Lunch() { print("Lunch()"); }
}

class PortableLunch extends Lunch {
    PortableLunch() { print("PortableLunch()");}
}

public class Sandwich extends PortableLunch implements FastFood  {
    private Bread b = new Bread();
    private Cheese c = new Cheese();
    private Lettuce l = new Lettuce();

    public Sandwich() {
        print("Sandwich()");
    }

    public Sandwich make(Bread b, Cheese c, Lettuce l) {
        return new Sandwich();
    }


    public static void main(String[] args) {
        new Sandwich();
    }
}

interface FastFood {
    Sandwich make(Bread b, Cheese c, Lettuce l);
}

