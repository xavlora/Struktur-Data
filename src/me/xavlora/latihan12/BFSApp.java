package me.xavlora.latihan12;

import java.util.Scanner;

class Vertex {
    public char label;
    public boolean wasVisited;

    public Vertex(char lab) {
        label = lab;
        wasVisited = false;
    }
}

class Queue {
    private int[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int size) {
        queArray = new int[size];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(int j) {
        if (rear == queArray.length - 1)
            rear = -1;

        queArray[++rear] = j;
        nItems++;
    }

    public int remove() {
        int temp = queArray[front++];

        if (front == queArray.length)
            front = 0;

        nItems--;
        return temp;
    }

    public boolean isEmpty() {
        return nItems == 0;
    }
}

class Graph {
    private final int MAX_VERTS = 20;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private int nVerts;
    private Queue theQueue;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;

        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }

        theQueue = new Queue(MAX_VERTS);
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    public int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < nVerts; j++) {
            if (adjMat[v][j] == 1 && !vertexList[j].wasVisited)
                return j;
        }
        return -1;
    }

    public void bfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theQueue.insert(0);

        int v2;

        while (!theQueue.isEmpty()) {
            int v1 = theQueue.remove();

            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                theQueue.insert(v2);
            }
        }

        for (int j = 0; j < nVerts; j++) {
            vertexList[j].wasVisited = false;
        }
    }
}

public class BFSApp {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Graph theGraph = new Graph();

        System.out.print("Masukkan jumlah vertex: ");
        int jumlahVertex = getInteger();

        for (int i = 0; i < jumlahVertex; i++) {
            System.out.print("Masukkan label vertex ke-" + i + ": ");
            char label = getChar();
            theGraph.addVertex(label);
        }

        System.out.print("Masukkan jumlah edge: ");
        int jumlahEdge = getInteger();

        for (int i = 0; i < jumlahEdge; i++) {
            System.out.println("Edge ke-" + (i + 1));

            System.out.print("Masukkan index vertex awal: ");
            int start = getInteger();

            System.out.print("Masukkan index vertex akhir: ");
            int end = getInteger();

            theGraph.addEdge(start, end);
        }

        System.out.print("Visits: ");
        theGraph.bfs();
        System.out.println();
    }

    public static char getChar() {
        String input = scanner.next();
        return input.charAt(0);
    }

    public static int getInteger() {
        return scanner.nextInt();
    }
}