package me.xavlora.latihan6;

class Link2 {
    public int iData;
    public double dData;
    public Link2 next;

    public Link2(int id, double dd) {
        iData = id;
        dData = dd;
    }

    public void displayLink2() {
        System.out.print("{" + iData + ", " + dData + "} ");
    }
}

class LinkList2 {
    private Link2 first;

    public LinkList2() {
        first = null;
    }

    public void insertFirst(int id, double dd) {
        Link2 newLink2 = new Link2(id, dd);
        newLink2.next = first;
        first = newLink2;
    }

    public Link2 find(int key) {
        Link2 current = first;

        while (current.iData != key) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }

        return current;
    }

    public Link2 delete(int key) {
        Link2 current = first;
        Link2 previous = first;

        while (current.iData != key) {
            if (current.next == null) {
                return null;
            } else {
                previous = current;
                current = current.next;
            }
        }

        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }

        return current;
    }

    public void displayList() {
        System.out.print("List (first --> last): ");
        Link2 current = first;

        while (current != null) {
            current.displayLink2();
            current = current.next;
        }

        System.out.println();
    }
}

class LinkList22App {
    public static void main(String[] args) {
        LinkList2 theList = new LinkList2();

        theList.insertFirst(22, 2.99);
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);

        theList.displayList();

        Link2 f = theList.find(44);
        if (f != null) {
            System.out.println("Found Link2 with key " + f.iData);
        } else {
            System.out.println("Can't find Link2");
        }

        Link2 d = theList.delete(66);
        if (d != null) {
            System.out.println("Deleted Link2 with key " + d.iData);
        } else {
            System.out.println("Can't delete Link2");
        }

        theList.displayList();
    }
}