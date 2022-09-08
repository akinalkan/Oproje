import java.io.*;
import java.util.Scanner;

public class Ogretmen {
    //Ogretmenler icin Ad-Soyad,Kimlik no,Dogum yili ve Brans bilgileri tutulmalidir
    //Ogretmen bilgileri kimlik no key kullanilip bir Map'de tutulacaktir
    //Listelemeler'de basta bilgi satiri olacak
    //Soyisim ve brans bilgisiyle silme olmayacaktir

    static Scanner scan = new Scanner(System.in);

    public static void ogretmenMenu() throws InterruptedException, FileNotFoundException {

        String tercih = "";

        do {
            System.out.println("""
                    ============= YILDIZ KOLEJI =============
                    =========== OGRETMEN MENU ============
                     1- Ogretmenler Listesi Yazdir
                     2- Soyisimden Ogretmen Bulma
                     3- Branstan Ogretmen Bulma
                     4- Bilgilerini Girerek Ogretmen Ekleme
                     5- Kimlik No Ile Kayit Silme
                     A- ANAMENU
                     Q- CIKIS""");

            tercih = scan.nextLine();

            switch (tercih) {
                case "1"://1- Ogretmenler Listesi Yazdir
                    ogretmenGetir();
                    break;
                case "2"://2- Soyisimden Ogretmen Bulma
                    soyisimdenOgretmenBul();
                    break;
                case "3"://  3- Branstan Ogretmen Bulma
                    branstanOgretmenBul();
                    break;
                case "4"://4- Bilgilerini Girerek Ogretmen Ekleme
                    ogretmenEkle();
                    break;
                case "5":// 5- Kimlik No Ile Kayit Silme
                    tcNoIleOgretmenSil();
                    break;
                case "A"://A- ANAMENU
                case "a":
                    Depo.anaMenu();
                    break;
                case "Q":// Q- ÇIKIŞ
                case "q":
                    Depo.projeDurdur();
                    break;
                default:
                    System.out.println("Lutfen gecerli tercih yapiniz");
            }
        } while (!tercih.equalsIgnoreCase("Q"));

        Depo.projeDurdur();


    }

    public static void tcNoIleOgretmenSil() {

        {

                System.out.println("");
                int index=0;
                String tempFile="temp.txt";
                System.err.println("Lutfen silmek istediginiz tcNo giriniz");
                String removeTerm=scan.nextLine();
                File oldFile= new File("src/ogrt.txt");
                File newFile = new File(tempFile);


                String currentLine;
                String data[];

                try {
                    FileWriter fw= new FileWriter(tempFile,true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw);

                    FileReader fr=new FileReader("src/ogrt.txt");
                    BufferedReader br = new BufferedReader(fr);
                    while ((currentLine = br.readLine()) !=null)
                    {
                        data = currentLine.split(", ");
                        if(!(data[0].equalsIgnoreCase(removeTerm)))
                        {
                            pw.println(currentLine);
                        }
                    }
                    pw.flush();
                    pw.close();
                    fr.close();
                    br.close();
                    bw.close();
                    fw.close();
                    oldFile.delete();
                    File dump = new File("src/ogrt.txt");
                    newFile.renameTo(dump);

                }
                catch (IOException e) {

                }
            }
        }


    public static void ogretmenEkle() {
        System.out.println("");
        System.out.println("Tc No : ");
        String tcNo = scan.nextLine();
        System.out.println("Isim : ");
        String isim = scan.nextLine();
        System.out.println("Soyisim : ");
        String soyisim = scan.nextLine();
        System.out.println("Dogum Yili : ");
        String dYili = scan.nextLine();
        System.out.println("Brans : ");
        String brans = scan.nextLine();

        try {
            BufferedWriter write = new BufferedWriter(new FileWriter("src/ogrt.txt", true));//true olmak zorunda çünkü false olduğu zaman txt kısmını tamamen siler ekleme yapmak isteği zaman hata verir
            write.newLine();
            write.write(tcNo + ", " + isim + ", " + soyisim + ", " + dYili + ", " + brans);
            System.out.println("Dosyaya yazildi");
            write.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void branstanOgretmenBul() throws InterruptedException {
        {
            System.out.println("Aradiginiz ogretmenin bransini giriniz.");
            String arananBrans = scan.nextLine();
            System.out.println("""
                ============= YILDIZ KOLEJI =============
               ======= BRANS ILE OGRETMEN ARAMA ======
              TC.NO    ISIM    SOYISIM  D.YILI  BRANS""");

            File file=new File("src/ogrt.txt");

            try {
                Scanner scan =new Scanner(file);
                String[] ogrtArr;
                while (scan.hasNextLine()){
                    String line=scan.nextLine();
                    ogrtArr=line.split(", ");
                    if(arananBrans.equalsIgnoreCase(ogrtArr[4])){
                        System.out.printf("%11s %-8s %-8s %4s %s\n",ogrtArr[0],ogrtArr[1],ogrtArr[2],ogrtArr[3],ogrtArr[4]);
                    }

                }
                scan.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            Thread.sleep(3000);

        }


    }

    public static void soyisimdenOgretmenBul() throws InterruptedException {
        System.out.println(SET_BOLD_TEXT+ANSI_BLUE+ANSI_YELLOW_BACKGROUND+"Aradiginiz ogretmenin soyadini giriniz."+ANSI_RESET);
        String arananSoyisim = scan.nextLine();
        System.out.println("""
                ============= YILDIZ KOLEJI =============
               ======= SOYISIM ILE OGRETMEN ARAMA ======
              TC.NO    ISIM    SOYISIM  D.YILI  BRANS""");

        File file=new File("src/ogrt.txt");

        try {
            Scanner scan =new Scanner(file);
            String[] ogrtArr;
            while (scan.hasNextLine()){
                String line=scan.nextLine();
                ogrtArr=line.split(", ");
                if(arananSoyisim.equalsIgnoreCase(ogrtArr[2])){
                    System.out.printf("%11s %-8s %-8s %4s %s\n",ogrtArr[0],ogrtArr[1],ogrtArr[2],ogrtArr[3],ogrtArr[4]);
                }

            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Thread.sleep(3000);

    }

    public static void ogretmenGetir() {

        File file = new File("src/ogrt.txt");

        try {
            Scanner scan = new Scanner(file);
            String[] ogrtArr;
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                ogrtArr = line.split(", ");

                System.out.printf("%11s %-8s %-8s %4s %s\n",
                        ogrtArr[0], ogrtArr[1], ogrtArr[2], ogrtArr[3], ogrtArr[4]);
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
    public static final String SET_ITALIC_TEXT = "\033[0;3m";
    public static final String SET_ALTICIZILI_TEXT = "\033[0;4m";
    public static final String SET_BOLD_TEXT = "\033[0;1m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
}
