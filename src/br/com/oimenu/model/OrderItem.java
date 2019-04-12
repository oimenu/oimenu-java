package br.com.oimenu.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderItem {
	@SerializedName("id")
    @Expose
    private String id = "";
	
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

    @SerializedName("options")
    @Expose
    private List<OrderItemOption> options = new ArrayList<OrderItemOption>();
    
    @SerializedName("notes")
    @Expose
    private List<String> notes = new ArrayList<String>();
    
    @SerializedName("extra_fields")
    @Expose
    private String extraFields = "";
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
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
    
    public List<OrderItemOption> getOptions() {
        return options;
    }
    public void setOptions(List<OrderItemOption> options) {
        this.options = options;
    }
    
    public List<String> getNotes() {
        return notes;
    }
    public void setNotes(List<String> notes) {
        this.notes = notes;
    }
    
    public String getExtraFields() {
        return extraFields;
    }
    public void setExtraFields(String extraFields) {
        this.extraFields = extraFields;
    }
}
