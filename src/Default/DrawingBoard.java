package Default;
import Algorithms.*;
import DataStructures.*;
import CustomGraph.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;

public class DrawingBoard extends JFrame{
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    public JPanel drawingPanel;
    private int currentX, currentY, oldX, oldY;
    public Array2d maze;
    PrimMazeGeneration gen;
    DFSMazeGeneration dfs;
    private JButton resetButton;

    private int cellSize;
    private JButton stepButton;
    //    private Timer timer;
    private JButton solve;
    MyGraph graph;
    Cell[] shortestPath;
    private static final int DELAY = 500;

    public DrawingBoard() {
        // Making sure the board isn't resizable, this would also lead to making a custom button to exit

        setUndecorated(true); // Remove window decorations (title bar, etc.)
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Start in full-screen mode
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initializing the Board

        setTitle("Drawing Board");
        setSize(size.width, size.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cellSize = 50;
        // Initializing the 2d array implementation
        maze = new Array2d();
//        gen = new PrimMazeGeneration(maze);
//        gen.generateMaze();
//        maze = gen.getMaze();
//        graph = MazeToGraphConverter.convertToGraph(maze);
//        System.out.println(graph);
        dfs = new DFSMazeGeneration(maze);
        dfs.generateMaze();
        Cell source = maze.get(0,0); // specify your source cell
        Cell destination = maze.get(0,0); // specify your destination ce
        PathFinding.bfs( source, destination);
        shortestPath = PathFinding.getPath(source,destination);
        System.out.println(Arrays.toString(shortestPath));
//        Cell source = maze.get(11,15); // specify your source cell
//        Cell destination = maze.get(9,15); // specify your destination ce
//        shortestPath = ShortestPathFinder.findShortestPath(maze, source, destination);
//        for (int i = 0; i < shortestPath.size(); i++) {
//            System.out.println(shortestPath.get(i).x + ", " +shortestPath.get(i).y );
//        }
        //        setBorders();
        drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawGenMaze(g);
            }
        };

        drawingPanel.setBackground(Color.WHITE);
        // The custom exit button
        JButton closeButton = new JButton("Close");

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the window
            }
        });


        // Create a panel for the close button
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(closeButton);

        // Add components to the content pane
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(drawingPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }
    private void drawGenMaze(Graphics g) {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                int x = size.width / 5 + j * 40;
                int y = size.height / 10 + i * 40 - 50;
                
                maze.cells[i][j].x = x;
                maze.cells[i][j].y = y;

                // Draw cell background

                    g.setColor(Color.WHITE);

                g.fillRect(x, y, 50, 50);

                // Draw cell borders
                g.setColor(Color.RED);
                if (maze.cells[i][j].up) {
                    g.drawLine(x, y, x + 50, y);
                }
                if (maze.cells[i][j].down) {
                    g.drawLine(x, y + 50, x + 50, y + 50);
                }
                if (maze.cells[i][j].left) {
                    g.drawLine(x, y, x, y + 50);
                }
                if (maze.cells[i][j].right) {
                    g.drawLine(x + 50, y, x + 50, y + 50);
                }
            }
        }
//         // Draw the shortest path
//         g.setColor(Color.GREEN);
//         for (int i = 0; i < shortestPath.length; i++) {
//             Cell predecessor = shortestPath[i];
//             if (predecessor != null) {
//                 int x = predecessor.x;
//                 int y = predecessor.y;
//                 g.fillRect(x + 5, y + 5, 40, 30); // Fill the entire cell
//             }
//         }
//     }

//     //    private void setBorders(){
// //        for (int i = 0; i < maze.getLength(); i++) {
// //            for (int j = 0; j < maze.getLength(); j++) {
// //                int random = (int)(Math.random()*5);
// //                if(random == 1 )
// //                    maze.cells[i][j].setUp(true);
// //                else if (random == 2)
// //                    maze.cells[i][j].setDown(true);
// //                else if (random == 3)
// //                    maze.cells[i][j].setRight(true);
// //                else
// //                    maze.cells[i][j].setLeft(true);
// //            }
// //        }
// //    }
// //}
//     public void markShortestPath(Array2d maze, List<Cell> shortestPath) {
//         for (Cell cell : shortestPath) {
//             maze.getIdentifier(cell.identifier).isVisited = true;
//             // You can add additional visualization logic here
//         }
//     }
    }
}


