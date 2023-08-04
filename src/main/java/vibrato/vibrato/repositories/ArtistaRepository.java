package vibrato.vibrato.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vibrato.vibrato.entidades.Artista;

public interface ArtistaRepository extends JpaRepository<Artista, Integer> {
        public Artista findByUsernameOrEmail(String username, String email);
}
