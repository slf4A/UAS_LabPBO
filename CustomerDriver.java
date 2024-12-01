public class CustomerDriver extends Driver {
    private Customer akun;
    private ListBarang barang;
    private Transaksi transaksi;

    public CustomerDriver(Customer akun, ListBarang barang) {
        // Memanggil konstruktor kelas induk (Driver)
        super(akun);
        this.akun = akun;
        this.barang = barang;
    }

    @Override
    public void login() {
        // Implementasi login untuk CustomerDriver
        System.out.println("Customer " + akun.getId() + " berhasil login.");
    }

    public Customer getAkun() {
        return akun;
    }
    
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
