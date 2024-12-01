import java.util.ArrayList;

abstract class Driver {
}
 
public class AdminDriver extends Driver {
  private Admin akun;
  private ListBarang istBarang;
  private ArrayList<Transaksi> istTransaksi;

  public AdminDriver(Admin akun, ListBarang istBarang) {
      this.akun = akun;
      this.istBarang = istBarang;
      this.istTransaksi = new ArrayList<>(); 
  }

  public Admin getAkun() {
      return akun;
  }

  public void setAkun(Admin akun) {
      this.akun = akun;
  }

  public ListBarang getIstBarang() {
      return istBarang;
  }

  public void setIstBarang(ListBarang istBarang) {
      this.istBarang = istBarang;
  }

  public ArrayList<Transaksi> getIstTransaksi() {
      return istTransaksi;
  }

  public void addTransaksi(Transaksi transaksi) {
      this.istTransaksi.add(transaksi);
  }
}