package me.xavlora.latihan6;

class Link6 {
    public long dData;
    public Link6 next;

    public Link6(long dd) {
        dData = dd;
    }

    public void displayLink() {
        System.out.print(dData + " ");
    }
}

class SortedList {
    private Link6 first;

    public SortedList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insert(long key) {
        Link6 newLink = new Link6(key);
        Link6 previous = null;
        Link6 current = first;

        while (current != null && key > current.dData) {
            previous = current;
            current = current.next;
        }

        if (previous == null) {
            first = newLink;
        } else {
            previous.next = newLink;
        }

        newLink.next = current;
    }

    public Link6 remove() {
        Link6 temp = first;
        first = first.next;
        return temp;
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        Link6 current = first;

        while (current != null) {
            current.displayLink();
            current = current.next;
        }

        System.out.println();
    }
}

class SortedListApp {
    public static void main(String[] args) {
        SortedList theSortedList = new SortedList();

        theSortedList.insert(20);
        theSortedList.insert(40);

        theSortedList.displayList();

        theSortedList.insert(10);
        theSortedList.insert(30);
        theSortedList.insert(50);

        theSortedList.displayList();

        theSortedList.remove();

        theSortedList.displayList();
    }
}
