
<h1 align="center">Micromouse Maze Generation</h1>


<p align="center">
  This repository contains a Java implementation of maze generation algorithms suitable for a micromouse project, with added visualization.
</p>



## Project Description
This project is a comprehensive exploration into maze generation algorithms for robotics applications, specifically designed for a micromouse. It encompasses different approaches for maze generation and path-finding, providing a foundation for autonomous robot navigation within a maze environment. The project also includes visualization capabilities to aid in understanding the generated mazes and path-finding processes.

## Features
- **Multiple Maze Generation Algorithms:** Includes implementations of Depth-First Search (DFS) and Prim's algorithm for generating random mazes.
- **Graph Conversion:** Provides a mechanism to convert the generated maze into a graph representation, suitable for path-finding algorithms.
- **Pathfinding:** Implements Breadth-First Search (BFS) for path-finding within the generated mazes.
- **Visualization:** Includes a graphical user interface (GUI) to visualize the generated mazes and the shortest paths found using BFS.
- **Data Structures:** Utilizes custom data structures such as `Array2d`, `Cell`, `LinkedList`, and `Stack` to manage the maze structure and pathfinding.
- **Modular Design:** The codebase is designed to be modular with separate packages for algorithms, custom graph structures, and data structures.

## Installation
1. Ensure you have Java Development Kit (JDK) 8 or higher installed on your system.
2. Clone the repository to your local machine:
   ```bash
   git clone https://github.com/TalhaShahid004/Micromouse-Maze-Generation.git
   ```
3. Navigate to the cloned repository's directory:
   ```bash
   cd Micromouse-Maze-Generation
   ```
4. Compile the Java files using your preferred IDE (such as IntelliJ IDEA, Eclipse) or the command line.

## Running the Project
1.  After compiling the code, navigate to the `src/Default` directory.
2.  Run the `Main.java` class. This will open the drawing board with the generated maze.
    - Using Command Line:
      ```bash
      java -cp <path_to_compiled_classes> Default.Main
      ```
      (replace `<path_to_compiled_classes>` with the actual path to your compiled java class files)
    - Using IDE:
       Run `Main.java` using your chosen IDE's run configuration tools.

The application will start with a generated maze displayed graphically.

## Dependencies and Tools
*   **Java Development Kit (JDK 8 or higher):** Required for running and compiling Java code.
*   **Swing:** Used for creating the GUI.
*  **Git:** Used for version control of the repository.

## Contribution Guide
Contributions to this project are welcome. Here’s how you can contribute:
1.  Fork the repository.
2.  Create a new branch for your feature or bug fix.
3.  Make your changes and commit them.
4.  Push your changes to your fork.
5.  Submit a pull request to the main repository.

Please follow the existing code style and ensure that your code is well-documented.

## License
This project is licensed under the MIT License. 
