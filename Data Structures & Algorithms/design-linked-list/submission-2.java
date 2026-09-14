class MyLinkedList {
 private static class Node{
            int val;
            Node prev;
            Node next;
            Node(int val){
                this.val = val;
            }
        }
        private int size;
        private final Node head;
        private final Node tail;

    public MyLinkedList() {
        size = 0;
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        Node curr = getNode(index);
        return curr.val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    public void addAtIndex(int index, int val) {
         if (index < 0 || index > size) {
            return;
        }

        Node succ = (index == size) ? tail : getNode(index);
        Node pred = succ.prev;

        Node newNode = new Node(val);
        newNode.prev = pred;
        newNode.next = succ;
        pred.next = newNode;
        succ.prev = newNode;

        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        Node target = getNode(index);
        Node pred = target.prev;
        Node succ = target.next;

        pred.next = succ;
        succ.prev = pred;

        size--;
    }

    private Node getNode(int index) {
        Node curr;
        if (index < size / 2) {
            curr = head.next;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
        } else {
            curr = tail.prev;
            for (int i = 0; i < size - 1 - index; i++) {
                curr = curr.prev;
            }
        }
        return curr;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */