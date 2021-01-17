package containers;

public class SList<T> {
    private  int size;
    private Node<T> head;
    private static class Node<T> {
        private T item;
        private Node<T> next;
        Node(T t) {
            item = t;
            next = null;
        }
    }
    void add(T t) {
        SList<T> list = new SList<>();
        Node<T> newNode = new Node<>(t);
        if (head == null) {
            head = newNode;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
    }
      T getNext() {
        Node curNode = head;
        //while (curNode != null) {
          //  System.out.println(curNode.item);
          T t = (T) curNode.item;
            curNode = curNode.next;
            return t;
        //}
    }

    public static void main(String[] args) {
        SList<Integer> list = new SList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.getNext());
        System.out.println(list.getNext());
        System.out.println(list.getNext());
    }

}

