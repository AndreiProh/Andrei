package containers;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        Gerbil gerbil1 = new Gerbil(1);
        Gerbil gerbil2 = new Gerbil(2);
        Gerbil gerbil3 = new Gerbil(3);
        Map<String, Gerbil> map = new HashMap<String, Gerbil>();
        map.put("gerbil1", gerbil1 );
        map.put("gerbil2", gerbil2);
        map.put("gerbil3", gerbil3);
        Map<String,Gerbil> map2 = new LinkedHashMap<>();
    }
}
