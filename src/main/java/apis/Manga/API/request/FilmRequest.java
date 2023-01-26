package apis.Manga.API.request;

import apis.Manga.API.Entety.User;

public class FilmRequest {
    private long filmId;
    private String titel;
    private String titelbild;
    private String erscheinungsjahr;
    private int bewertung;
    private String kommentar;
    private String hinzugefuegt;
    private boolean watched;
    private User user;


    public FilmRequest(String titel, String titelbild, String erscheinungsjahr, int bewertung, String kommentar, String hinzugefuegt,boolean watched, User user) {
        this.titel = titel;
        this.titelbild = titelbild;
        this.erscheinungsjahr = erscheinungsjahr;
        this.bewertung = bewertung;
        this.kommentar = kommentar;
        this.hinzugefuegt = hinzugefuegt;
        this.watched = watched;
        this.user = user;
    }

    public String getTitel() {
        return titel;
    }

    public String getTitelbild() {
        return titelbild;
    }

    public String getErscheinungsjahr() {
        return erscheinungsjahr;
    }

    public int getBewertung() {
        return bewertung;
    }

    public String getKommentar() {
        return kommentar;
    }

    public String getHinzugefuegt() {
        return hinzugefuegt;
    }

    public User getUser() {
        return user;
    }

    public long getFilmId() {
        return filmId;
    }

    public boolean isWatched() {
        return watched;
    }
}
