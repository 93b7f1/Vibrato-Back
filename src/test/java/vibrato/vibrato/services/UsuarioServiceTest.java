package vibrato.vibrato.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import vibrato.vibrato.entidades.Usuario;
import vibrato.vibrato.repositories.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @Mock
    UsuarioRepository usuarioRepository;

    @InjectMocks
    UsuarioService usuarioService;



    @Test
    void listarUsuarioVazia() {

        List<Usuario> usuarios = new ArrayList<>();

        Mockito.when(usuarioRepository.findAll()).thenReturn(usuarios);

        List<Usuario> resposta = usuarioService.listarUsuario();

        assertTrue(resposta.isEmpty());
        assertTrue(resposta.size() == 0);

    }

    @Test
    void listarUsuario() {

        List<Usuario> usuarios = List.of(new Usuario(), new Usuario(), new Usuario());

        Mockito.when(usuarioRepository.findAll()).thenReturn(usuarios);

        List<Usuario> resposta = usuarioService.listarUsuario();

        assertFalse(resposta.isEmpty());
        assertTrue(resposta.size() == 3);

    }

    @Test
    void buscarUsuarioPorIdInexistente(){
        Integer id = 1;

        Mockito.when(usuarioRepository.findById(id)).thenReturn(Optional.empty());

        Optional<Usuario> resposta= usuarioService.buscarUsuarioPorId(id);

        assertTrue(resposta.isEmpty());
    }
}