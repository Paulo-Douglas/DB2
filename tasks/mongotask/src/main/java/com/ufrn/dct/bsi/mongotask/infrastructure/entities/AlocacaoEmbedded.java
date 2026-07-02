package com.ufrn.dct.bsi.mongotask.infrastructure.entities;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlocacaoEmbedded {
    @NotNull
    private String empregado;

    @NotNull
    private String horas;
}
