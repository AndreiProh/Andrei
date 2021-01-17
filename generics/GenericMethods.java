package generics;
public class GenericMethods {
    public <T, K, R> void f(T x, K k, R r, String s) {
        System.out.print(x.getClass().getName());
        System.out.print(k.getClass().getName());
        System.out.print(r.getClass().getName());
        System.out.println(s);
    }
    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("", 1, 1.0, "hello");
        gm.f(1.0F, "hello", gm, "hello");
    }
}
