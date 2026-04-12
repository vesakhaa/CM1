public class ProsesPeminjaman04 {

    // Implementasi Selection Sort - Denda Terbesar (Descending)
    public void selectionSortDenda(Peminjaman04[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j].denda > data[maxIdx].denda) {
                    maxIdx = j;
                }
            }
            Peminjaman04 temp = data[maxIdx];
            data[maxIdx] = data[i];
            data[i] = temp;
        }
    }

    // Implementasi Binary Search berdasarkan NIM
    public void binarySearchNIM(Peminjaman04[] data, String cariNim) {
        // Sort NIM terlebih dahulu (syarat Binary Search) menggunakan Selection Sort
        for (int i = 0; i < data.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j].mhs.nim.compareTo(data[minIdx].mhs.nim) < 0) {
                    minIdx = j;
                }
            }
            Peminjaman04 temp = data[minIdx];
            data[minIdx] = data[i];
            data[i] = temp;
        }

        int low = 0, high = data.length - 1;
        boolean ditemukan = false;

        while (low <= high) {
            int mid = (low + high) / 2;
            int res = cariNim.compareTo(data[mid].mhs.nim);

            if (res == 0) {
                // Cari ke kiri dan kanan untuk menangani NIM yang sama (pinjam > 1 buku)
                cetakSemuaHasil(data, mid, cariNim);
                ditemukan = true;
                break;
            } else if (res > 0) low = mid + 1;
            else high = mid - 1;
        }
        if (!ditemukan) System.out.println("Data NIM " + cariNim + " tidak ditemukan.");
    }

    private void cetakSemuaHasil(Peminjaman04[] data, int mid, String nim) {
        int left = mid;
        while (left >= 0 && data[left].mhs.nim.equals(nim)) {
            data[left].tampilPeminjaman();
            left--;
        }
        int right = mid + 1;
        while (right < data.length && data[right].mhs.nim.equals(nim)) {
            data[right].tampilPeminjaman();
            right++;
        }
    }
}