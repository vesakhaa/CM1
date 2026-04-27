import java.util.Scanner;

public class MahasiswaDemo04 {
    public static void main(String[] args) {
        StackTugasMahasiswa stack = new StackTugasMahasiswa(5);
        Scanner sc = new Scanner(System.in);
        int pilih;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Mengumpulkan Tugas");
            System.out.println("2. Menilai Tugas");
            System.out.println("3. Melihat Tugas Teratas");
            System.out.println("4. Melihat Tugas Terbawah");
            System.out.println("5. Melihat Daftar Tugas");
            System.out.println("6. Menghitung Jumlah Tugas");
            System.out.println("7. Keluar");
            System.out.print("Pilih: ");

            pilih = sc.nextInt();
            sc.nextLine(); // Membersihkan buffer

            switch (pilih) {
                case 1:
                    System.out.print("Nama: ");
                    String nama = sc.nextLine();
                    System.out.print("NIM: ");
                    String nim = sc.nextLine();
                    System.out.print("Kelas: ");
                    String kelas = sc.nextLine();

                    // Menggunakan constructor 4 parameter sesuai class Mahasiswa04
                    Mahasiswa04 mhs = new Mahasiswa04(nim, nama, kelas, -1);
                    stack.push(mhs);
                    System.out.printf("Tugas %s berhasil dikumpulkan\n", mhs.Nama);
                    break;

                case 2:
                    Mahasiswa04 dinilai = stack.pop();
                    if (dinilai != null) {
                        System.out.println("Menilai tugas dari " + dinilai.Nama);
                        System.out.print("Masukkan nilai (0-100): ");
                        int nilai = sc.nextInt();
                        dinilai.tugasDinilai(nilai);
                        System.out.printf("Nilai Tugas %s adalah %d\n", dinilai.Nama, nilai);
                        String biner = stack.konversiDesimalKeBiner(nilai);
                        System.out.println("Nilai Biner Tugas: " + biner );
                    }
                    break;

                case 3:
                    Mahasiswa04 lihat = stack.peek();
                    if (lihat != null) {
                        System.out.println("Tugas terakhir dikumpulkan oleh " + lihat.Nama);
                    }
                    break;

                case 4:
                    stack.lihatTugasTerbawah();
                    break;

                case 5:
                    System.out.println("Daftar semua tugas");
                    System.out.println("Nama\tNIM\tKelas");
                    stack.print();
                    break;

                case 6:
                    System.out.println("Jumlah tugas yang dikumpulkan: " + stack.hitungTugas());
                    break;

                case 7:
                    System.out.println("Keluar dari program...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilih != 7);
        
        sc.close();
    }
}