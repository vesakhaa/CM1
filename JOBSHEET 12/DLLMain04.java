import java.util.Scanner;

public class DLLMain04 {

    // Method bantuan untuk input data agar lebih rapi
    static mahasiswa04 inputMahasiswa(Scanner scan) {
        System.out.print("NIM   : "); String nim = scan.nextLine();
        System.out.print("Nama  : "); String nama = scan.nextLine();
        System.out.print("Kelas : "); String kelas = scan.nextLine();
        System.out.print("IPK   : "); double ipk = scan.nextDouble();
        scan.nextLine(); // Membersihkan buffer
        return new mahasiswa04(nim, nama, kelas, ipk);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        doubleLinkedList04 list = new doubleLinkedList04();
        int pilihan;

        do {
            System.out.println("\n===== MENU DOUBLE LINKED LIST (PRAKTIKUM) =====");
            System.out.println("1.  Tambah data di awal");
            System.out.println("2.  Tambah data di akhir");
            System.out.println("3.  Sisipkan data di tengah (setelah NIM)");
            System.out.println("4.  Hapus data di awal");
            System.out.println("5.  Hapus data di akhir");
            // System.out.println("6.  Hapus data setelah NIM");
            // System.out.println("7.  Hapus data pada Index tertentu");
            // System.out.println("8.  Tampilkan data (Awal -> Akhir)");
            // System.out.println("9.  Tampilkan data (Akhir -> Awal)");
            // System.out.println("10. Tampilkan data Pertama");
            // System.out.println("11. Tampilkan data Terakhir");
            // System.out.println("12. Tampilkan data pada Index tertentu");
            // System.out.println("13. Tampilkan jumlah data (Size)");
            System.out.println("0.  Keluar");
            System.out.print("Pilih menu: ");
            
            pilihan = scan.nextInt();
            scan.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("--- Tambah Data Awal ---");
                    list.addFirst(inputMahasiswa(scan));
                    break;
                    
                case 2:
                    System.out.println("--- Tambah Data Akhir ---");
                    list.addLast(inputMahasiswa(scan));
                    break;
                    
                case 3:
                    System.out.print("Masukkan NIM referensi (disisipkan setelah NIM ini): ");
                    String keyNim = scan.nextLine();
                    System.out.println("Masukkan data mahasiswa baru: ");
                    list.insertAfter(keyNim, inputMahasiswa(scan));
                    break;
                    
                case 4:
                    list.removeFirst();
                    break;
                    
                case 5:
                    list.removeLast();
                    break;

                case 0:
                    System.out.println("Program selesai.");
                    break;
                    
                default:
                    System.out.println("Menu tidak valid.");
            }
        } while (pilihan != 0);
        
        scan.close();
    }
}