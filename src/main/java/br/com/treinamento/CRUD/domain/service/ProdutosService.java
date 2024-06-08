package br.com.treinamento.CRUD.domain.service;

import br.com.treinamento.CRUD.domain.DTOs.RequestProductsDTO;
import br.com.treinamento.CRUD.domain.Product;
import br.com.treinamento.CRUD.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutosService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProducts(RequestProductsDTO product) {
        return productRepository.save(new Product(product));
    }

    public List<Product> getAllProduct() {
        return productRepository.findAllByActiveTrue();
    }

//    public Optional<Product> searchProduct(Long id) {
//        try {
//            if (id != null) {
//                return productRepository.findById(id);
//            }
//        } catch (NullPointerException e) {
//            throw new RuntimeException("Recurso não encontrado");
//        }
//        return RuntimeException
//    }

//    public void delete(Long id) {
//
//    }
}
