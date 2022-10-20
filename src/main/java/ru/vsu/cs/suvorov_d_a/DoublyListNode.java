package ru.vsu.cs.suvorov_d_a;

class DoublyListNode<T> {
    T data;
    DoublyListNode<T> next;
    DoublyListNode<T> prev;

    DoublyListNode(T data) {
        this(null, data, null);
    }

    DoublyListNode(DoublyListNode<T> prev, T data, DoublyListNode<T> next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}