package com.cg.ecommerce.itemmgt.dto;

public class AddCartItemDto {

    private String productId;

    public String getProductId(){
        return productId;
    }

    public void setProductId(String id){
        this.productId=id;
    }

    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


}
