package org.ekosutrisno.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.ekosutrisno.model.ProductEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Eko Sutrisno
 * @create 13/11/2020 10:06
 */
@ApplicationScoped
public class ProductEntityRepository implements PanacheRepository<ProductEntity> {

    public Optional<ProductEntity> findByIdOptional(UUID productId) {
        return find("productId", productId)
                .stream().findFirst();
    }

    public Optional<ProductEntity> findByProductNameIgnoreCase(String productName) {
        return find("productName", productName).stream().findAny();
    }

    public List<ProductEntity> findProductByCategory(String category) {
        return list("productCategory", category);
    }


    public void updateAvailable(UUID productId) {
        update("available = false where productId = ?1", productId);
    }
}
