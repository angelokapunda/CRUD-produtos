package br.com.treinamento.CRUD.domain.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record RequestProductsDTO(

        @NotBlank
        String nome ,

        @NotNull
        BigDecimal price_in_cents) {
}
