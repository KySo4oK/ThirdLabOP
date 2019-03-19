package com.company.POJO;

public class Node<T> {
    private Node<T> previous;
    private Node<T> next;
    private T item;

    public Node(Node previous, Node next, T item) {
        this.previous = previous;
        this.next = next;
        this.item = item;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
