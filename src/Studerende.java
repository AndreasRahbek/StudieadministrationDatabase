import java.util.ArrayList;

public class Studerende {
    private int stdnr;
    private String fnavn;
    private String enavn;
    private String adresse;
    private String postnr;
    private String mobil;
    private String klasse;

    private ArrayList<Fag> fagListe=new ArrayList<Fag>();

    public Studerende() {
    }

    public Studerende(int stdnr, String fnavn, String enavn, String adresse, String postnr, String mobil, String klasse) {
        this.stdnr = stdnr;
        this.fnavn = fnavn;
        this.enavn = enavn;
        this.adresse = adresse;
        this.postnr = postnr;
        this.mobil = mobil;
        this.klasse = klasse;
    }

    public int getStdnr() {
        return stdnr;
    }

    public void setStdnr(int stdnr) {
        this.stdnr = stdnr;
    }

    public String getFnavn() {
        return fnavn;
    }

    public void setFnavn(String fnavn) {
        this.fnavn = fnavn;
    }

    public String getEnavn() {
        return enavn;
    }

    public void setEnavn(String enavn) {
        this.enavn = enavn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPostnr() {
        return postnr;
    }

    public void setPostnr(String postnr) {
        this.postnr = postnr;
    }

    public String getMobil() {
        return mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public String getKlasse() {
        return klasse;
    }

    public void setKlasse(String klasse) {
        this.klasse = klasse;
    }

    public ArrayList<Fag> getFagListe() {
        return fagListe;
    }

    public void setFagListe(ArrayList<Fag> fagListe) {
        this.fagListe = fagListe;
    }

    public void tilmeldFag(Fag f){
        fagListe.add(f);
    }

    public void frameldFag(Fag f){
        fagListe.remove(f);
    }

    public void tilmeldFag(int fagnr,String fagnavn){
        Fag f=new Fag(fagnr,fagnavn);
        fagListe.add(f);
    }

    public void frameldFag(int fagnr){
        int index=indexOfFag(fagnr);
        fagListe.remove(index);
    }

    private int indexOfFag(int fagnr){
        for(int i=0;i<fagListe.size();i++){
            if(fagListe.get(i).getFagnr()==fagnr)
                return i;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Studerende{" +
                "stdnr=" + stdnr +
                ", fnavn='" + fnavn + '\'' +
                ", enavn='" + enavn + '\'' +
                ", adresse='" + adresse + '\'' +
                ", postnr='" + postnr + '\'' +
                ", mobil='" + mobil + '\'' +
                ", klasse='" + klasse + '\'' +
                ", fagListe=" + fagListe +
                '}';
    }
}
