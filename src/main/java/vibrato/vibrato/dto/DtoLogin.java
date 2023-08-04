package vibrato.vibrato.dto;

import vibrato.vibrato.security.Token;

public class DtoLogin {

    private Integer id;
    private String username;
    private Token token;
    private String tipoUsuario;

    public DtoLogin(Integer id, String username, Token token,String tipoUsuario) {
        this.id = id;
        this.username = username;
        this.token = token;
        this.tipoUsuario = tipoUsuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
