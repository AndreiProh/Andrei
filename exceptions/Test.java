package exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class Test {
    public Test() throws TestException{
            throw new RuntimeException();
    }
    public static  void g() throws TestException, TestException2, TestException3 {
        throw new TestException3();
    }
    public static void f() throws TestException, TestException2, TestException3 {
        g();
        throw new NullPointerException();
    }
    public static void main(String[] args) {
        Test2 test2 = new Test2();
    }
    }
class Test2{
    public Test2() {
        super();
    }
}
class TestException extends Exception {
    private static Logger logger = Logger.getLogger("LoggingException");
    TestException() {
        StringWriter trace  = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
    TestException(String s) {
        super(s);
    }

}
class LoggingException {
    private static Logger logger = Logger.getLogger("LoggingException");
    static void logException(Exception e) {
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}
class TestException2 extends Exception {}
class TestException3 extends Exception {}