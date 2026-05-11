import java.util.Scanner;

public class QueueMain04 {
    public static void main(String[] args) {
        QueueLinkedList04 antrian = new QueueLinkedList04();
        Scanner sc = new Scanner(System.in);
        int menu;

        do {
            System.out.println("\n=== SISTEM ANTRIAN UNIT KEMAHASISWAAN ===");
            System.out.println("1. Daftar Antrian Baru (Enqueue)");
            System.out.println("2. Panggil Antrian (Dequeue)");
            System.out.println("3. Cek Antrian Terdepan (Peek)");
            System.out.println("4. Lihat Semua Daftar Antrian (Print)");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            menu = sc.nextInt();
            sc.nextLine(); 

            switch (menu) {
                case 1:
                    System.out.print("NIM           : ");
                    String nim = sc.nextLine();
                    System.out.print("Nama          : ");
                    String nama = sc.nextLine();
                    System.out.print("Kelas         : ");
                    String kelas = sc.nextLine();
                    System.out.print("Jenis Kelamin : ");
                    String jk = sc.nextLine(); 

                    AntrianMhs04 mhsBaru = new AntrianMhs04(nim, nama, kelas, jk);
                    antrian.enqueue(mhsBaru);
                    break;
                case 2:
                    antrian.dequeue();
                    break;
                case 3:
                    antrian.peek();
                    break;
                case 4:
                    antrian.print();
                    break;
                case 5:
                    System.out.println("Keluar dari program layanan. Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan menu tidak valid!");
            }
        } while (menu != 5);
        
        sc.close();
    }
}