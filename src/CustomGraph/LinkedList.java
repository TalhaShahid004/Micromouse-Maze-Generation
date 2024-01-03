package CustomGraph;

public class LinkedList<T>{
    Node head;
    private int size;

    public LinkedList() {
        head = null;
    }
    public void insert(Vertex value){
        if (head == null) {
            head = new Node(value);
            size++;
            return;
        }
        Node temp = head;
        Node n = new Node(value);
        n.next = temp;
        head = n;
    }
    public Boolean find(T value) {
        Node temp = head;
        while (temp != null) {
            if(temp.v.equals(value)){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void delete(T value) {
        Node temp = head;
        if (head.v.equals(value)) {
            head = head.next;
            size--;
        }
        while (temp.next != null) {
            if (temp.next.v.equals(value)) {
                temp.next = temp.next.next;
                return;
            }
            else {
                temp = temp.next;

            }
        }
    }

    public void clear(){
        head = null;
        size = 0;
    }

//    public void insertBefore(Node found, int d) { //index of the node before which the new node is placed
//        if (head == found) {
//            Node n = new Node(d);
//            n.next = head;
//            head = n;
//        }
//        else {
//            Node p = null;
//            for (Node n = head; n != found; p = n, n = n.next) ;
//            Node m = new Node(d);
//            m.next = p.next;
//            p.next = m;
//        }
//    }


    @Override
    public String toString() {
        if (size == 0)
            return "NULL";
        else {
            Node temp = head;
            StringBuilder s = new StringBuilder();
            while (temp != null) {
                s.append(temp.v);
                if (temp.next != null)
                    s.append(", ");
                temp = temp.next;
            }
            return s.toString();
        }
        }
        public int getSize() {
            return size;
        }
        
    }
