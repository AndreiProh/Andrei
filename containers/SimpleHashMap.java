package containers;
import java.util.*;
import net.mindview.util.*;

public class SimpleHashMap<K,V> extends AbstractMap<K,V> {
    // Choose a prime number for the hash table
    // size, to achieve a uniform distribution:
    static final int SIZE = 997;
    int i ;
    // You can't have a physical array of generics,
    // but you can upcast to one:
    @SuppressWarnings("unchecked")
    LinkedList<MapEntry<K,V>>[] buckets =
            new LinkedList[SIZE];
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if(buckets[index] == null)
            buckets[index] = new LinkedList<MapEntry<K,V>>();
        LinkedList<MapEntry<K,V>> bucket = buckets[index];
        MapEntry<K,V> pair = new MapEntry<K,V>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K,V>> it = bucket.listIterator();

        while(it.hasNext()) {
            MapEntry<K,V> iPair = it.next();
            if(iPair.getKey().equals(key)) {
                i++;
                System.out.println("Коллизия" + i);
                oldValue = iPair.getValue();
                it.set(pair); // Replace old with new
                found = true;
                break;
            }
        }
        if(!found)
            buckets[index].add(pair);
        return oldValue;
    }
    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if(buckets[index] == null) return null;
        for(MapEntry<K,V> iPair : buckets[index])
            if(iPair.getKey().equals(key))
                return iPair.getValue();
        return null;
    }
    public Set<Map.Entry<K,V>> entrySet() {
        Set<Map.Entry<K,V>> set= new HashSet<Map.Entry<K,V>>();
        for(LinkedList<MapEntry<K,V>> bucket : buckets) {
            if(bucket == null) continue;
            for(MapEntry<K,V> mpair : bucket)
                set.add(mpair);
        }
        return set;
    }
    public void clear() {
        buckets = new LinkedList[SIZE];
    }
    public V remove(Object k) {
        V oldValue = null;
        int index = Math.abs(k.hashCode()) % SIZE;
        if (buckets[index] == null) {
            return null;
        }
        LinkedList<MapEntry<K,V>> bucket2 = buckets[index];
        ListIterator<MapEntry<K,V>> it = bucket2.listIterator();
        while (it.hasNext()) {
            MapEntry<K,V> iPair = it.next();
            if (iPair.getKey().equals(k)) {
                oldValue = iPair.getValue();
                bucket2.remove(it.nextIndex() - 1);

            }
        }
        return oldValue;

    }
    public int size() {
        return entrySet().size();
    }
    public boolean isEmpty() {
        if (size() == 0)
            return true;
        return false;
    }
    public boolean containsKey(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null)
            return false;
        LinkedList<MapEntry<K,V>> bucket = buckets[index];
        for (MapEntry<K,V> me: bucket) {
            if (me.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }
    public boolean containsValue(Object value) {
        for (LinkedList<MapEntry<K,V>> list : buckets ) {
            for (MapEntry<K,V> mapEntry : list) {
                if (mapEntry.getValue().equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }
    public void putAll(Map<? extends K, ? extends V> m) {
        Set<? extends Entry<? extends K, ? extends V>> set = m.entrySet();
        for (Entry<? extends K, ? extends V> me : set) {
            put(me.getKey(), me.getValue());
        }
    }
    public static void main(String[] args) {
        SimpleHashMap<Integer,String> map = new SimpleHashMap<>();
        map.putAll(new CountingMapData(25));
        map.putAll(new CountingMapData(25));
        System.out.println(map.isEmpty());
        map.clear();
        System.out.println(map.isEmpty());
        map.putAll(new CountingMapData(25));
        System.out.println(map.entrySet());
        map.remove(6);
        System.out.println(map.entrySet());
        System.out.println(map.size());
        System.out.println(map.containsKey(8));
        System.out.println(map.containsKey(6));
        SimpleHashMap<Integer,String> map2 = new SimpleHashMap<>();
        map2.put(35,"WWW");
        map2.put(45,"EEE");
        map.putAll(map2);
        System.out.println(map.entrySet());
    }
}
