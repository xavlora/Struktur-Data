package me.xavlora.latihan6;

class Link1 {
    public int iData;
    public double dData;
    public Link1 next;

    public Link1(int id, double dd) {
        iData = id;
        dData = dd;
    }

    public void displayLink1() {
        System.out.print("{" + iData + "}");
    }
}

class LinkList1 {
    private Link1 first;

    public LinkList1() {
        first = null;
    }

    public boolean isEmpty() {
        return (first==null);
    }

    public void insertFirst(int id, double dd) {
        Link1 newLink1 = new Link1(id, dd);
        newLink1.next = first;
        first = newLink1;
    }

    public Link1 deleteFirst() {
        Link1 temp = first;
        first = first.next;
        return temp;
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        Link1 current = first;
        while(current != null) {
            current.displayLink1();
            current = current.next;
        }
        System.out.println("");
    }
}

public class LinkListApp {
    public static void main(String[] args) {
        LinkList1 theList = new LinkList1();

        theList.insertFirst(22, 2.99);
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);

        theList.displayList();

        while(!theList.isEmpty()) {
            Link1 aLink1 = theList.deleteFirst();
            System.out.print("Deleted ");
            aLink1.displayLink1();
            System.out.println("");
        }

        theList.displayList();
    }
}
