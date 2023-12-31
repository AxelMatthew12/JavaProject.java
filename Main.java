import java.util.Scanner;

public class Main {
    static final String MANAJER = "MANAJER";
    static final String KASIR = "KASIR";
    static final String KELUAR = "KELUAR";

    public static void main(String[] args) {
        login();
    }

    static void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===== SELAMAT DATANG ======");
        System.out.println("==     LOGIN SEBAGAI?    ==");
        System.out.println("=         MANAJER         =");
        System.out.println("=         KASIR           =");
        System.out.println("=         KELUAR          =");
        System.out.println("===========================");
        System.out.println("=== MASUKKAN PILIHAN =====");
        String pilih = scanner.nextLine();

        if (pilih.equalsIgnoreCase(MANAJER)) {
            manajer();
        } else if (pilih.equalsIgnoreCase(KASIR)) {
            kasier();
        } else if (pilih.equalsIgnoreCase(KELUAR)) {
            System.out.println("== ANDA KELUAR DARI PROGRAM! ==");
        } else {
            System.out.println("Eror 404: Pilihan tidak valid");
        }
    }
    static void kasier(){
    Scanner input= new Scanner(System.in);
    String pencatatanpesanan="PENCATATAN PESANAN";
    String melihatstok="PROSES TRANSAKSI";
    String laporanpendapatan="LAPORAN PENDAPATAN";
    System.out.println("============= WELCOME ==============");
    System.out.println("==                                ==");
    System.out.println("==                                ==");
    System.out.println("         PENCATATAN PESANAN         ");
    System.out.println("            MELIHAT STOK            ");
    System.out.println("          PROSES TRANSAKSI          ");
    System.out.println("======  LAPORKAN PENDAPATAN  ====== ");
    String pilihankasir= input.nextLine();

    if (pilihankasir.equals(pencatatanpesanan)) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("====== SELAAMT DATANG DI KANTIN SEHAT ======");
        System.out.println("====               MENU                 ====");
        System.out.println("         1. NASI GORENG SEHAT               ");
        System.out.println("         2. SOTO BENING                     ");
        System.out.println("         3. RAWON                           ");
        System.out.println("         4. BUBUR AYAM                      ");
        System.out.println("         5. SUP SAYUR                       ");
        System.out.println("                MINUMAN                     ");
        System.out.println("         1. AIR PUTIH AQUA                  ");
        System.out.println("         2. AIR HANGAT                      ");
        System.out.println("         3. TEH HANGAT                      ");
        System.out.println("         4. ES TEH                          ");
        System.out.println("         5. ES JERUK                        ");
        System.out.println(" SILAHKAN MASUKKAN PESANAN ANDA:            ");
        int Pesanan= scanner.nextInt();

        switch (Pesanan) {
            case 1:
            System.out.println("NASI GORENG SEHAT");
            break;
        
            case 2:
            System.out.println("SOTO BENING");
            break;
            case 3:
            System.out.println(" RAWON");
        }
    }


    }

    static void manajer() {
        Scanner scanner = new Scanner(System.in);
        String password = "admin123";
        String id = "admin123";

        System.out.println("======Anda masuk sebagai MANAJER====  ");
        System.out.println("     =====Masukkan ID Anda=====       ");
        String idanda = scanner.nextLine();
        System.out.println("             Password             ");
        String passwordanda = scanner.nextLine();

        if (idanda.equals(id) && passwordanda.equals(password)) {
            System.out.println("ANDA BERHASIL MASUK");
            StokBarang stokBarang = new StokBarang();
            stokBarang.start();
        } else {
            System.out.println("Mohon maaf ID/password Anda tidak sesuai");
        }
    }
}

class StokBarang {
    int[] stok = {10, 20, 15, 30};
    String[] produk = {"Produk A", "Produk B", "Produk C", "Produk D"};

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            System.out.println("\n========= Menu ==========");
            System.out.println("1. Lihat Stok Barang");
            System.out.println("2. Tambah Stok Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("4. Keluar");
            System.out.println("Pilih Menu anda: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayStok();
                    break;
                case 2:
                    tambahStok(scanner);
                    break;
                case 3:
                    kurangiStok(scanner);
                    break;
                case 4:
                    System.out.println("Terima Kasih !");
                    break;
                default:
                    System.out.println("Pilihan Anda tidak valid! Silahkan pilih 1-4");
                    break;
            }
        }
        scanner.close();
    }

    public void displayStok() {
        System.out.println("\n====== Stok Barang ======");
        for (int i = 0; i < stok.length; i++) {
            System.out.println(produk[i] + ": " + stok[i]);
        }
    }

    public void tambahStok(Scanner scanner) {
        System.out.println("\n===== Tambah Stok Barang =====");
        System.out.println("Masukkan indeks barang: ");
        int indeks = scanner.nextInt();
        if (indeks >= 0 && indeks < stok.length) {
            System.out.print("Masukkan jumlah stok yang ditambahkan: ");
            int tambahStok = scanner.nextInt();
            stok[indeks] += tambahStok;
            System.out.println("Stok barang berhasil ditambahkan ! ");
        } else {
            System.out.println("Indeks produk tidak valid. ");
        }
    }

    public void kurangiStok(Scanner scanner) {
        System.out.println("\n====== Kurangi Stok Barang ======");
        System.out.println("Masukkan indeks barang: ");
        int indeks = scanner.nextInt();
        if (indeks >= 0 && indeks < stok.length) {
            System.out.println("Masukkan jumlah stok yang dikurangi: ");
            int kurangiStok = scanner.nextInt();
            if (kurangiStok <= stok[indeks]) {
                stok[indeks] -= kurangiStok;
                System.out.println("Stok barang berhasil dikurangi !");
            } else {
                System.out.println("Stok tidak mencukupi untuk dikurangi !");
            }
        } else {
            System.out.println("Indeks produk tidak valid.");
        }
    }
    public void cekstoktersedia(){
        System.out.println("\n ===== Stok Barang Tersedia =====");
        for (int i=0; i < stok.length;i++){
            System.out.println(produk[i]+ " : "+stok[i]);
            
        }
    }
   static double perhitungandiskon(double total){
    double diskon=0.0;

    if (total > 100000) {
        diskon = total * 0.1;//diskon 10%
        
    }
    return total-diskon;
   }

   }


