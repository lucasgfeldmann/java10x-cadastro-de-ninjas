package br.com.dnos.CadastroDeNinjas.Missao;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Missões")
@RestController
@RequestMapping("missao")
public class MissaoController {

    private final MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    @Operation(summary = "Returns all missions")
    @GetMapping
    public List<MissaoDTO> listarTodasMissoes() {
        return missaoService.listarTodasMissoes();
    }

    @Operation(summary = "Returns a mission specified by its id")
    @GetMapping("{id}")
    public MissaoDTO listarMissaoPorId(@PathVariable Long id) {
        return missaoService.listarMissaoPorId(id);
    }

    @Operation(summary = "Creates a new mission")
    @PostMapping
    public MissaoDTO criarMissao(@RequestBody MissaoDTO missao) {
        return missaoService.criaMissao(missao);
    }

    @Operation(summary = "Change all data from a mission specified by its id")
    @PutMapping("{id}")
    public MissaoDTO alterarMissao(@PathVariable Long id, @RequestBody MissaoDTO missao) {
        return missaoService.atualizarMissao(id, missao);
    }

    @Operation(summary = "Delete a mission specified by its id")
    @DeleteMapping("{id}")
    public void deletarMissao(@PathVariable Long id) {
        missaoService.deletarMissaoPorId(id);
    }

}
