public class doubleLinkedList04 {
    node04 head, tail;

    public doubleLinkedList04() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(mahasiswa04 data) {
        node04 newNode = new node04(data);
        if(isEmpty()) {
            head = tail = newNode;
        }else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addLast(mahasiswa04 data) {
        node04 newNode = new node04(data);
        if(isEmpty()){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void insertAfter(String keyNim, mahasiswa04 data) {
        node04 current = head;
        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }
        if(current == null) {
            System.out.println("data dengan nim " + keyNim + " tidak ditemukan.");
            return;
        }

        node04 newNode = new node04(data);

        if(current == tail) {
            newNode.prev = current;
            current.next = newNode;
        }else{
            newNode.prev = current;
            newNode.next = current.next;
            current.next.prev = newNode;
            current.next = newNode;
        }
        System.out.println("Data berhasil disisipkan setelah nim " + keyNim);
    }

    public void print(){
        if(isEmpty()) {
            System.out.println("Linked List Masih Kosong");
            return;
        }
        node04 current = head;
        while (current != null) {
            current.data.tampil();
            current = current.next;
        }
        System.out.println();
    }

    public void printReverse() {
        if (isEmpty()) {
        System.out.println("Linked List Masih Kosong");
        return;
    }
        node04 current = tail; 
        while (current != null) {
            current.data.tampil();
            current = current.prev; 
    }
    System.out.println();
}
}
