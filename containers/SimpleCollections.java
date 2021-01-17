package containers;

import java.util.*;

public class SimpleCollections {
    int count = 0;
    String[] namesHero = new String[] {"bob", "tom", "mike", "nick", "john"};
    String next() {
        if (count == 5)
            count = 0;
        return namesHero[count++];
    }
    public static void main(String[] args) {
        SimpleCollections c = new SimpleCollections();
        String[] str = new String[20];
        List<String> str1 = new ArrayList<>();
        List<String> str2 = new LinkedList<>();
        Set<String> str3 = new HashSet<>();
        Set<String> str4 = new LinkedHashSet<>();
        Set<String> str5 = new TreeSet<>();
        for (int i = 0; i < 20; i++) {
            str[i] = c.next();
            str1.add(c.next());
        }
        System.out.println(str);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str4);
        System.out.println(str5);
    }
}
