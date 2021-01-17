package strings;

import java.util.ArrayList;
import java.util.Arrays;

public class SplitDemo {
    public static void main(String[] args) {
        String input = "This!!unusual use!!of exclamation!!points";
        System.out.println(Arrays.toString(input.split("!!")));
    }
}
