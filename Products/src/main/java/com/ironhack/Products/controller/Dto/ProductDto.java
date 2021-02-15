package com.ironhack.Products.controller.Dto;

import com.sun.istack.NotNull;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;

public class ProductDto {

    /** Properties **/

    @NotNull
    @NotEmpty
    private String productName;

    @NotNull
    @DecimalMin("0.00")
    private Double productPrice;

    @NotNull
    @DecimalMin("0")
    private Integer inventoryCount;

    /** Constructor **/
    public ProductDto() {
    }

    /** Getters & Setters **/


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(Integer inventoryCount) {
        this.inventoryCount = inventoryCount;
    }
}
