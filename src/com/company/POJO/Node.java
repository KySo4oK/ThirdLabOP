package com.company.POJO;

public class Node {
    private Object item;
    private int priority;
    private Node next;

    public Node(Object item, int priority, Node next) {
        this.item = item;
        this.priority = priority;
        this.next = next;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
