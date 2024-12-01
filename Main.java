import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ListBarang listBarang = new ListBarang();
    private static CustomerDriver customerDriver;
    private static ArrayList<Transaksi> listTransaksi = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Menu:");
            System.out.println("[1] Registrasi");
            System.out.println("[2] Login");
            System.out.println("================");
            System.out.print("Masukkan pilihan Anda: ");
            int pilihanMenu = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (pilihanMenu) {
                case 1:
                    registrasi();
                    break;
                case 2:
                    login();
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void registrasi() {
        System.out.println("\nRegistrasi sebagai:");
        System.out.println("[1] Admin");
        System.out.println("[2] Customer");
        System.out.println("================");
        System.out.print("Masukkan pilihan Anda: ");
        int pilihanRegistrasi = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (pilihanRegistrasi) {
            case 1:
                System.out.println("\nRegistrasi Admin");
                System.out.print("Username: ");
                String username = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();
                Admin admin = new Admin(username, email, password);
                admin.saveToFile("admin.txt");
                System.out.println("Admin berhasil dibuat dan disimpan ke file.\n");
                break;

            case 2:
                System.out.println("\nRegistrasi Customer");
                System.out.print("ID: ");
                String id = scanner.nextLine();
                System.out.print("Password: ");
                String customerPassword = scanner.nextLine();
                Customer customer = new Customer(id);
                customerDriver = new CustomerDriver(customer, listBarang);
                customerDriver.getAkun().getKeranjang().tambahBarang(new Barang());
                System.out.println("Akun Customer berhasil dibuat.\n");
                break;

            default:
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
        }
    }

    private static void login() {
        System.out.println("\nLogin sebagai:");
        System.out.println("[1] Admin");
        System.out.println("[2] Customer");
        System.out.println("================");
        System.out.print("Masukkan pilihan Anda: ");
        int pilihanLogin = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (pilihanLogin) {
            case 1:
                System.out.println("\nLogin Admin:");
                System.out.print("Username: ");
                String adminUsername = scanner.nextLine();
                System.out.print("Password: ");
                String adminPassword = scanner.nextLine();

                if (Admin.validateAdminLogin("admin.txt", adminUsername, adminPassword)) {
                    System.out.println("\nSelamat datang, Admin " + adminUsername + "!");
                    menuAdmin(); // Panggil menu khusus admin jika login berhasil
                } else {
                    System.out.println("Login admin gagal. Silakan coba lagi.\n");
                }
                break;

            case 2:
                System.out.println("\nLogin Customer:");
                System.out.print("ID: ");
                String id = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();

                if (customerDriver != null && id.equals(customerDriver.getAkun().getId())) {
                    System.out.println("\nSelamat datang, " + id + "!");
                    menuCustomer();
                } else {
                    System.out.println("Login gagal. Silakan coba lagi.\n");
                }
                break;

            default:
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
        }
    }

    private static void menuAdmin() {
        while (true) {
            System.out.println("\nMenu Admin:");
            System.out.println("[1] Lihat Semua Barang");
            System.out.println("[2] Tambah Barang Baru");
            System.out.println("[3] Edit Jumlah Barang");
            System.out.println("[4] Hapus Barang");
            System.out.println("[5] Lihat Transaksi");
            System.out.println("[6] Logout");
            System.out.println("================");
            System.out.print("Masukkan pilihan Anda: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Consume newline
    
            switch (pilihan) {
                case 1:
                    System.out.println("\nDaftar Barang:");
                    for (Barang barang : listBarang.getBarang()) {
                        System.out.println(barang.getId() + " - " + barang.getNama() + " - Rp" + barang.getHarga() + " - " + barang.getJumlah() + " buah");
                    }
                    if (listBarang.getBarang().isEmpty()) {
                        System.out.println("Barang tidak ada.");
                    }
                    break;
    
                case 2:
                    System.out.println("\nTambah Barang Baru:");
                    System.out.print("ID Barang: ");
                    String idBarang = scanner.nextLine();
                    System.out.print("Nama Barang: ");
                    String namaBarang = scanner.nextLine();
                    System.out.print("Harga Barang: ");
                    double hargaBarang = scanner.nextDouble();
                    System.out.print("Jumlah Barang: ");
                    int jumlahBarang = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Barang barangBaru = new Barang(idBarang, namaBarang, hargaBarang, jumlahBarang);
                    listBarang.tambahBarang(barangBaru);
                    System.out.println("Barang berhasil ditambahkan.\n");
                    break;
        
                case 3:
                    System.out.println("\nEdit Jumlah Barang:");
                    System.out.print("Masukkan ID Barang yang ingin diedit: ");
                    String idEdit = scanner.nextLine();
                    Barang barangDiedit = null;
                    for (Barang barang : listBarang.getBarang()) {
                        if (barang.getId().equals(idEdit)) {
                            barangDiedit = barang;
                            break;
                        }
                    }
                    if (barangDiedit != null) {
                        System.out.print("Masukkan jumlah barang baru: ");
                        int jumlahBaru = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        barangDiedit.setJumlah(jumlahBaru); // Pastikan ada setter untuk jumlah barang di kelas Barang
                        System.out.println("Jumlah barang berhasil diperbarui.\n");
                    } else {
                        System.out.println("Barang dengan ID tersebut tidak ditemukan.\n");
                    }
                    break;
    
                case 4:
                    System.out.println("\nHapus Barang:");
                    System.out.print("Masukkan ID Barang yang ingin dihapus: ");
                    String idHapus = scanner.nextLine();
                    Barang barangDihapus = null;
                    for (Barang barang : listBarang.getBarang()) {
                        if (barang.getId().equals(idHapus)) {
                            barangDihapus = barang;
                            break;
                        }
                    }
                    if (barangDihapus != null) {
                        listBarang.getBarang().remove(barangDihapus);
                        System.out.println("Barang berhasil dihapus.\n");
                    } else {
                        System.out.println("Barang dengan ID tersebut tidak ditemukan.\n");
                    }
                    break;

                case 5:
                    System.out.println("\nLihat Transaksi:");
                    if (listTransaksi.isEmpty()) {
                        System.out.println("Belum ada transaksi yang dilakukan.");
                    } else {
                        for (int i = 0; i < listTransaksi.size(); i++) {
                            Transaksi transaksi = listTransaksi.get(i);
                            System.out.println("Transaksi #" + (i + 1));
                            System.out.println("Customer ID: " + transaksi.getAkun().getId());
                            for (Barang barang : transaksi.getBarang()) {
                                System.out.println("- " + barang.getNama() + " - Rp" + barang.getHarga());
                            }
                            System.out.println("-----------------------------");
                            
                            // Menambahkan pilihan untuk menyetujui atau menolak transaksi
                            System.out.print("Apakah Anda ingin menyetujui transaksi ini? (y/n): ");
                            String keputusan = scanner.nextLine().toLowerCase();
                            
                            if (keputusan.equals("y")) {
                                // Setujui transaksi
                                transaksi.setStatusPembayaran("Disetujui");
                                transaksi.getAkun().setStatusPembayaran("Selesai");  // Ubah status pembayaran akun ke "Selesai"
                                System.out.println("Transaksi disetujui.\n");
                            } else if (keputusan.equals("n")) {
                                // Tolak transaksi
                                transaksi.setStatusPembayaran("Ditolak");
                                transaksi.getAkun().setStatusPembayaran("Sedang Diproses");  // Ubah status pembayaran akun ke "Sedang Diproses"
                                System.out.println("Transaksi ditolak.\n");
                            } else {
                                System.out.println("Pilihan tidak valid. Transaksi tidak diubah.\n");
                            }
                        }
                    }
                    break;
        
                case 6:
                    System.out.println("Logout berhasil.\n");
                    return;
    
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void menuCustomer() {
        while (true) {
            System.out.println("\nMenu Customer:");
            System.out.println("[1] Tambah barang ke keranjang");
            System.out.println("[2] Edit barang di keranjang");
            System.out.println("[3] Hapus barang di keranjang");
            System.out.println("[4] Lihat Barang");
            System.out.println("[5] Lihat Keranjang");
            System.out.println("[6] Check Out");
            System.out.println("[7] Lihat Invoice");
            System.out.println("[8] Logout");
            System.out.println("================");
            System.out.print("Masukkan pilihan Anda: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (pilihan) {
                case 1:
                    System.out.println("\nTambah Barang ke Keranjang:");
                    System.out.print("ID Barang: ");
                    String idBarangCustomer = scanner.nextLine();
                    System.out.print("Nama Barang: ");
                    String namaBarangCustomer = scanner.nextLine();
                    System.out.print("Harga Barang: ");
                    double hargaBarangCustomer = scanner.nextDouble();
                    System.out.print("Jumlah Barang: ");
                    int jumlahBarangCustomer = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Barang barangBaruCustomer = new Barang(idBarangCustomer, namaBarangCustomer, hargaBarangCustomer, jumlahBarangCustomer);
                    customerDriver.getAkun().getKeranjang().tambahBarang(barangBaruCustomer);
                    System.out.println("Barang berhasil ditambahkan ke keranjang.\n");
                    break;

                case 2:
                    System.out.println("\nDaftar Barang di Keranjang:");
                    // Menampilkan semua barang yang ada di keranjang
                    if (customerDriver.getAkun().getKeranjang().getBarang().isEmpty()) {
                        System.out.println("Keranjang Anda kosong.\n");
                    } else {
                        int index = 1;
                        for (Barang barang : customerDriver.getAkun().getKeranjang().getBarang()) {
                            System.out.println(index + ". " + barang.getNama() + " - ID: " + barang.getId() +
                                            " - Harga: " + barang.getHarga() + " - Jumlah: " + barang.getJumlah());
                            index++;
                        }
                        System.out.print("\nMasukkan nomor barang yang ingin diedit jumlahnya: ");
                        int pilihanBarang = scanner.nextInt();
                        scanner.nextLine(); // Menangani newline karakter setelah input angka
                        
                        // Memastikan input nomor barang valid
                        if (pilihanBarang < 1 || pilihanBarang > customerDriver.getAkun().getKeranjang().getBarang().size()) {
                            System.out.println("Pilihan tidak valid.\n");
                        } else {
                            Barang barangYangDipilih = customerDriver.getAkun().getKeranjang().getBarang().get(pilihanBarang - 1);
                            System.out.print("Masukkan jumlah baru untuk " + barangYangDipilih.getNama() + ": ");
                            int jumlahBaru = scanner.nextInt();
                            scanner.nextLine(); // Menangani newline karakter setelah input angka
                            
                            // Memastikan jumlah baru valid
                            if (jumlahBaru > 0) {
                                barangYangDipilih.setJumlah(jumlahBaru);
                                System.out.println("Jumlah barang " + barangYangDipilih.getNama() + " berhasil diperbarui.\n");
                            } else {
                                System.out.println("Jumlah barang tidak valid.\n");
                            }
                        }
                    }
                    break;

                case 3:
                    System.out.println("\nHapus Barang di Keranjang:");
                    System.out.print("Masukkan ID Barang yang ingin dihapus: ");
                    String idBarangHapus = scanner.nextLine();

                    // Mencari barang di keranjang berdasarkan ID
                    Barang barangDihapusCustomer = null;
                    for (Barang barang : customerDriver.getAkun().getKeranjang().getBarang()) {
                        if (barang.getId().equals(idBarangHapus)) {
                            barangDihapusCustomer = barang;
                            break;
                        }
                    }

                    // Jika barang ditemukan, hapus dari keranjang
                    if (barangDihapusCustomer != null) {
                        customerDriver.getAkun().getKeranjang().getBarang().remove(barangDihapusCustomer);
                        System.out.println("Barang berhasil dihapus dari keranjang.\n");
                    } else {
                        System.out.println("Barang dengan ID tersebut tidak ditemukan di keranjang.\n");
                    }
                    break;

                case 4:
                    System.out.println("\nDaftar Barang:");
                    for (Barang barang : listBarang.getBarang()) {
                        System.out.println(barang.getId() + " - " + barang.getNama() + " - Rp" + barang.getHarga() + " - " + barang.getJumlah() + " buah");
                    }
                    if (listBarang.getBarang().isEmpty()) {
                        System.out.println("Barang tidak ada.");
                    }
                    break;

                case 5:
                    System.out.println("\nIsi Keranjang:");
                    for (Barang barang : customerDriver.getAkun().getKeranjang().getBarang()) {
                        System.out.println(barang.getId() + " - " + barang.getNama() + " - Rp" + barang.getHarga() + " - " + barang.getJumlah() + " buah");
                    }
                    if (customerDriver.getAkun().getKeranjang().getBarang().isEmpty()) {
                        System.out.println("Keranjang Anda kosong.");
                    }
                    break;

                case 6:
                    System.out.println("\nCheckout:");
                
                    ArrayList<Barang> barangKeranjang = customerDriver.getAkun().getKeranjang().getBarang();
                    if (barangKeranjang.isEmpty()) {
                        System.out.println("Keranjang kosong. Tidak ada yang bisa di-checkout.\n");
                    } else {
                        // Menampilkan barang di keranjang
                        System.out.println("Barang yang ada di keranjang Anda:");
                        for (int i = 0; i < barangKeranjang.size(); i++) {
                            Barang barang = barangKeranjang.get(i);
                            System.out.println((i + 1) + ". " + barang.getNama() + " - Rp" + barang.getHarga() + " (Stok: " + barang.getJumlah() + ")");
                        }
                
                        // Meminta input nomor barang dan jumlah
                        System.out.print("\nMasukkan nomor barang yang ingin Anda checkout: ");
                        int idBarang = scanner.nextInt();
                        scanner.nextLine();  // Menangani newline karakter setelah input angka
                
                        if (idBarang < 1 || idBarang > barangKeranjang.size()) {
                            System.out.println("Nomor barang tidak valid.\n");
                            break;
                        }
                
                        Barang barangYangDipilih = barangKeranjang.get(idBarang - 1);
                
                        System.out.print("Masukkan jumlah barang yang ingin Anda checkout: ");
                        int jumlahYangDipilih = scanner.nextInt();
                        scanner.nextLine(); // Menangani newline karakter
                
                        // Mengecek apakah jumlah yang diminta melebihi stok
                        if (jumlahYangDipilih > barangYangDipilih.getJumlah()) {
                            System.out.println("Jumlah yang ingin Anda checkout melebihi jumlah barang di keranjang.\n");
                        } else {
                            // Menanyakan apakah ingin melanjutkan ke pembayaran
                            System.out.println("\nApakah Anda ingin melanjutkan ke pembayaran?");
                            System.out.println("[1] Ya");
                            System.out.println("[2] Tidak");
                
                            System.out.print("Masukkan pilihan Anda: ");
                            int pilihanPembayaran = scanner.nextInt();
                            scanner.nextLine(); // Menangani newline karakter setelah input angka
                
                            if (pilihanPembayaran == 2) {
                                System.out.println("Checkout batal. Kembali ke menu utama.\n");
                                break;
                            } else if (pilihanPembayaran == 1) {
                                // Menampilkan metode pembayaran
                                System.out.println("\nPilih metode pembayaran:");
                                System.out.println("1. Qris");
                                System.out.println("2. Bank");
                                System.out.println("3. COD");
                
                                System.out.print("Masukkan pilihan Anda: ");
                                int metodePembayaran = scanner.nextInt();
                                scanner.nextLine(); // Menangani newline karakter
                
                                System.out.print("Masukkan nominal yang ingin Anda bayarkan: ");
                                double nominalPembayaran = scanner.nextDouble();
                                scanner.nextLine(); // Menangani newline karakter
                
                                // Mengecek apakah pembayaran sesuai dengan total harga barang yang dipilih
                                double totalHarga = barangYangDipilih.getHarga() * jumlahYangDipilih;
                
                                if (nominalPembayaran >= totalHarga) {
                                    double kembalian = nominalPembayaran - totalHarga;
                                    System.out.println("Pembayaran berhasil! Kembalian Anda: Rp" + kembalian);
                
                                    // Proses checkout: buat transaksi baru
                                    ArrayList<Barang> barangCheckout = new ArrayList<>();
                                    barangCheckout.add(new Barang(barangYangDipilih.getId(), barangYangDipilih.getNama(), barangYangDipilih.getHarga(), jumlahYangDipilih));
                
                                    Transaksi transaksi = new Transaksi(customerDriver.getAkun(), barangCheckout);
                                    listTransaksi.add(transaksi);
                
                                    // Tampilkan invoice
                                    transaksi.cetakInvoice();
                
                                    // Simpan ke file
                                    transaksi.simpanKeFile("transaksi.txt");
                
                                    // Update jumlah barang yang ada di keranjang
                                    barangYangDipilih.setJumlah(barangYangDipilih.getJumlah() - jumlahYangDipilih);
                
                                    // Kosongkan keranjang jika sudah dibayar
                                    if (barangYangDipilih.getJumlah() == 0) {
                                        customerDriver.getAkun().getKeranjang().getBarang().remove(barangYangDipilih);
                                    }
                
                                    System.out.println("Checkout berhasil. Keranjang Anda telah diperbarui.\n");
                                } else {
                                    System.out.println("Nominal yang Anda bayarkan tidak cukup.\n");
                                }
                            } else {
                                System.out.println("Pilihan tidak valid.\n");
                            }
                        }
                    }
                    break;

                case 7:
                    // Lihat Invoice
                    System.out.println("\nLihat Invoice:");
                    System.out.println("Status pembayaran: " + customerDriver.getAkun().getStatusPembayaran());
                    
                    if (customerDriver.getAkun().getStatusPembayaran().equals("Selesai")) {
                        System.out.println("Pembayaran telah disetujui dan transaksi selesai.");
                    } else if (customerDriver.getAkun().getStatusPembayaran().equals("Sedang Diproses")) {
                        System.out.println("Pembayaran Anda sedang diproses. Mohon tunggu.");
                    } else if (customerDriver.getAkun().getStatusPembayaran().equals("Ditolak")) {
                        System.out.println("Pembayaran Anda telah ditolak.");
                    }
                    break;
            
    
                case 8:
                    System.out.println("Logout berhasil.\n");
                    return;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}