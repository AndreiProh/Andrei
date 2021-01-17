package strings;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.*;
import static net.mindview.util.Print.*;

public class Groups {
    static public final String POEM =
            "Twas brillig, and the slithy toves\n" +
                    "Did gyre and gimble in the wabe.\n" +
                    "All mimsy were the borogoves,\n" +
                    "And the mome raths outgrabe.\n\n" +
                    "Beware the Jabberwock, my son,\n" +
                    "The jaws that bite, the claws that catch.\n" +
                    "Beware the Jubjub bird, and shun\n" +
                    "The frumious Bandersnatch.";
    public static void main(String[] args) {
        Matcher m = Pattern.compile("\\p{Lower}\\w+")
                        .matcher(POEM);
        Set<String> s = new LinkedHashSet<>();
        while(m.find()) {
            for(int j = 0; j <= m.groupCount(); j++)
                printnb("[" + m.group(j) + "]");
            s.add(m.group());
            print();
        }
        System.out.println(s.size());
    }
}
