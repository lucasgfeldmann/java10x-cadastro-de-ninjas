package br.com.dnos.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {
    private final MissoesModel missoesModel;
    private final MissoesDTO missoesDTO;

    public MissoesMapper(MissoesModel missoesModel, MissoesDTO missoesDTO) {
        this.missoesModel = missoesModel;
        this.missoesDTO = missoesDTO;
    }

    public MissoesModel map(MissoesDTO missoesDTO) {
        missoesModel.setId(missoesDTO.getId());
        missoesModel.setNome(missoesDTO.getNome());
        missoesModel.setDificuldade(missoesDTO.getDificuldade());
        missoesModel.setNinja(missoesDTO.getNinja());
        return missoesModel;
    }

    public MissoesDTO map(MissoesModel missoesModel) {
        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setNome(missoesModel.getNome());
        missoesDTO.setDificuldade(missoesModel.getDificuldade());
        missoesDTO.setNinja(missoesModel.getNinja());
        return missoesDTO;
    }
}
