public class BukuFiksi extends Buku{

    // inheritance
    public BukuFiksi(
      String judul,
      String penulis){

      super(judul,penulis);
    }

    @Override
    public void info(){

      System.out.println(
       "Buku : "+getJudul()+
       " | Penulis : "+getPenulis()
      );
    }
}