package br.com.dnos.CadastroDeNinjas.Ninja;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Ninja")
@RestController
@RequestMapping("ninja")
public class NinjaController {
    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @PostMapping
    @Operation(summary = "Creates a new ninja")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Ninja criado com Sucesso"), @ApiResponse(responseCode = "400", description = "Erro na criação do ninja")})
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja criado com sucesso: " + novoNinja.getNome() + " (ID): " + novoNinja.getId());
    }

    @Operation(summary = "Returns all registered ninjas")
    @GetMapping
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> nijas = ninjaService.listarNinjas();
        return ResponseEntity.ok(nijas);
    }

    @GetMapping("{id}")
    @Operation(summary = "Returns a ninja specified by its id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Ninja encontrado com Sucesso"), @ApiResponse(responseCode = "400", description = "Ninja não encontrado")})
    public ResponseEntity<?> listarNinjaPorId(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.listarNinjaPorId(id);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com ID " + id + " não encontrado");
    }

    @PutMapping("{id}")
    @Operation(summary = "Change all data from a ninja specified by its id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Ninja alterado com Sucesso"), @ApiResponse(responseCode = "400", description = "Ninja não , não foi possivel alterar")})
    public ResponseEntity<?> alterarNinjaPorId(@Parameter(description = "Usuario manda por id no caminho da requisição") @PathVariable Long id, @Parameter(description = "Usuario manda os dados do ninja a ser atualizado no corpo da requisição") @RequestBody NinjaDTO ninjaAtualizado) {
        NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com ID " + id + " não encontrado");

    }

    @Operation(summary = "Delete a ninja specified by its id")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {
        if (ninjaService.listarNinjaPorId(id) != null) {
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com o ID " + id + " deletado com sucesso");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com o ID " + id + " inexistente");
    }

}
