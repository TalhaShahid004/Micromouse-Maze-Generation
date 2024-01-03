package CustomGraph;

public class Vertex {
    String name;
    int age;
    private boolean isVisited;
    private Vertex predecessor;
    LinkedList<Vertex> friendsList = new LinkedList<>();
    Vertex(String d, int a ){
        name = d;
        age = a;
    }

    @Override
    public String toString() {
        return "name: " + name + ", age: " + age ;
    }
    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }
    public boolean getVisited(){
        return isVisited;
    }
    public Vertex getPredecessor() {
        return predecessor;
    }
    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }
}
