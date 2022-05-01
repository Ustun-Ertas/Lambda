package day01_Lambda;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {
    public static void main(String[] args) {

        Universite bogazici = new Universite("bogazici", "matematik", 571, 93);
        Universite itu = new Universite("istanbul teknik", "matematik", 622, 81);
        Universite istanbul = new Universite("istanbul", "hukuk", 1453, 71);
        Universite marmara = new Universite("marmara", "bilgisayar muh", 1071, 77);
        Universite ytu = new Universite("yıldız teknik", "gemi", 333, 74);
        List<Universite> unv = new ArrayList<>(Arrays.asList(bogazici, itu, istanbul, marmara, ytu));

        System.out.println(notOrt74BykUnv(unv));
        System.out.println("\n   ***   ");
        System.out.println(ogrcSayisi110AzMi(unv));
        System.out.println("\n   ***   ");
        System.out.println(matBolumVarming(unv));
        System.out.println("\n   ***   ");
        System.out.println(ogrSayiBkSira(unv));
        System.out.println("\n   ***   ");
        ogrSayiBkSiraVoid(unv);
        System.out.println("\n   ***   ");
        notOrtBkSiaLilkUc(unv);
        System.out.println("\n   ***   ");
        System.out.println(enAzOgrncSaysi2Unv(unv));
        System.out.println("\n   ***   ");
        System.out.println(notOrt63ByUnvOgrncSayisiToplaInt(unv));
        System.out.println("\n   ***   ");
        System.out.println("task 8 : " +orncSayis33BykNotOrtOrtalamaAl(unv));
        System.out.println("\n   ***   ");
        System.out.println("task 9 : " +mathBolmSayisi(unv));
        System.out.println("\n   ***   ");
        System.out.println("task 10 : " +ogrcSayisi571BykMaxNotOrt(unv));
        System.out.println("\n   ***   ");
        System.out.println("task 11 : " +ogrcSayisi1071AzMiMinotOrt(unv));


    }

    //task1: ==>notOrt'larin 74'den buyuk olan kontrol eden pr create ediniz
    public static boolean notOrt74BykUnv(List<Universite>unv) {

        return unv.stream().allMatch(t->t.getNotOrt()>74);
}
    //task 02-->ogrc sayilarinin   110 den az olmadigini  kontrol eden pr create ediniz.
    public static boolean ogrcSayisi110AzMi(List<Universite> unv){

        return unv.
                stream().
                allMatch(t -> t.getOrgSayisi()>110);
    }

    //task 03-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.
    public static boolean matBolumVarming(List<Universite> unv) {
        return unv.
                stream().
                anyMatch(t -> t.getBolum().toLowerCase().contains("mat"));
    }
    //task 04-->universite'leri ogr sayilarina gore b->k siralayiniz.

    public static List<Universite> ogrSayiBkSira(List<Universite> unv){

        return unv.
                stream().sorted(Comparator.comparing(Universite::getOrgSayisi).reversed()).
                collect(Collectors.toList());
    }

    public static void ogrSayiBkSiraVoid(List<Universite> unv){
        System.out.println(unv.
                stream().sorted(Comparator.comparing(Universite::getOrgSayisi).reversed()).
                collect(Collectors.toList()));//collect ()-> akistaki elamanlari istenen sarta gore toplar
        //Collectors.tolist()->collecte'e toplanan elemanlari list'e cevirir

    }
    //task 05-->universite'leri notOrt gore  b->k siralayip ilk 3 'unu print ediniz.
    private static void notOrtBkSiaLilkUc(List<Universite> unv) {

        System.out.println(unv.
                stream().//akisa alindi
                sorted(Comparator.comparing(Universite::getNotOrt).//notOrt a gore b->k siralandi
                        reversed()).
                limit(3).//akisin ilk 3 elemani alindi
                collect(Collectors.toList()));//akisin ilk 3 elamani list'e gore edildi
    }
    //task 06--> ogrc sayisi en az olan 2. universite'yi  print ediniz.
    public static List<Universite> enAzOgrncSaysi2Unv(List<Universite> unv){

        return unv.
                stream().
                sorted(Comparator.comparing(Universite::getOrgSayisi)).
                limit(2).
                skip(1).
                collect(Collectors.toList());

    }

    //task 07--> notOrt 63 'den buyuk olan universite'lerin ogrc sayilarini toplamini print ediniz
    public static int notOrt63ByUnvOgrncSayisiToplaInt(List<Universite> unv){

        return unv.
                stream().
                filter(t->t.getNotOrt()>63).
                mapToInt(t->t.getOrgSayisi()).//akis elemanlari int data type'ina convert eder
                sum();

        // mapToInt() --> bu method akısdaki elemanların data type'nı
        // parameterisindeki() degere göre Int data type update eder

    }

    //task 08--> Ogrenci sayisi 130'dan buyuk olan universite'lerin notOrt'larinin ortalamasini bulunuz.

    public static OptionalDouble orncSayis33BykNotOrtOrtalamaAl(List<Universite> unv){

       return unv.
                stream().
                filter(t->t.getOrgSayisi()>333).
                mapToDouble(t->t.getNotOrt())
                .average();//akisdaki elemanlarin ortalmasi alindi

        // mapToDouble() --> bu method akısdaki elemanların data type'nı
        // parameterisindeki degere göre dooble data type update eder

    }

    //task 09-->"matematik" bolumlerinin sayisini  print ediniz.
    public static int mathBolmSayisi(List<Universite> unv){

       return (int) unv.
                stream().
               filter(t->t.getBolum().contains("mat")).
                count();//akısdaki elelman sayısını return eder
        //count();-->akısdaki elelman sayısını return eder

    }

    //task 10-->Ogrenci sayilari 130'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz
    public static OptionalInt ogrcSayisi571BykMaxNotOrt(List<Universite> unv){
       return unv.
                stream().
                filter(t->t.getOrgSayisi()>571).//unv obj akısı fittrelendi
                mapToInt(t->t.getNotOrt()).//akısdaki unv obj notOrt akısı olarak update edildi
                max();//akısın en byk degerini return eder
    }

    //task 11-->Ogrenci sayilari 1071'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.
    public static OptionalInt ogrcSayisi1071AzMiMinotOrt(List<Universite> unv){

       return unv.
                stream().filter(t->t.getOrgSayisi()<1071).
                mapToInt(t->t.getNotOrt()).
                min();
 }

}
