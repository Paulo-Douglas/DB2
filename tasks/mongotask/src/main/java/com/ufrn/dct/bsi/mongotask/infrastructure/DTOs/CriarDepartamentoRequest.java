package com.ufrn.dct.bsi.mongotask.infrastructure.DTOs;

import jakarta.validation.constraints.NotBlank;

public record CriarDepartamentoRequest(
        @NotBlank(message = "Nome do departamento é obrigatório")
        String nomeDep,

        @NotBlank(message = "Gerente do departamento é obrigatório")
        String gerente
) {
}
