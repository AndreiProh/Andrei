package io;

import java.util.regex.Pattern;

public class TestIO {
    public static void main(String[] args) {
        String s = "dfgdg sfkjekfh  dfgdfj = ";
        Pattern pattern = Pattern.compile("\\d+");
        System.out.println(pattern.matcher(s).find());
    }
}
