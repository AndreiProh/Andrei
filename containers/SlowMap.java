package containers;
import java.util.*;
import net.mindview.util.*;

public class SlowMap<K,V> extends AbstractMap<K,V>  {
    private List<K> keys = new ArrayList<K>();
    private List<V> values = new ArrayList<V>();
    public V put(K key, V value) {
        V oldValue = get(key); // The old value or null
        if(!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else
            values.set(keys.indexOf(key), value);
        return oldValue;
    }
    public V get(Object key) { // key is type Object, not K
        if(!keys.contains(key))
            return null;
        return values.get(keys.indexOf(key));
    }
    public Set<Map.Entry<K,V>> entrySet() {
        Set<Map.Entry<K,V>> set= new HashSet<Map.Entry<K,V>>();
        Iterator<K> ki = keys.iterator();
        Iterator<V> vi = values.iterator();
        while(ki.hasNext())
            set.add(new MapEntry<K,V>(ki.next(), vi.next()));
        return set;
    }
    public void clear() {
        keys.removeAll(keys);
        values.removeAll(values);
    }
    public static void main(String[] args) {
        String[] s = TextFile.read("src/containers/test2.txt").split("\\p{Punct}*\\s+\\p{Punct}*");
        SlowMap<String, Integer> amount = new SlowMap<>();
        System.out.println(Arrays.toString(s));
        for (String str : s) {
            if (amount.get(str) == null) {
                amount.put(str, 1);
            } else {
                Integer i  = amount.get(str);
                amount.put(str, ++i);
            }
        }
        System.out.println(amount);
    }
}
