class Bank {

    // Method hitung biaya transfer (default)
    int biayaTransfer(String bankTujuan) {
        if (bankTujuan.equalsIgnoreCase("BNI")) {
            return 3000;
        } else if (bankTujuan.equalsIgnoreCase("BCA")) {
            return 5000;
        } else {
            return 7000; // bank lain
        }
    }

    // Overloading 1
    void transferUang(int jumlah, String rekeningTujuan) {
        System.out.println("Transfer ke " + rekeningTujuan + " sebesar " + jumlah);
    }

    // Overloading 2 (pakai biaya)
    void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        int biaya = biayaTransfer(bankTujuan);
        System.out.println("Transfer ke " + rekeningTujuan + " (" + bankTujuan + ")");
        System.out.println("Jumlah : " + jumlah);
        System.out.println("Biaya  : " + biaya);
        System.out.println("Total  : " + (jumlah + biaya));
    }

    // Overloading 3
    void transferUang(int jumlah, String rekeningTujuan, String bankTujuan, String berita) {
        int biaya = biayaTransfer(bankTujuan);
        System.out.println("Transfer ke " + rekeningTujuan + " (" + bankTujuan + ")");
        System.out.println("Jumlah : " + jumlah);
        System.out.println("Biaya  : " + biaya);
        System.out.println("Total  : " + (jumlah + biaya));
        System.out.println("Berita : " + berita);
    }

    double sukuBunga() {
        return 3.0;
    }
}

class BankBNI extends Bank {

    @Override
    double sukuBunga() {
        return 4.0;
    }

    @Override
    int biayaTransfer(String bankTujuan) {
        return 3000; // khusus BNI
    }

    @Override
    void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        int biaya = biayaTransfer(bankTujuan);
        System.out.println("[BNI] Transfer ke " + rekeningTujuan);
        System.out.println("Jumlah : " + jumlah);
        System.out.println("Biaya  : " + biaya);
        System.out.println("Total  : " + (jumlah + biaya));
    }
}

class BankBCA extends Bank {

    @Override
    double sukuBunga() {
        return 4.5;
    }

    @Override
    int biayaTransfer(String bankTujuan) {
        return 5000; // khusus BCA
    }

    @Override
    void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        int biaya = biayaTransfer(bankTujuan);
        System.out.println("[BCA] Transfer ke " + rekeningTujuan);
        System.out.println("Jumlah : " + jumlah);
        System.out.println("Biaya  : " + biaya);
        System.out.println("Total  : " + (jumlah + biaya));
    }
}

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();
        BankBNI bni = new BankBNI();
        BankBCA bca = new BankBCA();

        System.out.println("=== OVERLOADING + BIAYA ===");
        bank.transferUang(100000, "123456");
        bank.transferUang(200000, "123456", "BNI");
        bank.transferUang(300000, "123456", "BCA", "Bayar Kuliah");

        System.out.println("\n=== OVERRIDING + BIAYA ===");
        bni.transferUang(500000, "987654", "BNI");
        bca.transferUang(750000, "987654", "BCA");

        System.out.println("\n=== SUKU BUNGA ===");
        System.out.println("Bank   : " + bank.sukuBunga() + "%");
        System.out.println("BNI    : " + bni.sukuBunga() + "%");
        System.out.println("BCA    : " + bca.sukuBunga() + "%");
    }
}