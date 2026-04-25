import java.util.ArrayList;

// generic class
public class Rak<T>{

    ArrayList<T> daftar =
      new ArrayList<>();

    public void tambah(T item){
        daftar.add(item);
    }

    public void tampil(){

       for(T x : daftar){
           System.out.println(x);
       }

    }
}