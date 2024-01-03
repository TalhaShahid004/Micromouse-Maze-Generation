package CustomGraph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import DataStructures.*;
public class PathFinding {
    public static Cell[] predecessors;
    public static void DFS(MyGraph G, Vertex s){
        Stack<Vertex> stack = new Stack<>();
        stack.push(s);
        s.setVisited(true);
        System.out.println(s);
        while(!stack.isEmpty()){
            Vertex v = stack.peek();
            Vertex w = null;
            Node temp = v.friendsList.head;
            for (int i = 0; i < v.friendsList.getSize(); i++) {
                if(!temp.v.getVisited()){
                    w = temp.v;
                    break;
                }
                temp = temp.next;
            }
            if(w != null && !w.getVisited()){
                stack.push(w);
                w.setVisited(true);
                System.err.println(w);

            }
            else
                stack.pop();
        }
        G.setfalse();
    }
    public static void BFS(MyGraph G, Vertex s){
        Queue<Vertex> queue = new java.util.LinkedList();
        queue.add(s);
        s.setVisited(true);
        System.err.println(s);
        Vertex v = null;
        Vertex w = null;
        while (!queue.isEmpty()) {
            v = queue.poll();
            Node temp = v.friendsList.head;
            for (int i = 0; i < v.friendsList.getSize(); i++) {
                if(!temp.v.getVisited()){
                    w = temp.v;
                    break;
                }
                temp = temp.next;
            }
            if(w != null && !w.getVisited()){
                queue.add(w);
                w.setVisited(true);
                System.err.println(w);
            }
        }
        G.setfalse();
    }

    public static void BFS_shortest_path(MyGraph G, Cell s1, Cell s2){
        Cell s = s1;
        predecessors = new Cell[G.getCount()];
        Queue<Cell> queue = new LinkedList();
        queue.add(s);
        s.setVisited(true);
        // System.err.println(s);
        Cell v = null;
        Cell w = null;
        int a = 0;
        while (!queue.isEmpty()) {
            v = queue.poll();
            LinkedListNode temp = v.getNeighbors().head;
            for (int i = 0; i < v.getNeighbors().size(); i++) {
                if(!temp.cell.isVisited){
                    w = temp.cell;
                    break;
                }
                temp = temp.next;
            }
            if(w != null && !w.isVisited){
                queue.add(w);
                w.setVisited(true);
                predecessors[a] = v;
                a++;
                // System.err.println(w);
            }
            System.out.println("w.x " + w.x + " w.y " + w.y+ " s.x " + s.x + " s.y " + s.y);
            if(w.x == s2.x && w.y == s2.y)
                break;
        }
//        for (int i = 0; i < predecessors.length; i++) {
//            if(predecessors[i]!=null)
//                System.out.println(predecessors[i]);
//        }
        G.setfalse();
        G.setPredecessorNull();
       System.out.println(Arrays.toString(predecessors));
        System.out.println(predecessors[0].x);
    }

    public static Cell[] getPredecessors() {
        return predecessors;
    }


    public static void bfs(Cell source, Cell destination) {
        Queue<Cell> queue = new LinkedList<>();
        source.setVisited(true);
        queue.add(source);

        while (!queue.isEmpty()) {
            Cell current = queue.poll();

            if (current.equals(destination)) {
                break;
            }

            DataStructures.LinkedList neighbors = current.getNeighbors();
            for (int i = 0; i < neighbors.size(); i++) {
                Cell neighbor = neighbors.get(i);
                if (!neighbor.isVisited) {
                        neighbor.setVisited(true);
                        neighbor.setPredecessor(current);
                        queue.add(neighbor);
                    // Check if there is a border between the current cell and the neighbor
                    if ((current.x == neighbor.x && current.y - neighbor.y == 1 && !current.left) ||
                            (current.x == neighbor.x && current.y - neighbor.y == -1 && !current.right) ||
                            (current.y == neighbor.y && current.x - neighbor.x == 1 && !current.up) ||
                            (current.y == neighbor.y && current.x - neighbor.x == -1 && !current.down)) {
                        neighbor.setVisited(true);
                        neighbor.setPredecessor(current);
                        queue.add(neighbor);
                    }
                }
            }
        }
    }
//public static void bfs(Cell source, Cell destination) {
//    Queue<Cell> queue = new LinkedList<>();
//    source.setVisited(true);
//    queue.add(source);
//
//    while (!queue.isEmpty()) {
//        Cell current = queue.poll();
//
//        if (current.equals(destination)) {
//            break;
//        }
//
//        DataStructures.LinkedList neighbors = current.getNeighbors();
//        for (int i = 0; i < neighbors.size(); i++) {
//            Cell neighbor = neighbors.get(i);
//            if (!neighbor.isVisited) {
//                neighbor.setVisited(true);
//                neighbor.setPredecessor(current);
//                queue.add(neighbor);
//            }
//        }
//    }
//}
    public static Cell[] getPath(Cell source, Cell destination) {
        // First, determine the length of the path
        int length = 0;
        for (Cell cell = destination; cell != null; cell = cell.getPredecessor()) {
            length++;
        }

        // Create an array of the correct length
        Cell[] path = new Cell[length];

        // Fill the array with the cells in the path
        Cell current = destination;
        for (int i = length - 1; i >= 0; i--) {
            path[i] = current;
            current = current.getPredecessor();
        }

        // If the first cell in the path is the source, return the path
        if (path.length > 0 && path[0].equals(source)) {
            return path;
        }

        // If there is no path from the source to the destination, return an empty array
        return new Cell[0];
    }



}
