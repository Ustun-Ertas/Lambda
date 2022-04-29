package day01_Lambda;

import java.util.*;

public class Lambda03 {
    public static void main(String[] args) {

        List<String> menu = new ArrayList(Arrays.asList("küşleme", "adana", "trileçe", "havucDilim", "buryan",
                "yaglama", "kokareç", "arabAşı", "güveç", "trileçe", "trileçe", "trileçe"));

        alfBykTekrrsz(menu);
        System.out.println("\n   ***   ");
        chrSayisiTersSirali(menu);
        System.out.println("\n   ***   ");
        chrSayisiBkSirala(menu);
        System.out.println("\n   ***   ");
        sonHrfBkSirala(menu);
        System.out.println("\n   ***   ");
        charKaresiCiftElSirala(menu);
        System.out.println("\n   ***   ");
        harfSayisi7denAzKontrol(menu);
        System.out.println("\n   ***   ");
        wIleBaslayanElKontrol(menu);
        System.out.println("\n   ***   ");
        xIleBitenElKontrol(menu);
        System.out.println("\n   ***   ");
        charSayisiBykElPrint(menu);


    }

    // Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    private static void alfBykTekrrsz(List<String> menu) {

        menu.////akıs kaynagı
                stream().//akisa girdi
                //map(t->t.toUpperCase()).//Jamb.Ex  elemanlar buyuk harf update edildi
                        map(String::toUpperCase).//Meth.Ref elemanlar buyuk harf update edildi
                sorted().//alafabetik(natural dogal) sıra yapıldı
                distinct().// benzersiz: tekrarsız hale getirildi
                forEach(t -> System.out.print(t + " "));//print

        //distinct() => Bu method tekrarlı elemanları sadece bir kere akısa sokar.
        // Bu akışın farklı elemanlarından (Object.equals (Object) 'e göre) oluşan bir akış döndürür.
        // Sıralı akışlar için, farklı elemanın seçimi sabittir
        // (yinelenen öğeler için, karşılaşma sırasında ilk görünen öğe korunur.)
        // Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez. Stream return eder.
    }

    // Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    private static void chrSayisiTersSirali(List<String> menu) {

        menu.//akis kaygani
                stream().//akisa girdi
                // map(t->t.length()).
                        map(String::length).//elemanlar karakter sayısına update edildi
                sorted(Comparator.reverseOrder()).//ter sıra yapıldı
                distinct().//benzersiz yapıldı
                //forEach(t->System.out.print(t+" "));
                        forEach(Lambda01::yazdir);//print edildi


    }

    // Task : list elemanlarinin son harfine gore ters sirali print ediniz.
    private static void chrSayisiBkSirala(List<String> menu) {

        menu.//akis kaygani
                stream().
                sorted(Comparator.
                        comparing(String::length)).
                forEach(t -> System.out.println(t + ""));

    }


    // Task : list elemanlarinin son harfine gore ters sirali print ediniz.
    private static void sonHrfBkSirala(List<String> menu) {
        menu.
                stream().
                sorted(Comparator.
                        comparing(t -> t.toString().
                                charAt(t.toString().length() - 1)).
                        reversed()).
                forEach(t -> System.out.print(t + " "));

    }

    // Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini tekrarsiz buyukten kucuge sirali  print ediniz..
    // Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
    // Task : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.
    // Task : Karakter sayisi en buyuk elemani yazdiriniz.
    // Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.


    // Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini tekrarsiz buyukten kucuge sirali  print ediniz...
    private static void charKaresiCiftElSirala(List<String> menu) {

        menu.
                stream().
                map(t -> t.length() * t.length()).//akısdaki string elemanları boyutlarının karesine update edildi
                filter(Lambda01::ciftBul).//cift elelmalar filtrelendi
                distinct().//tekrarsız yapıldı
                sorted(Comparator.reverseOrder()).//ters b->k sıra yapıldı
                forEach(Lambda01::yazdir);// print edildi

    }

    // Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    private static void harfSayisi7denAzKontrol(List<String> menu) {

        //amele code
        System.out.println("amele code");
        boolean kontrol = menu.stream().allMatch(t -> t.length() <= 7);
        if (kontrol) {
            System.out.println("list elemanları 7 ve daha az harften olusuyor");
        } else System.out.println("list elemanları 7 harften  buyuk");
        //cincix code
        System.out.println("cincix code");
        System.out.println(menu.
                stream().
                allMatch(t -> t.length() <= 7) ? "list elemanları 7 ve daha az harften olusuyor" : "list elemanları 7 harften  buyuk");
    }


//anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
//allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
//noneMatch()--> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.


     // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
     private static void wIleBaslayanElKontrol(List<String> menu) {

         System.out.println(menu.
                 stream().
                 noneMatch(t -> t.startsWith("w")) ? "agam w ile başlayan yemahh olu mu ?" :
                 "agam  wenemen ne menen bi şey  ?");
}


    // Task : List elelmanlarinin "x" ile biten en az bir elemanı kontrol ediniz.
    private static void xIleBitenElKontrol(List<String> menu) {

        System.out.println(menu.
                stream().
                anyMatch(t -> t.endsWith("x")) ? "agam senden bir  cacix olmaz  ?" :
                "agam senin aradigin yemek bu torpaklarda yooogggg");
}

       // Task : Karakter sayisi en buyuk elemani yazdiriniz.
       private static void charSayisiBykElPrint(List<String> menu) {
           System.out.println(menu.
                   stream().sorted(Comparator.
                           comparing(t -> t.toString().length()).reversed()).
                   findFirst());

           // akıs cıktısını bir veriable assaign edilebilir
           Optional<String> enBykKrEl= menu.
                   stream().
                   sorted(Comparator.comparing(t -> t.toString().length()).
                           reversed()).
                   findFirst();
       }
// Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
}




