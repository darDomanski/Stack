package com.codecool.Stack;

import com.codecool.Stack.Exceptions.StackOverflow;
import com.codecool.Stack.Exceptions.StackUnderflow;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StackTest {

    @Test
    public void testCreateStackWith0Capacity() {
        assertThrows(IllegalArgumentException.class, () -> new Stack<String>(0));
    }

    @Test
    public void testCreateStackWithNegativeCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new Stack<String>(-100));
    }

    @Test
    public void testPushNullToStack() {
        Stack<String> stack = new Stack(1);

        assertThrows(IllegalArgumentException.class, () -> stack.push(null));
    }

    @Test
    public void testAddObjectToEmptyList() {
        Stack<String> stack = new Stack(1);
        stack.push("dog");
        String stackToString = stack.toString();

        String expected = " dog";

        assertEquals(expected, stackToString);
    }

    @Test
    public void testAddObjectToStackContainingObjects() {
        Stack<String> testStack = createTestStack();
        testStack.push("bird");
        String stackToString = testStack.toString();

        String expected = " bird cow cat dog";

        assertEquals(expected, stackToString);
    }

    @Test
    public void testAddObjectToFullStack() {
        Stack<String> testStack = createTestStack();
        testStack.push("bird");

        assertThrows(StackOverflow.class, () -> testStack.push("pig"));
    }

    @Test
    public void testPeekingObjectFromStackContainingObjects() {
        Stack<String> testStack = createTestStack();
        String peekedObject = testStack.peek();

        String expected = "cow";

        assertEquals(expected, peekedObject);
    }

    @Test
    public void testPeekFromEmptyStack() {
        Stack<String> testStack = new Stack<>(1);

        assertThrows(StackUnderflow.class, () -> testStack.peek());
    }

    @Test
    public void testPopDataFromStack() {
        Stack<String> testStack = createTestStack();
        String popedObject = testStack.pop();
        String stackToString = testStack.toString();

        String expected = " cat dog";
        assertEquals(expected, stackToString);

        String expectedPoped = "cow";
        assertEquals(expectedPoped, popedObject);
    }

    @Test
    public void testGetCapacity() {
        Stack<String> testStack = new Stack<>(3);
        int stackCapacity = testStack.getCapacity();

        int expected = 3;

        assertEquals(expected, stackCapacity);
    }

    @Test
    public void testGetFreePlaces() {
        Stack<String> testStack = createTestStack();
        int freePlaces = testStack.getFreePlaces();

        int expected = 1;

        assertEquals(expected, freePlaces);
    }


    private Stack<String> createTestStack() {
        Stack<String> testStack = new Stack<>(4);
        testStack.push("dog");
        testStack.push("cat");
        testStack.push("cow");
        return testStack;
    }

}