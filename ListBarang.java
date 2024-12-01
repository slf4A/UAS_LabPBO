import java.io.*;
import java.util.ArrayList;

public class ListBarang {
    private ArrayList<Barang> barangList;

    public ListBarang() {
        this.barangList = new ArrayList<>();
    }

    // Menambahkan barang ke dalam list
    public void tambahBarang(Barang barang) {
        barangList.add(barang);
    }

    // Mendapatkan list barang
    public ArrayList<Barang> getBarang() {
        return barangList;
    }

    // Menyimpan informasi barang ke file
    public void saveToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            int entryNumber = getEntryCount(filePath) + 1;
            for (Barang barang : barangList) {
                writer.write(entryNumber + ". ID: " + barang.getId() + "\n");
                writer.write("   Nama: " + barang.getNama() + "\n");
                writer.write("   Harga: " + barang.getHarga() + "\n");
                writer.write("   Jumlah: " + barang.getJumlah() + "\n");  // Menyimpan jumlah barang
                writer.newLine();
                entryNumber++;
            }
            System.out.println("Data barang berhasil disimpan ke file: " + filePath);
        } catch (IOException e) {
            System.out.println("Error saving barang to file: " + e.getMessage());
        }
    }

    // Membaca informasi barang dari file
    public void loadFromFile(String filePath) {
        barangList.clear(); // Membersihkan data lama
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            String id = null, nama = null;
            double harga = 0.0;
            int jumlah = 0;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("   ID: ")) {
                    id = line.split(": ")[1].trim();
                } else if (line.startsWith("   Nama: ")) {
                    nama = line.split(": ")[1].trim();
                } else if (line.startsWith("   Harga: ")) {
                    harga = Double.parseDouble(line.split(": ")[1].trim());
                } else if (line.startsWith("   Jumlah: ")) {  // Mengambil jumlah barang
                    jumlah = Integer.parseInt(line.split(": ")[1].trim());
                    barangList.add(new Barang(id, nama, harga, jumlah));  // Menambahkan jumlah ke objek Barang
                }
            }
            System.out.println("Data barang berhasil dibaca dari file: " + filePath);
        } catch (IOException e) {
            System.out.println("Error reading barang from file: " + e.getMessage());
        }
    }

    // Menghitung jumlah entri dalam file
    private int getEntryCount(String filePath) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("1. ID: ") || line.matches("\\d+\\. ID: .*")) {
                    count++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error counting entries: " + e.getMessage());
        }
        return count;
    }

    // Validasi keberadaan barang berdasarkan ID
    public boolean validateBarangById(String filePath, String idToFind) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("ID: " + idToFind)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading barang from file: " + e.getMessage());
        }
        return false;
    }
}
