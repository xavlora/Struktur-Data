package me.xavlora.latihan1;

import java.util.Scanner;

public class Balok {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double panjang, lebar, tinggi, luasAlas, luasPermukaan, volume;

        System.out.print("Masukkan panjang balok: ");
        panjang = sc.nextDouble();
        System.out.print("Masukkan lebar balok: ");
        lebar = sc.nextDouble();
        System.out.print("Masukkan tinggi balok: ");
        tinggi = sc.nextDouble();

        luasAlas = panjang*lebar;
        volume = panjang*lebar*tinggi;
        luasPermukaan = (2*panjang*lebar)+(2*panjang*tinggi)+(2*lebar*tinggi);

        System.out.println("Luas alas balok adalah " + luasAlas);
        System.out.println("Volume balok adalah " + volume);
        System.out.println("Luas permukaan balok adalah " + luasPermukaan);
    }
}
