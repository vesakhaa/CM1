import java.util.Scanner;

public class MainKRS04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Maksimal antrian 10 sesuai instruksi soal
        QueueKRS04 antrianKRS = new QueueKRS04(10); 
        int pilihan;

        do {
            System.out.println("\n=== Layanan Persetujuan KRS ===");
            System.out.println("1. Tambah Antrian Mahasiswa");
            System.out.println("2. Panggil Antrian (Proses 2 Mahasiswa)");
            System.out.println("3. Lihat Semua Antrian");
            System.out.println("4. Lihat 2 Antrian Terdepan");
            System.out.println("5. Lihat Antrian Paling Akhir");
            System.out.println("6. Cek Info Statistik Layanan KRS");
            System.out.println("7. Kosongkan Semua Antrian");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine(); 

            switch (pilihan) {
                case 1:
                    System.out.print("NIM   : ");
                    String nim = sc.nextLine();
                    System.out.print("Nama  : ");
                    String nama = sc.nextLine();
                    System.out.print("Prodi : ");
                    String prodi = sc.nextLine();
                    System.out.print("Kelas : ");
                    String kelas = sc.nextLine();
                    Mahasiswa04 mhs = new Mahasiswa04(nim, nama, prodi, kelas);
                    antrianKRS.enqueue(mhs);
                    break;
                case 2:
                    antrianKRS.prosesKRS();
                    break;
                case 3:
                    antrianKRS.printSemua();
                    break;
                case 4:
                    antrianKRS.peekDuaTerdepan();
                    break;
                case 5:
                    antrianKRS.peekBelakang();
                    break;
                case 6:
                    antrianKRS.infoAntrian();
                    break;
                case 7:
                    antrianKRS.clear();
                    break;
                case 0:
                    System.out.println("Terima kasih.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);

        sc.close();
    }
}