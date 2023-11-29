package Pertemuan7;

import java.util.Scanner;

public class TokoSerbaAda {
    public static void main(String[] args) {
        // Inisialisasi Nama Barang dan Harga Berdasarkan Kode Barang
        String[] namaBarang = {"Buku", "Pensil", "Pulpen", "Penggaris", "Karton"};
        int[] hargaBarang = {3000, 4000, 5000, 6000, 2000};

        Scanner input = new Scanner(System.in);

        // Input Jumlah Barang yang akan dibeli
        System.out.print("Masukkan jumlah barang yang akan dibeli: ");
        int jumlahBeli = input.nextInt();

        // Inisialisasi array untuk menyimpan input
        String[] kodeBarang = new String[jumlahBeli];
        int[] jumlahBeliArray = new int[jumlahBeli];

        // Input data barang
        for (int i = 0; i < jumlahBeli; i++) {
            System.out.println("Data barang ke-" + (i + 1));
            System.out.print("Masukkan kode barang (1-5): ");
            kodeBarang[i] = input.next();

            // Validasi kode barang
            while (!isValidKodeBarang(kodeBarang[i])) {
                System.out.println("Kode barang tidak valid. Masukkan ulang.");
                System.out.print("Masukkan kode barang (1-5): ");
                kodeBarang[i] = input.next();
            }

            System.out.print("Masukkan jumlah beli: ");
            jumlahBeliArray[i] = input.nextInt();
        }

        // Menampilkan output
        System.out.println("\n Toko Serba Ada ");
        System.out.println("\n**********************");
        System.out.println("No   Kode Barang   Nama Barang   Harga    Jumlah Beli   Jumlah Bayar");

        int JumlahBayar = 0;

        for (int i = 0; i < jumlahBeli; i++) {
            int index = Integer.parseInt(kodeBarang[i]) - 1;
            int totalHargaBarang = hargaBarang[index] * jumlahBeliArray[i];
            JumlahBayar += totalHargaBarang;

            System.out.println("==========================================================================");
            System.out.printf("%-5d%-14s%-14s%-14d%-13d%-13d1\n", (i + 1), kodeBarang[i], namaBarang[index], hargaBarang[index], jumlahBeliArray[i], totalHargaBarang);
        }
        System.out.println("==========================================================================");
        System.out.println("\nTotal Harga: " + JumlahBayar);
        System.out.println("==========================================================================");
    }

    // Validasi kode barang (hanya 1-5)
    static boolean isValidKodeBarang(String kode) {
        int kodeInt;
        try {
            kodeInt = Integer.parseInt(kode);
        } catch (NumberFormatException e) {
            return false;
        }
        return kodeInt >= 1 && kodeInt <= 5;
    }
}
