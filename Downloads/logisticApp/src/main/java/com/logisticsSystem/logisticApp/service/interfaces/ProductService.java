package com.logisticsSystem.logisticApp.service.interfaces;

import aj.org.objectweb.asm.ConstantDynamic;
import com.logisticsSystem.logisticApp.data.model.AppUser;
import com.logisticsSystem.logisticApp.data.model.Product;
import com.logisticsSystem.logisticApp.dto.request.ProductRequest;
import com.logisticsSystem.logisticApp.dto.request.ProductUpdate;
import com.logisticsSystem.logisticApp.dto.request.UpdateUserRequest;
import com.logisticsSystem.logisticApp.dto.response.ProductResponse;

public interface ProductService {
    ProductResponse createProduct(ProductRequest productRequest);

   boolean delete_Product(String name , String customerEmail);

    Product updateProduct(ProductUpdate productUpdate);

    Product findProduct(String name , String customerEmail);



}

