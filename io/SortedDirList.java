package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class SortedDirList {
    public String path;
    public File fPath;
    public String[] listF;
    public SortedDirList(String path) {
        this.path = path;
        fPath = new File(path);
    }
    public String[] list1() {
        listF = fPath.list();
        return listF;
    }
    public String[] list1(final String regex) {
        return listF = fPath.list(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
    }

    public static void main(String[] args) {
        SortedDirList sl = new SortedDirList("src/io/");
        for (String s : sl.list1("D.*\\gh.java")) {
            System.out.println(s);
        }
    }

}
