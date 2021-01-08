package org.ekosutrisno.service;

import org.ekosutrisno.model.ProductEntity;
import org.ekosutrisno.model.dto.AddProductRequest;

import java.util.List;
import java.util.UUID;

/**
 * @author Eko Sutrisno
 * @create 13/11/2020 10:16
 */
public interface ProductEntityService {

    List<ProductEntity> getAllProduct();

    List<ProductEntity> getAllProductByCategory(String productCategory);

    ProductEntity getById(UUID productId);

    Boolean insertProduct(AddProductRequest product);

    Boolean updateProduct(UUID productId, AddProductRequest product);

    ProductEntity getProductByName(String productName);

    Boolean deleteProduct(UUID productId);
}
