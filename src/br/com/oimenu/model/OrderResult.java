package br.com.oimenu.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;



public class OrderResult {
	
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
    private List<Order> data = new ArrayList<Order>();
    
    @SerializedName("count")
    @Expose
    private Integer count = 0;

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
    
    public List<Order> getData() {
        return data;
    }
    public void setData(List<Order> data) {
        this.data = data;
    }
    
    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }
}
