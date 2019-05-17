package br.com.oimenu.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Card {
	@SerializedName("code")
    @Expose
    private Integer code = -1;
	
    @SerializedName("qr_code")
    @Expose
    private String qrCode = "";
    
    @SerializedName("service_percentage")
    @Expose
    private Double servicePercentage = 0.00;

    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }

    public String getQrCode() {
        return qrCode;
    }
    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public Double getServicePercentage() {
        return servicePercentage;
    }
    public void setServicePercentage(Double servicePercentage) {
        this.servicePercentage = servicePercentage;
    }
}
