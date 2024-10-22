import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Kullanıcıdan veri almak için Scanner kullanıyoruz
        Scanner scanner = new Scanner(System.in);

        // Kullanıcıdan personelin isim, günlük ücret ve çalıştığı gün sayısı bilgilerini alıyoruz
        System.out.print("Personelin adını giriniz: ");
        String isim = scanner.nextLine();

        System.out.print("Personelin günlük ücretini giriniz: ");
        double gunlukUcret = scanner.nextDouble();

        System.out.print("Personelin çalıştığı gün sayısını giriniz: ");
        int calistigiGun = scanner.nextInt();

        // Bir personel nesnesi oluşturuyoruz
        Personel personel = new Personel(isim, gunlukUcret, calistigiGun);

        // Muhasebe üzerinden maaş hesaplıyoruz
        double maas = Muhasebe.maasHesapla(personel);

        // Sonuçları ekrana yazdırıyoruz
        System.out.println(personel.getIsim() + " isimli personel için hesaplanan maaş: " + maas + " TL" +"'dir.");

        // Scanner'ı kapatıyoruz
        scanner.close();
    }
}

class Personel {
    private String isim;
    private double gunlukUcret;
    private int calistigiGun;

    public Personel(String isim, double gunlukUcret, int calistigiGun) {
        this.isim = isim;
        this.gunlukUcret = gunlukUcret;
        this.calistigiGun = calistigiGun;
    }

    public int getCalistigiGun() {
        return calistigiGun;
    }

    public double getGunlukUcret() {
        return gunlukUcret;
    }

    public String getIsim() {
        return isim;
    }
}

class Muhasebe {

    public static double maasHesapla(Personel personel) {


        double gunlukUcret = personel.getGunlukUcret();
        int calistigiGun = personel.getCalistigiGun();

        // Prim hesaplama işlemi (25'ten fazla gün çalıştıysa her gün için 1000 TL prim eklenir) Üçlü operatör kullanımı
        double prim = (calistigiGun > 25) ? (calistigiGun - 25) * 1000 : 0;

        // Toplam maaş hesaplaması
        double toplamMaas = calistigiGun * gunlukUcret + prim;
        return toplamMaas;
//test
    }
}