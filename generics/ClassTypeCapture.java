package generics;

import java.awt.image.ImageProducer;
import java.util.HashMap;
import java.util.Map;

class Building {}
class House extends Building {}

public class ClassTypeCapture<T> {
    Map<String,Class<?>> map;
    Class<T> kind;
    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
        map = new HashMap<>();
    }
    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }
    public void addType(String typename, Class<?> kind) {
        this.map.put(typename, kind);
    }
    public Class<?> createNew(String typename) {
        try {
           return  Class.forName(typename);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
            return null;
        }
    }
    public <T> T createNew2(String typename) {
        try {
            Class<?> cls = Class.forName(typename);
            try {
                return (T) cls.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
                return  null;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
        ClassTypeCapture<Building> ctt1 =
                new ClassTypeCapture<Building>(Building.class);
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House()));
        ClassTypeCapture<House> ctt2 =
                new ClassTypeCapture<House>(House.class);
        System.out.println(ctt2.f(new Building()));
        System.out.println(ctt2.f(new House()));
        System.out.println("");
        System.out.println( ctt1.createNew2("java.lang.String").getClass());
        try {
            Class cls = Class.forName("String".getClass().getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
