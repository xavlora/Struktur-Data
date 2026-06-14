package me.xavlora.latihan8;

class ArraySh {
    private long[] theArray;
    private int nElems;

    public ArraySh(int max) {
        theArray = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        theArray[nElems] = value;
        nElems++;
    }

    public void display() {
        System.out.print("A=");

        for (int j = 0; j < nElems; j++) {
            System.out.print(theArray[j] + " ");
        }

        System.out.println();
    }

    public void shellSort() {
        int inner, outer;
        long temp;

        int h = 1;

        while (h <= nElems / 3) {
            h = h * 3 + 1;
        }

        while (h > 0) {
            for (outer = h; outer < nElems; outer++) {
                temp = theArray[outer];
                inner = outer;

                while (inner > h - 1 && theArray[inner - h] >= temp) {
                    theArray[inner] = theArray[inner - h];
                    inner -= h;
                }

                theArray[inner] = temp;
            }

            h = (h - 1) / 3;
        }
    }
}

public class ShellSortApp {
    public static void main(String[] args) {
        int maxSize = 10;
        ArraySh arr = new ArraySh(maxSize);

        for (int j = 0; j < maxSize; j++) {
            long n = (int) (Math.random() * 10);
            arr.insert(n);
        }

        System.out.println("Before sorting:");
        arr.display();

        arr.shellSort();

        System.out.println("After sorting:");
        arr.display();
    }
}
