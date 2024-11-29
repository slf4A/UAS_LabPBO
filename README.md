# UAS_LabPBO
# Kelas Transaksi

## Deskripsi
Kelas `Transaksi` adalah bagian dari sistem penjualan yang digunakan untuk merepresentasikan transaksi yang dilakukan oleh pelanggan. Kelas ini menyimpan informasi terkait transaksi, termasuk ID transaksi, informasi pelanggan, daftar item yang dibeli, total harga, dan metode pembayaran.

## Fitur
- Menyimpan informasi transaksi seperti ID, pelanggan, daftar item, total harga, dan metode pembayaran.
- Mencetak invoice transaksi yang berisi detail transaksi.

## Struktur Kelas
### 1. **Transaksi**
Kelas ini adalah representasi dari transaksi yang dilakukan oleh pelanggan.

#### Properti
- **idTransaksi**: `String`  
  Menyimpan ID unik untuk setiap transaksi.
  
- **customer**: `Customer`  
  Objek dari kelas `Customer` yang menyimpan informasi pelanggan yang melakukan transaksi.
  
- **items**: `ArrayList<ItemKeranjang>`  
  Menyimpan daftar item yang dibeli dalam transaksi.
  
- **totalHarga**: `double`  
  Menyimpan total harga dari semua item yang dibeli.
  
- **metodePembayaran**: `String`  
  Menyimpan metode pembayaran yang digunakan oleh pelanggan.

#### Metode
- **Transaksi(String idTransaksi, Customer customer, ArrayList<ItemKeranjang> items, double totalHarga, String metodePembayaran)**  
  Konstruktor untuk menginisialisasi semua atribut transaksi.
  
- **getIdTransaksi()**  
  Mengembalikan ID transaksi.
  
- **cetakInvoice()**  
  Mencetak invoice transaksi ke konsol, menampilkan semua informasi terkait transaksi, termasuk detail barang yang dibeli, total harga, dan metode pembayaran.

## Cara Penggunaan
1. Buat instance `Customer` dan `ItemKeranjang`.
2. Buat instance `Transaksi` dengan memberikan ID transaksi, objek `Customer`, daftar `ItemKeranjang`, total harga, dan metode pembayaran.
3. Panggil metode `cetakInvoice` untuk mencetak detail transaksi.

### Contoh
Berikut adalah contoh penggunaan program:
```java
public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Florence Clarrine", "Flo.Clarrine@example.com");
        ArrayList<ItemKeranjang> items = new ArrayList<>();
        items.add(new ItemKeranjang(new Barang("PC", 35000000), 1));
        items.add(new ItemKeranjang(new Barang("Keyboard", 3000000), 2));

        Transaksi transaksi = new Transaksi("TRX001", customer, items, 38000000, "Kartu Kredit");
        transaksi.cetakInvoice();
    }
}
