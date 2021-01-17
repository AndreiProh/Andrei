package io;
import net.mindview.util.TextFile;

import java.util.regex.*;
import java.io.*;
import java.util.*;

public class DirList {
    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if(args.length == 0)
            list = path.list();
        else
            list = path.list(new DirFilter("[TestIO]"));
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for(String dirItem : list)
            System.out.println(dirItem);
    }
}

class DirFilter implements FilenameFilter {
    private Pattern pattern;
    public DirFilter(String regex) {
        pattern = Pattern.compile(regex);
    }
    public boolean accept(File dir, String name) {
        String s = TextFile.read(name);
        System.out.println(s);
        System.out.println(pattern.matcher(s).find());
        return pattern.matcher(s).find();
    }
}
