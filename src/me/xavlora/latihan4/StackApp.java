package me.xavlora.latihan4;

class StackX1 {
    private int maxSize;
    private long[] stackArray;
    public static int top;

    public StackX1(int s) {
        maxSize = s;
        stackArray = new long[maxSize];
        top = -1;
    }

    public void push (long j) {
        stackArray[++top] = j;
    }

    public long pop() {
        return stackArray[top--];
    }

    public long peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize-1);
    }
}

public class StackApp {
    public static void main(String[] args) {
        StackX1 theStack = new StackX1(10);
        theStack.push(20);
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);

        while(!theStack.isEmpty()) {
            long value = theStack.pop();
            System.out.print(value + "\n");
        }

        System.out.println("");
    }
}
