package apis.Manga.API.Controller;
import java.util.List;
import apis.Manga.API.Entety.Champ;
import apis.Manga.API.Entety.Film;
import apis.Manga.API.Repository.ChampRepository;
import apis.Manga.API.Repository.FilmRepository;
import org.springframework.web.bind.annotation.*;


import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.stream.Collectors;
@CrossOrigin
@RestController
@RequestMapping("/auth")
public class FilmController {

    private FilmRepository filmRepository;
    private ChampRepository champRepository;


    public FilmController(FilmRepository filmRepository, ChampRepository champRepository) {
        this.filmRepository = filmRepository;
        this.champRepository = champRepository;

    }

   @CrossOrigin
   @GetMapping("/film")
    public List<Film> getClip(){
        return filmRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/champ")
    public List<Champ> getChamp(){
        return champRepository.findAll();
    }


    @CrossOrigin
   @GetMapping("/film/sortiert/{nutzerId}")
    public List<Film> leseNutzerListe(@PathVariable Long nutzerId){
        List<Film> clips = filmRepository.findAll();
        return  clips.stream().filter(c->c.getUser().getNutzerId() == nutzerId).collect(Collectors.toList());
    }

    @CrossOrigin
    @GetMapping("/aufgabe/{nutzerId}")
    public Film leseNutzerListe(@PathVariable long nutzerId){
        Optional<Film> clip = filmRepository.findById(nutzerId);
        if(clip.isPresent()){
            return clip.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin
    @DeleteMapping("/{filmId}")
    public Boolean deleteOrder( @PathVariable (value = "filmId") Long Id) {
        filmRepository.deleteById(Id);
        return true;
    }

  @PutMapping("/film/{filmId}")
    public void  patchClip(@RequestBody Film filmUpdate, @PathVariable Long filmId) {
        Optional<Film> film = filmRepository.findById(filmId);
        if (!film.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Film filmInstance = film.get();
        filmInstance.setTitel(filmUpdate.getTitel());
        filmInstance.setTitelbild(filmUpdate.getTitelbild());
        filmInstance.setErscheinungsjahr(filmUpdate.getErscheinungsjahr());
        filmInstance.setBewertung(filmUpdate.getBewertung());
        filmInstance.setKommentar(filmUpdate.getKommentar());
        filmInstance.setWatched((filmUpdate.isWatched()));
        filmRepository.save(filmInstance);
    }
}
