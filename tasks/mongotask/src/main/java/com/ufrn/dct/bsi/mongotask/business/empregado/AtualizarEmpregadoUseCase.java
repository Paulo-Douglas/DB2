package com.ufrn.dct.bsi.mongotask.business.empregado;

import com.ufrn.dct.bsi.mongotask.infrastructure.DTOs.CriarEmpregadoRequest;
import com.ufrn.dct.bsi.mongotask.infrastructure.repository.EmpregadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class AtualizarEmpregadoUseCase {
    private EmpregadoRepository empregadoRepository;

    public void executar(final String id, final CriarEmpregadoRequest request){
        final var empregado = empregadoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empregado não encontrado"));

        empregado.setDataNasc(request.dataNasc());
        empregado.setEndereco(request.endereco());
        empregado.setSexo(request.sexo());
        empregado.setSalario(request.salario());
        empregado.setSupervisor(request.supervisor());
        empregado.setDepto(request.depto());

        empregadoRepository.save(empregado);
    }
}
