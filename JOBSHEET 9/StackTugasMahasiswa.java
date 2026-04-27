
public class StackTugasMahasiswa {

    Mahasiswa04[] stack;
    int top;
    int size;

    public StackTugasMahasiswa(int size) {
        this.size = size;
        stack = new Mahasiswa04[size];
        top = -1;
    }

    public boolean isFull() {
        if (top == size - 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    void push(Mahasiswa04 mhs) {
        if (!isFull()) {
            top++;
            stack[top] = mhs;
        } else {
            System.out.println("Stack Penuh! Tidak bisa menambahkan tugas lagi.");
        }
    }

    public Mahasiswa04 pop() {
        if (!isEmpty()) {
            Mahasiswa04 m = stack[top];
            top--;
            return m;
        } else {
            System.out.println("Stack Kosong! Tidak ada tugas untuk dinilai");
            return null;
        }
    }

    public Mahasiswa04 peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println("Stack Kosong! Tidak ada tugas yang dikumpulkan");
            return null;
        }
    }

    public void print() {
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i].Nama + "\t" + stack[i].NIM + "\t" + stack[i].Kelas);
        }
    }

    public void lihatTugasTerbawah() {
        if (!isEmpty()) {
            System.out.println("Tugas pertama dikumpulkan oleh: " + stack[0].Nama);
        } else {
            System.out.println("Stack kosong!");
        }
    }

    public int hitungTugas() {
        return top + 1; 
    }

    public String konversiDesimalKeBiner(int Nilai) {
        StackKonversi04 stack = new StackKonversi04();
        while (Nilai > 0) {
            int sisa = Nilai % 2;
            stack.push(sisa);
            Nilai = Nilai / 2;
        }
        String biner = new String();
        while (!stack.isEmpty()) {
            biner += stack.pop();
        }

        return biner;
    }
}
