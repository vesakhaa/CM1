import java.util.Scanner;
public class SLLMain {
   public static void main(String[] args) {
    SIngleLinkedLis04 sll = new SIngleLinkedLis04();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Tambah Data Mahasiswa ===");
        System.out.print("Masukkan Nama  : ");
        String nama = sc.nextLine();
        System.out.print("Masukkan NIM   : ");
        String nim = sc.nextLine();
        System.out.print("Masukkan Kelas : ");
        String kelas = sc.nextLine();
        System.out.print("Masukkan IPK   : ");
        double ipk = sc.nextDouble();

        Mhs04 mhsInput = new Mhs04(nama, nim, kelas, ipk);
        
        sll.addFirst(mhsInput);
        
        System.out.println("\nMenampilkan Data:");
        sll.print();
        
        sc.close();

      // SIngleLinkedLis04 sll = new SIngleLinkedLis04();
        
      //   Mhs04 mhs1 = new Mhs04("Alvaro", "24212200", "1A", 4.0);
      //   Mhs04 mhs2 = new Mhs04("Bimon", "23212201", "2B", 3.8);
      //   Mhs04 mhs3 = new Mhs04("Cintia", "22212202", "3C", 3.5);
      //   Mhs04 mhs4 = new Mhs04("Dirga", "21212203", "40", 3.6);

      //   sll.print();
      //   sll.addFirst(mhs4);
      //   sll.print();
      //   sll.addLast(mhs1);
      //   sll.print();
      //   sll.insertAfter("Dirga", mhs3);
      //   sll.insertAt(2, mhs2);
      //   sll.print();

      //   System.out.println("data index 1: ");
      //   sll.getData(1); // Mengambil data mahasiswa di indeks ke-1

      //   System.out.println("data mahasiswa an Bimon berada pada index: " + sll.indexOf("Bimon"));
      //   System.out.println();

      //   sll.removeFirst();
      //   sll.removeLast();
      //   sll.print(); // Mencetak list setelah penghapusan awal dan akhir

      //   sll.removeAt(0);
      //   sll.print(); // Mencetak list akhir
   }
}
