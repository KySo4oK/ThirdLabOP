package com.company.POJO;

public class Node<T> {
    Node<T> next;
    T element;
    int priority;

    public Node(Node<T> next, T element, int priority) {
        this.next = next;
        this.element = element;
        this.priority = priority;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}