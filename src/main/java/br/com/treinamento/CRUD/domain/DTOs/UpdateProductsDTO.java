package br.com.treinamento.CRUD.domain.DTOs;

import java.math.BigDecimal;

public record UpdateProductsDTO(String nome, BigDecimal price_in_cents){
}
