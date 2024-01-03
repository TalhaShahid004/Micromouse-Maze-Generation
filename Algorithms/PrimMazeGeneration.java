package Algorithms;

import java.util.Random;
import DataStructures.*;
public class PrimMazeGeneration {

    Array2d maze;
    LinkedList unvisitedNeighbors = new LinkedList();
    private int step;

    // Constructor for PrimMazeGeneration
    public PrimMazeGeneration(Array2d maze) {
        this.maze = maze;

        for (int i = 0; i < maze.size; i++) {
            for (int j = 0; j < maze.size; j++) {
                // get the current cell
                Cell currentCell = maze.get(i, j);

                // make all the walls true
                setAllWalls(currentCell);

                // add neighbors
                addNeighbors(currentCell);
            }
        }
    }

    public void setAllWalls(Cell cell) {
        cell.up = true;
        cell.right = true;
        cell.down = true;
        cell.left = true;
    }

    //  method to add all neighbors to a cell
    public void addNeighbors(Cell currentCell) {
        int x = currentCell.getX();
        int y = currentCell.getY();

        // check the left neighbor
        if (x - 1 >= 0 && x - 1 < 16) {
            Cell leftNeighbor = maze.get(x - 1, y);
            currentCell.getNeighbors().add(leftNeighbor);
        }

        // check the right neighbor
        if (x + 1 >= 0 && x + 1 < 16) {
            Cell rightNeighbor = maze.get(x + 1, y);
            currentCell.getNeighbors().add(rightNeighbor);
        }

        // check the up neighbor
        if (y - 1 >= 0 && y - 1 < 16) {
            Cell upNeighbor = maze.get(x, y - 1);
            currentCell.getNeighbors().add(upNeighbor);
        }

        // check the down neighbor
        if (y + 1 >= 0 && y + 1 < 16) {
            Cell downNeighbor = maze.get(x, y + 1);
            currentCell.getNeighbors().add(downNeighbor);
        }
    }

    //method to make all cells unvisited
    public void makeAllUnvisited() {
        //make all cells unvisited
        for (int i = 0; i < maze.size; i++) {
            for (int j = 0; j < maze.size; j++) {
                Cell currentCell = maze.get(i, j);
                currentCell.setVisited(false);
            }
        }
    }

    public void firstCell() {
        int startX = 0;
        int startY = 0;

        //2) add the neighbors of 0,0 to the list

        //make a list of unvisited neighbors

        Cell currentCell = maze.get(startX, startY);
        currentCell.setVisited(true);

        //add the neighbors of 0,0 to the list
        addUnvisitedNeighbours(unvisitedNeighbors, currentCell);

    }

    //4) randomly select a cell from the list
    public Cell randomNeighbour(LinkedList unvisitedNeighbors) {
        if (unvisitedNeighbors.isEmpty()) {
            return null;
        }

        Random rand = new Random();
        int randomIndex = rand.nextInt(unvisitedNeighbors.size());

        return unvisitedNeighbors.get(randomIndex);
    }

    //5) add all the unvisited neighbors of the selected neighbor to the list

    public void addUnvisitedNeighbours(LinkedList unvisitedNeighbors, Cell currentCell) {
        // add all the unvisited neighbors of the selected neighbor to the list
        // check the left, right, up, down neighbors
        // do this by checking the current index of the cell
        // make sure each x and y is within bounds
        // if the cell is not visited, add it to the list

        int x = currentCell.getX();
        int y = currentCell.getY();

        // Check the left neighbor
        if (x - 1 >= 0) {
            Cell leftNeighbor = maze.get(x - 1, y);
            if (leftNeighbor != null && !leftNeighbor.isVisited) {
                unvisitedNeighbors.add(leftNeighbor);
            }
        }

        // Check the right neighbor
        if (x + 1 < 16) {
            Cell rightNeighbor = maze.get(x + 1, y);
            if (rightNeighbor != null && !rightNeighbor.isVisited) {
                unvisitedNeighbors.add(rightNeighbor);
            }
        }

        // Check the up neighbor
        if (y - 1 >= 0) {
            Cell upNeighbor = maze.get(x, y - 1);
            if (upNeighbor != null && !upNeighbor.isVisited) {
                unvisitedNeighbors.add(upNeighbor);
            }
        }

        // Check the down neighbor
        if (y + 1 < 16) {
            Cell downNeighbor = maze.get(x, y + 1);
            if (downNeighbor != null && !downNeighbor.isVisited) {
                unvisitedNeighbors.add(downNeighbor);
            }
        }
    }


    //6) connect the neighbour with a visited neighbor

    public void connectNeighbour(Cell currentCell) {
        //go through current cell neighbours
        // check if there is a visited neighbour in its neighbour list
        //if there is, connect the current cell to the visited neighbour

        LinkedList currentCellNeighbours = currentCell.getNeighbors();

        //go through the current cell's neighbors
        //check if there is a visited neighbor in its neighbor list
        //if there is, connect the current cell to the visited neighbor
        for (int i = 0; i < currentCellNeighbours.size(); i++) {
            Cell currentCellNeighbor = currentCellNeighbours.get(i);
            if (currentCellNeighbor.isVisited) {
                if (currentCellNeighbor.getX() == currentCell.getX() - 1) {
                    //current cell is to the left of the visited neighbor
                    currentCellNeighbor.left = false;
                    currentCell.right = false;
                } else if (currentCellNeighbor.getX() == currentCell.getX() + 1) {
                    //current cell is to the right of the visited neighbor
                    currentCellNeighbor.right = false;
                    currentCell.left = false;
                } else if (currentCellNeighbor.getY() == currentCell.getY() - 1) {
                    //current cell is above the visited neighbor
                    currentCellNeighbor.up = false;
                    currentCell.down = false;
                } else if (currentCellNeighbor.getY() == currentCell.getY() + 1) {
                    //current cell is below the visited neighbor
                    currentCellNeighbor.down = false;
                    currentCell.up = false;
                }

                return;
            }
        }


    }

