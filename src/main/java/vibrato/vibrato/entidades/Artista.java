package vibrato.vibrato.entidades;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@DiscriminatorValue("Artista")
public class Artista extends Usuario {


    @OneToMany(mappedBy = "artista")
    private List<EchoSystem> echoSystems;


}
