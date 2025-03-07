package br.com.dnos.CadastroDeNinjas.Ninjas;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninjas")
public class NinjaController {
    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }


    @GetMapping("/boasVindas")
    @Operation(summary = "Mensagem de boas vindas", description = "Essa rota da uma mensagem de boas vindas para quem acessa ela")
    public String boasVindas() {
        return "Essa é a minha primeira Rota";
    }

    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja", description = "Rota cria um novo ninja e insere no banco de dados")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Ninja criado com Sucesso"), @ApiResponse(responseCode = "400", description = "Erro na criação do ninja")})
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ninja criado com sucesso: " + novoNinja.getNome() + " (ID): " + novoNinja.getId());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> nijas = ninjaService.listarNinjas();
        return ResponseEntity.ok(nijas);
    }

    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista o ninja por ID", description = "Rota lista o ninja pelo ID")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Ninja encontrado com Sucesso"), @ApiResponse(responseCode = "400", description = "Ninja não encontrado")})
    public ResponseEntity<?> listarNinjaPorId(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.listarNinjaPorId(id);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com ID " + id + " não encontrado");
    }

    @PutMapping("/atualizar/{id}")
    @Operation(summary = "Altera o ninja por ID", description = "Rota altera o ninja pelo seu ID")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Ninja alterado com Sucesso"), @ApiResponse(responseCode = "400", description = "Ninja não , não foi possivel alterar")})
    public ResponseEntity<?> alterarNinjaPorId(@Parameter(description = "Usuario manda por id no caminho da requisição") @PathVariable Long id, @Parameter(description = "Usuario manda os dados do ninja a ser atualizado no corpo da requisição") @RequestBody NinjaDTO ninjaAtualizado) {
        NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com ID " + id + " não encontrado");

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {
        if (ninjaService.listarNinjaPorId(id) != null) {
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com o ID " + id + " deletado com sucesso");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com o ID " + id + " inexistente");
    }

}
