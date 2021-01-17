package test;

public class Root {
    Root() {
        System.out.println("Root");
    }
    Component3 component3;
    Component2 component2;
    Component1 component1;
}
class Component1 {
    Component1() {
        System.out.println("Component1");
    }
}
class Component2 {
    Component2() {
        System.out.println("Component2");
    }
}
class Component3 {
    Component3() {
        System.out.println("Component3");
    }
}
class Stem extends Root {
    Stem() {
        System.out.println("stem");
    }
    Component3 component3;
    Component2 component2;
    Component1 component1;
}
