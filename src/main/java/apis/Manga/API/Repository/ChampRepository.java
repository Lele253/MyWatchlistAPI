package apis.Manga.API.Repository;

import apis.Manga.API.Entety.Champ;
import apis.Manga.API.Entety.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChampRepository extends JpaRepository<Champ, Long> {
}
