package br.com.dnos.CadastroDeNinjas.Missao;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missao")
public class MissaoController {

    private final MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    @GetMapping
    public List<MissaoDTO> listarTodasMissoes() {
        return missaoService.listarTodasMissoes();
    }

    @GetMapping("{id}")
    public MissaoDTO listarMissaoPorId(@PathVariable Long id) {
        return missaoService.listarMissaoPorId(id);
    }

    @PostMapping
    public MissaoDTO criarMissao(@RequestBody MissaoDTO missao) {
        return missaoService.criaMissao(missao);
    }

    @PutMapping("{id}")
    public MissaoDTO alterarMissao(@PathVariable Long id, @RequestBody MissaoDTO missao) {
        return missaoService.atualizarMissao(id, missao);
    }

    @DeleteMapping("{id}")
    public void deletarMissao(@PathVariable Long id) {
        missaoService.deletarMissaoPorId(id);
    }

}
