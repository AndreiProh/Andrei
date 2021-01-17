package innerclass;

import java.util.ArrayList;
import java.util.Iterator;

interface Selector<T> {
    boolean end();
    Object current();
    void next();
}

public class Sequence<T> {
    private ArrayList<T> items;
    private int next = 0;
    public Sequence() { items = new ArrayList<T>(); }
    public void add(T t) {
        items.add(t);
    }
    private class SequenceSelector<T> implements Selector<T> {
        private int i = 0;
        public boolean end() { return i == items.size(); }
        public Object current() { return items.get(i); }
        public void next() { if(i < items.size()) i++; }
        public Sequence getSequence() {
            return Sequence.this;
        }
    }
    public Selector selector() {
        return new SequenceSelector();
    }
    private class Teststring {
        String string = "String";
        public String toString() {
            return string;
        }
    }
    public Teststring selector2() {
        return new Teststring();
    }
    public static void main(String[] args) {
        Sequence<String> sequence = new Sequence<>();
        Sequence.Teststring t = sequence.selector2();
        for(int i = 0; i < 10; i++) {
            sequence.add(t.toString());
        }
        Iterator it = sequence.items.iterator();
        //Selector selector = sequence.selector();
        while (it.hasNext()) {
            System.out.print(it.next());
        }
    }
}
