import java.io.FileNotFoundException;
import java.util.Scanner;

public class Depo {//3 tane method olur.
    // Bunlar;
    //public static void anaMenu()
    //public static void okulBilgileriniYazdir()
    //public static void projeDurdur()

    //Burada ki  projeDurdur() Q ya da q 'ya basilinca projenin durmasi icin yazilan ozel bir method:

    // public static void projeDurdur() {
    //        System.err.println("Projeler.Okul projesinden ciktiniz");
    //        System.exit(0);//Sistemin tamamen durmasi icin kullanilir
    //    }

    //Kullanicidan tercih almak icin scanner class'indan faydalaniriz

    static Scanner scan = new Scanner(System.in);

    public static void anaMenu() throws InterruptedException, FileNotFoundException {

        //Ana menu :menuden ana menu secilince gidilecek yer olmali.
        //Kullanicidan tercih alip ,bu tercihi do-while loop'unda switch case ile istenen yere yonlendirmeliyiz

        //           "                   =========== YILDIZ KOLEJI =============" +
        //           "                   ==============  ANA MENU ==============" +
        //           "                        1- Projeler.Okul Bilgileri Goruntule" +
        //           "                        2- Ogretmen Menu\n" +
        //           "                        3- Ogrenci Menu\n" +
        //           "                        Q- ÇIKIŞ");

        String tercih="";

        do{
            System.out.println("""
                =========== YILDIZ KOLEJI =============
                ==============  ANA MENU ==============
                1- Okul Bilgileri Goruntule
                2- Ogretmen Menu
                3- Ogrenci Menu
                Q- CIKIS""");
            System.out.println("Lutfen menuden tercihinizi yapiniz");
            tercih = scan.nextLine();
            switch (tercih){
                case "1":
                    okulBilgileriniYazdir();
                    break;
                case "2":
                    Ogretmen.ogretmenMenu();
                    break;
                case "3":
                    Ogrenci.ogrenciMenu();
                    break;
                case "Q":
                case "q":
                    break;
                default:
                    System.out.println("Lutfen gecerli bir tercih yapiniz");

            }
        }while (!tercih.equalsIgnoreCase("Q"));

        projeDurdur();



    }

    public static void okulBilgileriniYazdir() throws InterruptedException {
        System.out.println("""
                 =========== YILDIZ KOLEJI =============
                 Adres : """+Okul.adres+ """
                \nTelefon : """+Okul.telefon);
        Thread.sleep(3000);
    }

    public static void projeDurdur() {
        System.err.println("Okul projesinden ciktiniz");
        System.exit(0);
    }
}