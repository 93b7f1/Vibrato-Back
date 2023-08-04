package vibrato.vibrato.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import vibrato.vibrato.entidades.Artista;
import vibrato.vibrato.entidades.EchoSystem;
import vibrato.vibrato.entidades.Ouvinte;
import vibrato.vibrato.entidades.Usuario;
import vibrato.vibrato.repositories.UsuarioRepository;
import vibrato.vibrato.security.Token;
import vibrato.vibrato.security.TokenUtil;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    private PasswordEncoder passwordEncoder;

    private final Logger logger = LoggerFactory.getLogger(ArtistaService.class);

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Usuario> listarUsuario() {
//        logger.info("Usuario: " + getLogado() + " Listando Usuarios");
        return usuarioRepository.findAll();
    }

    public Artista criarArtista(Artista artista) {
        if (usuarioRepository.existsByUsername(artista.getUsername())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe um usuário com esse username");
        }
        if (usuarioRepository.existsByEmail(artista.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe um usuário com esse email");
        }
        String encoder = this.passwordEncoder.encode(artista.getSenha());
        artista.setSenha(encoder);
        logger.info("Usuario: " + getLogado() + " Criando Usuario");
        return usuarioRepository.save(artista);
    }

    public Ouvinte criarOuvinte(Ouvinte ouvinte) {
        if (usuarioRepository.existsByUsername(ouvinte.getUsername())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe um usuário com esse username");
        }
        if (usuarioRepository.existsByEmail(ouvinte.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe um usuário com esse email");
        }
        String encoder = this.passwordEncoder.encode(ouvinte.getSenha());
        ouvinte.setSenha(encoder);
        logger.info("Usuario: " + getLogado() + " Criando Usuario");
        return usuarioRepository.save(ouvinte);
    }

    public Usuario editarUsuario(Usuario usuario) {

        return usuarioRepository.save(usuario);
    }

    public Boolean excluirUsuario(Integer id) {
        usuarioRepository.deleteById(id);
        logger.info("Usuario: " + getLogado() + " Excluindo Usuario");
        return true;
    }

    public Token gerarToken(Usuario usuario) {
        Optional<Usuario> user = usuarioRepository.findByEmail(usuario.getEmail());
        if (user.isPresent()) {
            Boolean valid = passwordEncoder.matches(usuario.getSenha(), user.get().getSenha());
            if (valid) {
                return new Token(TokenUtil.createToken(user.get()));
            }
        }
        return null;
    }

    private String getLogado() {
        Authentication userLogado = SecurityContextHolder.getContext().getAuthentication();
        if(!(userLogado instanceof AnonymousAuthenticationToken)) {
            return userLogado.getName();
        }
        return "Null";
    }
    public Optional<Usuario> buscarUsuarioPorId(Integer id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> buscarUsuarioPorUser(String username) {
        return usuarioRepository.findByUsername(username);
    }

    public Optional<Usuario> buscarId(Integer id){
        Optional<Usuario> busca =  usuarioRepository.findById(id);
        return busca;
    }

    public Usuario atualizarEmail(Usuario u, String email){
        usuarioRepository.atualizarEmail(email, u.getIdUsuario());
        return buscarId(u.getIdUsuario()).get();
    }

    public Usuario atualizarSenha(Usuario u, String senha){
        String encoder = this.passwordEncoder.encode(senha);
        usuarioRepository.atualizarSenha(encoder, u.getIdUsuario());
        return buscarId(u.getIdUsuario()).get();
    }

    public void deletarConta(Integer id){
        usuarioRepository.deletarConta(id);
    }


}
