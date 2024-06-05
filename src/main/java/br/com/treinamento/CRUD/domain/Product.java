package br.com.treinamento.CRUD.domain;

import br.com.treinamento.CRUD.domain.DTOs.RequestProductsDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "products")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal price_in_cents;
    private boolean active;

    public Product(RequestProductsDTO requestProductsDTO) {
        this.nome = requestProductsDTO.nome();
        this.price_in_cents = requestProductsDTO.price_in_cents();
        this.active = true;
    }
}
