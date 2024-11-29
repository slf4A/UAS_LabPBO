import java.util.ArrayList;

public class Transaksi {
    private String idTransaksi;
    private Customer customer;
    private ArrayList<ItemKeranjang> items;
    private double totalHarga;
    private String metodePembayaran;

    public Transaksi(String idTransaksi, Customer customer, ArrayList<ItemKeranjang> items,
                     double totalHarga, String metodePembayaran) {
        this.idTransaksi = idTransaksi;
        this.customer = customer;
        this.items = items;
        this.totalHarga = totalHarga;
        this.metodePembayaran = metodePembayaran;
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<ItemKeranjang> getItems() {
        return items;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public void cetakInvoice() {
        System.out.println("=== Invoice Transaksi ===");
        System.out.println("ID Transaksi: " + idTransaksi);
        System.out.println("Pelanggan: " + customer.getName());
        System.out.println("Daftar Barang:");
        for (ItemKeranjang item : items) {
            System.out.println("- " + item.getBarang().getNama() + " (Jumlah: " + item.getJumlah() + ") - Harga: " + item.getBarang().getHarga());
        }
        System.out.println("Total Harga: " + totalHarga);
        System.out.println("Metode Pembayaran: " + metodePembayaran);
        System.out.println("=========================");
    }
}