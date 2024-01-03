package Algorithms;
import CustomGraph.*;
import DataStructures.*;
public class MazeToGraphConverter {
    public static MyGraph convertToGraph(Array2d maze) {
        MyGraph graph = new MyGraph(maze.size * maze.size);

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.width; j++) {
                Cell currentCell = maze.get(i, j);

                // Add the cell as a vertex in the graph
                graph.AddVertex(currentCell);

                // Connect neighbors without walls
                if (i > 0 && !currentCell.up && !maze.get(i - 1, j).down) {
                    Cell neighbor = maze.get(i - 1, j);
                    graph.AddEdge(currentCell, neighbor);
                    System.out.println(currentCell + " edged with " + neighbor);
                }

                if (i < maze.length - 1 && !currentCell.down && !maze.get(i + 1, j).up) {
                    Cell neighbor = maze.get(i + 1, j);
                    graph.AddEdge(currentCell, neighbor);
                    System.out.println(currentCell + " edged with " + neighbor);
                }

                if (j > 0 && !currentCell.left && !maze.get(i, j - 1).right) {
                    Cell neighbor = maze.get(i, j - 1);
                    graph.AddEdge(currentCell, neighbor);
                    System.out.println(currentCell + " edged with " + neighbor);
                }

                if (j < maze.width - 1 && !currentCell.right && !maze.get(i, j + 1).left) {
                    Cell neighbor = maze.get(i, j + 1);
                    graph.AddEdge(currentCell, neighbor);
                    System.out.println(currentCell + " edged with " + neighbor);
                }

                // Special case for the first row and first column
                if (i == 0 && j < maze.width - 1 && !currentCell.right && !maze.get(i, j + 1).left) {
                    Cell neighbor = maze.get(i, j + 1);
                    graph.AddEdge(currentCell, neighbor);
                    System.out.println(currentCell + " edged with " + neighbor);
                }

                if (j == 0 && i < maze.length - 1 && !currentCell.down && !maze.get(i + 1, j).up) {
                    Cell neighbor = maze.get(i + 1, j);
                    graph.AddEdge(currentCell, neighbor);
                    System.out.println(currentCell + " edged with " + neighbor);
                }
            }
        }

        return graph;
    }

}
