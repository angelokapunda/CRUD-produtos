package br.com.treinamento.CRUD.domain.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ResponseProductDTO(

        @NotNull
        Long id,

        @NotBlank
        String nome,

        @NotNull
        BigDecimal price_in_cents

) {
}
