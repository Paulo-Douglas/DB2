package com.ufrn.dct.bsi.mongotask.controller;

import com.ufrn.dct.bsi.mongotask.business.projeto.AlocarEmpregadoProjetoUseCase;
import com.ufrn.dct.bsi.mongotask.business.projeto.AtualizarProjetoUseCase;
import com.ufrn.dct.bsi.mongotask.business.projeto.BuscarProjetoUseCase;
import com.ufrn.dct.bsi.mongotask.business.projeto.CriarProjetoUseCase;
import com.ufrn.dct.bsi.mongotask.business.projeto.ExcluirProjetoUseCase;
import com.ufrn.dct.bsi.mongotask.business.projeto.ListarProjetosUseCase;
import com.ufrn.dct.bsi.mongotask.business.projeto.RemoverAlocacaoProjetoUseCase;
import com.ufrn.dct.bsi.mongotask.infrastructure.DTOs.AlocacaoRequest;
import com.ufrn.dct.bsi.mongotask.infrastructure.DTOs.CriarProjetoRequest;
import com.ufrn.dct.bsi.mongotask.infrastructure.DTOs.ProjetoResponse;
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
@RequestMapping("/projetos")
@AllArgsConstructor
public class ProjetoController {
    private final CriarProjetoUseCase criarProjetoUseCase;
    private final ListarProjetosUseCase listarProjetosUseCase;
    private final BuscarProjetoUseCase buscarProjetoUseCase;
    private final AtualizarProjetoUseCase atualizarProjetoUseCase;
    private final ExcluirProjetoUseCase excluirProjetoUseCase;
    private final AlocarEmpregadoProjetoUseCase alocarEmpregadoProjetoUseCase;
    private final RemoverAlocacaoProjetoUseCase removerAlocacaoProjetoUseCase;

    @PostMapping("/registro")
    public ResponseEntity<NovoRecursoResponse> criarProjeto(
            @RequestBody @Valid final CriarProjetoRequest request
    ) {
        criarProjetoUseCase.executar(request);

        return ResponseEntity.ok(NovoRecursoResponse.builder()
                .criado(Boolean.TRUE)
                .criadoEm(LocalDate.now())
                .mensagem("Projeto criado com sucesso")
                .build()
        );
    }

    @GetMapping
    public ResponseEntity<List<ProjetoResponse>> listarProjetos() {
        return ResponseEntity.ok(listarProjetosUseCase.executar());
    }

    @GetMapping("/{codProj}")
    public ResponseEntity<ProjetoResponse> buscarProjeto(
            @PathVariable final String codProj
    ) {
        return ResponseEntity.ok(buscarProjetoUseCase.executar(codProj));
    }

    @PutMapping("/{codProj}")
    public ResponseEntity<MensagemResponse> atualizarProjeto(
            @PathVariable final String codProj,
            @RequestBody @Valid final CriarProjetoRequest request
    ) {
        atualizarProjetoUseCase.executar(codProj, request);

        return ResponseEntity.ok(MensagemResponse.builder()
                .mensagem("Projeto atualizado com sucesso")
                .build()
        );
    }

    @DeleteMapping("/{codProj}")
    public ResponseEntity<MensagemResponse> excluirProjeto(
            @PathVariable final String codProj
    ) {
        excluirProjetoUseCase.executar(codProj);

        return ResponseEntity.ok(MensagemResponse.builder()
                .mensagem("Projeto excluído com sucesso")
                .build()
        );
    }

    @PostMapping("/{codProj}/alocacoes")
    public ResponseEntity<MensagemResponse> alocarEmpregado(
            @PathVariable final String codProj,
            @RequestBody @Valid final AlocacaoRequest request
    ) {
        alocarEmpregadoProjetoUseCase.executar(codProj, request);

        return ResponseEntity.ok(MensagemResponse.builder()
                .mensagem("Empregado alocado com sucesso")
                .build()
        );
    }

    @DeleteMapping("/{codProj}/alocacoes/{empregado}")
    public ResponseEntity<MensagemResponse> removerAlocacao(
            @PathVariable final String codProj,
            @PathVariable final String empregado
    ) {
        removerAlocacaoProjetoUseCase.executar(codProj, empregado);

        return ResponseEntity.ok(MensagemResponse.builder()
                .mensagem("Alocação removida com sucesso")
                .build()
        );
    }
}
