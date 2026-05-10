public class Mhs04 {
    String nama, nim, kelas;
    double ipk;

    Mhs04(String nama, String nim, String kelas, double ipk) {
        this.nama = nama;
        this.nim = nim;
        this.kelas = kelas;
        this.ipk = ipk;
    }

    public void tampilInformasi() {
        System.out.printf("| %-10s | %-10s | %-5s | %-4.2f |\n", nama, nim, kelas, ipk);
    }
}
