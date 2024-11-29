# UAS_LabPBO
# Keranjang Barang

## Deskripsi
Program ini adalah representasi dari sebuah keranjang belanja menggunakan Java. Class `Keranjang` digunakan untuk menyimpan daftar barang yang ditambahkan, menghitung total harga, dan memberikan akses ke daftar barang dalam keranjang.

## Fitur
- Menambahkan barang ke dalam keranjang.
- Mengambil daftar barang yang ada di dalam keranjang.
- Menghitung total harga barang di dalam keranjang.

## Struktur Kelas
### 1. **Keranjang**
Kelas ini adalah representasi dari keranjang belanja.

#### Properti
- **barangList**: `ArrayList<Barang>`  
  Menyimpan daftar barang yang ditambahkan ke keranjang.

#### Metode
- **Keranjang()**  
  Konstruktor untuk menginisialisasi keranjang kosong.
  
- **tambahBarang(Barang barang)**  
  Menambahkan objek `Barang` ke dalam keranjang.
  
- **getBarangList()**  
  Mengembalikan daftar barang yang ada di dalam keranjang.
  
- **totalHarga()**  
  Menghitung dan mengembalikan total harga dari semua barang di dalam keranjang.

### 2. **Barang**
Kelas ini diharapkan sudah ada sebelumnya sebagai representasi dari barang yang dimasukkan ke dalam keranjang. Harus memiliki setidaknya metode berikut:
- **getHarga()**: Mengembalikan harga barang.

## Cara Penggunaan
1. Buat instance `Keranjang`.
2. Tambahkan objek `Barang` ke dalam keranjang menggunakan metode `tambahBarang`.
3. Gunakan metode `totalHarga` untuk menghitung total harga dari barang yang ada.

### Contoh
Berikut adalah contoh penggunaan program:
```java
public class Main {
    public static void main(String[] args) {
        Keranjang keranjang = new Keranjang();

        Barang barang1 = new Barang("Laptop", 15000000);
        Barang barang2 = new Barang("Mouse", 150000);
        
        keranjang.tambahBarang(barang1);
        keranjang.tambahBarang(barang2);
        
        System.out.println("Daftar Barang:");
        for (Barang b : keranjang.getBarangList()) {
            System.out.println("- " + b.getNama() + ": Rp" + b.getHarga());
        }

        System.out.println("Total Harga: Rp" + keranjang.totalHarga());
    }
}
