public class Main {

    public static void main(String[] args) {

        Mahasiswa<String,String,Integer> m = new Mahasiswa<>();

        m.setNim("2301");
        m.setNama("Fredi");
        m.setClas(21);

        System.out.println(m.getNim());
        System.out.println(m.getNama());
        System.out.println(m.getClas());
    }

}