public abstract class Buku {

    // atribut private (encapsulation)
    private String judul;
    private String penulis;

    public Buku(String judul,String penulis){
        this.judul=judul;
        this.penulis=penulis;
    }

    public String getJudul(){
        return judul;
    }

    public String getPenulis(){
        return penulis;
    }

    // method abstract
    public abstract void info();
}