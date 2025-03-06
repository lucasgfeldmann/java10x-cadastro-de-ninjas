package br.com.dnos.CadastroDeNinjas.Missoes;


import org.springframework.stereotype.Service;

import java.time.chrono.MinguoChronology;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@Service
public class MissoesService {

    private final MissoesRepository missoesRepository;
    private final MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    public List<MissoesDTO> listarTodasMissoes() {
        List<MissoesModel> missoesModels = missoesRepository.findAll();
        return missoesModels.stream().map(missoesMapper::map).collect(Collectors.toList());
    }


    public MissoesDTO listarMissaoPorId(Long id) {
        Optional<MissoesModel> missaoId = missoesRepository.findById(id);
        return missaoId.map(missoesMapper::map).orElse(null);
    }

    public MissoesDTO criaMissao(MissoesDTO missoesDTO) {
        MissoesModel missoesModel = missoesMapper.map(missoesDTO);
        missoesModel = missoesRepository.save(missoesModel);
        return missoesMapper.map(missoesModel);
    }

    public void deletarMissaoPorId(Long id) {
        missoesRepository.deleteById(id);
    }

    public MissoesDTO atualizarMissao(Long id, MissoesDTO missao) {
        Optional<MissoesModel> missaoId = missoesRepository.findById(id);
        if (missaoId.isPresent()) {
            missao.setId(id);
            MissoesModel missoesModel = missoesRepository.save(missoesMapper.map(missao));
            return missoesMapper.map(missoesModel);
        }
        return null;
    }
}
