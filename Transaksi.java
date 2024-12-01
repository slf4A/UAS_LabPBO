import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Transaksi {
    private Customer akun;
    private ArrayList<Barang> barang;
    private String statusPembayaran;

    public Transaksi(Customer akun, ArrayList<Barang> barang) {
        this.akun = akun;
        this.barang = barang;
        this.statusPembayaran = "Sedang Diproses";  // Default status
    }

    public Customer getAkun() {
        return akun;
    }

    public ArrayList<Barang> getBarang() {
        return barang;
    }

    public String getStatusPembayaran() {
        return statusPembayaran;
    }

    public void setStatusPembayaran(String statusPembayaran) {
        this.statusPembayaran = statusPembayaran;
    }

    public void cetakInvoice() {
        System.out.println("Transaksi untuk: " + akun.getId());
        for (Barang barang : barang) {
            System.out.println(barang.getNama() + " - Rp" + barang.getHarga());
        }
    }

    public void simpanKeFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("Transaksi untuk: " + akun.getId());
            writer.newLine();
            for (Barang barang : barang) {
                writer.write(barang.getNama() + " - Rp" + barang.getHarga());
                writer.newLine();
            }
            writer.write("=======================================");
            writer.newLine();
            System.out.println("Transaksi berhasil disimpan ke file: " + fileName);
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan transaksi ke file: " + e.getMessage());
        }
    }
}
