package strings;
import java.io.File;
import java.util.Arrays;
import java.util.regex.*;
import net.mindview.util.*;

public class JGrep {
    public static void main(String[] args) throws Exception {
        Pattern p = Pattern.compile("\\b[Ssct]\\w+", Pattern.MULTILINE);
        // Iterate through the lines of the input file:
        int index = 0;
        Matcher m = p.matcher("");
        File[] file = new File("src/strings").listFiles();
        System.out.println(Arrays.toString(file));
        for (File f : file) {
            for (String line : new TextFile(f.toString())) {
                m.reset(line);
                while (m.find())
                    System.out.println(index++ + ": " +
                            m.group() + ": " + m.start());
            }
        }
    }
}
