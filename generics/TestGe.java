package generics;

import javax.management.MBeanAttributeInfo;
import java.util.Arrays;
import java.util.List;

interface First {}
interface Second {}

class FirSec implements First, Second {}
class Fruit {}
class Apple extends Fruit {}
class Johnatan extends Apple {}
class Orange extends Fruit {}
class Generic1<T> {
    public T item;
    public void set(T t) {
        this.item = t;
    }
}
class Generic2<T> {
    T t;
    public T get() {
        return t;
    }
}
public class TestGe {
    public <T> void testG(Generic1<? super T> generic1) {

    }
    public static void main(String[] args) {

    }
}
