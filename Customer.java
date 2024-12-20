import java.util.ArrayList;

public class Customer extends Akun {
    private Keranjang keranjang;
    private ArrayList<Invoice> invoiceSelesai;

    public Customer(String id) {
        super(id);
        this.keranjang = new Keranjang();
        this.invoiceSelesai = new ArrayList<>();
    }

    public Keranjang getKeranjang() {
        return keranjang;
    }

    public ArrayList<Invoice> getInvoiceSelesai() {
        return invoiceSelesai;
    }
}