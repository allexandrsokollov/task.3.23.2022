package vsu.cs.sokolov.entities;

import java.util.Comparator;

public class MyPriorityQueue<T> {

    private final Comparator<T> comparator;
    private Node head;
    private int amountOfElems;

    public MyPriorityQueue(Comparator<T> comparator) {
        this.comparator = comparator;
        head = null;
        amountOfElems = 0;
    }

    public void add(T value) {
        if (head == null) {
            head = new Node(value);
            head.next = null;

        } else {
            Node newNode = new Node(value);
            Node iter = head;

            if (comparator.compare(newNode.value, head.value) > 0) {
                Node temp = new Node(iter);
                head = newNode;
                head.setNext(temp);

            } else {
                while (iter.next != null && comparator.compare(newNode.value, iter.next.value) < 0) {
                        iter = iter.next;
                }

                Node temp = null;
                if (iter.next != null) {
                    temp = new Node(iter.next);
                }
                iter.setNext(newNode);
                iter.getNext().setNext(temp);
            }
        }
        amountOfElems++;
    }

    public T extract() {
        Node toReturn = new Node(head);
        head = head.next;
        return toReturn.getValue();
    }
    public Node getHead() {
        return head;
    }

    public int getAmountOfElems() {
        return amountOfElems;
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
