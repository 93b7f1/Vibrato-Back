package vibrato.vibrato.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.configuration.IMockitoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import vibrato.vibrato.dto.DtoExplore;
import vibrato.vibrato.entidades.EchoSystem;
import vibrato.vibrato.entidades.Usuario;
import vibrato.vibrato.repositories.EchoSystemRepository;
import vibrato.vibrato.services.EchoSystemService;

import javax.validation.constraints.AssertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EchoSystemControllerTest {

    @MockBean
    EchoSystemService echoSystemService;

    @MockBean
    EchoSystemRepository echoSystemRepository;

    @Autowired
    EchoSystemController echoSystemController;

    @Test
    void testeListarMusicasVazia() {

        List<EchoSystem> musicas = new ArrayList<>();

        Mockito.when(echoSystemService.echoSystemList()).thenReturn(musicas);

        ResponseEntity<List<EchoSystem>> resposta = echoSystemController.listaEchos();

        assertTrue(resposta.getBody().isEmpty());
    }

    @Test
    void testeListarMusicaCheio(){
        List<EchoSystem> musicas = List.of(new EchoSystem(), new EchoSystem());

        Mockito.when(echoSystemService.echoSystemList()).thenReturn(musicas);

        ResponseEntity<List<EchoSystem>> resposta = echoSystemController.listaEchos();

        assertTrue(Objects.nonNull(resposta.getBody()));
        assertEquals(200, resposta.getStatusCodeValue());
    }

    @Test
    void testeListarTop5Vazio(){
        List<EchoSystem> musicas =  new ArrayList<>();

        Mockito.when(echoSystemService.listarTop5GenericoPerfil()).thenReturn(musicas);

        ResponseEntity<List<EchoSystem>> resposta = echoSystemController.listarTop5();

        assertTrue(Objects.isNull(resposta.getBody()));
        assertEquals(204, resposta.getStatusCodeValue());
    }

    @Test
    void testeListarTop5Cheia(){
        List<EchoSystem> musicas =  List.of(new EchoSystem(), new EchoSystem());

        Mockito.when(echoSystemService.listarTop5GenericoPerfil()).thenReturn(musicas);

        ResponseEntity<List<EchoSystem>> resposta = echoSystemController.listarTop5();

        assertTrue(Objects.nonNull(resposta.getBody()));
        assertEquals(200, resposta.getStatusCodeValue());
    }

    @Test
    void testeListaExploreVazio(){
        List<DtoExplore> musicas = new ArrayList<>();

        Mockito.when(echoSystemService.listarTudo()).thenReturn(musicas);

        ResponseEntity<List<DtoExplore>> resposta = echoSystemController.listarTodos();

        assertEquals(204, resposta.getStatusCodeValue());
    }

    @Test
    void testeBuscaLast3ComIdInexistente(){
        List<EchoSystem> musicas = new ArrayList<>();
        Integer id = 1;

        Mockito.when(echoSystemService.getTop3EchoSystemByArtistaId(id)).thenReturn(musicas);

        ResponseEntity<List<EchoSystem>> resposta = echoSystemController.getTop3EchoSystemsByArtistaId(id);

        assertEquals(404, resposta.getStatusCodeValue());
    }

    @Test
    void testeBuscaPorIdParaDeletarMusicaComIdinexistente(){
        Integer id = 1;

        Mockito.when(echoSystemService.buscarPorId(id)).thenReturn(Optional.empty());

        ResponseEntity<Void> resposta = echoSystemController.deleteEcho(id);

        assertEquals(404, resposta.getStatusCodeValue());
    }

    @Test
    void testeRespostaBuscaPorGeneroRockVazio(){
        List<EchoSystem> musicas = new ArrayList<>();

        Mockito.when(echoSystemService.findAllEchoSystemGeneroRock()).thenReturn(musicas);

        ResponseEntity<List<EchoSystem>> resposta = echoSystemController.listarGeneroRock();

        assertEquals(204, resposta.getStatusCodeValue());
    }

    @Test
    void testeRespostaBuscaPorGeneroSertanejoVazio(){
        List<EchoSystem> musicas = new ArrayList<>();

        Mockito.when(echoSystemService.findAllEchoSystemGeneroSertanejo()).thenReturn(musicas);

        ResponseEntity<List<EchoSystem>> resposta = echoSystemController.listarGeneroSertanejo();

        assertEquals(204, resposta.getStatusCodeValue());
    }

    @Test
    void testeRespostaBuscaPorGeneroJRockVazio(){
        List<EchoSystem> musicas = new ArrayList<>();

        Mockito.when(echoSystemService.findAllEchoSystemGeneroJrock()).thenReturn(musicas);

        ResponseEntity<List<EchoSystem>> resposta = echoSystemController.listarGeneroJrock();

        assertEquals(204, resposta.getStatusCodeValue());
    }

    @Test
    void testeRespostaBuscaPorGeneroPagodeVazio(){
        List<EchoSystem> musicas = new ArrayList<>();

        Mockito.when(echoSystemService.findAllEchoSystemGeneroPagode()).thenReturn(musicas);

        ResponseEntity<List<EchoSystem>> resposta = echoSystemController.listarGeneroPagode();

        assertEquals(204, resposta.getStatusCodeValue());
    }

    @Test
    void testeRespostaBuscaPorGeneroKPopVazio(){
        List<EchoSystem> musicas = new ArrayList<>();

        Mockito.when(echoSystemService.findAllEchoSystemGeneroKpop()).thenReturn(musicas);

        ResponseEntity<List<EchoSystem>> resposta = echoSystemController.listarGeneroKpop();

        assertEquals(204, resposta.getStatusCodeValue());
    }

    @Test
    void testeRespostaBuscaPorGeneroEdmKawaiiVazio(){
        List<EchoSystem> musicas = new ArrayList<>();

        Mockito.when(echoSystemService.findAllEchoSystemGeneroEdmKawaii()).thenReturn(musicas);

        ResponseEntity<List<EchoSystem>> resposta = echoSystemController.listarGeneroEdmKawaii();

        assertEquals(204, resposta.getStatusCodeValue());
    }

    @Test
    void testeRespostaBuscaPorGeneroEdmVazio(){
        List<EchoSystem> musicas = new ArrayList<>();

        Mockito.when(echoSystemService.findAllEchoSystemGeneroEdm()).thenReturn(musicas);

        ResponseEntity<List<EchoSystem>> resposta = echoSystemController.listarGeneroEdm();

        assertEquals(204, resposta.getStatusCodeValue());
    }

    @Test
    void testeRespostaBuscaPorGeneroIndieVazio(){
        List<EchoSystem> musicas = new ArrayList<>();

        Mockito.when(echoSystemService.findAllEchoSystemGeneroIndie()).thenReturn(musicas);

        ResponseEntity<List<EchoSystem>> resposta = echoSystemController.listarGeneroIndie();

        assertEquals(204, resposta.getStatusCodeValue());
    }

    @Test
    void testeRespostaBuscaPorGeneroJazzVazio(){
        List<EchoSystem> musicas = new ArrayList<>();

        Mockito.when(echoSystemService.findAllEchoSystemGeneroJazz()).thenReturn(musicas);

        ResponseEntity<List<EchoSystem>> resposta = echoSystemController.listarGeneroJazz();

        assertEquals(204, resposta.getStatusCodeValue());
    }

    @Test
    void testeRespostaBuscaPorGeneroPopVazio(){
        List<EchoSystem> musicas = new ArrayList<>();

        Mockito.when(echoSystemService.findAllEchoSystemGeneroPop()).thenReturn(musicas);

        ResponseEntity<List<EchoSystem>> resposta = echoSystemController.listarGeneroPop();

        assertEquals(204, resposta.getStatusCodeValue());
    }

    @Test
    void testeRespostaBuscaPorGeneroEletroSwingVazio(){
        List<EchoSystem> musicas = new ArrayList<>();

        Mockito.when(echoSystemService.findAllEchoSystemGeneroEletroSwing()).thenReturn(musicas);

        ResponseEntity<List<EchoSystem>> resposta = echoSystemController.listarGeneroEletroSwing();

        assertEquals(204, resposta.getStatusCodeValue());
    }

    @Test
    void testeRespostaBuscaPorGeneroFuteCoreVazio(){
        List<EchoSystem> musicas = new ArrayList<>();

        Mockito.when(echoSystemService.findAllEchoSystemGeneroFutureCore()).thenReturn(musicas);

        ResponseEntity<List<EchoSystem>> resposta = echoSystemController.listarGeneroFuteCore();

        assertEquals(204, resposta.getStatusCodeValue());
    }

    @Test
    void testeRespostaBuscaPorGeneroHipHopRapVazio(){
        List<EchoSystem> musicas = new ArrayList<>();

        Mockito.when(echoSystemService.findAllEchoSystemGeneroHipHopRap()).thenReturn(musicas);

        ResponseEntity<List<EchoSystem>> resposta = echoSystemController.listarGeneroHipHopRap();

        assertEquals(204, resposta.getStatusCodeValue());
    }

    @Test
    void testeRespostaBuscaPorGeneroRbSoulVazio(){
        List<EchoSystem> musicas = new ArrayList<>();

        Mockito.when(echoSystemService.findAllEchoSystemGeneroRbSoul()).thenReturn(musicas);

        ResponseEntity<List<EchoSystem>> resposta = echoSystemController.listarGeneroRbSoul();

        assertEquals(204, resposta.getStatusCodeValue());
    }

    @Test
    void testeRedirecionamentoComIdInexistente(){
        Integer id = 1;

        Mockito.when(echoSystemService.buscarId(id)).thenReturn(Optional.empty());

        ResponseEntity<EchoSystem> resposta = echoSystemController.redirecionamentoPlays(id, new EchoSystem());

        assertEquals(404, resposta.getStatusCodeValue());
    }

    @Test
    void testeGet3MusicaByCurtidaComIdInexistente(){
        List<EchoSystem> musicas = new ArrayList<>();

        Mockito.when(echoSystemService.curtidasDesc(1,0,3)).thenReturn(musicas);

        ResponseEntity<List<EchoSystem>> resposta = echoSystemController.getTop3MusicasByCurtida(1);

        assertEquals(200, resposta.getStatusCodeValue());
    }

    @Test
    void testeGet3MusicaByRedirecionamentoComIdInexistente(){
        List<EchoSystem> musicas = new ArrayList<>();

        Mockito.when(echoSystemService.redirecionamentoDesc(1,0,3)).thenReturn(musicas);

        ResponseEntity<List<EchoSystem>> resposta = echoSystemController.getTop3MusicasByRedirecionamento(1);

        assertEquals(200, resposta.getStatusCodeValue());
    }

    @Test
    void testeBuscarPorIdEchoLinkComIdInexistente(){
        Integer id = 1;

        Mockito.when(echoSystemService.buscarId(id)).thenReturn(Optional.empty());

        ResponseEntity<Optional<EchoSystem>> resposta = echoSystemController.buscarPorId(id);

        assertEquals(204, resposta.getStatusCodeValue());
    }

    @Test
    void testeGet3MusicaByPlayComIdExistente(){
        List<EchoSystem> musicas = new ArrayList<>();

        Mockito.when(echoSystemService.streamDesc(1,0,3)).thenReturn(musicas);

        ResponseEntity<List<EchoSystem>> resposta = echoSystemController.getTop3MusicasByPlay(1);

        assertEquals(200, resposta.getStatusCodeValue());
    }

    @Test
    void testeGet3MusicasComUsernameInexistente(){
        List<EchoSystem> musicas = new ArrayList<>();
        String a = "abc";

        Mockito.when(echoSystemService.visualizacaoDescUsername(a,0,3)).thenReturn(musicas);

        ResponseEntity<List<EchoSystem>> resposta = echoSystemController.getTop3EchoSystemsByArtistaUsername(a);

        assertEquals(404, resposta.getStatusCodeValue());
    }

    @Test
    void testeGetAllEchoByIdComIdExistente(){
        List<EchoSystem> musicas = List.of(new EchoSystem());

        Mockito.when(echoSystemService.findAllEchoSystemByArtistaId(1)).thenReturn(musicas);

        ResponseEntity<List<EchoSystem>> resposta = echoSystemController.getAllEchoSystemByArtistaId(1);

        assertEquals(200, resposta.getStatusCodeValue());
    }

    @Test
    void testeGetTop3VizualizacaoByIdComIdExistente(){
        List<EchoSystem> musicas = List.of();

        Mockito.when(echoSystemService.visualizacaoDesc(1,0,3)).thenReturn(musicas);

        ResponseEntity<List<EchoSystem>> resposta = echoSystemController.getTop3EchoSystemByArtistaId(1);

        assertEquals(200, resposta.getStatusCodeValue());
    }



}
