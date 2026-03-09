package me.xavlora.latihan1;

import java.util.Scanner;

public class SecondsToTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total, jam, menit, detik;

        System.out.print("Masukkan total detik: ");
        total = sc.nextInt();

        jam = total / 3600;
        menit = (total % 3600) / 60;
        detik = total % 60;

        System.out.println(total + " detik = " + jam + " jam, " + menit + " menit, " + detik + " detik");

    }
}
