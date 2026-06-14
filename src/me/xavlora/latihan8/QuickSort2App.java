package me.xavlora.latihan8;

class ArrayIns1 {
    private long[] theArray;
    private int nElems;

    public ArrayIns1(int max) {
        theArray = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        theArray[nElems] = value;
        nElems++;
    }

    public void display() {
        System.out.print("A = ");
        for (int j = 0; j < nElems; j++) {
            System.out.print(theArray[j] + " ");
        }
        System.out.println();
    }

    public void quickSort() {
        recQuickSort(0, nElems - 1);
    }

    private void recQuickSort(int left, int right) {
        if (left >= right) {
            return;
        }

        long pivot = medianOf3(left, right);
        int partition = partitionIt(left, right, pivot);

        recQuickSort(left, partition - 1);
        recQuickSort(partition + 1, right);
    }

    private long medianOf3(int left, int right) {
        int center = (left + right) / 2;

        if (theArray[left] > theArray[center])
            swap(left, center);

        if (theArray[left] > theArray[right])
            swap(left, right);

        if (theArray[center] > theArray[right])
            swap(center, right);

        swap(center, right - 1);

        return theArray[right - 1];
    }

    private int partitionIt(int left, int right, long pivot) {
        int leftPtr = left;
        int rightPtr = right - 1;

        while (true) {
            while (theArray[++leftPtr] < pivot);

            while (theArray[--rightPtr] > pivot);

            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }

        swap(leftPtr, right - 1);

        return leftPtr;
    }

    private void swap(int dex1, int dex2) {
        long temp = theArray[dex1];
        theArray[dex1] = theArray[dex2];
        theArray[dex2] = temp;
    }
}

public class QuickSort2App {
    public static void main(String[] args) {
        int maxSize = 16;
        ArrayIns1 arr = new ArrayIns1(maxSize);

        for (int j = 0; j < maxSize; j++) {
            long n = (long) (Math.random() * 99);
            arr.insert(n);
        }

        arr.display();
        arr.quickSort();
        arr.display();
    }
}
