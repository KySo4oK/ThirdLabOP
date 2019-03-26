package com.company.POJO;

public class Node<T> {
    private T item;
    private int priority;
    private Node next;

    public Node(T item, int priority, Node next) {
        this.item = item;
        this.priority = priority;
        this.next = next;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
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
