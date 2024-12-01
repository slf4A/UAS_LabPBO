public abstract class Driver {
    protected Akun akun;

    public Driver(Akun akun) {
        this.akun = akun;
    }

    // Metode abstrak login yang wajib diimplementasikan oleh kelas turunan
    public abstract void login(); {
    }
}
