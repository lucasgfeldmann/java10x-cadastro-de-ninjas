package br.com.dnos.CadastroDeNinjas.Missoes;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;


@Service
@RequestMapping("missoes")
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    @GetMapping("/listar")
    public List<MissoesModel> listarTodasMissoes() {
        return missoesRepository.findAll();
    }


    public MissoesModel listarMissaoPorId(Long id) {
        Optional<MissoesModel> missaoId = missoesRepository.findById(id);
        return missaoId.orElse(null);
    }
}
