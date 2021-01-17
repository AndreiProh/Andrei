package containers;

import java.util.*;

public class Statistics {
    public static void main(String[] args) {
        Random rand = new Random();
        Map<Integer,Integer> m = new HashMap<>();
        Set<Integer> it = m.keySet();
        boolean b = true;
        int count = 0;
        while (b) {
            for (int i = 0; i < 6000; i++) {
                int r = rand.nextInt(6);
                Integer freq = m.get(r);
                m.put(r, freq == null ? 1 : freq + 1);
            }
            count++;
            System.out.println(m);
            for (Integer i : it) {
                if (m.get(i) > 1140) {
                    System.out.println(m.get(i) + "  " + count);
                    b = false;
                }
            }
            m.clear();
        }
    }
}

