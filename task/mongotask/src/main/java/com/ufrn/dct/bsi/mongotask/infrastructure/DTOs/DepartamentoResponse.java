package com.ufrn.dct.bsi.mongotask.infrastructure.DTOs;

public record DepartamentoResponse(
        String codDep,
        String nomeDep,
        String gerente
) {
}
