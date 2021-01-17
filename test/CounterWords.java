package test;

import net.mindview.util.TextFile;

import java.io.FileNotFoundException;
import java.util.*;

public class CounterWords {
    public static void main(String[] args)  {
        String s = TextFile.read("src/test.txt");
        String[] words = s.split("\\W+");
        List<String> wordList = new LinkedList<>();
        for (String str : words) {
            wordList.add(str);
        }
        HashMap<String, Integer> wordMap = new HashMap<>();
        for (String str : words) {
            if (wordMap.containsKey(str)) {
                Integer i = wordMap.get(str);
                wordMap.put(str, i + 1);
            } else {
                wordMap.put(str, 1);
            }
        }
        Set<String> wordC = wordMap.keySet();
        for (String str : wordC) {

        }
        System.out.println(wordList);
        System.out.println(wordMap);
    }
}
