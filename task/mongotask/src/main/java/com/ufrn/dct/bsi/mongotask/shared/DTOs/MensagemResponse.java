package com.ufrn.dct.bsi.mongotask.shared.DTOs;

import lombok.Builder;

@Builder
public record MensagemResponse(
        String mensagem
) {
}
