package innerclass;

public class Test {
    public class Inner {
        
    }
    public Inner getInner() {
        return new Inner();
    }
}
class Instance{
    Test.Inner inner = new Test().new Inner();
    Test test = new Test();
    Test.Inner inn = test.new Inner();
    Test.Inner inn2 = test.getInner();
}