package com.ironhack.ShippingOrders.controller.Dto;
import com.sun.istack.NotNull;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;

public class ShippingOrderDto {

    /** Properties **/

    @NotNull
    private Integer productId;

    @DecimalMin("0")
    private Integer quantity;

    /** Constructor **/

    public ShippingOrderDto() {
    }

    /** Getters & Setters **/

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
