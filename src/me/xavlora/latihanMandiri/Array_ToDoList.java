package me.xavlora.latihanMandiri;

import java.util.Scanner;

class Lists{
    private String[] lists;
    private int maxSize;
    private int top = -1;

    Lists(int maxSize) {
        this.maxSize = maxSize;
        lists = new String[maxSize];
    }

    public boolean isEmpty() {
        boolean flagger = false;
        for(int i = 0; i<lists.length; i++) {
            if(lists[i] == null) {
                flagger = true;
            }
        }
        return flagger;
    }

    public boolean isFull() {
        boolean flagger = false;
        for(int i = 0; i<lists.length; i++) {
            if(lists[i] != null) {
                flagger = true;
            }
        }
        return flagger;
    }

    public void menu() {
        System.out.println("===[ TO-DO LIST WITH ARRAY ]===");
        System.out.println("1. Tambahkan list.");
        System.out.println("2. Hapus list.");
        System.out.println("3. Tampilkan list.");
        System.out.print("Pilihan anda: "); int pilihan = getInt();
        switch(pilihan) {
            case 1:
                add();
                break;
            case 2:
                delete();
                break;
            case 3:
                show();
                break;
            default:
                menu();
        }

    }

    public void show() {
        if(isEmpty()) {
            System.out.println("List sedang kosong!");
            menu();
        } else {
            display();
            menu();
        }
    }

    public void display() {
        for(int i = 0; i<lists.length; i++) {
            System.out.println((i+1) + ". " + lists[i]);
        }
    }

    public void add() {
        if(isFull()) {
            System.out.println("List sedang penuh!");
            menu();
        } else {
            System.out.println("Masukan list yang ingin ditambahkan:");

            System.out.println("Berhasil menambahkan list!");
            menu();
        }
    }

    public void delete() {
        if(isEmpty()) {
            System.out.println("List sedang kosong!");
            menu();
        } else {
            display();
            System.out.print("Pilih nomor list yang ingin anda hapus: ");
            int pilihan = getInt();
            String temp;
            for(int i = (pilihan-1); i<lists.length; i++) {
                temp = lists[i+1];
                lists[i+1] = null;
                lists[i] = temp;
            }
            top--;
            System.out.println("List pada nomor " + pilihan + " sudah dihapus!");
            menu();
        }
    }

    public String getString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public int getInt() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

}

public class Array_ToDoList {
    public static void main(String[] args) {
        Lists l1 = new Lists(10);
        l1.menu();
    }
}
