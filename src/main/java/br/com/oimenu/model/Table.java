package br.com.oimenu.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Table {
	@SerializedName("code")
    @Expose
    private Integer code = -1;
	
    @SerializedName("name")
    @Expose
    private String name = "";
    
    @SerializedName("service_percentage")
    @Expose
    private Double servicePercentage = 0.00;

    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Double getServicePercentage() {
        return servicePercentage;
    }
    public void setServicePercentage(Double servicePercentage) {
        this.servicePercentage = servicePercentage;
    }
}
