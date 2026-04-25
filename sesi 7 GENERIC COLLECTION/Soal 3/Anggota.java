public class Anggota implements Pinjam{

    private String nama;

    public Anggota(String nama){
        this.nama=nama;
    }

    @Override
    public void pinjamBuku(){

       System.out.println(
       nama+" meminjam buku"
       );

    }
}