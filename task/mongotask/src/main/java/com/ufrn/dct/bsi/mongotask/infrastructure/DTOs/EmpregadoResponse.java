package com.ufrn.dct.bsi.mongotask.infrastructure.DTOs;

import com.ufrn.dct.bsi.mongotask.shared.enums.SexoEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

public record EmpregadoResponse(
        String id,
        LocalDate dataNasc,
        String endereco,
        SexoEnum sexo,
        BigDecimal salario,
        String supervisor,
        String depto
) {
}
