package apis.Manga.API.Controller;
import apis.Manga.API.Service.ChampService;
import apis.Manga.API.Service.FilmService;
import apis.Manga.API.Entety.User;
import apis.Manga.API.Repository.UserRepository;
import apis.Manga.API.Security.JwtAuthentificationFilter;
import apis.Manga.API.Security.JwtTokenProvider;
import apis.Manga.API.request.AuthRequest;
import apis.Manga.API.request.ChampRequest;
import apis.Manga.API.request.FilmRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthController {

    private ChampService champService;
    private FilmService filmService;
   private UserRepository userRepository;
   private PasswordEncoder passwordEncoder;
   private AuthenticationManager authenticationManager;
   private JwtTokenProvider jwtTokenProvider;



    public AuthController(ChampService champService, UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, FilmService filmService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.filmService = filmService;
        this.champService = champService;
    }

    @CrossOrigin
    @PostMapping(value = "/regist")
    public ResponseEntity<User> register(@RequestBody AuthRequest authRequest){
        Optional<User> userOptional = userRepository.findByEmail(authRequest.getEmail());
        if(userOptional.isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        User user = new User();
        user.setEmail(authRequest.getEmail());
        user.setUsername(authRequest.getUsername());
        user.setPassword(passwordEncoder.encode(authRequest.getPassword()));
        User created = userRepository.save(user);
        return ResponseEntity.ok(created);

    }
    @CrossOrigin
    @GetMapping("/user")
    public Optional<User> getUser(){
        return userRepository.findByEmail(jwtTokenProvider.getUserMailFromToken( JwtAuthentificationFilter.x) );
    }

    @CrossOrigin
    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getEmail() ,
                        authRequest.getPassword()
                )
        );
        return ResponseEntity.ok(jwtTokenProvider.generateToken(authentication));
    }

//    @CrossOrigin
//    @PutMapping("user/{nutzerId}")
//    public void  patchUser(@RequestBody User userUpdate, @PathVariable Long nutzerId){
//        Optional<User> user = userRepository.findById(nutzerId);
//        if(!user.isPresent()){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
//        User userInstance = user.get();
//        userInstance.setInstagram(userUpdate.getInstagram());
//        userInstance.setFacebook(userUpdate.getFacebook());
//        userInstance.setTwitch(userUpdate.getTwitch());
//        userRepository.save(userInstance);
//    }
    @CrossOrigin
    @DeleteMapping("/user/all/{nutzerId}")
    public Boolean deleteOrder1( @PathVariable (value = "nutzerId") Long Id) {
        userRepository.deleteById(Id);
        return true;
    }
    @CrossOrigin
    @PutMapping("user/all/{nutzerId}")
    public void  patchUser1(@RequestBody User userUpdate, @PathVariable Long nutzerId){
        Optional<User> user = userRepository.findById(nutzerId);
        if(!user.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        User userInstance = user.get();
        userInstance.setUsername(userUpdate.getUsername());

        userRepository.save(userInstance);
    }
    @CrossOrigin
    @PostMapping(path="/film/{nutzerId}")
    public String erzeugeComb(@RequestBody FilmRequest filmRequest, @PathVariable long nutzerId){
        return filmService.erzeugeFilm(filmRequest,nutzerId);
    }
    @CrossOrigin
    @PostMapping(path="/champ")
    public String erzeugeChamp(@RequestBody ChampRequest champRequest){
        return champService.erzeugeChamp(champRequest);
    }


  /*  @CrossOrigin(origins = "http://ratetherank.com")
    @GetMapping("/clip/{nutzerId}")
    public Clip ladeClip(@PathVariable Long nutzerId){
        return clipService.ladeClip(nutzerId);
    }*/


}
 /*  @GetMapping("/clip/{Id}")
    public Clip leseNutzerListe(@PathVariable Long Id){
        Optional<Clip> clip = clipRepository.findById(Id);
        if(clip.isPresent()){
            return clip.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }*/

