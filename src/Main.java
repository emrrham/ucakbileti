import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Lütfen yaşınızı giriniz: ");
        int yas = input.nextInt();

        System.out.print("Lütfen uçuş mesafesini (km cinsinden) giriniz: ");
        int km = input.nextInt();

        System.out.print("Lütfen gidiş-dönüş uçuşu için 'g' veya tek yön uçuş için 't' giriniz: ");
        String gidisDonus = input.next();

        double fiyat = hesapla(yas, km, gidisDonus);

        if (fiyat == -1) {
            System.out.println("Geçersiz girdi! Lütfen tekrar deneyin.");
        } else {
            System.out.println("Bilet fiyatı: " + fiyat + " TL");
        }
    }

    public static double hesapla(int yas, int km, String gidisDonus) {
        double ucret = 0;

        if (yas < 0 || km < 0 || (!gidisDonus.equals("g") && !gidisDonus.equals("t"))) {
            return -1; // Hatalı girdi durumunda -1 döndürüyoruz
        }

        // Yaşa göre fiyat belirleme
        if (yas < 12) {
            ucret = km * 0.5;
        } else if (yas >= 12 && yas < 24) {
            ucret = km * 0.7;
        } else if (yas >= 24 && yas < 65) {
            ucret = km * 1;
        } else {
            ucret = km * 0.8;
        }

        // Gidiş-dönüş için fiyat artırımı
        if (gidisDonus.equals("g")) {
            ucret *= 2;
        }

        return ucret;
    }
}
