package ru.vsu.cs.suvorov_d_a;

public class CircularLinkedList<T> {

    private CircularListNode<T> head;
    private CircularListNode<T> tail;
    private int size;

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addNode(T value) {
        if(isEmpty())
            head = new CircularListNode<T>(value);
        else {
            CircularListNode<T> temp = head;
            tail.next = new CircularListNode<T>(value);

        }
        size++;
        tail = new CircularListNode<T>(value);
        tail.next = head;
    }

    public boolean containsNode(T searchValue) {

        CircularListNode<T> currentNode = head;

        if(head != null) {
            do {
                if(currentNode.data == searchValue) {
                    return true;
                }
                currentNode = currentNode.next;
            } while(currentNode != head);
        }
        return false;
    }

    public void deleteNode(T valueToDelete) {
        CircularListNode<T> currentNode = head;
        if(head == null) {
            return;
        }
        do {
            CircularListNode<T> nextNode = currentNode.next;
            if(nextNode.data == valueToDelete) {
                if (tail == head) {
                    head = null;
                    tail = null;
                } else {
                    currentNode.next = nextNode.next;
                    if(head == nextNode) {
                        head = head.next;
                    }
                    if(tail == nextNode) {
                        tail = currentNode;
                    }
                }
                break;
            }
            currentNode = nextNode;
        } while(currentNode != head);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        CircularListNode<T> temp = head;
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