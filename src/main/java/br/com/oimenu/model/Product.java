package br.com.oimenu.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {
	@SerializedName("code")
    @Expose
    private String code = "";
	
    @SerializedName("name")
    @Expose
    private String name = "";
    
    @SerializedName("price")
    @Expose
    private Double price = 0.00;

    @SerializedName("extra_fields")
    @Expose
    private String extraFields = "";
    
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

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    
    public String getExtraFields() {
        return extraFields;
    }
    public void setExtraFields(String extraFields) {
        this.extraFields = extraFields;
    }
}
