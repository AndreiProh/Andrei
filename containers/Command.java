package containers;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Command {
    String str;
    public void operation() {
        System.out.print(str + " ");
    }
    Command(String str) {
        this.str = str;
    }
}
class Fill {
    public Queue<Command> toFill(int x) {
        Queue<Command> queue = new LinkedList<>();
        for (int i = 0; i < x; i ++) {
            queue.offer(new Command("Command " + i));
        }
        System.out.println(queue);
        return queue;
    }
}
class TestQue {
    public static void printQue(Queue<Command> c) {
        while (c.peek() != null) {
            c.poll().operation();
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Double> priorityQueue = new PriorityQueue<>();
        Random rand = new Random();
        for (int i = 0; i < 10 ; i++) {
            priorityQueue.offer(rand.nextDouble());
        }
        for (Double d : priorityQueue) {
            System.out.println(d + " ");
        }
        Simple simple = new Simple();
        Simple simple1 = new Simple();
        PriorityQueue<Simple> pr = new PriorityQueue<>();
    }
}
class Simple {

}