public class QueueLinkedList04 {
    NodeAntrian04 head, tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(AntrianMhs04 data) {
        NodeAntrian04 newNode = new NodeAntrian04(data, null);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        System.out.println("Mahasiswa " + data.nama + " berhasil masuk antrian.");
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Antrian masih kosong!");
        } else {
            AntrianMhs04 dipanggil = head.data;
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
            }
            System.out.println("Memanggil antrian: " + dipanggil.nama + " (" + dipanggil.nim + ")");
        }
    }


    public void peek() {
        if (!isEmpty()) {
            System.out.println("Antrian terdepan saat ini:");
            System.out.println("----------------------------------------------------------");
            System.out.printf("| %-15s | %-15s | %-5s | %-12s |\n", "NIM", "Nama", "Kelas", "Gender");
            System.out.println("----------------------------------------------------------");
            head.data.tampilInformasi();
            System.out.println("----------------------------------------------------------");
        } else {
            System.out.println("Antrian kosong!");
        }
    }

    public void print() {
        if (!isEmpty()) {
            NodeAntrian04 tmp = head;
            System.out.println("Daftar Antrian Layanan Unit Kemahasiswaan:");
            System.out.println("----------------------------------------------------------");
            System.out.printf("| %-15s | %-15s | %-5s | %-12s |\n", "NIM", "Nama", "Kelas", "Gender");
            System.out.println("----------------------------------------------------------");
            while (tmp != null) {
                tmp.data.tampilInformasi();
                tmp = tmp.next;
            }
            System.out.println("----------------------------------------------------------\n");
        } else {
            System.out.println("Antrian kosong!");
        }
    }
}