package org.ekosutrisno.model;

import javax.persistence.*;
import java.util.UUID;

/**
 * @author Eko Sutrisno
 * @create 13/11/2020 9:40
 */
@Entity
@Table(name = ProductEntity.TABLE_NAME)
@Cacheable
public class ProductEntity {
    static final String TABLE_NAME = "tbl_m_product";

    @Id
    @GeneratedValue
    @Column(name = "product_id", nullable = false)
    private UUID productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_category", nullable = false)
    private String productCategory;

    @Column(name = "available", nullable = false)
    private Boolean available = Boolean.TRUE;

    public ProductEntity(String productName, String productCategory, Boolean available) {
        this.productName = productName;
        this.productCategory = productCategory;
        this.available = available;
    }

    public ProductEntity() {
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
