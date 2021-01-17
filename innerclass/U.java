package innerclass;

interface U {
    void one();
    void two();
    void three();
}
class A {
    U makeU() {
        return new U() {
            public void one() {
                System.out.print("one");
            }
            public void two() {
                System.out.print("two");
            }
            public void three() {
                System.out.println("three");
            }
        };
    }
}
class B {
    U []u = new U[10];
    int x = 0;
    void setU(U i) {
        u[x] = i;
        x++;
    }
    void resetU(int i) {
        u[i] = null;
    }
    void selectorU() {
        for (U x :u) {
            x.one();
            x.two();
            x.three();
        }
    }

    public static void main(String[] args) {
        B b = new B();
        A a = new A();
        for (U x : b.u) {
            b.setU(a.makeU());
        }
        b.resetU(1);
        b.resetU(4);
        b.resetU(5);
        b.selectorU();

    }
}