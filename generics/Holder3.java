package generics;

import typeinfo.pets.Dog;
import typeinfo.pets.Pet;

import java.util.ArrayList;
import java.util.List;

public class Holder3<T> {
    private T a;
    public Holder3(T a) { this.a = a; }
    public Holder3(){}
    public void set(T a) { this.a = a; }
    public T get() { return a; }
}
class Wildcards {
    static void rawArgs(Holder3 holder, Object arg) {
        holder.set(arg);
        holder.set(new Wildcards());
    }
    static <T> void f1(Holder3<T> holder) {
        T t = holder.get();
        System.out.println(t.getClass().getSimpleName());
    }
    static <T> void f3(Holder3<List<?>> holder) {
        holder.set(new ArrayList<T>());
        System.out.println(holder.get().getClass().getSimpleName());
    }

    public static void main(String[] args) {
        Holder3<Integer> holder = new Holder3<>();

    }

}
