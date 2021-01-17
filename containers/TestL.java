package containers;

import net.mindview.util.*;

import java.util.*;

public class TestL implements Comparable<TestL>{
    private Integer in;
    public TestL() {
        Random r = new Random();
        in = r.nextInt(100);
    }

    @Override
    public int compareTo(TestL o) {
        return in > o.in ? 1 : in == o.in ? 0 : -1;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.addAll(new CountingIntegerList(30));
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);

    }
}