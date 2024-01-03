package DataStructures;

public class LinkedList {
    public LinkedListNode head;

    public LinkedList() {
        this.head = null;
    }

    public void add(Cell cell) {
        LinkedListNode nodeToAdd = new LinkedListNode(cell);

        if (this.head == null) {
            this.head = nodeToAdd;
        } else {
            LinkedListNode temp = this.head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = nodeToAdd;
        }
    }

    //remove a cell from the list only from the head
    public void queueRemove(Cell cell) {
        if (this.head == null) {
            return;
        }

        if (this.head.cell == cell) {
            this.head = this.head.next;
            return;
        }

    }


    public void remove(Cell cell) {
        if (this.head == null) {
            return;
        }

        if (this.head.cell == cell) {
            this.head = this.head.next;
            return;
        }

        LinkedListNode temp = this.head;
        while (temp.next != null) {
            if (temp.next.cell == cell) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }


    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int count = 0;
        LinkedListNode temp = this.head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public Cell get(int randomIndex) {
        //return a cell based on the index
        //if the index is 3, iterate 3 through the list to get the cell

        LinkedListNode temp = this.head;
        int count = 0;
        while (temp != null) {
            if (count == randomIndex) {
                return temp.cell;
            }
            count++;
            temp = temp.next;
        }
        return null;
    }

    //display
    public void display() {
        LinkedListNode temp = this.head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

}
