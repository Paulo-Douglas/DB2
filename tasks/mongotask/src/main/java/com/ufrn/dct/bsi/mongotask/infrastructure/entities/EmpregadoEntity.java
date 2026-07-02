package com.ufrn.dct.bsi.mongotask.infrastructure.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.DecimalMin;   

import com.ufrn.dct.bsi.mongotask.shared.enums.SexoEnum;

@Document(collection = "empregado")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpregadoEntity {
    @Id
    private String id;

    @NotNull
    private LocalDate dataNasc;

    @NotBlank
    private String endereco;

    @NotNull
    private SexoEnum sexo;

    @DecimalMin("0.00")
    @NotNull
    private BigDecimal salario;

    private String supervisor;

    @NotBlank
    private String depto;
}
