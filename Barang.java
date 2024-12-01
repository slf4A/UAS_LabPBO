public class Barang {
    private String id;
    private String nama;
    private double harga;
    private int jumlah;

    // Konstruktor dengan parameter
    public Barang(String id, String nama, double harga, int jumlah) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    // Konstruktor default
    public Barang() {
        this.id = "";
        this.nama = "";
        this.harga = 0.0;
        this.jumlah = 0;
    }

    // Getter dan Setter untuk jumlah
    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
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
}