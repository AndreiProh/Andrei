package containers;

import net.mindview.util.TextFile;

import java.util.*;

public class UniqueWords {
    public static void main(String[] args) {
        List <String> words = new ArrayList<>(new TextFile
                ("src/containers/test.txt", "\\W+"));
        Set<String> ch = new HashSet<>();
        Map<String, Integer> words2 = new LinkedHashMap<>();
        Collections.addAll(ch, "A E I O U".split(" "));
        System.out.println(words);
        Iterator<String> it = words.iterator();
        Set<String> words4 = new HashSet<>();
        Set<Words> words3 = new LinkedHashSet<>();
        while (it.hasNext()) {
            String s = it.next();
            if (words4.add(s)) {
                words3.add(new Words(s));
            }

        }
        System.out.println(words4);
        System.out.println(words3);
    }
}
class Words {
    String name;
    int count = 0;
    Words(String name) {
        this.name = name;
        count++;
    }
    public String toString() {
        return name + " "+ count;
    }

}
