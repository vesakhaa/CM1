public class AntrianMhs04 {
    String nim;
    String nama;
    String kelas;
    String jenisKelamin;

    public AntrianMhs04(String nim, String nama, String kelas, String jenisKelamin) {
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
        this.jenisKelamin = jenisKelamin;
    }

    public void tampilInformasi() {
        // Menggunakan printf agar rapi seperti tabel saat diprint
        System.out.printf("| %-15s | %-15s | %-5s | %-12s |\n", nim, nama, kelas, jenisKelamin);
    }
}