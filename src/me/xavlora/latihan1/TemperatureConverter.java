package me.xavlora.datastructure.latihan1;

import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double celcius, reamur, fahrenheit, kelvin;

        System.out.print("Masukkan suhu dalam derajat Celcius: ");
        celcius = sc.nextDouble();

        reamur = (4.0/5.0)*celcius;
        fahrenheit = ((9.0/5.0)*celcius)+32;
        kelvin = celcius+273;

        System.out.println("Celcius = " + celcius + "°C");
        System.out.println("Reamur = " + reamur + "°R");
        System.out.println("Fahrenheit = " + fahrenheit + "°F");
        System.out.println("Kelvin = " + kelvin + "K");
    }
}
