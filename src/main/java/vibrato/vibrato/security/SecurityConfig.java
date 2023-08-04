package vibrato.vibrato.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter  {
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html");
    }
    public void configure(HttpSecurity httpSec) throws Exception {
        httpSec.csrf().disable()
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.POST, "/usuarios/login").permitAll()
                .antMatchers(HttpMethod.POST, "/artistas/cadastrar").permitAll()
                .antMatchers(HttpMethod.POST, "/usuarios/artista").permitAll()
                .antMatchers(HttpMethod.POST, "/usuarios/ouvinte").permitAll()
                .antMatchers(HttpMethod.POST, "/echo").permitAll()
                .antMatchers(HttpMethod.GET, "/echo").permitAll()
                .antMatchers(HttpMethod.GET, "/echo/explore").permitAll()
                .antMatchers(HttpMethod.GET, "/usuarios/**").permitAll()
                .antMatchers(HttpMethod.GET, "/echo/echolink/**").permitAll()
                .antMatchers(HttpMethod.PATCH, "/usuarios").permitAll()
                .antMatchers(HttpMethod.GET, "/echo/top5").permitAll()
                .antMatchers(HttpMethod.GET, "/echo/artista/**").permitAll()
                .antMatchers(HttpMethod.GET, "/artista/**").permitAll()
                .antMatchers(HttpMethod.GET, "/echo/last3/**").permitAll()
                .antMatchers(HttpMethod.GET, "/echo/last33/**").permitAll()
                .antMatchers(HttpMethod.GET, "/echo/visu/**").permitAll()
                .antMatchers(HttpMethod.GET, "/echo/visu100/**").permitAll()
                .antMatchers(HttpMethod.GET, "/echo/visuu/**").permitAll()
                .antMatchers(HttpMethod.PATCH, "/echo/streams/**").permitAll()
                .antMatchers(HttpMethod.PATCH, "/echo/redirecionamento/**").permitAll()
                .antMatchers(HttpMethod.PATCH, "/echo/visualizacao/**").permitAll()
                .antMatchers(HttpMethod.PATCH, "/usuarios/atualizar/perfil/email/**").permitAll()
                .antMatchers(HttpMethod.PATCH, "/usuarios/atualizar/perfil/senha/**").permitAll()
                .antMatchers(HttpMethod.DELETE, "/usuarios/deletar/**").permitAll()
                .antMatchers(HttpMethod.DELETE, "/echo/deletar/echo/**").permitAll()
                .antMatchers(HttpMethod.PATCH, "/echo/curtidas/**").permitAll()
                .antMatchers(HttpMethod.GET, "/echo/top3-musicas-recentes").permitAll()
                .antMatchers(HttpMethod.GET, "/echo/top3-musicas-ouvidas").permitAll()
                .antMatchers(HttpMethod.GET, "/echo/gerarArquivoTxt/**").permitAll()
                .antMatchers(HttpMethod.GET, "/echo/visu-csv/**").permitAll()
                .antMatchers(HttpMethod.POST, "/echo/importar-csv/**").permitAll()
                .antMatchers(HttpMethod.GET, "/echo/lerArquivoTxt/**").permitAll()
                .antMatchers(HttpMethod.GET, "/echo/explore").permitAll()
                .antMatchers(HttpMethod.GET, "/echo/per/**").permitAll()
                .antMatchers(HttpMethod.GET, "/echo/likes/**").permitAll()
                .antMatchers(HttpMethod.GET, "/echo/streams/**").permitAll()
                .antMatchers(HttpMethod.GET, "/echo/redirec/**").permitAll()
                .antMatchers(HttpMethod.GET, "/per/**").permitAll()
                .antMatchers(HttpMethod.GET, "/echo/genero/rock").permitAll()
                .antMatchers(HttpMethod.GET, "/echo/genero/pop").permitAll()
                .antMatchers(HttpMethod.GET, "/echo/genero/future-core").permitAll()
                .antMatchers(HttpMethod.GET, "/echo/genero/kpop").permitAll()
                .antMatchers(HttpMethod.GET, "/echo/genero/hip-hop-rap").permitAll()
                .antMatchers(HttpMethod.GET, "/echo/genero/r&b-soul").permitAll()
                .antMatchers(HttpMethod.GET, "/echo/genero/indie").permitAll()
                .antMatchers(HttpMethod.GET, "/echo/genero/jrock").permitAll()
                .antMatchers(HttpMethod.GET, "/echo/genero/edm").permitAll()
                .antMatchers(HttpMethod.GET, "/echo/genero/edm-kawaii").permitAll()
                .antMatchers(HttpMethod.GET, "/echo/genero/jazz").permitAll()
                .antMatchers(HttpMethod.GET, "/echo/genero/sertanejo").permitAll()
                .antMatchers(HttpMethod.GET, "/echo/genero/eletro-swing").permitAll()
                .antMatchers(HttpMethod.GET, "/echo/genero/pagode").permitAll()




                .anyRequest().authenticated().and().cors();

        httpSec.addFilterBefore(new SecurityFilter(), UsernamePasswordAuthenticationFilter.class);

    }
}