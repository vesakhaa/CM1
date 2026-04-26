public class StackSurat04 {
    Surat04[] stack;
    int size;
    int top;

    public StackSurat04(int size) {
        this.size = size;
        stack = new Surat04[size];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(Surat04 s) {
        if (!isFull()) {
            top++;
            stack[top] = s;
        } else {
            System.out.println("Stack Penuh! Tidak dapat menerima surat lagi.");
        }
    }

    public Surat04 pop() {
        if (!isEmpty()) {
            Surat04 s = stack[top];
            top--;
            return s;
        } else {
            System.out.println("Stack Kosong! Tidak ada surat untuk diproses.");
            return null;
        }
    }

    public Surat04 peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println("Stack Kosong!");
            return null;
        }
    }

    public void cariSurat(String nama) {
        if (isEmpty()) {
            System.out.println("Stack Kosong! Tidak ada data untuk dicari.");
            return;
        }
        
        boolean ditemukan = false;
        for (int i = top; i >= 0; i--) {
            if (stack[i].namaMahasiswa.equalsIgnoreCase(nama)) {
                System.out.println("Surat ditemukan!");
                System.out.println("ID Surat: " + stack[i].idSurat);
                System.out.println("Nama: " + stack[i].namaMahasiswa);
                System.out.println("Kelas: " + stack[i].kelas);
                System.out.println("Jenis: " + (stack[i].jenisIzin == 'S' ? "Sakit" : "Izin"));
                System.out.println("Durasi: " + stack[i].durasi + " hari");
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Surat atas nama " + nama + " tidak ditemukan.");
        }
    }
}