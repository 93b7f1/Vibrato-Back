package vibrato.vibrato.entidades;


import javax.persistence.*;

@Entity
@Table(name ="echo")
public class EchoSystem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEcho")
    private Integer idEcho;

    @ManyToOne
    private Artista artista;

    @Column(name = "tituloMusica")
    private String tituloMusica;

    @Column(name = "tituloAlbum")
    private String tituloAlbum;
    @Column(name = "compositor")
    private String compositor;

    @Column(name = "genero")
    private String genero;

    @Column(name = "lyrics", length = 3000)
    private String lyrics;

    @Column(name = "spotify")
    private String spotify;

    @Column(name = "youtube")
    private String youtube;

    @Column(name = "soundCloud")
    private String soundCloud;

    @Column(name = "deezer")
    private String deezer;

    @Column(name = "amazonMusic")
    private String amazonMusic;

    @Column(name = "appleMusic")
    private String appleMusic;

    @Column(name = "otherPlataform1")
    private String otherPlataform1;

    @Column(name = "otherLink1")
    private String otherLink1;

    
    @Column(name = "imagem")
    private String blob;

    @Column(name = "visualizacao")
    private Integer visualizacao;


    @Column(name = "stream")
    private Integer streams;

    @Column(name = "redirecionamento")
    private Integer redirecionamento;

    @Column(name = "curtidas")
    private Integer curtidas;



    public Artista getArtista() {
        return artista;
    }


    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public String getOtherLink1() {
        return otherLink1;
    }

    public void setOtherLink1(String otherLink1) {
        this.otherLink1 = otherLink1;
    }

    public Integer getIdEcho() {
        return idEcho;
    }

    public String getBlob() {
        return blob;
    }

    public void setBlob(String blob) {
        this.blob = blob;
    }

    public void setIdEcho(Integer idEcho) {
        this.idEcho = idEcho;
    }

    public String getTituloMusica() {
        return tituloMusica;
    }

    public void setTituloMusica(String tituloMusica) {
        this.tituloMusica = tituloMusica;
    }

    public String getTituloAlbum() {
        return tituloAlbum;
    }

    public void setTituloAlbum(String tituloAlbum) {
        this.tituloAlbum = tituloAlbum;
    }

    public String getCompositor() {
        return compositor;
    }

    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getSpotify() {
        return spotify;
    }

    public void setSpotify(String spotify) {
        this.spotify = spotify;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }

    public String getSoundCloud() {
        return soundCloud;
    }

    public void setSoundCloud(String soundCloud) {
        this.soundCloud = soundCloud;
    }

    public String getDeezer() {
        return deezer;
    }

    public void setDeezer(String deezer) {
        this.deezer = deezer;
    }

    public String getAmazonMusic() {
        return amazonMusic;
    }

    public void setAmazonMusic(String amazonMusic) {
        this.amazonMusic = amazonMusic;
    }

    public String getAppleMusic() {
        return appleMusic;
    }

    public void setAppleMusic(String appleMusic) {
        this.appleMusic = appleMusic;
    }

    public String getOtherPlataform1() {
        return otherPlataform1;
    }

    public void setOtherPlataform1(String otherPlataform1) {
        this.otherPlataform1 = otherPlataform1;
    }


    public Integer getVisualizacao() { return visualizacao; }

    public void setVisualizacao(Integer visualizacao) { this.visualizacao = visualizacao; }

    public void setRedirecionamento(Integer redirecionamento) { this.redirecionamento = redirecionamento;}

    public void setCurtidas(Integer curtidas) { this.curtidas = curtidas;}

    public Integer getRedirecionamento() { return redirecionamento; }

    public Integer getCurtidas() { return curtidas; }

    public Integer getStreams() { return streams;}

    public void setStreams(Integer streams) { this.streams = streams;}
}
