package br.com.treinamento.CRUD.controllers;

import br.com.treinamento.CRUD.domain.DTOs.ResponseProductDTO;
import br.com.treinamento.CRUD.domain.DTOs.UpdateProductsDTO;
import br.com.treinamento.CRUD.domain.Product;
import br.com.treinamento.CRUD.domain.repository.ProductRepository;
import br.com.treinamento.CRUD.domain.DTOs.RequestProductsDTO;
import br.com.treinamento.CRUD.domain.service.ProdutosService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProdutosService produtosService;

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        var allProducts = produtosService.getAllProduct();
        return ResponseEntity.ok(allProducts);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Product> search(@PathVariable Long id) {
//
//    }

    @PostMapping
    @Transactional
    public ResponseEntity<ResponseProductDTO> saveProducts(@RequestBody @Valid RequestProductsDTO requestProductsDTO) {

        Product product =  produtosService.addProducts(requestProductsDTO);
        var response = ResponseProductDTO.builder()
                .id(product.getId())
                .nome(product.getNome())
                .price_in_cents(product.getPrice_in_cents())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateProducts(@PathVariable Long id, @RequestBody @Valid UpdateProductsDTO data) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setNome(data.nome());
            product.setPrice_in_cents(data.price_in_cents());
            return ResponseEntity.ok().body(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteProduct(@PathVariable Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setActive(false);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
