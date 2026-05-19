package com.ufrn.dct.bsi.mongotask.infrastructure.DTOs;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CriarProjetoRequest(
        @NotBlank(message = "Nome do projeto é obrigatório")
        String nomeProj,

        @NotBlank(message = "Departamento do projeto é obrigatório")
        String depto,

        @NotBlank(message = "Líder do projeto é obrigatório")
        String lider,

        @NotNull(message = "Alocações do projeto são obrigatórias")
        List<@Valid AlocacaoRequest> alocacoes
) {
}
