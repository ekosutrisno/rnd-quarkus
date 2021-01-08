package org.ekosutrisno.service.impl;

import org.ekosutrisno.model.ProductEntity;
import org.ekosutrisno.model.dto.AddProductRequest;
import org.ekosutrisno.repository.ProductEntityRepository;
import org.ekosutrisno.service.ProductEntityService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Eko Sutrisno
 * @create 13/11/2020 10:21
 */

@ApplicationScoped
public class ProductEntityServiceImpl implements ProductEntityService {

    @Inject
    ProductEntityRepository productEntityRepository;

    @Override
    public List<ProductEntity> getAllProduct() {
        return productEntityRepository.listAll()
                .stream().filter(ProductEntity::getAvailable)
                .collect(Collectors.toList());
    }

    @Override
    public ProductEntity getById(UUID productId) {
        Optional<ProductEntity> product = productEntityRepository.findByIdOptional(productId);
        return product.orElse(null);
    }

    @Override
    @Transactional
    public Boolean insertProduct(AddProductRequest product) {
        ProductEntity productEntity = new ProductEntity();

        productEntity.setProductName(product.getProductName());
        productEntity.setProductCategory(product.getProductCategory());

        productEntityRepository.persist(productEntity);

        return Boolean.TRUE;
    }

    @Override
    @Transactional
    public Boolean updateProduct(UUID productId, AddProductRequest product) {
        Optional<ProductEntity> productEntityOptional = productEntityRepository
                .findByIdOptional(productId);

        if (productEntityOptional.isPresent()) {
            ProductEntity productEntity = productEntityOptional.get();

            productEntity.setProductName(product.getProductName());
            productEntity.setProductCategory(product.getProductCategory());

            productEntityRepository.update("productName = ?1, productCategory = ?2",
                    productEntity.getProductName(), productEntity.getProductCategory()
            );

            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    @Override
    public ProductEntity getProductByName(String productName) {
        return productEntityRepository
                .findByProductNameIgnoreCase(productName)
                .orElse(null);
    }

    @Override
    public List<ProductEntity> getAllProductByCategory(String productCategory) {
        return productEntityRepository.findProductByCategory(productCategory);
    }

    @Override
    @Transactional
    public Boolean deleteProduct(UUID productId) {
        Optional<ProductEntity> productEntityOptional = productEntityRepository.findByIdOptional(productId);

        if (productEntityOptional.isPresent()) {
            productEntityRepository.updateAvailable(productId);
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }
}
