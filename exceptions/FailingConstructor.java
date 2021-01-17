package exceptions;

public class FailingConstructor {
    int t[] = new int[10];
    Failing f ;
    public FailingConstructor(int i) throws ArrayIndexOutOfBoundsException {
        t[i] = 10;
        f = new Failing();
    }
     void dispose() {
        System.out.println("dispose FailingConstructor");
    }

    public static void main(String[] args) {
        try {
            FailingConstructor fc = new FailingConstructor(1);
          try {
            System.out.println(fc);
          } finally {
            fc.dispose();
         }
         } catch (Exception e) {
            System.out.println(e);
        }
    }

}
class Failing {
    public void dispose() {
        System.out.println("dispose Failing");
    }
}
