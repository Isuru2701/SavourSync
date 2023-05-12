package model;

import view.AbstractView;

public class Navigation {
    private static Stack stack = new Stack(10);

    public void navigate(AbstractView view) {
        stack.push(view);
        view.initComponents();
    }

    public AbstractView back() {
        return stack.pop();
    }

}

class Stack {
    private int maxSize;
    private AbstractView[] stackArray;
    private int top;

    public Stack(int s) {
        maxSize = s;
        stackArray = new AbstractView[maxSize];
        top = -1;
    }

    public void push(AbstractView j) {
        stackArray[++top] = j;
    }

    public AbstractView pop() {
        return stackArray[top--];
    }

    public AbstractView peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }


}
