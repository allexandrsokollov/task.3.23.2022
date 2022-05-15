package vsu.cs.sokolov.entities;

import java.util.Comparator;

public class MyPriorityQueue<T>{

    private final Comparator<T> comparator;
    private Node head;
    private Node tail;
    private int amountOfNodes;
    public MyPriorityQueue(Comparator<T> comparator) {
        this.comparator = comparator;
        head = null;
        tail = null;
        amountOfNodes = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(T value) {
        if (head == null) {
            head = new Node(value);
            tail = head;
            head.next = null;

        } else if (comparator.compare(tail.value, value) >= 0) {
            Node node = new Node(value);
            tail.setNext(node);
            tail = tail.next;
            tail.setNext(null);

        } else {
            insertNode(new Node(value));
        }
        amountOfNodes++;
    }

    private void insertNode(Node node) {
        Node iter = head;

        if (comparator.compare(head.value, node.value) < 0) {
            node.setNext(head);
            head = node;
        } else {

            while (iter.next != null && comparator.compare(iter.next.value, node.value) >= 0) {
                iter = iter.next;
            }

            node.setNext(iter.next);
            iter.setNext(node);
        }
    }
    public T extract() {
        Node toReturn = new Node(head);
        head = head.next;
        amountOfNodes--;
        return toReturn.getValue();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node iter = head;
        while (iter != null) {
            sb.append(iter).append("\n");
            iter = iter.next;
        }
        return sb.toString();
    }

    class Node{
        T value;
        Node next;

        public Node(T value) {
            this.value = value;
            next = null;
        }

        public Node (Node node) {
            this.next = node.getNext();
            this.value = node.getValue();
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }

        public Node getNext() {
            return next;
        }
    }
}
