public class CustomerDriver extends Driver {
    private Customer akun;
    private ListBarang barang;
    private Transaksi transaksi;

    public CustomerDriver(Customer akun, ListBarang barang) {
        this.akun = akun;
        this.barang = barang;
    }

    public Customer getAkun() {
        return akun;
    }

    // Misalkan Anda ingin menampilkan informasi barang
    public void tampilkanBarang() {
        System.out.println("Daftar Barang: ");
        for (Barang b : barang.getBarang()) {
            System.out.println(b.getNama() + " - " + b.getHarga());
        }
    }

    public void buatTransaksi() {
        transaksi = new Transaksi(akun, akun.getKeranjang().getBarang());
    }

    public Transaksi getTransaksi() {
        return transaksi;
    }
}