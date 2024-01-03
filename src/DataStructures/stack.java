package DataStructures;

public class stack {
    StackNode head;

    public stack() {
        this.head = null;
    }

    public void push(Cell cell) {
        StackNode nodeToAdd = new StackNode(cell);

        if (this.head == null) {
            this.head = nodeToAdd;
        } else {
            nodeToAdd.next = this.head;
            this.head = nodeToAdd;
        }
    }

    public Cell pop() {
        if (this.head == null) {
            return null;
        }

        Cell cellToReturn = this.head.cell;
        this.head = this.head.next;
        return cellToReturn;
    }

    public Cell peek() {
        if (this.head == null) {
            return null;
        }

        return this.head.cell;
    }


    public boolean isEmpty() {
        return this.head == null;
    }

    public void display() {
        StackNode temp = this.head;
        while (temp != null) {
            System.out.println(temp.cell);
            temp = temp.next;
        }
    }
}
