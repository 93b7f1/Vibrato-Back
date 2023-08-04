package vibrato.vibrato.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vibrato.vibrato.dto.UsuarioDto;
import vibrato.vibrato.entidades.Artista;
import vibrato.vibrato.repositories.ArtistaRepository;
import vibrato.vibrato.security.Token;
import vibrato.vibrato.security.TokenUtil;

import java.util.List;

@Service
public class ArtistaService {

    private ArtistaRepository artistaRepository;


    public ArtistaService(ArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
    }


}
