package vibrato.vibrato.controllers;

import org.springframework.web.bind.annotation.*;
import vibrato.vibrato.services.ArtistaService;


@RestController
@CrossOrigin("*")
@RequestMapping("/artistas")
public class ArtistaController {

    private ArtistaService artistaService;
    public ArtistaController(ArtistaService artistaService){
        this.artistaService = artistaService;

    }




}
