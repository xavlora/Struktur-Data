package me.xavlora.latihan12;

class StackX1 {
    private int[] st;
    private int top;

    public StackX1(int size) {
        st = new int[size];
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
        return top == -1;
    }
}

class Graph2 {
    private final int MAX_VERTS = 20;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private int nVerts;
    private StackX1 theStack;

    public Graph2() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;

        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }

        theStack = new StackX1(MAX_VERTS);
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

    public void mst() {
        vertexList[0].wasVisited = true;
        theStack.push(0);

        while (!theStack.isEmpty()) {
            int currentVertex = theStack.peek();
            int v = getAdjUnvisitedVertex(currentVertex);

            if (v == -1) {
                theStack.pop();
            } else {
                vertexList[v].wasVisited = true;
                theStack.push(v);

                displayVertex(currentVertex);
                displayVertex(v);
                System.out.print(" ");
            }
        }

        for (int j = 0; j < nVerts; j++) {
            vertexList[j].wasVisited = false;
        }
    }

    public int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < nVerts; j++) {
            if (adjMat[v][j] == 1 && !vertexList[j].wasVisited) {
                return j;
            }
        }
        return -1;
    }
}

public class MSTApp {
    public static void main(String[] args) {
        Graph2 theGraph2 = new Graph2();

        theGraph2.addVertex('A');
        theGraph2.addVertex('B');
        theGraph2.addVertex('C');
        theGraph2.addVertex('D');
        theGraph2.addVertex('E');

        theGraph2.addEdge(0, 1);
        theGraph2.addEdge(0, 2);
        theGraph2.addEdge(0, 3);
        theGraph2.addEdge(0, 4);
        theGraph2.addEdge(1, 2);
        theGraph2.addEdge(1, 3);
        theGraph2.addEdge(1, 4);
        theGraph2.addEdge(2, 3);
        theGraph2.addEdge(2, 4);
        theGraph2.addEdge(3, 4);

        System.out.print("Minimum spanning tree: ");
        theGraph2.mst();
        System.out.println();
    }
}