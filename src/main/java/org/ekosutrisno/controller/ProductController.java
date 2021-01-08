package org.ekosutrisno.controller;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.ekosutrisno.model.ProductEntity;
import org.ekosutrisno.model.dto.AddProductRequest;
import org.ekosutrisno.service.ProductEntityService;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

/**
 * @author Eko Sutrisno
 * @create 13/11/2020 10:29
 */
@Path("/api/v1/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Product Service V1", description = "Handle Product")
public class ProductController {

    @Inject
    ProductEntityService productEntityService;

    @GET
    public List<ProductEntity> getAllProduct() {
        return productEntityService.getAllProduct();
    }

    @GET
    @Path("/{productId}")
    public ProductEntity getSingleProduct(@PathParam("productId") UUID productId) {
        return productEntityService.getById(productId);
    }

    @GET
    @Path("/{productCategory}/product")
    public List<ProductEntity> getSingleProduct(@PathParam("productCategory") String productCategory) {
        return productEntityService.getAllProductByCategory(productCategory);
    }

    @GET
    @Path("/filter")
    public ProductEntity getSingleByProductName(@QueryParam("productName") String productName) {
        return productEntityService.getProductByName(productName);
    }

    @POST
    public Boolean insertProduct(@Valid @NotNull AddProductRequest product) {
        return productEntityService.insertProduct(product);
    }

    @PUT
    @Path("/{productId}")
    public Boolean updateProduct(@NotNull @PathParam("productId") UUID productId, @Valid AddProductRequest product) {
        return productEntityService.updateProduct(productId, product);
    }

    @DELETE
    @Path("/{productId}")
    public Boolean insertProduct(@PathParam("productId") UUID productId) {
        return productEntityService.deleteProduct(productId);
    }

}
