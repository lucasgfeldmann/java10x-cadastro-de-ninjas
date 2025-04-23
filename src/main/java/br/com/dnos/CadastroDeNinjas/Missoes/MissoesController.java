package br.com.dnos.CadastroDeNinjas.Missoes;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping
    public List<MissoesDTO> listarTodasMissoes() {
        return missoesService.listarTodasMissoes();
    }

    @GetMapping("{id}")
    public MissoesDTO listarMissaoPorId(@PathVariable Long id) {
        return missoesService.listarMissaoPorId(id);
    }

    @PostMapping
    public MissoesDTO criarMissao(@RequestBody MissoesDTO missao) {
        return missoesService.criaMissao(missao);
    }

    @PutMapping("{id}")
    public MissoesDTO alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missao) {
        return missoesService.atualizarMissao(id, missao);
    }

    @DeleteMapping("{id}")
    public void deletarMissao(@PathVariable Long id) {
        missoesService.deletarMissaoPorId(id);
    }

}
