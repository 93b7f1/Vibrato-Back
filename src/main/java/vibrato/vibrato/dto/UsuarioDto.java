package vibrato.vibrato.dto;

public class UsuarioDto {
private String username;
private String email;
private String senha;

    public UsuarioDto(String username, String email, String senha) {
        this.username = username;
        this.email = email;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
