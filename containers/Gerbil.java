package containers;

import java.util.ArrayList;
import java.util.Iterator;

public class Gerbil {
    int gerbilNumber;
    public Gerbil( int gerbilNumber) {
        this.gerbilNumber = gerbilNumber;
    }
    public void hop() {
        System.out.println("gerbilNumber" + gerbilNumber);
    }
    public String toString() {return "gerbilNumber " + gerbilNumber; }

    public static void main(String[] args) {
        ArrayList<Gerbil> gerbil = new ArrayList<Gerbil>();
        for (int i = 0; i < 10; i++) {
            gerbil.add(new Gerbil(i * 10));
        }
        Iterator<Gerbil> ge = gerbil.iterator();
        while (ge.hasNext()) {
            ge.next().hop();
            ge.remove();
        }
    }
}
