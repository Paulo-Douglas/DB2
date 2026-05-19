package com.ufrn.dct.bsi.mongotask.infrastructure.DTOs;

import com.ufrn.dct.bsi.mongotask.shared.enums.SexoEnum;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CriarEmpregadoRequest(
        @NotNull(message = "Data de nascimento é obrigatória")
        LocalDate dataNasc,

        @NotBlank(message = "Endereço é obrigatório")
        String endereco,

        @NotNull(message = "O sexo é obrigatório")
        SexoEnum sexo,

        @DecimalMin("0.00")
        @NotNull(message = "O salario é obrigatório")
        BigDecimal salario,

        String supervisor,

        @NotNull(message = "O código do departamento é obrigatório")
        String depto
) {
}
