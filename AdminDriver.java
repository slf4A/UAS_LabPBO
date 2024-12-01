import java.util.ArrayList;

abstract class Driver {
}
 
public class AdminDriver extends Driver {
  private Admin akun;
  private ListBarang istBarang;
  private ArrayList<Transaksi> istTransaksi;

  // Constructor
  public AdminDriver(Admin akun, ListBarang istBarang) {
      this.akun = akun;
      this.istBarang = istBarang;
      this.istTransaksi = new ArrayList<>(); // Initialize the transaction list
  }

  // Getter for akun
  public Admin getAkun() {
      return akun;
  }

  // Setter for akun
  public void setAkun(Admin akun) {
      this.akun = akun;
  }

  // Getter for istBarang
  public ListBarang getIstBarang() {
      return istBarang;
  }

  // Setter for istBarang
  public void setIstBarang(ListBarang istBarang) {
      this.istBarang = istBarang;
  }

  // Getter for istTransaksi
  public ArrayList<Transaksi> getIstTransaksi() {
      return istTransaksi;
  }

  // Method to add a transaction
  public void addTransaksi(Transaksi transaksi) {
      this.istTransaksi.add(transaksi);
  }
}