package br.com.dnos.CadastroDeNinjas.Configs;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "API Cadastro de Ninjas",
                description = "API simples de cadastro de ninjas e missões."
        ),
        externalDocs = @ExternalDocumentation(
                description = "Github",
                url = "https://github.com/lucasgfeldmann/ponto-spring"
        )
)
public class DocApi {
}
