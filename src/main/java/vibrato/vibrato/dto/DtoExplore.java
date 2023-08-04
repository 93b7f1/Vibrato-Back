package vibrato.vibrato.dto;

public class DtoExplore {

    private String tituloMusica;

    private String cantor;

    private Integer idEcho;

    private String blob;

    public DtoExplore(String tituloMusica, String cantor, Integer idEcho, String blob) {
        this.tituloMusica = tituloMusica;
        this.cantor = cantor;
        this.idEcho = idEcho;
        this.blob = blob;
    }

    public String getTituloMusica() {
        return tituloMusica;
    }

    public void setTituloMusica(String tituloMusica) {
        this.tituloMusica = tituloMusica;
    }

    public String getCantor() {
        return cantor;
    }

    public void setCantor(String cantor) {
        this.cantor = cantor;
    }

    public Integer getIdEcho() {
        return idEcho;
    }

    public void setIdEcho(Integer idEcho) {
        this.idEcho = idEcho;
    }

    public String getBlob() {
        return blob;
    }

    public void setBlob(String blob) {
        this.blob = blob;
    }
}
