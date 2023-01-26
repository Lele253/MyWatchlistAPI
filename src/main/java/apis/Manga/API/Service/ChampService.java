package apis.Manga.API.Service;

import apis.Manga.API.Entety.Champ;
import apis.Manga.API.Repository.ChampRepository;
import apis.Manga.API.request.ChampRequest;
import org.springframework.stereotype.Service;

@Service
public class ChampService {
    private ChampRepository champRepository;

    public ChampService(ChampRepository champRepository) {
        this.champRepository = champRepository;
    }
    private String name;
    private String cost;
    private String skill;
    private String mana;
    private String trait1;
    private String trait2;
    private String trait3;
    private String bildURL;
    public String erzeugeChamp(ChampRequest champRequest) {
        Champ champ = new Champ(champRequest.getName(),champRequest.getCost(),champRequest.getSkill(), champRequest.getMana(),  champRequest.getTrait1(),champRequest.getTrait2(),champRequest.getTrait3(),champRequest.getBildURL());
        champRepository.save(champ);
        return "CHamp wurde erfolgreich erstellt";
    }
}
