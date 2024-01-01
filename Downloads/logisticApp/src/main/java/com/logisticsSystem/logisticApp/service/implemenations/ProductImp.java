package com.logisticsSystem.logisticApp.service.implemenations;

import com.logisticsSystem.logisticApp.data.model.Product;
import com.logisticsSystem.logisticApp.data.repository.ProductRepository;
import com.logisticsSystem.logisticApp.dto.request.ProductRequest;
import com.logisticsSystem.logisticApp.dto.request.ProductUpdate;
import com.logisticsSystem.logisticApp.dto.response.ProductResponse;
import com.logisticsSystem.logisticApp.service.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ProductImp implements ProductService {
    private final ProductRepository productRepository;


    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        if (productRepository.existsByNameAndCustomer_Email(productRequest.getProductName(), productRequest.getCustomer().getEmail()))
            throw new RuntimeException("product  already exist");
        Product foundProduct = new Product();
        foundProduct.setName(productRequest.getProductName());
        foundProduct.setProduct_Price(productRequest.getProduct_Price());
        foundProduct.setQuantity(productRequest.getQuantity());
        foundProduct.setDateCreated(LocalDateTime.now());
        foundProduct.setCustomer(productRequest.getCustomer());
        Product savedProduct = productRepository.save(foundProduct);


        ProductResponse productResponse = new ProductResponse();
        productResponse.setProductName(savedProduct.getName());
        productResponse.setQuantity(savedProduct.getQuantity());
        productResponse.setProduct_Price(savedProduct.getProduct_Price());
        productResponse.setCustomer(savedProduct.getCustomer());
        return productResponse;


    }

    @Override
    public boolean delete_Product(String name, String customerEmail) {
        productRepository.delete(findProduct(name, customerEmail));
        return productRepository.existsByNameAndCustomer_Email(name,customerEmail);


    }


    @Override
    public Product updateProduct(ProductUpdate productUpdate) {
        Product foundProduct = productRepository.findByNameAndCustomerEmail(productUpdate.getProductName(), productUpdate.getCustomerEmail());
        if (foundProduct == null)
            throw new RuntimeException("product with the name " + productUpdate.getProductName() + " does not exist the list of the customer with the email " + productUpdate.getCustomerEmail());
        foundProduct.setName(productUpdate.getProductName());
        foundProduct.setProduct_Price(productUpdate.getProduct_Price());
        foundProduct.setDateCreated(LocalDateTime.now());


        return productRepository.save(foundProduct);
    }

    @Override
    public Product findProduct(String name, String customerEmail) {
        Product foundProduct = productRepository.findByNameAndCustomerEmail(name, customerEmail);
        if (foundProduct == null) throw new RuntimeException(" product not found ");
        return foundProduct;
    }



    private ProductResponse getProductResponse(Product savedProduct) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProductName(savedProduct.getName());
        productResponse.setProduct_Price(savedProduct.getProduct_Price());
        productResponse.setQuantity(savedProduct.getQuantity());
        productResponse.setCustomer(savedProduct.getCustomer());
        return productResponse;
    }


    private Product mapProductRequestToProduct(ProductRequest productRequest) {
        Product createdProduct = new Product();
        createdProduct.setProduct_Price(productRequest.getProduct_Price());
        createdProduct.setName(productRequest.getProductName());
        createdProduct.setQuantity(productRequest.getQuantity());
        createdProduct.setDateCreated(LocalDateTime.now());
//        createdProduct.setCustomer(productRequest.getCustomer());
        createdProduct.setDateCreated(LocalDateTime.now());
        return createdProduct;
    }


}

