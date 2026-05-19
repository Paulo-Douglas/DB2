package com.ufrn.dct.bsi.mongotask.business.projeto;

import com.ufrn.dct.bsi.mongotask.infrastructure.DTOs.CriarProjetoRequest;
import com.ufrn.dct.bsi.mongotask.infrastructure.mappers.ProjetoMapper;
import com.ufrn.dct.bsi.mongotask.infrastructure.repository.ProjetoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CriarProjetoUseCase {
    private ProjetoRepository projetoRepository;
    private ProjetoMapper projetoMapper;

    public void executar(final CriarProjetoRequest request) {
        final var projeto = projetoMapper.toEntity(request);
        projetoRepository.save(projeto);
    }
}
