package com.ufrn.dct.bsi.mongotask.infrastructure.DTOs;

import java.util.List;

public record ProjetoResponse(
        String codProj,
        String nomeProj,
        String depto,
        String lider,
        List<AlocacaoResponse> alocacoes
) {
}
