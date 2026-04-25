package me.xavlora.latihanMandiri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Mahasiswa {
    String nama;
    String kelas;
    String nim;

    Mahasiswa(String nama, String kelas, String nim) {
        this.nama = nama;
        this.kelas = kelas;
        this.nim = nim;
    }

    void sayHello() {
        System.out.println("Halo " + nama + " dari kelas " + kelas + " dengan nim " + nim);
    }
}

public class class_n_object {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    }
}
