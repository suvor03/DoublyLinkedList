package ru.vsu.cs.suvorov_d_a;

import java.util.NoSuchElementException;

public class DoublyLinkedList<T> {

    private DoublyListNode<T> head;
    private int size;

    public DoublyLinkedList() {
        head = null;
    }

    public void addFirst(T x) {
        if(isEmpty())
            head = new DoublyListNode<T>(x);
        else {
            DoublyListNode<T> temp = head;
            head = new DoublyListNode<T>(null, x, temp);
            head.next.prev = head;
        }
        size++;
    }

    public void addLast(T x) {
        if(isEmpty())
            head = new DoublyListNode<T>(x);
        else {
            DoublyListNode<T> temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = new DoublyListNode<T>(temp, x, null);
        }
        size++;
    }

    public void addBefore(T x, T y) {
        if(isEmpty())
            throw new NoSuchElementException("Element " + x.toString() + " not found");

        DoublyListNode<T> current = head;

        while(current != null && !current.data.equals(x))
            current = current.next;

        if(current == null)
            throw new NoSuchElementException("Element " + x.toString() + " not found");

        DoublyListNode<T> newNode = new DoublyListNode<T>(current.prev, y, current);
        if(current.prev != null)
            current.prev.next = newNode;
        else
            head = newNode;
        current.prev = newNode;

        size++;
    }

    public void addAfter(T x, T y) {
        if(isEmpty())
            throw new NoSuchElementException("Element " + x.toString() + " not found");

        DoublyListNode<T> current = head;

        while(current != null && !current.data.equals(x))
            current = current.next;

        if(current == null)
            throw new NoSuchElementException("Element " + x.toString() + " not found");

        DoublyListNode<T> newNode = new DoublyListNode<T>(current, y, current.next);
        if(current.next != null)
            current.next.prev = newNode;
        current.next = newNode;

        size++;
    }

    public void remove(T x) {
        if(isEmpty())
            throw new NoSuchElementException("Element " + x.toString() + " not found");

        if(head.data.equals(x)) {
            head = head.next;
            return;
        }

        DoublyListNode<T> current = head;

        while(current != null && !current.data.equals(x))
            current = current.next;

        if(current == null)
            throw new NoSuchElementException("Element " + x.toString() + " not found");

        if(current.next != null)
            current.next.prev = current.prev;

        current.prev.next = current.next;

        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        DoublyListNode<T> temp = head;
        StringBuilder builder = new StringBuilder("[");

        while(temp != null) {
            builder.append(temp.data).append(",");
            temp = temp.next;
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }
}