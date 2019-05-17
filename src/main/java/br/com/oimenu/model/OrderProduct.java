package br.com.oimenu.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderProduct {

	@SerializedName("code")
    @Expose
    private String code = "";
	
    @SerializedName("name")
    @Expose
    private String name = "";
    
    @SerializedName("quantity")
    @Expose
    private Integer quantity = 0;
    
    @SerializedName("price")
    @Expose
    private Double price = 0.00;

   
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

}
