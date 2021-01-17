package containers;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class CollectionSequence implements Collection {
    public Gerbil[] gerbils = new Gerbil[]{new Gerbil(1), new Gerbil(2),
            new Gerbil(3), new Gerbil(4), new Gerbil(5)};

    public CollectionSequence() {
        gerbils = new Gerbil[]{new Gerbil(1), new Gerbil(2),
                new Gerbil(3), new Gerbil(4), new Gerbil(5)};
    }

    @Override
    public int size() {
        return gerbils.length;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int index = 0;

            public boolean hasNext() {
                return index < gerbils.length;
            }

            public Gerbil next() {
                return gerbils[index++];
            }
        };
    }


    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
class InterfaceVsIterator {
    public static void display (Collection<Gerbil> c) {
        for (Gerbil g : c) {
            System.out.println(g);
        }
    }

    public static void main(String[] args) {
        for (Map.Entry entry : System.getenv().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}