import java.util.ArrayList;

public class Transaksi {
    private String idTransaksi;
    private Customer customer;
    private ArrayList<ItemKeranjang> items;
    private double totalHarga;
    private String metodePembayaran;

    public Transaksi(String idTransaksi, Customer customer, ArrayList<ItemKeranjang> items, double totalHarga, String metodePembayaran) {
        this.idTransaksi = idTransaksi;
        this.customer = customer;
        this.items = items;
        this.totalHarga = totalHarga;
        this.metodePembayaran = metodePembayaran;
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }
    
    public void cetakInvoice() {
        System.out.println("========== Invoice ==========");
        System.out.println("ID Transaksi: " + idTransaksi);
        System.out.println("Nama Customer: " + customer.getName());
        System.out.println("Email Customer: " + customer.getName());
        System.out.println("==================================");
        System.out.println("Detail Barang:");
        for (ItemKeranjang item : items) {
            System.out.println("- " + item.getBarang().getNama() + 
                               " (x" + item.getJumlah() + ") = " + 
                               (item.getBarang().getHarga() * item.getJumlah()));
        }
        System.out.println("----------------------------------");
        System.out.println("Total Harga: Rp " + totalHarga);
        System.out.println("Metode Pembayaran: " + metodePembayaran);
        System.out.println("==================================");
    }
}
