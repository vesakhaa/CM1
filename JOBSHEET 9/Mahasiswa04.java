public class Mahasiswa04 {
    String NIM;
    String Nama;
    String Kelas;
    int Nilai;

    public Mahasiswa04() {
    }

    public Mahasiswa04(String NIM, String Nama, String Kelas, int Nilai) {
        this.NIM = NIM;
        this.Nama = Nama;
        this.Kelas = Kelas;
        Nilai = -1;
    }

    void tugasDinilai(int Nilai) {
        this.Nilai = Nilai;
    }
}
