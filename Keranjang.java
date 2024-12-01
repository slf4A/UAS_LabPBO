import java.util.ArrayList;

public class Keranjang {
    private ArrayList<Barang> barang;

    public Keranjang() {
        this.barang = new ArrayList<>();
    }

    public void tambahBarang(Barang barang) {
        this.barang.add(barang);
    }

    public ArrayList<Barang> getBarang() {
        return barang;
    }
}
