package me.xavlora.latihan12;

import java.util.Scanner;

class Vertex1 {
    public char label;
    public boolean wasVisited;

    public Vertex1(char lab) {
        label = lab;
        wasVisited = false;
    }
}

class StackX {
    private int[] st;
    private int top;

    public StackX(int s) {
        st = new int[s];
        top = -1;
    }

    public void push(int j) {
        st[++top] = j;
    }

    public int pop() {
        return st[top--];
    }

    public int peek() {
        return st[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}

class Graph1 {
    private final int MAX_VERTS = 20;
    private Vertex1[] vertexList;
    private int[][] adjMat;
    private int nVerts;
    private StackX theStack;

    public Graph1() {
        vertexList = new Vertex1[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;

        for (int j = 0; j < MAX_VERTS; j++) {
            for (int k = 0; k < MAX_VERTS; k++) {
                adjMat[j][k] = 0;
            }
        }

        theStack = new StackX(MAX_VERTS);
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex1(lab);
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
            if (adjMat[v][j] == 1 &&
                    !vertexList[j].wasVisited)
                return j;
        }
        return -1;
    }

    public void dfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theStack.push(0);

        while (!theStack.isEmpty()) {
            int v = getAdjUnvisitedVertex(theStack.peek());

            if (v == -1) {
                theStack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }

        for (int j = 0; j < nVerts; j++) {
            vertexList[j].wasVisited = false;
        }
    }
}

public class DFSApp {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Graph1 theGraph1 = new Graph1();

        System.out.print("Masukkan jumlah vertex: ");
        int jumlahVertex = getInteger();

        for (int i = 0; i < jumlahVertex; i++) {
            System.out.print("Masukkan label vertex ke-" + i + ": ");
            char label = getChar();
            theGraph1.addVertex(label);
        }

        System.out.print("Masukkan jumlah edge: ");
        int jumlahEdge = getInteger();

        for (int i = 0; i < jumlahEdge; i++) {
            System.out.println("Edge ke-" + (i + 1));

            System.out.print("Masukkan index vertex awal: ");
            int start = getInteger();

            System.out.print("Masukkan index vertex akhir: ");
            int end = getInteger();

            theGraph1.addEdge(start, end);
        }

        System.out.print("Visits: ");
        theGraph1.dfs();
        System.out.println();
    }

    public static int getInteger() {
        return scanner.nextInt();
    }

    public static char getChar() {
        return scanner.next().charAt(0);
    }
}