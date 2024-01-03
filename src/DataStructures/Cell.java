package DataStructures;

public class Cell {
    //coordinates
    public int x;
    public int y;

    //weight
    int distance;

    //directions/walls
    public boolean up;
    public boolean right;
    public boolean down;
    public boolean left;
    private Cell predecessor;

    //visited
    public boolean isVisited;

    //neighbors
    LinkedList neighbors;
    Cell previous;
    public int identifier;

    public Cell() {
        this.up = false;
        this.right = false;
        this.down = false;
        this.left = false;
        this.isVisited = false;
        this.neighbors = new LinkedList();
        this.x = 0;
        this.y = 0;
        this.distance = 0;
    }


    public LinkedList getNeighbors() {
        return neighbors;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void displayWalls() {
        System.out.println("up: " + up + " right: " + right + " down: " + down + " left: " + left);
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Cell other = (Cell) obj;
        return this.x == other.x && this.y == other.y;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Cell getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Cell predecessor) {
        this.predecessor = predecessor;
    }
}
