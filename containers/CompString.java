package containers;

import net.mindview.util.RandomGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class CompString implements Comparable<CompString> {
    String str1;
    String str2;
    public CompString() {
        str1 = new RandomGenerator.String(6).next();
        str2 = new RandomGenerator.String(6).next();
    }

    @Override
    public int compareTo(@NotNull CompString o) {
        return str1.compareTo(o.str1);
    }
    public String toString() {
        return str1 + " - " + str2;
    }
    public Comparator<CompString> comparator() {
        return new Comparator<CompString>() {
            @Override
            public int compare(CompString o1, CompString o2) {
                return o1.str2.compareTo(o2.str2);
            }

            @Override
            public boolean equals(Object obj) {
                if (this.equals(obj)) {
                    return true;
                }
                return false;
            }
        };
    }

    public static void main(String[] args) {
        CompString[] cs = new CompString[30];
        List<CompString> csList = new ArrayList<>();
        for (int i = 0; i < cs.length; i++) {
            cs[i] = new CompString();
            csList.add(new CompString());
        }
        Arrays.sort(cs, new CompString().comparator());
        Collections.sort(csList, new CompString().comparator());
        System.out.println(Arrays.asList(cs));
        System.out.println(csList);

    }
}
