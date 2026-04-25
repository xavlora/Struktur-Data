package me.xavlora.latihan6;

class Link8 {
    public long dData;
    public Link8 next;
    public Link8 previous;

    public Link8(long d) {
        dData = d;
    }

    public void displayLink() {
        System.out.print(dData + " ");
    }
}

class DoublyLinkedList {
    private Link8 first;
    private Link8 last;

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(long dd) {
        Link8 newLink = new Link8(dd);

        if (isEmpty()) {
            last = newLink;
        } else {
            first.previous = newLink;
        }

        newLink.next = first;
        first = newLink;
    }

    public void insertLast(long dd) {
        Link8 newLink = new Link8(dd);

        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
            newLink.previous = last;
        }

        last = newLink;
    }

    public Link8 deleteFirst() {
        Link8 temp = first;

        if (first.next == null) {
            last = null;
        } else {
            first.next.previous = null;
        }

        first = first.next;
        return temp;
    }

    public Link8 deleteLast() {
        Link8 temp = last;

        if (first.next == null) {
            first = null;
        } else {
            last.previous.next = null;
        }

        last = last.previous;
        return temp;
    }

    public boolean insertAfter(long key, long dd) {
        Link8 current = first;

        while (current != null && current.dData != key) {
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        Link8 newLink = new Link8(dd);

        if (current == last) {
            newLink.next = null;
            last = newLink;
        } else {
            newLink.next = current.next;
            current.next.previous = newLink;
        }

        newLink.previous = current;
        current.next = newLink;

        return true;
    }

    public Link8 deleteKey(long key) {
        Link8 current = first;

        while (current != null && current.dData != key) {
            current = current.next;
        }

        if (current == null) {
            return null;
        }

        if (current == first) {
            first = current.next;
        } else {
            current.previous.next = current.next;
        }

        if (current == last) {
            last = current.previous;
        } else {
            current.next.previous = current.previous;
        }

        return current;
    }

    public void displayForward() {
        System.out.print("List (first-->last): ");
        Link8 current = first;

        while (current != null) {
            current.displayLink();
            current = current.next;
        }

        System.out.println();
    }

    public void displayBackward() {
        System.out.print("List (last-->first): ");
        Link8 current = last;

        while (current != null) {
            current.displayLink();
            current = current.previous;
        }

        System.out.println();
    }
}

class DoublyLinkedApp {
    public static void main(String[] args) {
        DoublyLinkedList theList = new DoublyLinkedList();

        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66);

        theList.insertLast(11);
        theList.insertLast(33);
        theList.insertLast(55);

        theList.displayForward();
        theList.displayBackward();

        theList.deleteFirst();
        theList.deleteLast();
        theList.deleteKey(11);

        theList.displayForward();

        theList.insertAfter(22, 77);
        theList.insertAfter(33, 88);

        theList.displayForward();
    }
}