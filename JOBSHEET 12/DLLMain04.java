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
            System.out.println("4.  Tambah data pada Index tertentu");
            System.out.println("5.  Hapus data di awal");
            System.out.println("6.  Hapus data di akhir");
            System.out.println("7.  Hapus data setelah NIM");
            System.out.println("8.  Hapus data pada Index tertentu");
            System.out.println("9.  Tampilkan data (Awal -> Akhir)");
            System.out.println("10. Tampilkan data (Akhir -> Awal)");
            System.out.println("11. Tampilkan data Pertama");
            System.out.println("12. Tampilkan data Terakhir");
            System.out.println("13. Tampilkan data pada Index tertentu");
            System.out.println("14. Tampilkan jumlah data (Size)");
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
                    System.out.print("Masukkan posisi Index: ");
                    int idxAdd = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Masukkan data mahasiswa baru: ");
                    list.add(idxAdd, inputMahasiswa(scan));
                    break;

                case 5:
                    list.removeFirst();
                    break;
                    
                case 6:
                    list.removeLast();
                    break;
                    
                case 7:
                    System.out.print("Masukkan NIM referensi (data SETELAH NIM ini akan dihapus): ");
                    String keyRemove = scan.nextLine();
                    list.removeAfter(keyRemove);
                    break;

                case 8:
                    System.out.print("Masukkan posisi Index yang ingin dihapus: ");
                    int idxRemove = scan.nextInt();
                    scan.nextLine();
                    list.remove(idxRemove);
                    break;

                case 9:
                    System.out.println("\n--- Daftar Mahasiswa ---");
                    list.print();
                    break;

                case 10:
                    System.out.println("\n--- Daftar Mahasiswa (Terbalik) ---");
                    list.printReverse();
                    break;

                case 11:
                    list.getFirst();
                    break;

                case 12:
                    list.getLast();
                    break;

                case 13:
                    System.out.print("Masukkan posisi Index yang ingin ditampilkan: ");
                    int idxGet = scan.nextInt();
                    scan.nextLine();
                    list.getIndex(idxGet);
                    break;

                case 14:
                    System.out.println("Total jumlah mahasiswa di dalam list: " + list.getSize());
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