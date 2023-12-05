package kodlama.io.ders.entities.concretes;

public class ProgrammingLang {
    private int id;
    private String kursAd;

    public ProgrammingLang() {
    }

    public ProgrammingLang(int id, String kursAd) {
        this.id = id;
        this.kursAd = kursAd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKursAd() {
        return kursAd;
    }

    public void setKursAd(String kursAd) {
        this.kursAd = kursAd;
    }
}
