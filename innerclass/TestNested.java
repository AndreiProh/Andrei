package innerclass;

public class TestNested {
    static int a =5;
    int b = 10;
    public static void setB(int i) {
        a = i;
    }
    public static class TestN2 {
        static class TestN3 {

        }
    }
    public static class TestNested2 {
        public int getA() {
            return a;
        }
        TestNested t = new TestNested();

    }


}
class Nesmain {
    public static void main(String[] args) {
        TestNested.TestN2.TestN3 w = new TestNested.TestN2.TestN3();

    }
}
