package com.ufrn.dct.bsi.mongotask.business.projeto;

import com.ufrn.dct.bsi.mongotask.infrastructure.DTOs.ProjetoResponse;
import com.ufrn.dct.bsi.mongotask.infrastructure.mappers.ProjetoMapper;
import com.ufrn.dct.bsi.mongotask.infrastructure.repository.ProjetoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ListarProjetosUseCase {
    private ProjetoRepository projetoRepository;
    private ProjetoMapper projetoMapper;

    public List<ProjetoResponse> executar() {
        return projetoRepository.findAll()
                .stream()
                .map(projetoMapper::toResponse)
                .toList();
    }
}
