package br.com.dnos.CadastroDeNinjas.Missoes;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public List<MissoesModel> listarTodasMissoes() {
        return missoesRepository.findAll();
    }


    public MissoesModel listarMissaoPorId(Long id) {
        Optional<MissoesModel> missaoId = missoesRepository.findById(id);
        return missaoId.orElse(null);
    }

    public MissoesModel criaMissao(MissoesModel missoesModel) {
        return missoesRepository.save(missoesModel);
    }

    public void deletarMissaoPorId(Long id) {
        missoesRepository.deleteById(id);
    }
}
