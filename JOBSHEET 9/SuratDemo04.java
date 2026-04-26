import java.util.Scanner;

public class SuratDemo04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan kapasitas stack surat: ");
        int kapasitas = sc.nextInt();
        sc.nextLine();

        StackSurat04 tumpukan = new StackSurat04(kapasitas);
        int pilih;

        do {
            System.out.println("\nMenu Manajemen Surat Izin:");
            System.out.println("1. Terima Surat Izin");
            System.out.println("2. Proses Surat Izin");
            System.out.println("3. Lihat Surat Izin Terakhir");
            System.out.println("4. Cari Surat");
            System.out.println("5. Keluar");
            System.out.print("Pilih: ");
            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("ID Surat: ");
                    String id = sc.nextLine();
                    System.out.print("Nama Mahasiswa: ");
                    String nama = sc.nextLine();
                    System.out.print("Kelas: ");
                    String kelas = sc.nextLine();
                    System.out.print("Jenis Izin (S/I): ");
                    char jenis = sc.next().charAt(0);
                    System.out.print("Durasi (hari): ");
                    int durasi = sc.nextInt();
                    
                    Surat04 s = new Surat04(id, nama, kelas, jenis, durasi);
                    tumpukan.push(s);
                    break;

                case 2:
                    Surat04 diproses = tumpukan.pop();
                    if (diproses != null) {
                        System.out.println("Surat dari " + diproses.namaMahasiswa + " telah diproses.");
                    }
                    break;

                case 3:
                    Surat04 terakhir = tumpukan.peek();
                    if (terakhir != null) {
                        System.out.println("Surat teratas: " + terakhir.idSurat + " - " + terakhir.namaMahasiswa);
                    }
                    break;

                case 4:
                    System.out.print("Masukkan nama mahasiswa yang dicari: ");
                    String cariNama = sc.nextLine();
                    tumpukan.cariSurat(cariNama);
                    break;

                case 5:
                    System.out.println("Selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilih != 5);
        
        sc.close();
    }
}