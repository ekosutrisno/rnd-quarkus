package org.ekosutrisno.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Eko Sutrisno
 * @create 13/11/2020 12:23
 */
public class AddProductRequest {
    @NotBlank
    @NotNull
    private String productName;
    @NotNull
    @NotBlank
    private String productCategory;

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
}
