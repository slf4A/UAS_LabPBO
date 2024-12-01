class Transaksi {
    Customer akun;
    ArrayList<Barang> barang;

    public Transaksi(Customer akun, ArrayList<Barang> barang) {
        this.akun = akun;
        this.barang = barang;
    }
}
class Invoice {
    Transaksi transaksi;
    Pembayaran pembayaran;

    public Invoice(Transaksi transaksi, Pembayaran pembayaran) {
        this.transaksi = transaksi;
        this.pembayaran = pembayaran;
    }
}
abstract class Pembayaran {
    String id;

    public Pembayaran(String id) {
        this.id = id;
    }
}

class QRIS extends Pembayaran {
    public QRIS(String id) {
        super(id);
    }
}

class Bank extends Pembayaran {
    public Bank(String id) {
        super(id);
    }
}

class COD extends Pembayaran {
    public COD(String id) {
        super(id);
    }
}
