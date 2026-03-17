/*
	Program:	HighArray.java
	Pembuat:	Muhamad Hafiz
	Tanggal:	17 Maret 2026
	Deskripsi:	Membuat program yang menggunakan array
*/

package me.xavlora.latihan2;

class HighArray {
    private long[] a; // ref to array a
    private int nElems; // number of data items

    public HighArray(int max) { // constructor
        a = new long[max]; // create the array
        nElems = 0; // no items yet
    }

    public boolean find(long searchKey) { // find specified value
        int j;
        for (j = 0; j < nElems; j++) { // for each element
            if (a[j] == searchKey) { // found item?
                break; // exit loop before end
            }
        }

        if (j == nElems)
            return false; // not found
        else
            return true; // found
    }

    public void insert(long value) { // put element into array
        a[nElems] = value; // insert it
        nElems++; // increment size
    }

    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++) { // look for it
            if (value == a[j]) {
                break;
            }
        }

        if (j == nElems)
            return false; // can't find it
        else {
            for (int k = j; k < nElems - 1; k++) { // move elements down
                a[k] = a[k + 1];
            }
            nElems--; // decrement size
            return true;
        }
    }

    public void display() { // displays array contents
        for (int j = 0; j < nElems; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println();
    }
}

class HighArrayApp {
    public static void main(String[] args) {
        int maxSize = 100; // array size
        HighArray arr = new HighArray(maxSize);

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

        arr.display();

        int searchKey = 35;
        if (arr.find(searchKey))
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);

        arr.delete(0);
        arr.delete(55);
        arr.delete(99);

        arr.display();
    }
}
