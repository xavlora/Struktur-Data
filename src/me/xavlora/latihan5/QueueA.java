package me.xavlora.latihan5;

public class QueueA {
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;

    //--------------------------------------------------------------
    public QueueA(int s) { // constructor
        maxSize = s + 1; // array is 1 cell larger than requested
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
    }

    //--------------------------------------------------------------
    public void insert(long j) { // put item at rear of queue
        if (rear == maxSize - 1) {
            rear = -1;
        }
        queArray[++rear] = j;
    }

    //--------------------------------------------------------------
    public long remove() { // take item from front of queue
        long temp = queArray[front++];
        if (front == maxSize) {
            front = 0;
        }
        return temp;
    }

    //--------------------------------------------------------------
    public long peek() { // peek at front of queue
        return queArray[front];
    }

    //--------------------------------------------------------------
    public boolean isEmpty() { // true if queue is empty
        return (rear + 1 == front || (front + maxSize - 1 == rear));
    }

    //--------------------------------------------------------------
    public boolean isFull() { // true if queue is full
        return (rear + 2 == front || (front + maxSize - 2 == rear));
    }

    //--------------------------------------------------------------
    public int size() { // (assumes queue not empty)
        if (rear >= front) { // contiguous sequence
            return rear - front + 1;
        } else { // broken sequence (wrap around)
            return (maxSize - front) + (rear + 1);
        }
    }
}
