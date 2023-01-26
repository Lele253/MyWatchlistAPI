package apis.Manga.API.Entety;

import javax.persistence.*;

@Entity
public class Film {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long filmId;
    private String titel;
    @Column (length = 300)
    private String titelbild;
    private String erscheinungsjahr;
    private int bewertung;
    @Column (length = 600)
    private String kommentar;
    private String hinzugefuegt;
    private boolean watched;



    @ManyToOne
    @JoinColumn(name = "nutzerId", referencedColumnName = "nutzerId")
    private User user;

    public Film(String titel, String titelbild, String erscheinungsjahr, int bewertung, String kommentar, String hinzugefuegt, boolean watched, User user) {
        this.titel = titel;
        this.titelbild = titelbild;
        this.erscheinungsjahr = erscheinungsjahr;
        this.bewertung = bewertung;
        this.kommentar = kommentar;
        this.hinzugefuegt = hinzugefuegt;
        this.watched = watched;
        this.user = user;
    }

    public Film() {
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getTitelbild() {
        return titelbild;
    }

    public void setTitelbild(String titelbild) {
        this.titelbild = titelbild;
    }

    public String getErscheinungsjahr() {
        return erscheinungsjahr;
    }

    public void setErscheinungsjahr(String erscheinungsjahr) {
        this.erscheinungsjahr = erscheinungsjahr;
    }

    public int getBewertung() {
        return bewertung;
    }

    public void setBewertung(int bewertung) {
        this.bewertung = bewertung;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getHinzugefuegt() {
        return hinzugefuegt;
    }

    public void setHinzugefuegt(String hinzugefuegt) {
        this.hinzugefuegt = hinzugefuegt;
    }

    public User getUser() {
        return user;
    }

    public long getFilmId() {
        return filmId;
    }

    public void erzeuger(User user){
        this.user=user;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }
}

