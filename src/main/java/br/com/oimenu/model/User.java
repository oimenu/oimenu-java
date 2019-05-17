package br.com.oimenu.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
	@SerializedName("code")
    @Expose
    private Integer code = -1;
	
    @SerializedName("name")
    @Expose
    private String name = "";
    
    @SerializedName("active")
    @Expose
    private Integer active = 0;

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

    public Integer getActive() {
        return active;
    }
    public void setActive(Integer active) {
        this.active = active;
    }
}
