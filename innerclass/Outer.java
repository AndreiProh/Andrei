package innerclass;

public class Outer {
    private String str;
    Outer() {
        str = "String";
    }
    class Inner {
        public String toString() {
            System.out.println(str);
            return null;
        }
    }
    public Inner inners() {
        return new Inner();
    }

    public static void main(String[] args) {
        Outer out = new Outer();
        Outer.Inner s = out.inners();
        System.out.println(s.toString());
    }
}
