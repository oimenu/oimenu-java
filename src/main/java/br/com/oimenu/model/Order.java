package br.com.oimenu.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Order {
	@SerializedName("id")
    @Expose
    private String id = "";
	
    @SerializedName("date")
    @Expose
    private String date = "";
    
    @SerializedName("table")
    @Expose
    private Integer table = null;

    @SerializedName("card")
    @Expose
    private String card = null;
    
    @SerializedName("waiter")
    @Expose
    private String waiter = null;
    
    @SerializedName("items")
    @Expose
    private List<OrderItem> items = new ArrayList<OrderItem>();
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public Integer getTable() {
        return table;
    }
    public void setTable(Integer table) {
        this.table = table;
    }
    
    public String getCard() {
        return card;
    }
    public void setCard(String card) {
        this.card = card;
    }
    
    public String getWaiter() {
        return waiter;
    }
    public void setWaiter(String waiter) {
        this.waiter = waiter;
    }
    
    public List<OrderItem> getItems() {
        return items;
    }
    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
