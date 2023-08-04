package vibrato.vibrato.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vibrato.vibrato.entidades.EchoSystem;
import vibrato.vibrato.entidades.Usuario;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    public Usuario findByUsernameOrEmail(String username, String email);
    Optional<Usuario> findById(Integer id);

    Optional<Usuario> findByUsername(String username);
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    Optional<Usuario> findByEmail(String email);


    @Transactional
    @Modifying
    @Query("UPDATE Usuario u SET u.email = :email WHERE u.id = :id")
    void atualizarEmail(@Param("email") String email, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Usuario u SET u.senha = :senha WHERE u.id = :id")
    void atualizarSenha(@Param("senha") String senha, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Usuario u WHERE u.id = :id")
    void deletarConta(@Param("id") Integer id);

}
