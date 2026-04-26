import java.util.Scanner;

public class Main04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ProsesPeminjaman04 proses = new ProsesPeminjaman04(); 
        
        int pilih;
        do {
            System.out.println("\n=== SISTEM PEMINJAMAN RUANG BACA JTI ===");
            System.out.println("1. Tampilkan Mahasiswa");
            System.out.println("2. Tampilkan Buku");
            System.out.println("3. Tampilkan Peminjaman");
            System.out.println("4. Urutkan Denda Terbesar");
            System.out.println("5. Cari Berdasarkan NIM");
            System.out.println("0. Keluar");
            System.out.print("Pilih Menu: ");
            pilih = sc.nextInt();

            switch (pilih) {
                case 1:
                    System.out.println("\n--- Data Mahasiswa ---");
                    for (Mahasiswa04 m : proses.daftarMhs) m.tampilMahasiswa();
                    break;
                case 2:
                    System.out.println("\n--- Data Buku ---");
                    for (Buku04 b : proses.daftarBuku) b.tampilBuku();
                    break;
                case 3:
                    System.out.println("\n--- Data Peminjaman ---");
                    for (Peminjaman04 p : proses.dataPinjam) p.tampilPeminjaman();
                    break;
                case 4:
                    proses.selectionSortDenda();
                    System.out.println("\nData Berhasil Diurutkan (Denda Terbesar):");
                    for (Peminjaman04 p : proses.dataPinjam) p.tampilPeminjaman();
                    break;
                case 5:
                    System.out.print("Masukkan NIM Mahasiswa: ");
                    String cari = sc.next();
                    System.out.println("\nHasil Pencarian NIM " + cari + ":");
                    proses.binarySearchNIM(cari);
                    break;
            }
        } while (pilih != 0);
        
        System.out.println("Terima kasih!");
        sc.close();
    }
}