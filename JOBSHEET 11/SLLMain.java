public class SLLMain {
   public static void main(String[] args) {
    SIngleLinkedLis04 sll = new SIngleLinkedLis04();
        
        // Membuat empat object mahasiswa (urutan parameter: nim, nama, kelas, ipk)
         Mhs04 mhs1 = new Mhs04("Alvaro", "24212200", "1A", 4.0);
         Mhs04 mhs2 = new Mhs04("Bimon", "23212201", "2B", 3.8);
         Mhs04 mhs3 = new Mhs04("Cintia", "22212202", "3C", 3.5);
         Mhs04 mhs4 = new Mhs04("Dirga", "21212203", "40", 3.6);

        sll.print();
        sll.addFirst(mhs4);
        sll.print();
        sll.addLast(mhs1);
        sll.print();
        sll.insertAfter("Dirga", mhs3);
        sll.insertAt(2, mhs2);
        sll.print();
   }
}
