package vibrato.vibrato.services;

import org.springframework.stereotype.Service;
import vibrato.vibrato.entidades.Ouvinte;
import vibrato.vibrato.repositories.OuvinteRepository;

import java.util.List;

@Service
public class OuvinteService {
private OuvinteRepository ouvinteRepository;

public OuvinteService(OuvinteRepository ouvinteRepository){
    this.ouvinteRepository = ouvinteRepository;
}


}
