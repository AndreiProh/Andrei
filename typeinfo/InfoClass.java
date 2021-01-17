package typeinfo;

import typeinfo.pets.Pet;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class InfoClass {
    public static void main(String[] args) throws ClassNotFoundException {

        Class c = Class.forName("typeinfo.InfoClass");
        Method[] methods = c.getMethods();
        Constructor[] constructors = c.getConstructors();
        Field[] fields = c.getFields();
        Pattern p = Pattern.compile("\\w+\\.");
        for (Method m : methods) {
            System.out.println(p.matcher(m.toString()).replaceAll(""));
        }
        for (Constructor con : constructors) {
            System.out.println(p.matcher(con.toString()).replaceAll(""));
        }
        for (Field f : fields) {
            System.out.println(p.matcher(f.toString()).replaceAll(""));
        }
    }
}
