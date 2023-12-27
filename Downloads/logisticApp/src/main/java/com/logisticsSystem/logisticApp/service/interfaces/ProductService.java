package com.logisticsSystem.logisticApp.service.interfaces;

import com.logisticsSystem.logisticApp.data.model.Product;
import com.logisticsSystem.logisticApp.dto.request.ProductRequest;
import com.logisticsSystem.logisticApp.dto.request.ProductUpdate;
import com.logisticsSystem.logisticApp.dto.response.ProductResponse;

public interface ProductService {
    ProductResponse createProduct(ProductRequest productRequest);

   boolean delete_Product(String productName , String userEmail);

    Product updateProduct(String name, String customerEmail);

    Product findProduct(String name , String customerEmail);

}

