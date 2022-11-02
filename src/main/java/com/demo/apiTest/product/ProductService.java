package com.demo.apiTest.product;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product save(ProductDTO productDTO) {

        Product product = Product.builder()
                .name(productDTO.getName())
                .seller_id(productDTO.getSeller_id())
                .price(productDTO.getPrice())
                .description(productDTO.getDescription())
                .build();

        return productRepository.save(product);
    }

    public ProductDTO findById(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        ProductDTO productDTO = ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .seller_id(product.getSeller_id())
                .price(product.getPrice())
                .description(product.getDescription())
                .build();

        return productDTO;
    }

    public Page<ProductDTO> findAll(Pageable pageable) {
        Page<Product> productPage = productRepository.findAll(pageable);
        Page<ProductDTO> productDTOPage = productPage.map(product -> ProductDTO.builder()
                                                                            .id(product.getId())
                                                                            .name(product.getName())
                                                                            .seller_id(product.getSeller_id())
                                                                            .price(product.getPrice())
                                                                            .description(product.getDescription())
                                                                            .build());
        return productDTOPage;
    }

}
