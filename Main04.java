import java.util.Scanner;

public class Main04 {
    static Mahasiswa04[] daftarMhs = {
        new Mahasiswa04("22001", "Andi", "Teknik Informatika"),
        new Mahasiswa04("22002", "Budi", "Teknik Informatika"),
        new Mahasiswa04("22003", "Citra", "SIB")
    };

    static Buku04[] daftarBuku = {
        new Buku04("B01", "Algoritma", 2020),
        new Buku04("B02", "Basis Data", 2019),
        new Buku04("B03", "Java OOP", 2021)
    };

    static Peminjaman04[] dataPinjam = {
        new Peminjaman04(daftarMhs[0], daftarBuku[0], 7),
        new Peminjaman04(daftarMhs[1], daftarBuku[1], 4),
        new Peminjaman04(daftarMhs[2], daftarBuku[2], 10),
        new Peminjaman04(daftarMhs[0], daftarBuku[2], 6)
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProsesPeminjaman04 proses = new ProsesPeminjaman04();
        int pilih;

        do {
            System.out.println("\n=== MENU PEMINJAMAN 04 ===");
            System.out.println("1. Data Mahasiswa\n2. Data Buku\n3. Data Peminjaman");
            System.out.println("4. Urut Denda (Selection Sort)\n5. Cari NIM (Binary Search)\n0. Keluar");
            System.out.print("Pilih: ");
            pilih = sc.nextInt();

            switch (pilih) {
                case 1: for (Mahasiswa04 m : daftarMhs) m.tampilMahasiswaCM1(); break;
                case 2: for (Buku04 b : daftarBuku) b.tampilBuku(); break;
                case 3: for (Peminjaman04 p : dataPinjam) p.tampilPeminjaman(); break;
                case 4: 
                    proses.selectionSortDenda(dataPinjam);
                    System.out.println("Data Terurut Denda Terbesar:");
                    for (Peminjaman04 p : dataPinjam) p.tampilPeminjaman();
                    break;
                case 5:
                    System.out.print("Masukkan NIM yang dicari: ");
                    proses.binarySearchNIM(dataPinjam, sc.next());
                    break;
            }
        } while (pilih != 0);
    }
}