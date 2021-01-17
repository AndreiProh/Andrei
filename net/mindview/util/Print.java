package net.mindview.util;

import java.io.*;

public class Print {
    public static void print(Object obj) {
        System.out.println(obj);
    }

    public static void print() {
        System.out.println();
    }

    public static void printnb(Object obj) {
        System.out.print(obj);
    }

    public static PrintStream printf(String format, Object... args) {
        return System.out.printf(format, args);
    }

    public static int[] range(int n) {
        int result[] = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = i;
        }
        return result;
    }

    public static int[] range(int start, int end) {
        int sz = end - start;
        int result[] = new int[sz];
        for (int i = 0; i < sz; i++) {
            result[i] = start + i;
        }
        return result;
    }
    public static int[] range(int start, int end, int step) {
        int sz = (end - start) / step;
        int result[] = new int[sz];
        for(int i = 0; i < sz; i++ ) {
            result[i] = start + (i * step);
        }
        return result;
}


}

