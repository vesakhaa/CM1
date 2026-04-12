public class ProsesPeminjaman04 {
    // SEKARANG TANPA STATIC
    // Data ini akan dibuat setiap kali kita melakukan "new ProsesPeminjaman04()"
    public Mahasiswa04[] daftarMhs;
    public Buku04[] daftarBuku;
    public Peminjaman04[] dataPinjam;


    public ProsesPeminjaman04() {
        // Data Mahasiswa
        daftarMhs = new Mahasiswa04[] {
            new Mahasiswa04("22001", "Andi", "Teknik Informatika"),
            new Mahasiswa04("22002", "Budi", "Teknik Informatika"),
            new Mahasiswa04("22003", "Citra", "Sistem Informasi Bisnis")
        };

        // Data Buku
        daftarBuku = new Buku04[] {
            new Buku04("B001", "Algoritma", 2020),
            new Buku04("B002", "Basis Data", 2019),
            new Buku04("B003", "Pemrograman", 2021),
            new Buku04("B004", "Fisika", 2024)
        };

        // Data Peminjaman
        dataPinjam = new Peminjaman04[] {
            new Peminjaman04(daftarMhs[0], daftarBuku[0], 7),
            new Peminjaman04(daftarMhs[1], daftarBuku[1], 3),
            new Peminjaman04(daftarMhs[2], daftarBuku[2], 10),
            new Peminjaman04(daftarMhs[2], daftarBuku[3], 6),
            new Peminjaman04(daftarMhs[0], daftarBuku[1], 4)
        };
    }

    public void selectionSortDenda() {
        for (int i = 0; i < dataPinjam.length - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < dataPinjam.length; j++) {
                if (dataPinjam[j].denda > dataPinjam[maxIdx].denda) {
                    maxIdx = j;
                }
            }
            Peminjaman04 temp = dataPinjam[maxIdx];
            dataPinjam[maxIdx] = dataPinjam[i];
            dataPinjam[i] = temp;
        }
    }

    // Method searching (Tanpa Static)
    public void binarySearchNIM(String cariNim) {
        // selection sort berdasarkan NIM ASC
        for (int i = 0; i < dataPinjam.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < dataPinjam.length; j++) {
                if (dataPinjam[j].mhs.nim.compareTo(dataPinjam[minIdx].mhs.nim) < 0) {
                    minIdx = j;
                }
            }
            Peminjaman04 temp = dataPinjam[minIdx];
            dataPinjam[minIdx] = dataPinjam[i];
            dataPinjam[i] = temp;
        }

        // Binary Search
        int left = 0, right = dataPinjam.length - 1;
        boolean ditemukan = false;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (dataPinjam[mid].mhs.nim.equals(cariNim)) {
                System.out.println("Data ditemukan:");
                dataPinjam[mid].tampilPeminjaman();
                ditemukan = true;
                break;
            } else if (dataPinjam[mid].mhs.nim.compareTo(cariNim) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (!ditemukan) {
            System.out.println("Data dengan NIM " + cariNim + " tidak ditemukan.");
        }
    }
}