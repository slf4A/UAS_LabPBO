# UAS_LabPBO
# Keranjang Barang

## Deskripsi
Program ini adalah representasi sederhana dari sebuah keranjang belanja menggunakan Java. Kelas `Keranjang` bertugas untuk menyimpan daftar barang yang ditambahkan ke keranjang. Program ini dirancang dengan struktur yang dapat dikembangkan lebih lanjut, seperti penambahan fitur untuk menghitung total harga atau menghapus barang.

---

## Fitur
1. Menambahkan barang ke dalam keranjang menggunakan metode `tambahBarang`.
2. Mengakses daftar barang yang ada di keranjang melalui metode `getBarang`.

---

## Struktur Kelas
### **1. Keranjang**
Kelas ini merepresentasikan keranjang belanja.

#### **Properti**
- `barang`: `ArrayList<Barang>`  
  Menyimpan daftar barang yang dimasukkan ke dalam keranjang.

#### **Metode**
- **`Keranjang()`**  
  Konstruktor untuk menginisialisasi keranjang kosong.

- **`tambahBarang(Barang barang)`**  
  Menambahkan objek `Barang` ke dalam keranjang.

- **`getBarang()`**  
  Mengembalikan daftar barang yang ada di dalam keranjang sebagai `ArrayList`.
