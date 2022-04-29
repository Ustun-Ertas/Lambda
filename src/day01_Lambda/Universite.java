package day01_Lambda;

public class Universite {

    /*
TASK :
fields --> Universite (String)
           bolum (String)
           ogrcSayisi (int)
           notOrt (int)
           olan POJO clas craete edip main method içinde 5 arklı obj'den List create ediniz.
           pojo class: plan old java object
 */

    private String universite;
    private String bolum;
    private int orgSayisi;
    private int notOrt;

    public Universite(String universite, String bolum, int orgSayisi, int notOrt) {
        this.universite = universite;
        this.bolum = bolum;
        this.orgSayisi = orgSayisi;
        this.notOrt = notOrt;
    }

    public String getUniversite() {
        return universite;
    }

    public void setUniversite(String universite) {
        this.universite = universite;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public int getOrgSayisi() {
        return orgSayisi;
    }

    public void setOrgSayisi(int orgSayisi) {
        this.orgSayisi = orgSayisi;
    }

    public int getNotOrt() {
        return notOrt;
    }

    public void setNotOrt(int notOrt) {
        this.notOrt = notOrt;
    }

    @Override
    public String toString() {
        return "Universite{" +
                "universite='" + universite + '\'' +
                ", bolum='" + bolum + '\'' +
                ", orgSayisi=" + orgSayisi +
                ", notOrt=" + notOrt +
                '}';
    }
}
