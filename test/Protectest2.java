package test;


import protec.Protectest;

public class Protectest2 extends Protectest {
    Protectest2() {
        super();
    }

    public void printI() {
        setI(200);

    }

    public static void main(String[] args) {
        Protectest2 pro = new Protectest2();
        pro.printI();

    }
}
