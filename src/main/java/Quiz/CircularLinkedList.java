package Quiz;

public class CircularLinkedList {
    private static class Node {
        int key;
        Node next;
        Node(int key) {
            this.key = key;
        }
    }
    private Node head;
    private Node tail;
    private int size;
    public CircularLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    public void insert(int key) {
        Node newNode = new Node(key);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
        size++;
    }
    public void delete(int key) {
        Node current = head;
        Node previous = head;
        while (current.key != key) {
            previous = current;
            current = current.next;
        }
        if (current == head) {
            head = head.next;
            tail.next = head;
        } else {
            previous.next = current.next;
            if (current == tail)
                tail = previous;
        }
        size--;
    }
    public void print() {
        Node current = head;
        while (current.next != head) {
            System.out.print(current.key + " ");
            current = current.next;
        }
        System.out.println(current.key);
    }

    public double average() {
        Node current = head;
        int sum = 0;
        while (current.next != head) {
            sum += current.key;
            current = current.next;
        }
        sum += current.key;
        return (double) sum / size;
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        int size = (int) (Math.random() * 10) + 1;
        for (int i = 0; i < size; i++) {
            list.insert((int) (Math.random() * 100));
        }

        list.print();
        System.out.println("Linked List Size: " + list.size);
        System.out.println("Average: " + list.average());

    }
}
