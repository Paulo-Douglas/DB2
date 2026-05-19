package com.ufrn.dct.bsi.mongotask.infrastructure.DTOs;

import jakarta.validation.constraints.NotBlank;

public record AlocacaoRequest(
        @NotBlank(message = "Empregado da alocação é obrigatório")
        String empregado,

        @NotBlank(message = "Horas da alocação são obrigatórias")
        String horas
) {
}
