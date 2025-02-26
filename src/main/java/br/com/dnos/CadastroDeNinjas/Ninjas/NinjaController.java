package br.com.dnos.CadastroDeNinjas.Ninjas;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {
    @GetMapping("/boasVindas")
    public String boasVindas() {
        return "Essa é a minha primeira Rota";
    }

    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja Criado";
    }

    @GetMapping("/todos")
    public String mostrarTodosNijas() {
        return "Mostrar todos os nijas";
    }

    @GetMapping("/todosID")
    public String mostrarPorId() {
        return "Mostrar ninja por ID";
    }

    @PutMapping("/alterarID")
    public String alterarNinjaPorId() {
        return "Alterar ninja por ID";
    }

    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId() {
        return "Deletar ninja por ID";
    }

}
