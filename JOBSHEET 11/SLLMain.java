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
   }
}
