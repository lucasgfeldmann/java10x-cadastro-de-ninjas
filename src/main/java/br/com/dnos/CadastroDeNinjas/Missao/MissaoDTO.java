package br.com.dnos.CadastroDeNinjas.Missao;

import br.com.dnos.CadastroDeNinjas.Ninja.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissaoDTO {
    private Long id;
    private String nome;
    private String dificuldade;
    private List<NinjaModel> ninja;
}
