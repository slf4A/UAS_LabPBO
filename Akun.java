public class Akun {
    private String id;
    private String statusPembayaran;

    // Constructor
    public Akun(String id) {
        this.id = id;
        this.statusPembayaran = "Sedang Diproses"; //default status

    }

    // Getter for id
    public String getId() {
        return id;
    }

    // Setter for id
    public void setId(String id) {
        this.id = id;
    }

    public String getStatusPembayaran() {
        return statusPembayaran;
    }

    public void setStatusPembayaran(String statusPembayaran) {
        this.statusPembayaran = statusPembayaran;
    }
}