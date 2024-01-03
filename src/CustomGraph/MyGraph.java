package CustomGraph;

import DataStructures.Cell;

public class MyGraph {
    Cell[] adjList;
    int count;
    public MyGraph(int s){
        adjList = new Cell[s];
    }
    public void AddVertex(Cell cell){
        if (count-1 == adjList.length){
            System.out.println("Size of adjacency list is full, cannot add!");
            return;
        }
        adjList[count] = cell;
        cell.identifier = count;
        count++;
    }
    public void AddEdge(Cell n1, Cell n2){
        //first find the edge from the adj list that you want to add to n1
        n1.getNeighbors().add(n2);
        n2.getNeighbors().add(n1);
    }

    public void setfalse(){ //for BFS and DFS
        for (int i = 0; i < adjList.length; i++) {
            if(adjList[i]!=null)
                adjList[i].setVisited(false);
        }
    }
    public void setPredecessorNull(){ //for BFS shortest path
        for (int i = 0; i < adjList.length; i++) {
            if(adjList[i]!=null)
                adjList[i].setPredecessor(null);
        }
    }

    public int getCount() {
        return count;
    }
    @Override
    public String toString() {
        for (int i = 0; i < count; i++) {
            System.out.println("Vertex: " +  adjList[i] + " Neighbours:" + adjList[i].getNeighbors().toString());
        }
        return "";
    }
}
