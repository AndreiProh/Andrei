package containers;

import java.util.*;
import static net.mindview.util.Print.*;
public class ListFeatures {
    static ArrayList<String> getArray(int x) {
        Random r = new Random();
        ArrayList<String> array = new ArrayList<>();
        SimpleCollections s = new SimpleCollections();
        for (int i = 0; i < x; i++) {
            array.add(s.next());
        }
        return array;
    }
    public static void main(String[] args) {
        Random rand = new Random(47);
        List<String> pets = getArray(20);
        print("1: " + pets);
        String h = new String("125");
        pets.add(h); // Automatically resizes
        print("2: " + pets);
        print("3: " + pets.contains(h));
        pets.remove(h); // Remove by object
        String p = pets.get(2);
        print("4: " +  p + " " + pets.indexOf(p));
        String cymric = new String("200");
        print("5: " + pets.indexOf(cymric));
        print("6: " + pets.remove(cymric));
        // Must be the exact object:
        print("7: " + pets.remove(p));
        print("8: " + pets);
        pets.add(3, new String("300")); // Insert at an index
        print("9: " + pets);
        List<String> sub = pets.subList(1, 4);
        print("subList: " + sub);
        print("10: " + pets.containsAll(sub));
        Collections.sort(sub); // In-place sort
        print("sorted subList: " + sub);
        // Order is not important in containsAll():
        print("11: " + pets.containsAll(sub));
        Collections.shuffle(sub, rand); // Mix it up
        print("shuffled subList: " + sub);
        print("12: " + pets.containsAll(sub));
        List<String> copy = new ArrayList<String>(pets);
        sub = Arrays.asList(pets.get(1), pets.get(4));
        print("sub: " + sub);
        copy.retainAll(sub);
        print("13: " + copy);
        copy = new ArrayList<String>(pets); // Get a fresh copy
        copy.remove(2); // Remove by index
        print("14: " + copy);
        copy.removeAll(sub); // Only removes exact objects
        print("15: " + copy);
        copy.set(1, new String("1000")); // Replace an element
        print("16: " + copy);
        copy.addAll(2, sub); // Insert a list in the middle
        print("17: " + copy);
        print("18: " + pets.isEmpty());
        pets.clear(); // Remove all elements
        print("19: " + pets);
        print("20: " + pets.isEmpty());
        pets.addAll(getArray(10));
        print("21: " + pets);
        Object[] o = pets.toArray();
        print("22: " + o[3]);
        String[] pa = pets.toArray(new String[0]);
        print("23: " + pa[3].toString());
    }
}
