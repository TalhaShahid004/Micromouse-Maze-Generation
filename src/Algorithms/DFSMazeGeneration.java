package Algorithms;
import DataStructures.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DFSMazeGeneration {
    Array2d maze;

    public DFSMazeGeneration(Array2d maze) {
        this.maze = maze;

        // Initialize each cell in the maze
        for (int i = 0; i < maze.size; i++) {
            for (int j = 0; j < maze.size; j++) {
                maze.cells[i][j] = new Cell();
                Cell currentCell = maze.cells[i][j];
                currentCell.x = i;
                currentCell.y = j;
                setAllWalls(currentCell);
            }
        }
    }


    public void setAllWalls(Cell cell) {
        cell.up = true;
        cell.right = true;
        cell.down = true;
        cell.left = true;
    }

    public void generateMaze() {
        // Starting cell
        Cell startCell = maze.cells[0][0];
        startCell.setVisited(true);

        // Stack for DFS
        stack stack = new stack();
        stack.push(startCell);

        // Loop until the stack is empty
        while (!stack.isEmpty()) {
            // Get the top cell from the stack
            Cell currentCell = stack.peek();

            // Get all unvisited neighbors of the current cell
            LinkedList unvisitedNeighbors = getUnvisitedNeighbors(currentCell);

            if (unvisitedNeighbors.isEmpty()) {
                // If there are no unvisited neighbors, pop the stack
                stack.pop();
            } else {
                // Get a random unvisited neighbor
                Random rand = new Random();
                int randomIndex = rand.nextInt(unvisitedNeighbors.size());
                Cell randomNeighbor = unvisitedNeighbors.get(randomIndex);

                // Remove the wall between the current cell and the random neighbor
                removeWallBetween(currentCell, randomNeighbor);

                // Mark the random neighbor as visited and push it to the stack
                randomNeighbor.setVisited(true);
                stack.push(randomNeighbor);
            }
        }


        //make center open
        makeCenterOpen();
        makeAllUnvisited();

    }

    //make all unvisited
    public void makeAllUnvisited() {
        //make all cells unvisited
        for (int i = 0; i < maze.size; i++) {
            for (int j = 0; j < maze.size; j++) {
                Cell currentCell = maze.cells[i][j];
                currentCell.setVisited(false);
            }
        }
    }


    private LinkedList getUnvisitedNeighbors(Cell cell) {
        LinkedList neighbors = new LinkedList();

        // Check up, right, down, left neighbors
        if (isValidNeighbor(cell.x - 1, cell.y) && !maze.cells[cell.x - 1][cell.y].isVisited) {
            neighbors.add(maze.cells[cell.x - 1][cell.y]);
        }
        if (isValidNeighbor(cell.x, cell.y + 1) && !maze.cells[cell.x][cell.y + 1].isVisited) {
            neighbors.add(maze.cells[cell.x][cell.y + 1]);
        }
        if (isValidNeighbor(cell.x + 1, cell.y) && !maze.cells[cell.x + 1][cell.y].isVisited) {
            neighbors.add(maze.cells[cell.x + 1][cell.y]);
        }
        if (isValidNeighbor(cell.x, cell.y - 1) && !maze.cells[cell.x][cell.y - 1].isVisited) {
            neighbors.add(maze.cells[cell.x][cell.y - 1]);
        }

        return neighbors;
    }

    private boolean isValidNeighbor(int x, int y) {
        return x >= 0 && x < maze.size && y >= 0 && y < maze.size;
    }

    private void removeWallBetween(Cell cell1, Cell cell2) {
        // Determine the relative position of cell2 to cell1
        int dx = cell2.x - cell1.x;
        int dy = cell2.y - cell1.y;

        // Break the corresponding wall
        if (dx == -1) {
            cell1.up = false;
            cell2.down = false;
        } else if (dx == 1) {
            cell1.down = false;
            cell2.up = false;
        } else if (dy == -1) {
            cell1.left = false;
            cell2.right = false;
        } else if (dy == 1) {
            cell1.right = false;
            cell2.left = false;
        }
    }

    //method to make center 4 cells open with outer borders
    public void makeCenterOpen() {
        Cell topLeftCell = maze.cells[7][7];
        Cell topRightCell = maze.cells[7][8];
        Cell bottomLeftCell = maze.cells[8][7];
        Cell bottomRightCell = maze.cells[8][8];


        setAllWallsTrue(topLeftCell);
        setAllWallsTrue(topRightCell);
        setAllWallsTrue(bottomLeftCell);
        setAllWallsTrue(bottomRightCell);

        //remove the walls between the cells
        removeWallBetween(topLeftCell, topRightCell);
        removeWallBetween(topLeftCell, bottomLeftCell);
        removeWallBetween(topRightCell, bottomRightCell);
        removeWallBetween(bottomLeftCell, bottomRightCell);

        // open up one of the walls at random
        Random rand = new Random();
        int randomIndex = rand.nextInt(8);

        if (randomIndex == 0){
            removeWallBetween(topLeftCell, maze.cells[7][6]);
            removeWallBetween(maze.cells[7][6], maze.cells[7][5]);
        } else if (randomIndex == 1){
            removeWallBetween(topLeftCell, maze.cells[6][7]);
            removeWallBetween(maze.cells[6][7], maze.cells[5][7]);
        } else if (randomIndex == 2){
            removeWallBetween(topRightCell, maze.cells[7][9]);
            removeWallBetween(maze.cells[7][9], maze.cells[7][10]);
        } else if (randomIndex == 3){
            removeWallBetween(topRightCell, maze.cells[6][8]);
            removeWallBetween(maze.cells[6][8], maze.cells[5][8]);
        } else if (randomIndex == 4){
            removeWallBetween(bottomLeftCell, maze.cells[9][7]);
            removeWallBetween(maze.cells[9][7], maze.cells[10][7]);
        } else if (randomIndex == 5){
            removeWallBetween(bottomLeftCell, maze.cells[8][6]);
            removeWallBetween(maze.cells[8][6], maze.cells[8][5]);
        } else if (randomIndex == 6){
            removeWallBetween(bottomRightCell, maze.cells[9][8]);
            removeWallBetween(maze.cells[9][8], maze.cells[10][8]);
        } else if (randomIndex == 7){
            removeWallBetween(bottomRightCell, maze.cells[8][9]);
            removeWallBetween(maze.cells[8][9], maze.cells[8][10]);
        }

    }



    public void setAllWallsTrue(Cell cell) {
        // Set all walls of the current cell to true
        cell.up = true;
        cell.down = true;
        cell.left = true;
        cell.right = true;

        // Get the coordinates of the current cell
        int x = cell.x;
        int y = cell.y;

        // Set the corresponding walls of the top neighbor to true
        if (isValidNeighbor(x - 1, y)) {
            maze.cells[x - 1][y].down = true;
        }

        // Set the corresponding walls of the bottom neighbor to true
        if (isValidNeighbor(x + 1, y)) {
            maze.cells[x + 1][y].up = true;
        }

        // Set the corresponding walls of the left neighbor to true
        if (isValidNeighbor(x, y - 1)) {
            maze.cells[x][y - 1].right = true;
        }

        // Set the corresponding walls of the right neighbor to true
        if (isValidNeighbor(x, y + 1)) {
            maze.cells[x][y + 1].left = true;
        }
    }

}