import java.io.*;
import java.util.ArrayList;

public class History {
    private ArrayList<Transaksi> riwayatTransaksi = new ArrayList<>();
    private final String FILE_NAME = "history.txt";

    public History() {
        readFromFile();
    }

    public void tambahTransaksi(Transaksi transaksi) {
        riwayatTransaksi.add(transaksi);
        writeToFile(transaksi);
    }

    public void tampilkanRiwayat() {
        if (riwayatTransaksi.isEmpty()) {
            System.out.println("Belum ada transaksi yang tercatat.");
        } else {
            for (Transaksi transaksi : riwayatTransaksi) {
                System.out.println("Transaksi ID: " + transaksi.getAkun().getId());
            }
        }
    }

    private void writeToFile(Transaksi transaksi) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write("Transaksi ID: " + transaksi.getAkun().getId());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    private void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}