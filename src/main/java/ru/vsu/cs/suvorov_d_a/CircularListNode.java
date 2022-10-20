package ru.vsu.cs.suvorov_d_a;

class CircularListNode<T> {
    T data;
    CircularListNode<T> next;

    public CircularListNode(T data) {
        this.data = data;
    }

    CircularListNode(T data, CircularListNode<T> next) {
        this.data = data;
        this.next = next;
    }
}