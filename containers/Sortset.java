package containers;

import net.mindview.util.CollectionData;
import net.mindview.util.RandomGenerator;

import java.util.*;

public class Sortset<T extends Comparable<T>> extends LinkedList<T>
        implements SortedSet<T>{

    public Sortset(Collection<T> collection) {
        super(collection);
    }
    public Sortset() { super();}

    public Comparator<? super T> comparator() {
        return new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.compareTo(o2);
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        };
    }

    public SortedSet<T> subSet(T fromElement, T toElement) {
        int a = this.indexOf(fromElement);
        int b = this.indexOf(toElement);
        SortedSet<T> newthis = new Sortset<>();
        for (T t : this) {
            if ((indexOf(t) >= a)&(indexOf(t) < b)) {
                newthis.add(t);
            }
        }
        return newthis;
    }

    public SortedSet<T> headSet(T toElement) {
        Collections.sort(this, comparator());
        int i = this.indexOf(toElement);
        SortedSet<T> newthis = new Sortset<>();
        for (T t : this) {
            if (this.indexOf(t) < i) {
                newthis.add(t);
            }
        }
        return newthis;
    }

    public SortedSet<T> tailSet(T fromElement) {
        Collections.sort(this, comparator());
        int i = this.indexOf(fromElement);
        SortedSet<T> newthis = new Sortset<>();
        for (int x = i; x < this.size(); x++) {
            newthis.add(this.get(x));
        }
        return newthis;
    }
    public T first() {
        Collections.sort(this, comparator());
        return this.getFirst();
    }

    public T last() {
        Object[] t = new Object[this.size()];
        this.toArray(t);
        Arrays.sort(t);
        return (T) t[this.size() - 1];
    }

    public static void main(String[] args) {
        SortedSet<Integer> sortset = new Sortset<>(
                new CollectionData<Integer>(new RandomGenerator.Integer(), 15));
        System.out.println(sortset);
        System.out.println(sortset.first());
        System.out.println(sortset.last());
        System.out.println(sortset.tailSet(4868));
        System.out.println(sortset.headSet(4868));
        System.out.println(sortset.subSet(429, 6809));

    }

}
