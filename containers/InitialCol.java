package containers;

import net.mindview.util.TextFile;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InitialCol extends AbstractList<String> {
    String s;
    private static String[] str;
    public InitialCol(String s) {
        this.s = s;
        str = TextFile.read(s).split("\\W+");
    }
    private static List<String> list = new ArrayList<>();
    public static List<String> make() {
        for (int i = 0;  i < str.length; i++) {
            list.add(str[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        InitialCol in = new InitialCol("src/containers/Command.java");
        List<String> strings = InitialCol.make();
        System.out.println(strings);
    }

    @Override
    public String get(int index) {
        return str[index];
    }

    @Override
    public int size() {
        return str.length;
    }
}
