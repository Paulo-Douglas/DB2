package com.ufrn.dct.bsi.mongotask.infrastructure.entities;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Departamento")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartamentoEntity {
    @Id
    private String codDep;

    @NotBlank
    @Indexed(unique = true)
    private String nomeDep;

    @NotBlank
    private String gerente;
}
