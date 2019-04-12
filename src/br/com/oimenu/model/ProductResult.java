package br.com.oimenu.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductResult {
	
	@SerializedName("success")
    @Expose
    private Boolean success = false;
	
    @SerializedName("message")
    @Expose
    private String message = "";
    
    @SerializedName("status")
    @Expose
    private Integer responseCode = 200;
    
    @SerializedName("data")
    @Expose
    private Product data = new Product();

    public Boolean getSuccess() {
        return success;
    }
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getResponseCode() {
        return responseCode;
    }
    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }
    
    public Product getData() {
        return data;
    }
    public void setData(Product data) {
        this.data = data;
    }
}
