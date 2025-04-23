package br.com.dnos.CadastroDeNinjas.Ninja;

import br.com.dnos.CadastroDeNinjas.Missao.MissaoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private Long id;
    private String nome;
    private String email;
    private String imgUrl;
    private int idade;
    private String rank;
    private MissaoModel missoes;

}
