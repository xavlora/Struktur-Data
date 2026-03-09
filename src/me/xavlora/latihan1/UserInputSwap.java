package me.xavlora.datastructure.latihan1;

import java.util.Scanner;

public class UserInputSwap {
    public static void main(String[] args) {
        int A, B, swap;

        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan bilangan bulat (A) : ");
        A = sc.nextInt();

        System.out.print("Masukkan bilangan bulat (B) : ");
        B = sc.nextInt();

        System.out.println("Sebelum ditukar: (A = " + A + ") (B = " + B + ")");

        swap = A;
        A = B;
        B = swap;

        System.out.println("Setelah ditukar: (A = " + A + ") (B = " + B + ")");
    }
}
