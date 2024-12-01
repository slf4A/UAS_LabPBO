import java.util.ArrayList;

class Transaksi {
    private String idTransaksi;
    private Customer customer;
    private ArrayList<ItemKeranjang> items;
    private double totalHarga;
    private Pembayaran pembayaran;  // Tipe pembayaran, bisa QRIS, Bank, atau COD

    public Transaksi(String idTransaksi, Customer customer, ArrayList<ItemKeranjang> items, 
                     double totalHarga, Pembayaran pembayaran) {
        this.idTransaksi = idTransaksi;
        this.customer = customer;
        this.items = items;
        this.totalHarga = totalHarga;
        this.pembayaran = pembayaran;
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

    public Pembayaran getPembayaran() {
        return pembayaran;
    }
    
    public void cetakInvoice() {
        System.out.println("========== Invoice ==========");
        System.out.println("ID Transaksi: " + idTransaksi);
        System.out.println("Pelanggan: " + customer.getName());
        System.out.println("==================================");
        System.out.println("Detail Barang:");

        for (ItemKeranjang item : items) {
            double itemTotal = item.getBarang().getHarga() * item.getJumlah();
            System.out.println("- " + item.getBarang().getNama() +
                               " (x" + item.getJumlah() + ") = Rp " + itemTotal);
        }

        System.out.println("----------------------------------");
        System.out.println("Total Harga: Rp " + totalHarga);
        
        pembayaran.tampilkanMetodePembayaran();
        System.out.println("==================================");
    }
}
