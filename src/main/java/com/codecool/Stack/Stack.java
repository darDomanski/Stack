package com.codecool.Stack;

import com.codecool.Stack.Exceptions.StackOverflow;
import com.codecool.Stack.Exceptions.StackUnderflow;

public class Stack<T> {

    private Node<T> top;
    private int capacity;
    private int length;

    public Stack(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Stack's capacity must be at least 1 and positive!");
        this.capacity = capacity;
        this.length = 0;
    }

    public void push(T data) {
        if (data == null) throw new IllegalArgumentException("Cant push null to stack!");
        if (length >= capacity) throw new StackOverflow("Stack is already full, can't push any more data!");

        Node<T> current = top;
        Node<T> newNode = new Node<>(data);

        if (current == null) {
            top = newNode;
        } else {
            newNode.setNext(top);
            top = newNode;
        }
        length++;
    }

    public T peek() {
        if (top == null) throw new StackUnderflow("Stack is already empty, cant get any data!");
        return top.getData();
    }

    public T pop() {
        if (top == null) throw new StackUnderflow("Stack is already empty, can't pop any data!");

        Node<T> dataToRemove = top;
        top = top.getNext();
        return dataToRemove.getData();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getFreePlaces() {
        return capacity - length;
    }

    @Override
    public String toString() {
        Node<T> current = top;
        String stackToString = "";

        while (current.getNext() != null) {
            stackToString += " " + current.getData().toString();
            current = current.getNext();
        }
        stackToString += " " + current.getData().toString();
        return stackToString;
    }
}
