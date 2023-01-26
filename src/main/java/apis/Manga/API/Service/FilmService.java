package apis.Manga.API.Service;

import apis.Manga.API.Entety.Film;
import apis.Manga.API.Entety.User;
import apis.Manga.API.Repository.FilmRepository;
import apis.Manga.API.Repository.UserRepository;
import apis.Manga.API.request.FilmRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class FilmService {
    private FilmRepository filmRepository;
    private  UserRepository userRepository;



    public FilmService(FilmRepository filmRepository, UserRepository userRepository){
        this.filmRepository = filmRepository;
        this.userRepository = userRepository;
    }

    public String erzeugeFilm(FilmRequest filmRequest, long nutzerId) {
        User user = userRepository.findById(nutzerId);
        Film film = new Film(filmRequest.getTitel(), filmRequest.getTitelbild(), filmRequest.getErscheinungsjahr(),filmRequest.getBewertung(), filmRequest.getKommentar(), filmRequest.getHinzugefuegt(),filmRequest.isWatched(), filmRequest.getUser());
        film.erzeuger(user);
        filmRepository.save(film);
        return "Film wurde erfolgreich angelegt";
    }

    public Film ladeFilm(long nutzerId){
        User user = userRepository.findById(nutzerId);
        Optional<Film> clip = filmRepository.findById(user.getNutzerId());
        if(clip.isPresent()){
            return clip.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }
    }

