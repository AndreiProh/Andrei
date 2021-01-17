package containers;
import java.util.*;
import net.mindview.util.*;

public class SlowMap2<K,V> extends AbstractMap<K,V>  {
    private List<Map.Entry<K,V>> keysValues = new ArrayList<>();
    public V put(K key, V value) {
        V oldValue = get(key);// The old value or null
        MapEntry<K,V> kv = new MapEntry<>(key,value);
        Iterator<Map.Entry<K,V>> it = keysValues.iterator();
        if (!keysValues.contains(kv)) {
            while (it.hasNext()) {
                Map.Entry<K,V> me = it.next();
                if (me.getKey() == key) {
                    int i =keysValues.indexOf(me);
                    keysValues.set(i,kv);
                } else {
                    keysValues.add(kv);
                }
            }
        }
        return oldValue;
    }
    public V get(Object key) { // key is type Object, not K
        Iterator<Map.Entry<K,V>> iterator = keysValues.iterator();
        while (iterator.hasNext()) {
            Map.Entry<K,V> me2 = iterator.next();
            if (me2.getKey() == key) {
                return me2.getValue();
            }
        }
        return null;
    }
    public Set<Map.Entry<K,V>> entrySet() {
        Set<Map.Entry<K,V>> set= new HashSet<Map.Entry<K,V>>();
        for (Map.Entry<K,V> m : keysValues) {
            set.add(m);
        }
        return set;
    }
    public void clear() {
        keysValues.removeAll(keysValues);
    }
    public int size() {
        return keysValues.size();
    }
    public String toString() {
        String str = "";
        for (Map.Entry<K,V> m : keysValues) {
            str = str + m.getKey() + ":" + m.getValue() + " ,";
        }
        return str;
    }
    public static void main(String[] args) {
        SlowMap2<Integer, Integer> sl = new SlowMap2<>();
        sl.put(1,2);
        sl.put(3,4);
        sl.put(5,6);
        System.out.println(sl);
        System.out.println(sl.isEmpty());
    }
}
