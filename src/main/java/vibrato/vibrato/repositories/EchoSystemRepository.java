package vibrato.vibrato.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vibrato.vibrato.entidades.EchoSystem;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface EchoSystemRepository extends JpaRepository<EchoSystem,Integer> {
    List<EchoSystem> findTop5ByOrderByIdEchoDesc();

    List<EchoSystem> findAllByOrderByIdEchoDesc();

    @Query("SELECT e FROM EchoSystem e WHERE e.artista.idUsuario = :userId ORDER BY e.idEcho DESC")
    List<EchoSystem> findTop3EchoSystemByArtistaId(@Param("userId") Integer userId);

    @Query("SELECT e FROM EchoSystem e WHERE e.artista.username = :username ORDER BY e.idEcho DESC")
    List<EchoSystem> findTop3EchoSystemByArtistaUsername(@Param("username") String username);
    @Query("SELECT e FROM EchoSystem e WHERE e.artista.idUsuario = :userId ORDER BY e.visualizacao DESC")
    List<EchoSystem> findTop3TituloMusicaByOrderByVisualizacaoDesc(@Param("userId") Integer userId, Pageable pageable);

    @Query("SELECT e FROM EchoSystem e WHERE e.artista.username = :username ORDER BY e.visualizacao DESC")
    List<EchoSystem> findTop3TituloMusicaUsernameByOrderByVisualizacaoDesc(@Param("username") String username, Pageable pageable);

    @Query("SELECT e FROM EchoSystem e WHERE e.artista.idUsuario = :userId")
    List<EchoSystem> findAllEchoSystemByArtistaId(@Param("userId") Integer userId);

    @Query("SELECT e FROM EchoSystem e WHERE e.artista.idUsuario = :userId ORDER BY e.streams DESC")
    List<EchoSystem> findTop3TituloMusicaByOrderByStreamDesc(@Param("userId") Integer userId, Pageable pageable);

    @Query("SELECT e FROM EchoSystem e WHERE e.artista.idUsuario = :userId ORDER BY e.curtidas DESC")
    List<EchoSystem> findTop3TituloMusicaByOrderByCurtidasDesc(@Param("userId") Integer userId, Pageable pageable);

    @Query("SELECT e FROM EchoSystem e WHERE e.artista.idUsuario = :userId ORDER BY e.redirecionamento DESC")
    List<EchoSystem> findTop3TituloMusicaByOrderByRedirecionamentoDesc(@Param("userId") Integer userId, Pageable pageable);

    @Query("SELECT e FROM EchoSystem e WHERE LOWER(e.genero) = 'rock'")
    List<EchoSystem> buscarPorGeneroRock();

    @Query("SELECT e FROM EchoSystem e WHERE LOWER(e.genero) = 'pop'")
    List<EchoSystem> buscarPorGeneroPop();

    @Query("SELECT e FROM EchoSystem e WHERE LOWER(e.genero) = 'future core'")
    List<EchoSystem> buscarPorGeneroFutureCore();

    @Query("SELECT e FROM EchoSystem e WHERE LOWER(REPLACE(e.genero, '-', '')) = 'kpop'")
    List<EchoSystem> buscarPorGeneroKpop();

    @Query("SELECT e FROM EchoSystem e WHERE LOWER(REPLACE(e.genero, '-', '')) = 'jrock'")
    List<EchoSystem> buscarPorGeneroJrock();

    @Query("SELECT e FROM EchoSystem e WHERE LOWER(REPLACE(e.genero, '/', ' ')) = 'hip hop rap'")
    List<EchoSystem> buscarPorGeneroHipHopRap();

    @Query("SELECT e FROM EchoSystem e WHERE LOWER(REPLACE(e.genero, '/', ' ')) = 'r&b soul'")
    List<EchoSystem> buscarPorGeneroRbSoul();

    @Query("SELECT e FROM EchoSystem e WHERE LOWER(e.genero) = 'indie'")
    List<EchoSystem> buscarPorGeneroIndie();

    @Query("SELECT e FROM EchoSystem e WHERE LOWER(e.genero) = 'edm'")
    List<EchoSystem> buscarPorGeneroEdm();

    @Query("SELECT e FROM EchoSystem e WHERE LOWER(REPLACE(e.genero, '-', ' ')) = 'edm kawaii'")
    List<EchoSystem> buscarPorGeneroEdmKawaii();

    @Query("SELECT e FROM EchoSystem e WHERE LOWER(e.genero) = 'jazz'")
    List<EchoSystem> buscarPorGeneroJazz();

    @Query("SELECT e FROM EchoSystem e WHERE LOWER(e.genero) = 'sertanejo'")
    List<EchoSystem> buscarPorGeneroSertanejo();

    @Query("SELECT e FROM EchoSystem e WHERE LOWER(e.genero) = 'eletro swing'")
    List<EchoSystem> buscarPorGeneroEletroSwing();

    @Query("SELECT e FROM EchoSystem e WHERE LOWER(e.genero) = 'pagode'")
    List<EchoSystem> buscarPorGeneroPagode();


}
