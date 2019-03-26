package com.company.POJO;

<<<<<<< Updated upstream
public class Node {
    private Object item;
    private int priority;
    private Node next;

    public Node(Object item, int priority, Node next) {
=======
public class Node<T> {
    private T item;
    private int priority;
    private Node next;

    public Node(T item, int priority, Node next) {
>>>>>>> Stashed changes
        this.item = item;
        this.priority = priority;
        this.next = next;
    }

<<<<<<< Updated upstream
    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
=======
    public T getItem() {
        return item;
    }

    public void setItem(T item) {
>>>>>>> Stashed changes
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
