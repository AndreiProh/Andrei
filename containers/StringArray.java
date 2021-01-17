package containers;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
public class StringArray {
    private String[] string;
    private int capacity;
    private int size = 0;
    public StringArray() {
        capacity = 10;
        string = new String[capacity];
    }
    public StringArray(int capacity) {
        if (capacity < 10) {
            this.capacity = 10;
        } else {
            this.capacity = capacity;
            string = new String[capacity];
        }

    }
    public boolean add(String str) {
        if (size == capacity - 2 ) {
            capacity *= 2;
            String[] newString = new String[capacity];
            for (int i = 0;i < size; i++) {
                newString[i] = string[i];
            }
            string = newString;
        }
        string[size] = str;
        size++;
        return true;
    }
    public String get(int index) {
        try {
            return string[index];
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static void main(String[] args) {
        StringArray s = new StringArray();
        List<String> s2 = new ArrayList<>();
        System.out.println(s);
        System.out.println(s.get(50));
        System.out.println(s.get(250));
        long start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            s.add("www");
        }
        System.out.println(System.nanoTime() - start);
        long start2 = System.nanoTime();
        for (int i = 0; i <1000; i++) {
            s2.add("www");
        }
        System.out.println(System.nanoTime() - start2);
    }
}
