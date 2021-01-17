package test;

import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

public class RandomChar  {
    Random rand = new Random(47);
    public double next() {
        return rand.nextDouble();
    }
}
class AdapterRandomChar extends RandomChar implements Readable {
    private int count;
    AdapterRandomChar(int count) {
        this.count = count;
    }
    public int read(CharBuffer cb) {
        if(count-- == 0) {
            return -1;
        }
        String result = Double.toString(next()) + " ";
        cb.append(result);
        return result.length();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(new AdapterRandomChar(5));
        while (s.hasNextDouble()) {
            System.out.println(s.nextDouble() + " ");
        }
    }
}
