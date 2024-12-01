public class Barang {
    private String id;
    private String nama;
    private double harga;
    private int stok;

    public Barang(String id, String nama, double harga, int stok) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}

class BarangList {
    private ArrayList<Barang> listBarang = new ArrayList<>();

    public void tambahBarang(Barang barang) {
        listBarang.add(barang);
    }

    public void tampilkanBarang() {
        for (Barang barang : listBarang) {
            System.out.println("ID: " + barang.getId() + ", Nama: " + barang.getNama() +
                               ", Harga: " + barang.getHarga() + ", Stok: " + barang.getStok());
        }
    }

    public Barang cariBarang(String id) {
        for (Barang barang : listBarang) {
            if (barang.getId().equals(id)) {
                return barang;
            }
        }
        return null; // Tidak ditemukan
    }
}
