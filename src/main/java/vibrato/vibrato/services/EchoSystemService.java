package vibrato.vibrato.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import vibrato.vibrato.dto.DtoExplore;
import vibrato.vibrato.entidades.EchoSystem;
import vibrato.vibrato.entidades.Usuario;
import vibrato.vibrato.repositories.EchoSystemRepository;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EchoSystemService {

    private EchoSystemRepository echoSystemRepository;

    public EchoSystemService(EchoSystemRepository echoSystemRepository){
        this.echoSystemRepository = echoSystemRepository;
    }

    public EchoSystem addMusica(EchoSystem novaMusica){
        EchoSystem musicBanco = echoSystemRepository.save(novaMusica);
        return musicBanco;
    }
    public List<EchoSystem> echoSystemList() {
        return echoSystemRepository.findAll();
    }

    public List<EchoSystem> listarTop5GenericoPerfil(){
        List<EchoSystem> lista = echoSystemRepository.findTop5ByOrderByIdEchoDesc();
        return lista;
    }


    public Optional<EchoSystem> buscarId(Integer id){
        Optional<EchoSystem> busca =  echoSystemRepository.findById(id);
        return busca;
        }
    public Optional<EchoSystem> buscarPorId(Integer id) {
        return echoSystemRepository.findById(id);
    }
    public List<DtoExplore> listarTudo(){
        List<EchoSystem> lista = echoSystemRepository.findAllByOrderByIdEchoDesc();
        List<DtoExplore> listaFiltrada = new ArrayList<>();
        for (EchoSystem e:
             lista) {
            DtoExplore d = new DtoExplore(e.getTituloMusica(),e.getCompositor(),e.getIdEcho(),e.getBlob());
            listaFiltrada.add(d);
        }
        return listaFiltrada;
    }

    public List<EchoSystem> getTop3EchoSystemByArtistaId(Integer userId) {
        return echoSystemRepository.findTop3EchoSystemByArtistaId(userId);
    }

    public List<EchoSystem> getTop3EchoSystemByArtistaUsername(String username) {
        return echoSystemRepository.findTop3EchoSystemByArtistaUsername(username);
    }

    public EchoSystem editarEchoSystem(EchoSystem echoSystem) {
        Optional<EchoSystem> echoSystemExistente = echoSystemRepository.findById(echoSystem.getIdEcho());

        if (echoSystemExistente.isEmpty()) {
            throw new IllegalArgumentException("EchoSystem não encontrado");
        }

        EchoSystem echoSystemAtualizado = echoSystemExistente.get();

        if (echoSystem.getVisualizacao() != null) {
            echoSystemAtualizado.setVisualizacao(echoSystem.getVisualizacao());
        }
        if (echoSystem.getStreams() != null){
            echoSystemAtualizado.setStreams(echoSystem.getStreams());
        }
        if (echoSystem.getCurtidas() != null){
            echoSystemAtualizado.setCurtidas(echoSystem.getCurtidas());
        }
        if (echoSystem.getRedirecionamento() != null){
            echoSystemAtualizado.setRedirecionamento(echoSystem.getRedirecionamento());
        }

        return echoSystemRepository.save(echoSystemAtualizado);
    }


    public List<EchoSystem> visualizacaoDesc(Integer userId, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return echoSystemRepository.findTop3TituloMusicaByOrderByVisualizacaoDesc(userId, pageRequest);
    }

    public void deletarEchoSystem(Integer id) {
        Optional<EchoSystem> echoSystem = echoSystemRepository.findById(id);
        if (echoSystem.isPresent()) {
            echoSystemRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("EchoSystem não encontrado");
        }
    }

    public List<EchoSystem> visualizacaoDescUsername(String username, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return echoSystemRepository.findTop3TituloMusicaUsernameByOrderByVisualizacaoDesc(username, pageRequest);
    }
    public List<EchoSystem> streamDesc(Integer userId, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return echoSystemRepository.findTop3TituloMusicaByOrderByStreamDesc(userId, pageRequest);
    }

    public List<EchoSystem> curtidasDesc(Integer userId, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return echoSystemRepository.findTop3TituloMusicaByOrderByCurtidasDesc(userId, pageRequest);
    }

    public List<EchoSystem> redirecionamentoDesc(Integer userId, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return echoSystemRepository.findTop3TituloMusicaByOrderByRedirecionamentoDesc(userId, pageRequest);
    }

    public List<EchoSystem> findAllEchoSystemByArtistaId(Integer userId) {
        return echoSystemRepository.findAllEchoSystemByArtistaId(userId);
    }

    public List<EchoSystem> findAllEchoSystemGeneroRock() {
        return echoSystemRepository.buscarPorGeneroRock();
    }

    public List<EchoSystem> findAllEchoSystemGeneroPop() {
        return echoSystemRepository.buscarPorGeneroPop();
    }

    public List<EchoSystem> findAllEchoSystemGeneroFutureCore() {
        return echoSystemRepository.buscarPorGeneroFutureCore();
    }

    public List<EchoSystem> findAllEchoSystemGeneroKpop() {
        return echoSystemRepository.buscarPorGeneroKpop();
    }

    public List<EchoSystem> findAllEchoSystemGeneroJrock() {
        return echoSystemRepository.buscarPorGeneroJrock();
    }

    public List<EchoSystem> findAllEchoSystemGeneroHipHopRap() {
        return echoSystemRepository.buscarPorGeneroHipHopRap();
    }

    public List<EchoSystem> findAllEchoSystemGeneroRbSoul() {
        return echoSystemRepository.buscarPorGeneroRbSoul();
    }

    public List<EchoSystem> findAllEchoSystemGeneroIndie() {
        return echoSystemRepository.buscarPorGeneroIndie();
    }

    public List<EchoSystem> findAllEchoSystemGeneroEdm() {
        return echoSystemRepository.buscarPorGeneroEdm();
    }

    public List<EchoSystem> findAllEchoSystemGeneroEdmKawaii() {
        return echoSystemRepository.buscarPorGeneroEdmKawaii();
    }

    public List<EchoSystem> findAllEchoSystemGeneroJazz() {
        return echoSystemRepository.buscarPorGeneroJazz();
    }


    public List<EchoSystem> findAllEchoSystemGeneroSertanejo() {
        return echoSystemRepository.buscarPorGeneroSertanejo();
    }


    public List<EchoSystem> findAllEchoSystemGeneroEletroSwing() {
        return echoSystemRepository.buscarPorGeneroEletroSwing();
    }


    public List<EchoSystem> findAllEchoSystemGeneroPagode() {
        return echoSystemRepository.buscarPorGeneroPagode();
    }



}






















