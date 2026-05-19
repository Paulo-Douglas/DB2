package com.ufrn.dct.bsi.mongotask.shared.DTOs;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record NovoRecursoResponse(
        String mensagem,
        Boolean criado,
        LocalDate criadoEm
) {
}
