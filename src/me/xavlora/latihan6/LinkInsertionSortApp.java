package me.xavlora.latihan6;

class Link7 {
    public long dData;
    public Link7 next;

    public Link7(long dd) {
        dData = dd;
    }
}

class SortedList2 {
    private Link7 first;

    public SortedList2() {
        first = null;
    }

    public SortedList2(Link7[] linkArr) {
        first = null;

        for (int j = 0; j < linkArr.length; j++) {
            insert(linkArr[j]);
        }
    }

    public void insert(Link7 k) {
        Link7 previous = null;
        Link7 current = first;

        while (current != null && k.dData > current.dData) {
            previous = current;
            current = current.next;
        }

        if (previous == null) {
            first = k;
        } else {
            previous.next = k;
        }

        k.next = current;
    }

    public Link7 remove() {
        Link7 temp = first;
        first = first.next;
        return temp;
    }
}

class ListInsertionSortApp {
    public static void main(String[] args) {
        int size = 10;

        Link7[] linkArray = new Link7[size];

        for (int j = 0; j < size; j++) {
            int n = (int) (java.lang.Math.random() * 99);
            Link7 newLink = new Link7(n);
            linkArray[j] = newLink;
        }

        System.out.print("Unsorted array: ");
        for (int j = 0; j < size; j++) {
            System.out.print(linkArray[j].dData + " ");
        }
        System.out.println();

        SortedList2 theSortedList = new SortedList2(linkArray);

        for (int j = 0; j < size; j++) {
            linkArray[j] = theSortedList.remove();
        }

        System.out.print("Sorted Array: ");
        for (int j = 0; j < size; j++) {
            System.out.print(linkArray[j].dData + " ");
        }
        System.out.println();
    }
}