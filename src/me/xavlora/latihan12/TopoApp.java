package me.xavlora.latihan12;

class Graph3 {
    private final int MAX_VERTS = 20;

    private Vertex[] vertexList;
    private int[][] adjMat;
    private int nVerts;
    private char[] sortedArray;

    public Graph3() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        sortedArray = new char[MAX_VERTS];
        nVerts = 0;
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
    }

    public void topo() {
        int orig_nVerts = nVerts;

        while (nVerts > 0) {
            int currentVertex = noSuccessors();

            if (currentVertex == -1) {
                System.out.println("ERROR: Graph3 has cycles");
                return;
            }

            sortedArray[nVerts - 1] =
                    vertexList[currentVertex].label;

            deleteVertex(currentVertex);
        }

        System.out.print("Topologically sorted order: ");

        for (int j = 0; j < orig_nVerts; j++) {
            System.out.print(sortedArray[j]);
        }

        System.out.println();
    }

    public int noSuccessors() {
        boolean isEdge;

        for (int row = 0; row < nVerts; row++) {
            isEdge = false;

            for (int col = 0; col < nVerts; col++) {
                if (adjMat[row][col] > 0) {
                    isEdge = true;
                    break;
                }
            }

            if (!isEdge) {
                return row;
            }
        }

        return -1;
    }

    public void deleteVertex(int delVert) {
        if (delVert != nVerts - 1) {
            for (int j = delVert; j < nVerts - 1; j++) {
                vertexList[j] = vertexList[j + 1];
            }

            for (int row = delVert; row < nVerts - 1; row++) {
                moveRowUp(row, nVerts);
            }

            for (int col = delVert; col < nVerts - 1; col++) {
                moveColLeft(col, nVerts - 1);
            }
        }

        nVerts--;
    }

    private void moveRowUp(int row, int length) {
        for (int col = 0; col < length; col++) {
            adjMat[row][col] = adjMat[row + 1][col];
        }
    }

    private void moveColLeft(int col, int length) {
        for (int row = 0; row < length; row++) {
            adjMat[row][col] = adjMat[row][col + 1];
        }
    }
}

public class TopoApp {
    public static void main(String[] args) {
        Graph3 theGraph3 = new Graph3();

        theGraph3.addVertex('A');
        theGraph3.addVertex('B');
        theGraph3.addVertex('C');
        theGraph3.addVertex('D');
        theGraph3.addVertex('E');
        theGraph3.addVertex('F');
        theGraph3.addVertex('G');
        theGraph3.addVertex('H');

        theGraph3.addEdge(0, 3);
        theGraph3.addEdge(0, 4);
        theGraph3.addEdge(1, 4);
        theGraph3.addEdge(2, 5);
        theGraph3.addEdge(3, 6);
        theGraph3.addEdge(4, 6);
        theGraph3.addEdge(5, 7);
        theGraph3.addEdge(6, 7);

        theGraph3.topo();
    }
}