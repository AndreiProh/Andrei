package generics;

public interface Geninterface {
    public void method1();
    public void method2();
}
class Genable implements Geninterface {

    @Override
    public void method1() {
        System.out.println("method1");
    }

    @Override
    public void method2() {
        System.out.println("method2");
    }
    public void method3() {
        System.out.println("method3");
    }
}
class Testgen {
     public static <T extends Geninterface> void test(T t) {
         System.out.println("test");
         t.method1();
         t.method2();
     }

    public static void main(String[] args) {
        Geninterface gi = new Genable();
        Testgen.test(gi);
    }
}
