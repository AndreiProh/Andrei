package strings;

import net.mindview.util.TextFile;

import java.text.Format;
import java.util.Formatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestStr {
    int i;
    long l;
    double dob ;
    float f;
    String s;
     {
        s = "Hello";
    }
    public TestStr(String str) {
        Scanner scn = new Scanner(str);
        i = scn.nextInt();
        l = scn.nextLong();
        dob = scn.nextDouble();
        f = scn.nextFloat();
    }

    public String toString() {
        return String.format("%d %d %f %f\n%s", i, l, dob, f,s);
    }

    public static void main(String[] args) {
        TestStr t = new TestStr("5 2635787667888 23,45 45,33 ");
        System.out.println(t);
    }
}

