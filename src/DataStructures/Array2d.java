package DataStructures;

public class Array2d {
    public int length;
    public int width;
    public int size = 16;

    public Cell[][] cells;

    public Array2d() {
        this.length = size;
        this.width = size;
        this.cells = new Cell[length][width];
        int a = 0;
        // Initialize each cell in the maze
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                cells[i][j] = new Cell();
                Cell currentCell = cells[i][j];
                currentCell.x = i;
                currentCell.y = j;
                currentCell.identifier = a;
                a++;
            }
        }
    }


    // will return a cell at a given x and y
    public Cell get(int x, int y) {
        if (x >= 0 && x < length && y >= 0 && y < width) {
            return cells[x][y];
        } else {
            return null;
        }
    }
    //will return on the basis of the identifier
    public Cell getIdentifier(int x){
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                if(x == cells[i][j].identifier){
                    return cells[i][j];
                }
            }
        }
        return null;
    }
}


