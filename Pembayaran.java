// Kelas Abstrak Pembayaran
abstract class Pembayaran {
    String id;

    public Pembayaran(String id) {
        this.id = id;
    }

    public abstract void tampilkanMetodePembayaran();
}

class QRIS extends Pembayaran {
    public QRIS(String id) {
        super(id);
    }

    @Override
    public void tampilkanMetodePembayaran() {
        System.out.println("Metode Pembayaran: QRIS");
    }
}

class Bank extends Pembayaran {
    public Bank(String id) {
        super(id);
    }

    @Override
    public void tampilkanMetodePembayaran() {
        System.out.println("Metode Pembayaran: Bank Transfer");
    }
}

class COD extends Pembayaran {
    public COD(String id) {
        super(id);
    }

    @Override
    public void tampilkanMetodePembayaran() {
        System.out.println("Metode Pembayaran: Cash On Delivery (COD)");
    }
}
