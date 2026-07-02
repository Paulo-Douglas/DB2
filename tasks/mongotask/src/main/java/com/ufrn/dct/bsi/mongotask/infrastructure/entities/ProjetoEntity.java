package com.ufrn.dct.bsi.mongotask.infrastructure.entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "projeto")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjetoEntity {
    @Id
    private String codProj;

    @NotBlank
    private String nomeProj;

    @NotBlank
    private String depto;

    @NotBlank
    private String lider;

    @NotNull
    private List<AlocacaoEmbedded> alocacoes;
}
