package generics;
class FixedSizeStack<T> {
    private int index = 0;
    private Object[] storage;
    public FixedSizeStack(int size) {
        storage = new Object[size];
    }
    public void push(T item) { storage[index++] = item; }
    @SuppressWarnings("unchecked")
    public T pop() { return (T)storage[--index]; }
}

public class GenericCast {
    public static final int SIZE = 10;
    public static void main(String[] args) {
        FixedSizeStack<String> strings =
                new FixedSizeStack<String>(SIZE);
        for(String s : "A B C D E F G H I J".split(" "))
            strings.push(s);
        for(int i = 0; i < SIZE; i++) {
            String s = strings.pop();
            System.out.print(s + " ");
        }
    }

}
class Car <T> {
    T t;
    public Car() {}
    public Car (T t) {
        this.t = t;
    }
    public T getT() {
        return t;
    }
}
class Lada extends Car<Lada> {
    public Lada() {
        super();
    }

    public Lada(Lada lada) {
        super(lada);
    }

    public static void main(String[] args) {
        Lada l = new Lada();
        Lada l2 = new Lada(l);
        System.out.println(l2.getT().getClass());
    }
}
