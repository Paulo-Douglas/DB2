package com.ufrn.dct.bsi.mongotask.controller;

import com.ufrn.dct.bsi.mongotask.business.departamento.AtualizarDepartamentoUseCase;
import com.ufrn.dct.bsi.mongotask.business.departamento.BuscarDepartamentoUseCase;
import com.ufrn.dct.bsi.mongotask.business.departamento.CriarDepartamentoUseCase;
import com.ufrn.dct.bsi.mongotask.business.departamento.ExcluirDepartamentoUseCase;
import com.ufrn.dct.bsi.mongotask.business.departamento.ListarDepartamentosUseCase;
import com.ufrn.dct.bsi.mongotask.infrastructure.DTOs.CriarDepartamentoRequest;
import com.ufrn.dct.bsi.mongotask.infrastructure.DTOs.DepartamentoResponse;
import com.ufrn.dct.bsi.mongotask.shared.DTOs.MensagemResponse;
import com.ufrn.dct.bsi.mongotask.shared.DTOs.NovoRecursoResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/departamentos")
@AllArgsConstructor
public class DepartamentoController {
    private final CriarDepartamentoUseCase criarDepartamentoUseCase;
    private final ListarDepartamentosUseCase listarDepartamentosUseCase;
    private final BuscarDepartamentoUseCase buscarDepartamentoUseCase;
    private final AtualizarDepartamentoUseCase atualizarDepartamentoUseCase;
    private final ExcluirDepartamentoUseCase excluirDepartamentoUseCase;

    @PostMapping("/registro")
    public ResponseEntity<NovoRecursoResponse> criarDepartamento(
            @RequestBody @Valid final CriarDepartamentoRequest request
    ) {
        criarDepartamentoUseCase.executar(request);

        return ResponseEntity.ok(NovoRecursoResponse.builder()
                .criado(Boolean.TRUE)
                .criadoEm(LocalDate.now())
                .mensagem("Departamento criado com sucesso")
                .build()
        );
    }

    @GetMapping
    public ResponseEntity<List<DepartamentoResponse>> listarDepartamentos() {
        return ResponseEntity.ok(listarDepartamentosUseCase.executar());
    }

    @GetMapping("/{codDep}")
    public ResponseEntity<DepartamentoResponse> buscarDepartamento(
            @PathVariable final String codDep
    ) {
        return ResponseEntity.ok(buscarDepartamentoUseCase.executar(codDep));
    }

    @PutMapping("/{codDep}")
    public ResponseEntity<MensagemResponse> atualizarDepartamento(
            @PathVariable final String codDep,
            @RequestBody @Valid final CriarDepartamentoRequest request
    ) {
        atualizarDepartamentoUseCase.executar(codDep, request);

        return ResponseEntity.ok(MensagemResponse.builder()
                .mensagem("Departamento atualizado com sucesso")
                .build()
        );
    }

    @DeleteMapping("/{codDep}")
    public ResponseEntity<MensagemResponse> excluirDepartamento(
            @PathVariable final String codDep
    ) {
        excluirDepartamentoUseCase.executar(codDep);

        return ResponseEntity.ok(MensagemResponse.builder()
                .mensagem("Departamento excluído com sucesso")
                .build()
        );
    }
}
