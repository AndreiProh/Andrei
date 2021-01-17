package innerclass;

public class TestInner {
    private int i = 3;
    TestInner iner = new TestInner();
    TestInner2 in = new TestInner2();

    public static void main(String[] args) {
        TestInner iner = new TestInner();
        TestInner2 inner2 = iner.new TestInner2();
    }

    private void testInner() {
        System.out.println("Test inner i = " + i);
    }
    public void testInner2(int a) {
        TestInner2 inner2 = new TestInner2();
        inner2.setI(a);
    }
    public class TestInner2 {
        private int g =45;
        public void setI(int a) {
            i = a;
            testInner();
        }
        public int getI() {
            return i;
        }
    }

}
class TestInner3 {



}
