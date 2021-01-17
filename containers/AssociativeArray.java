package containers;
import net.mindview.util.TextFile;

import java.util.Arrays;

import static net.mindview.util.Print.*;

public class AssociativeArray<K,V> {
    private Object[][] pairs;
    private int index;
    public AssociativeArray(int length) {
        pairs = new Object[length][2];
    }
    public void put(K key, V value) {
        if(index >= pairs.length)
            throw new ArrayIndexOutOfBoundsException();
        for (int i = 0; i < index; i++) {
            if (key.equals(pairs[i][0])) {
                pairs[i][1] = value;
                return;
            }
        }
        pairs[index++] = new Object[]{ key, value };
    }
    @SuppressWarnings("unchecked")
    public V get(K key) {
        for(int i = 0; i < index; i++)
            if(key.equals(pairs[i][0]))
                return (V)pairs[i][1];
        return null; // Did not find key
    }
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < index; i++) {
            result.append(pairs[i][0].toString());
            result.append(" : ");
            result.append(pairs[i][1].toString());
            if(i < index - 1)
                result.append("\n");
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String[] s = TextFile.read("src/containers/test2.txt").split("\\p{Punct}*\\s+\\p{Punct}*");
        AssociativeArray<String,Integer> amount = new AssociativeArray<>(s.length + 1);
        System.out.println(Arrays.toString(s));
        System.out.println(s.length);
        for (String str : s) {
            if (amount.get(str) == null) {
                amount.put(str, 1);
            } else {
                Integer i = amount.get(str);
                amount.put(str, ++i);
            }

        }
        System.out.println(amount);
    }
}
