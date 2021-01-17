package net.mindview.util;

public class SkipGenerator {
    public static class
    Boolean implements Generator<java.lang.Boolean> {
        private boolean value = false;
        public java.lang.Boolean next() {
            value = !value; // Just flips back and forth
            return value;
        }
    }
    public static class
    Byte implements Generator<java.lang.Byte> {
        private byte value = 0;
        private byte b;
        public Byte(byte b) {this.b = b;}
        public java.lang.Byte next() { return value += b; }
    }
    static char[] chars = ("abcdefghijklmnopqrstuvwxyz" +
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
    public static class
    Character implements Generator<java.lang.Character> {
        int index = -1;
        int i;
        public Character(int i) {this.i = i;}
        public java.lang.Character next() {
            index = (index + 1 + i) % chars.length;
            return chars[index];
        }
    }
    public static class
    String implements Generator<java.lang.String> {
        private int length = 7;
        Generator<java.lang.Character> cg = new CountingGenerator.Character();
        public String() {}
        public String(int length) { this.length = length; }
        public java.lang.String next() {
            char[] buf = new char[length];
            for(int i = 0; i < length; i++)
                buf[i] = cg.next();
            return new java.lang.String(buf);
        }
    }
    public static class
    Short implements Generator<java.lang.Short> {
        private short value = 0;
        private int i;
        public Short(int i) {this.i = i;}
        public java.lang.Short next() { return value += i; }
    }
    public static class
    Integer implements Generator<java.lang.Integer> {
        private int value = 0;
        private int i;
        public Integer(int i) { this.i = i;}
        public java.lang.Integer next() { return value += i; }
    }
    public static class
    Long implements Generator<java.lang.Long> {
        private long value = 0;
        private int i;
        public Long(int i) {this.i = i;}
        public java.lang.Long next() { return value += i; }
    }
    public static class
    Float implements Generator<java.lang.Float> {
        private float value = 0;
        private float i;
        public Float(float i) { this.i = i;}
        public java.lang.Float next() {
            float result = value;
            value += i;
            return result;
        }
    }
    public static class
    Double implements Generator<java.lang.Double> {
        private double value = 0.0;
        public java.lang.Double next() {
            double result = value;
            value += 1.0;
            return result;
        }
    }
    public static class
    BerylliumSphere implements Generator<arrays.BerylliumSphere> {
        public arrays.BerylliumSphere next() {
            return new arrays.BerylliumSphere();
        }
    }
}
