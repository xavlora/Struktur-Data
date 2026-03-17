/*
	Program:	OrdArray.java
	Pembuat:	Muhamad Hafiz
	Tanggal:	10 Maret 2026
	Deskripsi:	Demonstrasi array class dengan low level interface
*/

package me.xavlora.latihan2;

class OrdArray {
    private long[] a;
    private int nElems;

    public OrdArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while (true) {
            curIn = (lowerBound + upperBound) / 2;

            if (a[curIn] == searchKey)
                return curIn;
            else if (lowerBound > upperBound)
                return nElems;
            else {
                if (a[curIn] < searchKey)
                    lowerBound = curIn + 1;
                else
                    upperBound = curIn - 1;
            }
        }
    }

    public void insert(long value) {
        int j;

        for (j = 0; j < nElems; j++)
            if (a[j] > value)
                break;

        for (int k = nElems; k > j; k--)
            a[k] = a[k - 1];

        a[j] = value;
        nElems++;
    }

    public boolean delete(long value) {
        int j = find(value);

        if (j == nElems)
            return false;
        else {
            for (int k = j; k < nElems - 1; k++)
                a[k] = a[k + 1];

            nElems--;
            return true;
        }
    }

    public void display() {
        for (int j = 0; j < nElems; j++)
            System.out.print(a[j] + " ");

        System.out.println();
    }
}

class OrderedApp {
    public static void main(String[] args) {
        int maxSize = 100;
        OrdArray arr = new OrdArray(maxSize);

        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(0);
        arr.insert(66);
        arr.insert(33);

        int searchKey = 55;

        if (arr.find(searchKey) != arr.size())
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);

        arr.display();

        arr.delete(0);
        arr.delete(55);
        arr.delete(99);

        arr.display();
    }
}
