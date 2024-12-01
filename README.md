# UAS_LabPBO
## Kelas Pembayaran

### Deskripsi
Kelas `Pembayaran` adalah kelas abstrak yang mendefinisikan struktur dasar untuk berbagai metode pembayaran. Kelas ini memiliki beberapa kelas turunan yang mengimplementasikan metode pembayaran yang berbeda.

### Kelas Turunan
1. **QRIS**: Kelas ini mengimplementasikan metode pembayaran menggunakan QRIS. Ketika metode `tampilkanMetodePembayaran()` dipanggil, ia akan mencetak "Metode Pembayaran: QRIS".
   
2. **Bank**: Kelas ini mengimplementasikan metode pembayaran melalui transfer bank. Ketika metode `tampilkanMetodePembayaran()` dipanggil, ia akan mencetak "Metode Pembayaran: Bank Transfer".
   
3. **COD**: Kelas ini mengimplementasikan metode pembayaran Cash On Delivery (COD). Ketika metode `tampilkanMetodePembayaran()` dipanggil, ia akan mencetak "Metode Pembayaran: Cash On Delivery (COD)".

### Struktur Kelas
#### 1. Pembayaran
- **id (String)**: Menyimpan ID untuk metode pembayaran.
- **tampilkanMetodePembayaran()**: Metode abstrak yang harus diimplementasikan oleh kelas turunan untuk menampilkan metode pembayaran yang digunakan.

### Kelas Transaksi
## Deskripsi Kelas
Kelas `Transaksi` menyimpan informasi penting terkait transaksi, termasuk ID transaksi, informasi pelanggan, daftar item yang dibeli, total harga, dan metode pembayaran yang digunakan.

## Fitur Utama
- **Menyimpan Informasi Transaksi:** Kelas ini menyimpan berbagai informasi yang berkaitan dengan transaksi, seperti ID unik, data pelanggan, daftar item yang dibeli, total harga, dan metode pembayaran.
- **Mencetak Invoice:** Kelas ini memiliki kemampuan untuk mencetak invoice yang berisi detail transaksi, memberikan ringkasan yang jelas kepada pelanggan.

## Struktur Kelas
### 1. Transaksi
Kelas ini berfungsi sebagai representasi dari transaksi yang dilakukan oleh pelanggan.

#### Properti
- **idTransaksi (String):** 
  Menyimpan ID unik untuk setiap transaksi, yang digunakan untuk mengidentifikasi transaksi tersebut.
  
- **customer (Customer):** 
  Objek dari kelas `Customer` yang menyimpan informasi tentang pelanggan yang melakukan transaksi, seperti nama dan email.
  
- **items (ArrayList<ItemKeranjang>):** 
  Menyimpan daftar item yang dibeli dalam transaksi. Setiap item diwakili oleh objek `ItemKeranjang`, yang berisi informasi tentang barang dan jumlah yang dibeli.
  
- **totalHarga (double):** 
  Menyimpan total harga dari semua item yang dibeli dalam transaksi, memberikan gambaran jelas tentang biaya yang harus dibayar oleh pelanggan.
  
- **metodePembayaran (String):** 
  Menyimpan metode pembayaran yang digunakan oleh pelanggan, seperti "Kartu Kredit", "Transfer Bank", atau "COD".

#### Metode
- **Transaksi(String idTransaksi, Customer customer, ArrayList<ItemKeranjang> items, double totalHarga, String metodePembayaran):** 
  Konstruktor yang digunakan untuk menginisialisasi semua atribut transaksi saat objek `Transaksi` dibuat.
  
- **getIdTransaksi():** 
  Metode ini mengembalikan ID transaksi, memungkinkan akses ke informasi ID transaksi dari luar kelas.
  
- **cetakInvoice():** 
  Metode ini mencetak invoice transaksi ke konsol, menampilkan semua informasi terkait transaksi, termasuk detail barang yang dibeli, total harga, dan metode pembayaran yang digunakan.

## Cara Penggunaan
1. **Membuat Instance Customer dan ItemKeranjang:**
   - Pertama, buat objek `Customer` untuk menyimpan informasi pelanggan dan objek `ItemKeranjang` untuk menyimpan item yang dibeli.
   
2. **Membuat Instance Transaksi:**
   - Buat objek `Transaksi` dengan memberikan ID transaksi, objek `Customer`, daftar `ItemKeranjang`, total harga, dan metode pembayaran.
   
3. **Mencetak Invoice:**
   - Panggil metode `cetakInvoice` untuk mencetak detail transaksi, memberikan ringkasan yang jelas kepada pelanggan.

## Contoh Penggunaan
Berikut adalah contoh penggunaan program yang menunjukkan bagaimana cara membuat objek `Customer`, menambahkan item ke dalam daftar `ItemKeranjang`, dan membuat objek `Transaksi`. Setelah itu, metode `cetakInvoice` dipanggil untuk menampilkan detail transaksi kepada pengguna.

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Florence Clarrine", "Flo.Clarrine@example.com");
        
        ArrayList<ItemKeranjang> items = new ArrayList<>();

        items.add(new ItemKeranjang(new Barang("PC", 35000000), 1)); // 1 unit PC
        items.add(new ItemKeranjang(new Barang("Keyboard", 3000000), 2)); // 2 unit Keyboard

        double totalHarga = 35000000 + (3000000 * 2); // Total harga = harga PC + (harga Keyboard * jumlah)

        Transaksi transaksi = new Transaksi("TRX001", customer, items, totalHarga, "Kartu Kredit");

        transaksi.cetakInvoice();
    }
}
