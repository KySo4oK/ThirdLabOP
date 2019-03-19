package com.company.POJO;

public class MyQueer {
    private Node<Integer> first;
    private Node<Integer> last;
    private int size = 0;

    public int size() {
        return size;
    }

    public MyQueer() {
        this.first = new Node(null, null, null);
        this.last = new Node(null, null, null);
    }

    public void pushBack(int element) {
        if (size == 0) {
            first.setItem(element);
            last.setItem(element);
        } else {
            if (last.getPrevious() == null) {
                first.setItem(element);
                first.setNext(last);
                last.setPrevious(first);
            } else {
                Node current = new Node(null, first, element);
                first.setPrevious(current);
                first = current;
            }
        }
        size++;
    }

    public void pushFront(int element) {
        if (size == 0) {
            first.setItem(element);
            last.setItem(element);
        } else {
            if (last.getPrevious() == null) {
                last.setItem(element);
                first.setNext(last);
                last.setPrevious(first);
            } else {
                Node current = new Node(last, null, element);
                last.setNext(current);
                last = current;
            }
        }
        size++;
    }

    public int popBack() {
        if (size == 0) {
            System.out.println("Your queer is empty");
            throw new NullPointerException();
        } else {
            int temporary = first.getItem();
            first = first.getNext();
            size--;
            return temporary;
        }

    }

    public int popFront() {
        if (size == 0) {
            System.out.println("Your queer is empty");
            throw new NullPointerException();
        } else {
            int temporary = last.getItem();
            last = last.getPrevious();
            last.setNext(null);
            size--;
            return temporary;
        }

    }

    public void print() {
        Node current = first;
        for (int i = 0; i < size; i++) {
            if (i != size - 1) {
                System.out.print(current.getItem() + ", ");
            } else {
                System.out.print(current.getItem());
            }
            current = current.getNext();
        }
        System.out.println();
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void clear() {
        last.setPrevious(null);
        last.setItem(null);
        first.setItem(null);
        first.setNext(null);
        size = 0;

    }

}
