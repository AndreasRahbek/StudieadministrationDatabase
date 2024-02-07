import java.util.ArrayList;

public class Fag {
    private int fagnr;
    private String fagnavn;



    private ArrayList<Studerende> klasseListe=new ArrayList<>();

    public Fag() {
    }

    public Fag(int fagnr, String fagnavn) {
        this.fagnr = fagnr;
        this.fagnavn = fagnavn;
    }

    public int getFagnr() {
        return fagnr;
    }

    public void setFagnr(int fagnr) {
        this.fagnr = fagnr;
    }

    public String getFagnavn() {
        return fagnavn;
    }

    public void setFagnavn(String fagnavn) {
        this.fagnavn = fagnavn;
    }

    public ArrayList<Studerende> getKlasseListe() {
        return klasseListe;
    }

    public void setKlasseListe(ArrayList<Studerende> klasseListe) {
        this.klasseListe = klasseListe;
    }

    public void tilmeldStuderende(Studerende s){
        klasseListe.add(s);
    }

    public void frameldStuderende(Studerende s){
        klasseListe.remove(s);
    }

    public void tilmeldStuderende(int stdnr,String f,String e,String a,String p,String m,String k){
        Studerende s=new Studerende(stdnr,f,e,a,p,m,k);
        klasseListe.add(s);
    }

    public void frameldStuderende(int stdnr){
        int index=indexOfStuderende(stdnr);
        klasseListe.remove(index);
    }

    private int indexOfStuderende(int stdnr){
        for(int i=0;i<klasseListe.size();i++) {
            if (klasseListe.get(i).getStdnr() == stdnr)
                return i;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Fag{" +
                "fagnr=" + fagnr +
                ", fagnavn='" + fagnavn + '\'' +
                '}';
    }
}
