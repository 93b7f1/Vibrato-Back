package vibrato.vibrato.entidades;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoUsuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Integer idUsuario;

    @Column(name = "nome")
    private String nome;


    @Column(name = "senha")
    private String senha;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

        @Column(name = "twitter")
        private String twitter;

        @Column(name = "instagram")
        private String instagram;

        @Column(name = "spotify")
        private String spotify;

        @Column(name = "soundcloud")
        private String soundcloud;

        @Column(name = "genero")
        private String genero;

        @Column(name = "biografia", length = 3000)
        private String biografia;

        @Column(name = "imagem")
        private String blob;

        @Column(name = "visualizacao")
        private Integer visualizacao;

    @Transient
    private String novaSenha;
    public Usuario() {
    }
    @JsonProperty("tipoUsuario")
    public String getTipoUsuario() {
        DiscriminatorValue annotation = this.getClass().getAnnotation(DiscriminatorValue.class);
        if (annotation != null) {
            return annotation.value();
        }
        return null;
    }

    public Usuario(String nome, String senha, String email, String username) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.username = username;
    }

    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getSpotify() {
        return spotify;
    }

    public void setSpotify(String spotify) {
        this.spotify = spotify;
    }

    public String getSoundcloud() {
        return soundcloud;
    }

    public void setSoundcloud(String soundcloud) {
        this.soundcloud = soundcloud;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getBlob() {
        return blob;
    }

    public void setBlob(String blob) {
        this.blob = blob;
    }

    public Integer getVisualizacao() {
        return visualizacao;
    }

    public void setVisualizacao(Integer visualizacao) {
        this.visualizacao = visualizacao;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

