package net.mindview.util;
import java.util.*;

public class CountingMapData
        extends AbstractMap<Integer,String> {
    private int size;
    private static String[] chars =
            "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z"
                    .split(" ");
    public CountingMapData(int size) {
        if(size < 0) this.size = 0;
        this.size = size;
    }
    private static class Entry
            implements Map.Entry<Integer,String> {
        int index;
        Entry(int index) { this.index = index; }
        public boolean equals(Object o) {
            return Integer.valueOf(index).equals(o);
        }
        public Integer getKey() { return index; }
        public String getValue() {
            return
                    chars[index % chars.length] +
                            Integer.toString(index / chars.length);
        }
        public String setValue(String value) {
            throw new UnsupportedOperationException();
        }
        public int hashCode() {
            return Integer.valueOf(index).hashCode();
        }
    }
    public Set<Map.Entry<Integer,String>> entrySet() {
        // LinkedHashSet retains initialization order:
        Set<Map.Entry<Integer,String>> entries =
                new LinkedHashSet<Map.Entry<Integer,String>>();
        for(int i = 0; i < size; i++)
            entries.add(new Entry(i));
        return entries;
    }
    public static void main(String[] args) {
        System.out.println(new CountingMapData(60));
    }
    static class EntrySet extends AbstractSet<Map.Entry<Integer,String>> {
        private int size;
        EntrySet(int size) {
            if (size < 0)
                this.size = 0;
            else if (size > chars.length)
                this.size = chars.length;
            else
                this.size = size;
        }
        private class Iter implements Iterator<Map.Entry<Integer,String>> {
            Entry entry = new Entry(-1);
            public boolean hasNext() {
                return entry.index < size -1;
            }
            public Map.Entry<Integer, String> next() {
                entry.index++;
                return entry;
            }
        }
        @Override
        public Iterator<Map.Entry<Integer, String>> iterator() {
            return new Iter();
        }
        @Override
        public int size() {
            return size;
        }
    }
    private static Set<Map.Entry<Integer, String>> entries =
            new EntrySet(chars.length);


}
