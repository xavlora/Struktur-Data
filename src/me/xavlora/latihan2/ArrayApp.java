/*
	Program:	ArrayApp.java
	Pembuat:	Muhamad Hafiz
	Tanggal:	10 Maret 2026
	Deskripsi:	Membuat program yang menggunakan array untuk menghapus data pada indeks tertentu
*/

package me.xavlora.latihan2;

class ArrayApp {
	public static void main(String[] args) {
		long[] arr = new long[100];			//Mendefinisikan array "arr"
		int nElmns = 0;						//Variabel untuk besar indeks array
		int i = 0;							//Loop counter
		long searchKey;						//Variabel untuk angka yang akan disearch
		
		arr[0] = 77;
		arr[1] = 99;
		arr[2] = 44;
		arr[3] = 55;
		arr[4] = 22;
		arr[5] = 88;
		arr[6] = 11;
		arr[7] = 00;
		arr[8] = 66;
		arr[9] = 33;						//Mengisi 10 indeks pertama array "arr"
		nElmns = 10;						//Limit indeks array untuk pengulangan
		
		for(i = 0; i < nElmns; i++) {		//Menampilkan isi array "arr"
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
		
		searchKey = 66;						//Angka "66" adalah angka yang disearch
		for(i = 0; i < nElmns; i++) {		
			if(arr[i] == searchKey) {		//Mencari indeks pada angka "66"
				break;
			}
		}
		if(i == nElmns) {					//Mencari "apakah terletak di akhir?"
			System.out.println("Tidak bisa menemukan " + searchKey);
		} else {
			System.out.println(searchKey + " ditemukan pada indeks " + (i+1));
		}
		
		searchKey = 55;						//Angka "55" adalah angka yang disearch
		for(i = 0; i < nElmns; i++) {
			if(arr[i] == searchKey) {		
				break;						//Mencari indeks pada angka "55"
			}
		}
		
		for(int k=i; k<nElmns-1; k++) {
			arr[k] = arr[k+1];
		}
		nElmns--;
		
		for(i=0; i<nElmns; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println("");
		
	}
}