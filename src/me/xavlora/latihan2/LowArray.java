/*
	Program:	LowArray.java
	Pembuat:	Muhamad Hafiz
	Tanggal:	10 Maret 2026
	Deskripsi:	Demonstrasi array class dengan low level interface
*/

package me.xavlora.latihan2;

class LowArray {
	private long[] a;
	
	public LowArray(int size) {
		a = new long[size];
	}
	
	public void setElemn(int index, long value) {
		a[index] = value;
	}
	
	public long getElem(int index) {
		return a[index];
	}
}

class LowArrayApp{
	public static void main(String[] args) {
		LowArray arr;
		arr = new LowArray(100);
		int nElmns = 0;
		int j;
	
		arr.setElemn(0, 77);
		arr.setElemn(1, 99);
		arr.setElemn(2, 44);
		arr.setElemn(3, 55);
		arr.setElemn(4, 22);
		arr.setElemn(5, 88);
		arr.setElemn(6, 11);
		arr.setElemn(7, 00);
		arr.setElemn(8, 66);
		arr.setElemn(9, 33);
		nElmns = 10;
	
		for(j=0; j<nElmns; j++) {
			System.out.print(arr.getElem(j) + " ");
		}
		System.out.println("");
		
		int searchKey = 26;
		for(j=0; j<nElmns; j++) {
			if(arr.getElem(j) == searchKey) {
			break;
			}
		}
		if(j == nElmns) {
			System.out.println("Tidak dapat menemukan " + searchKey);
		} else {
			System.out.println(searchKey + " ditemukan!"); 
		}
	
		for(j=0; j<nElmns; j++) {
			if(arr.getElem(j) == 55) {
				break;
			}
		for(int k=j; k<nElmns; k++) {
			arr.setElemn(k, arr.getElem(k+1));
		}
		nElmns--;
	
		for(j=0; j<nElmns; j++) {
			System.out.print(arr.getElem(j) + " ");
		}
		System.out.println("");
		}
	}
}