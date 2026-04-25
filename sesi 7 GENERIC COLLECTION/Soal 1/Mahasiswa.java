public class Mahasiswa<T, U, V> {

    private T nim;
    private U nama;
    private V clas;

    // Setter
    public void setNim(T nim) {
        this.nim = nim;
    }

    public void setNama(U nama) {
        this.nama = nama;
    }

    public void setClas(V clas) {
        this.clas = clas;
    }

    // Getter
    public T getNim() {
        return nim;
    }

    public U getNama() {
        return nama;
    }

    public V getClas() {
        return clas;
    }
}