    //open up the center of the maze
    public void makeCenterOpen() {
        for (int i = maze.size / 2 - 1; i <= maze.size / 2; i++) {
            for (int j = maze.size / 2 - 1; j < maze.size / 2; j++) {
                Cell currentCell = maze.get(i, j);
                removeAllWalls(currentCell);
            }
        }

        //add an outer wall to the center
        for (int i = maze.size / 2 - 2; i <= maze.size / 2 + 1; i++) {
            Cell topCell = maze.get(i, maze.size / 2 - 2);
            Cell bottomCell = maze.get(i, maze.size / 2 + 1);
            topCell.up = true;
            bottomCell.down = true;
        }

        for (int j = maze.size / 2 - 2; j <= maze.size / 2 + 1; j++) {
            Cell leftCell = maze.get(maze.size / 2 - 2, j);
            Cell rightCell = maze.get(maze.size / 2 + 1, j);
            leftCell.left = true;
            rightCell.right = true;
        }

        Random rand = new Random();
        int randomX = rand.nextInt(2) + maze.size / 2 - 1;
        int randomY = rand.nextInt(2) + maze.size / 2 - 1;

        Cell randomCell = maze.get(randomX, randomY);
        Cell randomNeighbor = getRandomNeighbor(randomCell);

        removeWallBetween(randomCell, randomNeighbor);

    }

    public void removeWallBetween(Cell cell1, Cell cell2) {
        if (cell1.getX() == cell2.getX() - 1) {
            // cell1 is to the left of cell2
            cell1.right = false;
            cell2.left = false;
        } else if (cell1.getX() == cell2.getX() + 1) {
            // cell1 is to the right of cell2
            cell1.left = false;
            cell2.right = false;
        } else if (cell1.getY() == cell2.getY() - 1) {
            // cell1 is above cell2
            cell1.down = false;
            cell2.up = false;
        } else if (cell1.getY() == cell2.getY() + 1) {
            // cell1 is below cell2
            cell1.up = false;
            cell2.down = false;
        }
    }

    private Cell getRandomNeighbor(Cell currentCell) {
        LinkedList neighbors = currentCell.getNeighbors();
        Random rand = new Random();
        int randomIndex = rand.nextInt(neighbors.size());
        return neighbors.get(randomIndex);
    }

    public void removeAllWalls(Cell cell) {
        cell.up = false;
        cell.right = false;
        cell.down = false;
        cell.left = false;
    }

    //logic to generate the maze
    // logic to generate the maze
    public void generateMaze() {

        firstCell();

        while (!unvisitedNeighbors.isEmpty()) {
            // randomly select a neighbor from the list

            Cell currentCell = randomNeighbour(unvisitedNeighbors);

            if (currentCell == null) {
                break;  // No valid unvisited neighbors
            }


            // add all the unvisited neighbors of the selected neighbor to the list
            addUnvisitedNeighbours(unvisitedNeighbors, currentCell);

            // connect the neighbor with a visited neighbor
            connectNeighbour(currentCell);
            currentCell.isVisited = true;
            unvisitedNeighbors.remove(currentCell);
        }

        makeCenterOpen();
        makeOuterWalls();
        makeAllUnvisited();

    }




    public Array2d getMaze() {
        return maze;
    }

    public void displayMazeConsole() {
        System.out.println("Maze:");
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                Cell currentCell = maze.get(i, j);

                if (currentCell.up) {
                    System.out.print("─");
                } else {
                    System.out.print(" ");
                }

                if (currentCell.right) {
                    System.out.print("│");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    //make all outer walls true
    public void makeOuterWalls() {
        //make all outer walls true
        //make the top row true
        for (int i = 0; i < maze.size; i++) {
            Cell currentCell = maze.get(0, i);
            currentCell.up = true;
        }

        //make the bottom row true
        for (int i = 0; i < maze.size; i++) {
            Cell currentCell = maze.get(maze.size - 1, i);
            currentCell.down = true;
        }

        //make the left column true
        for (int i = 0; i < maze.size; i++) {
            Cell currentCell = maze.get(i, 0);
            currentCell.left = true;
        }

        //make the right column true
        for (int i = 0; i < maze.size; i++) {
            Cell currentCell = maze.get(i, maze.size - 1);
            currentCell.right = true;
        }
    }

    //display
    //use the cell class display walls, and call that for every cell
    public void displayMazeCells() {
        System.out.println("Maze:");
        for (int i = 0; i < maze.size; i++) {
            for (int j = 0; j < maze.size; j++) {
                Cell currentCell = maze.get(i, j);

                currentCell.displayWalls();
            }
        }
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
