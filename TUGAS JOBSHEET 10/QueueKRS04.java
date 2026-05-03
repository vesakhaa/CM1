public class QueueKRS04 {
    Mahasiswa04[] antrian;
    int front;
    int rear;
    int size;
    int max;
    
    int totalDiproses;
    final int MAX_KRS_DPA = 30; // Kuota maksimal DPA

    public QueueKRS04(int max) {
        this.max = max;
        this.antrian = new Mahasiswa04[max];
        this.size = 0;
        this.front = 0;
        this.rear = -1;
        this.totalDiproses = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void clear() {
        if (!isEmpty()) {
            front = 0;
            rear = -1;
            size = 0;
            System.out.println("Antrian berhasil dikosongkan.");
        } else {
            System.out.println("Antrian masih kosong.");
        }
    }

    public void enqueue(Mahasiswa04 mhs) {
        if (isFull()) {
            System.out.println("Mohon maaf, antrian sudah penuh (Maks " + max + ").");
        } else if (totalDiproses + size >= MAX_KRS_DPA) {
            System.out.println("Mohon maaf, kuota DPA sudah habis (Maks 30 Mahasiswa).");
        } else {
            rear = (rear + 1) % max;
            antrian[rear] = mhs;
            size++;
            System.out.println("Mahasiswa atas nama " + mhs.nama + " berhasil masuk antrian.");
        }
    }

    public void prosesKRS() {
        if (isEmpty()) {
            System.out.println("Antrian kosong, tidak ada yang bisa diproses.");
        } else {
            System.out.println("\n--- Memproses KRS ---");
            int jumlahProses = 0;
            while (!isEmpty() && jumlahProses < 2) {
                Mahasiswa04 mhs = antrian[front];
                front = (front + 1) % max;
                size--;
                totalDiproses++;
                jumlahProses++;
                System.out.println("Memproses mahasiswa ke-" + jumlahProses + ":");
                mhs.tampilkanData();
            }
            System.out.println("---------------------");
        }
    }

    public void printSemua() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Daftar Mahasiswa dalam Antrian KRS:");
            for (int i = 0; i < size; i++) {
                int index = (front + i) % max;
                System.out.print((i + 1) + ". ");
                antrian[index].tampilkanData();
            }
        }
    }

    public void peekDuaTerdepan() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("2 Antrian Terdepan:");
            for (int i = 0; i < 2 && i < size; i++) {
                int index = (front + i) % max;
                System.out.print((i + 1) + ". ");
                antrian[index].tampilkanData();
            }
        }
    }

    public void peekBelakang() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Antrian Paling Akhir:");
            antrian[rear].tampilkanData();
        }
    }

    public void infoAntrian() {
        System.out.println("\n=== Info Layanan KRS DPA ===");
        System.out.println("Jumlah mahasiswa dalam antrian saat ini : " + size);
        System.out.println("Jumlah mahasiswa yang sudah proses KRS  : " + totalDiproses);
        System.out.println("Sisa mahasiswa yang belum proses KRS    : " + (MAX_KRS_DPA - totalDiproses));
        System.out.println("============================");
    }
}