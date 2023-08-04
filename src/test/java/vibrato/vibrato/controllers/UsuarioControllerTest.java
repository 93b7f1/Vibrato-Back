package vibrato.vibrato.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import vibrato.vibrato.entidades.Artista;
import vibrato.vibrato.entidades.Ouvinte;
import vibrato.vibrato.entidades.Usuario;
import vibrato.vibrato.repositories.UsuarioRepository;
import vibrato.vibrato.services.UsuarioService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UsuarioControllerTest {

    @MockBean
    UsuarioService usuarioService;

    @MockBean
    UsuarioRepository usuarioRepository;

    @Autowired
    UsuarioController controller;

    @Test
    void testeListagemUsuariosVazia() {
        List<Usuario> usuarios = new ArrayList<>();

        Mockito.when(usuarioService.listarUsuario()).thenReturn(usuarios);

        ResponseEntity<List<Usuario>> resposta = controller.listaUsuarios();

        assertTrue(resposta.getBody().isEmpty());
    }

    @Test
    void testeListagemUsuariosCheia() {
        List<Usuario> usuarios = List.of(new Usuario(), new Usuario());

        Mockito.when(usuarioService.listarUsuario()).thenReturn(usuarios);

        ResponseEntity<List<Usuario>> resposta = controller.listaUsuarios();

        assertTrue(Objects.nonNull(resposta.getBody()));
        assertEquals(200, resposta.getStatusCodeValue());
    }

    @Test
    void testeBuscaPorIdComIdInexistente() {

        Integer id = 1;

        Mockito.when(usuarioService.buscarId(id)).thenReturn(Optional.empty());

        ResponseEntity<Optional<Usuario>> resposta = controller.buscarPorId(id);

        assertEquals(204, resposta.getStatusCodeValue());
    }

    @Test
    void testeBuscaPorUsernameComUsernameInexistente() {

        String username = "abc";

        Mockito.when(usuarioService.buscarUsuarioPorUser(username)).thenReturn(Optional.empty());

        ResponseEntity<Optional<Usuario>> resposta = controller.buscarPorUser(username);

        assertEquals(204, resposta.getStatusCodeValue());
    }

    @Test
    void testeAtualizarSenhaComIdInexistente(){
        Integer id = 1;

        Mockito.when(usuarioService.buscarId(id)).thenReturn(Optional.empty());

        ResponseEntity<Usuario> resposta = controller.atualizarSenha(id, new Usuario());

        assertEquals(204, resposta.getStatusCodeValue());
    }

    @Test
    void testeAtualizarEmailComIdInexistente(){
        Integer id = 1;

        Mockito.when(usuarioService.buscarId(id)).thenReturn(Optional.empty());

        ResponseEntity<Usuario> resposta = controller.atualizarEmail(id, new Usuario());

        assertEquals(204, resposta.getStatusCodeValue());
    }

    @Test
    void testeDeletarUsuarioComIdInexistente(){
        Integer id = 1;

        Mockito.when(usuarioService.buscarId(id)).thenReturn(Optional.empty());

        ResponseEntity<Void> resposta = controller.deletarConta(id);

        assertEquals(204, resposta.getStatusCodeValue());
    }

    @Test
    void testeCriarOuvinte(){

        Mockito.when(usuarioService.criarOuvinte(new Ouvinte())).thenReturn(new Ouvinte());

        ResponseEntity<Usuario> resposta = controller.criarOuvinte(new Ouvinte());

        assertEquals(201, resposta.getStatusCodeValue());
    }

    @Test
    void testeCriarArtista(){

        Mockito.when(usuarioService.criarArtista(new Artista())).thenReturn(new Artista());

        ResponseEntity<Usuario> resposta = controller.criarArtista(new Artista());

        assertEquals(201, resposta.getStatusCodeValue());
    }

    @Test
    void testeAtualizarUsuario(){

        Mockito.when(usuarioService.editarUsuario(new Usuario())).thenReturn(new Usuario());

        ResponseEntity<Usuario> resposta = controller.editarUsuario(new Usuario());

        assertEquals(200, resposta.getStatusCodeValue());
    }

    @Test
    void testeDeletarUsuario(){

        Mockito.when(usuarioService.excluirUsuario(1)).thenReturn(null);

        ResponseEntity<?> resposta = controller.excluirUsuario(1);

        assertEquals(204, resposta.getStatusCodeValue());
    }






}