package generics;
import generics.coffee.*;
import java.util.*;
import net.mindview.util.*;

public class Generators {
    public static <T> Collection<T>
    fill(Collection<T> coll, Generator<T> gen, int n) {
        for(int i = 0; i < n; i++)
            coll.add(gen.next());
        return coll;
    }
    public static <T> List<T> fill(List<T> list, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            list.add(gen.next());
        }
        return list;
    }
    public static <T> Set<T> fill(Set<T> set, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            set.add(gen.next());
        }
        return set;
    }
    public static void main(String[] args) {
        Collection<Coffee> coffee = fill(
                new HashSet<Coffee>(), new CoffeeGenerator(), 4);
        for(Coffee c : coffee)
            System.out.println(c);
        Collection<Integer> fnumbers = fill(
                new ArrayList<Integer>(), new Fibonacci(), 12);
        for(int i : fnumbers)
            System.out.print(i + ", ");
    }
}
