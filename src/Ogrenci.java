import java.io.*;

import java.util.Scanner;

public class Ogrenci {
    //Ogrenciler icin Ad,Soyad, kimlik, dogum yili, okul no,sinif, sube bilgileri olmali
    //Soyisim veya sinif/sube bilgisi ile silme olmayacaktir

    static Scanner scan = new Scanner(System.in);
    public static void ogrenciMenu() throws FileNotFoundException, InterruptedException {
        String tercih = "";
        do{
            System.out.println("""
                 ============= YILDIZ KOLEJI =============
                 =========== OGRENCI MENU ============
                     1- Ogrenci Listesi Yazdir
                     2- Soyisimden Ogrenci Bulma
                     3- Okul No ile Ogrenci Bulma
                     4- Bilgilerini Girerek Ogrenci Ekleme
                     5- Kimlik No Ile Kayit Silme
                     A- ANAMENU
                     Q- CIKIS""");

            tercih = scan.nextLine();

            switch (tercih) {
                case "1":
                    ogrenciGetir();
                    break;
                case "2":
                    soyIsimdenOgrenciBulma();
                    break;
                case "3":
                    okulNodanOgrenciBulma();
                    break;
                case "4":
                    ogrenciEkle();
                    break;
                case "5":
                    tcNoIleOgrenciSil();
                    break;
                case "A":
                case "a":
                    Depo.anaMenu();
                    break;
                case "Q":
                case "q":
                    Depo.projeDurdur();
                    break;
                default:
                    System.out.println("Lutfen gecerli tercih yapiniz");
            }

        }while (!tercih.equalsIgnoreCase("q"));

        Depo.projeDurdur();



    }

    public static void tcNoIleOgrenciSil() {
        {

            {

                System.out.println("");
                int index=0;
                String tempFile="temp.txt";
                System.err.println("Lutfen silmek istediginiz tcNo giriniz");
                String removeTerm=scan.nextLine();
                File oldFile= new File("src/ogrenciler1.txt");
                File newFile = new File(tempFile);


                String currentLine;
                String data[];

                try {
                    FileWriter fw= new FileWriter(tempFile,true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw);

                    FileReader fr=new FileReader("src/ogrenciler1.txt");
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
                    File dump = new File("src/ogrenciler1.txt");
                    newFile.renameTo(dump);

                }
                catch (IOException e) {

                }
            }
        }
    }

    public static void ogrenciEkle() {
        System.out.println("Tc No");
        String tcNo= scan.nextLine();
        System.out.println("isim");
        String isim= scan.nextLine();
        System.out.println("soyisim");
        String soyisim= scan.nextLine();
        System.out.println("D.yili");
        String dYili= scan.nextLine();
        System.out.println("Okul No");
        String okulNo= scan.nextLine();
        System.out.println("Sınıf");
        String sinif= scan.nextLine();
        System.out.println("Sube");
        String sube= scan.nextLine();
        try {
            File file=new File("src/ogrenciler1.txt");
            FileWriter fw=new FileWriter(file,true);
            BufferedWriter write = new BufferedWriter(fw);
            // BufferedWriter write = new BufferedWriter(new FileWriter("src/ogrenciler1.txt", true));


            write.newLine();
            write.write(tcNo + ", " + isim+", "+soyisim+", "+dYili+", "
                    +okulNo+", "+sinif+", "+sube);
            System.out.println("Dosyaya yazildi");
            write.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void okulNodanOgrenciBulma() {
        System.out.println("Aradiginiz ogrencinin soyadini giriniz : ");
        String arananSoyisim= scan.nextLine();
        {
            System.out.println("""
                                
                ============= YILDIZ KOLEJI =============
                  =========== OGRENCI MENU ============
                  Tc No       İsim   Soyisim     D Yılı    OkulNo     Sınıf   Sube""");


            File file = new File("src/ogrenciler1.txt");


            try {
                Scanner scan = new Scanner(file);
                String[] ogrenciArr;
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    ogrenciArr = line.split(", ");
                    if(arananSoyisim.equalsIgnoreCase(ogrenciArr[4])){
                        System.out.printf("%11s %-8s %-8s %8s %8s %8s %5s\n",
                                ogrenciArr[0], ogrenciArr[1], ogrenciArr[2], ogrenciArr[3], ogrenciArr[4],ogrenciArr[5],ogrenciArr[6]);
                    }


                }
                scan.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }


        }

    }



    public static void soyIsimdenOgrenciBulma() {
        System.out.println("Aradiginiz ogrencinin soyadini giriniz : ");
        String arananSoyisim= scan.nextLine();
        {
            System.out.println("""
                                
                ============= YILDIZ KOLEJI =============
                  =========== OGRENCI MENU ============
                  Tc No       İsim   Soyisim     D Yılı    OkulNo     Sınıf   Sube""");


            File file = new File("src/ogrenciler1.txt");


            try {
                Scanner scan = new Scanner(file);
                String[] ogrenciArr;
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    ogrenciArr = line.split(", ");
                    if(arananSoyisim.equalsIgnoreCase(ogrenciArr[2])){
                        System.out.printf("%11s %-8s %-8s %8s %8s %8s %5s\n",
                                ogrenciArr[0], ogrenciArr[1], ogrenciArr[2], ogrenciArr[3], ogrenciArr[4],ogrenciArr[5],ogrenciArr[6]);
                    }


                }
                scan.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }


        }

    }

    public static void ogrenciGetir() {
        System.out.println("""
                                
                ============= YILDIZ KOLEJI =============
                  =========== OGRENCI MENU ============
                  Tc No       İsim   Soyisim     D Yılı    OkulNo     Sınıf   Sube""");


            File file = new File("src/ogrenciler1.txt");


        try {
            Scanner scan = new Scanner(file);
            String[] ogrenciArr;
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                ogrenciArr = line.split(", ");
                System.out.printf("%11s %-8s %-8s %8s %8s %8s %5s\n",
                        ogrenciArr[0], ogrenciArr[1], ogrenciArr[2], ogrenciArr[3], ogrenciArr[4],ogrenciArr[5],ogrenciArr[6]);
            }
            scan.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
