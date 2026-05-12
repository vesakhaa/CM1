public class doubleLinkedList04 {
    node04 head, tail;
    int size; // Tugas 5: Atribut untuk menghitung jumlah data

    public doubleLinkedList04() {
        head = null;
        tail = null;
        size = 0; // Inisialisasi size
    }

    public boolean isEmpty() {
        return head == null;
    }

    // Tugas 5: Method untuk mendapatkan jumlah data
    public int getSize() {
        return size;
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
        size++; // Tambah size
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
        size++; // Tambah size
    }

    public void insertAfter(String keyNim, mahasiswa04 data) {
        node04 current = head;
        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }
        if(current == null) {
            System.out.println("Data dengan nim " + keyNim + " tidak ditemukan.");
            return;
        }

        node04 newNode = new node04(data);

        if(current == tail) {
            newNode.prev = current;
            current.next = newNode;
            tail = newNode; // Koreksi tail dari diskusi sebelumnya
        }else{
            newNode.prev = current;
            newNode.next = current.next;
            current.next.prev = newNode;
            current.next = newNode;
        }
        size++; // Tambah size
        System.out.println("Data berhasil disisipkan setelah nim " + keyNim);
    }

    // Tugas 1: Tambah method add() pada index tertentu
    public void add(int index, mahasiswa04 data) {
        if (index < 0 || index > size) {
            System.out.println("Index di luar batas!");
            return;
        }
        if (isEmpty() || index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            node04 current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            node04 newNode = new node04(data);
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
            System.out.println("Data berhasil ditambahkan pada index " + index);
        }
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

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("Linked List Kosong");
            return;
        }
        System.out.println("Data berhasil dihapus:");
        head.data.tampil();
        System.out.println("---------------------------------------------");

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--; // Kurangi size
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("Linked List Kosong");
            return;
        }
        System.out.println("Data berhasil dihapus:");
        tail.data.tampil();
        System.out.println("---------------------------------------------");

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--; // Kurangi size
    }

    // Tugas 2: Tambah method removeAfter() untuk menghapus node setelah node tertentu
    public void removeAfter(String keyNim) {
        if (isEmpty()) {
            System.out.println("Linked List Kosong");
            return;
        }
        node04 current = head;
        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }
        
        if (current == null) {
            System.out.println("Data dengan nim " + keyNim + " tidak ditemukan.");
        } else if (current.next == null) {
            System.out.println("NIM " + keyNim + " adalah data terakhir, tidak ada data setelahnya untuk dihapus.");
        } else {
            node04 nodeToRemove = current.next;
            System.out.println("Data yang berhasil dihapus setelah NIM " + keyNim + ":");
            nodeToRemove.data.tampil();
            System.out.println("---------------------------------------------");
            
            if (nodeToRemove == tail) {
                removeLast(); // Jika yang dihapus adalah tail, gunakan removeLast
            } else {
                current.next = nodeToRemove.next;
                nodeToRemove.next.prev = current;
                size--;
            }
        }
    }

    // Tugas 3: Tambah method remove() pada index tertentu
    public void remove(int index) {
        if (isEmpty()) {
            System.out.println("Linked List Kosong");
            return;
        }
        if (index < 0 || index >= size) {
            System.out.println("Index di luar batas!");
            return;
        }
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            node04 current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            System.out.println("Data pada index " + index + " berhasil dihapus:");
            current.data.tampil();
            System.out.println("---------------------------------------------");
            
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
        }
    }

    // Tugas 4a: Method getFirst()
    public void getFirst() {
        if (isEmpty()) {
            System.out.println("Linked List Kosong");
        } else {
            System.out.println("Data Mahasiswa Pertama:");
            head.data.tampil();
        }
    }

    // Tugas 4b: Method getLast()
    public void getLast() {
        if (isEmpty()) {
            System.out.println("Linked List Kosong");
        } else {
            System.out.println("Data Mahasiswa Terakhir:");
            tail.data.tampil();
        }
    }

    // Tugas 4c: Method getIndex()
    public void getIndex(int index) {
        if (isEmpty()) {
            System.out.println("Linked List Kosong");
            return;
        }
        if (index < 0 || index >= size) {
            System.out.println("Index di luar batas!");
            return;
        }
        node04 current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        System.out.println("Data Mahasiswa pada index " + index + ":");
        current.data.tampil();
    }
}