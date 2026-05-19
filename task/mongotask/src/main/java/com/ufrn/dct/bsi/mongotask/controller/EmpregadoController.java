package com.ufrn.dct.bsi.mongotask.controller;

import com.ufrn.dct.bsi.mongotask.business.empregado.AtualizarEmpregadoUseCase;
import com.ufrn.dct.bsi.mongotask.business.empregado.BuscarEmpregadoUseCase;
import com.ufrn.dct.bsi.mongotask.business.empregado.CriarEmpregadoUseCase;
import com.ufrn.dct.bsi.mongotask.business.empregado.ExcluirEmpregadoUseCase;
import com.ufrn.dct.bsi.mongotask.business.empregado.ListarEmpregadosUseCase;
import com.ufrn.dct.bsi.mongotask.infrastructure.DTOs.CriarEmpregadoRequest;
import com.ufrn.dct.bsi.mongotask.infrastructure.DTOs.EmpregadoResponse;
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
@RequestMapping("/empregados")
@AllArgsConstructor
public class EmpregadoController {
    private final CriarEmpregadoUseCase criarEmpregadoUseCase;
    private final ListarEmpregadosUseCase listarEmpregadosUseCase;
    private final BuscarEmpregadoUseCase buscarEmpregadoUseCase;
    private final AtualizarEmpregadoUseCase atualizarEmpregadoUseCase;
    private final ExcluirEmpregadoUseCase excluirEmpregadoUseCase;

    @PostMapping("/registro")
    public ResponseEntity<NovoRecursoResponse> criarEmpregado(
            @RequestBody @Valid final CriarEmpregadoRequest request
    ){
        criarEmpregadoUseCase.executar(request);

        return ResponseEntity.ok(NovoRecursoResponse.builder()
                .criado(Boolean.TRUE)
                .criadoEm(LocalDate.now())
                .mensagem("Empregado criado com sucesso")
                .build()
        );
    }

    @GetMapping
    public ResponseEntity<List<EmpregadoResponse>> listarEmpregados(){
        return ResponseEntity.ok(listarEmpregadosUseCase.executar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpregadoResponse> buscarEmpregado(
            @PathVariable final String id
    ){
        return ResponseEntity.ok(buscarEmpregadoUseCase.executar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MensagemResponse> atualizarEmpregado(
            @PathVariable final String id,
            @RequestBody @Valid final CriarEmpregadoRequest request
    ){
        atualizarEmpregadoUseCase.executar(id, request);

        return ResponseEntity.ok(MensagemResponse.builder()
                .mensagem("Empregado atualizado com sucesso")
                .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MensagemResponse> excluirEmpregado(
            @PathVariable final String id
    ){
        excluirEmpregadoUseCase.executar(id);

        return ResponseEntity.ok(MensagemResponse.builder()
                .mensagem("Empregado excluído com sucesso")
                .build()
        );
    }
}
