package br.com.dnos.CadastroDeNinjas.Missao;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class MissaoService {

    private final MissaoRepository missaoRepository;
    private final MissaoMapper missaoMapper;

    public MissaoService(MissaoRepository missaoRepository, MissaoMapper missaoMapper) {
        this.missaoRepository = missaoRepository;
        this.missaoMapper = missaoMapper;
    }

    public List<MissaoDTO> listarTodasMissoes() {
        List<MissaoModel> missaoModels = missaoRepository.findAll();
        return missaoModels.stream().map(missaoMapper::map).collect(Collectors.toList());
    }


    public MissaoDTO listarMissaoPorId(Long id) {
        Optional<MissaoModel> missaoId = missaoRepository.findById(id);
        return missaoId.map(missaoMapper::map).orElse(null);
    }

    public MissaoDTO criaMissao(MissaoDTO missaoDTO) {
        MissaoModel missaoModel = missaoMapper.map(missaoDTO);
        missaoModel = missaoRepository.save(missaoModel);
        return missaoMapper.map(missaoModel);
    }

    public void deletarMissaoPorId(Long id) {
        missaoRepository.deleteById(id);
    }

    public MissaoDTO atualizarMissao(Long id, MissaoDTO missao) {
        Optional<MissaoModel> missaoId = missaoRepository.findById(id);
        if (missaoId.isPresent()) {
            missao.setId(id);
            MissaoModel missaoModel = missaoRepository.save(missaoMapper.map(missao));
            return missaoMapper.map(missaoModel);
        }
        return null;
    }
}
