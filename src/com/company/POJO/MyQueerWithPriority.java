package com.company.POJO;


public class MyQueerWithPriority {
    private Node last;


    private int size = 0;

    public int getSize() {
        return size;
    }

    public MyQueerWithPriority() {
        this.last = null;
    }

    public void push(Object element, int priority) {
        if (last == null) {
            last = new Node(element, priority, null);
        } else {
            boolean mark = false;
            Node current = last;
            Node previous = null;
            Node newElement;
            while (mark == false) {
                if (current.getPriority() > priority) {
                    newElement = new Node(element, priority, current);
                    if (previous != null) {
                        previous.setNext(newElement);
                    } else {
                        last = newElement;
                    }
                    mark = true;
                } else {
                    if (current.getPriority() < priority) {
                        if (current.getNext() == null) {
                            newElement = new Node(element, priority, null);
                            current.setNext(newElement);
                            mark = true;
                        }
                    }
                }
                previous = current;
                current = current.getNext();

            }
        }
        size++;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void clear() {
        this.last = null;
        size = 0;

    }

    public void print() {
        Node current = last;
        System.out.println("Your queer: ");
        for (int i = 0; i < size; i++) {
            if (i != size - 1) {
                System.out.print(current.getItem() + ", ");
            } else {
                System.out.print(current.getItem() + "; ");
            }
            current = current.getNext();

        }
        System.out.println();
    }

    public void printWithPriority() {
        Node current = last;
        System.out.println("Your queer (element, priority): ");
        for (int i = 0; i < size; i++) {
            if (i != size - 1) {
                System.out.print("(" + current.getItem() + ", " + current.getPriority() + "); ");
            } else {
                System.out.print("(" + current.getItem() + ", " + current.getPriority() + "). ");
            }
            current = current.getNext();

        }
        System.out.println();
    }

    public Node pop() {
        Node result = last;
        last = last.getNext();
        size--;
        return result;
    }
}
